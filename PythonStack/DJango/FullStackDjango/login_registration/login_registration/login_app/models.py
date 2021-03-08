from django.db import models
from datetime import date, datetime
import re
import bcrypt
class UserManager(models.Manager):
    def basic_validator_register(self, postData):
        errors = {}
        user = User.objects.filter(email = postData['email'])
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        today = datetime.now().strftime("%Y%m%d")
        user_birthday = postData['birthday'].replace("-", "")
        if len(postData['first_name']) < 2:
            errors["first_name"] = "first name should be at least 2 characters"
        if not postData['first_name'].isalpha():
            errors["first_name"] = "first name should be characters only"
        if len(postData['last_name']) < 2:
            errors["last_name"] = "last name should be at least 2 characters"
        if not postData['last_name'].isalpha():
            errors["last_name"] = "last name should be characters only"
        if not EMAIL_REGEX.match(postData['email']):
            errors['email'] = "Invalid email address!"
        if len(user):
            errors['email'] = "email already exist"
        if len(postData["birthday"]) > 0 and datetime.strptime(postData["birthday"], '%Y-%m-%d') >= datetime.today() :
            errors["birthday"] = "Invalid birthday"
        if (int(today[0:4]) - int(user_birthday[0:4])) <= 13:
            errors["birthday"] = "should be at least 13 years old"
        if len(postData['password']) < 8:
            errors["password"] = " password should be at least 8 characters"
        if postData['confirm'] != postData['password']:
            errors["confirm"] = "confirm password should match with password"
        return errors
    def basic_validator_login(self, postData):
        errors = {}
        user = User.objects.filter(email = postData['email'])
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):
            errors['email'] = "wrong email address!"
        if not len(user):
            errors['email'] = "Wrong email address Or not registered"
        if len(postData['password']) < 8:
            errors["password"] = "you should enter the password"
        if len(user) and not bcrypt.checkpw(postData['password'].encode(), user[0].password.encode()):
            errors["password"] = "Wrong Password!"
        return errors

class User(models.Model):
    first_name = models.CharField(max_length=45)
    last_name = models.CharField(max_length=45)
    email = models.CharField(max_length=45)
    password = models.CharField(max_length=255)
    birthday = models.DateField(null=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()

def register(reg_info):
    first_name = reg_info['first_name']
    last_name = reg_info['last_name']
    email = reg_info['email']
    birthday = reg_info['birthday']
    password = reg_info['password']
    confirm_password = reg_info['confirm']
    user = User.objects.filter(email = email)
    if len(user) == 0:
        if password == confirm_password :
            crypt_password = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
            User.objects.create(first_name=first_name,last_name=last_name,email=email,birthday=birthday,password=crypt_password)
            user_info = User.objects.last()
            return user_info
    return False


def login(log_info):
    user_in_data = User.objects.filter(email=log_info['email'])
    if len(user_in_data):
        if bcrypt.checkpw(log_info['password'].encode(), user_in_data[0].password.encode()):
            return user_in_data[0]
    return False

def reg_errors(check_info):
    errors = User.objects.basic_validator_register(check_info)
    return errors

def login_errors(check_info):
    errors = User.objects.basic_validator_login(check_info)
    return errors






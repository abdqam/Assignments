from django.shortcuts import render,redirect
from django.contrib import messages
from . import models



def root(request):
    if 'user_id' in request.session:
        return redirect('/books')
    return render(request,'login.html')

def welcome(request):
    if 'user_id' in request.session:
        context = {
            'first_name':request.session['first_name'],
            'last_name':request.session['last_name'],
            'books':models.all_books(),
            'favorites' : models.favorite(request.session['user_id'])
        }
        return render(request,'welcome.html',context)
    return redirect('/')

def registration(request):
    if request.method =='POST':
        errors = models.reg_errors(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect('/')
        else:
            user = models.register(request.POST)
            if user is not None:
                if 'user_id' not in request.session:
                    request.session['user_id'] = user.id
                    request.session['first_name'] = user.first_name
                    request.session['last_name'] = user.last_name
                return redirect('/books')
    return redirect('/')


def login(request):
    if request.method=='POST':
        errors = models.login_errors(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect('/')
        else:
            user = models.login(request.POST)
            if user is not None:
                if 'user_id' not in request.session:
                    request.session['user_id'] = user.id
                    request.session['first_name'] = user.first_name
                    request.session['last_name'] = user.last_name
                    return redirect('/books')
    return redirect('/')



def logout(request):
    if 'user_id' in request.session:
        del request.session['user_id']
        del request.session['first_name']
        del request.session['last_name']
    return redirect('/')

def addbook(request):
    if request.method =='POST':
        book = models.add_book(request.POST,request.session['user_id'])
        if book is not None:
            return redirect('/books')
    return redirect('/books')

def addtofav(request,id):
    models.add_fav(id,request.session['user_id'])
    return redirect('/books')

def view(request,id):
    context = {
        'book':models.get_book(id),
        'users':models.get_users(id),
        'signed_user':models.signed_user(request.session['user_id']),
    }
    return render(request,'edit.html',context)

def removefav(request,id):
    models.remove_fav(id,request.session['user_id'])
    return redirect('/books/' + str(id))

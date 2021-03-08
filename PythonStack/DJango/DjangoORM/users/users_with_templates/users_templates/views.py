from django.shortcuts import render,redirect
from .models import User
def root(request):
    context = {'all_the_users':User.objects.all()}
        
    return render(request,"users.html", context)
def add(request):
    if request.method=="POST":
        first=request.POST['first_name']
        last=request.POST['last_name']
        email=request.POST['email']
        age=request.POST['age']
    User.objects.create(first_name=first,last_name=last,email_address=email,age=int(age))
    User.objects.all()

    return redirect('/')
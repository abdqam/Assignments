from django.shortcuts import render,redirect
from django.contrib import messages
from . import models



def root(request):
    if 'user_id' in request.session:
        return redirect('/wall')
    return render(request,'login.html')

def wall(request):
    if 'user_id' in request.session:
        context = {
            'first_name':request.session['first_name'],
            'last_name':request.session['last_name'],
            'posts':models.all_posts(),
            'comments':models.all_comments(),
        }
        return render(request,'wall.html',context)
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
                return redirect('/wall')
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
                    return redirect('/wall')
    return redirect('/')



def logout(request):
    if 'user_id' in request.session:
        del request.session['user_id']
        del request.session['first_name']
        del request.session['last_name']
    return redirect('/')

def addpost(request):
    if request.method == 'POST':
        if 'user_id' in request.session:
            post = models.add_post(request.POST,request.session['user_id'])
            if post is not None:
                return redirect('/wall')
    return redirect('/wall')

def addcomment(request):
    if request.method == 'POST':
        if 'user_id' in request.session:
            comment = models.addcomment(request.POST,request.session['user_id'])
            if comment is not None:
                return redirect('/wall')
    return redirect('/wall')
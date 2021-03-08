from django.shortcuts import render,redirect
from django.contrib import messages
from . import models

def root(request):
    return redirect('/shows')

def shows(request):
    context = models.display_shows()
    return render(request,'shows.html',context)

def add_new(request):
    return render(request,'add_new.html')

def show_added(request):
    if request.method=='POST':
        errors = models.errors(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect('/shows/new')
        else:
            id = models.add_new(request.POST)
        return redirect('/shows/' + str(id))
    return redirect('/shows')

def show_tv(request,id):
    context = models.show_by_id(id)
    return render(request,'show_info.html',context)

def edit_by_id(request,id):
    context = models.show_by_id(id)
    return render(request,'edit.html',context)

def edit_show(request,id):
    if request.method=='POST':
        errors = models.errors(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect('/shows/' + str(id) + '/edit')
        else:
            Id = models.edit_show(request.POST,id)
        return redirect('/shows/' + str(Id))
    return redirect('/shows')

def destroy(request,id):
    models.delete(id)
    return redirect('/shows')

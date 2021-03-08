from django.shortcuts import render,redirect
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
        id = models.add_new(request.POST)
    return redirect('/shows/' + str(id))

def show_tv(request,id):
    context = models.show_by_id(id)
    return render(request,'show_info.html',context)

def edit_by_id(request,id):
    context = models.show_by_id(id)
    return render(request,'edit.html',context)

def edit_show(request,id):
    if request.method=='POST':
        Id = models.edit_show(request.POST,id)
    return redirect('/shows/' + str(Id))

def destroy(request,id):
    models.delete(id)
    return redirect('/shows')

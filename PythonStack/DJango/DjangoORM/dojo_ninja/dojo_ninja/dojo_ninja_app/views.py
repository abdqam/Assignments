from django.shortcuts import render,redirect
from .models import Dojo,Ninja
def root(request):
    context = {
        'dojos':Dojo.objects.all(),
    }
    return render(request,'ninja.html',context)

def adddojo(request):
    if request.method=='POST':
            name=request.POST['dojo_name']
            city=request.POST['dojo_city']
            state=request.POST['dojo_state']
            Dojo.objects.create(name=name,city=city,state=state)
    return redirect('/')
def addninja(request):
    if request.method=='POST':
        first=request.POST['first_name']
        last=request.POST['first_name']
        dojo_id=request.POST['dojos']
        Ninja.objects.create(first_name=first,last_name=last,dojo=Dojo.objects.get(id=dojo_id))
    return redirect('/')
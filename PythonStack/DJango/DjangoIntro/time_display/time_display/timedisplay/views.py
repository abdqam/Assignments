from django.shortcuts import render,redirect
from time import gmtime, strftime
    
def root(request):
    context = {
        "current_date": strftime("%a-%b %d, %Y", gmtime()),
        "current_time": strftime("%H:%M %p",gmtime())

    }
    return render(request,'time_display.html', context)
def time_display(request):
    return redirect('/')
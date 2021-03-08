from django.shortcuts import render,redirect
def count(request):
    if 'counter' in request.session:
        request.session['counter'] +=1
    else:
        request.session['counter']=0
        request.session['usercounter']=0
    return render(request,'counter.html')
def destroy(request):
    del request.session['counter']
    del request.session['usercounter']
    return redirect('/')
def increment(request):
    if 'usercounter' in request.session:
        request.session['usercounter']+=2
    else:
        request.session['usercounter']=0
    return redirect('/')
def incrementByUser(request):
    if request.method == "POST":
        inserted_value = request.POST["count"]
    if 'usercounter' in request.session:
        request.session['usercounter']+=int(inserted_value)
    return redirect('/')
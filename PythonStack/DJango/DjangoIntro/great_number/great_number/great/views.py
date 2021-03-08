from django.shortcuts import render,redirect
import random 	                # import the random module 
def root(request):
    request.session['cumputer_number'] = random.randint(1, 100)
    request.session['guessed']=0
    return render(request,'great.html')
def check(request):
    if request.method=='POST':
        request.session['guess_number']=request.POST['value']
    if request.session['guessed'] < 5:
        if (int(request.session['guess_number']) > request.session['cumputer_number']):
            request.session['result']='high'
            request.session['guessed']+=1
        elif (int(request.session['guess_number']) < request.session['cumputer_number']):
            request.session['result']='low'
            request.session['guessed']+=1
        elif (int(request.session['guess_number']) == request.session['cumputer_number']):
            request.session['result']='correct'
    elif request.session['guessed'] >= 5: 
        request.session['result']="You Lose"
    context = {
        'request.session.result':request.session['result'],
        'request.session.guessed':request.session['guessed']
    }
    return render(request,'great.html',context)
def back(request):
    del request.session['cumputer_number']
    del request.session['result']
    del request.session['guessed']
    return redirect('/')
def lose(request):
    del request.session['cumputer_number']
    del request.session['result']
    del request.session['guessed']
    return redirect('/')
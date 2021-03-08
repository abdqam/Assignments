from django.shortcuts import render,redirect
from time import gmtime, strftime
import random
def root(request):
    if 'gold' not in request.session:
        request.session['gold']=0
    if 'result' not in request.session:
        request.session['result']=""
    if 'lost' not in request.session:
        request.session['lost']=""
    return render(request,'ninja.html')
def process(request):
    if request.method=='POST':
        if request.POST['which_form'] == 'farm':
            request.session['farm_gold']=random.randint(10,20)
            request.session['result']+=f"Earned {request.session['farm_gold']} golds from the farm!(" + strftime("%Y-%m-%d %H:%M %p", gmtime())+ ")\n"
            request.session['gold']+=request.session['farm_gold']
        elif request.POST['which_form'] == 'cave':
            request.session['cave_gold']=random.randint(5,10) 
            request.session['gold']+=request.session['cave_gold']
            request.session['result']+=f"Earned {request.session['cave_gold']} golds from the cave!(" + strftime("%Y-%m-%d %H:%M %p", gmtime())+ ")\n"
        elif request.POST['which_form'] == 'house':
            request.session['house_gold']=random.randint(2,5)
            request.session['gold']+=request.session['house_gold']
            request.session['result']+=f"Earned {request.session['house_gold']} golds from the house!(" + strftime("%Y-%m-%d %H:%M %p", gmtime())+ ")\n"
        elif request.POST['which_form'] == 'casino':
            request.session['casino_gold']=random.randint(-50,50)
            request.session['gold']+=request.session['casino_gold']
            if request.session['casino_gold'] >0:
                request.session['result']+=f"Earned {request.session['casino_gold']} golds from the casino!(" + strftime("%Y-%m-%d %H:%M %p", gmtime())+ ")\n"
            else:
                request.session['result']+=f"Lost {-1*request.session['casino_gold']} golds from the casino!.. Ouch..(" + strftime("%Y-%m-%d %H:%M %p", gmtime())+ ")\n"
    return redirect('/')
def destroy(request):
    del request.session['result']
    del request.session['lost']
    del request.session['gold']
    return redirect('/')

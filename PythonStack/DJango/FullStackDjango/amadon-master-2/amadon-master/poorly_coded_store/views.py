from django.shortcuts import render,redirect
from . import models
def index(request):
    context = models.all_products()
    return render(request, "store/index.html", context)

def checkout(request):
    orders=models.all_order()
    total_charge=0
    order_quantity=0
    for order in orders:
        total_charge+=order.total_price
        order_quantity+=order.quantity_ordered
    context={
        'total_charge':total_charge,
        'price':request.session['price'],
        'order_quantity':order_quantity,
    }
    return render(request, "store/checkout.html",context)


def buy(request):
    if request.method=='POST':
        context=models.orders(request.POST)
        if 'price' not in request.session:
            request.session['price']=context['price'] * context['order'].quantity_ordered
    return redirect('/checkout')

def back(request):
    if 'price' in request.session:
        del request.session['price']
    return redirect('/')
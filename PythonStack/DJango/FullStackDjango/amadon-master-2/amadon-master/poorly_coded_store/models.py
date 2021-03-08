from django.db import models

class Product(models.Model):
    description = models.CharField(max_length=45)
    price = models.DecimalField(decimal_places=2, max_digits=5)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Order(models.Model):
    quantity_ordered = models.IntegerField()
    total_price = models.DecimalField(decimal_places=2, max_digits=6)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


def orders(order_info):
    quantity_from_form = int(order_info["quantity"])
    price_from_form = float(Product.objects.get(id=int(order_info["price"])).price)
    total_charge = quantity_from_form * price_from_form
    Order.objects.create(quantity_ordered=quantity_from_form, total_price=total_charge)
    order=Order.objects.last()
    context = {
        'order':order,
        'price':price_from_form,
    }
    return context

def all_products():
    context={
        'all_products':Product.objects.all()
        }
    return context


def all_order():
    context=Order.objects.all()
    return context
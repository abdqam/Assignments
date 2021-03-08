from django.urls import path
from . import views

urlpatterns = [
    path('',views.root),
    path('books',views.welcome),
    path('register',views.registration),
    path('login',views.login),
    path('logout',views.logout),
    path('addbook',views.addbook),
    path('addtofav/<int:id>',views.addtofav),
    path('removefav/<int:id>',views.removefav),
    path('books/<int:id>',views.view),
]

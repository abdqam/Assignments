from django.urls import path
from . import views

urlpatterns = [
    path('',views.root),
    path('wall',views.wall),
    path('register',views.registration),
    path('login',views.login),
    path('logout',views.logout),
    path('addpost',views.addpost),
    path('addcomment',views.addcomment),
]

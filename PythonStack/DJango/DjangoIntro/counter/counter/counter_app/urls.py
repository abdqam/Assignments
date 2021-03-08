from django.urls import path
from . import views

urlpatterns = [
    path('', views.count),
    path('destroy_session',views.destroy),
    path('plus_tow',views.increment),
    path('plus_user_define',views.incrementByUser),
]
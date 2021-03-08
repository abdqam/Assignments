from django.urls import path
from . import views

urlpatterns = [
    path('', views.show),
    path('add',views.add),
    path('insert',views.insert),
    path('authers',views.authers),
    path('books/<int:id>',views.disc),
    path('authers/<int:id>',views.go),
    path('add_auther/<int:id>',views.add_auther),
    path('add_books/<int:id>',views.add_book),
#     # path('delete/<int:i>',views.delete),
]
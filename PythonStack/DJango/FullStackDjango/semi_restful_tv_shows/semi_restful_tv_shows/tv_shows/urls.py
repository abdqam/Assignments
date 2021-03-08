from django.urls import path
from . import views

urlpatterns = [
    path('',views.root),
    path('shows',views.shows),
    path('shows/new',views.add_new),
    path('shows/create',views.show_added),
    path('shows/<int:id>',views.show_tv),
    path('shows/<int:id>/edit',views.edit_by_id),
    path('shows/<int:id>/update',views.edit_show),
    path('shows/<int:id>/destroy',views.destroy)
]
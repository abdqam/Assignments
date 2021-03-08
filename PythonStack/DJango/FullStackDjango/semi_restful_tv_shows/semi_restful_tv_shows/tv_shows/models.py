from django.db import models

class Tv(models.Model):
    title = models.CharField(max_length=255)
    network = models.CharField(max_length=255)
    desc = models.TextField(default="some description")
    release_date = models.DateField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

def display_shows():
    context={
        'tv':Tv.objects.all()
    }
    return context

def add_new(info_to_add):
    Tv.objects.create(title=info_to_add['title'],network=info_to_add['network'],release_date=info_to_add['release_date'],desc=info_to_add['description'])
    id = Tv.objects.last().id
    return id
def show_by_id(id):
    context={
        'show':Tv.objects.get(id=id)
    }
    return context
def edit_show(info_to_edit,id):
    edit = Tv.objects.get(id=id)
    edit.title = info_to_edit['title']
    edit.network = info_to_edit['network']
    edit.release_date = info_to_edit['release_date']
    edit.desc = info_to_edit['description']
    edit.save()
    return edit.id

def delete(id):
    delete_value=Tv.objects.get(id=id)
    delete_value.delete()

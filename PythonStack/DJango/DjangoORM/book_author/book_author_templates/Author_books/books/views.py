from django.shortcuts import render,redirect
from .models import Book,Auther

def show(request):
    context={
        'all_books':Book.objects.all(),
    }
    return render(request,'index.html',context)

# Create your views here.

def add(request):
    if request.method=='POST':
        title = request.POST['title']
        desc = request.POST['desc']
        Book.objects.create(title=title,desc=desc)

        context={
            'all_books':Book.objects.all()
        }

    return render(request,'index.html',context)

def authers(request):
    if request.method=='POST':
        first = request.POST['first']
        last = request.POST['last']
        notes = request.POST['note']
        Auther.objects.create(first_name=first,last_name=last,notes=notes)

        context={
            'all_authers':Auther.objects.all()
        }


    return render(request,'auther.html',context)


def insert(request):
    context={
        'all_authers':Auther.objects.all()
    }
    return render(request,'auther.html',context)



def disc(request,id):
    book=Book.objects.get(id=id)
    auther=book.authers.all()
    context={
        "books": book ,
        "authers":auther,
        'all_authers':Auther.objects.all()
        }
    return render(request ,"books.html",context)

def go(request,id):
    auther=Auther.objects.get(id=id)
    book=auther.books.all()
    context={
        "authers": auther ,
        "books":book,
        'all_books':Book.objects.all()
        }
    return render(request ,"authers.html",context)

def add_auther(request,id):
    if request.method=='POST':
        auther=Auther.objects.get(id=id)
        book=Book.objects.get(id=request.POST['autherbook'])
        auther.books.add(book)

    return redirect('/authers/' + str(id))
    
def add_book(request,id):
    if request.method=='POST':
        book=Book.objects.get(id=id)
        auther=Auther.objects.get(id=request.POST['autherbook'])
        book.authers.add(auther)

    return redirect('/books/' + str(id))



# def delete(request,i):
#     c=dojo.objects.get(id=i)
#     c.delete()

#     return redirect("/")
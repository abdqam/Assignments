from django.shortcuts import render

def survey(request):
    return render(request,'survey.html')
def result(request):
    if request.method=='POST':
        name=request.POST['name']
        location=request.POST['location']
        language=request.POST['language']
        comment=request.POST['comment']
    context={
        'name':name,
        'location':location,
        'language':language,
        'comment':comment,
    }
    return render(request,'result.html',context)
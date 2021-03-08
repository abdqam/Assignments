## CountDown
def countdown(num):
    newL=[]
    for i in range(num,-1,-1):
        newL.append(i)
    return newL
print(countdown(10))

## Print and Return
def PandR(List):
    print(List[0])
    return List[1]

print(PandR([2,4]))

## First Plus Length
def firstPlusLength(List):
    return List[0]+len(List)

print(firstPlusLength([3,3,5,4,8]))

## Values Greater than Second
def Gsecond(list):
    newL=[]
    for x in range(len(list)):
        if list[1]<list[x]:
            newL.append(list[x])
    return newL

print(Gsecond([5,3,7,9,11]))

##This Length, That Value 
def length_and_value(l,v):
    list=[]
    for x in range(l):
        list.append(v)
    return list

print(length_and_value(4,8))
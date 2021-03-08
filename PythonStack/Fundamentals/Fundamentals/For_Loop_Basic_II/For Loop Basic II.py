## Biggie Size
def Bsize(list):
    for x in range(len(list)):
        if list[x]>0:
            list[x]="big"
    return list

print(Bsize([2,4,5,3,-1,-5,-7]))

## Count Positives
def CP(list):
    count=0
    for x in range(len(list)):
        if list[x]>0:
            count+=1
    list[len(list)-1]=count
    return list

print(CP([5,2,0,4,-4,-5]))

## Sum Total
def Sum(list):
    sum=0
    for x in range(len(list)):
        sum+=list[x]
    return sum

print(Sum([5,2,3,4,6,8]))

## Average 

def avg(list):
    sum=0
    for x in range(len(list)):
        sum+=list[x]
    return sum/len(list)
print(avg([5,2,3,4,6,8]))

## Length 
def length(list):
    count=0
    for x in list:
        count+=1
    return count

print(length([5,2,3,4,6,8]))

## Minimum 

def Minimum(list):
    if len(list)==0:
        return False
    else:
        min=list[0]
        for z in range(len(list)):
            if list[z]<min:
                min=list[z]
        return min

print(Minimum([5,2,3,4,6,8]))

## Maximum 
def Maximum(list):
    if len(list)==0:
        return False
    else:
        max=list[0]
        for z in range(len(list)):
            if list[z]>max:
                max=list[z]
        return max

print(Maximum([5,2,3,4,6,8]))

## Ultimate Analysis
def Ult(list):

    return {'sumTotal': Sum(list) ,'average': avg(list),'minimum': Minimum(list),'maximum': Maximum(list),'length': length(list)}

print(Ult([5,2,3,4,6,8]))

## Reverse List
def rev(list):
    return list[::-1]

print(rev([5,2,3,4,6,8]))
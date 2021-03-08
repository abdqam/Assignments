# 1
for x in range(151):
    print(x)

# 2
for i in range(1001):
    if i%5==0:
        print(i)

# 3
for i in range(100):
    if i%5==0 and i%10!=0:
        print("Coding")
    elif i%10 ==0:
        print("Coding Dojo")
    else:
        print(i)

# 4
sum=0
for i in range(500000):
    if i%2!=0:
        sum+=i
print(sum)

# 5

for x in range(2018,0,-4):
    print(x)

# 6

lowNum=0
highNum=10
mult=2
for x in range(lowNum,highNum):
    if x/mult==1:
        print(x)
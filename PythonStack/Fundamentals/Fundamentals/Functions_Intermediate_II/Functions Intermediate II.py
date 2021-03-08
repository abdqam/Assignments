###############################################################
###############################################################
# 1
x = [[5, 2, 3], [10, 8, 9]]
students = [
    {'first_name':  'Michael', 'last_name': 'Jordan'},
    {'first_name': 'John', 'last_name': 'Rosales'}
]
sports_directory = {
    'basketball': ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer': ['Messi', 'Ronaldo', 'Rooney']
}
z = [{'x': 10, 'y': 20}]

x[1][0] = 15
print(x)
students[0]['last_name'] = 'Bryant'
print(students)
sports_directory['soccer'][0] = 'Andres'
print(sports_directory)
z[0]['y'] = 30
print(z)
print('='*30)
###############################################################
###############################################################
# 2
students = [
    {'first_name':  'Michael', 'last_name': 'Jordan'},
    {'first_name': 'John', 'last_name': 'Rosales'},
    {'first_name': 'Mark', 'last_name': 'Guillen'},
    {'first_name': 'KB', 'last_name': 'Tonel'}
]


def iterateDictionary(dict):

    for key in dict:
        for val, i in key.items():
            print(val, '-', i, end=',')
        print()


iterateDictionary(students)
print('='*30)
###############################################################
###############################################################
# 3


def iterateDictionary2(key_name, dict):
    for key in dict:
        print(key[key_name])


print(iterateDictionary2('first_name', students))


def iterateDictionary3(last_name, dict):
    for key in dict:
        print(key[last_name])


print(iterateDictionary3('last_name', students))
print('='*30)

###############################################################
###############################################################
# 4
dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}
def printInfo(dict):
    for key,val in dict.items():
        print()
        print(len(dict[key]),key)
        for i in val:
            print(i)
printInfo(dojo)
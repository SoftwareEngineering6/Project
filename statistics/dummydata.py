from random import *

data = []
choices = ['right', 'wrong', 'skipped']
completed = []

for i in range(0, randint(10, 20)):
    person = []
    for j in range(0, randint(7, 10)):
        item = []
        item.append(choices[randint(0, 2)])
        item.append(uniform(0, 10))
        person.append(item)
    data.append(person)

for i in range(0, randint(1, 10)):
    person = []
    for j in range(0, randint(1, 10)):
        item = []
        item.append(choices[randint(0, 2)])
        item.append(uniform(0, 10))
        person.append(item)
    data.append(person)

for k in range(0, len(data)):
    completed.append(len(data[k]))

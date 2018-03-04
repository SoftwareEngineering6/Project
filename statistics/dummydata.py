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

results = []
for i in range(0, len(data)):
    qresults = []
    for j in range(0, completed[i]):
        qresults.append(data[i][j][0])
    results.append(qresults)

right = [0]*10
wrong = [0]*10
skipped = [0]*10
for i in range(0, len(results)):
    for j in range(0, len(results[i])):
        if results[i][j] == 'right':
            right[j] += 1
        elif results[i][j] == 'wrong':
            wrong[j] += 1
        else:
            skipped[j] += 1

totals = [(right[i] + wrong[i] + skipped[i]) for i in range(0, 10)]

time = []
for i in range(0, len(data)):
    qtime = []
    for j in range(0, completed[i]):
        qtime.append(data[i][j][1])
    time.append(qtime)

times_q = []
time.sort(key=len, reverse=True)
for i in range(0, 10):
    ztime = []
    for j in range(0, totals[i]):
        ztime.append(time[j][i])
    times_q.append(ztime)

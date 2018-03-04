import dummydata
import matplotlib.pyplot as plt
import numpy as np

N = 10
ind = np.arange(N)
width = 0.65

p1 = plt.bar(ind, dummydata.right, width, color='green')
p2 = plt.bar(ind, dummydata.wrong, width, bottom=dummydata.right, color='red')
p3 = plt.bar(ind, dummydata.skipped, width, bottom=np.array(dummydata.right)+np.array(dummydata.wrong), color='grey')

plt.ylabel('Results')
plt.xlabel('Question')
plt.xticks(ind)
plt.yticks(np.arange(len(dummydata.completed)))
plt.legend((p1[0], p2[0], p3[0]),('Right', 'Wrong', 'Skipped'))
plt.show()

import dummydata
import matplotlib.pyplot as plt
import numpy as np

#Question results
ind = np.arange(1,11)
width = 0.65

plt.figure(1)
#plt.subplot(131)
p1 = plt.bar(ind, dummydata.right, width, color='green')
p2 = plt.bar(ind, dummydata.wrong, width, bottom=dummydata.right, color='red')
p3 = plt.bar(ind, dummydata.skipped, width, bottom=np.array(dummydata.right)+np.array(dummydata.wrong), color='grey')
plt.title('Results of each Question')
plt.ylabel('Results')
plt.xlabel('Question')
plt.xticks(ind)
plt.yticks(np.arange(len(dummydata.completed)+1))
plt.legend((p1[0], p2[0], p3[0]),('Right', 'Wrong', 'Skipped'))

#Time Taken
#plt.subplot(132)
plt.figure(2)
plt.boxplot(dummydata.times_q)
plt.title('Time Taken on Each Question')
plt.ylabel('Time Taken (s)')
plt.xlabel('Question')

#Questions completed
#plt.subplot(133)
plt.figure(3)
plt.boxplot([dummydata.completed])
plt.xlabel('')
plt.ylabel('Questions Completed')
plt.title('Number of Questions Completed')

plt.show()

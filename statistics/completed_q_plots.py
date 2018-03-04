import dummydata
import matplotlib.pyplot as plt

fig = plt.figure()
ax = fig.add_axes([0.1, 0.1, 0.8, 0.8])
ax.boxplot([dummydata.completed])
ax.set_xlabel('')
ax.set_ylabel('Questions Completed')
ax.set_title('Number of Questions Completed')
ax.set_xticks([1])
ax.set_xticklabels([''])
plt.show()

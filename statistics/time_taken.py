import dummydata
import matplotlib.pyplot as plt

fig = plt.figure()
plt.boxplot(dummydata.times_q)
plt.title('Time Taken on Each Question')
plt.ylabel('Time Taken (s)')
plt.xlabel('Question')
plt.show()

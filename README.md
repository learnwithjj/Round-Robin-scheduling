# Round-Robin-scheduling
ROUND ROBIN SCHEDULING ALGORITHM is a scheduling process where each task gets exceuted in a cyclic queue for a particular time slice.
We consider another array to keep track of burst time.
time quantum=3
| p1  | p2  | p3  | p4  | p1  | p2  | p3  | p1  | 
0  -  3  -  6  -  9  -  12  - 15 - 16  - 18  -  22

turn around time=completion time-arrival time
waiting time=turn around time-burst time

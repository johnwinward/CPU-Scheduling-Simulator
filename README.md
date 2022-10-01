# CPU-Scheduling-Simulator
CPSC 340 Semester Project

To use, download the .jar file from releases and execute with Java 17 or greater. The CLI based application will prompt the number of trials to run. Each trial is randomly generated and run through each algorithm to determine algorithm efficiency. After execution, each algorithm's measurements will be saved to a separate .csv file in the directory containing the .jar file, which can be opened with spreadsheet software like Microsoft Excel. Each trial will be separated by a blank row in the spreadsheet.

FCFS - First Come First Serve,
RR - Round Robin,
SJF - Shortest Job First,
SRTN - Shortest Remaining Time Next

Spreadsheet Columns:
PID - Process ID,
AT - Arrival Time,
BT - Burst Time,
CT - Completion Time,
TAT - Turn-Around Time,
WT - Wait Time,
RT - Response Time

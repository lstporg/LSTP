# get input
_in = input("input csv: ")

# read lines
inputfile = open(_in, 'r')
lines = inputfile.readlines()

# strips newline
a = 0
while (a < len(lines)):
    lines[a] = lines[a].strip()
    a+=1

# store output vals
outputs = []
i = 0
while (i < len(lines)):
    line = lines[i]
    arr = line.split(',')
    val = arr[len(arr) - 1]
    outputs.append(val)
    i+=1

# write inputs without outputs to old csv
open(_in, 'w').close()
f = open(_in, 'a')
j = 0
while (j < len(lines)):
    current = lines[j]
    arr = current.split(',')
    newline = ""
    k = 0
    while (k < len(arr) - 1):
        newline = newline + arr[k]
        if (k < len(arr) - 2):
            newline = newline + ","
        k+=1
    f.write(newline + "\n")
    j+=1

# export output csv
o = open("out.csv", "w+")
l = 0
while (l < len(outputs)):
    o.write(outputs[l] + "\n")
    l+=1
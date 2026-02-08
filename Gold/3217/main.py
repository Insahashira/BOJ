class block:
    def __init__(self, name, start, size, isFree):
        self.name = name
        self.start = start
        self.size = size
        self.isFree = isFree

    def free(self):
        return

case = int(input())

arr = []
arr.append(block("foo", 1, 100000, True))

def free(target):
    for i in range (len(arr)): 
        if arr[i].name == target and not arr[i].isFree:
            continue
    return

for i in range(case):
    cmd = input()
    
    start = cmd.find('(')
    end = cmd.find(')')

    target = cmd[start + 1:end]

    parse = cmd.split("=")
    if(len(parse) == 1):
        if "free" in parse[0]:
            free(target)
        elif "malloc" in parse[0]:
            continue
import sys
from bisect import bisect_left

input = sys.stdin.readline

count = int(input())

arr = list(map(int, input().split()))
ans = []

lobal_max = 0

for i in range (count):
    if len(ans) == 0: 
        ans.append(arr[i])
        continue;

    idx = bisect_left(ans, arr[i])
    if idx == len(ans):
        ans.append(arr[i])

    else:
        ans[idx] = arr[i]

result = 0

# print(ans)
print(len(ans))
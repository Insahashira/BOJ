import sys
count = int(sys.stdin.readline())
correct = 0


for _ in range (count):
    input = sys.stdin.readline().strip()
    word_set = set()
    prev = ""
    for i in range(len(input)):
        if input[i] in word_set and prev != input[i] and i != 0:
            correct -= 1
            break
        prev = input[i]
        word_set.add(input[i])
    correct += 1

print(correct)

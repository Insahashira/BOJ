count = int(input());

scores = [];
dp = [[0 for _ in range (2)] for _ in range (count)]

for _ in range (count):
    scores.append(int(input()))

dp[0][0] = scores[0]
if(count > 1):
    dp[1][0] = scores[1]
    dp[1][1] = scores[0] + scores[1]

    for i in range (2, count):
        dp[i][0] = max(dp[i - 2][0], dp[i - 2][1]) + scores[i]

        dp[i][1] = dp[i -1][0] + scores[i]

print(max(dp[count - 1][0], dp[count -1][1]))
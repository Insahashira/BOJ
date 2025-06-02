//LCS
#include <stdio.h>

static char str1[1001], str2[1001];
static int largest = 0, dp[1001][1001], largestLength = 0;

int max(int a, int b) {return a > b ? a : b;}
int min(int a, int b) {return a < b ? a : b;}

int main() {
    scanf("%s", str1);
    scanf("%s", str2);

    for (int i = 0; str1[i]; i++) for (int ii = 0; str2[ii]; ii++) {
        if (str1[i] == str2[ii]) dp[i + 1][ii + 1] = dp[i][ii] + 1;
        else dp[i + 1][ii + 1] = max(dp[i + 1][ii], dp[i][ii + 1]);
        largest = max(largest, dp[i + 1][ii + 1]);
    }
    printf("%d\n", largest);
}
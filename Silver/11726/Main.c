#include <stdio.h>

int count[10001] = {0};

int recur(int num) {
    if (num > 1){
        if (count[num] == 0) return count[num] = recur(num - 1) % 10007 + recur(num - 2) % 10007;
        return count[num];
    }
    return count[num] = 1;
}

int main() {
    int input;
    scanf("%d", &input);

    printf("%d\n", recur(input) % 10007);
}
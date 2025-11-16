#include <stdio.h>
#include <stdlib.h>

// int *dp;
int zeros, ones, num;

int fib(int n);

int main() {
    int count;
    scanf("%d", &count);
    for (int i = 0; i < count; i++) {
        zeros = 0;
        ones = 0;
        scanf("%d", &num);
        // dp = malloc(sizeof(int) * num);
        if (num == 0) {
            
        }
        fib(num);
        printf("%d %d\n", zeros, ones);
        // free(dp);
    }
}

int fib(int n) {
    if (n == 0) {
        zeros++;
        return 0;
    }
    if (n == 1) {
        ones++;
        return 1;
    }
    return fib(n-1), fib(n-2);
}
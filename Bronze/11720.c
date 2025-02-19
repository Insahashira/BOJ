#include <stdio.h>
#include <math.h>

int main() {
    int count;
    long sum = 0;
    scanf("%d", &count);
    char str[count];
    scanf("%s", str);
    for (int i = 0; i < count; i++) sum += str[i] - '0';


    printf("%ld\n", sum);
}
#include <stdio.h>

int main() {
    int a, b, c, bDigit = 10;
    scanf("%d", &a);
    scanf("%d", &b);
    scanf("%d", &c);

    while (b >= bDigit) bDigit = bDigit*10;

    printf("%d\n", a + b - c);
    printf("%d\n", a*bDigit + b - c);
}
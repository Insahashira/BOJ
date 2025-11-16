#include <stdio.h>
int table[50001] = {0};

int main() {
    int input, e = 1, count = 0;
    scanf("%d", &input);

    while(input != 0){

        while(input >= e*e) e++;

        if(!table[--e]++) count++;

        input -= e*e;
        e = 1;
    }

    printf("%d\n", count);
}
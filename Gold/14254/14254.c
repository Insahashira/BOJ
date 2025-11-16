#include <stdio.h>
#include <string.h>

int main() {
    char input[51];
    int count;

    scanf("%s", input);
    scanf("%d", &count);

    char *hd[count + 1], *tl[count + 1];
    hd[count] = tl[count] = '\0';

    for (int i = 0; i < count; i++) {
        hd[i] = &input[i];
        tl[i] = &input[strlen(input) - count + i];
    }

    int c = 0;
    if (strcmp(hd, tl) != 0){
        for (int i = 0; i < count; i++) {
            if (hd[i] != tl[i]) c++;
        }
    }
    printf("%d\n", c);
}
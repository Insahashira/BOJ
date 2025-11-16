#include <stdio.h>
//16402 제국

static char par[26] = {0};

char find(char in) {
    if (par[in - 'A'] == 0) return in;
    return par[in - 'A'] = find(par[in - 'A']);
}

int main(){
    int king_count, operations, kingdoms[26] = {0}, count = 0;

    scanf("%d %d", &king_count, &operations);

    for(int i = 0; i < king_count; i++){
        char input;
        scanf(" Kingdom of %c", &input);
        kingdoms[input - 'A'] = 1;
        count++;
    }

    for(int i = 0; i < operations; i++){
        char a, b, c;
        scanf(" Kingdom of %c,Kingdom of %c,%c", &a, &b, &c);

        char win = c == '1' ? a : b;
        char lose = c == '1' ? b : a;

        char win_parent = win;
        char lose_parent = lose;

        win_parent = find(win_parent);
        lose_parent = find(lose_parent);

        if(win_parent == lose_parent){
            par[win - 'A'] = 0;
            win_parent = win;
        }
        par[lose_parent - 'A'] = win_parent;
        if (kingdoms[win_parent - 'A'] == 0) count++;
        kingdoms[win_parent - 'A'] = 1;
        kingdoms[lose_parent - 'A'] = 0;
        count--;
    }
    printf("%d\n", count);
    for(int i = 0; i < 26; i++) if (kingdoms[i]  ==  1) printf("Kingdom of %c\n", (i + 'A'));
}

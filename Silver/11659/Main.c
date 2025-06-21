//11659 -> 세그먼트 트리 사용
#include <stdio.h>
#include <stdlib.h>

int *st, e = 1;

int treeBuilder(int idx){
    if(idx < e) return st[idx] = treeBuilder(idx * 2) + treeBuilder(idx * 2 + 1);
    return st[idx];
}

int main(){
    int count, sum;

    scanf("%d %d", &count, &sum);

    while (e < count) e *= 2;

    st = (int*) calloc(2 * e, 4);

    for (int i = 0; i < count; i++) scanf("%d", &st[e + i]);

    treeBuilder(1);

    for(int i = 0; i < sum; i++){
        int from, to, result = 0;

        scanf("%d %d", &from, &to);

        from += e - 1;
        to += e - 1;

        while (from <= to) {
            if (from == to) {
                result += st[from];
                break;
            }

            if (from % 2 != 0) {
                result += st[from];
                from += 1;
            }

            if (to % 2 != 1) {
                result += st[to];
                to -= 1;
            }

            from /= 2;
            to /= 2;
        }
        printf("%d\n", result);
    }

    free(st);
    return 0;
}
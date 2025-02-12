#include <stdio.h>

int main() {
    int count, steps;

    scanf("%d %d", &count, &steps);

    int init[count];
    int stations[1000001][2];

    for (int i = 0; i < count; i++) {
        scanf("%d", &init[i]);
    }

    for (int i = 0; i < count; i++) {
        int prev = init[(i - 1 + count) % count];
        int next = init[(i+1) % count];
        stations[init[i]][0] = prev;
        stations[init[i]][1] = next;
    }
    for (int i = 0; i < steps; i++) {
        char type[2];
        scanf(" %c%c", &type[0], &type[1]);

        int temp, prev, next;
        if (type[0] == 'B' && type[1] == 'N') {
            scanf("%d %d", &prev, &temp);
            next = stations[prev][1];
            stations[prev][1] = temp;
            stations[next][0] = temp;
            stations[temp][0] = prev;
            stations[temp][1] = next;
            printf("%d\n", next);
        }else if (type[0] == 'B' && type[1] == 'P') {
            scanf("%d %d", &next, &temp);
            prev = stations[next][0];
            stations[prev][1] = temp;
            stations[next][0] = temp;
            stations[temp][0] = prev;
            stations[temp][1] = next;
            printf("%d\n", prev);
        }else if (type[0] == 'C' && type[1] == 'N') {
            scanf("%d", &prev);
            temp = stations[prev][1];
            next = stations[temp][1];
            stations[prev][1] = next;
            stations[next][0] = prev;
            printf("%d\n", temp);
        }else {
            scanf("%d", &next);
            temp = stations[next][0];
            prev = stations[temp][0];
            stations[prev][1] = next;
            stations[next][0] = prev;
            printf("%d\n", temp);
        }
    }
}

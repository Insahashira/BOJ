#include <stdio.h>
#include <stdlib.h>

static int n, m, *element, *isUsed, *result;

void print(int* arr) {
    for (int i = 0; i < m; i++) printf("%d ", arr[i]);
    printf("\n");
}

void reset(int* arr, int curIndex) {for (int i = curIndex + 1; i < m; i++) arr[i] = 0;}

void rec(int* arr, int curIndex) {
    if (curIndex == m) return print(arr);
    for (int i = 0; i < n; i++) {
        if (!isUsed[i]) {
            if (element[i] == arr[curIndex]) continue;

            isUsed[i] = 1;
            arr[curIndex] = element[i];
            rec(arr, curIndex + 1);
            reset(arr, curIndex);
            isUsed[i] = 0;
        }
    }
}


int comp(const void *a, const void *b) {return *(int*)a - *(int*)b;}

int main() {
    scanf("%d %d", &n, &m);
    result = malloc(m * sizeof(int));
    for (int i = 0; i < m; i++) result[i] = -1;

    isUsed = malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) isUsed[i] = 0;

    element = malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) scanf("%d", &element[i]);
    qsort(element, n, sizeof(int), comp);

    rec(result, 0);
}
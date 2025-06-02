//N과 M (12)
#include <stdio.h>
#include <stdlib.h>

static int n, m, *element, *result;

void print(int* arr) {
    for (int i = 0; i < m; i++) printf("%d ", arr[i]);
    printf("\n");
}

void reset(int* arr, int curIndex) {for (int i = curIndex + 1; i < m; i++) arr[i] = 0;}

int comp(const void *a, const void *b) {return *(int*)a - *(int*)b;}

void rec(int* arr, int curIndex) {
    if (curIndex == m) return print(arr);

    for (int i = 0; i < n; i++){
        if (curIndex && arr[curIndex - 1] > element[i] || arr[curIndex] == element[i]) continue;

        arr[curIndex] = element[i];
        rec(arr, curIndex + 1);
        reset(arr, curIndex);
    }
}


int main() {
    scanf("%d %d", &n, &m);
    result = malloc(m * sizeof(int));
    for (int i = 0; i < m; i++) result[i] = -1;

    element = malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) scanf("%d", &element[i]);
    qsort(element, n, sizeof(int), comp);

    rec(result, 0);
}
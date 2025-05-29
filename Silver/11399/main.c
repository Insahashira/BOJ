#include <stdio.h>
#include <math.h>

void normal_sort(int* arr, int size) {
    for (int i = 0; i < size; i++) {
        for (int ii = 0; ii < size - 1; ii++) {
            if (arr[ii] > arr[ii + 1]) {
                arr[ii]     = arr[ii] ^ arr[ii + 1];
                arr[ii + 1] = arr[ii] ^ arr[ii + 1];
                arr[ii]     = arr[ii] ^ arr[ii + 1];
            }
        }
    }
}

int main() {
    int count, result = 0;
    scanf("%d", &count);
    int arr[count];
    for (int i = 0; i < count; i++) scanf("%d", &arr[i]);

    normal_sort(arr, count);
    for (int i = 0; i < count; i++) result += (count - i) * arr[i];
    printf("%d\n", result);
}
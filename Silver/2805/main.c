#include <stdio.h>

long num, target;

long bin_search(long lo, long hi, long arr[]) {
    if (lo >= hi) return hi;

    long long result = 0;
    long pivot = (lo + hi)/2;
    if (pivot == lo) return lo;
    for (long i = 0; i < num; i++) {
        long temp = arr[i] <= pivot ? 0 : arr[i] - pivot;
        result += temp;
    }

    if (result == target) return pivot;
    if (result < target) return bin_search(lo, pivot - 1, arr);
    return bin_search(pivot + 1, hi, arr);
}

int main() {
    scanf("%ld %ld", &num, &target);

    long arr[num];
    long max_height = 0;

    for (long i = 0; i < num; i++) {
        long temp;
        scanf(" %ld", &temp);
        arr[i] = temp;
        max_height = max_height > temp ? max_height : temp;
    }

    printf("%ld\n", bin_search(0, max_height, arr));
    return 0;
}


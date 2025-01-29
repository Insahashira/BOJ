#include <stdio.h>
#include <limits.h>

int min(int x, int y);

int main(){
    int tests, count;
    scanf("%d", &tests);
    for(int i = 0; i < tests; i++) {
        scanf("%d", &count);
        int arr[count][count], val[count], sum[count + 1];
        for(int ii = 0; ii < count; ii++) for (int iii = 0; iii < count; iii++) arr[ii][iii] = ii == iii ? 0 : INT_MAX;

        sum[0] = 0;

        for(int ii = 0; ii < count; ii++) {
            scanf("%d", &val[ii]);
            sum[ii + 1] = val[ii] + sum[ii];
        }
        for(int ii = 1; ii < count; ii++) { //number of blocks to merge
            for(int iii = 0; iii < count - ii; iii++) { //upper pointer
                for (int iv = 0; iv < ii; iv++) {
                    arr[iii][iii+ii] = min(arr[iii][iii + iv] + arr[iii + iv + 1][iii + ii] + sum[iii + ii + 1] - sum[iii], arr[iii][iii + ii]);
                }
            }
        }
        printf("%d\n", arr[0][count-1]);
    }
}

int min(int x, int y) {
    return x < y ? x : y;
}
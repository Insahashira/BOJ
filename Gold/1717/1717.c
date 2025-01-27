#include <stdio.h>

int *arr;

int parent(int i) {
    if (i != arr[i]) {
        return arr[i] = parent(arr[i]);
    }
    return i;
}

int main() {
    int n, m;
    scanf("%d %d", &n, &m);
    int par[n+1];
    arr = par;
    for (int i = 0; i <= n; i++) {par[i] = i;}
    for (int i = 0; i < m; i++) {
        int type, a, b, parA, parB;
        scanf("%d %d %d", &type, &a, &b);
        parA = parent(a);
        parB = parent(b);
        if (parA == parB) {
            if (type == 1) {printf("YES\n");}
        } else if (type == 0) {
            par[parA] = par[parB] = parA < parB ? parA : parB;
        } else {
            printf("NO\n");
        }
    }
}


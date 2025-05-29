#include <stdio.h>
#include <math.h>

static int r, c;
int rec(int n, int row, int col, int offset);

int main() {
    int N;
    scanf("%d %d %d", &N, &r, &c);

    printf("%d", rec(N, 0, 0, 0));

}

int rec(int n, int row, int col, int offset) {
    if (n == 1) {
        if (row == r) {
            if (col == c) return offset;
            return offset + 1;
        }
        if (col == c) return offset + 2;
        return offset + 3;
    }
    n -= 1;
    int l_off = (int) pow(2,n); //linear_offset
    int m_off = (int) pow(l_off,2); //matrix offset

    if (row + l_off > r) {
        if (col + l_off > c) return rec(n, row, col, offset);
        return rec(n, row, col + l_off, offset + m_off);
    }
    if (col + l_off > c) return rec(n, row + l_off, col, offset + 2 * m_off);
    return rec(n, row + l_off, col + l_off, offset + 3 * m_off);
}
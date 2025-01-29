#include <stdio.h>
#include <stdbool.h>

int main() {
  int row, col;
  scanf("%d %d", &row, &col);
  bool map[row][col];
  for (int i = 0; i < row; i++) {
    for (int ii = 0; ii < col; ii++) {
      char c;
      scanf(" %c", &c);
      map[i][ii] = c == 'B' ? 1 : 0;
    }
  }
  int min = 0x7fffffff;
  for (int i = 0; i < row - 7; i++) {
    for (int ii = 0; ii < col - 7; ii++) {
      int fault = 0;
      int counter[2];
      counter[0] = map[i][ii];
      counter[1] = !map[i][ii];
      for (int iii = 0; iii < 8; iii++) {
        for(int iv = 0; iv < 8; iv++){
          if (map[i + iii][ii + iv] != counter[(i + iii + ii + iv) % 2]) fault++;
          }
        }
      int count = fault < 32 ? fault : 64 - fault;
      min = min > count ? count : min;
    }
  }
  printf("%d\n", min);
}

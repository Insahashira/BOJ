#include <stdio.h>
#include <stdbool.h>

int main() {
  int count, row, col, odd, even;
  scanf("%d", &count);
  for (int c = 0; c < count; c++) {
    scanf("%d %d", &row, &col);
    bool map[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        char temp;
        scanf("%c", &temp);
        map[i][j] = temp == '.' ? true : false;
      }
    }
  }
}

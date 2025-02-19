#include <stdio.h>
#include <math.h>

int main() {
  int n0, n1, n2, n3, n4, n5;
  scanf("%d %d %d %d %d", &n0, &n1, &n2, &n3, &n4);
  n5 = (int) (pow(n0, 2) + pow(n1, 2) + pow(n2, 2) + pow(n3, 2) + pow(n4, 2)) % 10;
  printf("%d\n", n5);
}
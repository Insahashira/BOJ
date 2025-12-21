#include <stdio.h>
#include <stdlib.h>



int main(){
    int grid, count;
    scanf("%d", &grid);
    scanf("%d", &count);
    
    int** cases = malloc(count * sizeof(int*));
    
    for(int i = 0; i < count; i++){
        cases[i] = malloc(2 * sizeof(int));
    }

    for(int i = 0; i < count; i++){
        scanf("%d %d", &cases[i][0], &cases[i][1]);
    }

}
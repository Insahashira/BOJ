#include <stdio.h>
#include <stdlib.h>

#define MAX(x, y) ((x) < (y) ? (y) : (x))
#define MIN(x, y) ((x) > (y) ? (y) : (x))
#define COORDINATE(prev, next) (abs(cases[prev][0] - cases[next][0]) + abs(cases[prev][1] - cases[next][1]))
#define INF 0x7fffffff

int main(){
    int grid, count;
    scanf(" %d", &grid);
    scanf(" %d", &count);
    
    //사건 위치들
    int** cases = malloc((count + 1) * sizeof(int*));
    //dp 테이블
    int** dp = malloc((count + 1) * sizeof(int*));
    //순서
    int order[count+1][count+1];
    int par[count+1][count+1][2];

    //사건 위치, dp 테이블 초기화
    for(int i = 0; i <= count; i++){
        cases[i] = malloc(2 * sizeof(int));
        cases[i][0] = 0;
        cases[i][1] = 0;

        dp[i] = malloc((count + 1) * sizeof(int));
        for(int ii = 0; ii <= count; ii++){
            dp[i][ii] = INF;
        }
    }
    
    //사건 좌표 받기
    for(int i = 0; i < count; i++){
        scanf("%d %d", &cases[i+1][0], &cases[i+1][1]);
    }

    dp[0][0] = 0;

    // printf("case dump ----\n");
    // for(int i = 0; i < count; i++){
    //     printf("case %d: %d, %d\n", i, cases[i+1][0],cases[i+1][1]);
    // }

    for(int i = 0; i < count; i++){
        for(int ii = 0; ii < count; ii++){
            if(i == ii && dp[i][ii] == INF) continue;
            int num = MAX(i, ii) + 1;
            int var;

            // if(num > count) continue;

            if(i == 0)
                var = dp[i][ii] + abs(cases[num][0] - 1)    + abs(cases[num][1] - 1);
            else
                var = dp[i][ii] + COORDINATE(i, num);

            if(dp[num][ii] > var){
                dp[num][ii] = var;
                par[num][ii][0] = i;
                par[num][ii][1] = ii;
                order[num][ii] = 1;
            }

            if(ii == 0)
                var = dp[i][ii] + abs(cases[num][0] - grid) + abs(cases[num][1] - grid);
            else
                var = dp[i][ii] + COORDINATE(ii, num);
            
            if(dp[i][num] > var){
                dp[i][num] = var;
                par[i][num][0] = i;
                par[i][num][1] = ii;
                order[i][num] = 2;
            }
        }
    }

    int min = INF;
    int coor[2];

    for(int i = 0; i < count; i++){
        if(dp[i][count] < min){
            min = dp[i][count];
            coor[0] = i;
            coor[1] = count;
        }

        if(dp[count][i] < min){
            min = dp[count][i];
            coor[0] = count;
            coor[1] = i;
        }
    }

    printf("%d\n", min);

    int result[count];
    int par_count = count;
    while(coor[0] != 0 || coor[1] != 0){
    // while(par_count > 0){
        result[--par_count] = order[coor[0]][coor[1]];
        int x = par[coor[0]][coor[1]][0];
        int y = par[coor[0]][coor[1]][1];

        coor[0] = x;
        coor[1] = y;
    }

    // printf("Array Dump -----\n");
    // for (int i = 0; i <= count; i++) {
    //     for(int ii = 0; ii <= count; ii++){
    //         printf("%d ", dp[i][ii]);
    //     }
    //     printf("\n");
    // }
    for(int i = 0; i < count; i++){
        printf("%d\n", result[i]);
    }
    
}
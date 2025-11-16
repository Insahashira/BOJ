#include <iostream>;
#include <queue> queue<int> q;

using namespace std;

void bfs();

int main(){
    int row, col, z;
//    int box;

// 1 익음 0 안익음 -1 없음
    cin >> row >>  col >> z;
    int box[row][col][z];
    for(int i = 0; i < row; i++){
        for(int ii = 0; ii < col; ii++){
            for(int iii = 0; iii < z; iii++){
                cin >> box[i][ii][iii];
            }
        }
    }
}

void bfs(){

}
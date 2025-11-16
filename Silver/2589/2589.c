#include <stdio.h>
#include <stdlib.h>

int row, col, table[50][50];

struct bfs_queue {
    int row, col, val;
    struct bfs_queue *prev;
};

struct bfs_queue *head = NULL, *tail = NULL;

void enqueue(int row, int col, int val) {
    struct bfs_queue *node = (struct bfs_queue *)malloc(sizeof(struct bfs_queue));
    node->row = row;
    node->col = col;
    node->val = val;

    if (tail == NULL) {
        tail = head = node;
        return;
    }

    tail->prev = node;
    tail = node;
}

struct bfs_queue* dequeue() {
    struct bfs_queue *temp = head;

    if (head == tail) {
        head = tail = NULL;
        return temp;
    }

    head = head->prev;
    return temp;
}

void bfs() {
    struct bfs_queue *temp = dequeue();
    int dx[4] = {0, 0, 1, -1}, dy[4] = {1, -1, 0, 0};
    int row = temp->row, col = temp->col, val = temp->val;
    free(temp);

    max_val = max_val > val ? max_val : val;

    for (int i = 0; i < 4; i++) {
        if (row + dy[i] > -1 && row + dy[i] < row_limit &&
            col + dx[i] > -1 && col + dx[i] < col_limit &&
            table[row + dy[i]][col + dx[i]] == 0)
        {
            table[row + dy[i]][col + dx[i]] = val + 1;
            enqueue(row + dy[i], col + dx[i], val + 1);
        }
    }
}

int main(){
    scanf("%d %d", &row, &col);

    for (int i = 0; i < row; i++) for (int ii = 0; ii < col; ii++) scanf("%d", table[i][ii]);

    
}
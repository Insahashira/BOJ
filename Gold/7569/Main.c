//직접 큐 구현해서 bfs 돌리기, 배열 -> 입력 최대크기 100*100*100으로 고정, 마지막 익었는지 is_ok 쭉 돌려서 확인

#include <stdio.h>
#include <stdlib.h>

int row_limit, col_limit, height_limit, table[100][100][100], max_val = 0, is_ok = 1;

struct bfs_queue {
    int row, col, height, val;
    struct bfs_queue *prev;
};

struct bfs_queue *head = NULL, *tail = NULL;

void enqueue(int row, int col, int height, int val) {
    struct bfs_queue *node = (struct bfs_queue *)malloc(sizeof(struct bfs_queue));
    node->row = row;
    node->col = col;
    node->height = height;
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
    int dx[6] = {0, 0, 1, -1}, dy[6] = {1, -1}, dz[6] = {0, 0, 0, 0, 1, -1};
    int row = temp->row, col = temp->col, height = temp->height, val = temp->val;
    free(temp);

    max_val = max_val > val ? max_val : val;

    for (int i = 0; i < 6; i++) {
        if (row + dy[i] > -1 && row + dy[i] < row_limit &&
            col + dx[i] > -1 && col + dx[i] < col_limit &&
            height + dz[i] > -1 && height + dz[i] < height_limit &&
            table[row + dy[i]][col + dx[i]][height + dz[i]] == 0)
        {
            table[row + dy[i]][col + dx[i]][height + dz[i]] = val + 1;
            enqueue(row + dy[i], col + dx[i], height + dz[i], val + 1);
        }
    }
}

int main() {
    scanf("%d %d %d", &col_limit, &row_limit, &height_limit);

    for (int iii = 0; iii < height_limit; iii++) for (int i = 0; i < row_limit; i++) for (int ii = 0; ii < col_limit; ii++) {
        scanf("%d", &table[i][ii][iii]);
        if(table[i][ii][iii] == 1) enqueue(i, ii, iii, 0);
    }

    while (head != NULL) bfs();

    for (int iii = 0; iii < height_limit; iii++) for (int i = 0; i < row_limit; i++) for (int ii = 0; ii < col_limit; ii++) if (table[i][ii][iii] == 0) is_ok = 0;

    if (is_ok) printf("%d", max_val);
    else printf("-1");
}
//직접 큐 구현해서 bfs 돌리기, 배열은 최대크기 1000*1000이라 그냥 고정시킴, 마지막 익었는지 is_ok 쭉 돌려서 확인

#include <stdio.h>
#include <stdlib.h>

int row_limit, col_limit, table[1000][1000], max_val = 0, is_ok = 1;

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

int main() {
    scanf("%d %d", &col_limit, &row_limit);

    for (int i = 0; i < row_limit; i++) for (int ii = 0; ii < col_limit; ii++) {
        scanf("%d", &table[i][ii]);
        if(table[i][ii] == 1) enqueue(i, ii, 0);
    }

    while (head != NULL) bfs();

    for (int i = 0; i < row_limit; i++) for (int ii = 0; ii < col_limit; ii++) if (table[i][ii] == 0) is_ok = 0;

    if (is_ok) printf("%d", max_val);
    else printf("-1");
}
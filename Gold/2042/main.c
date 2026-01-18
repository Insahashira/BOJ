#include <stdio.h>
#include <stdlib.h>

static long long* table;
static int line, round_up;

void table_dump();

void build_tree(){
    for(int i = round_up-1; i > 0; i--) table[i] = table[i*2+1] + table[i*2];
    // table_dump();
}

void update(int index, long val){
    static int idx;
    idx = index + round_up-1;
    table[idx] = val;
    while(idx != 1){
        table[idx/2] = table[idx%2 == 0 ? idx+1 : idx-1] + table[idx];
        idx = idx/2;
    }
}

long long find(int a, int b){
    long long result = 0;
    if(a > b){
        static int temp;
        temp  = a;
        a = b;
        b = temp;

        // a = a ^ b;
        // b = a ^ b;
        // a = a ^ b;
    }

    int a_index = round_up+a-1, b_index = round_up+b-1;

    // printf("index a is: %d index b is: %d\n", a_index, b_index);

    while(a_index < b_index && a_index != 1 && b_index != 1){
        if(a_index%2 == 1){
            // printf("subtracting %d\n", a_index-1);
            result -= table[a_index-1];
        }
        a_index /= 2;
    
        if(b_index%2 == 0){
            // printf("subtracting %d\n", b_index+1);
            result -= table[b_index+1];
        }
        b_index /= 2;
    }

    if(a_index == b_index) result += table[a_index];
    else result += table[a_index] + table[b_index];
    
    return result;
}

void table_dump(){
    for(int i = 0; i < round_up * 2; i++) printf("%d ", i);
    printf("\n");
    for(int i = 0; i < round_up * 2; i++) printf("%lld ", table[i]);
    printf("\n");
}

int main(){
    int change, sum_count;

    scanf(" %d %d %d", &line, &change, &sum_count);

    round_up = 1;
    while(round_up < line) round_up = round_up << 1;

    // printf("round up line: %d\n", round_up);

    table = calloc((round_up * 2), sizeof(long long));

    for(int i = 0; i < line; i++) scanf(" %lld", &table[round_up + i]);

    build_tree();

    // table_dump();

    for(int i = 0; i < change + sum_count; i++){
        int type;
        long long a, b;
        scanf(" %d %lld %lld", &type, &a, &b);

        if(type == 1) update(a, b);
        else          printf("%lld\n", find(a, b));
    }
}
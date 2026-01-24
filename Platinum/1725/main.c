#include <stdio.h>
#include <stdlib.h>

int length;
int round_up = 1;
int *height;
int *seg_tree;
int *idx;

#define min(x,y) ((x) > (y)? (y): (x))

void find(int a, int b, int *result){
    if(a > b){
        int temp = a;
        a = b;
        b = temp;
    }
    a += round_up;
    b += round_up;
    int a_val = seg_tree[a], b_val = seg_tree[b], a_idx = idx[a], b_idx = idx[b];
    while(a <= b){
        if(a%2 == 1){
            a /= 2;
            a += 1;
        }else{
            a /= 2;
            if(a_val > seg_tree[a]){
                a_val = seg_tree[a];
                a_idx = idx[a];
            }
        }
        
        if(b%2 == 0){
            b /= 2;
            b -= 1;
        }
        b /= 2;
        if(b_val > seg_tree[b]){
            b_val = seg_tree[b];
            b_idx = idx[b];
        }
    }
    result[0] = a_val > b_val ? b_val : a_val;
    result[1] = a_val > b_val ? b_idx : a_idx;
}

void build_tree(){
    for(int i = 0; i < round_up; i--){
        int left = seg_tree[i*2];
        int right = seg_tree[i*2+1];
        if(right > left){
            idx[i] = i*2;
            seg_tree[round_up + i] = left;
        }else{
            idx[i] = i*2+1;
            seg_tree[round_up + i] = right;
        }
    }
}

int rec(int start, int end){
    if(start == end) return 0x7fffffff;

    int val[2];
    find(start, end, val);
    
    if(start - end == 1) return val[0];

    return min(rec(start, val[1]), rec(val[1], end));
}

int main(){
    scanf("%d", &length);

    height = malloc(length * sizeof(int));

    while(round_up < length){round_up = round_up << 1;}
    round_up = round_up << 1;

    seg_tree = malloc((round_up*2) * sizeof(int));
    for(int i = round_up; i < round_up * 2; i++){seg_tree[i] = 0x7fffffff;}
    idx = malloc(round_up * sizeof(int));

    for(int i = 0; i < length; i++){
        int temp;
        scanf(" %d", &temp);
        height[i] = temp;
        seg_tree[length + i] = temp;
    }

    build_tree();

    

    // printf("%d", rec(0, length-1));
}
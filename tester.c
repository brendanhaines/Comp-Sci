#include "stdio.h"

void main(){
printf( "ints:\n" );
int a = 1;
int *b = &a;
a = 2;
printf( "%d\n", a );
printf( "%d\n", b );
printf( "%d\n", *b );
}

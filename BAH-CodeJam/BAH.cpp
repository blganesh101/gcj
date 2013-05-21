#include <stdio.h>
#include <functional>
#include <bitset>
#include <math.h>
#include <time.h>
#include <stdlib.h>
#include <algorithm>
#include <iostream>
#include <string>
#include <vector>
#include <set>
#include <map>
#include <sstream>
#include <queue>
#include <bitset>
#include <string.h>
using namespace std;

typedef vector<int> vi;
typedef vector<vi> vii;
typedef vector<string> vs;
typedef long long int64;

#define forit(a,b) for(typeof((b).end()) a=(b).begin();a!=(b).end();a++)
#define clr(a,b) memset(a,b,sizeof a)
#define all(a) a.begin(),a.end()
#define sorta(a) sort(all(a))
#define scan(a) fscanf(in,"%d",&a)

FILE *in = fopen( "f.in" , "r" );
FILE *out = fopen( "output.txt" , "w" );

int N , M , dp[ 111 ][ 111 ];
char g[ 111 ][ 111 ];

bool bad( char x ){
	if( x == 'W' || x == 'R' || x == 'T' ) return 1;
	return 0;
}
inline int sum( int x1 , int y1 , int x2 , int y2 ){
	return dp[ x1 ][ y1 ] - dp[ x1 ][ y2 + 1 ] - dp[ x2 + 1 ][ y1 ] + dp[ x2 + 1 ][ y2 + 1 ];
}

int main(){

	int tes; scan( tes );
	for( int ttes = 1 ; ttes <= tes ; ttes++ ){
		scan( M ); scan( N );
		for( int q = 0 ; q < N ; q++ ){
			fscanf( in , "%s" ,g[ q ] );
		}
		clr( dp , 0 );
		for( int q = N - 1 ; q >= 0 ; q-- ){
			for( int w = M - 1 ; w >= 0 ; w-- ){
				dp[ q ][ w ] = bad( g[ q ][ w ] ) + dp[ q ][ w + 1 ] + dp[ q + 1 ][ w ] - dp[ q + 1 ][ w + 1 ];
			}
		}
		int ret = 0;
		for( int q = 0 ; q < N ; q++ ){
			for( int w = 0 ; w < M ; w++ ){
				for( int e = q ; e < N ; e++ ){
					for( int r = w ; r < M ; r++ ){
						if( sum( q , w , e , r ) == 0 ) ret = max( ret , (e - q + 1) * (r - w + 1) );
					}
				}
			}
		}
		fprintf( out , "Case #%d: %d\n" ,ttes ,ret );
	}

	return 0;
}

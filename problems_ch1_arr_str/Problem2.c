#include <stdio.h>

/*
 * string reversal
 * main: in place
 */

void reverse(char *str) {
	char* end = str;
	char tmp;
	printf("test");
	if(str) {
		while(*end) {
			++end;// find end of str
		}
		--end; // since last char is null
		
		while(str < end) {
			tmp = *str;
			*str++ = *end;
			*end-- = tmp;
		}
	}

}

int main(int args, char *argv[]){
	printf("String reverse problem.\n");
	char str[] = "this is a string";
	reverse(str);
	printf("Str: %s.\n", str);
	return 0;
}



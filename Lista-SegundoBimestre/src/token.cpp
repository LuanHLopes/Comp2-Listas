#include <iostream>
#include "token.h"
#include <string.h>
using namespace std;

void Token::passa(){
    s++;
}

char Token::retornaChar(){
    return *s;
}

Token::Token(char *tok){
    s = tok;
}
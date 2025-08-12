#include <string.h>
#include <stdio.h>
#include <iostream>

using namespace std;

#include "montaarvore.h"
#include "token.h"
#include "base.h"
#include "soma.h"
#include "subtracao.h"
#include "multiplicacao.h"
#include "divisao.h"
#include "numero.h"

Base* MontaArvore::Parse(char* str){
    Base *b = NULL;
    Token tkn = new Token(str);
    b = parseExpression(tkn);

    return b;
}

Base* MontaArvore::parseExpression(Token *token){
    Base *b = NULL;
    if(token->retornaChar() != NULL)
        b = parseSomaSub(token);

    return b;
}

Base* MontaArvore::parseSomaSub(Token *token){
    Base *b = new Base();
    
    if(token->retornaChar() != NULL){
        b->esq = parseMultDiv(token);
        if(token->retornaChar() == ')') token->passa();
        switch(token->retornaChar()){
            case '+': b = new Soma(b->esq, b->dir); break;
            case '-': b = new Subtracao(b->esq, b->dir); break;
            default: b = parseMultDiv(token);
        }
        token->passa();
        b->dir = parseMultDiv(token);
    }

    return b;
}

Base* MontaArvore::parseMultDiv(Token *token){
    Base *b = new Base();

    if(token->retornaChar() != NULL){
        b->esq = parseUnary(token);
        switch(token->retornaChar()){
            case '*': b = new Multiplicacao(b->esq, b->dir); break;
            case '/': b = new Divisao(b->esq, b->dir); break;
            default: return b->esq;
        }
    }

    return b;
}

Base* MontaArvore::parseUnary(Token *token){
    Base *b = new Base();

    b = parseAtom(token);

    return b;
}

Base* MontaArvore::parseNumero(Token *token){
    Base *b = new Base();
    if((token->retornaChar() > '0' && token->retornaChar < '9') || token->retornaChar() == '.'){
        char *num;
        *num = token->retornaChar();
        for(token->passa();(token->retornaChar() > '0' && token->retornaChar < '9') || token->retornaChar() == '.';token->passa()){
            strcat(num, &token->retornaChar());
        }
        strcat(num, "\0");
        b = new Numero(num);
    }

    return b;
}

Base* MontaArvore::parseAtom(Token *token){
    Base *b = new Base();

    if(token->retornaChar() == '('){
        token->passa();        
        b = parseExpression(token);
    }
    else b = parseNumero(token);

    return b;
}
#include "divisao.h"
Divisao::Divisao(Base* esquerda, Base* direita) : Base (esquerda, direita){
    
}

double Divisao::processa(){
    return esq->processa()/dir->processa();
}
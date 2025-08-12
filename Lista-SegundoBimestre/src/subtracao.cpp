#include "subtracao.h"

Subtracao::Subtracao(Base* esquerda, Base* direita) : Base (esquerda, direita){
    
}

double Subtracao::processa(){
    return esq->processa()-dir->processa();
}
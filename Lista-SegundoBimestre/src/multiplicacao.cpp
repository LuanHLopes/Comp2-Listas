#include "multiplicacao.h"
Multiplicacao::Multiplicacao(Base* esquerda, Base* direita) : Base (esquerda, direita){
    
}

double Multiplicacao::processa(){
    return esq->processa()*dir->processa();
}
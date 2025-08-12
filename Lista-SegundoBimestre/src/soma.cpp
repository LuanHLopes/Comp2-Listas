#include "soma.h"

Soma::Soma(Base* esquerda, Base* direita) : Base (esquerda, direita){
}

double Soma::processa(){
    return esq->processa()+dir->processa();
}
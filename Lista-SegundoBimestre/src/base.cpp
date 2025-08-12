#include "base.h"
#include <iostream>

Base::Base(){
    esq = dir = NULL;
}

Base::Base(Base *esq, Base *dir){
    this->esq = esq;
    this->dir = dir;
}

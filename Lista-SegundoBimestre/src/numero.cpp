#include "base.h"
#include "numero.h"
#include <stdlib.h>
#include <iostream>
using namespace std;

Numero::Numero(char *s) : Base (){
    this->num = atof ( s );
    cout << "Construindo Numero" << endl;
}

double Numero::processa() {
    return this->num;
}
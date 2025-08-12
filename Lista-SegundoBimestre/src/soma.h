#include "base.h"

class Soma : public Base{
public:
    Soma(Base* esquerda, Base* direita);
    double processa();
};
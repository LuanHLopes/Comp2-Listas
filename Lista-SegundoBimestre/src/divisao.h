#include "base.h"

class Divisao : public Base{
public:
    Divisao(Base* esquerda, Base* direita);
    double processa();
};
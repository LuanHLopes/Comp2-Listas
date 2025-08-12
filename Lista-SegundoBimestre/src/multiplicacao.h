#include "base.h"

class Multiplicacao : public Base{
public:
    Multiplicacao(Base* esquerda, Base* direita);
    double processa();
};
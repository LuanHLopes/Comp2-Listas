#include "base.h"

class Subtracao : public Base{
public:
    Subtracao(Base* esquerda, Base* direita);
    double processa();
};
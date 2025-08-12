#include "base.h"
#include <iostream>
using namespace std;

class MontaArvore{
public:
    Base* Parse(char *str);
    Base* parseExpression(Token *token);
    Base* parseSomaSub(Token *token);
    Base* parseMultDiv(Token *token);
    Base* parseUnary(Token *token);
    Base* parseAtom(Token *token);
    Base* parseNumero(Token *token);
};
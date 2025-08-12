class Base{
protected:
    Base *esq;
    Base *dir;
public:
    Base();
    Base(Base *esq, Base *dir);
    virtual double processa() = 0;
};
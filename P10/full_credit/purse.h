#ifndef PURSE_H
#define PURSE_H
#include <iostream>

class Purse{
    private:
    int _pounds;
    int _shillings;
    int _pence;
    void rationalize();

    public:
    Purse(int pounds=0, int shillings=0, int pence=0);
    friend std::ostream& operator<<(std::ostream& os, const Purse& purse);

    bool operator==(const Purse& purse)const;
    bool operator!=(const Purse& purse) const;
    bool operator<(const Purse& purse) const;
    bool operator<=(const Purse& purse) const;
    bool operator>(const Purse& purse) const;
    bool operator>=(const Purse& purse) const;

    Purse& operator++();    
    Purse operator++(int);
    Purse operator+(const Purse& purse) const;
    Purse operator-(const Purse& purse) const;
    Purse& operator+=(const Purse& purse);
    Purse& operator-=(const Purse& purse);
};
#endif
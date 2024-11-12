#include "purse.h"

// Constructor
Purse::Purse(int pounds, int shillings, int pence)
    : _pounds(pounds), _shillings(shillings), _pence(pence) {
    rationalize();
}

// Rationalize the values of pounds, shillings, and pence
void Purse::rationalize() {
    if (_pence >= 12) {
        _shillings += _pence / 12;
        _pence %= 12;
    }
    if (_shillings >= 20) {
        _pounds += _shillings / 20;
        _shillings %= 20;
    }
    if (_pence < 0) {
        _pence += 12;
        _shillings--;
    }
    if (_shillings < 0) {
        _shillings += 20;
        _pounds--;
    }
}

// Output in the format £pounds shillings spence d
std::ostream& operator<<(std::ostream& os, const Purse& purse) {
    char poundSymbol = 156;  // If this doesn't work, use '#'
    os << poundSymbol << purse._pounds << " " << purse._shillings << "s" << purse._pence << "d";
    return os;
}

// Comparison operators
bool Purse::operator==(const Purse& purse) const {
    return _pounds == purse._pounds && _shillings == purse._shillings && _pence == purse._pence;
}

bool Purse::operator!=(const Purse& purse) const {
    return !(*this == purse);
}

bool Purse::operator<(const Purse& purse) const {
    if (_pounds != purse._pounds) return _pounds < purse._pounds;
    if (_shillings != purse._shillings) return _shillings < purse._shillings;
    return _pence < purse._pence;
}

bool Purse::operator<=(const Purse& purse) const {
    return *this < purse || *this == purse;
}

bool Purse::operator>(const Purse& purse) const {
    return !(*this <= purse);
}

bool Purse::operator>=(const Purse& purse) const {
    return !(*this < purse);
}

// Pre-increment
Purse& Purse::operator++() {
    _pence++;
    rationalize();
    return *this;
}

// Post-increment
Purse Purse::operator++(int) {
    Purse temp = *this;
    ++(*this);
    return temp;
}

// Addition operator
Purse Purse::operator+(const Purse& purse) const {
    return Purse(_pounds + purse._pounds, _shillings + purse._shillings, _pence + purse._pence);
}

// Subtraction operator
Purse Purse::operator-(const Purse& purse) const {
    return Purse(_pounds - purse._pounds, _shillings - purse._shillings, _pence - purse._pence);
}

// Compound addition operator
Purse& Purse::operator+=(const Purse& purse) {
    _pounds += purse._pounds;
    _shillings += purse._shillings;
    _pence += purse._pence;
    rationalize();
    return *this;
}

// Compound subtraction operator
Purse& Purse::operator-=(const Purse& purse) {
    _pounds -= purse._pounds;
    _shillings -= purse._shillings;
    _pence -= purse._pence;
    rationalize();
    return *this;
}

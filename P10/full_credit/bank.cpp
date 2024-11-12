#include <iostream>
#include <map>
#include <string>
#include "purse.h"

int main() {
    std::map<std::string, Purse> vault;
    int numAccounts;
    std::cout << "How many accounts would you like to create? ";
    std::cin >> numAccounts;
    std::cin.ignore();

    for (int i = 0; i < numAccounts; ++i) {
        std::string name;
        int pounds, shillings, pence;
        std::cout << "Enter the name of account #" << (i + 1) << ": ";
        std::getline(std::cin, name);
        std::cout << "Enter initial deposit for " << name << " (pounds shillings pence): ";
        std::cin >> pounds >> shillings >> pence;
        std::cin.ignore();
        vault[name] = Purse(pounds, shillings, pence);
    }
    Purse total;
    std::cout << "\nAccount List:\n";
    for (const auto& [name, purse] : vault) {
        std::cout << name << ": " << purse << '\n';
        total += purse;
    }
    std::cout << "\nTotal amount of money in the bank: " << total << '\n';
    return 0;
}
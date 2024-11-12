#include <iostream>
#include <map>
#include <string>
#include "purse.h"

int main() {
    std::map<std::string, Purse> vault;
    int numAccounts;
    std::cout << "How many accounts? ";
    std::cin >> numAccounts;
    std::cin.ignore();

    for (int i = 0; i < numAccounts; ++i) {
        std::string name;
        int pounds, shillings, pence;
        std::cout << "Name account " << (i) << ": ";
        std::getline(std::cin, name);
        std::cout << "Enter initial deposit for (pounds shillings pence): ";
        std::cin >> pounds >> shillings >> pence;
        std::cin.ignore();
        vault[name] = Purse(pounds, shillings, pence);
    }
    Purse total;
    std::cout << "\nAccount List\n";
    std::cout << "============\n";
    for (const auto& [name, purse] : vault) {
        std::cout << "      " << name << " with " << purse << '\n';
        total += purse;
    }
    std::cout << "\nTotal in bank is " << total << '\n';
    return 0;
}
#include "clock.h"
#include <iostream>
#include <stdexcept>

int main(int argc, char *argv[]){
    if(argc!=4){
        std::cerr<<"usage: clock <hour> <minutes> <seconds>" << std::endl;
        return -1;
    }
    try{
        int hours=std::stoi(argv[1]);
        int minutes=std::stoi(argv[2]);
        int seconds=std::stoi(argv[3]);
        Clock clock(hours, minutes, seconds);

        std::string input;
        while(true){
            clock.print();
            std::cout<<"Enter 'q' to quit or any other key to tic: ";
            std::getline(std::cin, input);
            if(input=="q")break;
            clock.tic();
        }
    }catch(std::out_of_range &e){
        std::cerr<<e.what()<<std::endl;
        return -2;
    }catch(std::invalid_argument &e){
        std::cerr<<"Invalid argument provided."<<std::endl;
        return -2;
    } 
    return 0;
}
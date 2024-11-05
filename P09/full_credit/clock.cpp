#ifndef CLOCK_H
#define CLOCK_H

#include <iostream>
#include <stdexcept>

class Clock{
    public:
            Clock(int hours, int minutes, int second);
            void print();
            void tic();
    protected:
                int _hours;
                int _minutes;
                int _seconds;

            // void format_time(int time_unit)      
};
#endif
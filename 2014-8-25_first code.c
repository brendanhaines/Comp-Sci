/*
  variable shoes_on_feet
  set shoes_on_feet = 0
  while shoes_on_feet !=2
    get shoe
    put shoe on foot
    shoes_on_feet ++
    if shoes match
      exit while loop
    else
      shoes_on_feet --
*/
#include "stdio.h"

char Amount = 2.34; // Dolars.cents

int Ones = 0;
int Quarters = 0;
int Dimes = 0;
int Nickels = 0;
int Pennies = 0;

int main()
{
  printf( "Enter Amount..." );
  
  //Get amount
  
  Ones = ctoi( Amount );
  Amount = Amount - Ones;
  
  Quarters = ctoi( Amount / 4 );
  Amount = Amount - 0.25 * Quarters;
  
  Dimes = ctoi( Amount / 10 );
  Amount = Amount - 0.10 * Dimes;
  
  Nickels = ctoi( Amount / 20 );
  Amount = Amount - 0.05 * Nickels;
  
  Pennies = Amount;
  
  printf( "Ones: %d\tQuarters: %d\tDimes: %d\tNickels: %d\tPennies: %d\n", Ones, Quarters, Dimes, Nickels, Pennies );
}
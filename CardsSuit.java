//this class is reponsible/ the purpose of this class is to create random cards with random suit and random number


package com.mycompany.blackjack2;

import java.util.Random;



// this enumerator class is where all the suits and number of cards will be stored
public enum CardsSuit
{
     Hearts,
     Club,
     Spades,
     Diamond;
     
    
    
    private static Random ran = new Random();
    
    // this will return a random suit value.
    public static CardsSuit randomSuit() 
    {

    int pick = ran.nextInt(CardsSuit.values().length);
    return CardsSuit.values()[pick];
    
    } 
    
    // this will return a random number value of cards
    public static int randomValue()
    {
        final int lowerLimit = 0;
    
        final int upperLimit = 14;
        int randomValue = ran.nextInt((lowerLimit + 1) + (upperLimit - 1));
        return randomValue;
    }
       
    
}

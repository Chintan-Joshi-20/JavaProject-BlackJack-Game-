//this class will sort out 2 same cards so that 2 same cards will never be generated


package com.mycompany.blackjack2;


public class Card 
{
   private int cardNumber;
   
   private CardsSuit cardsSuit;
   
   //After the cards being generated with random number and random suit it will be entered here for sorting purposes in case of same cards
   public Card(int cardNumber , CardsSuit cardsSuit)
   {
       this.cardNumber = cardNumber;
       this.cardsSuit = cardsSuit;
   }
   
   // this method will get the random card number.
   public int getCardNumber()
   {
      return this.cardNumber;
   }
   
   // this method will get the random card value.
   public CardsSuit getCardsSuit()
    {
        return this.cardsSuit;
    }
   
   //this method will get the random card number and card value and will basically print them.
   public String toString()
   {
       return getCardNumber() + " of " + getCardsSuit();
   }
}

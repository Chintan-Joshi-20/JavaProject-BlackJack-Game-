// this program is about the java code that is basically a representation of a text-based Blackjack. 

package com.mycompany.blackjack2;
import java.util.*;

public class Blackjack2
{
    public static void main(String[] args)
    {
        Scanner user = new Scanner(System.in); 
        
        System.out.println("Do you want to begin the game? (Yes or No)");
        
        String userResponse = user.nextLine();            // so far till this line user will be prompted to enter the user until user tpyes yes the game won't begin.
                
        if(userResponse.toLowerCase().equals("yes"))  // this will check the user response if it yes than the game will begin.
        {
            boolean gameCountinue = true; // this means that telling Java that the game will begin now
            
            HashMap<Integer , Card> dealerCards = getDealerCards(2);  // this creates 2 random dealer cards
            HashMap<Integer , Card> playerCards = getPlayerCards(2); // this creates 2 random dealer cards
            
            // setting the player and dealer points
            int playerPoints = 0;
            int dealerPoints = 0;
            
            while (gameCountinue) //this loop is responsible for asking the user for cards and for letting the game run as well
            {

                System.out.println("\nPlayer has:");     
                // this will bascially display and generate how many and which set of cards player has from different suits and random numbers aka shuffling cards.
                for(Integer key: playerCards.keySet())
                {
                  Card playerRandomCard = playerCards.get(key);
                  playerPoints += playerRandomCard.getCardNumber();
                  System.out.println(playerRandomCard.toString());
                }

                System.out.println("\nDealer has:");
                // this will bascially display and generate how many and which set of cards dealer has from different suits and random numbers aka shuffling cards.
                for(Integer key : dealerCards.keySet())
                {
                   Card dealerRandomCard = dealerCards.get(key);
                   dealerPoints += dealerRandomCard.getCardNumber();
                   System.out.println(dealerRandomCard.toString());
                }

                System.out.println("\nDo you want to hit or stand (Please type hit or stand only :) )");
                String hitOrStandUserInput = user.nextLine();  // this will check for user input if user has entered hit or stand.
                

                switch (hitOrStandUserInput.toLowerCase()) 
                {
                    // from here according to user input the game will progress if user says hit a new random card will be generated along with a new dealer random card as well
                    case "hit":
                        playerCards = getPlayerCards(1);
                        System.out.println("You drew " + playerCards.get(0).toString());
                        dealerCards = getDealerCards(1);
                        System.out.println("Dealer drew " + dealerCards.get(0).toString());
                        break;
                        
                    // here if user says stand than the code will be terminated along with given the user points and dealer points and who won and who lost.
                    case "stand":
                        gameCountinue = false;
                        System.out.println("Your points: " + playerPoints);
                        System.out.println("Dealer points: " + dealerPoints);
                        
                        //this will count the numbers/final points of dealer and player and will print who won and who lost
                        if(playerPoints > 21)
                        {
                            System.out.println("You lost Dealer won!");
                        }
                        else if(dealerPoints > 21)
                        {
                            System.out.println("You won! Dealer Lost!");
                        }
                        else if(dealerPoints == playerPoints)
                        {
                            System.out.println("No one wins!");
                        }
                        else if(playerPoints > dealerPoints)
                        {
                            System.out.println("You won! Dealer Lost");
                        }
                        else if(playerPoints > 21 && dealerPoints > 21)
                        {
                            System.out.println("Nobody won! both lost");
                        }
                        else
                        {
                            System.out.println("You Lost! Dealer Lost");
                        }
                        break;
                    default:
                        System.out.println("Please enter hit or stand only");
                        break;
                }
            }
        }
        else
        {
            //this code is for the special case in case if user enters nothing and presses enter than the code will ask to put an valid input and end the game
            if(userResponse.isEmpty())
            {
               System.out.println("Please enter a input");
            }
            else
            {
                System.out.println("Have a good day!");
            }
        }
    }
    
    //this part is reponsible for generating a random card with random number and suit for dealer's side (after player says "hit")
     public static HashMap<Integer , Card> getDealerCards (int numDealerCards)
     {
        return getRandomCards(numDealerCards);
        
     }
     
     // this part of code is responsible for generating a random card with random number and suit for player's side(after player says "hit")
     public static HashMap<Integer , Card> getPlayerCards (int numPlayerCards)
     {
        return getRandomCards(numPlayerCards);
        
     }
     
     // this part of code is responsible for generating 2 random cards which are given to player and dealer at the begining of the game.
     private static HashMap<Integer , Card> getRandomCards(int numOfCards)
     {
       HashMap<Integer, Card> totalCards = new HashMap<>();
        
        for (int i = 0; i < numOfCards ; i++)
        {
            Card card = new Card(CardsSuit.randomValue(),CardsSuit.randomSuit());
            totalCards.put(i, card);
        }
        
        return totalCards;
     }
}
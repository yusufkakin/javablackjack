package BlackJack;

import java.util.Scanner;

public class playBlackJack {

    static CardDealer card = new CardDealer();

    public static void runGame() {

        int playerMoney = 300;

        Scanner scanner = new Scanner(System.in);

        //STARTS THE GAME WITH THE Y KEY

        System.out.println("Enter (Y) to play the game!");
        String customerInput = scanner.nextLine();
        while (customerInput.equalsIgnoreCase("y")) {
            System.out.println("How much you want to bet? You can only bet with what you have and in $5 increments");
            System.out.println("Your balance is $" + playerMoney);
            int betInput = scanner.nextInt();
            //CHECKS THE CONDITION OF THE USER BET FOR 5 INCREMENTS, USER CAN'T PLACE WHAT THEY DON'T HAVE
            if (betInput < playerMoney && betInput % 5 == 0) {
                //USER GETS 2 CARDS, 2 DEALER GETS 2 CARDS
                String card1 = card.getCard();
                int card1Value = card.getCardValue();
                String card2 = card.getCard();
                int card2Value = card.getCardValue();
                String dealerCard1 = card.getCard();
                int dealerCard1Value = card.getCardValue();
                String dealerCard2 = card.getCard();
                int dealerCard2Value = card.getCardValue();
                int playerTotal = card1Value + card2Value;
                int dealerTotal = dealerCard1Value + dealerCard2Value;
                System.out.println("Your cards are " + card1 + " of " + CardDealer.getSuit() + " and " + card2 + " of " + CardDealer.getSuit() + " with a total of: " + playerTotal);
                System.out.println("Dealer cards are " + dealerCard1 + " of " + CardDealer.getSuit() + " and [Unrevealed]" + " with a total of: " + dealerCard1Value);
                //CHECKS THE TOTAL OF PLAYER'S CARD
                if (playerTotal < 21) {
                    System.out.println("Would you like to (H)it or (S)tand?");
                    scanner.nextLine();
                    String playerChoice = scanner.nextLine();
                    if (playerChoice.equalsIgnoreCase("h")) {
                        String card3 = card.getCard();
                        int card3Value = card.getCardValue();
                        //STATEMENT FOR THE ACE VALUE
                        if ((playerTotal + 11) > 21 && (card1Value == 11 || card2Value == 11)) playerTotal -= 10;
                        playerTotal += card3Value;
                        System.out.println("Your new card is a " + card3 + " of " + CardDealer.getSuit() + " with a value of " + card3Value);
                        System.out.println("Now your total value is " + playerTotal);
                        if (playerTotal < 21) {
                            System.out.println("Would you like to (H)it or (S)tand?");
                            String playerChoice2 = scanner.nextLine();
                            if (playerChoice2.equalsIgnoreCase("h")) {
                                String card4 = card.getCard();
                                int card4Value = card.getCardValue();
                                //STATEMENT FOR THE ACE
                                if ((playerTotal + 11) > 21 && card3Value == 11) playerTotal -= 10;
                                System.out.println("Your new card is a " + card4 + " of " + CardDealer.getSuit() + " with a value of " + card4Value);
                                playerTotal += card4Value;
                                System.out.println("Now your total value is " + playerTotal);
                                if (playerTotal < 21) {
                                    System.out.println("Would you like to (H)it or (S)tand?");
                                    String playerChoice3 = scanner.nextLine();
                                    if (playerChoice3.equalsIgnoreCase("h")) {
                                        String card5 = card.getCard();
                                        int card5Value = card.getCardValue();
                                        //STATEMENT FOR THE ACE
                                        if ((playerTotal + 11) > 21 && card4Value == 11) playerTotal -= 10;
                                        System.out.println("Your new card is a " + card5 + " of " + CardDealer.getSuit() + " with a value of " + card5Value);
                                        playerTotal += card5Value;
                                        System.out.println("Your total value is: " + playerTotal);

                                        //CHECKS THE ACE IF IT IS BUSTING THE PLAYERS HAND
                                        if ((playerTotal + 11) > 21 && card5Value == 11) {
                                            playerTotal -= 10;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (playerTotal > 21 || dealerTotal == 21) {
                    System.out.println("Sorry you bust!");
                    playerMoney -= betInput;
                    continue;
                }
                System.out.println("Dealer flips over " + dealerCard2 + " of " + CardDealer.getSuit() + " with a value of " + dealerCard2Value);
                System.out.println("Dealer total is " + dealerTotal);

                while (dealerTotal < 17) {
                    String newDealerCard = card.getCard();
                    int newDealerCardValue = card.getCardValue();
                    System.out.println("Dealer flips over a " + newDealerCard + " of " + CardDealer.getSuit() + " with a value of " + newDealerCardValue);
                    dealerTotal += newDealerCardValue;
                    System.out.println("Dealer total is now: " + dealerTotal);
                }

                // EVALUATES THE HAND OF THE PLAYER AND THE DEALER

                if (playerTotal > dealerTotal || dealerTotal > 21) {
                    System.out.println("Congrats! You have won! You have " + playerTotal + "and the Dealer has " + dealerTotal);
                    playerMoney += betInput * 1.5;
                    System.out.println("Your balance is: $" + playerMoney);
                } else if (dealerTotal > playerTotal) {
                    System.out.println("Sorry! You have lost. You have " + playerTotal + "and the Dealer has " + dealerTotal);
                    playerMoney -= betInput;
                    System.out.println("Your balance is $" + playerMoney);
                    //EVALUATES THE BLACKJACK
                } else if (playerTotal == 21) {
                    System.out.println("BlackJack! Your balance is $" + playerMoney);
                } else
                    System.out.println("It's a tie!");

                System.out.println("Do you want to play again? Enter (Y)");
                customerInput = scanner.nextLine();

            }

        }

    }
}


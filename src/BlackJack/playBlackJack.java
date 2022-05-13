package BlackJack;

import java.util.Scanner;

public class playBlackJack {

    static CardDealer card = new CardDealer();

    public static void runGame() {

        int playerMoney = 200;

        Scanner scanner = new Scanner(System.in);
        String runGame = "y";

            System.out.println("Enter (Y) to play the game!");
            String customerInput = scanner.nextLine();
            while (customerInput.equalsIgnoreCase("y")) {
                System.out.println("Welcome to the Casino! How much you want to bet?");
                System.out.println("Your balance is $" + playerMoney);
                int betInput = scanner.nextInt();
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
                System.out.println("Your cards are " + card1 + " and " + card2 + " with a total of: " + playerTotal);
                System.out.println("Dealer cards are " + dealerCard1 + " and [Unrevealed]" + " with a total of: " + dealerCard1Value);
                if (playerTotal < 21) {
                    System.out.println("Would you like to (H)it or (S)tand?");
                    String playerChoice = scanner.nextLine();
                    if (playerChoice.equalsIgnoreCase("h")) {
                        String card3 = card.getCard();
                        int card3Value = card.getCardValue();
                        System.out.println("Your new card is a " + card3 + " with a value of " + card3Value);
                        playerTotal += card3Value;
                        System.out.println("Now your total value is " + playerTotal);
                        if (playerTotal < 21) {
                            System.out.println("Would you like to (H)it or (S)tand?");
                            String playerChoice2 = scanner.nextLine();
                            if (playerChoice2.equalsIgnoreCase("h")) {
                                String card4 = card.getCard();
                                int card4Value = card.getCardValue();
                                System.out.println("Your new card is a " + card4 + " with a value of " + card4Value);
                                playerTotal += card4Value;
                                System.out.println("Now your total value is " + playerTotal);
                                if (playerTotal < 21) {
                                    System.out.println("Would you like to (H)it or (S)tand?");
                                    String playerChoice3 = scanner.nextLine();
                                    if (playerChoice3.equalsIgnoreCase("h")) {
                                        String card5 = card.getCard();
                                        int card5Value = card.getCardValue();
                                        System.out.println("Your new card is a " + card5 + " with a value of " + card4Value);
                                        playerTotal += card5Value;
                                    }
                                }
                            }
                        }

                        if (playerTotal > 21) {
                            System.out.println("Sorry you bust!");
                        }
                        System.out.println("Dealer flips over " + dealerCard2 + " with a value of " + dealerCard2Value);
                        System.out.println("Dealer total is " + dealerTotal);
                    }

                    while (dealerTotal < 17) {
                        String newDealerCard = card.getCard();
                        int newDealerCardValue = card.getCardValue();
                        System.out.println("Dealer flips over a " + newDealerCard + " with a value of " + newDealerCardValue);
                        dealerTotal += newDealerCardValue;
                        System.out.println("Dealer total is now: " + dealerTotal);
                    }

                    if ((playerTotal > dealerTotal && playerTotal <= 21) || (playerTotal < 21 && dealerTotal > 21)) {
                        System.out.println("Congrats! You have won! You have " + playerTotal + " Dealer has " + dealerTotal);
                        playerMoney += betInput * 1.5;
                        System.out.println("Your balance is: $" + playerMoney);
                    } else if ((dealerTotal > playerTotal && dealerTotal <= 21) || (dealerTotal <= 21 && playerTotal > 21)) {
                        System.out.println("Sorry! You have lost. You have " + playerTotal + " Dealer has " + dealerTotal);
                        playerMoney -= betInput;
                        System.out.println("Your balance is $" + playerMoney);
                    } else {
                        System.out.println("It's a tie");
                    }


                    System.out.println("Do you want to play again? Enter (Y)");
                    String runGame2 = scanner.nextLine();

                }

            }
        }
    }
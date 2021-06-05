/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package Base;

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main( String[] args )
    {
        double price = 1.00;
        String order = getData("order amount");
        String state = getData("state");
        int orderNum = stringToInt(order);
        String output = calcTotal (orderNum, state, price);
        printOutput(output);
    }
    public static String getData(String phrase)
    {
        System.out.printf( "What is the %s? ", phrase);
        return in.nextLine();
    }

    public static int stringToInt(String number)
    {
        return Integer.parseInt(number);
    }

    public static String calcTotal(double orderNum, String state, double price)
    {
        double total = orderNum * price;
        if (state.equals("WI"))
        {
            int subtotal = (int)total;
            double tax = total * 0.055;
            tax = roundToCent(tax);
            total += tax;
            total = roundToCent(total);
            return "The subtotal is $" + subtotal +".00\nThe tax is $" + tax +
                    "\nThe total is $" + total;
        }

        total = roundToCent(total);
        return "The total is $" + total + "0";
    }

    public static double roundToCent(double money)
    {
        money *= 100;
        money = Math.ceil(money);
        return money / 100;
    }

    public static void printOutput (String output)
    {
        System.out.println(output);
    }
}
package org.DifferentCoat.demos;

import org.DifferentCoat.customers.Customer;
import org.DifferentCoat.customers.GeneralPublic;
import org.DifferentCoat.customers.TradeCustomer;
import org.DifferentCoat.shapes.Cylinder;
import org.DifferentCoat.shapes.Rectangle;
import org.DifferentCoat.shapes.Square;

public class Demo {

    static Square square = new Square(10, 10 );
    protected static Customer connellMcKee = new GeneralPublic(
            "Connell McKee"
            , "421 apache street, Monaghan"
            , "(078) 79424874"
            , square
    );

    protected static Customer plankAreUsCustomer = new TradeCustomer(
            "Planks are us"
            , "121 Darkley road, Co.Aramgh"
            , "(028) 37530217"
            , 560
    );

    static Rectangle rectangle = new Rectangle(10, 10, 10);
    protected static Customer barryKeenan = new GeneralPublic(
            "Barry McKee"
            , "45 Armagh, saint patrick ave."
            , "(078) 79424874"
            , rectangle
    );

    static Cylinder cylinder = new Cylinder(30, 25);

    protected static Customer amyMcBirney = new GeneralPublic(
            "Amy McBirney"
            , "12 Granemore road"
            , "07879424178"
            , cylinder
    );

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("########################################################################\n");
        stringBuilder.append("This application is my solution to calculate the paint required to paint a\n" +
                "room for the customers of Different coat. The calculation has two main factors which effect it: customer type and\n" +
                "shape type:\n" +
                "   -  When a user selects that they are a TradeCustomer they enter the surface area only as they have the\n" +
                "      ability to accurately calculate the surface area of a room for when calculating the paint coverage.\n" +
                "   -  When a user selects that they are a GeneralCustomer we assume that the surface area calculation by them\n" +
                "      won't be so accurate therefore from this customer we request input like the room shape (Cylinder, Square,\n " +
                "     Rectangle: Users for calculating perimeter used for calculation) and how much wastage\n" +
                "      there is.\n");
        stringBuilder.append("########################################################################");
        stringBuilder.append("\nBelow is a list of examples of customer data and the coverage information produced by them:\n");
        System.out.println(stringBuilder);

        // This creates a tradeCustomer and prints out its toString

        System.out.println(plankAreUsCustomer);

        // This creates a General Customer and prints out its toString function
        // For this I will be testing 3 customers to view there different shapes and the outputs for those
        // shapes calculations.

        System.out.println(connellMcKee);

        System.out.println(barryKeenan);

        System.out.println(amyMcBirney);
    }
}

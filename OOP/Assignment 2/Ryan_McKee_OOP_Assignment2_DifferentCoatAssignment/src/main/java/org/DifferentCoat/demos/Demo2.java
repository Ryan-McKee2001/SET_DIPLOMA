/*
This demo will demonstrate the file system used to store
customer details as records and read the customer details
from the file.
 */

package org.DifferentCoat.demos;

import org.DifferentCoat.customers.Customer;
import org.DifferentCoat.support.Helper;

import java.io.IOException;
import java.util.ArrayList;

import static org.DifferentCoat.demos.Demo.*;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("########################################################################\n");
        stringBuilder.append("This demo contains a demonstration of the csv filing system used for storing customer" +
                "details and retrieving them from the csv.\n" +
                "Below shows a number of examples of customers being added to a csv file and then\n" +
                "\"being read from them again. When customer details are read from the csv file a customer object\n" +
                "\"associated with the customer type is created to wrap around the information presented\n");
        stringBuilder.append("########################################################################");
        stringBuilder.append("\n\n");
        System.out.println(stringBuilder);
        Helper.clearFile();
        Helper.addCustomer(connellMcKee);
        Helper.addCustomer(amyMcBirney);
        Helper.addCustomer(plankAreUsCustomer);
        Helper.addCustomer(barryKeenan);

        ArrayList<Customer> customers = Helper.getFileAsArrayList();
        System.out.println("\nBelow shows the toStrings for each of the customers read from the paint_coverage_information.csv: \n");

        for (Customer x :
                customers) {
            System.out.println(x);
        }

        Helper.clearFile();

        System.out.println();


        System.out.println("Paint needed for Connell McKee where shape is Square and height and width are 10: " + connellMcKee.calculatePaintCoverage());
        System.out.println("Paint needed for Amy McBirney where shape is cylinder and height is 30 and width is 25: " + amyMcBirney.calculatePaintCoverage());
        System.out.println("Paint needed for barry mckee where shape is rectangle and height, width and length and all equal to 10" + plankAreUsCustomer.calculatePaintCoverage());
        System.out.println("Paint needed for plants are us where surface area is 560: " + plankAreUsCustomer.calculatePaintCoverage());
    }
}

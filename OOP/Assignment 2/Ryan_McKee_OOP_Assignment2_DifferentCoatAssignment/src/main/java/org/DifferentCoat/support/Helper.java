/*
This helper class reads and writes customer information relating
to the paint coverage to the paint_coverage_information.txt file.
There is two main classes within this class:
- addItem: addItem takes an customer object and adds in to the paint_coverage.csv
           file.
- readFile: This function reads each record from the paint_coverage_information.csv
            and add each record to an arrayList of Strings where the values in the
            array are separated by a ";"
 */

package org.DifferentCoat.support;

import org.DifferentCoat.customers.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Helper {

    // fields
    private static ArrayList<String[]> coverageInformation = new ArrayList<String[]>();

    // This field stores the relevant file location to the csv file.
    private static String fileLocation = new String(System.getProperty("user.dir") + "/src/paint_coverage_information.csv");

    private static File myObj = new File(fileLocation);

    private static Scanner scanner;

    private static FileWriter myWriter;

    static {
        try {
            scanner = new Scanner(myObj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This function reads each line and adds values that are
     * separated by ; to instantiate a customer then this string array is added
     * to a customer array list. This is repeated for each record in the
     * paint_coverage_information.txt file
     * @return ArrayList<customer>
     */

    // TODO: Need to get this function working for a rectangle, as rectangle has length width and height.
    // TODO: Need to change the write function too.
    public static ArrayList<Customer> getFileAsArrayList() {

        ArrayList<Customer> customers = new ArrayList<>();
        Helper.readFile();

        for (String[] customerInfoArray :
                coverageInformation) {
            String customerType = customerInfoArray[1];

            if (customerType.equals("G")) {
                customers.add(CustomerParser.createGeneralCustomerObject(customerInfoArray));
            } else {
                customers.add(CustomerParser.createTradeCustomerObject(customerInfoArray));
            }
        }
        return customers;
    }

    /**
     * This function takes customer in the parameter and
     * appends it to the paint_coverage_information.txt file.
     * @param customer
     * @throws IOException
     */
    public static void addCustomer(Customer customer)
            throws IOException {

        myWriter = new FileWriter(fileLocation, true);
        String string = CustomerParser.getCustomerString(customer);
        myWriter.append(string.toString());
        myWriter.write("\n");
        myWriter.close();
    }

    /**
     * This function reads the file and sets the coverageInformation
     * arrayList with the information from the file.
     */
    private static void readFile() {

        coverageInformation.clear();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            String[] arr = data.split(";");
            coverageInformation.add(arr);
        }
        scanner.close();
    }

    public static void clearFile() {
        try{
            myWriter = new FileWriter(fileLocation, false);
            myWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

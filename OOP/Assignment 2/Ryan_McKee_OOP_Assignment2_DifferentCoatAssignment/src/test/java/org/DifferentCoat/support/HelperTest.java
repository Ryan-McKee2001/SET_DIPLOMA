/*
This test class is used to test the functionality
of the helper class.
 */

package org.DifferentCoat.support;

import org.DifferentCoat.customers.Customer;
import org.DifferentCoat.customers.GeneralPublic;
import org.DifferentCoat.customers.TradeCustomer;
import org.DifferentCoat.shapes.Square;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelperTest {

    ArrayList<Customer> expectedCustomers = new ArrayList<>();

    GeneralPublic generalCustomer;

    TradeCustomer tradeCustomer;

    @BeforeClass
    public void setUp() {

        generalCustomer = new GeneralPublic(
                "Brad"
                , "19 Beverly hills road"
                , "(233) 79424178"
                , new Square(10, 3)
        );

        tradeCustomer = new TradeCustomer(
                "Dry ice Ireland"
                , "19 springisland road, newry"
                , "(028) 37430106"
                , 300
        );

        expectedCustomers.add(generalCustomer);
        expectedCustomers.add(tradeCustomer);
    }

    @Test
    public void addTradeCustomerAndReadFile() throws IOException {

        Helper.addCustomer(generalCustomer);
        Helper.addCustomer(tradeCustomer);

        List<Customer> customers = Helper.getFileAsArrayList();

        int i = 0;
        for (Customer x :
                customers) {
            System.out.println(x);
        }

        //Helper.clearFile();
    }
}
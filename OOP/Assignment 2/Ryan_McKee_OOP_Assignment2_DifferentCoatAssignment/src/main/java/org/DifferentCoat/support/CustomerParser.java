package org.DifferentCoat.support;

import org.DifferentCoat.customers.Customer;
import org.DifferentCoat.customers.GeneralPublic;
import org.DifferentCoat.customers.TradeCustomer;
import org.DifferentCoat.shapes.Cylinder;
import org.DifferentCoat.shapes.Rectangle;
import org.DifferentCoat.shapes.Shape;
import org.DifferentCoat.shapes.Square;

public class CustomerParser {

    /**
     * This function takes the customer object in its parameters then
     * transforms the objects fields values into a format that can be added
     * to the paint_coverage_information.csv file
     * @param customer
     * @return Customer string formatted for the text file
     */
    protected static String getCustomerString(Customer customer) {
        StringBuilder string = new StringBuilder();

        if (customer instanceof GeneralPublic) {
            string.append(((GeneralPublic) customer).getCustName());
            string.append(";" + ((GeneralPublic) customer).getCustType());
        } else {
            string.append(((TradeCustomer) customer).getTradeName());
            string.append(";" + ((TradeCustomer) customer).getCustType());
        }

        string.append(";" + customer.getCustAddress());
        string.append(";" + customer.getCustTelNo());
        string.append(";" + customer.getSurfaceArea());

        if (customer instanceof GeneralPublic) {
            string.append(";" + ((GeneralPublic) customer).getRoomShape().getShapeName());
            string.append(";" + String.valueOf(((GeneralPublic) customer).getRoomShape().getHeight()));
            string.append(";" + String.valueOf(((GeneralPublic) customer).getRoomShape().getWidth()));
        } else {
            string.append(";NA");
            string.append(";NA");
            string.append(";NA");
        }

        string.append(";" + String.valueOf(customer.calculatePaintCoverage()));
        return string.toString();
    }

    public static Customer createGeneralCustomerObject(String[] customerInformationArray) {

        Shape shape;
        double height = Double.valueOf(customerInformationArray[6]);
        double width = Double.valueOf(customerInformationArray[7]);

        switch (Shape.ShapeEnum.valueOf(customerInformationArray[5])) {  // shapeType
            case SQUARE:
                shape = new Square(height, width);
                break;
            case RECTANGLE:
                double length = Double.valueOf(customerInformationArray[8]);
                shape = new Rectangle(height, width, length);
                break;
            case CYLINDER:
                shape = new Cylinder(height, width);
                break;
            default:
                shape = null;
        }

        return new GeneralPublic(
                customerInformationArray[0] // customerName
                , customerInformationArray[2] // customerAddress
                , customerInformationArray[3] // customerTelNo
                , shape  // shape: CYLINDER:SQUARE(height, width) RECTANGLE(height,width,length)
        );
    }

    public static Customer createTradeCustomerObject(String[] customerInformationArray) {

        return new TradeCustomer(
                customerInformationArray[0] // customerName
                , customerInformationArray[2] // customerAddress
                , customerInformationArray[3] // customerTelNo
                , Double.valueOf(customerInformationArray[4]) // customerSurfaceArea
        );
    }
}

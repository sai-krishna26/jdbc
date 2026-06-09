package com.xworkz.transDetail.PaymentStatus;

public class GetPaymentStatus{
    public static void main(String[] args) {
        System.out.println("checking GetPaymentStatus class existence");
        try
        {
            Class.forName("com.xworkz.transDetail.statementDetails.GetStatementDetails");
            System.out.println("GetPaymentStatus is found!!");
        }
        catch(ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}

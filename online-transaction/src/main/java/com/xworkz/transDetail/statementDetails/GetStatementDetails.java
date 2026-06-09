package com.xworkz.transDetail.statementDetails;

public class GetStatementDetails {
    public static void main(String[] args) {
        System.out.println("checking GetStatementDetails class existence");
        try{
            Class.forName("com.xworkz.transDetail.recieverDeatails.GetReceiverDetails");
            System.out.println("GetStatementDetails is found!!");
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}

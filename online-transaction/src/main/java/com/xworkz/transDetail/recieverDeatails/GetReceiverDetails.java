package com.xworkz.transDetail.recieverDeatails;

public class GetReceiverDetails
{
    public static void main(String[] args) {
        System.out.println("checking the GetReceiverDetails class existence");
        try{
            Class.forName("com.xworkz.transDetail.platformDetails.GetPlatformDetails");
            System.out.println("GetReceiverDetails is found!!");
        }
        catch(ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}

package com.xworkz.transDetail.senderDeatails;

public class GetSenderDetails {
    public static void main(String[] args) {
        System.out.println("checking GetSenderDetails class existence");
        try {
            Class.forName("com.xworkz.transDetail.recieverDeatails.GetReceiverDetails");
            System.out.println("GetSenderDetails found!!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

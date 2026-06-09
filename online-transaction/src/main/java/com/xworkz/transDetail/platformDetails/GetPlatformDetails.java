package com.xworkz.transDetail.platformDetails;

public class GetPlatformDetails {
    public static void main(String[] args) {
        System.out.println("checking the GetPlatformDetails class existence");
        try {
            Class.forName("com.mysql.cj.jdbc.Drive");
            System.out.println("GetPlatformDetails is found!!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


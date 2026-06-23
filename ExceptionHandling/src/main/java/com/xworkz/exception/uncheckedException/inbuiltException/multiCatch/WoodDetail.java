package com.xworkz.exception.uncheckedException.inbuiltException.multiCatch;

public class WoodDetail {
    public int getDetails(int size, String woodType)
    {
        try
        {
            int sizePerPeice=size/4;
            woodType.trim();
        }
        catch(NullPointerException | ArithmeticException e)
        {
            System.err.println("exception type:NullPointerException,ArithmeticException \nmessage: "+e.getMessage());
        }
        return -1;
    }
}

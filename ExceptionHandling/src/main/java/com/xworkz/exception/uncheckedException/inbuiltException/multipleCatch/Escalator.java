package com.xworkz.exception.uncheckedException.inbuiltException.multipleCatch;

import java.sql.SQLOutput;

public class Escalator {
    public int getSolution(int number, int index)
    {
        try{
            int arr[]={1,2,4,5,6,7};
            int value=arr[index];
            int solution=number/0;

        }
        catch (ArithmeticException e)
        {
            System.err.println("exception type: ArithmeticException, message: "+e.getMessage());
        }

        catch (ArrayIndexOutOfBoundsException e)
        {
            System.err.println("exception type: ArrayIndexOutOfBoundsException, message: "+e.getMessage());
        }
        return number;
    }

}

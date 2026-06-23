package com.xworkz.exception.checkedException.inbuiltException.singleCatch;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class LongOn {
    public static void main(String... values)
    {
        try
        {
            FileReader fileReader=new FileReader("sampoorn.txt");
            fileReader.toString();

        }
        catch(FileNotFoundException e){
            System.err.println("single catch,message:"+e.getMessage());
    }
    }
}

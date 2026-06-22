package com.xworkz.exception.checkedException;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@AllArgsConstructor
public class Library{

    File file;

    public void getFile() throws FileNotFoundException
    {
        try{
            FileReader fileReader=new FileReader(file);
            System.out.println("File found successfully");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("give a valid file name");
            throw new FileNotFoundException();
        }
    }
}

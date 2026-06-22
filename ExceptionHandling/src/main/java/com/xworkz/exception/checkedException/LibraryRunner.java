package com.xworkz.exception.checkedException;

import java.io.File;
import java.io.FileNotFoundException;

public class LibraryRunner {
    public static void main(String[] args){
        File file=new File("Resume.pdf");
        Library library=new Library(file);

        try {
            library.getFile();
            System.out.println("got a file");
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            throw new RuntimeException(e);
        }
    }
}

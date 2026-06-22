package com.xworkz.exception.uncheckedException;

public class Action {
    String variable;
    public Action(String variable)
    {
        this.variable=variable;
    }
    public int doubleAction()
    {
        int length=0;
        try{
            length=variable.length();
        }
        //unchecked exception
        catch (NullPointerException e)
        {
            System.out.println("variable should not be null");
            throw new NullPointerException();
        }
        return length;
    }
}

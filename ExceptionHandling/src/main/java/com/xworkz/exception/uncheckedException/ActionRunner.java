package com.xworkz.exception.uncheckedException;

public class ActionRunner{
    public static void main(String... values)
    {
        Action action=new Action("king_fisherman".trim());
        int len=action.doubleAction();
        System.out.println("length of the "+action.variable+" is: "+len);
    }
}

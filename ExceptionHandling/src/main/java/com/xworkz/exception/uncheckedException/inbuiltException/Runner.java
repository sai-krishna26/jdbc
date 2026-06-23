package com.xworkz.exception.uncheckedException.inbuiltException;

import com.xworkz.exception.uncheckedException.inbuiltException.multiCatch.WoodDetail;
import com.xworkz.exception.uncheckedException.inbuiltException.multipleCatch.Escalator;
import com.xworkz.exception.uncheckedException.inbuiltException.singleCatch.MobileHolder;

public class Runner {

    public static void main(String[] args) {
        //MobileHolder mobileHolder=new MobileHolder();
        //mobileHolder.getName(null);

//        Escalator escalator=new Escalator();
//        escalator.getSolution(80,8);

        WoodDetail woodDetail=new WoodDetail();
        woodDetail.getDetails(20,null);
    }
}

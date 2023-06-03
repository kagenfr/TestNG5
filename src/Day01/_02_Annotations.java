package Day01;

import org.testng.annotations.*;

public class _02_Annotations {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod çalıştı");


    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod çalıştı");


    }



    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass çalıştı");


    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass çalıştı");


    }

//    @BeforeTest
//    public void zbeforeTest(){
//        System.out.println("beforeTest çalıştı");
//
//
//    }
//    @AfterTest
//    public void afterTest(){
//        System.out.println("afterTest çalıştı");
//
//
//    }


    @Test
    public void Test1(){
        System.out.println("test1 çalıştı");

    }
    @Test
    public void Test2(){
        System.out.println("test2 çalıştı");


    }

}

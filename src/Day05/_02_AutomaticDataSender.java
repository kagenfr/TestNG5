package Day05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

    /*
        * Aşağıdaki ikili ile Dataproviderın içindeki bütün veriler tek tek test e gönderilerek
        * data sayısı kadar test çalıştırılır, dataların olduğu yere DataProvider annottion ı konur.
        * çalıştırılacak teste ise dataProvider = "getData"  bölümü eklenir.
        * Dataprovider bir testi birden fazla DATA ile çok çalıştırmak için kullanılır.
        * XML filer file gruplama, pararalel, ve farklı tesleri koordine edip birarada çalıştırmak için kullanılır.
    */

public class _02_AutomaticDataSender {



    @Test(dataProvider = "datalarim")
    void UserNameTest(String useradi){
        System.out.println("useradi = " + useradi);



    }
    @DataProvider // bu metoda dataprovider görevi verildi.
    public Object[] datalarim(){ // DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.


        Object[] userlar = {"Etka","Emir","Enes","Erva"};

        return userlar;

    }
}

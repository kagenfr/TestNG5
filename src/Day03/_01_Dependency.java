package Day03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {

    @Test
    void startCar() {
        System.out.println("startCar");
        //Assert.fail();
    }

    // bu testin çalışması, startCar ın hatasız çalışmasına bağlı
    @Test(dependsOnMethods = {"startCar"})
    void driveCar() {
        System.out.println("driveCar");
    }

    @Test(dependsOnMethods = {"startCar", "driveCar"})
    void parkCar() {
        System.out.println("parkCar");
    }

    //alwaysRun = true bağımlılıkları var ama hata çıksa bile çalışır
    @Test(dependsOnMethods = {"parkCar"}, alwaysRun = true)
    void stopCar() {
        System.out.println("stopCar");
    }

    // aynı seviyedeki testleri için priority verilebilir.
    // bağımlı testler, direk metodundan çalıştırdığınızda bağımlı olduğu metod zincirinde
    // 2 üste kadar ototmatik çağırıp çalışabilir.


}

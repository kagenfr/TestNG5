package Day05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_DataProvider_CokBoyutlu {
    @Test(dataProvider = "UserData")
    void UsernameTest(String username, String password) {
        System.out.println("user = " + username + " " + password);
    }

    @DataProvider
    public Object[][] UserData() {
        Object[][] data = {
                {"Etka", "12345"},
                {"Emir", "112233"},
                {"Enes", "ererer"},
                {"Erva", "erer1212"}
        };
        return data;
    }

}

package Day07;

import Day06._03_PlaceOrderElements;
import Utility.BaseDriver;
import Utility.Tools;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _02_WishList_POM extends BaseDriver {
    @Test
    @Parameters("searchText")
    void addToWishList(String text) {
        _03_PlaceOrderElements poe = new _03_PlaceOrderElements();
        poe.searchBox.sendKeys(text);
        poe.searchButton.click();

        _03_WishList_Elements wle = new _03_WishList_Elements();

        int randomSecim = Tools.RandomGenerator(wle.searchResult.size()); // 0,1,2,3

        String wishItemText = wle.searchResult.get(randomSecim).getText(); // tıklatılacak elemanın ismini aldım

        wle.wishBtnList.get(randomSecim).click();  // random elementin wish listine tıklattım

        wle.btnWisthProducts.click();

        Tools.listContainString(wle.wishTableNames, wishItemText);
    }
}
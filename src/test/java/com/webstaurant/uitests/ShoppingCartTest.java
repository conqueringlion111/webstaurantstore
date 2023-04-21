package com.webstaurant.uitests;

import com.webstaurant.testcommon.TestCore;
import org.testng.annotations.Test;

public class ShoppingCartTest extends TestCore {

    @Test(dataProvider = "dataProvider", description = "test coverage for adding product to the cart")
    public void verifyAddProductToCartSuccessful(String searchText) {
        homepage.fillOutSearchField(searchText)
                .clickSearchButton()
                .navigateToLastPage()
                .setLastItemName()
                .addLastItemToCart()
                .acceptProductAccessorySubmitIfPresentV2()
                .clickViewShoppingCart()
                .verifyItemAddedToCartSuccessful();
    }

    @Test(dataProvider = "dataProvider", description = "test coverage for removing product from the cart")
    public void verifyRemoveProductFromCartSuccessful(String searchText, String message) {
        homepage.fillOutSearchField(searchText)
                .clickSearchButton()
                .navigateToLastPage()
                .setLastItemName()
                .addLastItemToCart()
                .acceptProductAccessorySubmitIfPresentV2()
                .clickViewShoppingCart()
                .removeAllItemsFromCart()
                .selectEmptyCartFromPopUp()
                .verifyRemoveAllItemsFromCartSuccessful(message);
    }

}

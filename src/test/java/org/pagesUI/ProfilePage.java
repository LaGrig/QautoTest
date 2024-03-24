package org.pagesUI;

import org.openqa.selenium.By;

public class ProfilePage extends Web {
    private final String sidebarProfileLink = "//a [@class='btn btn-white btn-sidebar sidebar_btn -profile' and @href='/panel/profile']";


    public void gotoProfilePage(){
        driver.findElement(By.xpath(sidebarProfileLink)).click();
    }

}

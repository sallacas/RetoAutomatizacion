package starter.ui.business;

import org.openqa.selenium.By;

public class BusinessOverview {

    public static By NEW_BUTTON = By.xpath("//span[@class='button-inner']");
    public static By NAME_BOX = By.name("Name");
    public static By DROPDOWN_1 = By.xpath("//a[@href='javascript:void(0)']");
    public static By PARENT_BOX = By.xpath("//div[@class='select2-search']/input");
    public static By SAVE_BUTTON = By.xpath("//div[@class='tool-button save-and-close-button icon-tool-button']/div/span");
    public static By REFRESH_BUTTON = By.xpath("//div[@title='Refresh']");
    public static By DOWN = By.xpath("//div[@class='slick-cell l1 r1']/a[text()='Technology']");

    public By asd (String name){
        By hola = By.xpath("//a[text()='"+name+"']");
        return hola;
    }

}

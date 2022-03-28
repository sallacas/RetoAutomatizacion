package starter.ui.dashboard;

import org.openqa.selenium.By;

public class DashboardOverview {
    //Matcher
    public static By DASHBOARD_TITLE = By.xpath("//*[@id=\"s-DashboardPage\"]/main/section/section/h1");
    //Business section
    public static By ORG_OPTION = By.xpath("//a[@href='#nav_menu1_3_1']");
    public static By BUSINESS_UNIT = By.xpath("//*[@id=\"nav_menu1_3_1\"]/li[1]/a");
    //Meeting section
    public static By MET_OPTION = By.xpath("/html/body/aside/div[2]/div[2]/div[1]/ul/li[3]/ul/li[2]/a");
    public static By MEETINGS = By.xpath("//*[@id=\"nav_menu1_3_2\"]/li[1]/a");
}

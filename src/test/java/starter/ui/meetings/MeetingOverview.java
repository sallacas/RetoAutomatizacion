package starter.ui.meetings;

import org.openqa.selenium.By;

public class MeetingOverview {

    //Buttons
    public static By NEW_MEETING_BUTTON = By.xpath("//div[@class='tool-button add-button icon-tool-button']/div/span");
    public static By SAVE_BUTTON = By.xpath("//div[@class='tool-button save-and-close-button icon-tool-button']/div/span");
    public static By REFRESH_BUTTON = By.xpath("//div[@title='Refresh']");
    //Meeting Form
    public static By DROPDOWN_BOX = By.xpath("//div[@id='select2-drop']/div/input");

    public static By MEETING_NAME = By.name("MeetingName");
    public static By MEETING_TYPE_SELECT= By.xpath("//div[@class='field MeetingTypeId col-sm-6']/div/a");
    public static By MEETING_NUMBER = By.name("MeetingNumber");

    public static By START_DATE = By.name("StartDate");
    public static By TIME_START_DATE = By.xpath("//div[@class='field StartDate col-sm-6']/select");

    public static By END_DATE = By.name("EndDate");
    public static By TIME_END_DATE = By.xpath("//div[@class='field EndDate col-sm-6']/select");

    public static By LOCATION = By.xpath("//div[@class='field LocationId col-sm-6']/div/a");

    public static By UNIT = By.xpath("//div[@class='field UnitId col-sm-6']/div/a");

    public static By ORGANIZED_BY = By.xpath("//div[@class='field OrganizerContactId col-sm-6']/div/a");

    public static By REPORTER = By.xpath("//div[@class='field ReporterContactId col-sm-6']/div/a");

    public static By ATTENDEES = By.xpath("//div[@class='field AttendeeList']/div/div/div/a");

}

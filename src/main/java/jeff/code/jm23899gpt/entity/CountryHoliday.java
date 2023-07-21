package jeff.code.jm23899gpt.entity;

import lombok.Getter;
import lombok.Setter;

//lombok annotations
@Getter
@Setter
public class CountryHoliday {
    //generate student fields
    private String countryCode;
    private String countryName;
    private String holidayDate;
    private String holidayName;

    public String toCSVString() {
        return (countryCode + "," + countryName + "," + holidayDate + "," + holidayName + "\r\n");
    }

    public String toPrimaryKey() {
        return (countryCode + "," + holidayDate);
    }

}

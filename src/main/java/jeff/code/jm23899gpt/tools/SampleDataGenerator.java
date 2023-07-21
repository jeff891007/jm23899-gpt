package jeff.code.jm23899gpt.tools;

import jeff.code.jm23899gpt.entity.CountryHoliday;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SampleDataGenerator {
    public static void main(String[] args) throws IOException, URISyntaxException {
        generateSampleData();
    }

    //generate a csv file with 100 rows of sample data of four column CountryCode, CountryName, HolidayDate, HolidayName
    public static void generateSampleData() throws IOException, URISyntaxException {
        //generate an array of 100 CountryCodes
        String[] countryCode = {"AFG", "ALB", "DZA", "ASM", "AND", "AGO", "AIA", "ATA", "ATG", "ARG", "ARM", "ABW", "AUS", "AUT", "AZE", "BHS", "BHR", "BGD", "BRB", "BLR", "BEL", "BLZ", "BEN", "BMU", "BTN", "BOL", "BES", "BIH", "BWA", "BVT", "BRA", "IOT", "BRN", "BGR", "BFA", "BDI", "KHM", "CMR", "CAN", "CPV", "CYM", "CAF", "TCD", "CHL", "CHN", "CXR", "CCK", "COL", "COM", "COG", "COD", "COK", "CRI", "HRV", "CUB", "CUW", "CYP", "CZE", "CIV", "DNK", "DJI", "DMA", "DOM", "ECU", "EGY", "SLV", "GNQ", "ERI", "EST", "SWZ", "ETH", "FLK", "FRO", "FJI", "FIN", "FRA", "GUF", "PYF", "ATF", "GAB", "GMB", "GEO", "DEU", "GHA", "GIB", "GRC", "GRL", "GRD", "GLP", "GUM", "GTM", "GGY", "GIN", "GNB", "GUY", "HTI"};
        //generate an array of  CountryNames
        String[] countryName = {"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica (the territory South of 60 deg S)", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", " Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", " Bhutan", "Bolivia", "Bonaire", "Bosnia and Herzegovina", "Botswana", "Bouvet Island (Bouvetoya)", "Brazil", "British Indian Ocean Territory (Chagos Archipelago)", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", " Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cura�ao", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", " Eritrea", "Estonia", "Ethiopia", "Faroe Islands", "Falkland Islands (Malvinas)", "Fiji", "Finland", "France", "French Guiana", "French Polynesia", "French Antarctic Territory", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", " Guam", "Guatemala", "Guernsey", "Guinea", "Guinea-Bissau", "Guyana", "Haiti"};


        //generate an array of 100 sample dates  in yyyy-MM-dd format
        String[] sampleDate = {"2020-01-01", "2020-01-24", "2020-02-24", "2020-03-01", "2020-04-10", "2020-05-01", "2020-06-01", "2020-07-01", "2020-08-01", "2020-09-01", "2020-10-01", "2020-11-01", "2020-12-25", "2020-01-01", "2020-01-24", "2020-02-24", "2020-03-01", "2020-04-10", "2020-05-01", "2020-06-01", "2020-07-01", "2020-08-01", "2020-09-01", "2020-10-01", "2020-11-01", "2020-12-25", "2020-01-01", "2020-01-24", "2020-02-24", "2020-03-01", "2020-04-10", "2020-05-01", "2020-06-01", "2020-07-01", "2020-08-01", "2020-09-01", "2020-10-01", "2020-11-01", "2020-12-25", "2020-01-01", "2020-01-24", "2020-02-24", "2020-03-01", "2020-04-10", "2020-05-01", "2020-06-01", "2020-07-01", "2020-08-01", "2020-09-01", "2020-10-01", "2020-11-01", "2020-12-25", "2020-01-01", "2020-01-24", "2020-02-24", "2020-03-01", "2020-04-10", "2020-05-01", "2020-06-01", "2020-07-01", "2020-08-01"};
        //generate an array of 100 HolidayName
        String[] holidayName = {"New Year's Day", "Chinese New Year", "Emperor's Birthday", "Independence Movement Day", "Good Friday", "Labor Day", "Children's Day", "Canada Day", "Bank Holiday", "Labor Day", "National Day", "All Saints' Day", "Christmas Day", "New Year's Day", "Chinese New Year", "Emperor's Birthday", "Independence Movement Day", "Good Friday", "Labor Day", "Children's Day", "Canada Day", "Bank Holiday", "Labor Day", "National Day", "All Saints' Day", "Christmas Day", "New Year's Day", "Chinese New Year", "Emperor's Birthday", "Independence Movement Day", "Good Friday", "Labor Day", "Children's Day", "Canada Day", "Bank Holiday", "Labor Day", "National Day", "All Saints' Day", "Christmas Day", "New Year's Day", "Chinese New Year", "Emperor's Birthday", "Independence Movement Day", "Good Friday", "Labor Day", "Children's Day", "Canada Day", "Bank Holiday", "Labor Day", "National Day", "All Saints' Day", "Christmas Day", "New Year's Day", "Chinese New Year", "Emperor's Birthday", "Independence Movement Day", "Good Friday", "Labor Day", "Children's Day", "Canada Day", "Bank Holiday"};
        //generate an list of CountryHoliday objects
        List<CountryHoliday> countryHolidayList = new ArrayList<>();
        //generate 100 rows of sample data
        HashSet<String> sampleDataSet = new HashSet<>();
        //generate 100 rows of sample data
        while (countryHolidayList.size() < 100) {

            //generate a random number between 0 and 30
            int randomCountry = (int) (Math.random() * 30);
            //generate a random number between 0 and 50
            int randomDate = (int) (Math.random() * 50);
            //create a new CountryHoliday object
            CountryHoliday countryHoliday = new CountryHoliday();
            //set the CountryCode
            countryHoliday.setCountryCode(countryCode[randomCountry]);
            //set the CountryName
            countryHoliday.setCountryName(countryName[randomCountry]);
            //set the HolidayDate
            countryHoliday.setHolidayDate(sampleDate[randomDate]);
            //set the HolidayName
            countryHoliday.setHolidayName(holidayName[randomDate]);
            //add the CountryHoliday object to the sampleDataSet
            if(sampleDataSet.contains(countryHoliday.toPrimaryKey())){
                continue;
            }else{
                sampleDataSet.add(countryHoliday.toPrimaryKey());

            }
            countryHolidayList.add(countryHoliday);
        }
        //write the sample data to HolidayData.csv
        //write the data
        for (CountryHoliday countryHoliday : countryHolidayList) {
            //write the data to file
            Files.write(Paths.get(SampleDataGenerator.class.getClassLoader().getResource("HolidayData.csv").toURI()), countryHoliday.toCSVString().getBytes(), StandardOpenOption.APPEND);

        }


    }

}

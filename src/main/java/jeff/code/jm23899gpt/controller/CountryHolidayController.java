package jeff.code.jm23899gpt.controller;

import jeff.code.jm23899gpt.entity.CountryHoliday;
import jeff.code.jm23899gpt.tools.SampleDataGenerator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/holiday")
public class CountryHolidayController
{
    //Add a new holiday
    @RequestMapping("/addHoliday")
    public String addHoliday(@RequestBody List<CountryHoliday> countryHolidayList) throws Exception {
        //write the data
        for (CountryHoliday countryHoliday : countryHolidayList) {
            //write the data to file
            Files.write(Paths.get(SampleDataGenerator.class.getClassLoader().getResource("HolidayData.csv").toURI()), countryHoliday.toCSVString().getBytes(), StandardOpenOption.APPEND);
        }

        return "Added a new holiday";
    }


    //Update multiple Holiday
    @RequestMapping("/updateHoliday")
    public String updateHoliday(@RequestBody List<CountryHoliday> countryHolidayList) throws Exception {
        //read the data
        List<String> lines = Files.readAllLines(Paths.get(SampleDataGenerator.class.getClassLoader().getResource("HolidayData.csv").toURI()));
        //update the data
        for (CountryHoliday countryHoliday : countryHolidayList) {
            //update the data
            for (int i = 0; i < lines.size(); i++) {
                //split the line
                String[] line = lines.get(i).split(",");
                //check if the CountryCode and HolidayDate match
                if (line[0].equals(countryHoliday.getCountryCode()) && line[2].equals(countryHoliday.getHolidayDate())) {
                    //update the data
                    lines.set(i, countryHoliday.toCSVString());
                }
            }
        }
        //write the data
        Files.write(Paths.get(SampleDataGenerator.class.getClassLoader().getResource("HolidayData.csv").toURI()), lines);

        return "Updated multiple holidays";
    }

    //Delete multiple Holiday
    @RequestMapping("/deleteHoliday")
    public String deleteHoliday(@RequestBody List<CountryHoliday> countryHolidayList) throws Exception {
        //read the data
        List<String> lines = Files.readAllLines(Paths.get(SampleDataGenerator.class.getClassLoader().getResource("HolidayData.csv").toURI()));
        //delete the data
        for (CountryHoliday countryHoliday : countryHolidayList) {
            //delete the data
            for (int i = 0; i < lines.size(); i++) {
                //split the line
                String[] line = lines.get(i).split(",");
                //check if the CountryCode and HolidayDate match
                if (line[0].equals(countryHoliday.getCountryCode()) && line[2].equals(countryHoliday.getHolidayDate())) {
                    //delete the data
                    lines.remove(i);
                }
            }
        }
        //write the data
        Files.write(Paths.get(SampleDataGenerator.class.getClassLoader().getResource("HolidayData.csv").toURI()), lines);
        return "Deleted multiple holidays";
    }


    //Get next year's holiday for a given country based on system date
    @RequestMapping("/getNextYearHolidays")
    public List<String> getNextYearHolidays(@RequestParam String countryCode) throws Exception {
        List<String> results = new ArrayList<>();
        //read the data
        List<String> lines = Files.readAllLines(Paths.get(SampleDataGenerator.class.getClassLoader().getResource("HolidayData.csv").toURI()));
        // transform lines into CountryHoliday objects
        List<CountryHoliday> countryHolidayList = new ArrayList<>();
        for (String line : lines) {
            //split the line
            String[] lineArray = line.split(",");
            //create a new CountryHoliday object
            CountryHoliday countryHoliday = new CountryHoliday();
            //set the CountryCode
            countryHoliday.setCountryCode(lineArray[0]);
            //set the CountryName
            countryHoliday.setCountryName(lineArray[1]);
            //set the HolidayDate
            countryHoliday.setHolidayDate(lineArray[2]);
            //set the HolidayName
            countryHoliday.setHolidayName(lineArray[3]);
            //add the CountryHoliday object to the list
            countryHolidayList.add(countryHoliday);
        }

        //get the next year
        int nextYear = LocalDate.now().getYear() + 1;
        //get the next year's holidays
        for (int i = 0; i < countryHolidayList.size(); i++) {
            //check year
            if (Integer.parseInt(countryHolidayList.get(i).getHolidayDate().substring(0, 4)) == nextYear) {
                //check CountryCode
                if (countryHolidayList.get(i).getCountryCode().equals(countryCode)) {
                    //add the HolidayName to the list
                    results.add(countryHolidayList.get(i).getHolidayName());
                }
            }
        }
        //return the list
        return results;
    }

    //Get next holiday for a given country code
    @RequestMapping("/getNextHoliday")
    public String getNextHoliday(@RequestParam String countryCode) throws Exception {
        //read the data
        List<String> lines = Files.readAllLines(Paths.get(SampleDataGenerator.class.getClassLoader().getResource("HolidayData.csv").toURI()));
        // transform lines into CountryHoliday objects
        List<CountryHoliday> countryHolidayList = new ArrayList<>();
        for (String line : lines) {
            //split the line
            String[] lineArray = line.split(",");
            //create a new CountryHoliday object
            CountryHoliday countryHoliday = new CountryHoliday();
            //set the CountryCode
            countryHoliday.setCountryCode(lineArray[0]);
            //set the CountryName
            countryHoliday.setCountryName(lineArray[1]);
            //set the HolidayDate
            countryHoliday.setHolidayDate(lineArray[2]);
            //set the HolidayName
            countryHoliday.setHolidayName(lineArray[3]);
            //add the CountryHoliday object to the list
            countryHolidayList.add(countryHoliday);
        }
        List<CountryHoliday> filteredList = new ArrayList<>();
        //get the next holiday
        for (int i = 0; i < countryHolidayList.size(); i++) {
            //check if the CountryCode match
            if (countryHolidayList.get(i).getCountryCode().equals(countryCode)) {
                //check if the HolidayDate is after today
                if (LocalDate.parse(countryHolidayList.get(i).getHolidayDate()).isAfter(LocalDate.now())) {
                    //return the HolidayName
                    filteredList.add(countryHolidayList.get(i));
                }
            }
        }
        //sort fileteredList by HolidayDate
        Collections.sort(filteredList,  (o1, o2) -> LocalDate.parse(o1.getHolidayDate()).compareTo(LocalDate.parse(o2.getHolidayDate())));
        //return the first element
        if (filteredList.size() > 0) {
            return filteredList.get(0).getHolidayName();
        }
        //return null if no holiday found
        return null;
    }

    //check if a given date is a holiday
    @RequestMapping("/isHoliday")
    public List<CountryHoliday> isHoliday(@RequestParam String date) throws URISyntaxException, IOException {

        //validate Date format
        LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));


        //read the data
        List<String> lines = Files.readAllLines(Paths.get(SampleDataGenerator.class.getClassLoader().getResource("HolidayData.csv").toURI()));
        // transform lines into CountryHoliday objects
        List<CountryHoliday> countryHolidayList = new ArrayList<>();
        for (String line : lines) {
            //split the line
            String[] lineArray = line.split(",");
            //create a new CountryHoliday object
            CountryHoliday countryHoliday = new CountryHoliday();
            //set the CountryCode
            countryHoliday.setCountryCode(lineArray[0]);
            //set the CountryName
            countryHoliday.setCountryName(lineArray[1]);
            //set the HolidayDate
            countryHoliday.setHolidayDate(lineArray[2]);
            //set the HolidayName
            countryHoliday.setHolidayName(lineArray[3]);
            //add the CountryHoliday object to the list
            countryHolidayList.add(countryHoliday);
        }

        List<CountryHoliday> results = new ArrayList<>();
        //check if the date is a holiday
        for (int i = 0; i < countryHolidayList.size(); i++) {
            //check if the HolidayDate match
            if (countryHolidayList.get(i).getHolidayDate().equals(date)) {
                //return true if the date is a holiday
                results.add(countryHolidayList.get(i));
            }
        }
        //return false if the date is not a holiday
        return results;
    }



}

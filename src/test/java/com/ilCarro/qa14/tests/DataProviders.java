package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.models.Car;
import com.ilCarro.qa14.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> validUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"fSara","sSara","fSara6@gmail.com","Ff12345678"});
        list.add(new Object[]{"fSara","sSara","fSara7@gmail.com","Ff12345678"});
        list.add(new Object[]{"fSara","sSara","fSara8@gmail.com","Ff12345678"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validUserFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/tests_NewUser.csv")));
        String line = reader.readLine();
        while(line!=null) {


            String[] split = line.split(",");
            list.add(new Object[]{new User().withFirstName(split[0]).withSecondName(split[1])
                    .withEmail(split[2]).withPassword(split[3])});
            line = reader.readLine();
        }
        return list.iterator();

    }
    @DataProvider
    public Iterator<Object[]> validCarFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/tests_NewCar.csv")));
        String line = reader.readLine();
        while(line!=null) {


            String[] split = line.split(",");
            list.add(new Object[]{new Car().setCountry(split[0]).setAddress(split[1]).setDistance(split[2])});
            line = reader.readLine();
        }
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> validRegisteredUserFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/tests_DataUserLogin.csv")));
        String line = reader.readLine();
        while(line!=null) {


            String[] split = line.split(",");
            list.add(new Object[]{new User().withFirstName(split[0]).withSecondName(split[1])
                    .withEmail(split[2]).withPassword(split[3])});
            line = reader.readLine();
        }
        return list.iterator();

    }
    @DataProvider
    public Iterator<Object[]> invalidRegisteredUserFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/tests_DataUserLogin.csv")));
        String line = reader.readLine();
        while(line!=null) {


            String[] split = line.split(",");
            list.add(new Object[]{new User().withFirstName(split[0]).withSecondName(split[1])
                    .withEmail(split[2]).withPassword(split[3])});
            line = reader.readLine();
        }
        return list.iterator();

    }

}

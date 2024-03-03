package org.example;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Test.*;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    City city = new City("Tokyo","Japan");
    City city2 = new City("Okinawa","Japan");
    City city3 = new City("Shinobu","Japan");
    //This test shows that number of cities added is correct or not.
    @Test
    public void testcount()
    {
        CityList cl = new CityList();
        cl.add(city);
        cl.add(city2);
        assertEquals(2,cl.Count());
    }

    //This test shows that the number of cities is reduced after deleting indicating success.
    @Test
    public void testdelete()
    {
        CityList cl = new CityList();
        cl.add(city);
        cl.add(city2);
        cl.add(city3);

        cl.delete(city2);
        assertEquals(2,cl.Count());
        //ekhane 3 ta city chilo. 1 ta delete dewar por 2 ta hoise.
    }

    //This test handles the case where an exception is thrown if a city is selected to be deleted,
    // but doesn't exist in the list of cities.
    @Test
    public void testdeleteexception()
    {
        CityList cl = new CityList();
        cl.add(city);
        assertThrows(IllegalArgumentException.class,() -> {
            cl.delete(city3);
        });
        //ekhane city3 delete dite gesi, jeta adou list e nai
    }

    //This test shows that no matter in what order cities are added,
    // the list remains in sorted order (based on city name)
    @Test
    public void testsort()
    {
        CityList cl = new CityList();
        cl.add(city3);
        cl.add(city);
        cl.add(city2);

        List<City> sortedCities = cl.getCities();

        for (int i = 0; i < sortedCities.size() - 1; i++) {
            assertTrue(sortedCities.get(i).compareTo(sortedCities.get(i + 1)) <= 0);
        }
    }
    //In my City.java file I have created a function that tests whether one city is lexicographically
    //smaller than other city (compareto() function)
    // Ekhane ami ekta loop chalaisi jekhane ei function use kore dekhe je pashapashi duita city
    //sorted akare ase kina. jodi sobgula thik thake taile test success.
}
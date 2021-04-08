import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();

        findPlanesLeavingInTheNextTwoHours(airport);

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        int HOUR = 3600 * 1000;
        Date nowDate = new Date();
        Date setDate = new Date(nowDate.getTime() + 2 * HOUR);
//        System.out.println(nowDate);
//        System.out.println(setDate);

        return airport.getTerminals().stream().flatMap(terminal -> terminal.getFlights().stream()
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE)))
                .filter(flight -> flight.getDate().after(nowDate) && flight.getDate().before(setDate))
                .collect(Collectors.toList());
//                .forEach(System.out::println);

    }

}
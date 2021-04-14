import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class GetShortestRouteTest extends TestCase {

    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    @Override
    protected void setUp() throws Exception {
        stationIndex = new StationIndex();

        Line lineFirst = new Line(1, "First");
        Line lineSecond = new Line(2, "Second");
        Line lineThird = new Line(3, "Third");

        stationIndex = new StationIndex();

        stationIndex.addLine(lineFirst);
        stationIndex.addLine(lineSecond);
        stationIndex.addLine(lineThird);

        Station st1l1 = new Station("L1-ST-1", lineFirst);
        Station st2l1 = new Station("L1-ST-2", lineFirst);

        lineFirst.addStation(st1l1);
        lineFirst.addStation(st2l1);

        Station st1l2 = new Station("L2-ST-1", lineSecond);
        Station st2l2 = new Station("L2-ST-2", lineSecond);
        Station st3l2 = new Station("L2-ST-3", lineSecond);

        Station st4l2 = new Station("L2-ST-4", lineSecond); //!

        lineSecond.addStation(st1l2);
        lineSecond.addStation(st2l2);
        lineSecond.addStation(st3l2);

        lineSecond.addStation(st4l2);                           //!

        Station st1l3 = new Station("L3-ST-1", lineThird);
        Station st2l3 = new Station("L3-ST-2", lineThird);

        lineThird.addStation(st1l3);
        lineThird.addStation(st2l3);

        stationIndex.addStation(st1l1);
        stationIndex.addStation(st2l1);

        stationIndex.addStation(st1l2);
        stationIndex.addStation(st2l2);
        stationIndex.addStation(st3l2);

        stationIndex.addStation(st4l2);                         //!

        stationIndex.addStation(st1l3);
        stationIndex.addStation(st2l3);

        List<Station> connections1= new ArrayList<>();
        connections1.add(st2l1);
        connections1.add(st2l2);
        stationIndex.addConnection(connections1);

        List<Station> connections2= new ArrayList<>();
        connections2.add(st4l2);
        connections2.add(st1l3);
        stationIndex.addConnection(connections2);
    }

    public void test_distance_to_same_station(){

        routeCalculator = new RouteCalculator(stationIndex);

        Station stationFrom = stationIndex.getStation("L1-ST-1");
        Station stationTo = stationIndex.getStation("L1-ST-1");

        String str = "";

        for (Station items : routeCalculator.getShortestRoute(stationFrom, stationTo)){
            str += items  + "\n";
        }

        String actual = str;
        String expected = "L1-ST-1\n";
        assertEquals(expected, actual);
    }

    public void test_stations_next_to_each_other_on_single_line(){

        routeCalculator = new RouteCalculator(stationIndex);

        Station stationFrom = stationIndex.getStation("L1-ST-1");
        Station stationTo = stationIndex.getStation("L1-ST-2");

        String str = "";

        for (Station items : routeCalculator.getShortestRoute(stationFrom, stationTo)){
            str += items  + "\n";
        }

        String actual = str;
        String expected = "L1-ST-1\nL1-ST-2\n";
        assertEquals(expected, actual);
    }

    public void test_opposite_stations_on_single_line(){

        routeCalculator = new RouteCalculator(stationIndex);

        Station stationFrom = stationIndex.getStation("L2-ST-1");
        Station stationTo = stationIndex.getStation("L2-ST-4");


        String str = "";

        for (Station items : routeCalculator.getShortestRoute(stationFrom, stationTo)){
            str += items  + "\n";
        }

        String actual = str;
        String expected = "L2-ST-1\nL2-ST-2\nL2-ST-3\nL2-ST-4\n";
        assertEquals(expected, actual);
    }

    public void test_stations_with_one_transfer(){

        routeCalculator = new RouteCalculator(stationIndex);

        Station stationFrom = stationIndex.getStation("L1-ST-1");
        Station stationTo = stationIndex.getStation("L2-ST-1");


        String str = "";

        for (Station items : routeCalculator.getShortestRoute(stationFrom, stationTo)){
            str += items  + "\n";
        }

        String actual = str;
        String expected = "L1-ST-1\nL1-ST-2\nL2-ST-2\nL2-ST-1\n";
        assertEquals(expected, actual);
    }

    public void test_station_with_two_transfers(){

        routeCalculator = new RouteCalculator(stationIndex);

        Station stationFrom = stationIndex.getStation("L1-ST-1");
        Station stationTo = stationIndex.getStation("L3-ST-2");

        String str = "";

        for (Station items : routeCalculator.getShortestRoute(stationFrom, stationTo)){
            str += items  + "\n";
        }

        String actual = str;
        String expected = "L1-ST-1\nL1-ST-2\nL2-ST-2\nL2-ST-3\nL2-ST-4\nL3-ST-1\nL3-ST-2\n";
        assertEquals(expected, actual);
    }
}

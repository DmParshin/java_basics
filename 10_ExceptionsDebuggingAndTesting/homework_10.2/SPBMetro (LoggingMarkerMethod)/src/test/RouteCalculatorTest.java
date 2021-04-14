import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(2, "Третья");

        route.add(new Station("Первая станция на первой линии", line1));
        route.add(new Station("Вторая станция на первой линии", line1));
        route.add(new Station("Первая станция на второй линии", line2));
        route.add(new Station("Вторая станция на второй линии", line2));
        route.add(new Station("Третья станция на второй линии", line2));
        route.add(new Station("Первая станция на третьей линии", line3));
        route.add(new Station("Вторая станция на третьей линии", line3));

    }

    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 16;
        assertEquals(expected, actual);
    }
}

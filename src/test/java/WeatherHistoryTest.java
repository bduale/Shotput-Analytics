import edu.gmu.datacorrelation.weather.WeatherHistory;
import org.junit.Assert;
import org.junit.Test;

public class WeatherHistoryTest {

    @Test
    public void testCelsiusConversion() {
        WeatherHistory weatherHistory = new WeatherHistory();
        weatherHistory.setDegreesFarenheit(100f);
        Assert.assertEquals(37.7778, weatherHistory.toCelsius(), 0.0001);
        weatherHistory.setDegreesFarenheit(0f);
        Assert.assertEquals(-17.7778, weatherHistory.toCelsius(), 0.0001);
    }
}

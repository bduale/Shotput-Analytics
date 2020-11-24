import edu.gmu.datacorrelation.athlete.Athlete;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class AthleteTest {

    @Test
    public void testDateOfBirth() {
        Athlete athlete = new Athlete();
        athlete.setDob(LocalDate.of(1999, Month.JULY, 12));
        Assert.assertEquals(20, athlete.getAge(LocalDate.of(2019, Month.SEPTEMBER, 12)));
    }
}

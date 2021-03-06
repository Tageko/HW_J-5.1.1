import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndUnderLimit() {

        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);
    }

    @Test
    void shouldCalculateRegisteredAndOverLimit() {

        BonusService service = new BonusService();

        long amount = 36_000_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);
    }

    @Test
    void shouldCalculateUnRegisteredUnderLimit() {

        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);
    }

    @Test
    void shouldCalculateUnregisteredAndZeroLimit() {

        BonusService service = new BonusService();

        long amount = 3000_60;
        boolean registered = false;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);
    }
}
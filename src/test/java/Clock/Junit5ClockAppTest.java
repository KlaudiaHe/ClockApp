package Clock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Junit5ClockAppTest {
    @ParameterizedTest
    @MethodSource("inputProvider")
    void isTimeAlright(int hours, int minutes, int expected1, int expected2) {
//no need to parseInt() the arguments even though they're provided as Strings in inputProvider. Handy
        Clock clock = new Clock(hours, minutes);
        assertEquals(expected1, clock.getHours());
        assertEquals(expected2, clock.getMinutes());}

   private static Stream<Arguments> inputProvider() {
      return Stream.of(
              Arguments.of("21", "15", "21", "15"),
              Arguments.of("23", "59", "23", "59"),
              Arguments.of("21", "15", "21", "15"),
              Arguments.of("11", "34", "11", "34"),
              Arguments.of("0000", "0000", "00", "00"),
              Arguments.of("1", "0", "1", "0"));
   }

    @ParameterizedTest
    @MethodSource("inputProvider2")
    void updateClock(int hours, int minutes, int hours2, int minutes2, int expected1, int expected2) {
//no need to parseInt() the arguments even though they're provided as Strings in inputProvider. Handy
        Clock clock = new Clock(hours, minutes);
        Clock clock2 = new Clock(hours2, minutes2);
        Clock updatedClock= clock.addAnotherClockTime(clock2);
        assertEquals(expected1, updatedClock.getHours());
        assertEquals(expected2, updatedClock.getMinutes());}

    private static Stream<Arguments> inputProvider2() {
        return Stream.of(
                Arguments.of("0", "0", "21", "15", "21", "15"),
                Arguments.of("23", "59", "23", "59", "23", "58"),
                Arguments.of("0", "0", "0", "0", "0", "0"),
                Arguments.of("11", "34", "8", "34", "20", "8"),
                Arguments.of("15", "59", "4", "01", "20", "0"),
                Arguments.of("18", "22", "13", "10", "7", "32"));
    }


    @ParameterizedTest
    @MethodSource("inputProvider3")
    void expectingException(int hours, int minutes) {
//no need to parseInt() the arguments even though they're provided as Strings in inputProvider. Handy
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {        Clock clock = new Clock(hours, minutes);
        });
    }
    private static Stream<Arguments> inputProvider3() {
        return Stream.of(
                Arguments.of("-1", "-1"),
                Arguments.of("-232", "-245"),
                Arguments.of("324", "450"),
                Arguments.of("001000", "0"),
                Arguments.of("-23", "19"),
                Arguments.of("12", "-1"));
    }
}
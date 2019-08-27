package Clock;

public class Clock {

    private int hours;
    private int minutes;

    public Clock(int hours, int minutes) {
        setHours(hours);
        setMinutes(minutes);
        }

    public Clock addAnotherClockTime(Clock another) {
       int updatedHours= this.hours += another.getHours();
       if (another.getHours()==0){
           updatedHours=this.hours;
       }
       if (this.hours == 0){
           updatedHours=another.getHours();
       }
       int updatedMinutes= this.minutes+=another.getMinutes();
        if (updatedMinutes > 59) {
        int modulo= ((updatedMinutes +(hours*60))%60);
        updatedHours= ((updatedMinutes +(hours*60))/60);
        updatedMinutes=modulo; //'member temp?
        }
        if (updatedHours > 23){
            updatedHours=updatedHours-24;
        }
        Clock updatedClock = new Clock(updatedHours, updatedMinutes);
        return updatedClock;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Only integers between 0 and 59 (inclusive)");
        }
        this.minutes = minutes;
    }

    public void setHours(int hours) {
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Only integers between: 0 and 23 (inclusive)");
        }
        this.hours = hours;
    }

    @Override
    public String toString() {
        if ((hours <=9)&& (minutes  <=9)){
            return "Clock: 0" +
                    +hours +
                    ".0" + minutes;
        }
        if ((hours >9)&& (minutes  <=9)){
            return "Clock: " +
                    +hours +
                    ".0" + minutes;
        }
        if ((hours <=9)&& (minutes  >9)){
            return "Clock: 0" +
                    +hours +
                    "." + minutes;
        }   else {
            return "Clock: " +
                    + hours +
                    "." + minutes;
        }
    }
}
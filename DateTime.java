import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    int year;
    int month;
    int day;
    int hour;
    int min;

    public DateTime (int month, int day, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public DateTime(String date_string) {
        String[] split_date = date_string.split("/");
        this.month = Integer.parseInt(split_date[0]);
        this.day = Integer.parseInt(split_date[1]);
        this.year = Integer.parseInt(split_date[2]);
    }

    public DateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = dtf.format(now);
        String temp[] = formattedDate.split("-");
        for (int i = 0; i < temp.length; i++)
            System.out.println(temp[i]);
    }

    public DateTime(int year, int month, int day, int hour, int min) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.min = min;
    }

    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

}

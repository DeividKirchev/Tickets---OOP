package bg.tu_varna.sit.b1.f23621684.models;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void fromString(String s) {
        String[] parts = s.split("\\.");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid date format, expected dd.mm.yyyy");
        }

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        setDay(day);
        setMonth(month);
        setYear(year);
    }

    @Override
    public String toString() {
        return String.format("%02d.%02d.%04d", day, month, year);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}

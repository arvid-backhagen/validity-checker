package com.company;
import java.time.DateTimeException;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PersonalNumberFormatCheck extends ValidityCheck {
    private String pn;
    private int year;
    private int month;
    private int daysInMonth;
    private int day;
    private int yearNow = Calendar.YEAR;
    static Date today = new Date();
    static Calendar cal = new GregorianCalendar();


    PersonalNumberFormatCheck(String pn){
        if(pn != null && !pn.equalsIgnoreCase("")) {
            this.pn = pn;
            try {
                this.year = Integer.parseInt(pn.substring(0, 4));
                this.month = Integer.parseInt(pn.substring(4, 6));
                this.daysInMonth = YearMonth.of(this.year, this.month).lengthOfMonth();
                this.day = Integer.parseInt(pn.substring(6, 8));
            } catch (NumberFormatException e) {
                System.out.println("Dates are not only numbers: " + pn.substring(0, 8));
                this.setValid(false);
            } catch (DateTimeException dt) {
                System.out.println("Month must be within 1 and 12 found " + Integer.toString(this.month));
                this.setValid(false);
            } catch (StringIndexOutOfBoundsException sioob) {
                System.out.println("Personal number is too short." + pn);
                this.setValid(false);
            }
        } else {
            this.setValid(false);
        }
    }

    @Override
    public void validate() {
        cal.setTime(today);
        cal.setLenient(false);

        if (this.year > cal.get(this.yearNow)) {
            System.out.println("Given year has not occurred ");
            this.setValid(false);
        } else {
            if (this.month <= 12 && this.month > 0){
                if( this.day > 0 && this.day <= daysInMonth) {
                    this.setValid(true);
                } else {
                    System.out.println("Day is not within the bounds of that month");
                    this.setValid(false);
                }
            }else {
                System.out.println("Month has to be between 1 and 12");
                this.setValid(false);
            }

        }
    }

    @Override
    public String toString() {
        if(this.isValid()){
            return this.pn + " has valid date and format.";
        } else {
            return this.pn + " has invalid date or format.";
        }
    }
}
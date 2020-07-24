
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

/**
 * This is the class to implement the concert event all of the its properties like total seats booked seats and total sales.
 *
 * @author Nancy
 */
public class Concert {

    /**
     * Below is defined all the instance variable of the concert class
     */
    private int day;
    private int month;
    private int year;
    private String artist;
    private String venue;
    private int availableUpperTickets;
    private int availableLowerTickets;
    private int availableFloorTickets;
    private double totalSales;

    /**
     * ticket prices for the different sections
     */
    private static final double PRICE_UPPER_TICKET = 29.90;
    private static final double PRICE_LOWER_TICKET = 99.0;
    private static final double PRICE_FLOOR_TICKET = 180.0;

    /**
     * total number of tickets per section
     */
    private static final int TOTAL_NUMBER_UPPER_TICKETS = 300;
    private static final int TOTAL_NUMBER_LOWER_TICKETS = 300;
    private static final int TOTAL_NUMBER_FLOOR_TICKETS = 400;

    /**
     * This is the default constructor of the concert class
     * which will initialize all the instance variable with the defualt paramter
     */
    public Concert() {
        this.month = 9;
        this.day = 8;
        this.year = 2019;
        this.artist = "Jonas Brothers";
        this.venue = "Van Andel Arena";
        this.totalSales = 0;
        this.availableFloorTickets = TOTAL_NUMBER_FLOOR_TICKETS;
        this.availableLowerTickets = TOTAL_NUMBER_LOWER_TICKETS;
        this.availableUpperTickets = TOTAL_NUMBER_UPPER_TICKETS;

    }

    /**
     * This is the parameterized constructor of the class
     *
     * @param m : month
     * @param d : day
     * @param y : year
     * @param a : artist name
     * @param v : venue
     */
    public Concert(int m, int d, int y, String a, String v) {
        if (isDateValid(m, d, y)) {
            this.month = m;
            this.day = d;
            this.year = y;
        } else {
            System.out.println("Error: provided date is invalid");
        }
        this.artist = a;
        this.venue = v;
        this.totalSales = 0;
        this.availableFloorTickets = TOTAL_NUMBER_FLOOR_TICKETS;
        this.availableLowerTickets = TOTAL_NUMBER_LOWER_TICKETS;
        this.availableUpperTickets = TOTAL_NUMBER_UPPER_TICKETS;
    }

    /**
     * This is another parameterized constructor of the concert class
     *
     * @param date : Date in the string format like "mm/dd/yyyy"
     * @param a    : artist name
     * @param v    : venue name
     */
    public Concert(String date, String a, String v) {
        parseDate(date);
        this.artist = a;
        this.venue = v;
        this.totalSales = 0;
        this.availableFloorTickets = TOTAL_NUMBER_FLOOR_TICKETS;
        this.availableLowerTickets = TOTAL_NUMBER_LOWER_TICKETS;
        this.availableUpperTickets = TOTAL_NUMBER_UPPER_TICKETS;
    }


    /**
     * This is the getter method to get the venue name
     *
     * @return : return the venue name
     */
    public String getVenue() {
        return venue;
    }

    /**
     * This is the method to get the artist name
     *
     * @return : return the artist name
     */
    public String getArtist() {
        return artist;
    }

    /**
     * This is the method to get the ticket price based on the provided ticket type
     *
     * @param ticketType : Type of ticket for which price is needed
     * @return : return the ticket price
     */
    public double getTicketPrice(char ticketType) {
        double ticketPrice = 0;
        if (ticketType == 'F') {
            ticketPrice = PRICE_FLOOR_TICKET;
        } else if (ticketType == 'L') {
            ticketPrice = PRICE_LOWER_TICKET;
        } else if (ticketType == 'U') {
            ticketPrice = PRICE_UPPER_TICKET;
        }
        return ticketPrice;
    }

    /**
     * Getter method to get the day of the concert
     *
     * @return : return the day
     */
    public int getDay() {
        return day;
    }


    /**
     * Getter method to get the month of the concert
     *
     * @return : return the month of the concert
     */
    public int getMonth() {
        return month;
    }


    /**
     * This is the getter method to get the year of the concert date
     *
     * @return : return the year of the concert date
     */
    public int getYear() {
        return year;
    }


    /**
     * This is the getter method of get the available seats in the upper section
     *
     * @return : return the available seats in the upper section
     */
    public int getAvailableUpperTickets() {
        return availableUpperTickets;
    }

    /**
     * This is the getter method to get the available seats in the Lower section
     *
     * @return : return the available seats in the lower section
     */
    public int getAvailableLowerTickets() {
        return availableLowerTickets;
    }


    /**
     * This is the method to get the available seats in the floor section
     *
     * @return : return the available seats in the floor section
     */
    public int getAvailableFloorTickets() {
        return availableFloorTickets;
    }


    /**
     * This is the method to the total sales amount
     *
     * @return : return the total sales amount
     */
    public double getTotalSales() {
        return totalSales;
    }

    /**
     * This is the setter method to set the artist name
     *
     * @param artist: name of the artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * This is the setter method to set the venue name of the concert
     *
     * @param venue : venue of the concert
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * This method is used to set the date of the concert
     *
     * @param m : month
     * @param d : day
     * @param y : year
     */
    public void setDate(int m, int d, int y) {
        if (isDateValid(m, d, y)) {
            this.month = m;
            this.day = d;
            this.year = y;
        } else {
            System.out.println("Error: provided date is invalid");
        }
    }

    /**
     * This method is used to parse the date and store it into the month, day and year
     *
     * @param date : date in the mm/dd/yyyy format
     */
    private void parseDate(String date) {
        int firstSlash = date.indexOf("/");
        int m = Integer.parseInt(date.substring(0, firstSlash));
        int secondSlash = date.indexOf("/", firstSlash + 1);
        int d = Integer.parseInt(date.substring(firstSlash + 1, secondSlash));
        int y = Integer.parseInt(date.substring(secondSlash + 1));
        if (isDateValid(m, d, y)) {
            this.month = m;
            this.day = d;
            this.year = y;
        } else {
            System.out.println("Error: provided date is invalid");
        }
    }

    /**
     * This method used to buy the tickets
     *
     * @param ticketType : type of ticket like Upper(U), lower(L) or floor(F) need to buy
     * @param numTickets : number of tickets needs to buy
     * @param pmt        : total amount to pay
     */
    public void buyTickets(char ticketType, int numTickets, double pmt) {
        if (numTickets < 0 || pmt < 0) {
            System.out.println("Error - invalid (negative) number of tickets or payment");
            return;
        }
        double dueAmount = 0;
        double ticketPrice = getTicketPrice(ticketType);
        dueAmount = numTickets * ticketPrice;
        if (ticketType == 'F') {
            if (numTickets <= availableFloorTickets) {
                dueAmount = numTickets * PRICE_FLOOR_TICKET;
                if (dueAmount <= pmt) {
                    totalSales = totalSales + dueAmount;
                    availableFloorTickets = availableFloorTickets - numTickets;
                    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
                    System.out.println("Transaction: Number tickets Floor Section: " + numTickets + ", total: " + currency.format(dueAmount));
                } else {
                    System.out.println("Error - payment is not enough to buy the tickets");
                }
            } else {
                System.out.println("Tickets not available in floor section");
            }
        } else if (ticketType == 'L') {
            if (numTickets <= availableLowerTickets) {
                dueAmount = numTickets * PRICE_LOWER_TICKET;
                if (dueAmount <= pmt) {
                    totalSales = totalSales + dueAmount;
                    availableLowerTickets = availableLowerTickets - numTickets;
                    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
                    System.out.println("Transaction: Number tickets Lower Section: " + numTickets + ", total: " + currency.format(dueAmount));
                } else {
                    System.out.println("Error � payment is not enough to buy the tickets");
                }
            } else {
                System.out.println("Tickets not available in lower section");
            }

        } else if (ticketType == 'U') {
            if (numTickets <= availableUpperTickets) {
                dueAmount = numTickets * PRICE_UPPER_TICKET;
                if (dueAmount <= pmt) {
                    totalSales = totalSales + dueAmount;
                    availableUpperTickets = availableUpperTickets - numTickets;
                    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
                    System.out.println("Transaction: Number tickets Upper Section: " + numTickets + ", total: " + currency.format(dueAmount));
                } else {
                    System.out.println("Error � payment is not enough to buy the tickets");
                }
            } else {
                System.out.println("Tickets not available in upper section");
            }
        }
    }

    /**
     * This method used to print the report of the concert ticket booking
     */
    public void printReport() {
        System.out.println("Concert Report");
        System.out.println("======================");
        System.out.println("Artist:        " + this.artist);
        System.out.println("Venue:	       " + this.venue);
        System.out.println("Date:	       " + formatDate(4));
        System.out.println();
        System.out.println("Tickets sold:");
        System.out.println("=============");

        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Upper: " + (TOTAL_NUMBER_UPPER_TICKETS - availableUpperTickets) + "	" + currency.format((TOTAL_NUMBER_UPPER_TICKETS - availableUpperTickets) * PRICE_UPPER_TICKET));
        System.out.println("Lower: " + (TOTAL_NUMBER_LOWER_TICKETS - availableLowerTickets) + "	" + currency.format((TOTAL_NUMBER_LOWER_TICKETS - availableLowerTickets) * PRICE_LOWER_TICKET));
        System.out.println("Floor: " + (TOTAL_NUMBER_FLOOR_TICKETS - availableFloorTickets) + "	" + currency.format((TOTAL_NUMBER_FLOOR_TICKETS - availableFloorTickets) * PRICE_FLOOR_TICKET));
        System.out.println("==============");
        System.out.println("Total Sales:	" + currency.format(totalSales));
    }

    /**
     * This method used to check whether a year is  leap year or not
     *
     * @param y : year
     * @return : if y is leap year then return true otherwise return false
     */
    private boolean isLeapYear(int y) {
        boolean isLeapYear = false;
        if (y % 4 == 0) {
            if (y % 100 == 0) {
                if (y % 400 == 0)
                    isLeapYear = true;
                else
                    isLeapYear = false;
            } else
                isLeapYear = true;
        } else {
            isLeapYear = false;
        }
        return isLeapYear;
    }

    /**
     * This method used to check if a date is valid or not based on hte value of month, day and year
     *
     * @param m : month
     * @param d : day
     * @param y : year
     * @return : true if date is valid and false is date is not valid
     */
    private boolean isDateValid(int m, int d, int y) {
        boolean isMonthValid = false;
        boolean isDayValid = false;
        boolean isYearValid = false;
        if (y > 0) {
            isYearValid = true;
        }
        if (m >= 1 && m <= 12) {
            isMonthValid = true;
            switch (m) {

                case 1:
                    if (d > 0 && d <= 31) {
                        isDayValid = true;
                    }
                    break;
                case 2:
                    boolean isLeap = isLeapYear(y);
                    if (isLeap) {
                        if (d > 0 && d <= 29) {
                            isDayValid = true;
                        }
                    } else {
                        if (d > 0 && d <= 28) {
                            isDayValid = true;
                        }
                    }
                    break;
                case 3:
                    if (d > 0 && d <= 31) {
                        isDayValid = true;
                    }
                    break;
                case 4:
                    if (d > 0 && d <= 30) {
                        isDayValid = true;
                    }
                    break;
                case 5:
                    if (d > 0 && d <= 31) {
                        isDayValid = true;
                    }
                    break;
                case 6:
                    if (d > 0 && d <= 30) {
                        isDayValid = true;
                    }
                    break;
                case 7:
                    if (d > 0 && d <= 31) {
                        isDayValid = true;
                    }
                    break;
                case 8:
                    if (d > 0 && d <= 31) {
                        isDayValid = true;
                    }
                    break;
                case 9:
                    if (d > 0 && d <= 30) {
                        isDayValid = true;
                    }
                    break;
                case 10:
                    if (d > 0 && d <= 31) {
                        isDayValid = true;
                    }
                    break;
                case 11:
                    if (d > 0 && d <= 30) {
                        isDayValid = true;
                    }
                    break;
                case 12:
                    if (d > 0 && d <= 31) {
                        isDayValid = true;
                    }
                    break;

            }
        }
        if (isDayValid && isYearValid && isMonthValid) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This is the method to format the data based on the provided format version
     *
     * @param format : Version of date formating as per the specification
     * @return : formatted date
     */
    public String formatDate(int format) {
        String date = "";
        if (format == 1) {
            date = Integer.toString(this.month) + "/" + Integer.toString(this.day) + "/" + Integer.toString(this.year);
        } else if (format == 2) {
            DecimalFormat dfMonDay = new DecimalFormat("00");
            DecimalFormat dfYear = new DecimalFormat("0000");
            date = dfMonDay.format(this.month) + "/" + dfMonDay.format(this.day) + "/" + dfYear.format(this.year);
        } else if (format == 3) {
            String months = "JanFebMarAprMayJunJulAugSepOctNovDec";
            String m = months.substring((this.month - 1) * 3, this.month * 3);
            date = m + " " + this.day + ", " + this.year;
        } else if (format == 4) {
            String strMonth = "";
            switch (month) {
                case 1:
                    strMonth = "January";
                    break;
                case 2:
                    strMonth = "February";
                    break;
                case 3:
                    strMonth = "March";
                    break;
                case 4:
                    strMonth = "April";
                    break;
                case 5:
                    strMonth = "May";
                    break;
                case 6:
                    strMonth = "June";
                    break;
                case 7:
                    strMonth = "July";
                    break;
                case 8:
                    strMonth = "August";
                    break;
                case 9:
                    strMonth = "September";
                    break;
                case 10:
                    strMonth = "October";
                    break;
                case 11:
                    strMonth = "November";
                    break;
                case 12:
                    strMonth = "December";
                    break;
            }
            date = strMonth + " " + day + ", " + year;
        }
        return date;
    }

    /**
     * This method is to simulate the bulk ticket buying randomly in all the ticket classes
     *
     * @param numberTickets : total number of tickets needed to buy
     */
    public void simulateCompanyBuyingTickets(int numberTickets) {
        for (int i = 0; i < numberTickets; i++) {
            char ticketType = 0;
            Random r = new Random();
            int type = r.nextInt(3);
            double paymentAmount = 0;
            if (type == 0) {
                ticketType = 'U';
                paymentAmount = PRICE_UPPER_TICKET;
            } else if (type == 1) {
                ticketType = 'L';
                paymentAmount = PRICE_LOWER_TICKET;
            } else if (type == 2) {
                ticketType = 'F';
                paymentAmount = PRICE_FLOOR_TICKET;
            }
            buyTickets(ticketType, 1, paymentAmount);
        }
    }
}

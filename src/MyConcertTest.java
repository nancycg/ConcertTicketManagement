import org.junit.*;

/****************************************************
 * ConcertTest - class used to test the Concert class
 *
 * @author  Nancy
 ****************************************************/
public class MyConcertTest {
    /** ticket prices for the different sections */ 
    private static final double PRICE_UPPER_TICKET = 29.90;
    private static final double PRICE_LOWER_TICKET = 99.0;
    private static final double PRICE_FLOOR_TICKET = 180.0;

    /** total number of tickets per section */
    private static final int TOTAL_NUMBER_UPPER_TICKETS = 300;
    private static final int TOTAL_NUMBER_LOWER_TICKETS = 300;
    private static final int TOTAL_NUMBER_FLOOR_TICKETS = 400;

    /******************************************************
     * Test default constructor - no input parameters
     *****************************************************/
    @Test
    public void testDefaultConstructor() {
        Concert concert = new Concert();
        Assert.assertEquals("Artist name should be Jonas Brothers","Jonas Brothers", 
            concert.getArtist());
        Assert.assertEquals("Venue name should be Van Andel Arena","Van Andel Arena", 
            concert.getVenue());
        Assert.assertEquals("Month should be 9",
            9, concert.getMonth());
        Assert.assertEquals("Day should be 8",
            8, concert.getDay());
        Assert.assertEquals("Year should be 2019",
            2019, concert.getYear());
        Assert.assertEquals("Available upper tickets should be 300",
            TOTAL_NUMBER_UPPER_TICKETS, concert.getAvailableUpperTickets());
        Assert.assertEquals("Available lower tickets should be 300",
            TOTAL_NUMBER_LOWER_TICKETS, concert.getAvailableLowerTickets());
        Assert.assertEquals("Available upper tickets should be 400",
            TOTAL_NUMBER_FLOOR_TICKETS, concert.getAvailableFloorTickets());
        Assert.assertEquals("total sales should be 0.0",
            0.0, concert.getTotalSales(),0.001);

    }

    /******************************************************
     * Test second constructor - input parameters for month,
     * day, year, artist and venue
     *****************************************************/
    @Test
    public void testConstructor2() {
        Concert concert = new Concert(11, 7, 2019, "Itzhak Perlman", "DeVos Performance Hall");
        Assert.assertEquals("Artist name should be equal to input parameter. Example:",
            "Itzhak Perlman", concert.getArtist());
        Assert.assertEquals("Venue name should be equal to input parameter. Example:",
            "DeVos Performance Hall",concert.getVenue());
        Assert.assertEquals("Month should be equal to input parameter. Example:",
            11, concert.getMonth());
        Assert.assertEquals("Day should be equal to input parameter. Example:",
            7, concert.getDay());
        Assert.assertEquals("Year should be equal to input parameter. Example:",
            2019, concert.getYear());
        Assert.assertEquals("Available upper tickets should be 300",
            TOTAL_NUMBER_UPPER_TICKETS, concert.getAvailableUpperTickets());
        Assert.assertEquals("Available lower tickets should be 300",
            TOTAL_NUMBER_LOWER_TICKETS, concert.getAvailableLowerTickets());
        Assert.assertEquals("Available upper tickets should be 400",
            TOTAL_NUMBER_FLOOR_TICKETS, concert.getAvailableFloorTickets());
        Assert.assertEquals("total sales should be 0.0",
            0.0, concert.getTotalSales(),0.001);
    }

    /******************************************************
     * Test third constructor - input parameters for date as 
     * a String, artist and venue
     *****************************************************/
    @Test
    public void testConstructor3() {
        Concert concert = new Concert("11/7/2019", "Itzhak Perlman", "DeVos Performance Hall");
        Assert.assertEquals("Artist name should be equal to input parameter. Example:","Itzhak Perlman", 
            concert.getArtist());
        Assert.assertEquals("Venue name should be equal to input parameter. Example:","DeVos Performance Hall",
            concert.getVenue());
        Assert.assertEquals("Month should be equal to input parameter. Example:",
            11, concert.getMonth());
        Assert.assertEquals("Day should be equal to input parameter. Example:",
            7, concert.getDay());
        Assert.assertEquals("Year should be equal to input parameter. Example:",
            2019, concert.getYear());
        Assert.assertEquals("Available upper tickets should be 300",
            TOTAL_NUMBER_UPPER_TICKETS, concert.getAvailableUpperTickets());
        Assert.assertEquals("Available lower tickets should be 300",
            TOTAL_NUMBER_LOWER_TICKETS, concert.getAvailableLowerTickets());
        Assert.assertEquals("Available upper tickets should be 400",
            TOTAL_NUMBER_FLOOR_TICKETS, concert.getAvailableFloorTickets());
        Assert.assertEquals("total sales should be 0.0",
            0.0, concert.getTotalSales(),0.001);
    }

    /*********************************************************
     *  Test Invalid date constructor2 - 3 ints for date
     ********************************************************/
    @Test
    public void testInvalidDateConstructor2(){
        // invalid month
        Concert concert = new Concert(13, 20, 2019, "Itzhak Perlman", "DeVos Performance Hall");
        Assert.assertEquals("trying to initialize an invalid month", 0, concert.getMonth());

        // invalid day - not leap year
        concert = new Concert(2, 29, 2019, "Itzhak Perlman", "DeVos Performance Hall");
        Assert.assertEquals("trying to initialize on invalid day - not leap year", 0, concert.getDay());

        // invalid year - negative year
        concert = new Concert(7, 4, -2000, "Itzhak Perlman", "DeVos Performance Hall");
        Assert.assertEquals("trying to initialize an invalid year - negative year", 0, concert.getYear());      
    } 

    /*********************************************************
     *  Test Invalid date constructor3(String date)
     ********************************************************/
    @Test
    public void testInvalidDateConstructor3(){
        // invalid month
        Concert concert = new Concert("13/20/2019", "Itzhak Perlman", "DeVos Performance Hall");
        Assert.assertEquals("trying to initialize an invalid month", 0, concert.getMonth());
        System.out.println("Nagendra "+concert.getMonth());

        // invalid day - not leap year
        concert = new Concert("2/29/2019", "Itzhak Perlman", "DeVos Performance Hall");
        Assert.assertEquals("trying to initialize on invalid day - not leap year", 0, concert.getDay());

        // invalid year - negative year
        concert = new Concert("7/4/-2000", "Itzhak Perlman", "DeVos Performance Hall");
        Assert.assertEquals("trying to initialize an invalid year - negative year", 0, concert.getYear());      
    } 

    /******************************************************
     * Test setDate - with correct dates
     * date entered as individual ints for month, day & year
     *****************************************************/
    @Test
    public void testSetDateCorrectDate() {
        Concert concert = new Concert();
        concert.setDate (4, 20, 2000);   
        Assert.assertEquals("month not set correctly to input parameter. Example: ", 
            4, concert.getMonth());                
        Assert.assertEquals("day not set correctly to input parameter. Example: ", 
            20, concert.getDay());   
        Assert.assertEquals("year not set correctly  to input parameter. Example: ", 
            2000, concert.getYear()); 

        // leap year
        concert.setDate (2, 29, 2004);   
        Assert.assertEquals("month not set correctly to input parameter. Example: ", 
            2, concert.getMonth());                
        Assert.assertEquals("day not set correctly to input parameter. Example: ", 
            29, concert.getDay());   
        Assert.assertEquals("year not set correctly to input parameter. Example: ", 
            2004, concert.getYear()); 

        // leap year
        concert.setDate (2, 29, 2400);   
        Assert.assertEquals("month not set correctly to input parameter. Example: ", 
            2, concert.getMonth());                
        Assert.assertEquals("day not set correctly to input parameter. Example: ", 
            29, concert.getDay());   
        Assert.assertEquals("year not set correctly to input parameter. Example: ", 
            2400, concert.getYear()); 
    } 

    /*********************************************************
     *  Test Invalid date - Input parameter individual integers
     *  for month, day and year
     ********************************************************/
    @Test
    public void testSetDateInvalidDate(){
        Concert concert = new Concert();

        // date should not change for any of these attemps to 
        // change the date
        // date should be: 9/8/2019 (Default constructor)

        // invalid month
        concert.setDate (13, 20, 1963); 
        Assert.assertEquals("invalid month - default date should remain", 
            9, concert.getMonth()); 

        // invalid day for april
        concert.setDate (4, 31, 2019); 
        Assert.assertEquals("invalid day  - default date should remain", 
            8, concert.getDay());

        // invalid day - 2019 not leap year
        concert.setDate (2, 29, 2019); 
        Assert.assertEquals("invalid day not leap year - default date should remain", 
            8, concert.getDay()); 

        // invalid day - 1900 not leap year
        concert.setDate (2, 29, 1900); 
        Assert.assertEquals("invalid day not leap year - default date should remain ", 
            8, concert.getDay()); 

        // invalid year - negative    
        concert.setDate (2, 3, -2019);  
        Assert.assertEquals("invalid year - negative -default date should remain", 
            2019, concert.getYear());      
    } 

    /*********************************************************
     *  Test getTicketPrice - Input parameter - ticketType
     ********************************************************/
    @Test
    public void testGetTicketPrice(){
        Concert concert = new Concert();

        // Testing upper ticket
        Assert.assertEquals("Upper Ticket Price should be" + PRICE_UPPER_TICKET,
            PRICE_UPPER_TICKET, concert.getTicketPrice('U'),0.001);

        // Testing lower ticket
        Assert.assertEquals("Lower Ticket Price should be" + PRICE_LOWER_TICKET,
            PRICE_LOWER_TICKET, concert.getTicketPrice('L'),0.001);

        // Testing floor ticket
        Assert.assertEquals("Floor Ticket Price should be" + PRICE_FLOOR_TICKET,
            PRICE_FLOOR_TICKET, concert.getTicketPrice('F'),0.001);
    }

    /*********************************************************
     *  Test setArtist - Input parameter - artist name
     ********************************************************/
    @Test
    public void testSetArtist(){
        Concert concert = new Concert();
        concert.setArtist ("Loui the Laker");
        Assert.assertEquals("Artist name should be equal to input parameter. Example:",
            "Loui the Laker", concert.getArtist());
    }

    /*********************************************************
     *  Test setVenue - Input parameter - venue name
     ********************************************************/
    @Test
    public void testSetVenue(){
        Concert concert = new Concert();
        concert.setVenue ("GVSU Fieldhouse");
        Assert.assertEquals("Venue name should be equal to input parameter. Example:",
            "GVSU Fieldhouse", concert.getVenue());
    }

    /*********************************************************
     *  Test buyTickets - buying 1 ticket of each type
     ********************************************************/
    @Test
    public void testBuyTickets(){
        Concert concert = new Concert();

        concert.buyTickets ('U', 1, PRICE_UPPER_TICKET);
        concert.buyTickets ('L', 1, PRICE_LOWER_TICKET);
        concert.buyTickets ('F', 1, PRICE_FLOOR_TICKET);

        // totalSales should be the sum of the price of each type of tickets
        Assert.assertEquals("After buying 1 ticket of each type total sales should be: " 
            + (PRICE_UPPER_TICKET + PRICE_LOWER_TICKET + PRICE_FLOOR_TICKET), 
            PRICE_UPPER_TICKET + PRICE_LOWER_TICKET + PRICE_FLOOR_TICKET,
            concert.getTotalSales(),0.001);

        // The tickets available of each type should be 1 less than the total possible
        Assert.assertEquals("After buying a ticket in the upper section," +
            "the available upper tickets should be 299",
            TOTAL_NUMBER_UPPER_TICKETS - 1, concert.getAvailableUpperTickets());
        Assert.assertEquals("After buying a ticket in the lower section," +
            "the available lower tickets should be 299",
            TOTAL_NUMBER_LOWER_TICKETS - 1, concert.getAvailableLowerTickets());
        Assert.assertEquals("After buying a ticket in the floor section," +
            "the available floor tickets should be 399",
            TOTAL_NUMBER_FLOOR_TICKETS - 1, concert.getAvailableFloorTickets());

    }

    /*********************************************************
     *  Test buyTickets - buying upper tickets several times
     ********************************************************/
    @Test
    public void testBuyUpperTicketsMultipletimes(){
        Concert concert = new Concert();

        concert.buyTickets ('U', 10, PRICE_UPPER_TICKET * 10);
        concert.buyTickets ('U', 10, PRICE_UPPER_TICKET * 10);

        // totalSales should be 20 * PRICE_UPPER_TICKET
        Assert.assertEquals("After buying 20 tickets in the upper section " +
            "the total sales should be: " 
            + PRICE_UPPER_TICKET * 20, PRICE_UPPER_TICKET * 20,           
            concert.getTotalSales(),0.001);

        // The upper tickets available should be 20 less than the total possible
        Assert.assertEquals("After buying 20 tickets in the upper section," +
            "the available upper tickets should be 280",
            TOTAL_NUMBER_UPPER_TICKETS - 20, concert.getAvailableUpperTickets());
    }

    /*********************************************************
     *  Test buyTickets - buying lower tickets several times
     ********************************************************/
    @Test
    public void testBuyLowerTicketsMultipletimes(){
        Concert concert = new Concert();

        concert.buyTickets ('L', 5, PRICE_LOWER_TICKET * 5);
        concert.buyTickets ('L', 10, PRICE_LOWER_TICKET * 10);

        // totalSales should be 15 * PRICE_LOWER_TICKET
        Assert.assertEquals("After buying 15 tickets in the lower section " +
            "the total sales should be: " 
            + PRICE_LOWER_TICKET * 15, PRICE_LOWER_TICKET * 15,           
            concert.getTotalSales(),0.001);

        // The upper tickets available should be 15 less than the total possible
        Assert.assertEquals("After buying 15 tickets in the lower section," +
            "the available upper tickets should be 285",
            TOTAL_NUMBER_LOWER_TICKETS - 15, concert.getAvailableLowerTickets());
    }

    /*********************************************************
     *  Test buyTickets - buying floor tickets several times
     ********************************************************/
    @Test
    public void testBuyFloorTicketsMultipletimes(){
        Concert concert = new Concert();

        concert.buyTickets ('F', 8, PRICE_FLOOR_TICKET * 8);
        concert.buyTickets ('F', 7, PRICE_FLOOR_TICKET * 7);

        // totalSales should be 15 * PRICE_FLOOR_TICKET
        Assert.assertEquals("After buying 15 tickets in the floor section " +
            "the total sales should be: " 
            + PRICE_FLOOR_TICKET * 15, PRICE_FLOOR_TICKET * 15,           
            concert.getTotalSales(),0.001);

        // The floor tickets available should be 15 less than the total possible
        Assert.assertEquals("After buying 15 tickets in the floor section," +
            "the available floor tickets should be 385",
            TOTAL_NUMBER_FLOOR_TICKETS - 15, concert.getAvailableFloorTickets());
    }

    /*********************************************************
     *  Test buyTickets - not enough money to buy tickets
     ********************************************************/
    @Test
    public void testBuyTicketsNotEnoughMoney(){
        Concert concert = new Concert();

        //paying only for 1 ticket - not enough money
        concert.buyTickets ('U', 8, PRICE_UPPER_TICKET);
        concert.buyTickets ('L', 7, PRICE_LOWER_TICKET);
        concert.buyTickets ('F', 7, PRICE_FLOOR_TICKET);

        // totalSales should be zero
        Assert.assertEquals("Not enough money to buy tickets, total sales should be 0.0: ", 
            0.0, concert.getTotalSales(),0.001);

        // available tickets should not change
        Assert.assertEquals("Available upper tickets should be 300",
            TOTAL_NUMBER_UPPER_TICKETS, concert.getAvailableUpperTickets());
        Assert.assertEquals("Available lower tickets should be 300",
            TOTAL_NUMBER_LOWER_TICKETS, concert.getAvailableLowerTickets());
        Assert.assertEquals("Available upper tickets should be 400",
            TOTAL_NUMBER_FLOOR_TICKETS, concert.getAvailableFloorTickets());
    }

    /*********************************************************
     *  Test buyTickets - Number of tickets not available
     ********************************************************/
    @Test
    public void testBuyTicketsNotAvailableTickets(){
        Concert concert = new Concert();

        // buying ALL the tickets available in all sections
        concert.buyTickets ('U', TOTAL_NUMBER_UPPER_TICKETS, 
            PRICE_UPPER_TICKET * TOTAL_NUMBER_UPPER_TICKETS);
        concert.buyTickets ('L', TOTAL_NUMBER_LOWER_TICKETS, 
            PRICE_LOWER_TICKET * TOTAL_NUMBER_LOWER_TICKETS);
        concert.buyTickets ('F', TOTAL_NUMBER_FLOOR_TICKETS, 
            PRICE_FLOOR_TICKET * TOTAL_NUMBER_FLOOR_TICKETS);

        double previousTotalSales = concert.getTotalSales ();

        // trying to buy more tickets
        concert.buyTickets ('U', 1, PRICE_UPPER_TICKET);
        concert.buyTickets ('L', 1, PRICE_LOWER_TICKET);
        concert.buyTickets ('F', 1, PRICE_FLOOR_TICKET);

        // totalSales should not change from previous totalSales value
        Assert.assertEquals("Tickets not available, total sales should be: " +
            previousTotalSales, previousTotalSales, concert.getTotalSales(),0.001);

        // sold out - available tickets should be zero
        Assert.assertEquals("Sold out - Available upper tickets should be 0",
            0, concert.getAvailableUpperTickets());
        Assert.assertEquals("Sold out - Available lower tickets should be 0",
            0, concert.getAvailableLowerTickets());
        Assert.assertEquals("Sold out - Available floor tickets should be 0",
            0, concert.getAvailableFloorTickets());
    }

    /*********************************************************
     *  Test buyTickets - paying more money than needed
     ********************************************************/
    @Test
    public void testBuyTicketsLargerPayment(){
        Concert concert = new Concert();

        concert.buyTickets ('U', 1, PRICE_UPPER_TICKET + 10);
        concert.buyTickets ('L', 1, PRICE_LOWER_TICKET + 20);
        concert.buyTickets ('F', 1, PRICE_FLOOR_TICKET + 3);

        // totalSales should be the sum of the price of each type of tickets
        Assert.assertEquals("After buying 1 ticket of each type total sales should be: " 
            + (PRICE_UPPER_TICKET + PRICE_LOWER_TICKET + PRICE_FLOOR_TICKET), 
            PRICE_UPPER_TICKET + PRICE_LOWER_TICKET + PRICE_FLOOR_TICKET,
            concert.getTotalSales(),0.001);

        // The tickets available of each type should be 1 less than the total possible
        Assert.assertEquals("After buying a ticket in the upper section," +
            "the available upper tickets should be 299",
            TOTAL_NUMBER_UPPER_TICKETS - 1, concert.getAvailableUpperTickets());
        Assert.assertEquals("After buying a ticket in the lower section," +
            "the available lower tickets should be 299",
            TOTAL_NUMBER_LOWER_TICKETS - 1, concert.getAvailableLowerTickets());
        Assert.assertEquals("After buying a ticket in the floor section," +
            "the available floor tickets should be 399",
            TOTAL_NUMBER_FLOOR_TICKETS - 1, concert.getAvailableFloorTickets());

    }

    /*********************************************************
     *  Test buyTickets - testing negative number of tickets
     ********************************************************/
    @Test
    public void testBuyTicketsNegativeNumTickets(){
        Concert concert = new Concert();

        concert.buyTickets ('U', -1, PRICE_UPPER_TICKET);
        concert.buyTickets ('L', -1, PRICE_LOWER_TICKET);
        concert.buyTickets ('F', -1, PRICE_FLOOR_TICKET);

        // totalSales should be zero
        Assert.assertEquals("numTickets cannot be nevative - total sales should be 0.0 ", 
            0.0, concert.getTotalSales(),0.001);

        // The tickets available of each type should be the total possible
        Assert.assertEquals("numTickets cannot be nevative," +
            "the available upper tickets should be 300",
            TOTAL_NUMBER_UPPER_TICKETS, concert.getAvailableUpperTickets());
        Assert.assertEquals("numTickets cannot be nevative," +
            "the available lower tickets should be 300",
            TOTAL_NUMBER_LOWER_TICKETS, concert.getAvailableLowerTickets());
        Assert.assertEquals("numTickets cannot be nevative," +
            "the available floor tickets should be 400",
            TOTAL_NUMBER_FLOOR_TICKETS, concert.getAvailableFloorTickets());

    }

    /*********************************************************
     *  Test buyTickets - testing negative payments
     ********************************************************/
    @Test
    public void testBuyTicketsNegativePayments(){
        Concert concert = new Concert();

        concert.buyTickets ('U', 1, -PRICE_UPPER_TICKET);
        concert.buyTickets ('L', 1, -PRICE_LOWER_TICKET);
        concert.buyTickets ('F', 1, -PRICE_FLOOR_TICKET);

        // totalSales should be zero
        Assert.assertEquals("payment cannot be nevative - total sales should be 0.0 ", 
            0.0, concert.getTotalSales(),0.001);

        // The tickets available of each type should be the total possible
        Assert.assertEquals("payment cannot be nevative," +
            "the available upper tickets should be 300",
            TOTAL_NUMBER_UPPER_TICKETS, concert.getAvailableUpperTickets());
        Assert.assertEquals("payment cannot be nevative," +
            "the available lower tickets should be 300",
            TOTAL_NUMBER_LOWER_TICKETS, concert.getAvailableLowerTickets());
        Assert.assertEquals("payment cannot be nevative," +
            "the available floor tickets should be 400",
            TOTAL_NUMBER_FLOOR_TICKETS, concert.getAvailableFloorTickets());

    }

    /*********************************************************
     * Test formatDate- Testing the different formats
     *********************************************************/
    @Test
    public void testFormatDate(){    
        Concert concert = new Concert();
        //Testing format 1
        concert.setDate(1,10,1995);
        Assert.assertEquals("Problems with formatting the date as required - " +
            "one or two digits for month and day : mm/dd/yyyy","1/10/1995", concert.formatDate(1));   

        //Testing format 2
        concert.setDate(1,8,1995);
        Assert.assertEquals("Problems with formatting the date as required: " 
            + "mm/dd/yyyy - 2 digits for month and day","01/08/1995", 
            concert.formatDate(2));  

        //Testing format 3
        concert.setDate(4,30,1960);
        Assert.assertEquals("Problems with formatting the date as required: "
            + "MMM dd, yyyy","Apr 30, 1960", concert.formatDate(3)); 

        //Testing format 4
        concert.setDate(4,30,1960);
        Assert.assertEquals("Problems with formatting the date as required: " 
            + "Month dd, yyyy","April 30, 1960", concert.formatDate(4)); 
    }  

    /*********************************************************
     *  Test simulate simulateCompanyBuyingTickets
     ********************************************************/
    @Test
    public void testSimulateCompanyBuyingTickets(){
        Concert concert = new Concert();

        // buying 250 individual tickets in random sections
        concert.simulateCompanyBuyingTickets(250);

        // seats available should be total of possible seats - 250
        Assert.assertEquals("Total number of available seats should be," +
            (TOTAL_NUMBER_UPPER_TICKETS + 
                TOTAL_NUMBER_LOWER_TICKETS + 
                TOTAL_NUMBER_FLOOR_TICKETS - 250), 
            TOTAL_NUMBER_UPPER_TICKETS + 
            TOTAL_NUMBER_LOWER_TICKETS + 
            TOTAL_NUMBER_FLOOR_TICKETS - 250, 
            concert.getAvailableUpperTickets() +
            concert.getAvailableLowerTickets() +
            concert.getAvailableFloorTickets());

    }
}
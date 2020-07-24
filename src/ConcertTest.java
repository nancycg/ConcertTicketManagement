/**
 * This is the test class to test the various methods of the Concert class.
 * This class will used the main method to test all the features of the concert class
 * @author Nancy Chauhan
 *
 */
public class ConcertTest {

	/**
	 * This is the main method and entry point for the JVM
	 * @param args
	 */
	public static void main(String[] args) {
		
		    System.out.println("############Testing starts  for concert 1 ##########");
	        int errors = 0;
	        // instantiating a concert 
	        Concert c1 = new Concert(10,19,2019, "Keith Urban & Kelsea Ballerini", "Van Andel Arena");

	        // buy 10 tickets in the floor section
	        c1.buyTickets ('F', 10, 1800.0);
	        if(c1.getTotalSales() != 1800.0){
	            errors++;
	            System.out.println("ERROR: Total Sales should be 1800.0");
	        }

	        // the floor tickets available should be 390 
	        if(c1.getAvailableFloorTickets() != 390){
	            errors++;
	            System.out.println("ERROR: available floor tickets should be 390");
	        }

	        // buy 1 ticket in the floor section
	        // testing errors in input parameters
	        c1.buyTickets ('F', -1, 180.0);
	        if(c1.getTotalSales() != 1800.0){
	            errors++;
	            System.out.println("ERROR: Total Sales should be 1800.0");
	        }
	        
	        //Buy 10 tickets of the lower section
	        c1.buyTickets('L', 10, 990);

	        //Check if output is not correct
	        if(c1.getTotalSales() != 2790.0) {
	        	errors++;
	        	System.out.println("ERROR: Total Sales should be 2790.0");
	        }
	        
	        //Buy 10 more tickets of the upper section
	        c1.buyTickets('U', 10, 300);
	        
	        //Check if there is mismatch in the total sales after purchasing this
	        if(c1.getTotalSales() != 3089.0) {
	        	errors++;
	        	System.out.println("ERROR: Total Sales should be 3089.0");
	        }
	        
	        //Change the artist name
	        c1.setArtist("John Mathew");
	        if(!c1.getArtist().equals("John Mathew")) {
	        	errors++;
	        	System.out.println("ERROR: Artist name must be John Mathew");
	        }
	        
	        //change the venue name
	        c1.setVenue("South Wales");
	        //check if new venue name is not reflected
	        if(!c1.getVenue().equals("South Wales")) {
	        	errors++;
	        	System.out.println("ERROR: Venue name must be South Wales");
	        }
	        
	        //check if remaining floor tickets are the correctly managed
	        if(c1.getAvailableFloorTickets()!=390) {
	        	errors++;
	        	System.out.println("ERROR: Remianing floor tickets must be 390 now");
	        }
	        
	        //check if remaining upper tickets are the correctly managed
	        if(c1.getAvailableUpperTickets()!=290) {
	        	errors++;
	        	System.out.println("ERROR: Remianing upper tickets must be 290 now");
	        }
	        
	       //check if remaining lower tickets are the correctly managed
	        if(c1.getAvailableLowerTickets()!=290) {
	        	errors++;
	        	System.out.println("ERROR: Remianing lower tickets must be 290 now");
	        }
	        
	        //check if day month and year of the venue is properly managed 
	        if(!(c1.getYear() == 2019 && c1.getMonth() == 10 && c1.getDay() == 19)) {
	        	errors++;
	        	System.out.println("ERROR: Year must be 2019 and month must be 10 and day must be 19");
	        }
	        
	        c1.setDate(1, 1, 2020);

	        //check if day month and year of the venue is properly managed
	        if(!(c1.getYear() == 2020 && c1.getMonth() == 1 && c1.getDay() == 1)) {
	        	errors++;
	        	System.out.println("ERROR: Year must be 2020 and month must be 1 and day must be 1");
	        }

	        // invoking the method to simulate a company buying 50
	        // individual tickets in random sections
	        c1.simulateCompanyBuyingTickets(50);

	        // invoking the report method
	        c1.printReport();

	        System.out.println("Testing Complete. Number of errors in Concert 1 : " + errors);
	        
	        System.out.println("#############Testing of the Concert 2 starts ##########");
	        Concert c2 = new Concert("1/1/2020", "David Hussy", "Greater South Wales");
	        
	        errors =0;
	        
	        //check venue date is correctly updated or not
	        if(!(c2.getYear() == 2020 && c2.getMonth() == 1 && c2.getDay() == 1)) {
	        	errors++;
	        	System.out.println("ERROR: year of the concert must be 2020 and month must be 1 and day must be 1");
	        }
	        
	        //check if artist name updated correctly
	        if(!c2.getArtist().equals("David Hussy")) {
	        	errors++;
	        	System.out.println("ERROR: Artist name must be Daid Hussy");
	        }
	        
	        //check if Venue name is updated correctly or not
	        if(!c2.getVenue().equals("Greater South Wales")) {
	        	errors++;
	        	System.out.println("ERROR: Venue name must be Greater South Wales");
	        }
	        
	        //This should buy one ticket in the Lower section
	        c2.buyTickets('L', 1, 5000);

	        //now check available seats in lower section
	        if(c2.getAvailableLowerTickets() != 299) {
	        	errors++;
	        	System.out.println("ERROR: Available seats in lower section must be 299");
	        }
	        
	        //This should buy 1 ticket in upper section
	        c2.buyTickets('U', 1, 500);

	        //check if available seats in the upper section is properly updated
	        if(c2.getAvailableUpperTickets()!=299) {
	        	errors++;
	        	System.out.println("ERROR: Available seats in upper section must be 299");
	        }
	        
	        //This would not buy any ticket as payment amount is not sufficient
	        c2.buyTickets('F', 1, 2);

	        //check if available seats in the floor section are unchanged
	        if(c2.getAvailableFloorTickets()!=400) {
	        	errors++;
	        	System.out.println("ERROR: Available seats in floor section must be 400");
	        }
	        c2.printReport();
	        System.out.println("Testing Complete. Number of errors in Concert 2 : "+errors);
	}
}

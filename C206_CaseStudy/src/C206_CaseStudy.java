import java.util.ArrayList;


public class C206_CaseStudy {

	private static final int OPTION_QUIT = 2;
	
	public static void main(String[] args) {
		
		int option = 0;

		while (option != OPTION_QUIT) {
		
		
		C206_CaseStudy.menu();
		option = Helper.readInt("Enter an option > ");

		if (option == 1) {
		
		
		}
	}
		
	}
			
	public static void menu() {
			C206_CaseStudy.setHeader("ONLINE AUCTION APP");
			System.out.println("1. Log In");
			System.out.println("2. Quit");
			Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

}

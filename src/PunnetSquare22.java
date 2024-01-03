import java.util.Scanner;

public class PunnetSquare22 {

	public static void main(String[] args) {
		
		//variables
		String p1, p2;
		char p1G11;
		char p1G12, p2G11, p2G12;
		///String f11, f12, f13, f14;
		
		Scanner input = new Scanner(System.in);
		
		//i
		System.out.println("enter one parent");
		p1 = input.next();
		System.out.println("enter other parent");
		p2 = input.next();
		
		//p
		p1G11 = p1.charAt(0);
		p1G12 = p1.charAt(1);
		p2G11 = p2.charAt(0);
		p2G12 = p2.charAt(1);
	
		String f11 = new StringBuilder().append(p1G11).append(p2G11).toString();
		String f12 = new StringBuilder().append(p1G11).append(p2G12).toString();
		String f13 = new StringBuilder().append(p1G12).append(p2G11).toString();
		String f14 = new StringBuilder().append(p1G12).append(p2G12).toString();
		
		
		System.out.printf("the possible genotypes are: %s, %s, %s, and %s", f11, f12, f13, f14);
		
		
	}
}

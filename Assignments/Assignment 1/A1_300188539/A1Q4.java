//Student name: Alae Boufarrachene
//Student number: 300188539

import java.util.Scanner;

public class A1Q4 {

    public static int getPlayerBonus(int goals, int assists, int penalties, int numberOfMatches, int yearsOfService) {
        if (goals>20 || assists>25 || penalties<25) {
            if (yearsOfService>=5 && numberOfMatches>55) {
                return 3;
            }
            if (yearsOfService>=5 && numberOfMatches<=55) {
                return 2;
            }
            if (yearsOfService<5) {
                return 1;
            }
        }
       return 0;
    }

    public static void main(String[] args) {
        
        Scanner goalsInput = new Scanner(System.in);
        System.out.print("-Enter the number of player goals during the season : ");
		int goals = goalsInput.nextInt();
        while (goals<0) {
            System.out.print("-Please enter a valid number of player goals during the season ! (>=0)");
		    goals = goalsInput.nextInt();
        }

        Scanner assistsInput = new Scanner(System.in);
        System.out.print("-Enter the number of player assists during the season : ");
		int assists = assistsInput.nextInt();
        while (assists<0) {
            System.out.print("-Please enter a valid number of player assists during the season ! (>=0)");
		    assists = assistsInput.nextInt();
        }

        Scanner penaltiesInput = new Scanner(System.in);
        System.out.print("-Enter the number of penalties during the season : ");
		int penalties = penaltiesInput.nextInt();
        while (penalties<0) {
            System.out.print("-Please enter a valid number of penalties ! (>=0)");
		    penalties = penaltiesInput.nextInt();
        }

        Scanner matchesInput = new Scanner(System.in);
        System.out.print("-Enter the number of matches played by the player : ");
		int matches = matchesInput.nextInt();
        while (matches<0) {
            System.out.print("-Please enter a valid number of matches payed during the season ! (>=0)");
		    matches = matchesInput.nextInt();
        }

        Scanner yearsInput = new Scanner(System.in); 
        System.out.print("-Enter the number of years of service of the player : ");
		int years = yearsInput.nextInt();
        while (years<0) {
            System.out.print("-Please enter a valid number of years of service of the player ! (>=0)");
		    matches = yearsInput.nextInt();
        }

        System.out.println(">This player's bonus code is the following : "+getPlayerBonus(goals, assists, penalties, matches, years));

        goalsInput.close();
        assistsInput.close();
        penaltiesInput.close();
        matchesInput.close();
        yearsInput.close();
    }
}
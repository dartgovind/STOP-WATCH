import java.io.IOException;
import java.util.Scanner;

public class STOP_WATCH{
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int H = 0, M = 0, S = 0;
        boolean running = false;
        System.out.println("(:DART GOVIND STOP WATCH:)");
        System.out.println("Type 'start' to begin the clock or 'reset' to reset it.");

        while (true) {
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("start")) {
                running = true;
            } else if (input.equals("reset")) {
                H = 0;
                M = 0;
                S = 0;
                running = false;
                System.out.print("\r00:00:00");  
            }

            while (running) {
                System.out.printf("\r%02d:%02d:%02d", H, M, S);
                Thread.sleep(1000);  
                S++;  

                if (S == 61) {  
                    S = 0;
                    M++;
                }

                if (M == 60) {  
                    M = 0;
                    H++;
                }

                if (H == 24) {  
                    H = 0;
                }

                
                try {
                    if (System.in.available() > 0) {
                        input = scanner.nextLine().toLowerCase();
                        if (input.equals("reset")) {
                            H = 0;
                            M = 0;
                            S = 0;
                            running = false;
                            System.out.print("\r00:00:00");  
                        } else if (input.equals("start")) {
                            running = true;
                        } else {
                            running = false;  
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();  
                }
            }
        }
    }
}

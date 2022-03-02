package feladat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Kliens {
    public static void main(String[]args){
        try{
            Socket kapcsolat = new Socket("localhost",8080);
            DataInputStream servertol = new DataInputStream(
                    kapcsolat.getInputStream());
            DataOutputStream serverre = new DataOutputStream(
                    kapcsolat.getOutputStream());

            Scanner sc = new Scanner(System.in);

            while(true){
                System.out.println("Kérem a kör sugarát");
                int sugar = sc.nextInt();
                serverre.writeInt(sugar);
                serverre.flush();
                System.out.printf("Szervertől a kerület: %.2f\n",servertol.readDouble());
                System.out.printf("Szervertől a terület: %.2f\n",servertol.readDouble());
            }

        }catch (IOException ex){
            System.out.println(ex);
        }
    }
}

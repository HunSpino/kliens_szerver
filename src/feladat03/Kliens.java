package feladat03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Kliens {
    public static void main(String[]args){

        try {
            Socket kapcsolat = new Socket("localhost",8080);
            DataInputStream servertol = new DataInputStream(
                    kapcsolat.getInputStream());
            DataOutputStream servernek = new DataOutputStream(
                    kapcsolat.getOutputStream());
            int menu;
            Scanner sc = new Scanner(System.in);
            do{
                System.out.println("Válasszon a menüpontok közül: ");
                System.out.println("1. listázás");
                System.out.println("2: az indiánok száma.");
                menu = sc.nextInt();
                servernek.writeInt(menu);
                servernek.flush();
                System.out.println(servertol.readUTF());
            }while(menu !=-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

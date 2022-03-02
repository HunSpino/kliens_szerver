package feladat02;

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
            DataOutputStream servernek = new DataOutputStream(
                    kapcsolat.getOutputStream());

            Scanner sc = new Scanner(System.in);

            while(true){
                System.out.println("Kérem az A oldalt: ");
                int a = sc.nextInt();
                servernek.writeInt(a);
                servernek.flush();
                System.out.println("Kérem az B oldalt: ");
                int b = sc.nextInt();
                servernek.writeInt(b);
                servernek.flush();
                int menu;
                do{
                    System.out.println("Válasszon az alábbi lehetőségek közül: ");
                    System.out.println("1: Kerület\n2: Terület\n3: Négyzet-e\n4: Átló mérete\n5: Kilépés");
                    menu = sc.nextInt();
                    servernek.writeInt(menu);
                    servernek.flush();
                    System.out.println(servertol.readUTF());

                }while (menu !=5);


            }

        }catch (IOException ex){
            System.out.println(ex);
        }
    }
}

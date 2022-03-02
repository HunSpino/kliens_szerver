package feladat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class UgyfelKiszolgalo implements Runnable{

    Socket kapcsolat;
    public UgyfelKiszolgalo(Socket kapcsolat){
        this.kapcsolat = kapcsolat;
    }

    @Override
    public void run() {
        try{
            DataInputStream ugyfeltol = new DataInputStream(
                    kapcsolat.getInputStream());
            DataOutputStream ugyfelnek = new DataOutputStream(
                    kapcsolat.getOutputStream());
            while(true){
                int a = ugyfeltol.readInt();
                int b = ugyfeltol.readInt();
                int menu;
                //"1: Kerület\n2: Terület\n3: Négyzet-e\n4: Átló mérete\n5: Kilépés"
                do{
                    menu = ugyfeltol.readInt();
                    switch (menu){
                        case 1: ugyfelnek.writeUTF(kerulet(a,b)); break;
                        case 2: ugyfelnek.writeUTF(terulet(a,b)); break;
                        case 3: ugyfelnek.writeUTF(negyzet(a,b)); break;
                        case 4: ugyfelnek.writeUTF(atlo(a,b)); break;
                        case 5: ugyfelnek.writeUTF("Ön a kilépést választotta");
                    }


                }while(menu != 5);

            }
        }catch (IOException ex){
            System.out.println(ex);
        }
    }

    private String atlo(int a, int b) {
        return "A téglalap átlójának a mérete: ";
    }

    private String negyzet(int a, int b) {
        return "Négyzet-e az alakzatunk? Válasz: ";
    }

    private String terulet(int a, int b) {
        return "A téglalap területe: "+a*b;
    }

    private String kerulet(int a, int b) {
        return "A téglalap kerülete: "+(2*(a+b));
    }
}

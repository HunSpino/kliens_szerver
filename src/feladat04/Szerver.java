package feladat04;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Szerver {
    public static void main(String[] args){

        UgyfelKiszolgalo u = new UgyfelKiszolgalo();
        ExecutorService exe = Executors.newCachedThreadPool();
        System.out.println("A szerver indul....");

        try{
            ServerSocket socket = new ServerSocket(8080);
            while(true){
                Socket kapcsolat = socket.accept();
                InetAddress ugyfel = kapcsolat.getInetAddress();

                feladat03.UgyfelKiszolgalo uk = new feladat03.UgyfelKiszolgalo(kapcsolat);
                exe.submit(uk);
            }


        }catch (IOException ex){
            System.out.println(ex);
        }
    }
}

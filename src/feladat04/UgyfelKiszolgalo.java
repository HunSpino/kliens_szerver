package feladat04;

import feladat03.Indian;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class UgyfelKiszolgalo implements Runnable{

    private HashMap<String,Idojaras> elorejelzes;
    private Socket kapcsolat;

    public UgyfelKiszolgalo(){
        elorejelzes = new HashMap<>();
        Beolvas();
        feladat1();
        feladat2();
        feladat3();
        feladat4();
        feladat5();
    }

    @Override
    public void run() {
        try{
            DataInputStream ugyfeltol = new DataInputStream(
                    kapcsolat.getInputStream());
            DataOutputStream ugyfelnek = new DataOutputStream(
                    kapcsolat.getOutputStream());
            while(true){
                int menu;
                Beolvas();
                do{
                    menu = ugyfeltol.readInt();
                    switch (menu){

                    }


                }while(menu != -1);
            }
        }catch (IOException ex){
            System.out.println(ex);
        }
    }
    private void Beolvas(){
        try{
            BufferedReader br =  new BufferedReader(new FileReader("weather.txt"));
            br.readLine();
            String sor = br.readLine();
            while (sor != null){
                Idojaras i = new Idojaras(sor);
                String megye = i.getMegye();
                elorejelzes.put(megye,i);
                sor = br.readLine();
            }
            for (Map.Entry<String, Idojaras> entry:elorejelzes.entrySet()) {
                System.out.println(entry);
            }

        }catch (FileNotFoundException ex){
            System.out.println(ex);
        }catch (IOException ex){
            System.out.println(ex);
        }
    }
    private void feladat1(){

    }
    private void feladat2(){

    }
    private void feladat3(){

    }
    private void feladat4(){

    }
    private void feladat5(){

    }
}

package feladat04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UgyfelKiszolgalo implements Runnable{

    private HashMap<String,Idojaras> elorejelzes;

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

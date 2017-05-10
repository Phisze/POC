package gameutil2d.project;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import gameutil2d.classes.basic.Image;

/**
 * Created by wever on 07/05/2017.
 */

public class Randomize {
//Randomizar o x dos inimigos, a vida(fazendo a devidas verificações), qual vai ser ele e o contador de tempo para spaw
    private int i;
    private int nVida;

    public int RandomizeX(){
        Random random=new Random();
        int x=random.nextInt(651);
        return x;
    }

    public int RandomizeI(){
        Random random=new Random();
        int i=random.nextInt(3);
        return i;
    }

    public int RandomizeNVida(){
        Random random=new Random();
        int nVida=random.nextInt(3);
        return  nVida;
    }

    public long cont(){
        long tempo = System.currentTimeMillis();
        long seconds = TimeUnit.MILLISECONDS.toSeconds(tempo);
        return seconds;
    }
}

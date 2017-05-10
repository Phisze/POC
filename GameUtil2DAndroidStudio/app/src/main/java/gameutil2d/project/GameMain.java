package gameutil2d.project;

import gameutil2d.framework.*;

import android.content.Context;
import android.view.MotionEvent;

import com.twicecircled.spritebatcher.SpriteBatcher;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import gameutil2d.classes.basic.*;
import gameutil2d.classes.scene.*;
import gameutil2d.classes.character.*;
import gameutil2d.classes.text.*;


public class GameMain {


    Image background, background1H,backgroundxH, background2Ah,backgroundxAh;
    Image jogador;
    Image seta_esquerda, seta_direita;
    Image xaviao;
    Image zaviao;
    Image zepelin;
    ArrayList<Image> inimigos;
    Randomize r;

    enum Acao {PARADO, SENTIDO_HORARIO, SENTIDO_ANTIHORARIO}

    Acao acaoPassaro = Acao.PARADO;

    public GameMain(Context context) {
        /* Construtor da classe GameMain
		 * Nesse método inicializamos todas as variáveis de controle, objetos e entre
		 * outros elementos do jogo (imagens, animações e personagens)*/

        //Insira seu código aqui
        r=new Randomize();
       r.cont();

        background = new Image(context, R.drawable.cenariop, 0, -100, 1500, 700);

        background1H = new Image(context, R.drawable.c1af, -1000, -500, 2500, 1500);
        backgroundxH = new Image(context, R.drawable.c1af, 1000, -830, 2500, 1500);

        background2Ah = new Image(context, R.drawable.c1f, -1000, -560, 2500, 1500);
        backgroundxAh = new Image(context, R.drawable.c1f, -3500, -960, 2500, 1500);

        jogador = new Image(context, R.drawable.jogador, 0, 0, 800, 500);

        zaviao = new Image(context, R.drawable.javiao, r.RandomizeX(), 130, 140, 70);
        xaviao = new Image(context, R.drawable.haviao, r.RandomizeX(), 130, 140, 70);
        zepelin = new Image(context, R.drawable.jhzepelin, r.RandomizeX(), 130, 140, 70);

        inimigos = new ArrayList<Image>();

        inimigos.add(zaviao);
        inimigos.add(xaviao);
        inimigos.add(zepelin);

        seta_direita = new Image(context, R.drawable.seta_direita_vermelha, 800 - 96, 480 - 96, 96, 96);
        seta_esquerda = new Image(context, R.drawable.seta_esquerda_vermelha, 0, 480 - 96, 96, 96);
    }


    public void onScreenLoading(int w, int h, OrientationMode orientation) {
		/* Método que é executado logo após o construtor da classe GameMain
		 * Aqui carregamos todos os elementos (imagens, animações, personagens) que dependam
		 * das informações de largura (w) e altura (h) da tela do jogo, incluindo também sua
		 * orientação (orientation)
		 */

        //Insira seu código aqui
    }


    public void Update() {
        //Método responsável pela execução da lógica do jogo (movimento, ação, colisões e etc.)

        //Insira seu código aqui
        r=new Randomize();
        if(r.cont()%30==0){
            inimigos.get(0).SetX(r.RandomizeX());
            inimigos.get(1).SetX(r.RandomizeX());
            inimigos.get(2).SetX(r.RandomizeX());
        }

        if (acaoPassaro == Acao.SENTIDO_HORARIO) {
            xaviao.MoveByX(-3);
            zaviao.MoveByX(-3);
            zepelin.MoveByX(-3);

            background1H.MoveByX(-6);
            background1H.MoveByY(1);
            backgroundxH.MoveByX(-6);
            backgroundxH.MoveByY(1);


            //se para redesenhar 1
            if (background1H.GetX() <= -1700) {
                background1H.SetX(-1000);
                background1H.SetY(-500);
            }
            if (backgroundxH.GetX() <= -1700) {
                backgroundxH.SetX(1000);
                backgroundxH.SetY(-830);
            }
/*
            //se ´para redesenhar o x
            if (backgroundxH.GetX() == -2000) {
                background1H.SetX(3000);
                background1H.SetY(-750);
            }
*/

            //if (background1.GetY() > -100) {
            //    );
            //}
        }
        else if (acaoPassaro == Acao.SENTIDO_ANTIHORARIO) {
            //Move o passaro (até o limite da tela)
            xaviao.MoveByX(3);
            zaviao.MoveByX(3);
            zepelin.MoveByX(3);

            background2Ah.MoveByX(6);
            background2Ah.MoveByY(1);
            backgroundxAh.MoveByX(6);
            backgroundxAh.MoveByY(1);


            //se para redesenhar 1
            if (background2Ah.GetX() >= 0) {
                background2Ah.SetX(-1000);
                background2Ah.SetY(-560);
            }
            if (backgroundxAh.GetX() >= 0) {
                backgroundxAh.SetX(-3500);
                backgroundxAh.SetY(-960);
            }
/*
            //se ´para redesenhar o x
            if (backgroundxH.GetX() == -2000) {
                background1H.SetX(3000);
                background1H.SetY(-750);
            }
*/

            //if (background1.GetY() > -100) {
            //    );
            //}


//            zaviao.MoveByX(3);
//            zepelin.MoveByX(3);
//            xaviao.MoveByX(3);
//            background2Ah.MoveByX(4);
//            //if (background2.GetX() > -220) {
//            //    background2.SetX(-480);
//            //}
//            background2Ah.MoveByY(1);
//            //if (background2.GetY() > -100) {
//            //   background2.SetY(-150);
//            //}
        }
    }

    public void Draw(SpriteBatcher spriteBatcher) {
        //Método responsável por desenhar todos os elementos do jogo na tela (através do objeto "spriteBatcher")

        //Insira seu código aqui
        r=new Randomize();
        if (acaoPassaro == Acao.PARADO) {
            background.Draw(spriteBatcher);
        } else if (acaoPassaro == Acao.SENTIDO_HORARIO) {
            background1H.Draw(spriteBatcher);
            backgroundxH.Draw(spriteBatcher);
        } else if (acaoPassaro == Acao.SENTIDO_ANTIHORARIO) {
            background2Ah.Draw(spriteBatcher);
            backgroundxAh.Draw(spriteBatcher);
        }
        jogador.Draw(spriteBatcher);

        if(r.cont()>=10) {
            inimigos.get(0).Draw(spriteBatcher);
            inimigos.get(1).Draw(spriteBatcher);
            inimigos.get(2).Draw(spriteBatcher);
            }

//        zaviao.Draw(spriteBatcher);
//        xaviao.Draw(spriteBatcher);
//        zepelin.Draw(spriteBatcher);

        seta_direita.Draw(spriteBatcher);
        seta_esquerda.Draw(spriteBatcher);

    }

    public void onTouch(MotionEvent e) {
        //Método executado quando ocorre algum evento de toque sobre a superficie da tela

        //Insira seu código aqui
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            //Seta direta foi tocada ????
            if (seta_direita.IsTouch(e.getX(), e.getY())) {
                acaoPassaro = Acao.SENTIDO_HORARIO;
            } else if (seta_esquerda.IsTouch(e.getX(), e.getY())) {
                acaoPassaro = Acao.SENTIDO_ANTIHORARIO;
            }
        }    //tirou o dedo da tela
        else if (e.getAction() == MotionEvent.ACTION_UP) {
            acaoPassaro = Acao.PARADO;
        }
    }

    public void onExitGame() {
		/* Método que é executado quando o jogo é encerrado
		   Adequado para a finalização de threads e músicas de fundo do jogo*/

        // Insira seu código aqui


    }

    public void onPauseGame() {
        /* Método que é executado quando o botão "HOME"
           do aparelho é pressionado ou quando a execução do jogo é suspensa*/

        // Insira seu código aqui
    }

    public void onResumeGame() {
        // Disparado quando a aplicação volta a ser executada

        // Insira seu código aqui

    }

    public void onBackButtonPressed() {
        /*
           OBS: Para esse evento funcionar execute a instrução abaixo no método GameMain
           ((GameActivity) context).SetCanClose(false);
           Esse método é executado quando o botão BACK do aparelho é pressionado
         */

        // Insira seu código aqui
    }



}

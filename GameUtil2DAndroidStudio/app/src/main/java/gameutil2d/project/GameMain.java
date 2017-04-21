package gameutil2d.project;

import gameutil2d.framework.*;
import android.content.Context;
import android.view.MotionEvent;

import com.twicecircled.spritebatcher.SpriteBatcher;

import gameutil2d.classes.basic.*;
import gameutil2d.classes.scene.*;
import gameutil2d.classes.character.*;
import gameutil2d.classes.text.*;



public class GameMain {


    Image background;
    Image background1, background2;

    Image jogador;
    Image seta_esquerda, seta_direita;

    enum Acao { PARADO, SENTIDO_HORARIO, SENTIDO_ANTIHORARIO};
    Acao acaoS = Acao.PARADO;


    public GameMain(Context context)
    {
		/* Construtor da classe GameMain
		 * Nesse método inicializamos todas as variáveis de controle, objetos e entre
		 * outros elementos do jogo (imagens, animações e personagens)*/

        //Insira seu código aqui
        background=new Image(context,R.drawable.cenariop,0,-100,1500,700);
        background1=new Image(context, R.drawable.c1q,-220,-145,1500,800);
        background2=new Image(context, R.drawable.c1aq,-200,-185,1500,787);
        jogador=new Image(context,R.drawable.jogador,0,0,800,500);
        seta_direita = new Image(context,R.drawable.seta_direita_vermelha,800 - 96, 480 - 96,96,96);
        seta_esquerda = new Image(context,R.drawable.seta_esquerda_vermelha,0, 480 - 96,96,96);
    }



    public void onScreenLoading(int w, int h, OrientationMode orientation)
    {
		/* Método que é executado logo após o construtor da classe GameMain
		 * Aqui carregamos todos os elementos (imagens, animações, personagens) que dependam
		 * das informações de largura (w) e altura (h) da tela do jogo, incluindo também sua
		 * orientação (orientation)
		 */

        //Insira seu código aqui
    }



    public void Update()
    {
        //Método responsável pela execução da lógica do jogo (movimento, ação, colisões e etc.)

        //Insira seu código aqui
        /*background.MoveByX(-1);
        if(background.GetX() < -680)
            background.SetX(0)*/;


        if(acaoS == Acao.SENTIDO_HORARIO){
            //Move o passaro (até o limite da tela)
            background1.MoveByX(-1);
            if(background1.GetX() < -500)
                background1.SetX(-230);
        }

        if(acaoS == Acao.SENTIDO_ANTIHORARIO){
            //Move o passaro (até o limite da tela)
            background2.MoveByX(1);
            if(background2.GetX() > -210)
                background2.SetX(-450);
        }
    }

    public void Draw(SpriteBatcher spriteBatcher)
    {
        //Método responsável por desenhar todos os elementos do jogo na tela (através do objeto "spriteBatcher")

        //Insira seu código aqui
        if(acaoS == Acao.PARADO) {
            background.Draw(spriteBatcher);
        }

        else if(acaoS == Acao.SENTIDO_ANTIHORARIO){
            background2.Draw(spriteBatcher);
        }

        else if(acaoS == Acao.SENTIDO_HORARIO){
            background1.Draw(spriteBatcher);
        }

        jogador.Draw(spriteBatcher);
        seta_direita.Draw(spriteBatcher);
        seta_esquerda.Draw(spriteBatcher);
    }

    public void onTouch(MotionEvent e)
    {
        //Método executado quando ocorre algum evento de toque sobre a superficie da tela

        //Insira seu código aqui
        if(e.getAction() == MotionEvent.ACTION_DOWN)
        {
            //Seta direta foi tocada ????
            if(seta_direita.IsTouch(e.getX(),e.getY()))
            {
                acaoS = Acao.SENTIDO_HORARIO;

            }
            else if(seta_esquerda.IsTouch(e.getX(),e.getY()))
            {
                acaoS = Acao.SENTIDO_ANTIHORARIO;


            }
        }    //tirou o dedo da tela
        else if(e.getAction() == MotionEvent.ACTION_UP)
        {
            acaoS = Acao.PARADO;
        }

    }

    public void onExitGame()
    {
		/* Método que é executado quando o jogo é encerrado
		   Adequado para a finalização de threads e músicas de fundo do jogo*/

        // Insira seu código aqui

    }

    public void onPauseGame()
    {
        /* Método que é executado quando o botão "HOME"
           do aparelho é pressionado ou quando a execução do jogo é suspensa*/

        // Insira seu código aqui
    }

    public void onResumeGame()
    {
       // Disparado quando a aplicação volta a ser executada

       // Insira seu código aqui

    }

    public void onBackButtonPressed()
    {
        /*

           OBS: Para esse evento funcionar execute a instrução abaixo no método GameMain
           ((GameActivity) context).SetCanClose(false);

           Esse método é executado quando o botão BACK do aparelho é pressionado

         */

        // Insira seu código aqui
    }

}

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



    Image background, background1, background2;
    Image jogador;
    Image seta_esquerda, seta_direita;
    Image xaviao;
    Image zaviao;
    Image zepelin;


    enum Acao { PARADO, SENTIDO_HORARIO, SENTIDO_ANTIHORARIO};

    Acao acaoPassaro = Acao.PARADO;

    public GameMain(Context context)
    {
		/* Construtor da classe GameMain
		 * Nesse método inicializamos todas as variáveis de controle, objetos e entre
		 * outros elementos do jogo (imagens, animações e personagens)*/

        //Insira seu código aqui
        background=new Image(context,R.drawable.cenariop,0,-100,1500,700);
        background1=new Image(context,R.drawable.c1aq,-220,-150,1500,700);
        background2=new Image(context,R.drawable.c1q,0,-150,1500,700);

        jogador=new Image(context,R.drawable.jogador,0,0,800,500);

        zaviao = new Image(context,R.drawable.javiao,650,130,140,70);
        xaviao = new Image(context,R.drawable.haviao,0,130,140,70);
        zepelin = new Image(context,R.drawable.jhzepelin,350,130,140,70);

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

        if(acaoPassaro == Acao.SENTIDO_HORARIO)
        {
            xaviao.MoveByX(-3);
            zaviao.MoveByX(-3);
            zepelin.MoveByX(-3);
            background1.MoveByX(-4);
            if(background1.GetX() < -480){
            background1.SetX(-220);
        }
            background1.MoveByY(1);
            if(background1.GetY() > -100){
                background1.SetY(-150);
            }
        }
        else if (acaoPassaro == Acao.SENTIDO_ANTIHORARIO)
        {
            //Move o passaro (até o limite da tela)
            xaviao.MoveByX(3);
            zaviao.MoveByX(3);
            zepelin.MoveByX(3);
            background2.MoveByX(4);
            if(background2.GetX() > -220){
                background2.SetX(-480);
        }
            background2.MoveByY(1);
            if(background2.GetY() > -100){
                background2.SetY(-150);
            }
    }
    }
    public void Draw(SpriteBatcher spriteBatcher)
    {
        //Método responsável por desenhar todos os elementos do jogo na tela (através do objeto "spriteBatcher")

        //Insira seu código aqui

        if (acaoPassaro == Acao.PARADO) {
            background.Draw(spriteBatcher);
        }
        else if(acaoPassaro == Acao.SENTIDO_HORARIO){
            background1.Draw(spriteBatcher);
        }
        else if(acaoPassaro == Acao.SENTIDO_ANTIHORARIO){
            background2.Draw(spriteBatcher);
        }
        jogador.Draw(spriteBatcher);

        zaviao.Draw(spriteBatcher);
        xaviao.Draw(spriteBatcher);
        zepelin.Draw(spriteBatcher);

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
        else if(e.getAction() == MotionEvent.ACTION_UP)
        {
            acaoPassaro = Acao.PARADO;
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

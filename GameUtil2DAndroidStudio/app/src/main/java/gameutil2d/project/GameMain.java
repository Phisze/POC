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
    Image jogador;

    public GameMain(Context context)
    {
		/* Construtor da classe GameMain
		 * Nesse método inicializamos todas as variáveis de controle, objetos e entre
		 * outros elementos do jogo (imagens, animações e personagens)*/

        //Insira seu código aqui
        background=new Image(context,R.drawable.cenariop,0,-100,1500,700);
        jogador=new Image(context,R.drawable.jogador,0,0,800,500);

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
        background.MoveByX(-1);
        if(background.GetX() < -680)
            background.SetX(0);
    }

    public void Draw(SpriteBatcher spriteBatcher)
    {
        //Método responsável por desenhar todos os elementos do jogo na tela (através do objeto "spriteBatcher")

        //Insira seu código aqui
        background.Draw(spriteBatcher);
        jogador.Draw(spriteBatcher);

    }

    public void onTouch(MotionEvent e)
    {
        //Método executado quando ocorre algum evento de toque sobre a superficie da tela

        //Insira seu código aqui


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

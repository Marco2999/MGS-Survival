package Game.GameStates;

import Main.Handler;
import Resources.Images;
import UI.ClickListlener;
import UI.UIImageButton;
import UI.UIManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Created by AlexVR on 7/1/2018.
 */


public class GameOver extends State {

    private int count = 0;
    private UIManager uiManager;
    

    public GameOver(Handler handler) {
    	
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);
        
        uiManager.addObjects(new UIImageButton(100, (223+(64+16))+(64+16), 128, 64, Images.butstart, new ClickListlener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUimanager(null);
                handler.getGame().reStart();
                State.setState(handler.getGame().gameState);
            }
        }));


        uiManager.addObjects(new UIImageButton(500, (223+(64+16))+(64+16), 128, 64, Images.BTitle, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().menuState);
        }));}



    

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();
        count++;
        if( count>=30){
            count=30;
        }
        if(handler.getKeyManager().pbutt && count>=30){
            count=0;

            State.setState(handler.getGame().gameState);
        }


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.SNAKE,0,0,790,800,null);
        uiManager.Render(g);

    }
    public static void playmusic(String filepath) {
    
}
}

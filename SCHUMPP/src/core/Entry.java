package core;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import objects.Background;
import objects.Spaceship;
import render.Renderer;
import update.Updater;

import objects.EnemySpaceshipSpawner;

public class Entry {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Window window = new Window("SCHUMPP", Window.getWinWidth(), Window.getWinHeight());
        Renderer renderer = new Renderer();
        Updater updater = new Updater();
        
        window.addKeyListener(new Input());
        window.add(renderer);
        window.packWindow();
        window.setVisible(true);

        boolean runGame = true;
        
        new Spaceship((Window.getWinWidth() / 2) - (Spaceship.width / 2), Window.getWinHeight() - 150);
        new Background(-Window.getWinHeight());
        new EnemySpaceshipSpawner();

        FPS.calcBeginTime();
        while (runGame) {
        	updater.update();
        	renderer.repaint();
            FPS.calcDeltaTime();
        }
    }
}

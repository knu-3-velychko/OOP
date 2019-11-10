package com.tai.lab3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import static com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class MainScreen implements Screen {

    final MainCore mainCore;

    private Stage stage;
    private TextButtonStyle style;
    private BitmapFont font;
    private Skin skin;

    TextButton runWhiteButton;
    TextButton runBlackButton;
    TextButton exitButton;

    public MainScreen(final MainCore mainCore) {
        this.mainCore = mainCore;

        setUpStyles();
        setUpButtons();

    }

    private void setUpStyles() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();
        skin = new Skin();

        skin.add("up-button", new Texture("WhiteSquare.png"));
        skin.add("down-button", new Texture("WhiteSquare_hover.png"));

        style = new TextButtonStyle();
        style.font = font;
        style.up = skin.getDrawable("up-button");
        style.down = skin.getDrawable("down-button");
    }

    private void setUpButtons() {
        float x = (Constants.SCREEN_WIDTH - Constants.BUTTON_WIDTH) / 2;
        float y = (Constants.SCREEN_HEIGHT - Constants.BUTTON_HEIGHT * 5) / 2;
        runWhiteButton = addButton("Start white", Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT, x, y + 4 * Constants.BUTTON_HEIGHT);
        runBlackButton = addButton("Start black", Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT, x, y + 2 * Constants.BUTTON_HEIGHT);
        exitButton = addButton("Exit", Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT, x, y);

        runWhiteButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed");
                mainCore.changeScreen(new CheckersGameScreen(mainCore, Color.White));
            }
        });

        runBlackButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed");
                mainCore.changeScreen(new CheckersGameScreen(mainCore, Color.Black));
            }
        });

        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                mainCore.exit();
            }
        });
    }

    private TextButton addButton(String text, float width, float height, float xPos, float yPos) {
        TextButton button = new TextButton(text, style);
        button.setWidth(width);
        button.setHeight(height);
        button.setPosition(xPos, yPos);
        stage.addActor(button);
        return button;
    }

    void changeScreen() {
        System.out.println("here");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        runBlackButton.remove();
        runWhiteButton.remove();
        exitButton.remove();
    }

    @Override
    public void dispose() {

    }
}

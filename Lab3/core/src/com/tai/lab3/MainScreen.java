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

public class MainScreen implements Screen {

    final MainCore mainCore;

    Stage stage;
    TextButton button;
    TextButton.TextButtonStyle style;
    BitmapFont font;
    Skin skin;

    public MainScreen(final MainCore mainCore) {
        this.mainCore = mainCore;

        setUpStyles();

        addButton(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);


        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed");
                mainCore.changeScreen(new CheckersGameScreen(mainCore));
            }
        });
    }

    private void setUpStyles() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();
        skin = new Skin();

        skin.add("up-button", new Texture("WhiteSquare.png"));
        skin.add("down-button", new Texture("WhiteSquare_hover.png"));

        style = new TextButton.TextButtonStyle();
        style.font = font;
        style.up = skin.getDrawable("up-button");
        style.down = skin.getDrawable("down-button");
    }

    private void addButton(float width, float height) {
        button = new TextButton("Button1", style);
        button.setWidth(width);
        button.setHeight(height);
        button.setPosition(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT / 2);
        stage.addActor(button);
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

    }

    @Override
    public void dispose() {

    }
}

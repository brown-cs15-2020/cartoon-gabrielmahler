package cartoon;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.animation.Timeline;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import sun.lwawt.macosx.CSystemTray;


public class PaneOrganizer {
    public BorderPane _root;
    public Pane rectsPane;
    public Pane playerPane;
    public Pane meteoritePane;
    public Pane junkPane;
    public Pane finishPane;

    public FallingObject _fallingObject;
    public Meteorite _meteorite;
    private Label _score;
    public Integer scoreValue = 0;

    public Player _player;

    public PaneOrganizer() {
        _root = new BorderPane();
        _root.setStyle("-fx-background-color: gray;");
        this.createRectsPane();
        this.createScore();
        this.setupTimeline(true);
        rectsPane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
        rectsPane.setFocusTraversable(true);
    }

    public BorderPane getRoot() {
        return _root;
    }

    public void createRectsPane() {
        playerPane = new Pane();
        rectsPane = new Pane();
        meteoritePane = new Pane();
        junkPane = new Pane();
        rectsPane.setPrefSize(cartoon.Constants.RECT_PANE_WIDTH, Constants.RECT_PANE_HEIGHT);
        rectsPane.setStyle("-fx-background-color: black");
        this.createStarBackGround(rectsPane);
        _root.setTop(rectsPane);
        _player = new Player(playerPane);
        rectsPane.getChildren().addAll(playerPane);
//        _fallingObject = new FallingObject(junkPane);
        _meteorite = new Meteorite(meteoritePane);
        rectsPane.getChildren().addAll(junkPane, meteoritePane);
    }

    public void createScore() {
        VBox scorePane = new VBox();
        scorePane.setAlignment(Pos.CENTER);
        _score = new Label("Score: 0");
        scorePane.getChildren().addAll(_score);
        _root.setBottom(scorePane);
    }


    public void setupTimeline(boolean OnOrOff) {
        KeyFrame kf = new KeyFrame(Duration.millis(20), new TimeHandler());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        if (OnOrOff) {
            timeline.play();
        }
        else{
            timeline.stop();
        }
    }

    private class TimeHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            boolean isInGame = false;
            if (_meteorite == null){
                isInGame = _fallingObject.checkFallingOnPlane();
                }
            else if (_fallingObject == null) {
                isInGame = _meteorite.checkMeteoriteOnPlane();
            }


            if (collisionDetector()) {
                setupTimeline(false);
                finishPane = new Pane();
                FinishScreen finish = new FinishScreen(finishPane, scoreValue);
                rectsPane.getChildren().addAll(finishPane);
            }
            else {
                if (isInGame) {
                    if (_fallingObject == null){
                        _meteorite.moveMeteorite(scoreValue);
                    }
                    else if (_meteorite == null) {
                        _fallingObject.moveFallObject(scoreValue);
                    }
                }
                else if(isInGame == false) {
////                    if (_meteorite == null){
//                        rectsPane.getChildren().remove(junkPane);
//                    }
////                    if (_fallingObject == null) {
//                        rectsPane.getChildren().remove(meteoritePane);
//                        }
                    int meteoriteOrJunk = 0;
                    if (Math.random() > 0.5){
                        meteoriteOrJunk = 1;
                    }
                    switch (meteoriteOrJunk){ // randomly creating either meteorite or fallingobject
                        case 0:
                            _fallingObject = new FallingObject(junkPane);
//                            rectsPane.getChildren().add(junkPane);
                            System.out.println("Falling object");
                            break;
                        case 1:
                            _meteorite = new Meteorite(meteoritePane);
//                            rectsPane.getChildren().add(meteoritePane);
                            System.out.println("meteorite");
                            break;
                    }

                }
                scoreValue += 1;
                _score.setText("Score: " + scoreValue.toString());
            }
        }
    }
        private class KeyHandler implements EventHandler<KeyEvent> {
            @Override
            public void handle(KeyEvent e) {
                KeyCode keyPressed = e.getCode();
                switch (keyPressed) {
                    case A:
                        _player.moveLeft();
                        break;
                    case D:
                        _player.moveRight();
                        break;
                }
                e.consume();
            }
        }

        public boolean collisionDetector() {
            boolean collision = false;
            if (_meteorite == null){
                if (_fallingObject._object.getBoundsInParent().intersects(_player._playerBody.getBoundsInParent())){
                    collision = true;
                }
            }
            else if (_fallingObject == null) {
                if (_meteorite._objectMeteorite.getBoundsInLocal().intersects(_player._playerBody.getBoundsInParent())){
                    collision = true;
                }
            }
            return collision;
        }

        public void createStarBackGround(Pane rectsPane){
            Circle star;
            double yStar;
            double xStar;
            Color starColor = Color.rgb(247,245,172);
            for (int i = 0; i < 400; i+=1){
                star = new Circle(3, starColor);
                yStar = (int)(Math.random()*550);
                xStar = (int)(Math.random()*1000);
                star.setCenterX(xStar);
                star.setCenterY(yStar);
                rectsPane.getChildren().addAll(star);
            }
        }
    }




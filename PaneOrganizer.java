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
import javafx.util.Duration;
import javafx.geometry.Bounds;



public class PaneOrganizer {
    //TODO: use this class to set up your panes, your quit button, and to create an instance of your top-level logic class!
    public BorderPane _root;
    public Pane rectsPane;

    public FallingObject _fallingObject;
    private Label _score;
    public Integer scoreValue = 0;
    public Player _player;

    public PaneOrganizer() {
        _root = new BorderPane();
        _root.setStyle("-fx-background-color: orange;");
        this.createRectsPane();
        this.createScore();
        this.setupTimeline();
        rectsPane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
        rectsPane.setFocusTraversable(true);


    }

    public BorderPane getRoot() {
        return _root;
    }

    public void createRectsPane() {
        rectsPane = new Pane();
        rectsPane.setPrefSize(cartoon.Constants.RECT_PANE_WIDTH, Constants.RECT_PANE_HEIGHT);
        rectsPane.setStyle("-fx-background-color: black");
        _root.setTop(rectsPane);
        _player = new Player(rectsPane);
        _fallingObject = new FallingObject();
        rectsPane.getChildren().addAll(_fallingObject.getFallingObjectNode());
        rectsPane.getChildren().addAll(_player.getPlayerNode());
    }

    public void createScore() {
        VBox scorePane = new VBox();
        scorePane.setAlignment(Pos.CENTER);
        _score = new Label("Score: 0");
        scorePane.getChildren().addAll(_score);
        _root.setBottom(scorePane);
    }


    public void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.millis(20), new TimeHandler());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private class TimeHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            boolean isInGame = _fallingObject.checkOnPlane();
            boolean collisionDetection = collisionDetector();
            if (collisionDetection) {
                Platform.exit();
            } else {
                if (isInGame) {
                    _fallingObject.moveFallObject();
                } else {
                    rectsPane.getChildren().remove(_fallingObject);
                    _fallingObject = new FallingObject();
                    rectsPane.getChildren().addAll(_fallingObject.getFallingObjectNode());
                }
                scoreValue += 1;
                _score.setText("Score: " + scoreValue.toString());


//            for (Node object : rectsPane.getChildren()) {
//                if (object instanceof FallingObject){
//
//                }
//            }


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
            return (_player._playerBody.intersects(_fallingObject._object.getBoundsInLocal()));

        }

        public void stopAnimation() {

        }
    }




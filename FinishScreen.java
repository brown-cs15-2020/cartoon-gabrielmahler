package cartoon;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.Text;

public class FinishScreen {
    public Ellipse _head;
    public Rectangle _background;
    public Line _leftBone;
    public Line _rightBone;
    public Circle _rightEye;
    public Circle _leftEye;
    public Text youLoseText;
    public Text gameOverText;
    public Text yourScoreText;

    public FinishScreen(Pane finishPane, double score){
        _background = new Rectangle();
        _background.setWidth(500);
        _background.setHeight(400);
        _background.setLayoutX(250);
        _background.setLayoutY(75);
        _background.setStroke(Color.rgb(111,120,119));
        _background.setFill(Color.rgb(53, 59,58));
//
//        _head = new Ellipse(70, 83);
//        _head.setCenterX(500);
//        _head.setCenterY(220);
//        _head.setStroke(Color.rgb(0,0,0));
//        _head.setFill(Color.rgb(255,255,255));
//
//        _rightEye = new Circle(18, Color.BLACK);
//        _rightEye.setCenterY(200);
//        _rightEye.setCenterX(530);
//
//        _leftEye = new Circle(18, Color.BLACK);
//        _leftEye.setCenterY(200);
//        _leftEye.setCenterX(470);
//
//        _leftBone = new Line();
//        _leftBone.setStartX(270);
//        _leftBone.setStartY(250);
//        _leftBone.setEndX(730);
//        _leftBone.setEndY(435);
//        _leftBone.setFill(Color.WHITE);
//        _leftBone.setStroke(Color.BLACK);
        youLoseText = new Text(300, 185, "GAME OVER");
        youLoseText.setFont(new Font(75));
        youLoseText.setFill(Color.rgb(255,255,255));

        gameOverText = new Text(360, 275, "YOU LOSE");
        gameOverText.setFont(new Font(55));
        gameOverText.setFill(Color.rgb(255,26,26));

        yourScoreText = new Text(370, 420, "Your Score:  " + String.valueOf((int) score));
        yourScoreText.setFont(new Font(35));
        yourScoreText.setFill(Color.rgb(44,94,232));





        finishPane.getChildren().addAll(_background, youLoseText, gameOverText, yourScoreText);

    }

}

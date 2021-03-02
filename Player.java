package cartoon;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;


public class Player {
    Rectangle _playerBody;
    public Player(Pane playerPane) {
        _playerBody = new Rectangle();
        _playerBody.setFill(Color.YELLOW);
        _playerBody.setX(Constants.PLAYER_X_LOCATION);
        _playerBody.setY(Constants.PLAYER_Y_LOCATION);
        _playerBody.setHeight(Constants.PLAYER_SIZE);
        _playerBody.setWidth(Constants.PLAYER_SIZE);
    }

    public void moveRight() {
        double currentX = _playerBody.getLayoutX();
        if (currentX < 500) {
            _playerBody.setLayoutX(currentX + Constants.PLAYER_MOVE);
        }
    }
    public void moveLeft() {
        double currentX = _playerBody.getLayoutX();
        if (currentX > -500) {
            _playerBody.setLayoutX(currentX - Constants.PLAYER_MOVE);
        }
    }

    public Node getPlayerNode() {
        return _playerBody;
    }
}

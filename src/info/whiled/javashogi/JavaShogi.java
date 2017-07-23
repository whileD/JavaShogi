package info.whiled.javashogi;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.stream.IntStream;

/**
 * Created by whiled on 17/07/13.
 */
public class JavaShogi extends Application {
    public static void main(String[] args) {
        launch();
    }

    private static final int CELL_SIZE = 30;
    @Override
    public void start(Stage stage) throws Exception {
        Group gridGroup = new Group();


        //Gridの生成
        IntStream.range(0,9).boxed().forEach(i ->
            IntStream.range(0,9).boxed().forEach(j ->{
                Rectangle rectangle = new Rectangle(i*CELL_SIZE, j*CELL_SIZE, CELL_SIZE,CELL_SIZE);
                rectangle.setFill(Color.BLACK);
                rectangle.setStroke(Color.GRAY);
                rectangle.setOnMouseExited(mouseEvent -> {
                    rectangle.setFill(Color.WHITE);
                });
                Text text = new Text(i*CELL_SIZE, j*CELL_SIZE, "T");
                gridGroup.getChildren().addAll(rectangle, text);

            })
        );


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridGroup);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(300);
        stage.show();
    }
}

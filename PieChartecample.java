package knk;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

public class PieChartecample extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane bp = new BorderPane();
        PieChart pc = new PieChart();
        pc.setTitle("Numri i oreve te Profesoreve - Bachelor");
        ObservableList <PieChart.Data> ol = FXCollections.observableArrayList(

                new PieChart.Data("Blerim Rexha", 20),
                new PieChart.Data("Isak Shabani", 18),
                new PieChart.Data("Qefsere Doko Gjonbalaj", 12),
                new PieChart.Data("Gentian Strana", 16),
                new PieChart.Data("Besmir Sejdiu", 10),
                new PieChart.Data("Valon Raca", 12),
                new PieChart.Data("Shqipe Lohaj", 14),
                new PieChart.Data("Qamil Kabashi", 14),
                new PieChart.Data("Lavdim Kurtaj", 16)

        );

        pc.setData(ol);
        bp.setCenter(pc);
        pc.setLegendSide(Side.LEFT);

        FadeTransition f = new FadeTransition(Duration.seconds(4),pc);
        f.setFromValue(0);
        f.setToValue(1);
        f.play();

        for (PieChart.Data data : pc.getData()){

            data.nameProperty().set(data.getName()+ " : "+(int)data.getPieValue()+ " ore");
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            JOptionPane.showMessageDialog(null,"Profesori --> "+ data.getName()+ "\nNumri i oreve -->" +(int)data.getPieValue());

                        }
                    }
            );
        }
        Scene sc = new Scene(bp,800,500);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Orari ne FIEK");
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}

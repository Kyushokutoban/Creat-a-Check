package cashRegister;

import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.Calendar;


public class Register extends Application
{
    private Check check;
    private HBox hBox;
    private VBox vBox1;
    private VBox vBox2;
    private VBox vBox3;
    private VBox vBox4;
    private BorderPane mainBorder;
    private static int countOfOrders = 0;
    private Calendar now = Calendar.getInstance();
    private Pane orders;
    private VBox basicInfo;
    private Label[] labels;
    private Button show;
    private ArrayList<Button> buttons = new ArrayList<>();


    @Override
    public void start(Stage stage)
    {
        check = new Check((int)((Math.random() * 10 + 0.5) * 2), (int)((Math.random() * 5 + 0.5)), "Staff A");

        mainBorder = new BorderPane();

        int date = now.get(Calendar.DAY_OF_MONTH);
        int month = now.get(Calendar.MONTH);
        int year = now.get(Calendar.YEAR);
        String today = "Date                            " + date + "/" + month + "/" + year + "";

        basicInfo = new VBox();
        labels = new Label[8];
        labels[0] = new Label("                                              "
                + "Welcome to Komeda's Coffee");

        labels[1] = new Label("                                                                                  "
                + today);

        labels[2] = new Label("                                                                                  "
                + "Check Number              " + check.getCheckNumber());

        labels[3] = new Label("                                                                                  "
                + "Table Number                 " + check.getTableNumber());

        labels[4] = new Label("                                                                                  "
                + "How Many People           " +check.getHowMany());

        labels[5] = new Label("                                                                                  "
                + "Staff Name                 " + check.getStaffName()
                + "\n" + "-----------------------------------------------" +
                "------------------------------------------------");
        show = new Button("Total");
        show.setOnAction(e ->{
            showOrders();
        });
        basicInfo.getChildren().addAll(labels[0], labels[1], labels[2], labels[3], labels[4], labels[5], show);
        mainBorder.setCenter(basicInfo);

        orders = new VBox();
        mainBorder.setBottom(orders);


        buttons.add(new Button(" BRAND  COFFEE"));
        buttons.add(new Button(" CAFE  ORE"));
        buttons.add(new Button("AMERICAN COFFEE"));
        buttons.add(new Button("MILK  COFFEE"));
        buttons.add(new Button("ICE  COFFEE"));
        buttons.add(new Button("ICE  ORE"));
        buttons.add(new Button("ICE MILK COFFEE "));
        buttons.add(new Button("MINISHIRONOWARE"));
        buttons.add(new Button("SHIRONOWARE"));
        buttons.add(new Button("MIX  SANDWICH  "));
        buttons.add(new Button("EGG  SANDWICH  "));
        buttons.add(new Button("FISH FRY BURGER"));

        // implementations of buttons
        buttons.get(0).setOnAction(e ->{
            check.addOrder("BRAND COFFEE");
            countOfOrders++;
            showOrders();
        });
        buttons.get(1).setOnAction(e ->{
            check.addOrder("CAFE ORE");
            countOfOrders++;
            showOrders();
        });
        buttons.get(2).setOnAction(e ->{
            check.addOrder("AMERICAN COFFEE");
            countOfOrders++;
            showOrders();
        });
        buttons.get(3).setOnAction(e ->{
            check.addOrder("MILK COFFEE");
            countOfOrders++;
            showOrders();
        });
        buttons.get(4).setOnAction(e ->{
            check.addOrder("ICE COFFEE");
            countOfOrders++;
            showOrders();
        });
        buttons.get(5).setOnAction(e ->{
            check.addOrder("ICE ORE");
            countOfOrders++;
            showOrders();
        });
        buttons.get(6).setOnAction(e ->{
            check.addOrder("ICE MILK COFFEE");
            countOfOrders++;
            showOrders();
        });
        buttons.get(7).setOnAction(e ->{
            check.addOrder("MINI SHIRONOWARE");
            countOfOrders++;
            showOrders();
        });
        buttons.get(8).setOnAction(e ->{
            check.addOrder("SHIRONOWARE");
            countOfOrders++;
            showOrders();
        });
        buttons.get(9).setOnAction(e ->{
            check.addOrder("MIX SANDWICH");
            countOfOrders++;
            showOrders();
        });
        buttons.get(10).setOnAction(e ->{
            check.addOrder("EGG SAND");
            countOfOrders++;
            showOrders();
        });
        buttons.get(11).setOnAction(e ->{
            check.addOrder("FISH FRY BURGER");
            countOfOrders++;
            showOrders();
        });


        vBox1 = new VBox();
        vBox1.getChildren().addAll(buttons.get(0), buttons.get(1), buttons.get(2));
        vBox2 = new VBox();
        vBox2.getChildren().addAll(buttons.get(3), buttons.get(4), buttons.get(5));
        vBox3 = new VBox();
        vBox3.getChildren().addAll(buttons.get(6), buttons.get(7), buttons.get(8));
        vBox4 = new VBox();
        vBox4.getChildren().addAll(buttons.get(9), buttons.get(10), buttons.get(11));

        hBox = new HBox();
        hBox.getChildren().addAll(vBox1, vBox2, vBox3, vBox4);
        mainBorder.setTop(hBox);

        Scene scene = new Scene(mainBorder);
        stage.setTitle("Check");
        stage.setScene(scene);
        stage.setWidth(470);
        stage.setHeight(500);
        stage.show();
    }

    public void showOrders()
    {
        orders.getChildren().clear();
        ArrayList<Integer> orderPrices = check.getOrderP();
        ArrayList<String> orderNames = check.getOrderN();
        Label sum = new Label(check.getTotalCheck() + "yen");

        for (int i = 0; i < countOfOrders; i++)
        {
            Label a = new Label(orderNames.get(i) + "                 " + orderPrices.get(i)
                    + "yen");
            this.orders.getChildren().add(a);
            if (i == countOfOrders-1)
            {
                orders.getChildren().add(new Label("------------------------------------" +
                        "-----------------------------------------------------------"));
            }
        }
        orders.getChildren().add(sum);
    }

    public static void main(String[] args) { Application.launch(args);}
}

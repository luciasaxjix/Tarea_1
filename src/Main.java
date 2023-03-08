import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {

    public Persona[] listaPersonas = new Persona[4];
    public ComboBox comboBoxPersona1;
    public ComboBox comboBoxPersona2;
    public TextField resultado;
    public int cantidad = 0;

    /**
     * Funcion main que inicia la aplicacion
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage paginaMain) throws Exception{

        paginaMain.setTitle("Tarea Mariela");


        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label aggPersona = new Label("Agregar Persona");
        GridPane.setConstraints(aggPersona,0,1, 2, 1);

        Label lNombre = new Label("Nombre:");
        GridPane.setConstraints(lNombre,0,2);
        TextField entryNombre = new TextField();
        GridPane.setConstraints(entryNombre,1,2);

        Label lProvincia = new Label("Provincia:");
        GridPane.setConstraints(lProvincia,0,3);
        ComboBox entryProvincia = new ComboBox();
        entryProvincia.getItems().addAll("San Jose", "Cartago","Limon","Alajuela","Heredia", "Guanacaste","Puntarenas");
        entryProvincia.setValue("Cartago");
        GridPane.setConstraints(entryProvincia,1,3);

        Label lEdad = new Label("Edad:");
        GridPane.setConstraints(lEdad,0,4);
        TextField entryEdad = new TextField();
        GridPane.setConstraints(entryEdad,1,4);

        Button btnaggPersona = new Button("+Persona");
        btnaggPersona.setOnAction(event -> agregarPersona(entryNombre.getText(),entryProvincia.getValue().toString(),Integer.parseInt(entryEdad.getText())));
        GridPane.setConstraints(btnaggPersona,0,5,2,1);

        Label linea = new Label("--------------------------------------------------------------------------------------------------");
        GridPane.setConstraints(linea,0,6,2,1);

        Label lPersona1 = new Label("Persona 1");
        GridPane.setConstraints(lPersona1, 0, 7);
        comboBoxPersona1 = new ComboBox<>();
        GridPane.setConstraints(comboBoxPersona1, 0,8);

        Label lPersona2 = new Label("Persona 2");
        GridPane.setConstraints(lPersona2, 1, 7);
        comboBoxPersona2 = new ComboBox<>();
        GridPane.setConstraints(comboBoxPersona2, 1,8);

        Button btnSuma = new Button("+");
        btnSuma.setOnAction(event -> operando("+",comboBoxPersona1.getValue().toString(),comboBoxPersona2.getValue().toString()));
        GridPane.setConstraints(btnSuma,0,9);

        Button btnResta = new Button("-");
        btnResta.setOnAction(event -> operando("-",comboBoxPersona1.getValue().toString(),comboBoxPersona2.getValue().toString()));
        GridPane.setConstraints(btnResta,1,9);

        Button btnMult = new Button("*");
        btnMult.setOnAction(event -> operando("*",comboBoxPersona1.getValue().toString(),comboBoxPersona2.getValue().toString()));
        GridPane.setConstraints(btnMult,0,10);

        Button btnDiv = new Button("/");
        btnDiv.setOnAction(event -> operando("/",comboBoxPersona1.getValue().toString(),comboBoxPersona2.getValue().toString()));
        GridPane.setConstraints(btnDiv,1,10);

        Label lResultado = new Label("Resultado: ");
        GridPane.setConstraints(lResultado,0,0);
        resultado = new TextField();
        GridPane.setConstraints(resultado,1,0);


        gridPane.getChildren().addAll(aggPersona,
                lNombre,entryNombre,
                lProvincia, entryProvincia,
                lEdad,entryEdad,
                btnaggPersona,
                linea,
                lPersona1, comboBoxPersona1,
                lPersona2, comboBoxPersona2,
                btnSuma,btnResta,
                btnMult,btnDiv,
                lResultado,resultado);

        Scene scene = new Scene(gridPane,500,370);

        paginaMain.setScene(scene);
        paginaMain.show();
    }

    public void agregarPersona(String nombre, String provincia, int edad){
        if (cantidad < 4 && !nombre.equals("") && !provincia.equals("") && edad>0){
            listaPersonas[cantidad] = new Persona(nombre, provincia, edad);
            cantidad++;
            comboBoxPersona1.getItems().add(nombre);
            comboBoxPersona2.getItems().add(nombre);
        }
        else {
            System.out.println("No mas");
        }
    }
    
    public void operando(String operador, String persona1, String persona2){
        int num1=0, num2=0;
        for (int i = 0; i < cantidad; i++) {
            if (listaPersonas[i].nombre == persona1){
                num1 = listaPersonas[i].edad;
            }
        }
        for (int i = 0; i < cantidad; i++) {
            if (listaPersonas[i].nombre == persona2){
                num2 = listaPersonas[i].edad;
            }
        }

        if (operador=="+"){
            int r = num1+num2;
            resultado.setText(String.valueOf(r));
        } else if (operador=="-") {
            int r = num1-num2;
            resultado.setText(String.valueOf(r));
        } else if (operador=="*") {
            int r = num1*num2;
            resultado.setText(String.valueOf(r));
        }
        else if (operador=="/") {
            int r = num1/num2;
            resultado.setText(String.valueOf(r));
        }

    }


}
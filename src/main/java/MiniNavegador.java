import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MiniNavegador extends Application {

    public static void main(String[] args) {
        launch(args);
    }


   public String formatarUrl (String url){
       if (!url.startsWith("http://") && !url.startsWith("https://")) {
           url = "https://" + url;
       }
   return url;}


    @Override
    public void start(Stage palco) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        TextField site = new TextField();
        site.setPromptText("Digite o site aqui");

        String inicial = "https://www.google.com/";

        webEngine.load(inicial);

        site.setOnAction(e -> {
            webEngine.load(formatarUrl(site.getText()));
        });

        VBox layout = new VBox(10, site, webView);
        Scene cena = new Scene(layout, 1200,700);
        palco.setTitle("Navegado web");
        palco.setScene(cena);
        palco.show();
    }

}

package marshallingService;

import com.google.gson.*;
import netscape.javascript.JSObject;
import productService.Category;
import productService.ProductsData;

import java.io.*;
import java.util.List;

public class GSONService {

    public ProductsData readFromGSON() {

        ProductsData productsData = new ProductsData();


        try (FileInputStream fis = new FileInputStream(new File("ProductList.json"));
             ObjectInputStream ois = new ObjectInputStream(fis)) {


            String jsonString = ois.readObject().toString();


            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(jsonString);

            JsonObject rootObject = jsonElement.getAsJsonObject(); // чтение главного объекта
            /*String message = rootObject.get("message").getAsString(); // получить поле "message" как строку
            JsonObject childObject = rootObject.getAsJsonObject("place"); // получить объект Place
            String place = childObject.get("name").getAsString(); // получить поле "name"
            System.out.println(message + " " + place); // напечатает "Hi World!"*/

            JsonElement categoryList = rootObject.get("categoryList");

            System.out.println(categoryList.toString());


        } catch (Exception e) {
            System.out.println("ЧТО-ТО СЛУЧИЛОСЬ ПРИ ЗАПИСИ В JSON");
            e.printStackTrace();
        }

        return productsData;

    }

    public void writeToGSON(ProductsData productsData) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(productsData);
        //System.out.println(json);

        try (FileOutputStream fos = new FileOutputStream(new File("ProductList.json"));
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(json);
            //fos. .write(json);

        } catch (Exception e) {
            System.out.println("ЧТО-ТО СЛУЧИЛОСЬ ПРИ ЗАПИСИ В JSON");
            e.printStackTrace();
        }




    }
}

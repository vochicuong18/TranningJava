package helper;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import data.Product;
import data.User;

import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;

public class JsonHelper {
    @DataProvider
    public Object[][] getAccount() throws FileNotFoundException {
        JsonElement jsonData = JsonParser.parseReader(new FileReader("src/test/Resources/data.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("account");
        List<User> testData = new Gson().fromJson(dataSet, new TypeToken<List<User>>() {
        }.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

    @DataProvider
    public Object[][] getProduct() throws FileNotFoundException {
        JsonElement jsonData = JsonParser.parseReader(new FileReader("src/test/Resources/data.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("product");
        List<Product> productList = new Gson().fromJson(dataSet, new TypeToken<List<Product>>() {
        }.getType());
        Object[][] returnValue = new Object[productList.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = productList.get(index++);
        }
        return returnValue;
    }
}

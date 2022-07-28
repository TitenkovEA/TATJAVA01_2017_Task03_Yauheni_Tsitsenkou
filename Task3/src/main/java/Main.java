import com.epam.catalog.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evgeny on 05.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();

        Map<String, String> request = new HashMap<>();
        request.put("COMMAND_NAME", "add_news");
        request.put("category", "film");
        request.put("title", "matrix2");
        request.put("author", "neo");
        view.sendRequest(request);

        request.clear();
        request.put("COMMAND_NAME", "find_news");
        request.put("category", "film");
        request.put("title", "matrix");
        request.put("author", "");
        view.sendRequest(request);

        request.clear();
        view.sendRequest(request);
    }
}

Люблю тебя
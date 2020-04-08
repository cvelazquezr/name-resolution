import java.net.URL;

URL url = getClass().getResource("weather.txt");
File file = new File(url.toURI());

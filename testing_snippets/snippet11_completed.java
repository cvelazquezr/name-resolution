import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.io.BufferedReader;

URL url = new URL("http://uthsms.net");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();

String data = URLEncoder.encode("button", "UTF-8") + "="
+ URLEncoder.encode("Send SMS", "UTF-8");
data += "&" + URLEncoder.encode("country", "UTF-8") + "="
+ URLEncoder.encode(country, "UTF-8");
data += "&" + URLEncoder.encode("gateway", "UTF-8") + "="
+ URLEncoder.encode("0", "UTF-8");
data += "&" + URLEncoder.encode("hyderabad", "UTF-8") + "="
+ URLEncoder.encode(message, "UTF-8");
data += "&" + URLEncoder.encode("remLen", "UTF-8") + "="
+ URLEncoder.encode(remLen, "UTF-8");
data += "&" + URLEncoder.encode("sindh", "UTF-8") + "="
+ URLEncoder.encode(number, "UTF-8");
data += "&" + URLEncoder.encode("x", "UTF-8") + "="
+ URLEncoder.encode("0", "UTF-8");
data += "&" + URLEncoder.encode("y", "UTF-8") + "="
+ URLEncoder.encode("0", "UTF-8");
conn.setDoOutput(true);

OutputStreamWriter wr = new OutputStreamWriter(
conn.getOutputStream());
wr.write(data);
wr.flush();


BufferedReader inStream = new BufferedReader(new InputStreamReader((conn.getInputStream())));

result = inStream.readLine();

inStream.close();

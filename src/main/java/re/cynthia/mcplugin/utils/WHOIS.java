package re.cynthia.mcplugin.utils;

import java.io.*;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WHOIS {

    private static final Pattern regexIANAWhois = Pattern.compile("whois:[\\s]+([\\.a-z0-9\\-]+)");;

    public static String queryWHOIS(String host, int port, String query) throws IOException {
        Socket socket = new Socket(host, port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());

        out.write((query+"\r\n").getBytes());
        out.flush();

        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            builder.append(line+"\n");
        }
        return builder.toString();
    }

    public static String query(String resource) throws IOException {
        String ianaResponse = queryWHOIS("whois.iana.org", 43, resource);
        Matcher m = regexIANAWhois.matcher(ianaResponse);
        if(!m.find()) return "error";
        return queryWHOIS(m.group(1), 43, resource);
    }

}

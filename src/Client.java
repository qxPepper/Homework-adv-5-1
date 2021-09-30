import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final static String CLIENT_ID = "127.0.0.1";
    private final static int CLIENT_PORT = 23444;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(CLIENT_ID, CLIENT_PORT);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Запустили клиент.");

            String str;
            while (true) {
                System.out.print("Введите число или end: ");
                str = scanner.nextLine();

                out.println(str);

                if (str.equals("end")) {
                    break;
                }
                System.out.println("fibonachi(" + str + ") = " + in.readLine());
            }
        }
    }
}

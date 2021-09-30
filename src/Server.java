import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int SERVER_PORT = 23444;

    public static void main(String[] args) throws IOException {
        ServerSocket servSocket = new ServerSocket(SERVER_PORT);

        System.out.println("Запустили сервер.");
        while (true) {
            try (Socket socket = servSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String input;
                while ((input = in.readLine()) != null) {
                    if (input.equals("end")) {
                        return;
                    }

                    int number = Integer.parseInt(input);
                    int result = fibonachi(number);
                    out.println(result);
                }

            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    static int fibonachi(int number) {
        if (number > 0) {
            return number == 1 ? 1 : fibonachi(number - 1) + fibonachi(number - 2);
        } else if (number < 0) {
            return number == -1 ? 1 : fibonachi(number + 2) - fibonachi(number + 1);
        } else {
            return 0;
        }
    }
}

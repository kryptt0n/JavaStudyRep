package algorythms;

import java.io.*;
import java.util.HashMap;

public class Yandex {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/input.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/output.txt"))) {
            String[] numbers = bufferedReader.readLine().split(" ");
            int dataCentreCount = Integer.parseInt(numbers[0]);
            int serversCount = Integer.parseInt(numbers[1]);
            int eventCount = Integer.parseInt(numbers[2]);
            boolean[][] dataCentresServers = new boolean[dataCentreCount][serversCount];
            HashMap<Integer, Integer> resets = new HashMap<>();
            for (int i = 0; i < dataCentreCount; i++) {
                resets.put(i, 0);
            }

            for (int i = 0; i < eventCount; i++) {
                String[] input = bufferedReader.readLine().split(" ");
                Action action = Action.valueOf(input[0]);
                if (action == Action.DISABLE) {
                    int dataCentre = Integer.parseInt(input[1]) - 1;
                    int server = Integer.parseInt(input[2]) - 1;
                    dataCentresServers[dataCentre][server] = true;

                } else if (action == Action.RESET) {
                    int dataCentre = Integer.parseInt(input[1]) - 1;
                    for (int j = 0; j < serversCount; j++) {
                        dataCentresServers[dataCentre][j] = false;
                    }
                    resets.put(dataCentre, resets.get(dataCentre) + 1);
                } else if (action == Action.GETMAX) {
                    int max = resets.get(0) * workingServersCount(dataCentresServers, 0);
                    int counter = 0;
                    for (int j = 0; j < dataCentreCount; j++) {
                        int temp = resets.get(j) * workingServersCount(dataCentresServers, j);
                        if (temp > max) {
                            max = temp;
                            counter = j;
                        }
                    }
                    bufferedWriter.write(counter + 1 + "\n");
                } else if (action == Action.GETMIN) {
                    int min = resets.get(0) * workingServersCount(dataCentresServers, 0);
                    int counter = 0;
                    for (int j = 0; j < dataCentreCount; j++) {
                        int temp = resets.get(j) * workingServersCount(dataCentresServers, j);
                        if (temp < min) {
                            min = temp;
                            counter = j;
                        }
                    }
                    bufferedWriter.write(counter + 1 + "\n");
                }
            }
        } catch (IOException e) {
        }
    }

    public static int workingServersCount(boolean[][] dataCentresServers, int dataCentre) {
        int count = 0;
        for (int i = 0; i < dataCentresServers[dataCentre].length; i++) {
            if (!dataCentresServers[dataCentre][i])
                count++;
        }
        return count;
    }

    enum Action {
        DISABLE,
        RESET,
        GETMAX,
        GETMIN
    }
}

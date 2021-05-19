import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LoaderWithThreads {

    static int count = 1;

    public static void main(String[] args) throws Exception {

        ArrayList<Thread> threadsArray = new ArrayList<>();

        long start = System.currentTimeMillis();

        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

        for(int regionCode = 1; regionCode < 100; regionCode++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int number = 1; number < 1000; number++) {
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            stringBuilder.append(firstLetter);
                            stringBuilder.append(padNumber(number, 3));
                            stringBuilder.append(secondLetter);
                            stringBuilder.append(thirdLetter);
                            stringBuilder.append(padNumber(regionCode, 2));
                            stringBuilder.append("\n");
                        }
                    }
                }
            }
            threadsArray.add(writeThread(stringBuilder));
        }

        for(Thread thread:threadsArray) {
            thread.join();
        }

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();
        for (int i = 0; i < padSize; i++) {
            numberStr = '0' + numberStr;
        }
        return numberStr;
    }

//    private static String padNumber(int number, int numberLength) {
//        String numberStr = Integer.toString(number);
//        int padSize = numberLength - numberStr.length();
//        for (int i = 0; i < padSize; i++) {
//            numberStr = '0' + numberStr;
//        }
//        return numberStr;
//    }

    private static Thread writeThread(StringBuilder stringBuilder) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("res/region" + count + ".txt");
        count++;
        Runnable runnable = ()->{
            writer.write(stringBuilder.toString());
            writer.flush();
            writer.close();
        };
        Thread myThread = new Thread(runnable);
        myThread.start();
        return myThread;
    }
}

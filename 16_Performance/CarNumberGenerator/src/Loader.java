import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        PrintWriter writer = new PrintWriter("res/numbers.txt");

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
            writer.write(stringBuilder.toString());
        }

        writer.flush();
        writer.close();

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
//        StringBuilder numberStr = new StringBuilder(String.valueOf(number));
//        int padSize = numberLength - numberStr.length();
//        for (int i = 0; i < padSize; i++) {
//            numberStr.append(String.valueOf("0" + numberStr));
//        }
//        return numberStr.toString();
//    }
}

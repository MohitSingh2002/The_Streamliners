package MSExcel;

import java.util.Scanner;

public class MSExcel {

    static char intToChar(int num) {
        return (char) ('A' + num - 1);
    }

    static String getColName(int col) {

        StringBuilder builder = new StringBuilder();
        while (col > 0) {
            int remainder = col % 26;
            if (remainder == 0) {
                builder.append('Z');
                col = (col / 26) - 1;
            } else {
                builder.append((char) (64 + remainder));
                col = col / 26;
            }
        }

        return builder.reverse().toString();

//        if(col >= 1 && col <= 26) {
//            return ""+intToChar(col);
//        }
//        int count = 0;
//        if(col % 26 != 0) {
//            count = col / 26;
//            col = col % 26;
//        } else {
//            count = (col - 26) / 26;
//            col -= 26 * count;
//        }
//        StringBuilder builder = new StringBuilder();
//        builder.append(intToChar(count))
//                .append(intToChar(col));
//        return builder.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number : ");
            int num = scanner.nextInt();

            System.out.println(getColName(num));
        }

    }

}

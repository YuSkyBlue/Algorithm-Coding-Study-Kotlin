package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ReArrangementLogFile {
    /**  5ms */
    private String[] recorderFileList(String[] logs) {
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }

        letterList.sort((s1, s2) -> {
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);
            System.out.println("s1x: " + Arrays.toString(s1x));
            System.out.println("s2x: " + Arrays.toString(s2x));
            //문자 로그 사전순 비교
            int compared = s1x[1].compareTo(s2x[1]);
            System.out.println("compared: " + compared);

            // 비교가 같을 경우 :  0
            // 비교 대상의 순서가 앞으로 와야 할 경우 : 1
            // 비교 대상 순서가 뒤에 머 물러야 할 경우 : -1

            // 문자 동일한 경우 식별자 비교
            if (compared == 0){
                return s1x[0].compareTo(s2x[0]);
            } else{
                return compared;
            }
        });

        letterList.addAll(digitList);

        return letterList.toArray(new String[0]);
    }
    public static void main(String[] args) {
        String[] logs = {
                "dig1 8 1 5 1",
                "let1 art can",
                "dig2 3 6",
                "let2 own kit dig",
                "let3 art zero"
        };
        // Method 1
        ReArrangementLogFile re = new ReArrangementLogFile();
        String[] answer = re.recorderFileList(logs);

    }
}

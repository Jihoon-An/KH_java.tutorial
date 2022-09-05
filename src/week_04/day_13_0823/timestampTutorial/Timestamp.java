package week_04.day_13_0823.timestampTutorial;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Timestamp {
    public static void main(String[] args) throws ParseException {
//epoch time 란 1970년 1월 1일 0시이다.
//time stamp 라고 하는 시간을 출력한다.
//time stamp란 epoch time으로 부터 현재까지 흐른 시간을 millis초값으로 표현한 값.

        System.out.println(System.currentTimeMillis()); // time stamp or epoch time

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  // 우리가 원하는 형태로 format할 수 있다.
                                                                                    // 원하는 포맷 형태를 작성한 instance를 만든다.
        String date = sdf.format(System.currentTimeMillis());                       // 포맷하여 String으로 출력
        System.out.println(date);

        Date result = sdf.parse(date);
        System.out.print("현재 시간의 timestamp값 : ");
        System.out.println(result.getTime());

    }
}

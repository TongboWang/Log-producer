import javax.xml.transform.Source;
import java.util.Random;

/***
 * @author Tongbo Wang
 * @date 2022/10/14 12:43 下午 周五
 * @jdk jdk1.8.0
 * @version 1.0
 ***/
public class RandTest {
    public static void main(String[] args) {

        String randomString = getRandomString(7, 0);

        System.out.println(randomString);
    }

    public static String getRandomString(int length,int flag){

        String str = null;

        int number = 0;

        Random random=new Random();

        StringBuffer sb=new StringBuffer();

        switch (flag) {
            case 0:
                str="abcdefghijklmnopqrstuvwxyz0123456789";
                for(int i=0;i<length;i++){
                    number=random.nextInt(36);
                    sb.append(str.charAt(number));
                }
                break;
            case 1:
                str = "0123456789";
                for(int i=0;i<length;i++){
                    number=random.nextInt(10);
                    sb.append(str.charAt(number));
                }
                break;
            case 2:
                str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                for(int i=0;i<length;i++){
                    number=random.nextInt(62);
                    sb.append(str.charAt(number));
                }
                break;
        }

        return sb.toString();
    }
}

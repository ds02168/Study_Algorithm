package LinearSearch;
import  java.util.*;

public class 전화번호목록 {
    public static boolean solution(String[] phone_book){
        Arrays.sort(phone_book);

        for(int i = 1; i < phone_book.length; i++){
            if(phone_book[i].startsWith(phone_book[i-1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] str1 = {"119", "97674223", "1195524421"};
        System.out.println(solution(str1));
        String[] str2 = {"123","456","789"};
        System.out.println(solution(str2));
        String[] str3 = {"12","123","1235","567","88"};
        System.out.println(solution(str3));
    }
}

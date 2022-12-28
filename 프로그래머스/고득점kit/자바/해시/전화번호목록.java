package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class 전화번호목록 {
    public static boolean solution(String[] phone_book) {
        // 중복을 허용하지 않는 컬렉션으로 전화번호를 저장
        Set<String> set = Arrays.stream(phone_book).collect(Collectors.toCollection(HashSet::new));

        //전화번호 하나씩
        for(String phone : set)
            for(int i = 1; i < phone.length(); i++)
                //접두어가 다른 전화번호에 존재하면 false
                if(set.contains(phone.substring(0,i))) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123","456","789"}));
        System.out.println(solution(new String[]{"12","123","1235","567","88"}));
    }
}

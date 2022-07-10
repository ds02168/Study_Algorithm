package LinearSearch;

public class 문자열내p와y의개수 {
    static boolean solution(String s){
        int p = s.replaceAll("[^pP]","").length(); //p의 개수
        int y = s.replaceAll("[^yY]","").length(); //y의 개수
        //p의 개수와 y의 개수가 같은지
        return p == y;
    }

    public static void main(String[] args) {
        String s = "pPoooyY";
        System.out.println(solution(s));
        s = "Pyy";
        System.out.println(solution(s));
    }
}

class Solution {
    public String solution(String s) {
        String answer = s.substring(0,1); 
        char temp; //비교할 문자를 저장
        answer = answer.toUpperCase(); //문장의 첫 문자는 무조건 대문자
        
        for(int i=1;i<s.length();i++){ //두번째 문자부터 비교 시작
            temp = s.charAt(i);
            if(s.charAt(i-1) == ' ') //이전 문자가 공백이면
                temp = Character.toUpperCase(temp); //대문자
            else{ // 공백이 아니면
                temp = Character.toLowerCase(temp); //소문자
            }
            answer += temp; //문자를 추가
        }
        return answer;
    }
}

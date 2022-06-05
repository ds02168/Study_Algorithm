package StackQueue스택큐;

import java.util.*;
import java.util.stream.*;

public class 프린터 {
    public static int solution(int[] priorities, int location){
        //링크드 리스트 선언
        ArrayList<Integer> list = Arrays.stream(priorities).boxed().collect(Collectors.toCollection(ArrayList::new));
        int priority = 0;
        while(!list.isEmpty()){
            //제일 큰지 비교
            if(list.stream().mapToInt(i->i).max().getAsInt() <= list.get(0)){ //제일 큰 값인지 비교
                //우선순위 1추가(0부터 시작)
                priority++;
                //찾는 문서가 출력 차례면 더이상 찾기 x
                if(location == 0)
                    break;
                else{ //찾는 문서가 아니면
                    location--; //한칸 앞으로
                    list.remove(0); //출력
                }

            }else{ //아니면
                //맨 뒤로 삽입
                int first = list.remove(0);
                list.add(first);
                //찾는 문서가 맨 뒤로 가야하면 location은 맨 뒤로
                if(location == 0)
                    location = list.size()-1;
                else //찾는 문서가 아니면
                    location--; //한칸 앞으로
            }
        }
        return priority; //우선순위 출력
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,1,3,2},2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1},0));
    }
}

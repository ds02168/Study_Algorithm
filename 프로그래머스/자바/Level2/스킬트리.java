package test;

import java.util.*;

public class 스킬트리 {

	public static int solution(String skill, String[] skill_trees) {
        int answer = -1;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        Iterator<String> it = skillTrees.iterator();
        
        while(it.hasNext())
            if(skill.indexOf(it.next().replaceAll("[^"+skill+"]","")) !=0) //1.skill에 없는 문자 삭제
                it.remove(); //2. skill에 있는 문자들 순서 확인
            
        
        answer = skillTrees.size(); //리스트에 남은 스킬트리들
        return answer;
    }
	
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

		System.out.println(solution(skill,skill_trees));
	}

}

package test;

import java.util.*;

public class ��ųƮ�� {

	public static int solution(String skill, String[] skill_trees) {
        int answer = -1;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        Iterator<String> it = skillTrees.iterator();
        
        while(it.hasNext())
            if(skill.indexOf(it.next().replaceAll("[^"+skill+"]","")) !=0) //1.skill�� ���� ���� ����
                it.remove(); //2. skill�� �ִ� ���ڵ� ���� Ȯ��
            
        
        answer = skillTrees.size(); //����Ʈ�� ���� ��ųƮ����
        return answer;
    }
	
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

		System.out.println(solution(skill,skill_trees));
	}

}

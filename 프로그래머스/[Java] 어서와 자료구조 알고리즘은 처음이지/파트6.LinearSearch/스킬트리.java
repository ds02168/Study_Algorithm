package LinearSearch;

public class 스킬트리 {
    public static int solution(String skill, String[] skill_trees){
        //올바른 스킬트리 수
        int count = 0;
        //스킬트리 하나씩 비교
        for(String skill_tree : skill_trees){
            //순서에 상관 없는 스킬들 전부제거
            skill_tree = skill_tree.replaceAll("[^"+skill+"]","");
            //순서에 상관 있는 스킬들이 skill과 같으면 +1
            if(skill.startsWith(skill_tree)) count++;
        }
        //올바른 스킬 순서 리턴
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}

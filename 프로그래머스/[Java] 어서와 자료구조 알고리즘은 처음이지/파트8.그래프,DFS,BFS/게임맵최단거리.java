import java.util.*;

public class 게임맵최단거리 {
    //위치 정보 클래스
    static class Location{
        int x, y;
        Location(int x, int y){ this.x=x; this.y=y;}
        boolean equals(Location other){
            return this.x == other.x && this.y == other.y;
        }
        Location left(){ return new Location(x-1, y);}
        Location right(){ return new Location(x+1, y);}
        Location up(){ return new Location(x, y-1);}
        Location down(){ return new Location(x, y+1);}
    }

    //플레이어 이동 정보 클래스
    static class Position{
        int steps;
        Location location;
        Position(Location l, int s){ location = l; steps = s; }
    }
    public static int solution(int[][] maps) {
        final int mapSizeX = maps.length;
        final int mapSizeY = maps[0].length;
        final Location target = new Location(mapSizeX-1, mapSizeY-1); //목적지

        boolean[][] visited = new boolean[mapSizeX][mapSizeY];

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(new Location(0,0), 1));

        while(!queue.isEmpty()){
            Position now = queue.poll();

            //맵 밖
            if(now.location.x < 0) continue;
            if(now.location.x >= mapSizeX) continue;
            if(now.location.y < 0) continue;
            if(now.location.y >= mapSizeY) continue;
            //벽
            if(maps[now.location.x][now.location.y] == 0) continue;
            //이미 방문
            if(visited[now.location.x][now.location.y]) continue;
            visited[now.location.x][now.location.y] = true;

            //목적지 도착
            if(now.location.equals(target)) return now.steps;


            //다음 위치 이동
            queue.offer(new Position(now.location.left(), now.steps+1));
            queue.offer(new Position(now.location.right(), now.steps+1));
            queue.offer(new Position(now.location.up(), now.steps+1));
            queue.offer(new Position(now.location.down(), now.steps+1));
        }

        //경로 막힘
        return -1;
    }

    public static void main(String[] args) {
        int[][] maps1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        System.out.println(solution(maps1));
        System.out.println(solution(maps2));
    }
}

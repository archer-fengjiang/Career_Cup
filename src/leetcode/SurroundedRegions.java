package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import leetcode.SurroundedRegions.Point;

public class SurroundedRegions{
    public class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void flip(int[][] matrix){
        if(matrix == null || matrix[0].length == 0){
            return;
        }
        int[][] visitedMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
        	for(int j = 0; j < matrix[0].length; j++){
        		visitedMatrix[i][j] = 0;
        	}
        }
        List<Point> pointsToFlip = new LinkedList<Point>();

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0 && visitedMatrix[i][j] == 0){
                    if(isSurrounded(new Point(i, j), pointsToFlip, visitedMatrix, matrix)){
                    	System.out.println("to flip: x:" + i + " y:" + j);
                        Iterator<Point> itr = pointsToFlip.iterator();
                        while(itr.hasNext()){
                            Point point = itr.next();
                            matrix[point.x][point.y] = 1;
                        }
                    }
                    pointsToFlip.clear();
                }
            }
        }
        return;
    }

    private boolean isSurrounded(Point point, List<Point> pointsToFlip, int[][] visitedMatrix, int[][] matrix){
        if(point.x < 0 || point.x >= matrix.length || point.y < 0 || point.y >= matrix[0].length){
            return false;
        }

        if(matrix[point.x][point.y] == 1 || visitedMatrix[point.x][point.y] == 1){
            return true;
        } else {
            pointsToFlip.add(point);
            visitedMatrix[point.x][point.y] = 1;
            if(isSurrounded(new Point(point.x - 1, point.y), pointsToFlip, visitedMatrix, matrix) &&
                isSurrounded(new Point(point.x + 1, point.y), pointsToFlip, visitedMatrix, matrix) &&
                isSurrounded(new Point(point.x, point.y - 1), pointsToFlip, visitedMatrix, matrix) &&
                isSurrounded(new Point(point.x, point.y + 1), pointsToFlip, visitedMatrix, matrix)
                ){
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix =   {{1,1,1,1,0},
                            {1,0,0,0,1},
                            {0,1,1,0,1},
                            {1,0,0,0,1},
                            {1,1,1,1,1} };
        SurroundedRegions sr = new SurroundedRegions();
        sr.flip(matrix);

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
package Chapter_8_Recursion;

import java.util.*;

public class RobotPath{
	public static void main(String[] args){
		RobotPath path = new RobotPath();
		/*
		boolean[][] grid = {{true, true, true, false, false, false, false},
							{true, false, true, false, true, true, true},
							{true, false, true, false, true, false, true},
							{true, false, true, true, true, false, true},
							{true, false, false, false, false, false, true},
							{true, true, true, true, true, true, true},
							{true, false, false, false, false, false, false},
							{true, true, true, true, true, true, true}};
							*/
		boolean[][] grid = {{true, true, true},{true, false, true},{true,true,true}};
		List pathList = path.searchPath(grid);
		System.out.println(pathList.toString());
	}
	
	public List searchPath(boolean[][] grid){
		int[] cordinate = {0,0};
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		String tmpPath = "";
		List pathList = new ArrayList<String>();
		visited[0][0] = true;
		searchHelper(cordinate, visited, pathList, tmpPath, grid);
		return pathList;
	}
	
	private void searchHelper(int[] cordinate, boolean[][] visited, List pathList, String tmpPath, boolean[][] grid){
		Iterator itr;
		int[] tmpCor;
		List<int[]> nextStepList = nextStep(cordinate[0],cordinate[1], visited, grid);
		
		if(nextStepList.isEmpty())
			;
		else{
			itr = nextStepList.iterator();
			int count = 0;
			while(itr.hasNext()){
				tmpCor = (int [])itr.next();
				if(tmpCor[0] - cordinate[0] == 1)
					tmpPath += 'R';
				else if(tmpCor[0] - cordinate[0] == -1)
					tmpPath += 'L';
				else if(tmpCor[1] - cordinate[1] == 1)
					tmpPath += 'D';
				else if(tmpCor[1] - cordinate[1] == -1)
					tmpPath += 'U';
				//don't set exit to be visited
				if(tmpCor[0] == visited[0].length - 1 && tmpCor[1] == visited.length - 1)
					pathList.add(tmpPath);
				else{
					visited[tmpCor[1]][tmpCor[0]] = true;
					searchHelper(tmpCor, visited, pathList, tmpPath, grid);
				}
			}
		}
	}
	private List nextStep(int x, int y, boolean[][] visited, boolean[][] grid)
	{
		System.out.println("One round");
		List<int[]> stepList = new ArrayList<int[]>();
		Iterator itr;
		if(x - 1 >= 0 && !visited[y][x-1] && grid[y][x-1]){
			int[] nextStep = new int[2];
			nextStep[0] = x - 1;
			nextStep[1] = y;
			System.out.println(Arrays.toString(nextStep));
			stepList.add(nextStep);
		}
		if(x + 1 < visited[0].length && !visited[y][x+1] && grid[y][x+1]){
			int[] nextStep = new int[2];
			nextStep[0] = x + 1;
			nextStep[1] = y;
			System.out.println(Arrays.toString(nextStep));
			stepList.add(nextStep);
		}
		if(y - 1 >= 0 && !visited[y -1][x] && grid[y - 1][x]){
			int[] nextStep = new int[2];
			nextStep[0] = x;
			nextStep[1] = y - 1;
			System.out.println(Arrays.toString(nextStep));
			stepList.add(nextStep);
		}
		if(y + 1 < visited.length && !visited[y+1][x] && grid[y+1][x]){
			int[] nextStep = new int[2];
			nextStep[0] = x;
			nextStep[1] = y + 1;
			System.out.println(Arrays.toString(nextStep));
			stepList.add(nextStep);
		}
		itr = stepList.iterator();
		
		//while(itr.hasNext())
			//System.out.println(Arrays.toString((int []) itr.next()));
		return stepList;
	}
}
import java.util.*;
import java.io.*;
public class Main {
    
	public static void main(String[] args) {
		File file = new File("sample_input.txt");
		Scanner sc = null;
		try{
		        sc = new Scanner(file);
		}
		catch(Exception e){
			System.out.println(e);
		}
	            int xDim = sc.nextInt();
	            int yDim = sc.nextInt();
	            String space = sc.nextLine();
	            Float xDimFloat = (float) xDim; 
	            //System.out.println(space);
	            String exp = sc.nextLine();
	            String [] data = new String[xDim*yDim];
	            data = exp.split(" ");
	            float [] dataEx = new float[xDim*yDim];
	            // Read the array of exposure data
	            for(int i = 0; i<data.length;i++){
	                float number = Float.parseFloat(data[i]);
	                dataEx[i]=number;
	            }
	            // Number of trees
	            String numTree = sc.nextLine();
	            int numTree1 = Integer.parseInt(numTree);
	            int x = 0;
	            int oriextX;
	            int oriextY;
	            int oriextO;
	            String x_coord1 = null;
	            String y_coord1 = null;
	            String ext1 = null;
	            float sum = 0;
	            
	            int x_coord = 0;
	            int y_coord = 0;
	            int ext = 0;

	            // Reading in tree coordinates and their extent
	            
	            
	            for(int y = 0; y < numTree1; y++){
	            	// Getting coord
	            	String treeInput = sc.nextLine();
	            	x_coord1 = treeInput.split(" ")[0];
	            	y_coord1 = treeInput.split(" ")[1];
	            	ext1 = treeInput.split(" ")[2];
	            	
	            	x_coord = Integer.parseInt(x_coord1);
	            	y_coord = Integer.parseInt(y_coord1);
	            	ext = Integer.parseInt(ext1);
	            	
	            	float thisTreeSum = sumTree(x_coord, y_coord, ext, dataEx, xDim);
	            	sum += thisTreeSum;
	         
	            	System.out.println(thisTreeSum);
	            }
	            
	            //float[] thisSum = null;
				System.out.println("==================================");
	            System.out.println(sum);

	            // Calculate the sum of each tree
	            
	            // 1 Step through each tree
	            
	            // 2 Get all of its neighborhood coords
	            // 3 Sum all of those
	            // 4 average
	            
	            /*
	            int counter = 0;
	            float [] orFloat = new float[numTree1];
	            for(int xi = 0; xi < numTree1; xi++){
	            	for(int yi = 0; yi<dataEx.length; yi++){
	            		if(counter < extent[xi]){
	            			orFloat[xi] = dataEx[originY[xi] + (xDim*originX[xi + counter])];
	            			orFloat[xi] = dataEx[originY[xi + counter] + (xDim*originX[xi])];
	            			orFloat[xi] = dataEx[originY[xi + counter] + (xDim*originX[xi + counter])];
	            			counter++;
	            	}
	            		for( float i: orFloat){
	            			sum += i;
	            			
	            		}
	            		
	            }
	            
	            
	            
	            
	            
		
	}
	            System.out.println(sum);*/
}

	private static float sumTree(int x, int y, int ext, float [] data, int dimensionSize) {
		int x_end = x + ext;
		int y_end = y + ext;
		float thisSum = 0;
		for(int i = x; i < x_end && i < dimensionSize; i ++)
		{
			for(int j = y; j < y_end && j < dimensionSize; j ++)
			{
				int mainArrX = i;
				int mainArrY = j;
				
				thisSum += data[mainArrX*dimensionSize + mainArrY];
			}
		}
		return thisSum;
	}
}
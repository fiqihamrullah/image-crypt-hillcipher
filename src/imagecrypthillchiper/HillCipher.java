/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagecrypthillchiper;


import java.util.*;
import java.io.*;

/**
 *
 * @author Fiqih Amrullah
 */
public class HillCipher 
{
 
       MatrixTransformation mt;
       int[][] matrixinvertibel;

       public HillCipher(int seed,int k,int multiplier, int width) 
       {
           mt = new MatrixTransformation(seed, k,multiplier);
           matrixinvertibel = mt.createMatrixInvertible(width);
       }
               
        public int[] mod(int vec[])      
        {
            int newvec[] = new int[vec.length];
            for(int i=0;i<vec.length;i++)
            {
                newvec[i] = vec[i] % MatrixTransformation.MODULO;
            }
            return newvec;
        }
 
	public static void main(String[] args) 
        {
		
	}
        
        
        public int[] encrypt(int vecPlainImag[]) 
        {
            int cipher[] = mod(Matrix.mult(matrixinvertibel, vecPlainImag));
          //  Matrix.toString(cipher);
            
            return cipher;
            
        }
        
        
        public int[]decrypt(int vecChiperImag[]) 
        {
            int plain[] = mod(Matrix.mult(matrixinvertibel, vecChiperImag));            
            return plain;
            
        }
        
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagecrypthillchiper;

/**
 *
 * @author Fiqih Amrullah
 */
public class MatrixTransformation 
{
    private int seedvalue;
    private int t;
    private int k;
  
    public static int MODULO=256;

    public MatrixTransformation(int seedvalue,int k, int multiplier)
    {
        this.seedvalue = seedvalue; 
        this.k = k;
        t = multiplier;
    }
    
    private int[][] generateRandomNumber(int nhalf)
    {
        //dengan metode Linear congruential generator
          int A11[][] = new int[nhalf][nhalf];
          int tempseed=0;
          for(int i=0;i<A11.length;i++)
          {
              for(int j=0;j<A11[i].length;j++)
              {
                  if (i==0 && j==0)
                  {
                         A11[i][j] = seedvalue;
                         tempseed=A11[0][0];
                  }else {
                      A11[i][j] =( t * tempseed) % MODULO;
                      tempseed =  A11[i][j] ;
                  }
              }
          }
         return A11;
    }
    
    
    public int[][] createMatrixInvertible(int n)
    {      
        
        int A11[][] = generateRandomNumber(n/2);  
      //  printMatrix("A11", A11);
        
        int A22[][] = new int[A11.length][A11.length];
        for(int i=0;i<A22.length;i++)
        {
            for(int j=0;j<A22[i].length;j++)
            {
                A22[i][j] = MODULO - A11[i][j];
            }
        }
        
       // printMatrix("A22", A22);
        
        int matrixidentitas[][] = new int[A11.length][A11.length];
        for(int i=0;i<matrixidentitas.length;i++)
        {
            for(int j=0;j<matrixidentitas[i].length;j++)
            {
                if (i==j) 
                {
                  matrixidentitas[i][j] = 1;
                }else{
                 matrixidentitas[i][j] = 0;   
                }
            }
        }
      //  printMatrix("Identitas", matrixidentitas);
        int A12[][] = new int[A11.length][A11.length];
         for(int i=0;i<A12.length;i++)
        {
            for(int j=0;j<A12[i].length;j++)
            {
                A12[i][j] = (k * (MODULO +  (matrixidentitas[i][j] - A11[i][j]))) % MODULO;
            }
        }
     //  printMatrix("A12", A12);
       
       int A21[][] = new int[A11.length][A11.length];
       for(int i=0;i<A21.length;i++)
        {
            for(int j=0;j<A21[i].length;j++)
            {
                 A21[i][j] = (matrixidentitas[i][j] + A11[i][j]);
                 while ( A21[i][j] % k!=0) 
                 {
                     A21[i][j] +=MODULO;
                 }
                 A21[i][j] = A21[i][j]/k;
            }
        }
       
       // printMatrix("A21", A21);
       printMatrix("A", combineAllAs(A11,A12,A21,A22));
       return combineAllAs(A11,A12,A21,A22);
    }
    
    private int[][] combineAllAs(int A11[][],int A12[][],int A21[][],int A22[][])
    {
      int matrixA[][] = new int[A11.length*2][A11.length*2];
      int half  = matrixA.length/2;
       
      for(int i=0;i<matrixA.length;i++)
      {
          for(int j=0;j<matrixA[i].length;j++)
          {
              if (i < (half) &&  j <(half))
              {
                  matrixA[i][j] = A11[i][j];
              }else if (i < (half) &&  j >=(half))
              {
                  matrixA[i][j] = A12[i][j-half];
              }else if (i >= (half) &&  j< half)
              {
                  matrixA[i][j] = A21[i-half][j];
              }else if (i >= (half) &&  j>= half)
              {
                  matrixA[i][j] = A22[i-half][j-half];
              }
          }
      }
      return matrixA;    
    }
    
    public void printMatrix(String label,int A11[][])
    {
        System.out.println(label);
        System.out.println("==========================");
        for(int i=0;i<A11.length;i++)
        {
            for(int j=0;j<A11[i].length;j++)
            {
                System.out.print(A11[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
}

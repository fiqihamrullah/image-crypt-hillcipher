/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagecrypthillchiper;

import java.awt.Color;
 
public class ImageData
{
  private int widthOri;
  private int heightOri;
  private int pixelasli[][];
  private int pixeloutput[][];
  private double realpixelasli[][];
  private double imgpixelasli[][];
 
  private String name;
  
  public ImageData() 
  {
     
      
  }

  public void SetName(String name)
  {
      this.name = name;
  }
  
  public String getName()
  {
      return name;
  }
  
    public ImageData(int widthOri, int heightOri) 
    {
        this.widthOri = widthOri;
        this.heightOri = heightOri;
        pixelasli = new int[heightOri][widthOri];
        pixeloutput = new int[heightOri][widthOri];
  
    }

    public void setPixelAsli(int[][] pixelasli) 
    {
        this.pixelasli = pixelasli;
    }

    public int[][] getPixelAsli() 
    {        
        return pixelasli;
    }
    
    public void setPixelOutput(int baris,int[] vec) 
    {
        for(int i=0;i<vec.length;i++)
        {
            pixeloutput[baris][i] = vec[i];
        }
    }

    public int getHeight() 
    {
        return heightOri;
    }

    public int getWidth() {
        return widthOri;
    }

    public void setPixel(int h,int w,int pixel) {
        this.pixelasli[h][w] = pixel;
    }

    public int getPixel(int h,int w) 
    {
        return pixelasli[h][w];
    }
    
    public int getPixelBiner(int h,int w) 
    {
        return (pixeloutput[h][w]==255)?1:0;
    }
    
    public void setPixelOutput(int h,int w,int output)
    {
        pixeloutput[h][w]=output;
    }
    
    public int getPixelOutput(int h,int w)
    {
        return  pixeloutput[h][w];
    }
    
    void setPixelReal(int h,int w,double realpixel)
    {
        realpixelasli[h][w] = realpixel;
    }
    
    double getPixelReal(int h,int w)
    {
        return realpixelasli[h][w];
    }      
    
      public int[] toOneDimensionalPixelOutput(){
       int[] onedpixel = new int[pixeloutput.length*pixeloutput[0].length];
       int i=0;
       for(int baris=0;baris<pixeloutput.length;baris++){
           for(int kolom=0;kolom<pixeloutput[0].length;kolom++){
                 int gray = pixeloutput[baris][kolom];  
                     Color c = new Color(gray, gray, gray );
                 onedpixel[i] =c.getRGB();
                 i++;

           }
       }
       return onedpixel;
   }
  
    
      public int[] toOneDimensionalPixelReal()
      {
       int[] onedpixel = new int[pixelasli.length*pixelasli[0].length];
       int i=0;
       for(int baris=0;baris<pixelasli.length;baris++){
           for(int kolom=0;kolom<pixelasli[0].length;kolom++){
                 int gray = pixelasli[baris][kolom]; 
                 Color c = new Color(gray, gray, gray,255 );
                 onedpixel[i] =c.getRGB();
                 i++;

           }
       }
       return onedpixel;
   }
  
     public double[] toOneDimensionalPixelDReal(){
       double[] onedpixel = new double[pixelasli.length*pixelasli[0].length];
       int i=0;
       for(int baris=0;baris<pixelasli.length;baris++){
           for(int kolom=0;kolom<pixelasli[0].length;kolom++){
                 double gray = pixelasli[baris][kolom];                  
                 onedpixel[i] =gray;
                 i++;

           }
       }
       return onedpixel;
   }
     
   
 
     
 }

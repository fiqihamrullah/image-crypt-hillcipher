/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagecrypthillchiper;

 
 
import java.awt.Color;
import java.awt.Image;
import java.awt.image.PixelGrabber;
import javax.swing.ImageIcon;


public class ImageReader {
    ImageData img;
    public ImageReader() {
        img = new ImageData();
    }
    
    public void readPixelsFrom(ImageIcon imgic)
    {
      img = new ImageData(imgic.getIconWidth(), imgic.getIconHeight()); 
      PixelGrabber pxlgrabber = new PixelGrabber(imgic.getImage(),0,0,img.getWidth(), img.getHeight(),false);
      pxlgrabber.startGrabbing();
      int pixels[];
       int pixelasli[][];
       
    try{
        if(pxlgrabber.grabPixels()){
            pixels = (int[])pxlgrabber.getPixels();
            pixelasli  = new int [img.getHeight()][img.getWidth()];
            int wpx = 0;
            int hpx = 0;
            for(int i =0;i<pixels.length;i++)
            {   
                 int pixel = pixels[i]; 
                 Color c = new Color(pixel);
                 int merah = c.getRed();
                 int hijau = c.getGreen();
                 int biru = c.getBlue();
                 int gray = (merah+hijau+biru)/3 ;           
                 
                /* if (gray>128)
                 {
                     gray =255;
                 }else{
                     gray=0;
                 }*/
                 
                 pixelasli[hpx][wpx] = gray; 
                 img.setPixelOutput(hpx, wpx, gray);
             //   System.out.println(gray);
                 wpx++;
                 if (wpx==img.getWidth())
                 {
                    wpx=0;
                    hpx++;

                }
            }
          
            img.setPixelAsli(pixelasli);
           
           
            System.out.println("Sukses");
        }
    }catch(InterruptedException ex){}
    }

    public ImageData getImage() {
        return img;
    }
    
    
    
    
    
}

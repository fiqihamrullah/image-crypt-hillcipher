/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagecrypthillchiper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Fiqih Amrullah
 */
public class SecureImageMaker 
{
 ImageData imgDt;
   HillCipher hc;
   
   public SecureImageMaker(ImageData imgDt,int seed,int k,int multiplier) 
   {
        hc = new HillCipher(seed, k,multiplier,imgDt.getWidth());
        this.imgDt = imgDt;
   }
    
    public void encryptImageData()
    {
       
        int pixels[][] = imgDt.getPixelAsli();
        for(int i=0;i<pixels.length;i++)
        {
                int vecplain[] = Matrix.getVecOfRow(pixels, i);
                int cipher[] = hc.encrypt(vecplain);
                imgDt.setPixelOutput(i, cipher);
        }
      
        /*
      int data[] = {4,6,12,9,0,1,6,9};           
      int cipher[] = hc.encrypt(data);          
      int plain[] = hc.decrypt(cipher);     
      printVector("Cipher", cipher);
      printVector("Plain From Cipher", plain);
      printVector("Plain ", data); 
        */
        
    }
    
     public void save(ImageData imgDt)
    {
       JFileChooser  fc = new JFileChooser();
       FileFilter filter1 = new ExtensionFileFilter("BMP  Files", new String[] { "BMP" });
       fc.setFileFilter(filter1);
       String filesimpan = "";
       int respon =  fc.showSaveDialog(null);
       if (respon == fc.APPROVE_OPTION){
            int w = imgDt.getWidth();
            int h = imgDt.getHeight();
            int pixwm[] = imgDt.toOneDimensionalPixelOutput();
            BufferedImage image = new BufferedImage(w , h , BufferedImage.TYPE_INT_RGB);     
            image.setRGB(0, 0, w , h ,pixwm, 0, w);
            BufferedImage bf =image;
            File outputfile = new File(fc.getSelectedFile().getAbsolutePath() + ".bmp");
            try{
             ImageIO.write(bf, "bmp", outputfile);
             JOptionPane.showMessageDialog(null, "Citra Hasil Enkripsi Berhasil disimpan!");
            }catch(IOException e){
                 
            }

       }
    }
    
    public void printVector(String label,int vec[])
    {
        System.out.println(label);
        System.out.println("==========================");
        for(int i=0;i<vec.length;i++)
        {            
           System.out.print(vec[i]  + "\t");          
        }
        System.out.println();
    }
    
    public void decryptImageData( )
    {
        int pixels[][] = imgDt.getPixelAsli();
        for(int i=0;i<pixels.length;i++)
        {
                int veccipher[] = Matrix.getVecOfRow(pixels, i);
                int plain[] = hc.decrypt(veccipher);
                imgDt.setPixelOutput(i, plain);
        }
    }
   
   
    
}

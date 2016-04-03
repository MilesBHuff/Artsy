package cs1302.p2;

import cs1302.effects.Artsy;
import javafx.scene.image.Image;

public class MyArtsy implements Artsy {
  
  public Image copyImage(Image src) {
      int width = (int) src.getWidth();
      int height = (int) src.getHeight();
      WritableImage ret = new WritableImage(width, height);
      PixelReader pr = src.getPixelReader();
      PixelWriter pw = ret.getPixelWriter();
      for (int x = 0; x < width; ++x) {
          for (int y = 0; y < height; ++y) {
              pw.setArgb(x, y, pr.getArgb(x, y));
          } // for
      } // for
      return ret;
  } // copyImage

    @Override
    public Image doCheckers(Image src1, Image src2, int size) {
	return null;
    } // doCheckers

    @Override
    public Image doHorizontalStripes(Image src1, Image src2, int height) {
      Image temp = new Image(copyImage(src1));
      PixelReader pr=src2.getPixelReader();
      PixelWriter pw=temp.getPixelWriter();
      int y=0;
      for(int x=0;x<temp.getWidth();x++){
        for(int count=0;count<height;count++){
          y++;
          pw.setArgb(x,y, pr.getArgb(x,y));
        }
        y+=height;
      }
  return temp;
    } // doHorizontalStripes

    @Override
    public Image doRotate(Image src, double degrees) {
	return null;
    } // doRotate

    @Override
    public Image doVerticalStripes(Image src1, Image src2, int width) {
      Image temp = new Image(copyImage(src1));
      PixelReader pr=src2.getPixelReader();
      PixelWriter pw=temp.getPixelWriter();
      int x=0;
      for(int y=0;y<temp.getHeight();y++){
        for(int count=0;count<height;count++){
          x++;
          pw.setArgb(x,y, pr.getArgb(x,y));
        }
        x+=height;
      }
    return temp;
    } // doVerticalStripes

} // MyArtsy

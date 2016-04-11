package main.java.cs1302.p3                       ;
import  main.java.cs1302.effects.Artsy            ;
import  javafx.scene.image.Image        ;
import  javafx.scene.image.PixelReader  ;
import  javafx.scene.image.PixelWriter  ;
import  javafx.scene.image.WritableImage;
@SuppressWarnings("restriction")
/** Implements effects.Artsy
 * @author Preston Sheppard (coding)
 * @author Miles B Huff (bugfixing and formatting)
**/
public class MyArtsy implements Artsy
{ //+class
	////////////////////////////////////////////////////////////////////////
	public Image doCopy(Image imgSrc)
	{ //+method
		int           iWidth  =     (int) imgSrc.getWidth (               );
		int           iHeight =     (int) imgSrc.getHeight(               );
		WritableImage wiCopy  = new WritableImage         (iWidth, iHeight);
		PixelReader   pr      =     imgSrc.getPixelReader (               );
		PixelWriter   pw      =     wiCopy.getPixelWriter (               );
		for (int iX = 0     ;
			 iX < iWidth;
			 iX++       )
		{ //+loop
			for(int iY = 0      ;
				iY < iHeight;
				iY++        )
			{pw.setArgb(iX, iY, pr.getArgb(iX, iY));}
		} //-loop
		return wiCopy;
	} //-method

	////////////////////////////////////////////////////////////////////////
	public Image doRotate(Image  imgSrc,double theta) {//rotates from top left corner, needs to rotate from middle
		double radians=(Math.PI*theta)/180;
		WritableImage rotated  = new WritableImage ((int) imgSrc.getWidth(), (int) imgSrc.getHeight());
		PixelReader pr=imgSrc.getPixelReader();
		PixelWriter pw=rotated.getPixelWriter();
		int xx=0, yy=0;
		for (int x=0; x<imgSrc.getWidth();x++){
			for (int y=0; y<imgSrc.getHeight(); y++){
				xx= (int) (x*Math.cos(radians)-y*Math.sin(radians)+150);
				yy= (int) (x*Math.sin(radians)+y*Math.cos(radians)-75);
				if ((0<xx)&&(xx<imgSrc.getWidth())&&(0<yy)&&(yy<imgSrc.getWidth())){
					pw.setArgb(xx, yy, pr.getArgb(x, y));
				}//end if
			}//end y loop	
		}//end x loop
	return rotated;	
	} //-method
	////////////////////////////////////////////////////////////////////////
	public Image doStripesVertical(Image img1, Image img2, int size){//done fag
		WritableImage temp1=(WritableImage) doCopy(img1);
		PixelReader pr=img2.getPixelReader();
		PixelWriter pw=temp1.getPixelWriter();
		for (int y=0; y<img1.getHeight();y++){
			for (int x=0;x<img1.getWidth();x=x+size+size){
				for (int count=0; (count<size)&&(count+x<img1.getWidth()); count++){
					pw.setArgb(x+count, y, pr.getArgb(x+count, y));
				}
			}
		}	
		return temp1;
	} //-method
	////////////////////////////////////////////////////////////////////////
	public Image doCheckers(Image img1, Image img2, int size){
		WritableImage temp1=(WritableImage) doCopy(img1);
		PixelReader pr=img2.getPixelReader();
		PixelWriter pw=temp1.getPixelWriter();
		int check=0; int x=0;
		for (int y=0; y<img1.getHeight();y=y+size){
			for (;x<img1.getWidth();x=x+size*2){
				for (int count=0; (count<size)&&(count+x<img1.getWidth()); count++){
					for (int county=0; (county<size)&&(county+y<img1.getHeight()); county++){
						pw.setArgb(x+count, y+county, pr.getArgb(x+count, y+county));
					}
				}
			}
			if (check==0){
				x=size;
				check=1;
			}else {
				check=0;
				x=0;
			}
		}	
		return temp1;
	} //-method

	////////////////////////////////////////////////////////////////////////
	public Image doStripesHorizontal(Image img1, Image img2, int size){
			WritableImage temp1=(WritableImage) doCopy(img1);
	PixelReader pr=img2.getPixelReader();
	PixelWriter pw=temp1.getPixelWriter();
	for (int x=0; x<img1.getWidth();x++){
		for (int y=0;y<img1.getHeight();y=y+size+size){
			for (int count=0; (count<size)&&(count+y<img1.getHeight()); count++){
				pw.setArgb(x, y+count, pr.getArgb(x, y+count));
			}
		}
	}	
	return temp1;
} //-method


} //-class

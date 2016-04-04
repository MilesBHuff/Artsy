package src.p2                  ;
import  src.effects.Artsy       ;
import  javafx.scene.image.Image;

public class MyArtsy implements Artsy
{ //+class
	////////////////////////////////////////////////////////////////////////
	/** Given an <code>Image</code>, this method returns a deep copy of the
	 *  given <code>Image</code>.
	 * @param  src The <code>Image</code> to copy
	 * @return a deep copy of <code>src</code>.
	**/
	private Image doCopy(Image oSrc)
	{ //+method
		int           iWidth  =        oSrc.getWidth(               );
		int           iHeight =       oSrc.getHeight(               );
		WritableImage oCopy   =    new WritableImage(iWidth, iHeight);
		PixelReader   oPR     =  oSrc.getPixelReader(               );
		PixelWriter   oPW     = oCopy.getPixelWriter(               );
		for (int iX = 0     ;
			 iX < iWidth;
			 iX++       )
		{ //+loop
			for(int iY = 0      ;
				iY < iHeight;
				iY++        )
			{ //+loop
				oPW.setArgb(iX, iY, oPR.getArgb(iX, iY));
			} //-loop
		} //-loop
		return oCopy;
	} //-method

	////////////////////////////////////////////////////////////////////////
	@Override
	public Image doRotate(Image  oSrc,
		              double dDeg)
	{ //+method
		return null;
	} //-method

	////////////////////////////////////////////////////////////////////////
  @Override
    public Image doCheckers(Image src1, Image src2, int size) {
      Image temp = new Image(copyImage(src1));
      PixelReader pr=src2.getPixelReader();
      PixelWriter pw=temp.getPixelWriter();
      int y=0, x=0, previousY=0;
      for(int tempx=x ;x<temp.getWidth();x+=size){
        for(int tempy=y;;y<temp.getHeight();y+=size){
          for(int countx=0;countx<size;countx++, tempx++){
            for (int county=0;county<size;county++, tempy++){
              pw.setArgb(tempx,tempy, pr.getArgb(tempx,tempy));
            }//end countx
          }//end county
        }//end y loop
        if (previousY==0) previousY=size, y=size;
        else previousY=0, y=0;
      }//emd x loop
	   return temp;
    } // doCheckers


	////////////////////////////////////////////////////////////////////////
	@Override
	public Image doHorizontalStripes(Image oSrc1  ,
		                         Image oSrc2  ,
		                         int   iHeight)
	{ //+method
		Image       oNew =            new Image(doCopy(oSrc1));
		PixelReader oPR  = oSrc2.getPixelReader(             );
		PixelWriter oPW  =  oNew.getPixelWriter(             );
		for(int iY = 0              ,
			iX = 0              ;
			iX < oNew.getWidth();
			iX++                )
		{ //+loop
			for(int iCount = 0      ;
				iCount < iHeight;
				iCount++        ,
				    iY++        )
			{ //+loop
				oPW.setArgb(iX, iY, oPR.getArgb(iX, iY));
			} //-loop
			iY+= iHeight;
		} //-loop
		return oNew;
	} //-method

	////////////////////////////////////////////////////////////////////////
	@Override
	public Image doVerticalStripes(Image src1, Image src2, int width)
	{ //method
		Image temp = new Image(doCopy(src1));
		PixelReader pr=src2.getPixelReader();
		PixelWriter pw=temp.getPixelWriter();
		int x = 0;
		for(int y = 0;
			y < temp.getHeight();
			y++)
		{ //+loop
			for(int count = 0;
				count < height;
				count++)
			{ //+loop
				x++;
				pw.setArgb(x, y, pr.getArgb(x, y));
			} //-loop
			x+= height;
		} //-loop
		return temp;
	} //-method
} //-class

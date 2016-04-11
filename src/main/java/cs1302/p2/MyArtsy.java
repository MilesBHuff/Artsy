package cs1302.p2                       ;
import  cs1302.effects.Artsy            ;
import  javafx.scene.image.Image        ;
import  javafx.scene.image.PixelReader  ;
import  javafx.scene.image.PixelWriter  ;
import  javafx.scene.image.WritableImage;

/** Implements effects.Artsy
 * @author Preston Sheppard (coding)
 * @author Miles B Huff (bugfixing and formatting)
**/
public class MyArtsy implements Artsy
{ //+class
	////////////////////////////////////////////////////////////////////////
	public WritableImage doCopy(Image imgSrc)
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
	public Image doRotate(Image  imgSrc,
		              double dDeg  )
	{ //+method
		WritableImage wiNew = doCopy(imgSrc)         ;
		PixelReader   pr    = imgSrc.getPixelReader();
		PixelWriter   pw    =  wiNew.getPixelWriter();
		for(int iX = 0               ,
		     iNewX = 0               ;
		        iX < wiNew.getWidth();
		        iX++                 )
		{ //+loop
			for(int iY = 0                ,
			     iNewY = 0                ;
			        iY < wiNew.getHeight();
			        iY++                  )
			{ //+loop
				iNewX =  iX * (int)Math.cos(dDeg) + iY * (int)Math.sin(dDeg);
				iNewY = -iX * (int)Math.sin(dDeg) + iY * (int)Math.cos(dDeg);
				if((    0<= iNewX            )
				&& (    0<= iNewY            )
				&& (iNewX<= wiNew.getWidth ())
				&& (iNewY<= wiNew.getHeight()))
				{pw.setArgb(iNewX, iNewY, pr.getArgb(iX, iY));}
			} //-loop
		} //-loop
		return wiNew;
	} //-method

	////////////////////////////////////////////////////////////////////////
	public Image doCheckers(Image imgSrc1,
	                        Image imgSrc2,
	                        int   iSize  )
	{ //+method
		WritableImage wiNew = doCopy(imgSrc1)         ;
	        PixelReader   pr    = imgSrc2.getPixelReader();
	        PixelWriter   pw    =  wiNew .getPixelWriter();
	        for(int iOffsetY = 0               ,
	                      iX = 0               ;
	                      iX < wiNew.getWidth();
	                      iX+= iSize           )
	        { //+loop
	                for(int iY = 0                ;
	                        iY < wiNew.getHeight();
	                        iY+= iSize            )
	                { //+loop
	                        iY+= iOffsetY;
	                        for(int iNewX = iX   ,
	                              iCountX = 0    ;
	                              iCountX < iSize;
	                              iCountX++      ,
	                                iNewX++      )
	                        { //+loop
	                                for(int iNewY = iY   ,
	                                      iCountY = 0    ;
	                                      iCountY < iSize;
	                                      iCountY++      ,
	                                        iNewY++      )
	                                {pw.setArgb(iNewX, iNewY, pr.getArgb(iNewX, iNewY));}
	                        } //-loop
	                } //-loop
	                if(iOffsetY == 0) iOffsetY = iSize;
	                else              iOffsetY = 0    ;
	        } //-loop
	        return wiNew;
	} //-method

	////////////////////////////////////////////////////////////////////////
	public Image doStripesHorizontal(Image imgSrc1  ,
		                         Image imgSrc2  ,
		                         int   iHeight  )
	{ //+method
		WritableImage wiNew = doCopy(imgSrc1)         ;
		PixelReader   pr    = imgSrc2.getPixelReader();
		PixelWriter   pw    =  wiNew .getPixelWriter();
		for(int iY = 0               ,
			iX = 0               ;
			iX < wiNew.getWidth();
			iX++                 )
		{ //+loop
			for(int iCount = 0      ;
				iCount < iHeight;
				iCount++        ,
				    iY++        )
			{ //+loop
				pw.setArgb(iX, iY, pr.getArgb(iX, iY));
			} //-loop
			iY+= iHeight;
		} //-loop
		return wiNew;
	} //-method

	////////////////////////////////////////////////////////////////////////
	public Image doStripesVertical(Image imgSrc1 ,
		                       Image imgSrc2 ,
		                       int   iWidth)
	{ //method
		WritableImage wiNew = doCopy(imgSrc1)         ;
		PixelReader   pr    = imgSrc2.getPixelReader();
		PixelWriter   pw    =  wiNew .getPixelWriter();
		for(int iX = 0                ,
			iY = 0                ;
			iY < wiNew.getHeight();
			iY++                  )
		{ //+loop
			for(int count = 0;
				count < iWidth;
				count++       ,
				   iX+= iWidth)
			{ //+loop
				iX++;
				pw.setArgb(iX, iY, pr.getArgb(iX, iY));
			} //-loop
		} //-loop
		return wiNew;
	} //-method
} //-class

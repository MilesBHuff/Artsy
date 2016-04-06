package src.p2                  ;
import  javafx.scene.image.Image;
import  src.effects.Artsy       ;

/**
 * @author Preston Sheppard (coding)
 * @author Miles B Huff (bugfixing and formatting)
**/
public class MyArtsy implements Artsy
{ //+class
	////////////////////////////////////////////////////////////////////////
	@Override
	public Image doCopy(Image imgSrc)
	{ //+method
		int           iWidth  =     imgSrc.getWidth      (               );
		int           iHeight =     imgSrc.getHeight     (               );
		WritableImage wiCopy  = new WritableImage        (iWidth, iHeight);
		PixelReader   pr      =     imgSrc.getPixelReader(               );
		PixelWriter   pw      =     wiCopy.getPixelWriter(               );
		for (int iX = 0     ;
			 iX < iWidth;
			 iX++       )
		{ //+loop
			for(int iY = 0      ;
				iY < iHeight;
				iY++        )
			{ pw.setArgb(iX, iY, pr.getArgb(iX, iY)); }
		} //-loop
		return oCopy;
	} //-method

	////////////////////////////////////////////////////////////////////////
	@Override
	public Image doRotate(Image  imgSrc,
		              double dDeg)
	{ //+method
		Image       imgNew = new Image                (copyImage(imgSrc));
		PixelReader pr     =     imgSrc.getPixelReader(                 );
		PixelWriter pw     =     imgNew.getPixelWriter(                 );
		for(int iX = 0                ,
		     iNewX = 0                ;
		        iX < imgNew.getWidth();
		        iX++                  )
		{ //+loop
			for(int iY = 0                 ,
			     iNewY = 0                 ;
			        iY < imgNew.getHeight();
			        iY++                   )
			{ //+loop
				iNewX =  iX * (int)Math.cos(dDeg) + iY * (int)Math.sin(dDeg);
				iNewY = -iX * (int)Math.sin(dDeg) + iY * (int)Math.cos(dDeg);
				if((    0<= iNewX             )
				&& (    0<= iNewY             )
				&& (iNewX<= imgNew.getWidth() )
				&& (iNewY<= imgNew.getHeight()))
				{ pw.setArgb(iNewX, iNewY, pr.getArgb(iX, iY)); }
			} //-loop
		} //-loop
		return imgNew;
	} //-method

	////////////////////////////////////////////////////////////////////////
	@Override
	public Image doCheckers(Image imgSrc1,
	                        Image imgSrc2,
	                        int   iSize  )
	{ //+method
	        Image       imgNew = new Image                 (doCopy(imgSrc1));
	        PixelReader pr     =     imgSrc2.getPixelReader(               );
	        PixelWriter pw     =     imgNew.getPixelWriter (               );
	        for(int iOffsetY = 0                ,
	                      iX = 0                ;
	                      iX < imgNew.getWidth();
	                      iX+= iSize            )
	        { //+loop
	                for(int iY = 0                 ;
	                        iY < imgNew.getHeight();
	                        iY+= iSize             )
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
	                                { pw.setArgb(iNewX, iNewY, pr.getArgb(iNewX, iNewY)); }
	                        } //-loop
	                } //-loop
	                if(iOffsetY == 0) iOffsetY = iSize;
	                else              iOffsetY = 0    ;
	        } //-loop
	        return imgNew;
	} //-method

	////////////////////////////////////////////////////////////////////////
	@Override
	public Image doStripesHorizontal(Image imgSrc1  ,
		                         Image imgSrc2  ,
		                         int   iHeight  )
	{ //+method
		Image       imgNew = new Image                 (doCopy(imgSrc1));
		PixelReader pr     =     imgSrc2.getPixelReader(               );
		PixelWriter pw     =     imgNew.getPixelWriter (               );
		for(int iY = 0                ,
			iX = 0                ;
			iX < imgNew.getWidth();
			iX++                  )
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
		return oNew;
	} //-method

	////////////////////////////////////////////////////////////////////////
	@Override
	public Image doStripesVertical(Image imgSrc1 ,
		                       Image imgSrc2 ,
		                       int   iWidth)
	{ //method
		Image       imgNew = new Image                 (doCopy(imgSrc1));
		PixelReader pr     =     imgSrc2.getPixelReader(               );
		PixelWriter pw     =     imgNew.getPixelWriter (               );
		for(int iX = 0               ,
			iY = 0               ;
			iY < imgNew.getHeight();
			iY++                 )
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
		return imgNew;
	} //-method
} //-class

package cs1302.p2;
import  cs1302.effects.Artsy;
import  javafx.scene.image.Image;

public class MyArtsy implements Artsy
{ //+class
	////////////////////////////////////////////////////////////////////////
	/** Given an <code>Image</code>, this method returns a deep copy of the
	 *  given <code>Image</code>.
	 * @param  src The <code>Image</code> to copy
	 * @return a deep copy of <code>src</code>
	**/
	private Image copyImage(Image src)
	{ //+method
		int width  = (int) src.getWidth();
		int height = (int) src.getHeight();
		WritableImage ret = new WritableImage(width, height);
		PixelReader pr = src.getPixelReader();
		PixelWriter pw = ret.getPixelWriter();
		for (int x = 0;
			 x < width;
			 x++)
		{ //+loop
			for(int y = 0;
				y < height;
				y++)
			{ //+loop
				pw.setArgb(x, y, pr.getArgb(x, y));
			} //-loop
		} //-loop
		return ret;
	} //-method

	////////////////////////////////////////////////////////////////////////
	@Override
	public Image doRotate(Image  src    ,
		              double degrees )
	{ //+method
		return null;
	} //-method

	////////////////////////////////////////////////////////////////////////
	@Override
	public Image doCheckers(Image src1,
		                Image src2,
		                int   size )
	{ //+method
		Image temp = new Image(copyImage(src1));
		PixelReader pr = src2.getPixelReader();
		PixelWriter pw = temp.getPixelWriter();
		int tempy = 0,
		    tempx = 0;
		for(int x = 0; x < temp.getWidth(); x++)
		{ //+loop
			for(int y = 0;
				y < temp.getHeight();
				y++)
			{ //+loop
				for(int countx = 0;
					countx < size;
					countx++)
				{ //+loop
					for (int county = 0;
						county < size;
						county++)
					{ //+loop
						pw.setArgb(x, y, pr.getArgb(x, y));
						tempy++;
					} //-loop
					tempx++;
				} //-loop
				y+= size;
			} //-loop
			x+= size;
		} //-loop
		return temp;
	} //-method

	////////////////////////////////////////////////////////////////////////
	@Override
	public Image doHorizontalStripes(Image src1  ,
		                         Image src2  ,
		                         int   height )
	{ //+method
		Image temp = new Image(copyImage(src1));
		PixelReader pr = src2.getPixelReader();
		PixelWriter pw = temp.getPixelWriter();
		int y = 0;
		for(int x = 0;
			x < temp.getWidth();
			x++)
		{ //+loop
			for(int count = 0;
				count < height;
				count++)
			{ //+loop
				y++;
				pw.setArgb(x, y, pr.getArgb(x, y));
			} //-loop
			y+= height;
		} //-loop
		return temp;
	} //-method

	////////////////////////////////////////////////////////////////////////
	@Override
	public Image doVerticalStripes(Image src1, Image src2, int width)
	{ //method
		Image temp = new Image(copyImage(src1));
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

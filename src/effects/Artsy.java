package src.effects;
import  javafx.scene.image.Image;

/** This interface describes Artsy!-effects that can be applied to Images. **/
public interface Artsy
{ //interface
	////////////////////////////////////////////////////////////////////////
	/** Given two <code>Image</code>s, this method returns a new
	 *  <code>Image</code>, the contents of which is composed of the source
	 *  images alternating horizontally and vertically at the specified
	 *  size, in pixels. This causes the <code>Image</code>s to appear
	 *  woven together in a checkered fashion.  
	 * @param  src1   The first <code>Image</code>
	 * @param  src2   The second <code>Image</code>
	 * @param  height The height, in pixels, of the horizontal stripes.
	 * @return a checkered <code>Image</code> composed of <code>src1</code> and <code>src2</code>.
	**/
	public Image doCheckers(Image src1,
		                Image src2,
		                int   size );

	////////////////////////////////////////////////////////////////////////
	/** Given two <code>Image</code>s, this method returns a new
	 *  <code>Image</code>, the contents of which is composed of the source
	 *  <code>Image</code>s alternating horizontally at the specified pixel-
	 *  height.
	 * @param  src1   The first <code>Image</code>
	 * @param  src2   The second <code>Image</code>
	 * @param  height The height, in pixels, of the horizontal stripes.
	 * @return a horizontally striped <code>Image</code> composed of <code>src1</code> and <code>src2</code>.
	**/
	public Image doHorizontalStripes(Image src1  ,
		                         Image src2  ,
		                         int   height );

	////////////////////////////////////////////////////////////////////////
	/** Given two Images, this method returns a new Image, the contents of
	 *  which is composed of the source images alternating vertically at the
	 *  specified pixel width. For an example, please see the project-
	 *  description.
	 * @param  src1  The first Image
	 * @param  src2  The second Image
	 * @param  width The width, in pixels, of the vertical stripes.
	 * @return an <code>Image</code> with the vertical stripes effect.
	**/
	public Image doVerticalStripes(Image src1 ,
		                       Image src2 ,
		                       int   width );

	////////////////////////////////////////////////////////////////////////
	/** Given a Image, this method returns a new Image which contains the
	 *  source image rotated clockwise by a certain number of degrees. The
	 *  image should be rotated about the center of the image. For an
	 *  example, please see the project description.  The easiest way to
	 *  rotate an image is to use an affine transformation.  See the
	 *  reference mentioned below for a link to AWT's
	 *  <code>AffineTransform</code> class.
	 * @see    http://docs.oracle.com/javase/8/docs/api/java/awt/geom/AffineTransform.html
	 * @param  src     The source Image
	 * @param  degrees The degrees to rotate the image, in degrees (not radians)
	 * @return a new <code>Image</code> containing a rotated version of the source image.
	**/
	public Image doRotate(Image  src    ,
		              double degrees );
} //interface

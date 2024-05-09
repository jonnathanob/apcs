import java.awt.Color;

public class Steganography {
    public static void main(String[] args) {
        // Notice how the picture needs to be created!
        // Don't change the String value in the Picture parameter.
        Picture beach = new Picture("images/beach.jpg");
        beach.explore();

        // Picture revealed = revealPicture(beach);

        // revealed.write("images/reavealed.png");
        // beach.explore();
        // beach = testClearLow(beach);
        // beach.write("images/test.png");
        // System.out.println(beach);
        // int i = 183;
        // i /= 4;
        // i *= 4;

        // i += 3;
        // System.out.println(i % 4);
    }

    public static boolean canHide(Picture source, Picture secret) {
        return source.getHeight() == secret.getHeight() && source.getWidth() == secret.getWidth();
    }

    public static Picture revealPicture(Picture p) {
        Picture picture = new Picture(p);
        Pixel[][] old_pixels = p.getPixels2D();
        Pixel[][] new_pixels = picture.getPixels2D();

        for (int i = 0; i < new_pixels.length; i++) {
            for (int j = 0; j < new_pixels[i].length; j++) {
                Pixel x = new_pixels[i][j];

                Pixel x_old = old_pixels[i][j];
                Color c_old = x_old.getColor();

                int old_r = c_old.getRed();
                int old_g = c_old.getGreen();
                int old_b = c_old.getBlue();

                int new_r = old_r % 4 * 64;
                int new_g = old_g % 4 * 64;
                int new_b = old_b % 4 * 64;

                x.setRed(new_r);
                x.setGreen(new_g);
                x.setBlue(new_b);
            }
        }

        return picture;
    }

    /**
     * Clear the lower (rightmost) two bits in a pixel.
     */
    public static void clearLow(Pixel p) {
        /* To be implemented */
        Color old = p.getColor();

        int r = old.getRed();
        int g = old.getGreen();
        int b = old.getBlue();

        r /= 4;
        g /= 4;
        b /= 4;

        r *= 4;
        g *= 4;
        b *= 4;

        p.setColor(new Color(r, g, b));
    }

    /**
     * Returns a new Picture object with the lowest two bits of each pixel cleared.
     */
    public static Picture testClearLow(Picture p) {
        /* To be implemented */
        Picture p2 = new Picture(p);

        Pixel[][] pixels = p2.getPixels2D();

        for (int i = 0; i < pixels.length; i++) {
            for (int o = 0; o < pixels[i].length; o++) {
                Pixel pix = (pixels[i][o]);
                clearLow(pix);
            }
        }

        return p2;
    }

}

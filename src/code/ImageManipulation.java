package code;

import image.APImage;
import image.Pixel;

public class ImageManipulation {



    /** CHALLENGE 0: Display Image
     *  Write a statement that will display the image in a window
     */
    private static APImage image;
    public static void main(String[] args) {
        image = new APImage("src/image/cyberpunk2077.jpg");
        image.draw();
    }

    /** CHALLENGE ONE: Grayscale
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a grayscale copy of the image
     *
     * To convert a colour image to grayscale, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * Set the red, green, and blue components to this average value. */
    public static void grayScale(String pathOfFile) {
        APImage img = new APImage(pathOfFile);

        for (int i=0; i<=img.getWidth()-1; i++){
            for (int j=0; j<=img.getHeight()-1; j++){
                Pixel p = img.getPixel(i,j);
                int avg = getAverageColour(p);
                p.setRed(avg);
                p.setGreen(avg);
                p.setBlue(avg);
            }
        }

        img.draw();
    }

    /** A helper method that can be used to assist you in each challenge.
     * This method simply calculates the average of the RGB values of a single pixel.
     * @param pixel
     * @return the average RGB value
     */
    private static int getAverageColour(Pixel pixel) {
        int r = pixel.getRed(), g = pixel.getGreen(), b = pixel.getBlue();
        int average = (r + g + b) / 3;
        return average;
    }

    /** CHALLENGE TWO: Black and White
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a black and white copy of the image
     *
     * To convert a colour image to black and white, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * If the average is less than 128, set the pixel to black
     * If the average is equal to or greater than 128, set the pixel to white */
    public static void blackAndWhite(String pathOfFile) {
        APImage img = new APImage(pathOfFile);

        for (int i=0; i<=img.getWidth()-1; i++){
            for (int j=0; j<=img.getHeight()-1; j++){
                Pixel p = img.getPixel(i,j);
                int avg = getAverageColour(p);
                if (avg<128){
                    p.setRed(0);
                    p.setGreen(0);
                    p.setBlue(0);
                }
                else{
                    p.setRed(255);
                    p.setGreen(255);
                    p.setBlue(255);
                }

            }
        }

        img.draw();

    }

    /** CHALLENGE Three: Edge Detection
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: an outline of the image. The amount of information will correspond to the threshold.
     *
     * Edge detection is an image processing technique for finding the boundaries of objects within images.
     * It works by detecting discontinuities in brightness. Edge detection is used for image segmentation
     * and data extraction in areas such as image processing, computer vision, and machine vision.
     *
     * There are many different edge detection algorithms. We will use a basic edge detection technique
     * For each pixel, we will calculate ...
     * 1. The average colour value of the current pixel
     * 2. The average colour value of the pixel to the left of the current pixel
     * 3. The average colour value of the pixel below the current pixel
     * If the difference between 1. and 2. OR if the difference between 1. and 3. is greater than some threshold value,
     * we will set the current pixel to black. This is because an absolute difference that is greater than our threshold
     * value should indicate an edge and thus, we colour the pixel black.
     * Otherwise, we will set the current pixel to white
     * NOTE: We want to be able to apply edge detection using various thresholds
     * For example, we could apply edge detection to an image using a threshold of 20 OR we could apply
     * edge detection to an image using a threshold of 35
     *  */
    public static void edgeDetection(String pathToFile, int threshold) {
        APImage img = new APImage(pathToFile);

        for (int i=0; i<=img.getWidth()-1; i++){
            for (int j=0; j<=img.getHeight()-1; j++){
                Pixel p = img.getPixel(i,j);
                Pixel left = img.getPixel(0,0);
                Pixel below = img.getPixel(0,0);
                try {
                    left = img.getPixel(i - 1, j);
                    below = img.getPixel(i,j+1);

                    int p_avg = getAverageColour(p), left_avg = getAverageColour(left), below_avg = getAverageColour(below);
                    if (Math.abs(p_avg - left_avg) > threshold || Math.abs(p_avg - below_avg) > threshold){
                        p.setRed(0);
                        p.setGreen(0);
                        p.setBlue(0);
                    }
                    else{
                        p.setRed(255);
                        p.setGreen(255);
                        p.setBlue(255);
                    }

                } catch (ArrayIndexOutOfBoundsException e){

                }

            }
        }

        img.draw();


    }

    /** CHALLENGE Four: Reflect Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image reflected about the y-axis
     *
     */
    public static void reflectImage(String pathToFile) {
        APImage img = new APImage(pathToFile);

        int midpt = img.getWidth() / 2;

        for (int i=0; i<=img.getWidth()/2; i++) {
            for (int j = 0; j <= img.getHeight()-1; j++) {
                Pixel p = img.getPixel(i,j);
                Pixel opp = img.getPixel(2*midpt - i -1, j);
                img.setPixel(2*midpt - i -1, j, p);
                img.setPixel(i,j,opp);
            }
        }

        img.draw();

    }

    /** CHALLENGE Five: Rotate Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image rotated 90 degrees CLOCKWISE
     *
     *  */
    public static void rotateImage(String pathToFile) {



    }

}
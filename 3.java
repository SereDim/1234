package com.company;
import java.awt.geom.AffineTransform;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.imageio.ImageIO;


public class Main {

    static Scanner scanner = new Scanner(System.in);//для сканера
    static Random random = new Random();//Для рандома
    static ArrayList<Integer> myList = new ArrayList<Integer>();

    public static int getInt(){                     //метод для считывания числа без ошибок
        System.out.println("Введите число:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }











    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }













    public static int getColor(){                     //метод для считывания числа без ошибок
        System.out.println("Введите число от 0 до 255:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
            if (num>255 || num<0){
                System.out.println("ОТ 0 ДО 255!.");
                scanner.next();
                num = getInt();
            }
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }






    public static void main(String[] args) throws IOException {


        //Устанавливаем размеры изображения
        System.out.print("\nШирину изображения: ");
        int width = getInt();
        System.out.print("\nВысоту изображения: ");
        int height = getInt();





        //Создаём изображение
        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();
        //Сохраняем создавшийся файл
        // Disposes of this graphics context and releases any system resources that it is using.
        g2d.dispose();




        // Save as JPEG
        File file = new File("myimage.jpg");
        ImageIO.write(bufferedImage, "jpg", file);






        try {



            //ищем предыдущее изображение и создаём новое
            File file2 = new File("C:\\Users\\SereD\\IdeaProjects\\Ind 3.1\\myimage.jpg");
            BufferedImage source = ImageIO.read(file2);


            BufferedImage result = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());











            //Устанавливаем размеры изображения
            int width3 = source.getWidth()/2;


            int height3 = source.getHeight()/2;






            //Создаём изображение
            // Constructs a BufferedImage of one of the predefined image types.
            BufferedImage source3 = new BufferedImage(width3, height3, BufferedImage.TYPE_INT_RGB);

            // Create a graphics which can be used to draw into the buffered image
            Graphics2D g2d3 = source3.createGraphics();












            System.out.print("\nНапишите 1, если желаете прописать значение каждого пикселя\nНапишите 2, если желаете заполнить пиксели случайными цветами: ");
            char choice;
            choice = scanner.next().charAt(0);
            int flag = -1;
            int avarage = 0;

            switch (choice) {



                //write
                case '1':

                    for (int x = 0; x < source.getWidth(); x++) {
                        for (int y = 0; y < source.getHeight(); y++) {

                            // Получаем цвет текущего пикселя
                            Color color = new Color(source.getRGB(x, y));



                            int common = getColor();
                            flag++;

                            myList.add(common);




                            if (x == 0 && y == 2){
                                Color newColor = new Color(0,0,0);
                                result.setRGB(x, y, newColor.getRGB());
                            }
                            else{
                                Color newColor = new Color(common,common,common);
                                result.setRGB(x, y, newColor.getRGB());
                            }








                            //  Для сжатого массива
                            if (x%2 > 0 && y%2 > 0 ) {


                                avarage = myList.get(flag) + myList.get(flag - 1) + myList.get(flag - source.getWidth()) + myList.get(flag - source.getWidth() - 1);
                                avarage = avarage/4;





                                Color newColor1 = new Color(avarage, avarage, avarage);
                                source3.setRGB((x/2), (y/2), newColor1.getRGB());
                            }




                            //  Создаём новый цве


                            // И устанавливаем этот цвет в текущий пиксель результирующего изображения
                        }
                    }
                    break;








                    //random
                case '2':

                    for (int x = 0; x < source.getWidth(); x++) {
                        for (int y = 0; y < source.getHeight(); y++) {

                            // Получаем цвет текущего пикселя
                            Color color = new Color(source.getRGB(x, y));


                            int randomColor = random.nextInt(255);


                            flag++;
                            myList.add(randomColor);




                            if (x == 0 && y == 2){
                                Color newColor = new Color(0,0,0);
                                result.setRGB(x, y, newColor.getRGB());
                            }
                            else{
                                Color newColor = new Color(randomColor,randomColor,randomColor);
                                result.setRGB(x, y, newColor.getRGB());
                            }




                            //  Для сжатого массива
                            if (x%2 > 0 && y%2 > 0 ) {


                                avarage = myList.get(flag) + myList.get(flag - 1) + myList.get(flag - source.getWidth()) + myList.get(flag - source.getWidth() - 1);
                                avarage = avarage/4;





                                Color newColor1 = new Color(avarage, avarage, avarage);
                                source3.setRGB((x/2), (y/2), newColor1.getRGB());
                            }





                        }
                    }
                    break;






                default:
                    System.out.printf("Ошибка");
                    return;
            }



































                // Сохраняем результат в новый файл
            File output = new File("Array.jpg");
            ImageIO.write(result, "jpg", output);








            //Сохраняем создавшийся файл
            // Disposes of this graphics context and releases any system resources that it is using.
            g2d.dispose();




            // Save as JPEG
            File file3 = new File("Scaledimage.jpg");
            ImageIO.write(source3, "jpg", file3);



            //scale









            File finalScale = new File("C:\\Users\\SereD\\IdeaProjects\\Ind 3.1\\Array.jpg");
            BufferedImage finalSource = ImageIO.read(finalScale);




            BufferedImage aa = resizeImage(finalSource, width * 500, height * 500);



            File file4 = new File("Array.jpg");
            ImageIO.write(aa, "jpg", file4);










            File finalScale2 = new File("C:\\Users\\SereD\\IdeaProjects\\Ind 3.1\\Scaledimage.jpg");
            BufferedImage finalSource2 = ImageIO.read(finalScale2);




            BufferedImage aa2 = resizeImage(finalSource2, width * 500, height * 500);



            File file42 = new File("Scaledimage.jpg");
            ImageIO.write(aa2, "jpg", file42);


















        } catch (IOException e) {

            // При открытии и сохранении файлов, может произойти неожиданный случай.
            // И на этот случай у нас try catch
            System.out.println("Файл не найден или не удалось сохранить");

        }
    }
}
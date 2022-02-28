package com.mqxu.web.exercise.util;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @description: 验证码生成工具类
 * @author: mqxu
 * @date: 2022-02-28
 **/
@Slf4j
public class VerifyCodeUtil {
    public static final int RANGE = 255;
    public static final String VERIFY_CODES = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random random = new Random();

    /**
     * 输出随机验证码图片流,并返回验证码值（一般传入输出流，响应response页面端，Web项目用的较多）
     *
     * @param width      图片宽度
     * @param height     图片高度
     * @param os         输出流
     * @param verifySize 数据长度
     * @return 验证码数据
     * @throws IOException IO异常
     */
    public static String outputVerifyImage(int width, int height, OutputStream os, int verifySize) throws IOException {
        String verifyCode = generateVerifyCode(verifySize);
        outputImage(width, height, os, verifyCode);
        return verifyCode;
    }

    /**
     * 使用系统默认字符源生成验证码
     *
     * @param verifySize 验证码长度
     * @return String
     */
    public static String generateVerifyCode(int verifySize) {
        return generateVerifyCode(verifySize, VERIFY_CODES);
    }

    /**
     * 使用指定源生成验证码
     *
     * @param verifySize 验证码长度
     * @param sources    验证码字符源
     * @return String
     */
    public static String generateVerifyCode(int verifySize, String sources) {
        // 未设定展示源的字码，赋默认值大写字母+数字
        if (sources == null || sources.length() == 0) {
            sources = VERIFY_CODES;
        }
        int codesLen = sources.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for (int i = 0; i < verifySize; i++) {
            verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
        }
        return verifyCode.toString();
    }

    /**
     * 生成随机验证码文件,并返回验证码值 (生成图片形式，用得较少)
     *
     * @param w          宽度
     * @param h          高度
     * @param outputFile 输出文件
     * @param verifySize 尺寸
     * @return String
     * @throws IOException IO异常
     */
    public static String outputVerifyImage(int w, int h, File outputFile, int verifySize) throws IOException {
        String verifyCode = generateVerifyCode(verifySize);
        outputImage(w, h, outputFile, verifyCode);
        return verifyCode;
    }


    /**
     * 生成指定验证码图像文件
     *
     * @param w          宽度
     * @param h          高度
     * @param outputFile 输出文件
     * @param code       验证码字符串
     * @throws IOException IO异常
     */
    public static void outputImage(int w, int h, File outputFile, String code) throws IOException {
        if (outputFile == null) {
            return;
        }
        File dir = outputFile.getParentFile();
        //文件不存在
        if (!dir.exists()) {
            //创建文件
            boolean flag = dir.mkdirs();
            log.info(String.valueOf(flag));
        }
        boolean flag = outputFile.createNewFile();
        log.info(String.valueOf(flag));
        FileOutputStream fos = new FileOutputStream(outputFile);
        outputImage(w, h, fos, code);
        fos.close();
    }

    /**
     * 输出指定验证码图片流
     *
     * @param w    宽度
     * @param h    高度
     * @param os   字节输出流
     * @param code 验证码字符串
     * @throws IOException IO异常
     */
    public static void outputImage(int w, int h, OutputStream os, String code) throws IOException {
        int verifySize = code.length();
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Random rand = new Random();
        Graphics2D g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 创建颜色集合，使用java.awt包下的类
        //Color[] colors = new Color[5];
        //Color[] colorSpaces = new Color[]{Color.WHITE, Color.CYAN,
        //        Color.GRAY, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
        //        Color.PINK, Color.YELLOW};
        //float[] frActions = new float[colors.length];
        //for (int i = 0; i < colors.length; i++) {
        //    colors[i] = colorSpaces[rand.nextInt(colorSpaces.length)];
        //    frActions[i] = rand.nextFloat();
        //}
        //Arrays.sort(frActions);
        // 设置边框色
        g2.setColor(Color.GRAY);
        g2.fillRect(0, 0, w, h);

        Color c = getRandColor(200, 250);
        // 设置背景色
        g2.setColor(c);
        g2.fillRect(0, 2, w, h - 4);
        // 绘制干扰线
        Random random = new Random();
        // 设置线条的颜色
        g2.setColor(getRandColor(160, 200));
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(w - 1);
            int y = random.nextInt(h - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            g2.drawLine(x, y, x + xl + 40, y + yl + 20);
        }

        // 添加噪点
        // 噪声率
        float yawRate = 0.05f;
        int area = (int) (yawRate * w * h);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(w);
            int y = random.nextInt(h);
            // 获取随机颜色
            int rgb = getRandomIntColor();
            image.setRGB(x, y, rgb);
        }
        // 添加图片扭曲
        shear(g2, w, h, c);

        g2.setColor(getRandColor(100, 160));
        int fontSize = h - 4;
        Font font = new Font("Algerian", Font.ITALIC, fontSize);
        g2.setFont(font);
        char[] chars = code.toCharArray();
        for (int i = 0; i < verifySize; i++) {
            AffineTransform affine = new AffineTransform();
            affine.setToRotation(Math.PI / 4 * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1), (w * 1.0 / verifySize) * i + fontSize / 2.0, h / 2.0);
            g2.setTransform(affine);
            g2.drawChars(chars, i, 1, ((w - 10) / verifySize) * i + 5, h / 2 + fontSize / 2 - 10);
        }
        g2.dispose();
        ImageIO.write(image, "jpg", os);
    }

    /**
     * 随机颜色
     *
     * @param fc 前景色
     * @param bc 背景色
     * @return color
     */
    private static Color getRandColor(int fc, int bc) {
        if (fc > RANGE) {
            fc = RANGE;
        }
        if (bc > RANGE) {
            bc = RANGE;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    private static int getRandomIntColor() {
        int[] rgb = getRandomRgb();
        int color = 0;
        for (int c : rgb) {
            color = color << 8;
            color = color | c;
        }
        return color;
    }

    private static int[] getRandomRgb() {
        int[] rgb = new int[3];
        for (int i = 0; i < 3; i++) {
            rgb[i] = random.nextInt(255);
        }
        return rgb;
    }

    private static void shear(Graphics g, int w1, int h1, Color color) {
        shearX(g, w1, h1, color);
        shearY(g, w1, h1, color);
    }

    private static void shearX(Graphics g, int w1, int h1, Color color) {
        int period = random.nextInt(2);
        int frames = 1;
        int phase = random.nextInt(2);

        for (int i = 0; i < h1; i++) {
            double d = (double) (0)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(0, i, w1, 1, (int) d, 0);
            g.setColor(color);
            g.drawLine((int) d, i, 0, i);
            g.drawLine((int) d + w1, i, w1, i);
        }

    }

    private static void shearY(Graphics g, int w1, int h1, Color color) {
        // 50;
        int period = random.nextInt(40) + 10;
        int frames = 20;
        int phase = 7;
        for (int i = 0; i < w1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(i, 0, 1, h1, 0, (int) d);
            g.setColor(color);
            g.drawLine(i, (int) d, i, 0);
            g.drawLine(i, (int) d + h1, i, h1);
        }
    }


    public static void main(String[] args) throws IOException {
        //测试一下验证码生成在本地
        OutputStream fos = new FileOutputStream("/Users/mqxu/Desktop/code.jpg");
        String code = VerifyCodeUtil.outputVerifyImage(100, 50, fos, 4);
        System.out.println(code);
    }

}

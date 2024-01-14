package org.example.demo.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

/**
 * 二维码工具
 *
 * @author fausto
 */
public class QRcodeUtil {

    private static final String CHARSET = "utf-8";
    private static final String FORMAT_NAME = "JPG";

    private static final int QRCODE_SIZE = 300;


    public static BufferedImage createImage(String url) throws WriterException {
        Hashtable hs = new Hashtable();
        hs.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hs.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hs.put(EncodeHintType.MARGIN, 1);
        BitMatrix encode = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hs);

        int width = encode.getWidth();
        int height = encode.getHeight();

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bufferedImage.setRGB(x, y, encode.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return bufferedImage;
    }

    public static void encode(String url, HttpServletResponse response) throws Exception {
        BufferedImage image = createImage(url);
        ImageIO.write(image, FORMAT_NAME, response.getOutputStream());

    }


}

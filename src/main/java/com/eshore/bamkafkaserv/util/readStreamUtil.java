package com.eshore.bamkafkaserv.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * created by czx on 2019/8/6 0006.
 */


public class readStreamUtil {

    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        return outSteam.toByteArray();
    }

}

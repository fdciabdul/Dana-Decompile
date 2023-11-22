package com.alibaba.griver.beehive.lottie.util;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class IOUtil {
    public static void closeStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }
}

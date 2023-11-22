package com.alibaba.griver.beehive.lottie.util;

import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.HexStringUtil;
import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

/* loaded from: classes6.dex */
public class MD5Util {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final String TAG = "MD5Util";

    public static String encrypt(String str) {
        try {
            return HexStringUtil.bytesToHexString(com.alibaba.griver.base.common.utils.MD5Util.getMD5Byte(str.getBytes(HexStringUtil.DEFAULT_CHARSET)));
        } catch (Throwable th) {
            GriverLogger.e(TAG, th.getMessage(), th);
            return null;
        }
    }

    public static String getFileMD5String(File file) {
        synchronized (MD5Util.class) {
            try {
                new FileInputStream(file).getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length());
                throw new NullPointerException();
            } catch (Exception e) {
                GriverLogger.e(TAG, "get file md5 exception: {}", e);
                return "";
            }
        }
    }

    public static String bytesToHex(byte[] bArr) {
        return bytesToHex(bArr, 0, bArr.length);
    }

    public static String bytesToHex(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = i; i3 < i + i2; i3++) {
            sb.append(byteToHex(bArr[i3]));
        }
        return sb.toString();
    }

    public static String byteToHex(byte b) {
        StringBuilder sb = new StringBuilder();
        char[] cArr = HEX_DIGITS;
        sb.append(cArr[(b & 240) >> 4]);
        sb.append(cArr[b & 15]);
        return sb.toString();
    }
}

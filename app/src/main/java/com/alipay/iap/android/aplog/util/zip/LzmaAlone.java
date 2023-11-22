package com.alipay.iap.android.aplog.util.zip;

import com.alipay.iap.android.aplog.core.LoggerFactory;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: classes3.dex */
public class LzmaAlone {
    private static final String TAG = "LzmaAlone";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r12v11, types: [com.alipay.iap.android.aplog.util.zip.LZMA_Decoder] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.alipay.iap.android.aplog.util.zip.LZMA_Encoder] */
    public static boolean sevenZipFile(boolean z, boolean z2, String str, String str2) {
        ?? r13;
        BufferedInputStream bufferedInputStream;
        ?? bufferedOutputStream;
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists() && file.isFile() && !file2.isDirectory()) {
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r13 = 0;
                }
                try {
                    if (z) {
                        ?? lZMA_Encoder = new LZMA_Encoder();
                        lZMA_Encoder.SetEndMarkerMode(z2);
                        lZMA_Encoder.WriteCoderProperties(bufferedOutputStream);
                        long length = z2 ? -1L : file.length();
                        for (int i = 0; i < 8; i++) {
                            bufferedOutputStream.write(((int) (length >>> (i * 8))) & 255);
                        }
                        lZMA_Encoder.Code(bufferedInputStream, bufferedOutputStream, -1L, -1L, null);
                    } else {
                        byte[] bArr = new byte[5];
                        if (bufferedInputStream.read(bArr, 0, 5) != 5) {
                            throw new Exception("input .lzma file is too short");
                        }
                        ?? lZMA_Decoder = new LZMA_Decoder();
                        long j = 0;
                        if (!lZMA_Decoder.SetDecoderProperties(bArr)) {
                            throw new Exception("Incorrect stream properties");
                        }
                        for (int i2 = 0; i2 < 8; i2++) {
                            int read = bufferedInputStream.read();
                            if (read < 0) {
                                throw new Exception("Can't read stream size");
                            }
                            j |= read << (i2 * 8);
                        }
                        if (!lZMA_Decoder.Code(bufferedInputStream, bufferedOutputStream, j)) {
                            throw new Exception("Error in data stream");
                        }
                    }
                    bufferedOutputStream.flush();
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th3) {
                        printThrowableLog(th3);
                    }
                    try {
                        bufferedOutputStream.close();
                        return true;
                    } catch (Throwable th4) {
                        printThrowableLog(th4);
                        return true;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream2 = bufferedOutputStream;
                    r13 = bufferedInputStream2;
                    bufferedInputStream2 = bufferedInputStream;
                    try {
                        printThrowableLog(th);
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Throwable th6) {
                                printThrowableLog(th6);
                            }
                        }
                        if (r13 != 0) {
                            try {
                                r13.close();
                            } catch (Throwable th7) {
                                printThrowableLog(th7);
                            }
                        }
                        return false;
                    } finally {
                    }
                }
            }
        }
        return false;
    }

    private static void printThrowableLog(Throwable th) {
        LoggerFactory.getTraceLogger().error(TAG, "sevenZipFile", th);
    }
}

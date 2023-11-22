package com.alibaba.ariver.resource.parser;

import android.util.Base64;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.iap.ac.android.common.utils.security.RSAHelper;
import io.split.android.client.service.ServiceConstants;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: classes6.dex */
class RsaUtil {
    RsaUtil() {
    }

    private static boolean a(String str, String str2, String str3) {
        FileInputStream fileInputStream;
        FileChannel fileChannel;
        boolean b;
        MappedByteBuffer mappedByteBuffer = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                fileChannel = fileInputStream.getChannel();
            } catch (Throwable th) {
                th = th;
                fileChannel = null;
            }
            try {
                long size = fileChannel.size();
                if (size < 65536 || size > ServiceConstants.MAX_EVENTS_SIZE_BYTES) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("verify size=");
                    sb.append(size);
                    RVLogger.d("AriverRes:Rsa", sb.toString());
                    b = b(str, str2, str3);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("NIO verify size=");
                    sb2.append(size);
                    RVLogger.d("AriverRes:Rsa", sb2.toString());
                    PublicKey generatePublic = KeyFactory.getInstance(RSAHelper.DEFAULT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 2)));
                    byte[] decode = Base64.decode(str3, 2);
                    Signature signature = Signature.getInstance("SHA1withRSA");
                    signature.initVerify(generatePublic);
                    mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size());
                    signature.update(mappedByteBuffer);
                    b = signature.verify(decode);
                }
                return b;
            } catch (Throwable th2) {
                th = th2;
                try {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("verify exception");
                    sb3.append(th);
                    RVLogger.e("AriverRes:Rsa", sb3.toString());
                    IOUtils.freeMappedBuffer(null);
                    IOUtils.closeQuietly(fileChannel);
                    IOUtils.closeQuietly(fileInputStream);
                    return false;
                } finally {
                    IOUtils.freeMappedBuffer(null);
                    IOUtils.closeQuietly(fileChannel);
                    IOUtils.closeQuietly(fileInputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            fileChannel = null;
        }
    }

    private static boolean b(String str, String str2, String str3) {
        BufferedInputStream bufferedInputStream;
        byte[] buf = IOUtils.getBuf(1024);
        boolean z = false;
        try {
            PublicKey generatePublic = KeyFactory.getInstance(RSAHelper.DEFAULT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 2)));
            byte[] decode = Base64.decode(str3, 2);
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(generatePublic);
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            int i = 0;
            while (bufferedInputStream.available() != 0) {
                try {
                    int read = bufferedInputStream.read(buf);
                    i += read;
                    signature.update(buf, 0, read);
                } catch (Throwable th) {
                    th = th;
                    try {
                        RVLogger.e("AriverRes:Rsa", "verify exception", th);
                        return z;
                    } finally {
                        IOUtils.returnBuf(buf);
                        IOUtils.closeQuietly(bufferedInputStream);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Stream verify size=");
            sb.append(i);
            RVLogger.d("AriverRes:Rsa", sb.toString());
            z = signature.verify(decode);
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean verify(String str, String str2, String str3) {
        if (IOUtils.isNIOEnabled()) {
            StringBuilder sb = new StringBuilder();
            sb.append("verify with NIO ");
            sb.append(str);
            RVLogger.d("AriverRes:Rsa", sb.toString());
            return a(str, str2, str3);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("verify with stream ");
        sb2.append(str);
        RVLogger.d("AriverRes:Rsa", sb2.toString());
        return b(str, str2, str3);
    }
}

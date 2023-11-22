package io.split.android.client.utils;

import io.split.android.client.utils.logger.Logger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/* loaded from: classes6.dex */
public class Gzip implements CompressionUtil {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r7v0, types: [io.split.android.client.utils.Gzip] */
    @Override // io.split.android.client.utils.CompressionUtil
    public byte[] decompress(byte[] bArr) {
        Exception e;
        GZIPInputStream gZIPInputStream;
        IOException e2;
        ?? r0 = 0;
        r0 = null;
        byte[] bArr2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            } catch (IOException e3) {
                e2 = e3;
                gZIPInputStream = null;
            } catch (Exception e4) {
                e = e4;
                gZIPInputStream = null;
            } catch (Throwable th) {
                th = th;
                close(byteArrayOutputStream);
                close(r0);
                close(byteArrayInputStream);
                throw th;
            }
            try {
                byte[] bArr3 = new byte[10240];
                while (true) {
                    int read = gZIPInputStream.read(bArr3);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
                bArr2 = byteArrayOutputStream.toByteArray();
            } catch (IOException e5) {
                e2 = e5;
                StringBuilder sb = new StringBuilder();
                sb.append("Gzip format error: ");
                sb.append(e2.getLocalizedMessage());
                Logger.e(sb.toString());
                close(byteArrayOutputStream);
                close(gZIPInputStream);
                close(byteArrayInputStream);
                return bArr2;
            } catch (Exception e6) {
                e = e6;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error decompressing gzip: ");
                sb2.append(e.getLocalizedMessage());
                Logger.e(sb2.toString());
                close(byteArrayOutputStream);
                close(gZIPInputStream);
                close(byteArrayInputStream);
                return bArr2;
            }
            close(byteArrayOutputStream);
            close(gZIPInputStream);
            close(byteArrayInputStream);
            return bArr2;
        } catch (Throwable th2) {
            r0 = bArr;
            th = th2;
            close(byteArrayOutputStream);
            close(r0);
            close(byteArrayInputStream);
            throw th;
        }
    }

    void close(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Gzip error closing component: ");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
        }
    }
}

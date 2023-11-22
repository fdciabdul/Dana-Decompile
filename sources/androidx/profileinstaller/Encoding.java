package androidx.profileinstaller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class Encoding {
    private Encoding() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getAuthRequestContext(String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void BuiltInFictitiousFunctionClassFactory(OutputStream outputStream, long j, int i) throws IOException {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((j >> (i2 * 8)) & 255);
        }
        outputStream.write(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(OutputStream outputStream, int i) throws IOException {
        BuiltInFictitiousFunctionClassFactory(outputStream, i, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory(OutputStream outputStream, int i) throws IOException {
        BuiltInFictitiousFunctionClassFactory(outputStream, i, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int BuiltInFictitiousFunctionClassFactory(int i) {
        return (((i + 8) - 1) & (-8)) / 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] BuiltInFictitiousFunctionClassFactory(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Not enough bytes to read: ");
                sb.append(i);
                throw new IllegalStateException(sb.toString());
            }
            i2 += read;
        }
        return bArr;
    }

    private static long KClassImpl$Data$declaredNonStaticMembers$2(InputStream inputStream, int i) throws IOException {
        byte[] BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(inputStream, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += (BuiltInFictitiousFunctionClassFactory[i2] & 255) << (i2 * 8);
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getAuthRequestContext(InputStream inputStream) throws IOException {
        return (int) KClassImpl$Data$declaredNonStaticMembers$2(inputStream, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int KClassImpl$Data$declaredNonStaticMembers$2(InputStream inputStream) throws IOException {
        return (int) KClassImpl$Data$declaredNonStaticMembers$2(inputStream, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long PlaceComponentResult(InputStream inputStream) throws IOException {
        return KClassImpl$Data$declaredNonStaticMembers$2(inputStream, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String PlaceComponentResult(InputStream inputStream, int i) throws IOException {
        return new String(BuiltInFictitiousFunctionClassFactory(inputStream, i), StandardCharsets.UTF_8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        if (r0.finished() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
    
        throw new java.lang.IllegalStateException("Inflater did not finish");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] getAuthRequestContext(java.io.InputStream r8, int r9, int r10) throws java.io.IOException {
        /*
            java.util.zip.Inflater r0 = new java.util.zip.Inflater
            r0.<init>()
            byte[] r1 = new byte[r10]     // Catch: java.lang.Throwable -> L88
            r2 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L88
            r3 = 0
            r4 = 0
            r5 = 0
        Le:
            boolean r6 = r0.finished()     // Catch: java.lang.Throwable -> L88
            if (r6 != 0) goto L55
            boolean r6 = r0.needsDictionary()     // Catch: java.lang.Throwable -> L88
            if (r6 != 0) goto L55
            if (r4 >= r9) goto L55
            int r6 = r8.read(r2)     // Catch: java.lang.Throwable -> L88
            if (r6 < 0) goto L39
            r0.setInput(r2, r3, r6)     // Catch: java.lang.Throwable -> L88
            int r7 = r10 - r5
            int r7 = r0.inflate(r1, r5, r7)     // Catch: java.util.zip.DataFormatException -> L2e java.lang.Throwable -> L88
            int r5 = r5 + r7
            int r4 = r4 + r6
            goto Le
        L2e:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L88
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L88
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L88
            throw r9     // Catch: java.lang.Throwable -> L88
        L39:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L88
            r8.<init>()     // Catch: java.lang.Throwable -> L88
            java.lang.String r10 = "Invalid zip data. Stream ended after $totalBytesRead bytes. Expected "
            r8.append(r10)     // Catch: java.lang.Throwable -> L88
            r8.append(r9)     // Catch: java.lang.Throwable -> L88
            java.lang.String r9 = " bytes"
            r8.append(r9)     // Catch: java.lang.Throwable -> L88
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L88
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L88
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L88
            throw r9     // Catch: java.lang.Throwable -> L88
        L55:
            if (r4 != r9) goto L69
            boolean r8 = r0.finished()     // Catch: java.lang.Throwable -> L88
            if (r8 == 0) goto L61
            r0.end()
            return r1
        L61:
            java.lang.String r8 = "Inflater did not finish"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L88
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L88
            throw r9     // Catch: java.lang.Throwable -> L88
        L69:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L88
            r8.<init>()     // Catch: java.lang.Throwable -> L88
            java.lang.String r10 = "Didn't read enough bytes during decompression. expected="
            r8.append(r10)     // Catch: java.lang.Throwable -> L88
            r8.append(r9)     // Catch: java.lang.Throwable -> L88
            java.lang.String r9 = " actual="
            r8.append(r9)     // Catch: java.lang.Throwable -> L88
            r8.append(r4)     // Catch: java.lang.Throwable -> L88
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L88
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L88
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L88
            throw r9     // Catch: java.lang.Throwable -> L88
        L88:
            r8 = move-exception
            r0.end()
            goto L8e
        L8d:
            throw r8
        L8e:
            goto L8d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.Encoding.getAuthRequestContext(java.io.InputStream, int, int):byte[]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(OutputStream outputStream, byte[] bArr) throws IOException {
        BuiltInFictitiousFunctionClassFactory(outputStream, bArr.length, 4);
        byte[] authRequestContext = getAuthRequestContext(bArr);
        BuiltInFictitiousFunctionClassFactory(outputStream, authRequestContext.length, 4);
        outputStream.write(authRequestContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] getAuthRequestContext(byte[] bArr) throws IOException {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[512];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        return new IllegalStateException(str);
    }
}

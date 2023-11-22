package io.split.android.client.utils;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes6.dex */
public class Zlib implements CompressionUtil {
    @Override // io.split.android.client.utils.CompressionUtil
    public byte[] decompress(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            Inflater inflater = new Inflater();
            inflater.setInput(bArr);
            byte[] bArr2 = new byte[10240];
            int inflate = inflater.inflate(bArr2);
            inflater.end();
            return Arrays.copyOfRange(bArr2, 0, inflate);
        } catch (DataFormatException e) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("DataFormatException error: ");
            sb.append(e.getLocalizedMessage());
            printStream.println(sb.toString());
            return null;
        } catch (Exception e2) {
            PrintStream printStream2 = System.out;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error decompressing: ");
            sb2.append(e2.getLocalizedMessage());
            printStream2.println(sb2.toString());
            return null;
        }
    }
}

package com.alibaba.ariver.kernel.api.bytedata;

import com.alibaba.ariver.kernel.api.bytedata.ByteArrayPools;
import id.dana.data.here.HereOauthManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class ByteOrderDataUtil {
    static final int BYTE_127 = 127;
    static final int BYTE_2 = 2;
    static final int BYTE_4 = 4;
    static final int BYTE_8 = 8;

    /* renamed from: a  reason: collision with root package name */
    private static ByteArrayPools.ByteArray2Pool f6078a = new ByteArrayPools.ByteArray2Pool();
    private static ByteArrayPools.ByteArray4Pool b = new ByteArrayPools.ByteArray4Pool();
    private static ByteArrayPools.ByteArray8Pool c = new ByteArrayPools.ByteArray8Pool();
    private static ByteArrayPools.ByteArray127Pool d = new ByteArrayPools.ByteArray127Pool();

    @Deprecated
    public static boolean readBoolean(BufferedInputStream bufferedInputStream) throws IOException {
        return bufferedInputStream.read() > 0;
    }

    @Deprecated
    public static void writeBoolean(BufferedOutputStream bufferedOutputStream, boolean z) throws IOException {
        bufferedOutputStream.write(z ? 1 : 0);
    }

    public static boolean readBoolean2(BufferedInputStream bufferedInputStream) throws IOException {
        return readByte(bufferedInputStream) > 0;
    }

    public static void writeBoolean2(BufferedOutputStream bufferedOutputStream, boolean z) throws IOException {
        writeByte(bufferedOutputStream, z ? (byte) 1 : (byte) 0);
    }

    public static byte readByte(BufferedInputStream bufferedInputStream) throws IOException {
        int read = bufferedInputStream.read();
        if (read != -1) {
            return (byte) read;
        }
        throw new IOException("end of the stream has been reached");
    }

    public static int readBytes(BufferedInputStream bufferedInputStream, byte[] bArr) throws IOException {
        int read = bufferedInputStream.read(bArr);
        if (read != -1) {
            return read;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("end of the stream has been reached, expect length ");
        sb.append(bArr.length);
        sb.append(" but got ");
        sb.append(read);
        throw new IOException(sb.toString());
    }

    public static int readBytes(BufferedInputStream bufferedInputStream, byte[] bArr, int i, int i2) throws IOException {
        int read = bufferedInputStream.read(bArr, i, i2);
        if (read != -1) {
            return read;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("end of the stream has been reached, expect count ");
        sb.append(i2);
        sb.append(" but got ");
        sb.append(read);
        throw new IOException(sb.toString());
    }

    public static void writeByte(BufferedOutputStream bufferedOutputStream, byte b2) throws IOException {
        bufferedOutputStream.write(b2);
    }

    public static short readShort(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] obtain = f6078a.obtain();
        readBytes(bufferedInputStream, obtain);
        short s = ByteOrderValues.getShort(obtain);
        f6078a.free(obtain);
        return s;
    }

    public static void writeShort(BufferedOutputStream bufferedOutputStream, short s) throws IOException {
        byte[] obtain = f6078a.obtain();
        ByteOrderValues.putShort(s, obtain);
        bufferedOutputStream.write(obtain);
        f6078a.free(obtain);
    }

    public static int readInt(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] obtain = b.obtain();
        readBytes(bufferedInputStream, obtain);
        int i = ByteOrderValues.getInt(obtain);
        b.free(obtain);
        return i;
    }

    public static void writeInt(BufferedOutputStream bufferedOutputStream, int i) throws IOException {
        byte[] obtain = b.obtain();
        ByteOrderValues.putInt(i, obtain);
        b.free(obtain);
        bufferedOutputStream.write(obtain);
    }

    public static long readLong(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] obtain = c.obtain();
        readBytes(bufferedInputStream, obtain);
        long j = ByteOrderValues.getLong(obtain);
        c.free(obtain);
        return j;
    }

    public static void writeLong(BufferedOutputStream bufferedOutputStream, long j) throws IOException {
        byte[] obtain = c.obtain();
        ByteOrderValues.putLong(j, obtain);
        bufferedOutputStream.write(obtain);
        c.free(obtain);
    }

    public static float readFloat(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] obtain = b.obtain();
        readBytes(bufferedInputStream, obtain);
        float f = ByteOrderValues.getFloat(obtain);
        b.free(obtain);
        return f;
    }

    public static void writeFloat(BufferedOutputStream bufferedOutputStream, float f) throws IOException {
        byte[] obtain = b.obtain();
        ByteOrderValues.putFloat(f, obtain);
        bufferedOutputStream.write(obtain);
        b.free(obtain);
    }

    public static double readDouble(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] obtain = c.obtain();
        readBytes(bufferedInputStream, obtain);
        double d2 = ByteOrderValues.getDouble(obtain);
        c.free(obtain);
        return d2;
    }

    public static void writeDouble(BufferedOutputStream bufferedOutputStream, double d2) throws IOException {
        byte[] obtain = c.obtain();
        ByteOrderValues.putDouble(d2, obtain);
        bufferedOutputStream.write(obtain);
        c.free(obtain);
    }

    @Deprecated
    public static String readString(BufferedInputStream bufferedInputStream) throws IOException {
        int read = bufferedInputStream.read();
        if (read == 0) {
            return null;
        }
        if (read > BYTE_127) {
            byte[] bArr = new byte[read];
            bufferedInputStream.read(bArr);
            return new String(bArr, HereOauthManager.ENC);
        }
        byte[] obtain = d.obtain();
        bufferedInputStream.read(obtain, 0, read);
        String str = new String(obtain, 0, read, HereOauthManager.ENC);
        d.free(obtain);
        return str;
    }

    @Deprecated
    public static void writeString(BufferedOutputStream bufferedOutputStream, String str) throws IOException {
        if (str == null || str.length() == 0) {
            bufferedOutputStream.write(0);
            return;
        }
        byte[] bytes = str.getBytes();
        bufferedOutputStream.write(bytes.length);
        bufferedOutputStream.write(bytes);
    }

    @Deprecated
    public static String[] readStringArray(BufferedInputStream bufferedInputStream) throws IOException {
        int read = bufferedInputStream.read();
        if (read == 0) {
            return null;
        }
        String[] strArr = new String[read];
        for (int i = 0; i < read; i++) {
            strArr[i] = readString(bufferedInputStream);
        }
        return strArr;
    }

    @Deprecated
    public static void writeStringArray(BufferedOutputStream bufferedOutputStream, String[] strArr) throws IOException {
        if (strArr == null || strArr.length == 0) {
            bufferedOutputStream.write(0);
            return;
        }
        bufferedOutputStream.write(strArr.length);
        for (String str : strArr) {
            writeString(bufferedOutputStream, str);
        }
    }

    @Deprecated
    public static List<String> readStringList(BufferedInputStream bufferedInputStream) throws IOException {
        int read = bufferedInputStream.read();
        if (read <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(read);
        for (int i = 0; i < read; i++) {
            arrayList.add(readString(bufferedInputStream));
        }
        return arrayList;
    }

    @Deprecated
    public static void writeStringList(BufferedOutputStream bufferedOutputStream, List<String> list) throws IOException {
        if (list == null || list.isEmpty()) {
            bufferedOutputStream.write(0);
            return;
        }
        bufferedOutputStream.write(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            writeString(bufferedOutputStream, it.next());
        }
    }

    public static String readString2(BufferedInputStream bufferedInputStream) throws IOException {
        String str;
        int readInt = readInt(bufferedInputStream);
        if (readInt < 0) {
            return null;
        }
        if (readInt == 0) {
            return "";
        }
        if (readInt > BYTE_127) {
            synchronized (ByteOrderDataUtil.class) {
                byte[] bArr = new byte[readInt];
                readBytes(bufferedInputStream, bArr);
                str = new String(bArr, HereOauthManager.ENC);
            }
            return str;
        }
        byte[] obtain = d.obtain();
        readBytes(bufferedInputStream, obtain, 0, readInt);
        String str2 = new String(obtain, 0, readInt, HereOauthManager.ENC);
        d.free(obtain);
        return str2;
    }

    public static void writeString2(BufferedOutputStream bufferedOutputStream, String str) throws IOException {
        if (str == null) {
            writeInt(bufferedOutputStream, -1);
        } else if (str.length() == 0) {
            writeInt(bufferedOutputStream, 0);
        } else {
            byte[] bytes = str.getBytes();
            writeInt(bufferedOutputStream, bytes.length);
            bufferedOutputStream.write(bytes);
        }
    }

    public static String[] readStringArray2(BufferedInputStream bufferedInputStream) throws IOException {
        int readInt = readInt(bufferedInputStream);
        if (readInt < 0) {
            return null;
        }
        if (readInt == 0) {
            return new String[0];
        }
        String[] strArr = new String[readInt];
        for (int i = 0; i < readInt; i++) {
            strArr[i] = readString2(bufferedInputStream);
        }
        return strArr;
    }

    public static void writeStringArray2(BufferedOutputStream bufferedOutputStream, String[] strArr) throws IOException {
        if (strArr == null) {
            writeInt(bufferedOutputStream, -1);
            return;
        }
        if (strArr.length == 0) {
            writeInt(bufferedOutputStream, 0);
            return;
        }
        writeInt(bufferedOutputStream, strArr.length);
        for (String str : strArr) {
            writeString2(bufferedOutputStream, str);
        }
    }

    public static List<String> readStringList2(BufferedInputStream bufferedInputStream) throws IOException {
        int readInt = readInt(bufferedInputStream);
        if (readInt < 0) {
            return null;
        }
        if (readInt == 0) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(readString2(bufferedInputStream));
        }
        return arrayList;
    }

    public static void writeStringList2(BufferedOutputStream bufferedOutputStream, List<String> list) throws IOException {
        if (list == null) {
            writeInt(bufferedOutputStream, -1);
        } else if (list.isEmpty()) {
            writeInt(bufferedOutputStream, 0);
        } else {
            writeInt(bufferedOutputStream, list.size());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                writeString2(bufferedOutputStream, it.next());
            }
        }
    }
}

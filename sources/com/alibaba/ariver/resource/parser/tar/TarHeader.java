package com.alibaba.ariver.resource.parser.tar;

import java.io.File;

/* loaded from: classes6.dex */
public class TarHeader {
    public static final int CHKSUMLEN = 8;
    public static final int GIDLEN = 8;
    public static final byte LF_BLK = 52;
    public static final byte LF_CHR = 51;
    public static final byte LF_CONTIG = 55;
    public static final byte LF_DIR = 53;
    public static final byte LF_FIFO = 54;
    public static final byte LF_LINK = 49;
    public static final byte LF_NORMAL = 48;
    public static final byte LF_OLDNORM = 0;
    public static final byte LF_SYMLINK = 50;
    public static final int MODELEN = 8;
    public static final int MODTIMELEN = 12;
    public static final int NAMELEN = 100;
    public static final int SIZELEN = 12;
    public static final int UIDLEN = 8;
    public static final int USTAR_DEVLEN = 8;
    public static final int USTAR_FILENAME_PREFIX = 155;
    public static final int USTAR_GROUP_NAMELEN = 32;
    public static final String USTAR_MAGIC = "ustar";
    public static final int USTAR_MAGICLEN = 8;
    public static final int USTAR_USER_NAMELEN = 32;
    public int checkSum;
    public int devMajor;
    public int devMinor;
    public int groupId;
    public StringBuffer groupName;
    public byte linkFlag;
    public long modTime;
    public int mode;
    public StringBuffer namePrefix;
    public long size;
    public int userId;
    public StringBuffer userName;
    public StringBuffer magic = new StringBuffer(USTAR_MAGIC);
    public StringBuffer name = new StringBuffer();
    public StringBuffer linkName = new StringBuffer();

    public TarHeader() {
        String property = System.getProperty("user.name", "");
        property = property.length() > 31 ? property.substring(0, 31) : property;
        this.userId = 0;
        this.groupId = 0;
        this.userName = new StringBuffer(property);
        this.groupName = new StringBuffer("");
        this.namePrefix = new StringBuffer();
    }

    public static StringBuffer parseName(byte[] bArr, int i, int i2) {
        byte b;
        StringBuffer stringBuffer = new StringBuffer(i2);
        for (int i3 = i; i3 < i2 + i && (b = bArr[i3]) != 0; i3++) {
            stringBuffer.append((char) b);
        }
        return stringBuffer;
    }

    public static int getNameBytes(StringBuffer stringBuffer, byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2 && i3 < stringBuffer.length()) {
            bArr[i + i3] = (byte) stringBuffer.charAt(i3);
            i3++;
        }
        while (i3 < i2) {
            bArr[i + i3] = 0;
            i3++;
        }
        return i + i2;
    }

    public static TarHeader createHeader(String str, long j, long j2, boolean z) {
        String trim = trim(str.replace(File.separatorChar, '/'), '/');
        TarHeader tarHeader = new TarHeader();
        tarHeader.linkName = new StringBuffer("");
        if (trim.length() > 100) {
            tarHeader.namePrefix = new StringBuffer(trim.substring(0, trim.lastIndexOf(47)));
            tarHeader.name = new StringBuffer(trim.substring(trim.lastIndexOf(47) + 1));
        } else {
            tarHeader.name = new StringBuffer(trim);
        }
        if (z) {
            tarHeader.mode = 40755;
            tarHeader.linkFlag = LF_DIR;
            if (tarHeader.name.charAt(r5.length() - 1) != '/') {
                tarHeader.name.append("/");
            }
            tarHeader.size = 0L;
        } else {
            tarHeader.mode = 100644;
            tarHeader.linkFlag = LF_NORMAL;
            tarHeader.size = j;
        }
        tarHeader.modTime = j2;
        tarHeader.checkSum = 0;
        tarHeader.devMajor = 0;
        tarHeader.devMinor = 0;
        return tarHeader;
    }

    public static String trim(String str, char c) {
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i = 0; i < stringBuffer.length() && stringBuffer.charAt(i) == c; i++) {
            stringBuffer.deleteCharAt(i);
        }
        for (int length = stringBuffer.length() - 1; length >= 0 && stringBuffer.charAt(length) == c; length--) {
            stringBuffer.deleteCharAt(length);
        }
        return stringBuffer.toString();
    }
}

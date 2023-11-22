package com.alibaba.griver.image.framework.utils;

import android.media.ExifInterface;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.image.framework.meta.ImageFileType;
import com.alibaba.griver.image.framework.meta.StaticOptions;
import id.dana.data.constant.BranchLinkConstant;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes6.dex */
public class Exif {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f6586a;

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0062, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0063, code lost:
    
        r2 = r1;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0065, code lost:
    
        if (r3 <= 8) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0067, code lost:
    
        r1 = a(r11, r2, 4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006e, code lost:
    
        if (r1 == 1229531648) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0073, code lost:
    
        if (r1 == 1296891946) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0075, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.e("CameraExif", "Invalid byte order");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007a, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x007b, code lost:
    
        if (r1 == 1229531648) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x007d, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x007e, code lost:
    
        r1 = a(r11, r2 + 4, 4, r5) + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0087, code lost:
    
        if (r1 < 10) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0089, code lost:
    
        if (r1 > r3) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008b, code lost:
    
        r2 = r2 + r1;
        r3 = r3 - r1;
        r1 = a(r11, r2 - 2, 2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
    
        if (r1 <= 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0097, code lost:
    
        if (r3 < 12) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009f, code lost:
    
        if (a(r11, r2, 2, r5) != 274) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a1, code lost:
    
        r11 = a(r11, r2 + 8, 2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a6, code lost:
    
        switch(r11) {
            case 1: goto L61;
            case 2: goto L61;
            case 3: goto L61;
            case 4: goto L61;
            case 5: goto L61;
            case 6: goto L61;
            case 7: goto L61;
            case 8: goto L61;
            default: goto L59;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a9, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.d("CameraExif", "Unsupported rotation");
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ae, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00af, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b0, code lost:
    
        r2 = r2 + 12;
        r3 = r3 - 12;
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b7, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.e("CameraExif", "Invalid offset");
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00bc, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bd, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.w("CameraExif", "Orientation not found");
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c2, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getOrientation(byte[] r11) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.framework.utils.Exif.getOrientation(byte[]):int");
    }

    private static int a(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        int i4 = 0;
        while (i2 > 0) {
            i4 = (i4 << 8) | (bArr[i] & 255);
            i += i3;
            i2--;
        }
        return i4;
    }

    public static int getOrientation(String str) {
        if (FileUtils.checkFile(str)) {
            if (!StaticOptions.useRandomAccessFileExif || !isCanUseRandomAccessFileExif()) {
                return a(str);
            }
            return b(str);
        }
        return 1;
    }

    private static int a(String str) {
        if (ImageFileType.isJPEG(new File(str))) {
            try {
                return new ExifInterface(str).getAttributeInt("Orientation", 1);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("getOrientationByExifInterface error, path: ");
                sb.append(str);
                sb.append(", e: ");
                sb.append(th);
                RVLogger.w("CameraExif", sb.toString());
                return 1;
            }
        }
        return 1;
    }

    private static int b(String str) {
        RandomAccessFile randomAccessFile;
        int i;
        int i2;
        int i3;
        RandomAccessFile randomAccessFile2 = null;
        int i4 = 1;
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, BranchLinkConstant.PayloadKey.REFERRAL);
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    int length = (int) randomAccessFile.length();
                    int i5 = 0;
                    while (i5 + 3 < length) {
                        int i6 = i5 + 1;
                        if ((a(randomAccessFile, i5) & 255) == 255) {
                            int a2 = a(randomAccessFile, i6) & 255;
                            if (a2 != 255) {
                                i6++;
                                if (a2 != 216 && a2 != 1) {
                                    if (a2 != 217 && a2 != 218) {
                                        int a3 = a(randomAccessFile, i6, 2, false);
                                        if (a3 < 2 || (i3 = i6 + a3) > length) {
                                            RVLogger.e("CameraExif", "Invalid length");
                                            IOUtils.closeQuietly(randomAccessFile);
                                            return 0;
                                        }
                                        if (a2 == 225 && a3 >= 8 && a(randomAccessFile, i6 + 2, 4, false) == 1165519206 && a(randomAccessFile, i6 + 6, 2, false) == 0) {
                                            i = i6 + 8;
                                            i2 = a3 - 8;
                                            break;
                                        }
                                        i5 = i3;
                                    }
                                }
                            }
                            i5 = i6;
                        }
                        i5 = i6;
                    }
                    i = i5;
                    i2 = 0;
                    if (i2 > 8) {
                        int a4 = a(randomAccessFile, i, 4, false);
                        if (a4 != 1229531648 && a4 != 1296891946) {
                            RVLogger.e("CameraExif", "Invalid byte order");
                            IOUtils.closeQuietly(randomAccessFile);
                            return 0;
                        }
                        boolean z = a4 == 1229531648;
                        int a5 = a(randomAccessFile, i + 4, 4, z) + 2;
                        if (a5 < 10 || a5 > i2) {
                            RVLogger.e("CameraExif", "Invalid offset");
                            IOUtils.closeQuietly(randomAccessFile);
                            return 0;
                        }
                        int i7 = i + a5;
                        int i8 = i2 - a5;
                        for (int a6 = a(randomAccessFile, i7 - 2, 2, z); a6 > 0 && i8 >= 12; a6--) {
                            if (a(randomAccessFile, i7, 2, z) == 274) {
                                int a7 = a(randomAccessFile, i7 + 8, 2, z);
                                switch (a7) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                        IOUtils.closeQuietly(randomAccessFile);
                                        return a7;
                                    default:
                                        try {
                                            RVLogger.d("CameraExif", "Unsupported rotation");
                                            IOUtils.closeQuietly(randomAccessFile);
                                            return 0;
                                        } catch (Exception e) {
                                            i4 = a7;
                                            e = e;
                                            e = e;
                                            randomAccessFile2 = randomAccessFile;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("parse exif error, path: ");
                                            sb.append(str);
                                            RVLogger.e("CameraExif", sb.toString(), e);
                                            randomAccessFile = randomAccessFile2;
                                            IOUtils.closeQuietly(randomAccessFile);
                                            return i4;
                                        }
                                }
                            }
                            i7 += 12;
                            i8 -= 12;
                        }
                    }
                    RVLogger.d("CameraExif", "Orientation not found");
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                IOUtils.closeQuietly(randomAccessFile2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
        }
        IOUtils.closeQuietly(randomAccessFile);
        return i4;
    }

    private static int a(RandomAccessFile randomAccessFile, int i, int i2, boolean z) throws IOException {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        int i4 = 0;
        while (i2 > 0) {
            i4 = (i4 << 8) | (a(randomAccessFile, i) & 255);
            i += i3;
            i2--;
        }
        return i4;
    }

    private static byte a(RandomAccessFile randomAccessFile, int i) throws IOException {
        randomAccessFile.seek(i);
        return randomAccessFile.readByte();
    }

    public static boolean isCanUseRandomAccessFileExif() {
        if (f6586a == null) {
            f6586a = Boolean.TRUE;
        }
        return f6586a.booleanValue();
    }
}

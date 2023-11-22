package com.alipay.iap.android.aplog.util;

import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

/* loaded from: classes3.dex */
public class FileUtil {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int PlaceComponentResult = 0;
    public static final String TAG = "FileUtil";
    private static int moveToNextValue = 1;
    private static char[] getAuthRequestContext = {39894, 39897, 39911, 39934, 39925};
    private static boolean BuiltInFictitiousFunctionClassFactory = true;
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;
    private static int MyBillsEntityDataFactory = 909155245;

    public static boolean sdCardAvailable() {
        try {
            int i = PlaceComponentResult + 107;
            moveToNextValue = i % 128;
            try {
                if ((i % 2 == 0 ? (char) 3 : 'M') != 'M') {
                    boolean equals = "mounted".equals(Environment.getExternalStorageState());
                    Object[] objArr = null;
                    int length = objArr.length;
                    return equals;
                }
                return "mounted".equals(Environment.getExternalStorageState());
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("isCanUseSdCard: ");
                sb.append(th);
                InstrumentInjector.log_e("FileUtil", sb.toString());
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void writeFile(File file, String str, boolean z) throws IOException {
        int i = moveToNextValue + 119;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            a(127 - TextUtils.getTrimmedLength(""), new byte[]{-123, -124, -125, -126, -127}, null, null, objArr);
            writeFile(file, str.getBytes(((String) objArr[0]).intern()), z);
            int i3 = moveToNextValue + 89;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        if ((!r3.getParentFile().exists() ? '(' : 6) != 6) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void writeFile(java.io.File r3, byte[] r4, boolean r5) throws java.io.IOException {
        /*
            int r0 = com.alipay.iap.android.aplog.util.FileUtil.PlaceComponentResult
            int r0 = r0 + 93
            int r1 = r0 % 128
            com.alipay.iap.android.aplog.util.FileUtil.moveToNextValue = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L24
            java.io.File r0 = r3.getParentFile()     // Catch: java.lang.Throwable -> L58
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L58
            r1.hashCode()     // Catch: java.lang.Throwable -> L58
            r2 = 33
            if (r0 != 0) goto L1f
            r0 = 36
            goto L21
        L1f:
            r0 = 33
        L21:
            if (r0 == r2) goto L46
            goto L35
        L24:
            java.io.File r0 = r3.getParentFile()     // Catch: java.lang.Throwable -> L58
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L58
            r2 = 6
            if (r0 != 0) goto L32
            r0 = 40
            goto L33
        L32:
            r0 = 6
        L33:
            if (r0 == r2) goto L46
        L35:
            java.io.File r0 = r3.getParentFile()     // Catch: java.lang.Throwable -> L58
            r0.mkdirs()     // Catch: java.lang.Throwable -> L58
            int r0 = com.alipay.iap.android.aplog.util.FileUtil.moveToNextValue
            int r0 = r0 + 81
            int r2 = r0 % 128
            com.alipay.iap.android.aplog.util.FileUtil.PlaceComponentResult = r2
            int r0 = r0 % 2
        L46:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L58
            r0.<init>(r3, r5)     // Catch: java.lang.Throwable -> L58
            r0.write(r4)     // Catch: java.lang.Throwable -> L55
            r0.flush()     // Catch: java.lang.Throwable -> L55
            r0.close()     // Catch: java.lang.Throwable -> L54
        L54:
            return
        L55:
            r3 = move-exception
            r1 = r0
            goto L59
        L58:
            r3 = move-exception
        L59:
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Throwable -> L5f
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L5f
            throw r4     // Catch: java.lang.Throwable -> L5f
        L5f:
            r3 = move-exception
            if (r1 == 0) goto L65
            r1.close()     // Catch: java.lang.Throwable -> L65
        L65:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.FileUtil.writeFile(java.io.File, byte[], boolean):void");
    }

    public static String readFile(File file) throws IOException {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            Object[] objArr = new Object[1];
            a(KeyEvent.keyCodeFromString("") + 127, new byte[]{-123, -124, -125, -126, -127}, null, null, objArr);
            String str = new String(bArr, ((String) objArr[0]).intern());
            try {
                fileInputStream.close();
                int i = moveToNextValue + 25;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
            } catch (Throwable unused) {
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            try {
                throw new IOException(th);
            } catch (Throwable th3) {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                        int i3 = moveToNextValue + 111;
                        PlaceComponentResult = i3 % 128;
                        int i4 = i3 % 2;
                    } catch (Throwable unused2) {
                    }
                }
                throw th3;
            }
        }
    }

    public static void deleteFileNotDir(File file) {
        int i = moveToNextValue + 41;
        PlaceComponentResult = i % 128;
        Object[] objArr = null;
        if ((i % 2 != 0 ? 'c' : (char) 6) == 'c') {
            int length = objArr.length;
            if (file == null) {
                return;
            }
        } else if (file == null) {
            return;
        }
        try {
            if (file.exists()) {
                try {
                    int i2 = PlaceComponentResult + 27;
                    try {
                        moveToNextValue = i2 % 128;
                        if (i2 % 2 == 0) {
                            boolean isFile = file.isFile();
                            objArr.hashCode();
                            if ((isFile ? '7' : (char) 20) == 20) {
                                return;
                            }
                        } else {
                            if (file.isFile() ? false : true) {
                                return;
                            }
                        }
                        int i3 = moveToNextValue + 73;
                        PlaceComponentResult = i3 % 128;
                        int i4 = i3 % 2;
                        file.delete();
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("deleteFileNotDir: ");
            sb.append(file.getAbsolutePath());
            InstrumentInjector.log_e("FileUtil", sb.toString(), th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088 A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #1 {all -> 0x009c, blocks: (B:16:0x002a, B:18:0x0030, B:21:0x0035, B:27:0x0043, B:34:0x0058, B:43:0x0073, B:46:0x0083, B:47:0x0088, B:40:0x0068), top: B:60:0x002a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long getFolderSize(java.io.File r13) {
        /*
            r0 = 0
            r1 = 1
            if (r13 == 0) goto L6
            r2 = 1
            goto L7
        L6:
            r2 = 0
        L7:
            r3 = 0
            if (r2 == 0) goto La9
            int r2 = com.alipay.iap.android.aplog.util.FileUtil.PlaceComponentResult
            int r2 = r2 + 105
            int r5 = r2 % 128
            com.alipay.iap.android.aplog.util.FileUtil.moveToNextValue = r5
            int r2 = r2 % 2
            boolean r2 = r13.exists()
            if (r2 == 0) goto La9
            boolean r2 = r13.isDirectory()     // Catch: java.lang.Exception -> La7
            r5 = 26
            if (r2 == 0) goto L26
            r2 = 12
            goto L28
        L26:
            r2 = 26
        L28:
            if (r2 == r5) goto La9
            java.io.File[] r2 = r13.listFiles()     // Catch: java.lang.Throwable -> L9c
            if (r2 == 0) goto L9b
            int r5 = r2.length     // Catch: java.lang.Throwable -> L9c
            if (r5 != 0) goto L35
            goto L9b
        L35:
            int r5 = r2.length     // Catch: java.lang.Throwable -> L9c
            r7 = r3
            r6 = 0
        L38:
            r9 = 89
            if (r6 >= r5) goto L3f
            r10 = 94
            goto L41
        L3f:
            r10 = 89
        L41:
            if (r10 == r9) goto L9a
            r9 = r2[r6]     // Catch: java.lang.Throwable -> L9c
            if (r9 == 0) goto L97
            int r10 = com.alipay.iap.android.aplog.util.FileUtil.moveToNextValue
            int r10 = r10 + 61
            int r11 = r10 % 128
            com.alipay.iap.android.aplog.util.FileUtil.PlaceComponentResult = r11
            int r10 = r10 % 2
            if (r10 == 0) goto L55
            r10 = 1
            goto L56
        L55:
            r10 = 0
        L56:
            if (r10 == r1) goto L68
            boolean r10 = r9.exists()     // Catch: java.lang.Throwable -> L9c
            r11 = 52
            if (r10 != 0) goto L63
            r10 = 20
            goto L65
        L63:
            r10 = 52
        L65:
            if (r10 == r11) goto L73
            goto L97
        L68:
            boolean r10 = r9.exists()     // Catch: java.lang.Throwable -> L9c
            r11 = 0
            r11.hashCode()     // Catch: java.lang.Throwable -> L9c
            if (r10 != 0) goto L73
            goto L97
        L73:
            boolean r10 = r9.isFile()     // Catch: java.lang.Throwable -> L9c
            if (r10 == 0) goto L88
            int r10 = com.alipay.iap.android.aplog.util.FileUtil.PlaceComponentResult
            int r10 = r10 + 29
            int r11 = r10 % 128
            com.alipay.iap.android.aplog.util.FileUtil.moveToNextValue = r11
            int r10 = r10 % 2
            long r9 = r9.length()     // Catch: java.lang.Throwable -> L9c
            goto L96
        L88:
            long r9 = getFolderSize(r9)     // Catch: java.lang.Throwable -> L9c
            int r11 = com.alipay.iap.android.aplog.util.FileUtil.moveToNextValue
            int r11 = r11 + 3
            int r12 = r11 % 128
            com.alipay.iap.android.aplog.util.FileUtil.PlaceComponentResult = r12
            int r11 = r11 % 2
        L96:
            long r7 = r7 + r9
        L97:
            int r6 = r6 + 1
            goto L38
        L9a:
            return r7
        L9b:
            return r3
        L9c:
            r0 = move-exception
            java.lang.String r13 = r13.getAbsolutePath()
            java.lang.String r1 = "FileUtil"
            com.fullstory.instrumentation.InstrumentInjector.log_w(r1, r13, r0)
            goto La9
        La7:
            r13 = move-exception
            throw r13
        La9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.FileUtil.getFolderSize(java.io.File):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
    
        if (r2 != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void moveFile(java.io.File r2, java.io.File r3) throws java.io.IOException {
        /*
            boolean r0 = r2.renameTo(r3)     // Catch: java.lang.Throwable -> L6c
            r1 = 23
            if (r0 != 0) goto La
            r0 = 7
            goto Lc
        La:
            r0 = 23
        Lc:
            if (r0 == r1) goto L1e
            copyFile(r2, r3)     // Catch: java.lang.Throwable -> L6c
            r2.delete()     // Catch: java.lang.Throwable -> L6c
            int r0 = com.alipay.iap.android.aplog.util.FileUtil.moveToNextValue
            int r0 = r0 + 117
            int r1 = r0 % 128
            com.alipay.iap.android.aplog.util.FileUtil.PlaceComponentResult = r1
            int r0 = r0 % 2
        L1e:
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> L6c
            r0 = 94
            if (r2 != 0) goto L29
            r2 = 94
            goto L2b
        L29:
            r2 = 83
        L2b:
            if (r2 != r0) goto L64
            int r2 = com.alipay.iap.android.aplog.util.FileUtil.moveToNextValue     // Catch: java.lang.Exception -> L62
            int r2 = r2 + 39
            int r0 = r2 % 128
            com.alipay.iap.android.aplog.util.FileUtil.PlaceComponentResult = r0     // Catch: java.lang.Exception -> L62
            int r2 = r2 % 2
            r0 = 0
            if (r2 == 0) goto L3c
            r2 = 0
            goto L3d
        L3c:
            r2 = 1
        L3d:
            if (r2 == 0) goto L46
            boolean r2 = r3.exists()     // Catch: java.lang.Throwable -> L6c
            if (r2 == 0) goto L64
            goto L4e
        L46:
            boolean r2 = r3.exists()     // Catch: java.lang.Throwable -> L6c
            r3 = 2
            int r3 = r3 / r0
            if (r2 == 0) goto L64
        L4e:
            int r2 = com.alipay.iap.android.aplog.util.FileUtil.PlaceComponentResult
            int r2 = r2 + 61
            int r3 = r2 % 128
            com.alipay.iap.android.aplog.util.FileUtil.moveToNextValue = r3
            int r2 = r2 % 2
            if (r2 != 0) goto L61
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L5f
            return
        L5f:
            r2 = move-exception
            throw r2
        L61:
            return
        L62:
            r2 = move-exception
            throw r2
        L64:
            java.lang.Exception r2 = new java.lang.Exception     // Catch: java.lang.Throwable -> L6c
            java.lang.String r3 = "move file fail"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L6c
            throw r2     // Catch: java.lang.Throwable -> L6c
        L6c:
            r2 = move-exception
            java.io.IOException r3 = new java.io.IOException
            r3.<init>(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.FileUtil.moveFile(java.io.File, java.io.File):void");
    }

    public static void copyFile(File file, File file2) throws IOException {
        Throwable th;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        FileChannel fileChannel3 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileChannel = fileInputStream.getChannel();
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
            fileChannel2 = null;
            fileOutputStream = null;
        }
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                fileChannel3 = fileOutputStream.getChannel();
                fileChannel.transferTo(0L, fileChannel.size(), fileChannel3);
                if ((file2.exists() ? (char) 11 : 'c') != 11) {
                    throw new RuntimeException("copy file fail");
                }
                int i = moveToNextValue + 45;
                PlaceComponentResult = i % 128;
                try {
                    if ((i % 2 != 0 ? 'A' : (char) 3) != 'A') {
                        fileInputStream.close();
                    } else {
                        fileInputStream.close();
                        int i2 = 19 / 0;
                    }
                } catch (Throwable unused) {
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (Throwable unused2) {
                    }
                }
                try {
                    fileOutputStream.close();
                } catch (Throwable unused3) {
                }
                if (fileChannel3 != null) {
                    int i3 = moveToNextValue + 15;
                    PlaceComponentResult = i3 % 128;
                    int i4 = i3 % 2;
                    try {
                        fileChannel3.close();
                        int i5 = moveToNextValue + 87;
                        PlaceComponentResult = i5 % 128;
                        int i6 = i5 % 2;
                    } catch (Throwable unused4) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                fileChannel2 = fileChannel3;
                fileInputStream2 = fileInputStream;
                try {
                    throw new IOException(th);
                } finally {
                }
            }
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            fileInputStream2 = fileInputStream;
            fileChannel2 = null;
            throw new IOException(th);
        }
    }

    public static boolean writeEncryptedContent(byte[] bArr, byte[] bArr2, File file) {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            if ((!file.getParentFile().exists() ? (char) 30 : (char) 31) == 30) {
                int i = moveToNextValue + 121;
                PlaceComponentResult = i % 128;
                if (i % 2 != 0) {
                    file.getParentFile().mkdirs();
                    int i2 = 44 / 0;
                } else {
                    file.getParentFile().mkdirs();
                }
            }
            fileOutputStream = new FileOutputStream(file, true);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    dataOutputStream = new DataOutputStream(bufferedOutputStream);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                bufferedOutputStream = null;
            }
        } catch (Throwable unused3) {
            bufferedOutputStream = null;
            fileOutputStream = null;
        }
        try {
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.writeShort((short) bArr2.length);
            dataOutputStream.write(bArr2);
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
            safeClose(dataOutputStream);
            safeClose(bufferedOutputStream);
            safeClose(fileOutputStream);
            int i3 = moveToNextValue + 13;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 24 / 0;
                return true;
            }
            return true;
        } catch (Throwable unused4) {
            dataOutputStream2 = dataOutputStream;
            safeClose(dataOutputStream2);
            safeClose(bufferedOutputStream);
            safeClose(fileOutputStream);
            return false;
        }
    }

    public static void safeClose(Closeable closeable) {
        if ((closeable != null ? '\r' : '?') != '?') {
            int i = PlaceComponentResult + 77;
            moveToNextValue = i % 128;
            int i2 = i % 2;
            try {
                closeable.close();
                try {
                    int i3 = moveToNextValue + 67;
                    PlaceComponentResult = i3 % 128;
                    if ((i3 % 2 != 0 ? '_' : '=') != '_') {
                        return;
                    }
                    Object[] objArr = null;
                    int length = objArr.length;
                } catch (Exception e) {
                    throw e;
                }
            } catch (IOException e2) {
                LoggerFactory.getInnerTraceLogger().error("FileUtil", e2.getMessage());
            }
        }
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int length;
        char[] cArr2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        try {
            char[] cArr3 = getAuthRequestContext;
            if ((cArr3 != null ? 'X' : '\f') != '\f') {
                int i2 = $10 + 17;
                $11 = i2 % 128;
                if (i2 % 2 == 0) {
                    length = cArr3.length;
                    cArr2 = new char[length];
                } else {
                    length = cArr3.length;
                    cArr2 = new char[length];
                }
                int i3 = 0;
                while (true) {
                    if ((i3 < length ? '\t' : '0') != '\t') {
                        break;
                    }
                    int i4 = $11 + 125;
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                    cArr2[i3] = (char) (cArr3[i3] ^ 4571606982258105150L);
                    i3++;
                }
                cArr3 = cArr2;
            }
            try {
                int i6 = (int) (MyBillsEntityDataFactory ^ 4571606982258105150L);
                if (KClassImpl$Data$declaredNonStaticMembers$2) {
                    int i7 = $10 + 29;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                    char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i6);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    }
                    objArr[0] = new String(cArr4);
                    return;
                }
                if ((BuiltInFictitiousFunctionClassFactory ? '.' : 'H') != '.') {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                    char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        int i9 = $11 + 85;
                        $10 = i9 % 128;
                        int i10 = i9 % 2;
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    }
                    objArr[0] = new String(cArr5);
                    return;
                }
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? '^' : 'X') != '^') {
                        objArr[0] = new String(cArr6);
                        return;
                    } else {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}

package com.alipay.mobile.security.bio.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.text.AndroidCharacter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alipay.mobile.security.bio.exception.BioIllegalArgumentException;
import id.dana.cashier.view.InputCardNumberView;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.util.Scanner;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes2.dex */
public class FileUtil {
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    public static final int STREAM_BUFFER_SIZE = 8192;
    private static int getAuthRequestContext;

    public static byte[] toByteArray(String str) throws IOException {
        BufferedInputStream bufferedInputStream;
        byte[] byteArray;
        synchronized (FileUtil.class) {
            File file = new File(str);
            if (!file.exists()) {
                throw new FileNotFoundException(str);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = bufferedInputStream.read(bArr, 0, 1024);
                            if (-1 != read) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                byteArray = byteArrayOutputStream.toByteArray();
                                InputStreamUtils.close(bufferedInputStream);
                                OutputStreamUtils.close(byteArrayOutputStream);
                            }
                        }
                    } catch (IOException e) {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        InputStreamUtils.close(bufferedInputStream);
                        OutputStreamUtils.close(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    throw e2;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        }
        return byteArray;
    }

    public static byte[] bitmapToByteArray(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        try {
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void bitmap2File(Bitmap bitmap, File file) {
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException | IOException unused) {
        }
    }

    public static byte[] getAssetsData(Context context, String str) {
        Throwable th;
        InputStream inputStream;
        int i;
        InputStream inputStream2 = null;
        byte[] bArr = null;
        try {
            try {
                Object[] objArr = {context.getAssets(), str};
                Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                if (obj == null) {
                    obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 58132), ExpandableListView.getPackedPositionType(0L), AndroidCharacter.getMirror('0') + 1)).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                }
                inputStream = (InputStream) ((Method) obj).invoke(null, objArr);
                try {
                    bArr = InputStreamUtils.input2byte(inputStream);
                    i = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
                    getAuthRequestContext = i % 128;
                } catch (IOException unused) {
                    i = getAuthRequestContext + 47;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    int i2 = i % 2;
                    InputStreamUtils.close(inputStream);
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    InputStreamUtils.close(inputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable cause = th3.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th3;
            }
        } catch (IOException unused2) {
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
        }
        int i22 = i % 2;
        InputStreamUtils.close(inputStream);
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] getAssetsData(android.content.res.Resources r8, java.lang.String r9) {
        /*
            r0 = 2
            r1 = 0
            android.content.res.AssetManager r8 = r8.getAssets()     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7d
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L6e
            r3 = 1
            r2[r3] = r9     // Catch: java.lang.Throwable -> L6e
            r9 = 0
            r2[r9] = r8     // Catch: java.lang.Throwable -> L6e
            java.util.Map<java.lang.Integer, java.lang.Object> r8 = o.NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested     // Catch: java.lang.Throwable -> L6e
            r4 = -906490705(0xffffffffc9f80caf, float:-2032021.9)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r8 = r8.get(r5)     // Catch: java.lang.Throwable -> L6e
            if (r8 == 0) goto L1e
            goto L55
        L1e:
            r8 = 58133(0xe315, float:8.1462E-41)
            float r5 = android.media.AudioTrack.getMinVolume()     // Catch: java.lang.Throwable -> L6e
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            int r8 = r8 - r5
            char r8 = (char) r8     // Catch: java.lang.Throwable -> L6e
            int r5 = android.view.ViewConfiguration.getMaximumDrawingCacheSize()     // Catch: java.lang.Throwable -> L6e
            int r5 = r5 >> 24
            int r6 = android.view.KeyEvent.normalizeMetaState(r9)     // Catch: java.lang.Throwable -> L6e
            int r6 = 49 - r6
            java.lang.Object r8 = o.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult(r8, r5, r6)     // Catch: java.lang.Throwable -> L6e
            java.lang.Class r8 = (java.lang.Class) r8     // Catch: java.lang.Throwable -> L6e
            java.lang.String r5 = "getAuthRequestContext"
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch: java.lang.Throwable -> L6e
            java.lang.Class<android.content.res.AssetManager> r7 = android.content.res.AssetManager.class
            r6[r9] = r7     // Catch: java.lang.Throwable -> L6e
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r6[r3] = r9     // Catch: java.lang.Throwable -> L6e
            java.lang.reflect.Method r8 = r8.getMethod(r5, r6)     // Catch: java.lang.Throwable -> L6e
            java.util.Map<java.lang.Integer, java.lang.Object> r9 = o.NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested     // Catch: java.lang.Throwable -> L6e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L6e
            r9.put(r3, r8)     // Catch: java.lang.Throwable -> L6e
        L55:
            java.lang.reflect.Method r8 = (java.lang.reflect.Method) r8     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r8 = r8.invoke(r1, r2)     // Catch: java.lang.Throwable -> L6e
            java.io.InputStream r8 = (java.io.InputStream) r8     // Catch: java.lang.Throwable -> L6e
            byte[] r9 = com.alipay.mobile.security.bio.utils.InputStreamUtils.input2byte(r8)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L7e
            int r2 = com.alipay.mobile.security.bio.utils.FileUtil.getAuthRequestContext
            int r2 = r2 + 5
            int r3 = r2 % 128
            com.alipay.mobile.security.bio.utils.FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r2 = r2 % r0
            goto L7f
        L6b:
            r9 = move-exception
            r1 = r8
            goto L79
        L6e:
            r8 = move-exception
            java.lang.Throwable r9 = r8.getCause()     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7d
            if (r9 == 0) goto L76
            throw r9     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7d
        L76:
            throw r8     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7d
        L77:
            r8 = move-exception
            r9 = r8
        L79:
            com.alipay.mobile.security.bio.utils.InputStreamUtils.close(r1)
            throw r9
        L7d:
            r8 = r1
        L7e:
            r9 = r1
        L7f:
            com.alipay.mobile.security.bio.utils.InputStreamUtils.close(r8)
            int r8 = com.alipay.mobile.security.bio.utils.FileUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 + 45
            int r2 = r8 % 128
            com.alipay.mobile.security.bio.utils.FileUtil.getAuthRequestContext = r2
            int r8 = r8 % r0
            r0 = 35
            if (r8 == 0) goto L91
            r8 = 6
            goto L93
        L91:
            r8 = 35
        L93:
            if (r8 == r0) goto L9b
            r1.hashCode()     // Catch: java.lang.Throwable -> L99
            return r9
        L99:
            r8 = move-exception
            throw r8
        L9b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.security.bio.utils.FileUtil.getAssetsData(android.content.res.Resources, java.lang.String):byte[]");
    }

    public static byte[] getRawData(Context context, int i) {
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2 = null;
        r0 = null;
        byte[] bArr = null;
        try {
            inputStream = context.getResources().openRawResource(i);
            try {
                bArr = InputStreamUtils.input2byte(inputStream);
            } catch (IOException unused) {
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                InputStreamUtils.close(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
        }
        InputStreamUtils.close(inputStream);
        return bArr;
    }

    public static boolean save(File file, byte[] bArr) {
        boolean z;
        Throwable th;
        FileOutputStream fileOutputStream;
        synchronized (FileUtil.class) {
            z = false;
            if (file != null && bArr != null) {
                if (file.exists()) {
                    file.delete();
                } else {
                    try {
                        file.createNewFile();
                    } catch (IOException unused) {
                    }
                }
                BufferedOutputStream bufferedOutputStream = null;
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                        try {
                            bufferedOutputStream2.write(bArr);
                            bufferedOutputStream2.flush();
                            OutputStreamUtils.close(bufferedOutputStream2);
                            z = true;
                        } catch (IOException unused2) {
                            bufferedOutputStream = bufferedOutputStream2;
                            OutputStreamUtils.close(bufferedOutputStream);
                            OutputStreamUtils.close(fileOutputStream);
                            return z;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedOutputStream = bufferedOutputStream2;
                            OutputStreamUtils.close(bufferedOutputStream);
                            OutputStreamUtils.close(fileOutputStream);
                            throw th;
                        }
                    } catch (IOException unused3) {
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException unused4) {
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
                OutputStreamUtils.close(fileOutputStream);
            }
        }
        return z;
    }

    public static void saveContent(File file, String str, boolean z) {
        BufferedWriter bufferedWriter;
        synchronized (FileUtil.class) {
            if (file == null && str == null) {
                throw new BioIllegalArgumentException();
            }
            if (!file.exists()) {
                try {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                } catch (IOException unused) {
                }
            }
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, z)));
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    bufferedWriter.write(str);
                    bufferedWriter.close();
                } catch (Exception unused3) {
                    bufferedWriter2 = bufferedWriter;
                    if (bufferedWriter2 != null) {
                        bufferedWriter2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter2 = bufferedWriter;
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused5) {
            }
        }
    }

    public static void recursionDeleteFile(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                return;
            }
            for (File file2 : listFiles) {
                recursionDeleteFile(file2);
            }
            file.delete();
        }
    }

    public static void copyDirectory(String str, String str2) throws IOException {
        File file = new File(str);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(File.separator);
                sb.append(listFiles[i].getName());
                String obj = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(File.separator);
                sb2.append(listFiles[i].getName());
                String obj2 = sb2.toString();
                File file2 = new File(str2);
                if (!file2.exists()) {
                    file2.mkdir();
                }
                copyDirectory(obj, obj2);
            }
        } else if (file.isFile()) {
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(str)));
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(str2)));
            byte[] bArr = new byte[524288];
            while (dataInputStream.read(bArr) != -1) {
                dataOutputStream.write(bArr);
            }
            dataInputStream.close();
            dataOutputStream.close();
        }
    }

    public static File extractAssets(Context context, String str) {
        AssetManager assets = context.getAssets();
        File file = new File(context.getFilesDir().getAbsolutePath());
        file.mkdirs();
        File file2 = new File(file, str);
        Object obj = null;
        try {
            if (assets.list(str) != null) {
                try {
                    Object[] objArr = {assets, str};
                    Object obj2 = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                    if (obj2 == null) {
                        obj2 = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 58133), View.getDefaultSize(0, 0), (ViewConfiguration.getWindowTouchSlop() >> 8) + 49)).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                        NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj2);
                    }
                    streamToStream((InputStream) ((Method) obj2).invoke(null, objArr), new FileOutputStream(file2));
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
        } catch (IOException unused) {
        }
        try {
            int i = getAuthRequestContext + 7;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 == 0 ? InputCardNumberView.DIVIDER : 'b') != 'b') {
                obj.hashCode();
                return file2;
            }
            return file2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static boolean streamToStream(InputStream inputStream, OutputStream outputStream) {
        boolean z = false;
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            outputStream.flush();
            z = true;
        } catch (Exception unused) {
        } catch (Throwable th) {
            closeSafely(outputStream);
            closeSafely(inputStream);
            throw th;
        }
        closeSafely(outputStream);
        closeSafely(inputStream);
        return z;
    }

    public static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static String assetsToString(Context context, String str) {
        try {
            try {
                Object[] objArr = {context.getAssets(), str};
                Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                if (obj == null) {
                    obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58133 - Gravity.getAbsoluteGravity(0, 0)), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 49 - Color.alpha(0))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                }
                Scanner useDelimiter = new Scanner((InputStream) ((Method) obj).invoke(null, objArr)).useDelimiter("\\A");
                if ((useDelimiter.hasNext() ? '0' : 'b') != 'b') {
                    try {
                        int i = getAuthRequestContext + 91;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                        int i2 = i % 2;
                        String next = useDelimiter.next();
                        int i3 = getAuthRequestContext + 91;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                        int i4 = i3 % 2;
                        return next;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                return "";
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (IOException unused) {
            return null;
        }
    }
}

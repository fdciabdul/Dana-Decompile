package com.alibaba.ariver.kernel.common.utils;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.io.ByteArrayPool;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes2.dex */
public class IOUtils {
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    public static final int MAP_FILE_THRESHOLD_MIN = 65536;
    public static final int MAP_FILE_THRESHOOLD_MAX = 5242880;
    private static int MyBillsEntityDataFactory;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {112, 117, 112, -122, 12, -13, 0, -33, 37, 9, -13, -2, 17, -50, TarHeader.LF_CHR, -15, 0, -1, 13};
    public static final int PlaceComponentResult = 148;

    /* renamed from: a  reason: collision with root package name */
    private static final ByteArrayPool f6161a = new ByteArrayPool(20480);

    public static ByteArrayPool getByteArrayPool() {
        return f6161a;
    }

    public static byte[] getBuf(int i) {
        return getByteArrayPool().getBuf(i);
    }

    public static void returnBuf(byte[] bArr) {
        getByteArrayPool().returnBuf(bArr);
    }

    public static boolean isNIOEnabled() {
        return "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_nebulaUseNIO", "yes"));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038 A[Catch: all -> 0x005b, TryCatch #0 {all -> 0x005b, blocks: (B:4:0x0003, B:8:0x0031, B:10:0x0038, B:12:0x004d), top: B:18:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004d A[Catch: all -> 0x005b, TRY_LEAVE, TryCatch #0 {all -> 0x005b, blocks: (B:4:0x0003, B:8:0x0031, B:10:0x0038, B:12:0x004d), top: B:18:0x0003 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x004f -> B:14:0x0054). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void freeMappedBuffer(java.nio.MappedByteBuffer r13) {
        /*
            if (r13 != 0) goto L3
            return
        L3:
            java.lang.String r0 = "java.nio.NioUtils"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L5b
            r1 = 1
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L5b
            java.lang.Class<java.nio.ByteBuffer> r3 = java.nio.ByteBuffer.class
            r4 = 0
            r2[r4] = r3     // Catch: java.lang.Throwable -> L5b
            byte[] r3 = com.alibaba.ariver.kernel.common.utils.IOUtils.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L5b
            r5 = 6
            r3 = r3[r5]     // Catch: java.lang.Throwable -> L5b
            byte r3 = (byte) r3     // Catch: java.lang.Throwable -> L5b
            byte r5 = (byte) r3     // Catch: java.lang.Throwable -> L5b
            byte r6 = (byte) r5     // Catch: java.lang.Throwable -> L5b
            int r6 = r6 * 2
            int r6 = 16 - r6
            byte[] r7 = com.alibaba.ariver.kernel.common.utils.IOUtils.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L5b
            int r5 = r5 * 4
            int r5 = 4 - r5
            int r3 = r3 * 2
            int r3 = 102 - r3
            byte[] r8 = new byte[r6]     // Catch: java.lang.Throwable -> L5b
            if (r7 != 0) goto L30
            r9 = r8
            r10 = 0
            r8 = r7
            r7 = r6
            goto L54
        L30:
            r9 = 0
        L31:
            int r10 = r9 + 1
            byte r11 = (byte) r3     // Catch: java.lang.Throwable -> L5b
            r8[r9] = r11     // Catch: java.lang.Throwable -> L5b
            if (r10 != r6) goto L4d
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Throwable -> L5b
            r3.<init>(r8, r4)     // Catch: java.lang.Throwable -> L5b
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r3, r2)     // Catch: java.lang.Throwable -> L5b
            r0.setAccessible(r1)     // Catch: java.lang.Throwable -> L5b
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5b
            r1[r4] = r13     // Catch: java.lang.Throwable -> L5b
            r13 = 0
            r0.invoke(r13, r1)     // Catch: java.lang.Throwable -> L5b
            return
        L4d:
            r9 = r7[r5]     // Catch: java.lang.Throwable -> L5b
            r12 = r7
            r7 = r6
            r6 = r9
            r9 = r8
            r8 = r12
        L54:
            int r5 = r5 + r1
            int r3 = r3 + r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            goto L31
        L5b:
            r13 = move-exception
            java.lang.String r0 = "AriverKernel"
            java.lang.String r1 = "freeMappedBuffer Exception!"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r0, r1, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.IOUtils.freeMappedBuffer(java.nio.MappedByteBuffer):void");
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                RVLogger.e("close stream exception", e);
            }
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        copy(inputStream, outputStream, 4096);
    }

    public static void copy(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] buf = getBuf(i);
        while (true) {
            int read = inputStream.read(buf);
            if (-1 == read) {
                return;
            }
            outputStream.write(buf, 0, read);
        }
    }

    public static byte[] readToByte(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, 2048);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            } catch (Exception e) {
                RVLogger.e("read exception", e);
                return null;
            } finally {
                closeQuietly(inputStream);
            }
        }
    }

    public static String read(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return new String(readToByte(inputStream));
    }

    public static String read(String str) {
        try {
            return read(new FileInputStream(str));
        } catch (Exception e) {
            RVLogger.e("read exception", e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r11v25, types: [int] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v2 */
    public static String readAsset(Resources resources, String str) {
        IOException e;
        String read;
        try {
            int i = MyBillsEntityDataFactory + 79;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            ?? r7 = 0;
            try {
                try {
                    try {
                        if (!(i % 2 != 0)) {
                            try {
                                Object[] objArr = {resources.getAssets(), str};
                                Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                                if (obj == null) {
                                    obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 58133), ViewConfiguration.getScrollBarFadeDuration() >> 16, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 49)).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                                }
                                InputStream inputStream = (InputStream) ((Method) obj).invoke(null, objArr);
                                read = read(inputStream);
                                closeQuietly(inputStream);
                                int length = r7.length;
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause != null) {
                                    throw cause;
                                }
                                throw th;
                            }
                        } else {
                            try {
                                Object[] objArr2 = {resources.getAssets(), str};
                                Object obj2 = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                                if (obj2 == null) {
                                    obj2 = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 58133), View.MeasureSpec.getSize(0), 49 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj2);
                                }
                                InputStream inputStream2 = (InputStream) ((Method) obj2).invoke(null, objArr2);
                                read = read(inputStream2);
                                closeQuietly(inputStream2);
                            } catch (Throwable th2) {
                                Throwable cause2 = th2.getCause();
                                if (cause2 != null) {
                                    throw cause2;
                                }
                                throw th2;
                            }
                        }
                        int i2 = MyBillsEntityDataFactory + 115;
                        BuiltInFictitiousFunctionClassFactory = i2 % 128;
                        resources = i2 % 2;
                        if ((resources == 0 ? ':' : (char) 21) != 21) {
                            int i3 = 18 / 0;
                            return read;
                        }
                        return read;
                    } catch (IOException e2) {
                        e = e2;
                        resources = 0;
                        RVLogger.e("read asset exception", e);
                        closeQuietly(resources);
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        closeQuietly(r7);
                        throw th;
                    }
                } catch (Throwable th4) {
                    r7 = resources;
                    th = th4;
                    closeQuietly(r7);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                RVLogger.e("read asset exception", e);
                closeQuietly(resources);
                return null;
            }
        } catch (Exception e4) {
            throw e4;
        }
    }

    public static void write(String str, String str2, boolean z) throws IOException {
        Throwable th;
        BufferedWriter bufferedWriter;
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException unused) {
            }
        }
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, z)));
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = null;
        }
        try {
            bufferedWriter.write(str2);
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }
}

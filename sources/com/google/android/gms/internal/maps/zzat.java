package com.google.android.gms.internal.maps;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.google.common.base.Ascii;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* loaded from: classes7.dex */
public final class zzat {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {104, -1, -63, 36, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int PlaceComponentResult = BlobStatic.MONITOR_IMAGE_WIDTH;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = 106 - r8
            int r6 = r6 * 4
            int r6 = 16 - r6
            int r7 = r7 * 15
            int r7 = 18 - r7
            byte[] r0 = com.google.android.gms.internal.maps.zzat.KClassImpl$Data$declaredNonStaticMembers$2
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r4 = r8
            r3 = 0
            r8 = r7
            r7 = r6
            goto L30
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r7 = r7 + 1
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.maps.zzat.a(int, byte, int, java.lang.Object[]):void");
    }

    public static String zza(@CheckForNull String str, @CheckForNull Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String str2;
        int i = 0;
        int i2 = 0;
        while (true) {
            length = objArr.length;
            if (i2 >= length) {
                break;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e) {
                    String name = obj.getClass().getName();
                    try {
                        Object[] objArr2 = {obj};
                        byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                        byte b2 = b;
                        Object[] objArr3 = new Object[1];
                        a(b, b2, b2, objArr3);
                        Class<?> cls = Class.forName((String) objArr3[0]);
                        byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                        byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                        Object[] objArr4 = new Object[1];
                        a(b3, b4, b4, objArr4);
                        String str3 = name + AUScreenAdaptTool.PREFIX_ID + Integer.toHexString(((Integer) cls.getMethod((String) objArr4[0], Object.class).invoke(null, objArr2)).intValue());
                        Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str3), (Throwable) e);
                        str2 = SimpleComparison.LESS_THAN_OPERATION + str3 + " threw " + e.getClass().getName() + SimpleComparison.GREATER_THAN_OPERATION;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                }
            }
            objArr[i2] = str2;
            i2++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i3 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (indexOf = str.indexOf("%s", i3)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i3, indexOf);
            sb.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb.append((CharSequence) str, i3, str.length());
        if (i < length2) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}

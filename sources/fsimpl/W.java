package fsimpl;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.FS;
import com.fullstory.util.Log;
import com.google.common.base.Ascii;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class W extends U {

    /* renamed from: a  reason: collision with root package name */
    private final Set f7815a;
    public static final byte[] MyBillsEntityDataFactory = {44, -51, -23, -10, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 149;

    private W() {
        this.f7815a = new HashSet();
    }

    private void a(Object obj, C0248az c0248az, Y y, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[5];
        try {
            Object[] objArr2 = {obj};
            Object[] objArr3 = new Object[1];
            c((byte) (MyBillsEntityDataFactory[5] - 1), MyBillsEntityDataFactory[5], (byte) (MyBillsEntityDataFactory[8] + 1), objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            byte b = (byte) (MyBillsEntityDataFactory[5] - 1);
            Object[] objArr4 = new Object[1];
            c(b, b, (byte) (-MyBillsEntityDataFactory[5]), objArr4);
            objArr[0] = Integer.valueOf(((Integer) cls.getMethod((String) objArr4[0], Object.class).invoke(null, objArr2)).intValue());
            objArr[1] = c0248az;
            objArr[2] = y;
            objArr[3] = str;
            objArr[4] = str2;
            String format = String.format(locale, "%d\t%s\t%s\t%s\t%s", objArr);
            if (a(format)) {
                Log.logAlways(format);
                FS.log(FS.LogLevel.INFO, format);
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private boolean a(String str) {
        return this.f7815a.add(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 + 4
            int r7 = r7 * 2
            int r7 = r7 + 16
            byte[] r0 = fsimpl.W.MyBillsEntityDataFactory
            int r8 = r8 + 105
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L16
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L35
        L16:
            r3 = 0
            r6 = r9
            r9 = r8
        L19:
            r8 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            int r8 = r8 + 1
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r7 = -r7
            int r10 = r10 + r7
            int r7 = r10 + 2
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r8
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.W.c(byte, short, int, java.lang.Object[]):void");
    }

    @Override // fsimpl.U
    void a(Object obj, C0248az c0248az, Y y, C0304da c0304da) {
        a(obj, c0248az, y, "match", c0304da.a());
    }

    @Override // fsimpl.U
    void a(Object obj, C0248az c0248az, Y y, Object obj2) {
        int i = 0;
        if (obj2 != null) {
            try {
                Object[] objArr = {obj2};
                Object[] objArr2 = new Object[1];
                c((byte) (MyBillsEntityDataFactory[5] - 1), MyBillsEntityDataFactory[5], (byte) (MyBillsEntityDataFactory[8] + 1), objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b = (byte) (MyBillsEntityDataFactory[5] - 1);
                Object[] objArr3 = new Object[1];
                c(b, b, (byte) (-MyBillsEntityDataFactory[5]), objArr3);
                i = ((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        a(obj, c0248az, y, "inherited", Integer.toString(i));
    }

    @Override // fsimpl.U
    void a(Object obj, C0248az c0248az, Y y, String str) {
        a(obj, c0248az, y, str, null);
    }

    @Override // fsimpl.U
    void a(Object obj, C0248az c0248az, C0370t c0370t, C0304da c0304da) {
        a(obj, c0248az, U.a(c0370t), c0304da);
    }

    @Override // fsimpl.U
    void a(Object obj, C0248az c0248az, C0370t c0370t, Object obj2) {
        a(obj, c0248az, U.a(c0370t), obj2);
    }

    @Override // fsimpl.U
    void a(Object obj, C0248az c0248az, C0370t c0370t, String str) {
        a(obj, c0248az, U.a(c0370t), str);
    }
}

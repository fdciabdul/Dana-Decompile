package fsimpl;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.util.Log;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dA implements Comparable, Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0320dr f7910a;
    private C0324dv b;
    public static final byte[] MyBillsEntityDataFactory = {42, -75, 2, Ascii.US, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 67;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dA(C0320dr c0320dr, C0324dv c0324dv) {
        this.f7910a = c0320dr;
        this.b = c0324dv;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r8 = r8 * 7
            int r8 = 106 - r8
            int r9 = r9 * 12
            int r9 = 16 - r9
            byte[] r0 = fsimpl.dA.MyBillsEntityDataFactory
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L38
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r4 = r0[r9]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L38:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + 2
            int r9 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.dA.c(byte, short, short, java.lang.Object[]):void");
    }

    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    public int compareTo(dA dAVar) {
        if (dAVar != null) {
            return this.b.compareTo(dAVar.b);
        }
        throw new IllegalArgumentException("Null comparable");
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        AtomicLong atomicLong;
        try {
            this.f7910a.a(new dB(this));
            this.f7910a.a(this.b.f, (IOException) null);
            atomicLong = this.f7910a.c;
            atomicLong.addAndGet(this.b.h);
            StringBuilder sb = new StringBuilder();
            sb.append("Successfully uploaded ");
            sb.append(this.b.h);
            sb.append(" bytes to ");
            sb.append(this.b.j);
            Log.i(sb.toString());
            this.b.f7948a.d.remove(this.b);
            this.b.a();
        } catch (IOException e) {
            this.f7910a.a(this.b.f, e);
            th = e;
            str = "I/O error while uploading file, not retrying";
            Log.e(str, th);
        } catch (Throwable th) {
            th = th;
            if (!(th.getCause() instanceof InterruptedException)) {
                str = "Unexpected error while uploading file, not retrying";
                Log.e(str, th);
            }
            try {
                byte b = (byte) (MyBillsEntityDataFactory[15] + 1);
                byte b2 = b;
                Object[] objArr = new Object[1];
                c(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-MyBillsEntityDataFactory[15]);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                c(b3, b4, b4, objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    throw th2;
                }
                throw cause;
            }
        }
    }
}

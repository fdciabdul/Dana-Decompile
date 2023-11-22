package Catalano.Math.Random;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public class Pcg32 implements IRandomNumberGenerator {
    private static final AtomicLong KClassImpl$Data$declaredNonStaticMembers$2;
    public static final byte[] PlaceComponentResult = {116, 58, -28, -63, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int getAuthRequestContext = 1;
    private boolean BuiltInFictitiousFunctionClassFactory = false;
    private long MyBillsEntityDataFactory;
    private long moveToNextValue;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 4
            int r7 = 16 - r7
            byte[] r0 = Catalano.Math.Random.Pcg32.PlaceComponentResult
            int r9 = r9 + 105
            int r8 = r8 * 15
            int r8 = 19 - r8
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L33
        L19:
            r3 = 0
        L1a:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L33:
            int r7 = -r7
            int r9 = r9 + 1
            int r10 = r10 + r7
            int r7 = r10 + 2
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: Catalano.Math.Random.Pcg32.a(short, byte, int, java.lang.Object[]):void");
    }

    public Pcg32() {
        AtomicLong atomicLong;
        long j;
        long j2;
        long nanoTime = System.nanoTime();
        do {
            atomicLong = KClassImpl$Data$declaredNonStaticMembers$2;
            j = atomicLong.get();
            j2 = 181783497276652981L * j;
        } while (!atomicLong.compareAndSet(j, j2));
        this.moveToNextValue = 0L;
        this.MyBillsEntityDataFactory = (j2 * 2) + 1;
        getAuthRequestContext();
        this.moveToNextValue += nanoTime;
        getAuthRequestContext();
    }

    private int getAuthRequestContext() {
        long j = this.moveToNextValue;
        this.moveToNextValue = (6364136223846793005L * j) + this.MyBillsEntityDataFactory;
        return Integer.rotateRight((int) (((j >>> 18) ^ j) >>> 27), (int) (j >>> 59));
    }

    static {
        try {
            Object[] objArr = {Pcg32.class};
            byte b = (byte) (getAuthRequestContext - 1);
            Object[] objArr2 = new Object[1];
            a(b, b, (byte) getAuthRequestContext, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b2 = (byte) (getAuthRequestContext - 1);
            byte b3 = (byte) getAuthRequestContext;
            a(b2, b3, (byte) (b3 - 1), new Object[1]);
            KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicLong(((Integer) cls.getMethod((String) r8[0], Object.class).invoke(null, objArr)).intValue());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }
}

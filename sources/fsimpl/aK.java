package fsimpl;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.fullstory.util.Log;

/* loaded from: classes.dex */
public class aK {

    /* renamed from: a  reason: collision with root package name */
    private final aE f7828a;
    private final bA b;
    private final C0275bz c;
    private final aX d;
    private final Rect e = new Rect();

    public aK(aE aEVar, bA bAVar, C0275bz c0275bz, aX aXVar) {
        this.f7828a = aEVar;
        this.b = bAVar;
        this.c = c0275bz;
        this.d = aXVar;
    }

    public static int a(Bitmap bitmap) {
        Bitmap b;
        int i = 0;
        try {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 1, 1, true);
            if (C0353ex.a(bitmap) && (b = C0353ex.b(createScaledBitmap)) != createScaledBitmap) {
                C0353ex.a(createScaledBitmap, bitmap);
                bitmap = createScaledBitmap;
                createScaledBitmap = b;
            }
            i = createScaledBitmap.getPixel(0, 0);
            C0353ex.a(createScaledBitmap, bitmap);
            return i;
        } catch (Throwable th) {
            Log.e("Exception getting dominant color", th);
            return i;
        }
    }

    private int a(fi fiVar, Bitmap bitmap) {
        try {
            if (aE.a(bitmap)) {
                Log.w("bitmap recycled after canvas checks and made it through to encoding, discarding from uploads");
                return 0;
            }
            return C0292cp.a(fiVar, bitmap.getWidth(), bitmap.getHeight(), 0, 0, 0, 0, bitmap.getDensity(), a(bitmap), 1);
        } catch (Throwable th) {
            Log.e("Exception during writing Masked Image", th);
            return 0;
        }
    }

    private int a(fi fiVar, Bitmap bitmap, boolean z) {
        String a2;
        try {
            if (aE.a(bitmap)) {
                Log.w("bitmap recycled after canvas checks and made it through to encoding, discarding from uploads");
                return 0;
            }
            byte[] bArr = null;
            String a3 = z ? null : this.b.a(bitmap);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int density = bitmap.getDensity();
            if (a3 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("sha256:");
                sb.append(a3);
                a2 = sb.toString();
            } else {
                a2 = z ? this.f7828a.a(bitmap, width, height) : this.f7828a.b(bitmap, width, height);
                if (a2 == null) {
                    return 0;
                }
            }
            int a4 = fiVar.a(a2);
            if (aE.a(bitmap)) {
                Log.w("bitmap recycled after canvas checks and made it through to encoding, discarding from uploads");
            } else {
                bArr = bitmap.getNinePatchChunk();
            }
            return C0292cp.a(fiVar, width, height, 0, a4, 0, bArr != null ? C0292cp.a(fiVar, bArr) : 0, density, 0, 0);
        } catch (Throwable th) {
            Log.e("Exception during writing Image", th);
            return 0;
        }
    }

    private int a(fi fiVar, String str, int i, int i2, int i3) {
        return C0292cp.a(fiVar, i, i2, 0, fiVar.a(str), 0, 0, i3, 0, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ec A[Catch: all -> 0x022e, TryCatch #9 {all -> 0x022e, blocks: (B:70:0x01c2, B:72:0x01d0, B:73:0x01e0, B:75:0x01ec, B:76:0x01fc, B:78:0x0202, B:80:0x0208, B:82:0x020e, B:84:0x022a, B:69:0x01bf), top: B:159:0x01d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x024e A[Catch: all -> 0x0295, TRY_LEAVE, TryCatch #5 {all -> 0x0295, blocks: (B:93:0x0248, B:95:0x024e), top: B:151:0x0248 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x028a  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v6, types: [int] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(java.util.Map r21, java.util.Map r22, java.util.Map r23, java.util.Map r24, java.util.Map r25, java.util.Map r26, fsimpl.fi r27) {
        /*
            Method dump skipped, instructions count: 872
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.aK.a(java.util.Map, java.util.Map, java.util.Map, java.util.Map, java.util.Map, java.util.Map, fsimpl.fi):int");
    }
}

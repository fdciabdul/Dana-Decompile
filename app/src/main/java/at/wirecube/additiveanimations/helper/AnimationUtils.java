package at.wirecube.additiveanimations.helper;

/* loaded from: classes6.dex */
public class AnimationUtils {
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a A[LOOP:0: B:11:0x001a->B:13:0x0020, LOOP_START, PHI: r3
      0x001a: PHI (r3v3 float) = (r3v2 float), (r3v7 float) binds: [B:9:0x0016, B:13:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0018 -> B:8:0x0014). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static float MyBillsEntityDataFactory(float r2, float r3) {
        /*
            float r3 = r3 - r2
            float r2 = java.lang.Math.abs(r3)
            r0 = 1127481344(0x43340000, float:180.0)
            r1 = 1135869952(0x43b40000, float:360.0)
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 <= 0) goto L14
            r2 = 0
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 <= 0) goto L13
            goto L18
        L13:
            float r3 = r3 + r1
        L14:
            int r2 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r2 <= 0) goto L1a
        L18:
            float r3 = r3 - r1
            goto L14
        L1a:
            r2 = -1011613696(0xffffffffc3b40000, float:-360.0)
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 >= 0) goto L22
            float r3 = r3 + r1
            goto L1a
        L22:
            int r2 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r2 <= 0) goto L27
            float r3 = r3 - r1
        L27:
            r2 = -1020002304(0xffffffffc3340000, float:-180.0)
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 >= 0) goto L2e
            float r3 = r3 + r1
        L2e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: at.wirecube.additiveanimations.helper.AnimationUtils.MyBillsEntityDataFactory(float, float):float");
    }
}

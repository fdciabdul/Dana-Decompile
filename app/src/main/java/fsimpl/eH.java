package fsimpl;

import java.security.SecureRandom;

/* loaded from: classes4.dex */
public class eH {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7954a = 74;
    private static final long b = new SecureRandom().nextLong();

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
    
        if (r7 != (-1)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.Object r7, java.lang.String r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r8.length()
            r0.<init>(r1)
            long r1 = fsimpl.eH.b
            int r3 = r8.hashCode()
            long r3 = (long) r3
            boolean r5 = r7 instanceof android.view.View
            r6 = 0
            if (r5 == 0) goto L1f
            android.view.View r7 = (android.view.View) r7
            int r7 = r7.getId()
            r5 = -1
            if (r7 == r5) goto L2a
            goto L2b
        L1f:
            boolean r5 = r7 instanceof com.fullstory.instrumentation.frameworks.compose.FSComposeLayoutNode
            if (r5 == 0) goto L2a
            com.fullstory.instrumentation.frameworks.compose.FSComposeLayoutNode r7 = (com.fullstory.instrumentation.frameworks.compose.FSComposeLayoutNode) r7
            int r7 = r7._fsGetSemanticsId()
            goto L2b
        L2a:
            r7 = 0
        L2b:
            java.util.Random r5 = new java.util.Random
            long r1 = r1 ^ r3
            long r3 = (long) r7
            long r1 = r1 ^ r3
            r5.<init>(r1)
        L33:
            int r7 = r8.length()
            if (r6 >= r7) goto L4b
            int r7 = fsimpl.eH.f7954a
            int r7 = r5.nextInt(r7)
            java.lang.String r1 = "AbCdEF. GHIJklM NOPQRS. TUVWXYZ ABCDEF. GHIJKLM NOPQRS. TUVWXYZ 1234567890"
            char r7 = r1.charAt(r7)
            r0.append(r7)
            int r6 = r6 + 1
            goto L33
        L4b:
            java.lang.String r7 = r0.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.eH.a(java.lang.Object, java.lang.String):java.lang.String");
    }
}

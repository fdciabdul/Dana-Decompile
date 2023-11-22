package com.alipay.mobile.security.faceauth.api;

import android.content.Context;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.mobile.security.bio.module.MicroModule;

/* loaded from: classes7.dex */
public class AntDetectFactory {
    public static int TYPE_FACE;
    public static final byte[] PlaceComponentResult = {TarHeader.LF_DIR, -98, 98, -100, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 159;

    public static AntDetector create(Context context, int i, MicroModule microModule) {
        if (context != null) {
            if (i == 0) {
                return (AntDetector) getInstance(context, "com.alipay.mobile.security.faceauth.bean.FaceAuthenticator", microModule);
            }
            throw new RuntimeException("Can't find Authenticator");
        }
        throw new RuntimeException("context Can't be null");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0029 A[Catch: Exception -> 0x0056, TryCatch #0 {Exception -> 0x0056, blocks: (B:2:0x0000, B:6:0x0023, B:8:0x0029, B:9:0x0048), top: B:14:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048 A[Catch: Exception -> 0x0056, TRY_LEAVE, TryCatch #0 {Exception -> 0x0056, blocks: (B:2:0x0000, B:6:0x0023, B:8:0x0029, B:9:0x0048), top: B:14:0x0000 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x004a -> B:11:0x004d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object getInstance(android.content.Context r12, java.lang.String r13, com.alipay.mobile.security.bio.module.MicroModule r14) {
        /*
            java.lang.Class r13 = java.lang.Class.forName(r13)     // Catch: java.lang.Exception -> L56
            r0 = 2
            java.lang.Class[] r1 = new java.lang.Class[r0]     // Catch: java.lang.Exception -> L56
            r2 = 97
            byte[] r3 = com.alipay.mobile.security.faceauth.api.AntDetectFactory.PlaceComponentResult     // Catch: java.lang.Exception -> L56
            r4 = -1
            r5 = 23
            byte[] r5 = new byte[r5]     // Catch: java.lang.Exception -> L56
            r6 = 22
            r7 = 4
            r8 = 1
            r2 = r1
            r4 = r3
            if (r3 != 0) goto L1e
            r9 = r5
            r3 = 22
            r5 = -1
            r10 = 4
            goto L4d
        L1e:
            r7 = r5
            r3 = 97
            r5 = -1
            r9 = 4
        L23:
            int r5 = r5 + r8
            byte r10 = (byte) r3     // Catch: java.lang.Exception -> L56
            r7[r5] = r10     // Catch: java.lang.Exception -> L56
            if (r5 != r6) goto L48
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Exception -> L56
            r4 = 0
            r3.<init>(r7, r4)     // Catch: java.lang.Exception -> L56
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> L56
            r1[r4] = r3     // Catch: java.lang.Exception -> L56
            java.lang.Class<com.alipay.mobile.security.bio.module.MicroModule> r1 = com.alipay.mobile.security.bio.module.MicroModule.class
            r2[r8] = r1     // Catch: java.lang.Exception -> L56
            java.lang.reflect.Constructor r13 = r13.getConstructor(r2)     // Catch: java.lang.Exception -> L56
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L56
            r0[r4] = r12     // Catch: java.lang.Exception -> L56
            r0[r8] = r14     // Catch: java.lang.Exception -> L56
            java.lang.Object r12 = r13.newInstance(r0)     // Catch: java.lang.Exception -> L56
            goto L57
        L48:
            r10 = r4[r9]     // Catch: java.lang.Exception -> L56
            r11 = r9
            r9 = r7
            r7 = r11
        L4d:
            int r7 = r7 + r8
            int r10 = -r10
            int r3 = r3 + r10
            int r3 = r3 + (-8)
            r11 = r9
            r9 = r7
            r7 = r11
            goto L23
        L56:
            r12 = 0
        L57:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.security.faceauth.api.AntDetectFactory.getInstance(android.content.Context, java.lang.String, com.alipay.mobile.security.bio.module.MicroModule):java.lang.Object");
    }
}

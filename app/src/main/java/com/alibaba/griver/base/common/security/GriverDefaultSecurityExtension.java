package com.alibaba.griver.base.common.security;

import com.alibaba.griver.api.common.security.GriverSecurityExtension;
import o.getOnBoardingScenario;

@Deprecated
/* loaded from: classes6.dex */
public class GriverDefaultSecurityExtension implements GriverSecurityExtension {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static long getAuthRequestContext = 4161976487060286528L;

    /* renamed from: a  reason: collision with root package name */
    private String f6301a = null;

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        if ((android.text.TextUtils.isEmpty(r5)) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        if (r0 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        com.alibaba.griver.base.common.logger.GriverLogger.w("GriverBase:GriverDefaultSecurityExtension", "aes key should not be empty");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        r5 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory + 1;
        com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2 = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        if (r5.length() == 16) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        com.alibaba.griver.base.common.logger.GriverLogger.w("GriverBase:GriverDefaultSecurityExtension", "aes key length should be 16");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:
    
        r4.f6301a = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initWithKey(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 89
            int r1 = r0 % 128
            com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 15
            if (r0 != 0) goto L11
            r0 = 15
            goto L13
        L11:
            r0 = 25
        L13:
            java.lang.String r2 = "GriverBase:GriverDefaultSecurityExtension"
            r3 = 1
            if (r0 == r1) goto L24
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L20
            r0 = 1
            goto L21
        L20:
            r0 = 0
        L21:
            if (r0 == 0) goto L3d
            goto L2c
        L24:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto L3d
        L2c:
            java.lang.String r5 = "aes key should not be empty"
            com.alibaba.griver.base.common.logger.GriverLogger.w(r2, r5)
            int r5 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L3b
            int r5 = r5 + r3
            int r0 = r5 % 128
            com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2 = r0     // Catch: java.lang.Exception -> L3b
            int r5 = r5 % 2
            return
        L3b:
            r5 = move-exception
            throw r5
        L3d:
            int r0 = r5.length()
            r1 = 16
            if (r0 == r1) goto L4b
            java.lang.String r5 = "aes key length should be 16"
            com.alibaba.griver.base.common.logger.GriverLogger.w(r2, r5)
            return
        L4b:
            r4.f6301a = r5
            return
        L4e:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.initWithKey(java.lang.String):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:45:0x00a4
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public void initWithSecurityGuard() {
        /*
            r8 = this;
            java.lang.String r0 = "authCode"
            java.lang.String r1 = "com.alibaba.wireless.security.open.SecurityGuardManager"
            boolean r1 = com.alibaba.griver.base.common.utils.ReflectUtils.classExist(r1)
            r2 = 57
            if (r1 != 0) goto Lf
            r1 = 57
            goto L11
        Lf:
            r1 = 79
        L11:
            java.lang.String r3 = "GriverBase:GriverDefaultSecurityExtension"
            if (r1 == r2) goto Lad
            android.app.Application r1 = com.alibaba.griver.base.common.env.GriverEnv.getApplicationContext()     // Catch: java.lang.Exception -> La6
            java.lang.String r2 = "Griver/config.json"
            java.lang.String r1 = com.alibaba.griver.base.common.utils.KitUtils.getAssetContent(r1, r2)     // Catch: java.lang.Exception -> La6
            com.alibaba.fastjson.JSONObject r1 = com.alibaba.fastjson.JSON.parseObject(r1)     // Catch: java.lang.Exception -> La6
            java.lang.String r2 = "0a6a"
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L64
            int r6 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 55
            int r7 = r6 % 128
            com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory = r7
            int r6 = r6 % 2
            boolean r6 = r1.containsKey(r0)     // Catch: java.lang.Exception -> La6
            if (r6 == 0) goto L3b
            r6 = 1
            goto L3c
        L3b:
            r6 = 0
        L3c:
            if (r6 == r5) goto L3f
            goto L64
        L3f:
            int r6 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 19
            int r7 = r6 % 128
            com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory = r7
            int r6 = r6 % 2
            java.lang.String r6 = r1.getString(r0)     // Catch: java.lang.Exception -> La6
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> La6
            if (r6 != 0) goto L64
            int r2 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L62
            int r2 = r2 + 27
            int r6 = r2 % 128
            com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2 = r6     // Catch: java.lang.Exception -> L62
            int r2 = r2 % 2
            java.lang.String r2 = r1.getString(r0)     // Catch: java.lang.Exception -> La6
            goto L64
        L62:
            r0 = move-exception
            throw r0
        L64:
            java.lang.String r0 = "GriverAESKey"
            java.lang.String r0 = com.alibaba.griver.base.common.utils.SecurityGuardUtils.getExtraData(r2, r0)     // Catch: java.lang.Exception -> La6
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> La6
            if (r1 == 0) goto L72
            r1 = 1
            goto L73
        L72:
            r1 = 0
        L73:
            if (r1 == 0) goto L8f
            int r0 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 19
            int r1 = r0 % 128
            com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            java.lang.String r0 = "get aes key from security guard failed, the key is empty"
            com.alibaba.griver.base.common.logger.GriverLogger.w(r3, r0)     // Catch: java.lang.Exception -> La6
            int r0 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 39
            int r1 = r0 % 128
            com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            return
        L8f:
            int r1 = r0.length()     // Catch: java.lang.Exception -> La6
            r2 = 16
            if (r1 == r2) goto L98
            goto L99
        L98:
            r4 = 1
        L99:
            if (r4 == r5) goto La1
            java.lang.String r0 = "get aes key from security guard, but the key length should be 16"
            com.alibaba.griver.base.common.logger.GriverLogger.w(r3, r0)     // Catch: java.lang.Exception -> La6
            return
        La1:
            r8.f6301a = r0     // Catch: java.lang.Exception -> La6
            return
        La4:
            r0 = move-exception
            throw r0
        La6:
            r0 = move-exception
            java.lang.String r1 = "init with security guard failed"
            com.alibaba.griver.base.common.logger.GriverLogger.e(r3, r1, r0)
            return
        Lad:
            java.lang.String r0 = "Security guard not integrated, return"
            com.alibaba.griver.base.common.logger.GriverLogger.w(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.initWithSecurityGuard():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        if ((android.text.TextUtils.isEmpty(r5.f6301a) ? 'H' : 20) != 'H') goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        if (r0 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        r0 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2 + 17;
        com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if ((r0 % 2) != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        if (r1 == true) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
    
        return com.alibaba.griver.base.common.utils.MD5Util.getMD5String(r5.f6301a);
     */
    @Override // com.alibaba.griver.api.common.security.GriverSecurityExtension
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getIdentifier() {
        /*
            r5 = this;
            int r0 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L4d
            int r0 = r0 + 83
            int r1 = r0 % 128
            com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory = r1     // Catch: java.lang.Exception -> L4d
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == 0) goto L26
            java.lang.String r0 = r5.f6301a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r4 = 72
            if (r0 == 0) goto L21
            r0 = 72
            goto L23
        L21:
            r0 = 20
        L23:
            if (r0 == r4) goto L2f
            goto L44
        L26:
            java.lang.String r0 = r5.f6301a     // Catch: java.lang.Exception -> L4d
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L4d
            int r4 = r3.length     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L44
        L2f:
            int r0 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 17
            int r4 = r0 % 128
            com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory = r4
            int r0 = r0 % 2
            if (r0 != 0) goto L3c
            goto L3d
        L3c:
            r1 = 1
        L3d:
            if (r1 == r2) goto L43
            int r0 = r3.length     // Catch: java.lang.Throwable -> L41
            goto L43
        L41:
            r0 = move-exception
            throw r0
        L43:
            return r3
        L44:
            java.lang.String r0 = r5.f6301a
            java.lang.String r0 = com.alibaba.griver.base.common.utils.MD5Util.getMD5String(r0)
            return r0
        L4b:
            r0 = move-exception
            throw r0
        L4d:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.getIdentifier():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r0 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (android.text.TextUtils.isEmpty(r9.f6301a) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        r0 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2 + 47;
        com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory = r0 % 128;
        r0 = r0 % 2;
        com.alibaba.griver.base.common.logger.GriverLogger.d("GriverBase:GriverDefaultSecurityExtension", "private key is empty, do not encrypt");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
    
        if (android.text.TextUtils.isEmpty(r10) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        r0 = ':';
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
    
        r0 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        if (r0 == ':') goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
    
        r8 = new java.lang.Object[1];
        b((android.view.ViewConfiguration.getLongPressTimeout() >> 16) + 26669, new char[]{32086, 5498, 44319, 17833, 56719}, r8);
        r10 = r10.getBytes(java.nio.charset.Charset.forName(((java.lang.String) r8[0]).intern()));
        r0 = r9.f6301a;
        r3 = new java.lang.Object[1];
        b(android.text.TextUtils.indexOf((java.lang.CharSequence) "", '0') + 26670, new char[]{32086, 5498, 44319, 17833, 56719}, r3);
        r10 = com.alibaba.griver.a.a.a(r0.getBytes(java.nio.charset.Charset.forName(((java.lang.String) r3[0]).intern())), r10, 0, r10.length, "AES/CBC/PKCS5Padding");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0097, code lost:
    
        if (r10 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0099, code lost:
    
        com.alibaba.griver.base.common.logger.GriverLogger.w("GriverBase:GriverDefaultSecurityExtension", "encrypt with aes failed, return null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a3, code lost:
    
        return android.util.Base64.encodeToString(r10, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a4, code lost:
    
        com.alibaba.griver.base.common.logger.GriverLogger.d("GriverBase:GriverDefaultSecurityExtension", "data is empty, do not encrypt");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a9, code lost:
    
        return r10;
     */
    @Override // com.alibaba.griver.api.common.security.GriverSecurityExtension
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String encrypt(java.lang.String r10) {
        /*
            r9 = this;
            int r0 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 25
            int r1 = r0 % 128
            com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r4 = 0
            java.lang.String r5 = "GriverBase:GriverDefaultSecurityExtension"
            if (r0 == r3) goto L22
            java.lang.String r0 = r9.f6301a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            int r6 = r4.length     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L39
            goto L2a
        L20:
            r10 = move-exception
            throw r10
        L22:
            java.lang.String r0 = r9.f6301a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L39
        L2a:
            int r0 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 47
            int r2 = r0 % 128
            com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory = r2
            int r0 = r0 % r1
            java.lang.String r0 = "private key is empty, do not encrypt"
            com.alibaba.griver.base.common.logger.GriverLogger.d(r5, r0)
            return r10
        L39:
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            r6 = 58
            r7 = 5
            if (r0 == 0) goto L45
            r0 = 58
            goto L46
        L45:
            r0 = 5
        L46:
            if (r0 == r6) goto La4
            int r0 = android.view.ViewConfiguration.getLongPressTimeout()
            int r0 = r0 >> 16
            int r0 = r0 + 26669
            char[] r6 = new char[r7]
            r6 = {x00aa: FILL_ARRAY_DATA , data: [32086, 5498, -21217, 17833, -8817} // fill-array
            java.lang.Object[] r8 = new java.lang.Object[r3]
            b(r0, r6, r8)
            r0 = r8[r2]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)
            byte[] r10 = r10.getBytes(r0)
            java.lang.String r0 = r9.f6301a
            r6 = 48
            java.lang.String r8 = ""
            int r6 = android.text.TextUtils.indexOf(r8, r6)
            int r6 = r6 + 26670
            char[] r7 = new char[r7]
            r7 = {x00b4: FILL_ARRAY_DATA , data: [32086, 5498, -21217, 17833, -8817} // fill-array
            java.lang.Object[] r3 = new java.lang.Object[r3]
            b(r6, r7, r3)
            r3 = r3[r2]
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = r3.intern()
            java.nio.charset.Charset r3 = java.nio.charset.Charset.forName(r3)
            byte[] r0 = r0.getBytes(r3)
            int r3 = r10.length
            java.lang.String r6 = "AES/CBC/PKCS5Padding"
            byte[] r10 = com.alibaba.griver.a.a.a(r0, r10, r2, r3, r6)
            if (r10 != 0) goto L9f
            java.lang.String r10 = "encrypt with aes failed, return null"
            com.alibaba.griver.base.common.logger.GriverLogger.w(r5, r10)
            return r4
        L9f:
            java.lang.String r10 = android.util.Base64.encodeToString(r10, r1)
            return r10
        La4:
            java.lang.String r0 = "data is empty, do not encrypt"
            com.alibaba.griver.base.common.logger.GriverLogger.d(r5, r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.encrypt(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        if ((r12 ? 25 : '\t') != 25) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        if (android.text.TextUtils.isEmpty(r10.f6301a) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        r12 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2 + 63;
        com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory = r12 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        if ((r12 % 2) != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        r12 = '\t';
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        r12 = kotlin.text.Typography.greater;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        if (r12 == '\t') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
    
        com.alibaba.griver.base.common.logger.GriverLogger.d("GriverBase:GriverDefaultSecurityExtension", "private key is empty, do not decrypt");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        com.alibaba.griver.base.common.logger.GriverLogger.d("GriverBase:GriverDefaultSecurityExtension", "private key is empty, do not decrypt");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        r1 = 63 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005b, code lost:
    
        if (android.text.TextUtils.isEmpty(r11) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005d, code lost:
    
        r12 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2 + 117;
        com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory = r12 % 128;
        r12 = r12 % 2;
        com.alibaba.griver.base.common.logger.GriverLogger.d("GriverBase:GriverDefaultSecurityExtension", "data is empty, do not decrypt");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006c, code lost:
    
        r11 = android.util.Base64.decode(r11, 2);
        r12 = r10.f6301a;
        r9 = new java.lang.Object[1];
        b(android.view.MotionEvent.axisFromString("") + 26670, new char[]{32086, 5498, 44319, 17833, 56719}, r9);
        r11 = com.alibaba.griver.a.a.b(r12.getBytes(java.nio.charset.Charset.forName(((java.lang.String) r9[0]).intern())), r11, 0, r11.length, "AES/CBC/PKCS5Padding");
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009e, code lost:
    
        if (r11 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a0, code lost:
    
        r4 = 29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a2, code lost:
    
        if (r4 == 29) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a4, code lost:
    
        r1 = new java.lang.Object[1];
        b(26668 - (android.widget.ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (android.widget.ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1)), new char[]{32086, 5498, 44319, 17833, 56719}, r1);
        r12 = new java.lang.String(r11, java.nio.charset.Charset.forName(((java.lang.String) r1[0]).intern()));
        r11 = com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.KClassImpl$Data$declaredNonStaticMembers$2 + 89;
        com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.BuiltInFictitiousFunctionClassFactory = r11 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d4, code lost:
    
        if ((r11 % 2) != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d6, code lost:
    
        r11 = 'P';
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d9, code lost:
    
        r11 = '5';
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00db, code lost:
    
        if (r11 == 'P') goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00dd, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e0, code lost:
    
        r11 = 48 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e1, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e4, code lost:
    
        com.alibaba.griver.base.common.logger.GriverLogger.w("GriverBase:GriverDefaultSecurityExtension", "decrypt with aes failed, return null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e9, code lost:
    
        return null;
     */
    @Override // com.alibaba.griver.api.common.security.GriverSecurityExtension
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String decrypt(java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.security.GriverDefaultSecurityExtension.decrypt(java.lang.String, java.lang.String):java.lang.String");
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        try {
            int i2 = $11 + 21;
            try {
                $10 = i2 % 128;
                int i3 = i2 % 2;
                while (true) {
                    if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                        break;
                    }
                    jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (getAuthRequestContext ^ 4796183387843776835L);
                    getonboardingscenario.getAuthRequestContext++;
                }
                char[] cArr2 = new char[length];
                getonboardingscenario.getAuthRequestContext = 0;
                int i4 = $10 + 105;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                while (true) {
                    if ((getonboardingscenario.getAuthRequestContext < cArr.length ? '+' : ',') == ',') {
                        objArr[0] = new String(cArr2);
                        return;
                    } else {
                        cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                        getonboardingscenario.getAuthRequestContext++;
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}

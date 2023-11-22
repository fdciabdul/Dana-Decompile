package com.appsflyer.internal;

/* loaded from: classes.dex */
public class a {
    private static int AppsFlyerConversionListener = 0;
    public static final int AppsFlyerInAppPurchaseValidatorListener = 0;
    public static final byte[] AppsFlyerLib = null;
    private static int getSdkVersion = 1;
    public static byte[] onAppOpenAttribution;
    private static Object onAttributionFailure;
    public static byte[] onConversionDataFail;
    private static Object onDeepLinking;
    private static int onValidateInApp;
    private static int onValidateInAppFailure;

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
    
        if ((r12 == null ? '/' : 'L') != 'L') goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
    
        if (r7 != '\f') goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0063, code lost:
    
        r0 = (r0 + 26) - 1;
        com.appsflyer.internal.a.onValidateInApp = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        if ((r0 % 2) == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0070, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0071, code lost:
    
        if (r11 == true) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
    
        r11 = r1;
        r0 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
    
        throw null;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00ae -> B:30:0x007a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String $$c(short r10, short r11, byte r12) {
        /*
            Method dump skipped, instructions count: 185
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.a.$$c(short, short, byte):java.lang.String");
    }

    public static int AFInAppEventType(Object obj) {
        int i = onValidateInApp;
        getSdkVersion = ((i ^ 35) + ((i & 35) << 1)) % 128;
        Object obj2 = onDeepLinking;
        getSdkVersion = (i + 21) % 128;
        try {
            Object[] objArr = {obj};
            byte[] bArr = AppsFlyerLib;
            int intValue = ((Integer) Class.forName($$c((short) 938, bArr[40], bArr[450]), true, (ClassLoader) onAttributionFailure).getMethod($$c((short) 400, bArr[15], bArr[92]), Object.class).invoke(obj2, objArr)).intValue();
            int i2 = onValidateInApp;
            int i3 = (i2 & 87) + (i2 | 87);
            getSdkVersion = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 6 : 'E') != 6) {
                return intValue;
            }
            throw new NullPointerException();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int AFKeystoreWrapper(int i) {
        int i2 = (onValidateInApp + 7) % 128;
        getSdkVersion = i2;
        Object obj = onDeepLinking;
        int i3 = ((i2 + 48) - 1) % 128;
        onValidateInApp = i3;
        getSdkVersion = ((i3 ^ 109) + ((i3 & 109) << 1)) % 128;
        try {
            Object[] objArr = {Integer.valueOf(i)};
            byte[] bArr = AppsFlyerLib;
            return ((Integer) Class.forName($$c((short) 938, bArr[40], bArr[450]), true, (ClassLoader) onAttributionFailure).getMethod($$c((short) 400, bArr[15], bArr[92]), Integer.TYPE).invoke(obj, objArr)).intValue();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static Object AFKeystoreWrapper(int i, int i2, char c) {
        int i3 = getSdkVersion;
        int i4 = ((i3 ^ 99) + ((i3 & 99) << 1)) % 128;
        onValidateInApp = i4;
        Object obj = onDeepLinking;
        int i5 = (i4 + 33) % 128;
        getSdkVersion = i5;
        onValidateInApp = ((i5 + 50) - 1) % 128;
        try {
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Character.valueOf(c)};
            byte[] bArr = AppsFlyerLib;
            return Class.forName($$c((short) 938, bArr[40], bArr[450]), true, (ClassLoader) onAttributionFailure).getMethod($$c((short) 214, bArr[15], bArr[66]), Integer.TYPE, Integer.TYPE, Character.TYPE).invoke(obj, objArr);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    static void init$0() {
        getSdkVersion = ((onValidateInApp + 2) - 1) % 128;
        byte[] bArr = new byte[986];
        System.arraycopy("]ó\u008et\të\u00153ÅúAìÍ\u000f\u0000\u0001ó\r\u0001\u001bÛþû\u0001!ß\u0002\r\u0004ôô\u0002?Íñ\u0000ý\rúó\u0014óDÅûú\u000fó\u0004\rõ>ÉA\u0000\të\u00153Â\u000bó\u00079ÛÚ\u0006ÿ\u000føî\u0003\u0000\r÷ú3Ñ\u0000\u0004\u0003\u0006\u0002í\u000bú\u0001ó\nò\u0003\u0006\u00056¿üEÞÞ\u0003\fþò\u0000\të\u00153À\u0005úAìÉ\u0005\u000f#Í\u000f\u0000\u0001óó\nò\u0003\u0006\u00056¿üEìÍ\fý\b@Î\u0011óÿ\nú\u0001\të\u00153ÅúAìÉ\u0005\u000f$Ï\u0000\u0011è0Ûþû\u0001!ß\u0002\r\u0004ô\u0003õö\rþ=»ú\u0006ÿ\u000fø?åÛ!èøþýù5ßí5×\u000bî\u0000'Ý\u000eýÿó\r\u0004ý\u001eÑ\t\u0000óô\u0002>Îñ\u0000ý\rúó\u0014óCÆûú\u000fó\u0004\rõ=ÊA\u0000\u0002ñ.Ýý\u0007ò/Û÷û\nÿí)é\u0005\tõ\u000f\u0002ñ1âþû\u0003!Û÷\r\u0004ý\u0003õö\rþ=»ú\u0006ÿ\u000fø?êßí2Ýý\u0007ô\u000bÿ\u0006ü\u0002þû\u0003\u0003õö\rþ=»ú\u0006ÿ\u000fø?ìáî\u000e!ßí5×\u000bî\u0000'Ý\u000eýÿó\u0002ñ1Ô\u000bÿ\"âþû\u0003!Û÷ûýÛ-Ñ\u0000+Ï\u0011÷ú Û\t\u000bú\u000b\u000b\u0015ù\u0017øºÿOº\u0005õ\u0000\n\u0001þøøS´\u0007ÿòK\u0015ú\u0016ø\u0015ü\u0014ø\u0015ø\u0018ø\të\u00153Â\u000bó\u00079ë×\u000bî\u0000'Ý\u000eýÿóó\nò\u0003\u0006\u00056Íñ\u0000BíÑ\u0000)Ûý\r\u0001õù\u0002ñ/Í\u0004\u000fó\u0004\rõ\u0019ß\u0005ý\u0011ú\u0002!Û÷\r\u0002ï\u0005ýùÌô\u0002>Îñ\u0000ý\rúó\u0014óCÆûú\u000fó\u0004\rõ=Í5\të\u00153ÅúAêãí\u0013\u0018Ûþû\u0001!ß\u0002\r\u0004ôý\u000eý ßí\të\u00153ÅúAìÉ\u0005\u000f$Ï\u0000\u0011è*Ú\u0001\u0004û\u0001!ß\u0002\r\u0004ôó\nò\u0003\u0006\u00056¿üEé×ø\r÷\u0003\u0001\u0001\b÷ú\u0015õ÷\u0010òô\u0002>Îñ\u0000ý\rúó\u0014óCÆûú\u000fó\u0004\rõ=Î=®\b\u0002ù\u0002ñ1×\u000bî\u0000'Ý\u000eýÿóË\u0003í\u00132Ë\u0003í\u00132ÿù\u0007ñ\u000f\u0002ñ.\u0002\u000fùì\u0016ûú\rí\u000bó\u0011\u0019ã\u0007ð\u0011ïù)ïí\f#Ù\u0007ø\b÷ú\u0001÷ýü\u000eÌô\u0002>Îñ\u0000ý\rúó\u0014óCÆûú\u000fó\u0004\rõ=Î4\të\u00153ÅúAº\u0007ý\fû÷\u0002ñ$Þ\u0003ÿ\u000bóþû\u0002ñ3ßï\u0004\u0003÷\u0001\u000f\u0015ïí\fó\nò\u0003\u0006\u00056Íñ\u0000BíÞï\u000bó\rõû%ìö\r\u0004ý\u0015õ÷\u0010\u0016é\të\u00153ÅúAèÝý\u0007\u0016Ú\u0001\u0004û\u0001!ß\u0002\r\u0004ô\u0002ó\u0017å\tõ\u000f\të\u00153ÅúAåú\nÍ\u0015þõü\u000bú\u0001ó\nò\u0003\u0006\u00056º\u000fí\u0004FÚïí\u0004\u001fá\u000býù\u000fí\f\u001cãöÿ\u0002ñ+Û\u0005õ\u000b\bõ+Ñ\u0000\u0004\u0003\u0006\u0002í\u000bú\u0001\të\u00153ÅúAèÝý\u0007\u0015ý\u0013øî\u0003\u0000\r÷ú ëü\b\u0018äý\u0000\u0003ö\të\u00153ÅúAèÝý\u0007!ßò\u0010ñ\tùü\u0005ý\u0005-É\u0005\u000f$Ï\u0000\u0011èý\u000eý!×\u000bî\u0000ô%ë\u0005ô\u0002?Íñ\u0000ý\rúó\u0014ó\u0005\u0011ñ\rí\u000bó\u0011\u0019ã\u0007ð\u0011ïù5Û÷\r\u0002ï\u0005ý\t\u0004ò\të\u00153ÅúAåÛþû\u0001!ß\u0002\r\u0004ô".getBytes("ISO-8859-1"), 0, bArr, 0, 986);
        AppsFlyerLib = bArr;
        AppsFlyerInAppPurchaseValidatorListener = 3;
        int i = onValidateInApp + 91;
        getSdkVersion = i % 128;
        if (i % 2 != 0) {
            return;
        }
        throw null;
    }

    private a() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:584:0x13b7
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    static {
        /*
            Method dump skipped, instructions count: 6371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.a.<clinit>():void");
    }
}

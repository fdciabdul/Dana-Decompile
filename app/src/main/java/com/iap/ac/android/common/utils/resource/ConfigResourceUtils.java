package com.iap.ac.android.common.utils.resource;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.alibaba.fastjson.parser.JSONLexer;
import com.iap.ac.android.common.log.ACLog;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ConfigResourceUtils {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    public static final String PRESET_CONFIG_FILE_NAME = "iapconnect_config_full";
    public static final String TAG = "ConfigResourceUtils";
    public static final String UNDERSCORE = "_";
    private static char[] getAuthRequestContext;
    public static boolean isReadFullConfig;
    public static String mConfigString;

    static {
        PlaceComponentResult();
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? '\'' : (char) 14) != '\'') {
            return;
        }
        int i2 = 63 / 0;
    }

    static void PlaceComponentResult() {
        getAuthRequestContext = new char[]{35494, 35563, 35351, 35337, 35342};
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:19:0x0033
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static java.lang.String getPresetConfigFileName(java.lang.String r3) {
        /*
            int r0 = com.iap.ac.android.common.utils.resource.ConfigResourceUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 39
            int r1 = r0 % 128
            com.iap.ac.android.common.utils.resource.ConfigResourceUtils.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == 0) goto L1e
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L1a
            goto L1b
        L1a:
            r1 = 1
        L1b:
            if (r1 == 0) goto L26
            goto L35
        L1e:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L35
        L26:
            int r3 = com.iap.ac.android.common.utils.resource.ConfigResourceUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 125
            int r0 = r3 % 128
            com.iap.ac.android.common.utils.resource.ConfigResourceUtils.BuiltInFictitiousFunctionClassFactory = r0
            int r3 = r3 % 2
            java.lang.String r3 = "iapconnect_config_full"
            return r3
        L33:
            r3 = move-exception
            throw r3
        L35:
            java.lang.String r0 = "iapconnect_config_full_"
            java.lang.StringBuilder r0 = com.iap.ac.android.common.a.a.a(r0)
            java.lang.String r3 = r3.toLowerCase()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            int r0 = com.iap.ac.android.common.utils.resource.ConfigResourceUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 125
            int r1 = r0 % 128
            com.iap.ac.android.common.utils.resource.ConfigResourceUtils.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            return r3
        L51:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.common.utils.resource.ConfigResourceUtils.getPresetConfigFileName(java.lang.String):java.lang.String");
    }

    public static String readConfigFromAsset(Context context, String str) {
        Throwable th;
        InputStream inputStream;
        Exception e;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            Object[] objArr = {context.getAssets(), str};
            Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
            if (obj == null) {
                obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (MotionEvent.axisFromString("") + 58134), Process.myTid() >> 22, 48 - TextUtils.lastIndexOf("", '0', 0, 0))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
            }
            inputStream = (InputStream) ((Method) obj).invoke(null, objArr);
            try {
                inputStreamReader = new InputStreamReader(inputStream);
            } catch (Exception e2) {
                e = e2;
                inputStreamReader = null;
                bufferedReader = null;
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("ConfigResourceUtils readConfigFromAsset failed: ");
                sb.append(e);
                ACLog.e(str2, sb.toString());
                safeClose(bufferedReader);
                safeClose(inputStreamReader);
                safeClose(inputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
                try {
                    safeClose(bufferedReader2);
                    safeClose(inputStreamReader);
                    safeClose(inputStream);
                    throw th;
                } catch (Exception e3) {
                    throw e3;
                }
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
            } catch (Exception e4) {
                e = e4;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                safeClose(bufferedReader2);
                safeClose(inputStreamReader);
                safeClose(inputStream);
                throw th;
            }
            try {
                try {
                    StringBuilder sb2 = new StringBuilder();
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
                    BuiltInFictitiousFunctionClassFactory = i % 128;
                    int i2 = i % 2;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            try {
                                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
                                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                                int i4 = i3 % 2;
                                sb2.append(readLine);
                            } catch (Exception e5) {
                                throw e5;
                            }
                        } else {
                            String obj2 = sb2.toString();
                            safeClose(bufferedReader);
                            safeClose(inputStreamReader);
                            safeClose(inputStream);
                            return obj2;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = inputStreamReader;
                    bufferedReader2 = bufferedReader;
                    safeClose(bufferedReader2);
                    safeClose(inputStreamReader);
                    safeClose(inputStream);
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                String str22 = TAG;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("ConfigResourceUtils readConfigFromAsset failed: ");
                sb3.append(e);
                ACLog.e(str22, sb3.toString());
                safeClose(bufferedReader);
                safeClose(inputStreamReader);
                safeClose(inputStream);
                return null;
            }
        } catch (Throwable th5) {
            try {
                Throwable cause = th5.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th5;
            } catch (Exception e7) {
                e = e7;
                inputStream = null;
                inputStreamReader = null;
                bufferedReader = null;
                String str222 = TAG;
                StringBuilder sb32 = new StringBuilder();
                sb32.append("ConfigResourceUtils readConfigFromAsset failed: ");
                sb32.append(e);
                ACLog.e(str222, sb32.toString());
                safeClose(bufferedReader);
                safeClose(inputStreamReader);
                safeClose(inputStream);
                return null;
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
                inputStreamReader = null;
                safeClose(bufferedReader2);
                safeClose(inputStreamReader);
                safeClose(inputStream);
                throw th;
            }
        }
    }

    public static String readFullConfig(Context context, String str, String str2) {
        if ((!isReadFullConfig ? JSONLexer.EOI : 'C') != 'C') {
            mConfigString = readConfigFromAsset(context, getPresetConfigFileName(str));
            isReadFullConfig = true;
        }
        if (TextUtils.isEmpty(mConfigString)) {
            int i = BuiltInFictitiousFunctionClassFactory + 53;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return null;
        }
        String str3 = mConfigString;
        Object[] objArr = new Object[1];
        a(new int[]{0, 5, 67, 2}, false, new byte[]{0, 1, 1, 1, 0}, objArr);
        byte[] decode = Base64.decode(str3.getBytes(Charset.forName(((String) objArr[0]).intern())), 0);
        if (decode != null) {
            try {
                return new JSONObject(new String(decode)).optString(str2, "");
            } catch (JSONException e) {
                String str4 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("ConfigResourceUtils parse config failed: ");
                sb.append(e);
                ACLog.e(str4, sb.toString());
            }
        }
        return null;
    }

    public static void safeClose(Closeable closeable) {
        int i = BuiltInFictitiousFunctionClassFactory + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? ',' : '(') != ',') {
            if ((closeable != null ? 'V' : 'R') != 'V') {
                return;
            }
        } else {
            int i2 = 17 / 0;
            if ((closeable != null ? (char) 22 : 'N') == 'N') {
                return;
            }
        }
        try {
            closeable.close();
            int i3 = BuiltInFictitiousFunctionClassFactory + 9;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (IOException e) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("ConfigResourceUtils readConfigFromAsset failed: ");
            sb.append(e);
            ACLog.e(str, sb.toString());
        }
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr = getAuthRequestContext;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = $10 + 113;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i2];
        System.arraycopy(cArr, i, cArr3, 0, i2);
        if (bArr != null) {
            char[] cArr4 = new char[i2];
            try {
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                char c = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                    int i8 = $11 + 53;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
                }
                cArr3 = cArr4;
            } catch (Exception e) {
                throw e;
            }
        }
        if (i4 > 0) {
            char[] cArr5 = new char[i2];
            System.arraycopy(cArr3, 0, cArr5, 0, i2);
            int i10 = i2 - i4;
            System.arraycopy(cArr5, 0, cArr3, i10, i4);
            System.arraycopy(cArr5, i4, cArr3, 0, i10);
        }
        if (!(!z)) {
            char[] cArr6 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if ((verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2 ? '^' : 'M') == 'M') {
                    break;
                }
                try {
                    int i11 = $11 + 73;
                    $10 = i11 % 128;
                    int i12 = i11 % 2;
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                    int i13 = $10 + 97;
                    $11 = i13 % 128;
                    int i14 = i13 % 2;
                } catch (Exception e2) {
                    throw e2;
                }
            }
            cArr3 = cArr6;
        }
        if ((i3 > 0 ? '1' : ',') == '1') {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        String str = new String(cArr3);
        int i15 = $10 + 29;
        $11 = i15 % 128;
        if (!(i15 % 2 == 0)) {
            objArr[0] = str;
            return;
        }
        Object obj = null;
        obj.hashCode();
        objArr[0] = str;
    }
}

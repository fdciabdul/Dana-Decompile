package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.os.SystemClock;
import com.alibaba.fastjson.parser.JSONLexer;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.mixpanel.android.util.MPLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InstallReferrerPlay implements InstallReferrerStateListener {
    private static int $10 = 0;
    private static int $11 = 1;
    protected static final Pattern BuiltInFictitiousFunctionClassFactory;
    private static int[] GetContactSyncConfig = null;
    private static String KClassImpl$Data$declaredNonStaticMembers$2 = "MixpanelAPI.InstallReferrerPlay";
    private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    private static boolean getAuthRequestContext = false;
    private static int initRecordTimeStamp = 1;
    private Timer DatabaseTableConfigUtil;
    private final Pattern MyBillsEntityDataFactory;
    private final Pattern NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Pattern PlaceComponentResult;
    private Context getErrorConfigVersion;
    private InstallReferrerClient lookAheadTest;
    private ReferrerCallback moveToNextValue;
    private final Pattern scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface ReferrerCallback {
        void MyBillsEntityDataFactory();
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        GetContactSyncConfig = new int[]{46093103, -642385097, -689086241, -124243573, 225620519, 142174711, -2036336170, -1677805003, 2050052805, 2028420139, -2079896911, 1385181964, -372879364, -1211662433, -1313515242, 2095341128, -1990790566, -300479318};
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory = Pattern.compile("(^|&)utm_source=([^&#=]*)([#&]|$)");
        getAuthRequestContext = false;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 91;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
    }

    public InstallReferrerPlay(Context context, ReferrerCallback referrerCallback) {
        try {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Pattern.compile("(^|&)utm_medium=([^&#=]*)([#&]|$)");
            this.MyBillsEntityDataFactory = Pattern.compile("(^|&)utm_campaign=([^&#=]*)([#&]|$)");
            this.PlaceComponentResult = Pattern.compile("(^|&)utm_content=([^&#=]*)([#&]|$)");
            this.scheduleImpl = Pattern.compile("(^|&)utm_term=([^&#=]*)([#&]|$)");
            this.getErrorConfigVersion = context;
            this.moveToNextValue = referrerCallback;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
            this.DatabaseTableConfigUtil = new Timer();
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        if (r7 != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
    
        if ((r7 == 1) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        com.mixpanel.android.util.MPLog.PlaceComponentResult(com.mixpanel.android.mpmetrics.InstallReferrerPlay.KClassImpl$Data$declaredNonStaticMembers$2, "Service is currently unavailable.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
    
        if (r7 == 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        r1 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
    
        r1 = 'Z';
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        if (r1 == 26) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        com.mixpanel.android.util.MPLog.PlaceComponentResult(com.mixpanel.android.mpmetrics.InstallReferrerPlay.KClassImpl$Data$declaredNonStaticMembers$2, "API not available on the current Play Store app.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
    
        if (r7 != 3) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0050, code lost:
    
        if (r7 == true) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
    
        com.mixpanel.android.util.MPLog.PlaceComponentResult(com.mixpanel.android.mpmetrics.InstallReferrerPlay.KClassImpl$Data$declaredNonStaticMembers$2, "Unexpected error.");
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0090  */
    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onInstallReferrerSetupFinished(int r7) {
        /*
            r6 = this;
            r0 = -1
            r1 = 59
            if (r7 == r0) goto L8
            r0 = 21
            goto La
        L8:
            r0 = 59
        La:
            r2 = 3
            r3 = 0
            r4 = 2
            r5 = 1
            if (r0 == r1) goto L7a
            if (r7 == 0) goto L5a
            int r0 = com.mixpanel.android.mpmetrics.InstallReferrerPlay.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 41
            int r1 = r0 % 128
            com.mixpanel.android.mpmetrics.InstallReferrerPlay.initRecordTimeStamp = r1
            int r0 = r0 % r4
            r1 = 51
            if (r0 != 0) goto L22
            r0 = 64
            goto L24
        L22:
            r0 = 51
        L24:
            if (r0 == r1) goto L29
            if (r7 == 0) goto L30
            goto L38
        L29:
            if (r7 == r5) goto L2d
            r0 = 0
            goto L2e
        L2d:
            r0 = 1
        L2e:
            if (r0 == 0) goto L38
        L30:
            java.lang.String r7 = com.mixpanel.android.mpmetrics.InstallReferrerPlay.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r0 = "Service is currently unavailable."
            com.mixpanel.android.util.MPLog.PlaceComponentResult(r7, r0)
            goto L81
        L38:
            r0 = 26
            if (r7 == r4) goto L3f
            r1 = 26
            goto L41
        L3f:
            r1 = 90
        L41:
            if (r1 == r0) goto L4b
            java.lang.String r7 = com.mixpanel.android.mpmetrics.InstallReferrerPlay.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r0 = "API not available on the current Play Store app."
            com.mixpanel.android.util.MPLog.PlaceComponentResult(r7, r0)
            goto L67
        L4b:
            if (r7 != r2) goto L4f
            r7 = 0
            goto L50
        L4f:
            r7 = 1
        L50:
            if (r7 == r5) goto L67
            java.lang.String r7 = com.mixpanel.android.mpmetrics.InstallReferrerPlay.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r0 = "Unexpected error."
            com.mixpanel.android.util.MPLog.PlaceComponentResult(r7, r0)
            goto L67
        L5a:
            com.android.installreferrer.api.InstallReferrerClient r7 = r6.lookAheadTest     // Catch: java.lang.Exception -> L71
            com.android.installreferrer.api.ReferrerDetails r7 = r7.getInstallReferrer()     // Catch: java.lang.Exception -> L71
            java.lang.String r7 = r7.getInstallReferrer()     // Catch: java.lang.Exception -> L71
            r6.BuiltInFictitiousFunctionClassFactory(r7)     // Catch: java.lang.Exception -> L71
        L67:
            int r7 = com.mixpanel.android.mpmetrics.InstallReferrerPlay.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r7 = r7 + 37
            int r0 = r7 % 128
            com.mixpanel.android.mpmetrics.InstallReferrerPlay.initRecordTimeStamp = r0
            int r7 = r7 % r4
            goto L82
        L71:
            r7 = move-exception
            java.lang.String r0 = com.mixpanel.android.mpmetrics.InstallReferrerPlay.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r1 = "There was an error fetching your referrer details."
            com.mixpanel.android.util.MPLog.getAuthRequestContext(r0, r1, r7)
            goto L81
        L7a:
            java.lang.String r7 = com.mixpanel.android.mpmetrics.InstallReferrerPlay.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r0 = "Service was disconnected unexpectedly."
            com.mixpanel.android.util.MPLog.PlaceComponentResult(r7, r0)
        L81:
            r3 = 1
        L82:
            if (r3 == 0) goto L90
            int r7 = com.mixpanel.android.mpmetrics.InstallReferrerPlay.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r7 = r7 + r2
            int r0 = r7 % 128
            com.mixpanel.android.mpmetrics.InstallReferrerPlay.initRecordTimeStamp = r0
            int r7 = r7 % r4
            r6.KClassImpl$Data$declaredNonStaticMembers$2()
            return
        L90:
            r6.PlaceComponentResult()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.InstallReferrerPlay.onInstallReferrerSetupFinished(int):void");
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public void onInstallReferrerServiceDisconnected() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 107;
        initRecordTimeStamp = i % 128;
        if (i % 2 != 0) {
            MPLog.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "Install Referrer Service Disconnected.");
            KClassImpl$Data$declaredNonStaticMembers$2();
            return;
        }
        MPLog.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "Install Referrer Service Disconnected.");
        KClassImpl$Data$declaredNonStaticMembers$2();
        Object obj = null;
        obj.hashCode();
    }

    public final void getAuthRequestContext() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 73;
        initRecordTimeStamp = i % 128;
        try {
            if (!(i % 2 != 0)) {
                InstallReferrerClient build = InstallReferrerClient.newBuilder(this.getErrorConfigVersion).build();
                this.lookAheadTest = build;
                build.startConnection(this);
                getAuthRequestContext = false;
            } else {
                InstallReferrerClient build2 = InstallReferrerClient.newBuilder(this.getErrorConfigVersion).build();
                this.lookAheadTest = build2;
                build2.startConnection(this);
                getAuthRequestContext = true;
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 103;
            initRecordTimeStamp = i2 % 128;
            int i3 = i2 % 2;
        } catch (SecurityException e) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "Install referrer client could not start connection", e);
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (!(this.NetworkUserEntityData$$ExternalSyntheticLambda1 <= 5)) {
            try {
                int i = initRecordTimeStamp + 107;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
                if ((i % 2 != 0 ? '-' : 'A') != 'A') {
                    MPLog.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "Already retried 5 times. Disconnecting...");
                    PlaceComponentResult();
                    Object[] objArr = null;
                    int length = objArr.length;
                    return;
                }
                MPLog.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "Already retried 5 times. Disconnecting...");
                PlaceComponentResult();
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        this.DatabaseTableConfigUtil.schedule(new TimerTask() { // from class: com.mixpanel.android.mpmetrics.InstallReferrerPlay.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                InstallReferrerPlay.this.getAuthRequestContext();
            }
        }, 2500L);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1++;
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 29;
        initRecordTimeStamp = i2 % 128;
        int i3 = i2 % 2;
    }

    private void PlaceComponentResult() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 43;
            initRecordTimeStamp = i % 128;
            int i2 = i % 2;
            InstallReferrerClient installReferrerClient = this.lookAheadTest;
            if ((installReferrerClient != null ? JSONLexer.EOI : Typography.greater) != 26) {
                return;
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 31;
            initRecordTimeStamp = i3 % 128;
            int i4 = i3 % 2;
            try {
                if ((installReferrerClient.isReady() ? '!' : '[') != '[') {
                    int i5 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 111;
                    initRecordTimeStamp = i5 % 128;
                    try {
                        if (!(i5 % 2 == 0)) {
                            this.lookAheadTest.endConnection();
                            return;
                        }
                        this.lookAheadTest.endConnection();
                        Object[] objArr = null;
                        int length = objArr.length;
                    } catch (Exception e) {
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "Error closing referrer connection", e);
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 115;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        if (str == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("referrer", str);
            String authRequestContext = getAuthRequestContext(BuiltInFictitiousFunctionClassFactory.matcher(str));
            if (authRequestContext != null) {
                hashMap.put("utm_source", authRequestContext);
            }
            String authRequestContext2 = getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0.matcher(str));
            if (authRequestContext2 != null) {
                hashMap.put("utm_medium", authRequestContext2);
            }
            try {
                String authRequestContext3 = getAuthRequestContext(this.MyBillsEntityDataFactory.matcher(str));
                if (authRequestContext3 != null) {
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 35;
                    initRecordTimeStamp = i3 % 128;
                    if ((i3 % 2 == 0 ? 'Q' : Typography.less) != 'Q') {
                        hashMap.put("utm_campaign", authRequestContext3);
                    } else {
                        hashMap.put("utm_campaign", authRequestContext3);
                        Object[] objArr = null;
                        int length = objArr.length;
                    }
                }
                String authRequestContext4 = getAuthRequestContext(this.PlaceComponentResult.matcher(str));
                if (authRequestContext4 != null) {
                    hashMap.put("utm_content", authRequestContext4);
                }
                String authRequestContext5 = getAuthRequestContext(this.scheduleImpl.matcher(str));
                if ((authRequestContext5 != null ? '?' : '8') == '?') {
                    hashMap.put("utm_term", authRequestContext5);
                    int i4 = initRecordTimeStamp + 55;
                    NetworkUserEntityData$$ExternalSyntheticLambda2 = i4 % 128;
                    int i5 = i4 % 2;
                }
                PersistentIdentity.getAuthRequestContext(this.getErrorConfigVersion, "com.mixpanel.android.mpmetrics.ReferralInfo", hashMap);
                ReferrerCallback referrerCallback = this.moveToNextValue;
                if (!(referrerCallback == null)) {
                    referrerCallback.MyBillsEntityDataFactory();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String getAuthRequestContext(Matcher matcher) {
        if ((matcher.find() ? '4' : '#') != '#') {
            String group = matcher.group(2);
            if ((group != null ? '!' : (char) 16) == '!') {
                try {
                    Object[] objArr = new Object[1];
                    a(6 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new int[]{1181912761, -2121317315, -1545246976, -242164305}, objArr);
                    String decode = URLDecoder.decode(group, ((String) objArr[0]).intern());
                    int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 13;
                    initRecordTimeStamp = i % 128;
                    int i2 = i % 2;
                    return decode;
                } catch (UnsupportedEncodingException unused) {
                    MPLog.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "Could not decode a parameter into UTF-8");
                }
            }
        }
        int i3 = initRecordTimeStamp + 7;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        int i4 = i3 % 2;
        return null;
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int i2;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        try {
            int[] iArr2 = GetContactSyncConfig;
            if (iArr2 != null) {
                int length = iArr2.length;
                int[] iArr3 = new int[length];
                int i3 = 0;
                while (i3 < length) {
                    iArr3[i3] = (int) (iArr2[i3] ^ (-3152031022165484798L));
                    i3++;
                    try {
                        int i4 = $11 + 17;
                        $10 = i4 % 128;
                        int i5 = i4 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                iArr2 = iArr3;
            }
            int length2 = iArr2.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = GetContactSyncConfig;
            if (iArr5 != null) {
                int i6 = $10 + 55;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i8 = 0;
                while (true) {
                    if ((i8 < length3 ? (char) 0 : (char) 14) != 0) {
                        break;
                    }
                    iArr6[i8] = (int) (iArr5[i8] ^ (-3152031022165484798L));
                    i8++;
                    length2 = length2;
                }
                i2 = length2;
                iArr5 = iArr6;
            } else {
                i2 = length2;
            }
            System.arraycopy(iArr5, 0, iArr4, 0, i2);
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                for (int i9 = 0; i9 < 16; i9++) {
                    int i10 = $10 + 27;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i9];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i12 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i12;
                }
                int i13 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i13;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                int i14 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i15 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
            }
            objArr[0] = new String(cArr2, 0, i);
        } catch (Exception e2) {
            throw e2;
        }
    }
}

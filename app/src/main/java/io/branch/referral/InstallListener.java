package io.branch.referral;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.ExpandableListView;
import com.huawei.hms.framework.common.ContainerUtils;
import id.dana.cashier.view.InputCardNumberView;
import io.branch.referral.Defines;
import io.branch.referral.InstallReferrerClientWrapper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public class InstallListener extends BroadcastReceiver {
    private static int $10 = 0;
    private static int $11 = 1;
    private static boolean BuiltInFictitiousFunctionClassFactory = false;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static boolean MyBillsEntityDataFactory = false;
    private static IInstallReferrerEvents PlaceComponentResult = null;
    private static String getAuthRequestContext = "bnc_no_value";
    private static char getErrorConfigVersion = 0;
    private static int lookAheadTest = 1;
    private static int moveToNextValue;
    static boolean unReportedReferrerAvailable;
    InstallReferrerClientWrapper.InstallReferrerWrapperListener installReferrerWrapperListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface IInstallReferrerEvents {
        void NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        int i = lookAheadTest + 125;
        moveToNextValue = i % 128;
        if ((i % 2 != 0 ? 'W' : '#') != '#') {
            int i2 = 8 / 0;
        }
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        getErrorConfigVersion = (char) 42070;
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{37275, 37346, 37255, 37367, 37254, 37253, 37252, 37257, 37274};
    }

    public InstallListener() {
        try {
            this.installReferrerWrapperListener = new InstallReferrerClientWrapper.InstallReferrerWrapperListener() { // from class: io.branch.referral.InstallListener.2
                @Override // io.branch.referral.InstallReferrerClientWrapper.InstallReferrerWrapperListener
                public final void PlaceComponentResult(Context context, String str, long j, long j2) {
                    PrefHelper.MyBillsEntityDataFactory("onReferrerClientFinished()");
                    InstallListener.access$100(context, str, j, j2);
                    if (InstallListener.access$200()) {
                        InstallListener.access$000();
                    }
                }

                @Override // io.branch.referral.InstallReferrerClientWrapper.InstallReferrerWrapperListener
                public final void getAuthRequestContext() {
                    PrefHelper.MyBillsEntityDataFactory("onReferrerClientError()");
                    InstallListener.access$302(false);
                }
            };
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void access$000() {
        int i = moveToNextValue + 121;
        lookAheadTest = i % 128;
        if (i % 2 != 0) {
            try {
                MyBillsEntityDataFactory();
            } catch (Exception e) {
                throw e;
            }
        } else {
            MyBillsEntityDataFactory();
            int i2 = 80 / 0;
        }
        int i3 = moveToNextValue + 109;
        lookAheadTest = i3 % 128;
        if ((i3 % 2 == 0 ? '*' : 'A') != '*') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    static /* synthetic */ void access$100(Context context, String str, long j, long j2) {
        int i = moveToNextValue + 59;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        MyBillsEntityDataFactory(context, str, j, j2);
        try {
            int i3 = moveToNextValue + 109;
            try {
                lookAheadTest = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 0 : '\f') != 0) {
                    return;
                }
                int i4 = 34 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ boolean access$200() {
        int i = moveToNextValue + 81;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? 'U' : 'A') != 'A') {
            boolean z = BuiltInFictitiousFunctionClassFactory;
            Object[] objArr = null;
            int length = objArr.length;
            return z;
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    static /* synthetic */ boolean access$302(boolean z) {
        int i = lookAheadTest + 39;
        moveToNextValue = i % 128;
        boolean z2 = i % 2 == 0;
        MyBillsEntityDataFactory = z;
        if (!z2) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return z;
    }

    public void captureInstallReferrer(Context context, long j, IInstallReferrerEvents iInstallReferrerEvents) {
        PlaceComponentResult = iInstallReferrerEvents;
        if (unReportedReferrerAvailable) {
            try {
                int i = moveToNextValue + 71;
                try {
                    lookAheadTest = i % 128;
                    if (!(i % 2 != 0)) {
                        MyBillsEntityDataFactory();
                        int i2 = 35 / 0;
                    } else {
                        MyBillsEntityDataFactory();
                    }
                    int i3 = moveToNextValue + 11;
                    lookAheadTest = i3 % 128;
                    if (i3 % 2 == 0) {
                        int i4 = 81 / 0;
                        return;
                    }
                    return;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        BuiltInFictitiousFunctionClassFactory = true;
        MyBillsEntityDataFactory = new InstallReferrerClientWrapper(context).getAuthRequestContext(this.installReferrerWrapperListener);
        new Timer().schedule(new TimerTask() { // from class: io.branch.referral.InstallListener.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                InstallListener.access$000();
            }
        }, j);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        MyBillsEntityDataFactory(context, intent.getStringExtra("referrer"), 0L, 0L);
        Object[] objArr = null;
        if ((BuiltInFictitiousFunctionClassFactory ? 'T' : '_') == 'T' && !MyBillsEntityDataFactory) {
            int i = moveToNextValue + 93;
            lookAheadTest = i % 128;
            if ((i % 2 == 0 ? (char) 27 : '\t') != 27) {
                MyBillsEntityDataFactory();
            } else {
                MyBillsEntityDataFactory();
                int length = objArr.length;
            }
        }
        int i2 = moveToNextValue + 79;
        lookAheadTest = i2 % 128;
        if ((i2 % 2 == 0 ? '(' : 'W') != 'W') {
            int length2 = objArr.length;
        }
    }

    private static void MyBillsEntityDataFactory(Context context, String str, long j, long j2) {
        PrefHelper.BuiltInFictitiousFunctionClassFactory(context);
        char c = 6;
        char c2 = 2;
        if ((j > 0 ? (char) 6 : Typography.quote) != '\"') {
            int i = moveToNextValue + 1;
            lookAheadTest = i % 128;
            if ((i % 2 == 0 ? 'a' : '\b') != '\b') {
                PrefHelper.BuiltInFictitiousFunctionClassFactory("bnc_referrer_click_ts", j);
                int i2 = 10 / 0;
            } else {
                PrefHelper.BuiltInFictitiousFunctionClassFactory("bnc_referrer_click_ts", j);
            }
        }
        if (j2 > 0) {
            PrefHelper.BuiltInFictitiousFunctionClassFactory("bnc_install_begin_ts", j2);
        }
        if (str != null) {
            int i3 = 5;
            try {
                Object[] objArr = new Object[1];
                a(new char[]{6, 2, 1, 4, 13803}, (byte) (View.combineMeasuredStates(0, 0) + 73), 5 - TextUtils.indexOf("", ""), objArr);
                String decode = URLDecoder.decode(str, ((String) objArr[0]).intern());
                HashMap hashMap = new HashMap();
                String[] split = decode.split(ContainerUtils.FIELD_DELIMITER);
                int length = split.length;
                int i4 = 0;
                while (i4 < length) {
                    String str2 = split[i4];
                    if (!TextUtils.isEmpty(str2)) {
                        String str3 = "-";
                        if ((!str2.contains("=") ? InputCardNumberView.DIVIDER : '?') == ' ' && str2.contains("-")) {
                            int i5 = lookAheadTest + 19;
                            moveToNextValue = i5 % 128;
                            int i6 = i5 % c2;
                        } else {
                            int i7 = moveToNextValue + 99;
                            lookAheadTest = i7 % 128;
                            int i8 = i7 % c2;
                            str3 = "=";
                        }
                        String[] split2 = str2.split(str3);
                        if (split2.length > 1) {
                            String str4 = split2[0];
                            char[] cArr = new char[i3];
                            cArr[0] = c;
                            cArr[1] = c2;
                            cArr[c2] = 1;
                            cArr[3] = 4;
                            cArr[4] = 13803;
                            Object[] objArr2 = new Object[1];
                            a(cArr, (byte) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 74), (Process.myPid() >> 22) + 5, objArr2);
                            String decode2 = URLDecoder.decode(str4, ((String) objArr2[0]).intern());
                            String str5 = split2[1];
                            char[] cArr2 = new char[i3];
                            cArr2[0] = 6;
                            cArr2[1] = 2;
                            cArr2[2] = 1;
                            cArr2[3] = 4;
                            cArr2[4] = 13803;
                            Object[] objArr3 = new Object[1];
                            a(cArr2, (byte) (TextUtils.indexOf("", "") + 73), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 4, objArr3);
                            hashMap.put(decode2, URLDecoder.decode(str5, ((String) objArr3[0]).intern()));
                            i4++;
                            i3 = 5;
                            c = 6;
                            c2 = 2;
                        }
                    }
                    i4++;
                    i3 = 5;
                    c = 6;
                    c2 = 2;
                }
                if (hashMap.containsKey(Defines.Jsonkey.LinkClickID.getKey())) {
                    int i9 = moveToNextValue + 79;
                    lookAheadTest = i9 % 128;
                    int i10 = i9 % 2;
                    String str6 = (String) hashMap.get(Defines.Jsonkey.LinkClickID.getKey());
                    getAuthRequestContext = str6;
                    PrefHelper.getAuthRequestContext("bnc_link_click_identifier", str6);
                }
                if (hashMap.containsKey(Defines.Jsonkey.IsFullAppConv.getKey())) {
                    if (!(!hashMap.containsKey(Defines.Jsonkey.ReferringLink.getKey()))) {
                        int i11 = lookAheadTest + 31;
                        moveToNextValue = i11 % 128;
                        int i12 = i11 % 2;
                        PrefHelper.KClassImpl$Data$declaredNonStaticMembers$2("bnc_is_full_app_conversion", Boolean.valueOf(Boolean.parseBoolean((String) hashMap.get(Defines.Jsonkey.IsFullAppConv.getKey()))));
                        PrefHelper.getAuthRequestContext("bnc_app_link", (String) hashMap.get(Defines.Jsonkey.ReferringLink.getKey()));
                    }
                }
                if (hashMap.containsKey(Defines.Jsonkey.GoogleSearchInstallReferrer.getKey())) {
                    PrefHelper.getAuthRequestContext("bnc_google_search_install_identifier", (String) hashMap.get(Defines.Jsonkey.GoogleSearchInstallReferrer.getKey()));
                    PrefHelper.getAuthRequestContext("bnc_google_play_install_referrer_extras", decode);
                    int i13 = moveToNextValue + 83;
                    lookAheadTest = i13 % 128;
                    if (i13 % 2 != 0) {
                        return;
                    }
                    int i14 = 42 / 0;
                }
            } catch (UnsupportedEncodingException unused) {
            } catch (IllegalArgumentException unused2) {
                PrefHelper.MyBillsEntityDataFactory("Illegal characters in url encoded string");
            }
        }
    }

    public static String getInstallationID() {
        String str;
        int i = moveToNextValue + 53;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? 'a' : '4') != 'a') {
            try {
                str = getAuthRequestContext;
            } catch (Exception e) {
                throw e;
            }
        } else {
            try {
                str = getAuthRequestContext;
                int i2 = 34 / 0;
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = moveToNextValue + 121;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    private static void MyBillsEntityDataFactory() {
        unReportedReferrerAvailable = true;
        IInstallReferrerEvents iInstallReferrerEvents = PlaceComponentResult;
        if (!(iInstallReferrerEvents == null)) {
            int i = lookAheadTest + 3;
            moveToNextValue = i % 128;
            if ((i % 2 != 0 ? (char) 19 : '1') != '1') {
                iInstallReferrerEvents.NetworkUserEntityData$$ExternalSyntheticLambda0();
                PlaceComponentResult = null;
                unReportedReferrerAvailable = false;
                BuiltInFictitiousFunctionClassFactory = false;
                MyBillsEntityDataFactory = true;
            } else {
                iInstallReferrerEvents.NetworkUserEntityData$$ExternalSyntheticLambda0();
                PlaceComponentResult = null;
                unReportedReferrerAvailable = false;
                BuiltInFictitiousFunctionClassFactory = false;
                MyBillsEntityDataFactory = false;
            }
        }
        int i2 = lookAheadTest + 99;
        moveToNextValue = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 20 : 'Z') != 'Z') {
            int i3 = 0 / 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007d, code lost:
    
        r3[r0.getAuthRequestContext] = (char) (r0.MyBillsEntityDataFactory - r12);
        r3[r0.getAuthRequestContext + 1] = (char) (r0.PlaceComponentResult - r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0090, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = r0.MyBillsEntityDataFactory / r2;
        r0.scheduleImpl = r0.MyBillsEntityDataFactory % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = r0.PlaceComponentResult / r2;
        r0.lookAheadTest = r0.PlaceComponentResult % r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
    
        if (r0.scheduleImpl != r0.lookAheadTest) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00aa, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ac, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ad, code lost:
    
        if (r7 == true) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b3, code lost:
    
        if (r0.BuiltInFictitiousFunctionClassFactory != r0.KClassImpl$Data$declaredNonStaticMembers$2) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b5, code lost:
    
        r7 = io.branch.referral.InstallListener.$11 + 105;
        io.branch.referral.InstallListener.$10 = r7 % 128;
        r7 = r7 % 2;
        r0.scheduleImpl = ((r0.scheduleImpl + r2) - 1) % r2;
        r0.lookAheadTest = ((r0.lookAheadTest + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e9, code lost:
    
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.lookAheadTest;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.scheduleImpl;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0105, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0106, code lost:
    
        throw r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0107, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = ((r0.BuiltInFictitiousFunctionClassFactory + r2) - 1) % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = ((r0.KClassImpl$Data$declaredNonStaticMembers$2 + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(char[] r11, byte r12, int r13, java.lang.Object[] r14) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.InstallListener.a(char[], byte, int, java.lang.Object[]):void");
    }
}

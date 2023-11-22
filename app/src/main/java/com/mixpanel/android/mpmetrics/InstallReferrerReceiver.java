package com.mixpanel.android.mpmetrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mixpanel.android.util.MPLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Deprecated
/* loaded from: classes8.dex */
public class InstallReferrerReceiver extends BroadcastReceiver {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] lookAheadTest = {35569, 35399, 35454, 35434, 35429};
    private static int moveToNextValue = 0;
    private static int scheduleImpl = 1;
    private final Pattern PlaceComponentResult = Pattern.compile("(^|&)utm_source=([^&#=]*)([#&]|$)");
    private final Pattern MyBillsEntityDataFactory = Pattern.compile("(^|&)utm_medium=([^&#=]*)([#&]|$)");
    private final Pattern getAuthRequestContext = Pattern.compile("(^|&)utm_campaign=([^&#=]*)([#&]|$)");
    private final Pattern BuiltInFictitiousFunctionClassFactory = Pattern.compile("(^|&)utm_content=([^&#=]*)([#&]|$)");
    private final Pattern KClassImpl$Data$declaredNonStaticMembers$2 = Pattern.compile("(^|&)utm_term=([^&#=]*)([#&]|$)");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        String string = extras.getString("referrer");
        if (string == null) {
            int i = moveToNextValue + 81;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("referrer", string);
        String PlaceComponentResult = PlaceComponentResult(this.PlaceComponentResult.matcher(string));
        if (PlaceComponentResult != null) {
            hashMap.put("utm_source", PlaceComponentResult);
        }
        String PlaceComponentResult2 = PlaceComponentResult(this.MyBillsEntityDataFactory.matcher(string));
        if (PlaceComponentResult2 != null) {
            hashMap.put("utm_medium", PlaceComponentResult2);
        }
        String PlaceComponentResult3 = PlaceComponentResult(this.getAuthRequestContext.matcher(string));
        if (!(PlaceComponentResult3 == null)) {
            int i3 = moveToNextValue + 19;
            scheduleImpl = i3 % 128;
            if (i3 % 2 == 0) {
                try {
                    hashMap.put("utm_campaign", PlaceComponentResult3);
                    int i4 = 29 / 0;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                hashMap.put("utm_campaign", PlaceComponentResult3);
            }
        }
        try {
            String PlaceComponentResult4 = PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.matcher(string));
            if (PlaceComponentResult4 != null) {
                hashMap.put("utm_content", PlaceComponentResult4);
            }
            String PlaceComponentResult5 = PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.matcher(string));
            if ((PlaceComponentResult5 != null ? 'L' : 'W') == 'L') {
                int i5 = moveToNextValue + 75;
                scheduleImpl = i5 % 128;
                if (i5 % 2 == 0) {
                    hashMap.put("utm_term", PlaceComponentResult5);
                    Object obj = null;
                    obj.hashCode();
                } else {
                    hashMap.put("utm_term", PlaceComponentResult5);
                }
            }
            PersistentIdentity.getAuthRequestContext(context, "com.mixpanel.android.mpmetrics.ReferralInfo", hashMap);
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String PlaceComponentResult(Matcher matcher) {
        if (!matcher.find()) {
            return null;
        }
        int i = scheduleImpl + 69;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        String group = matcher.group(2);
        if (group != null) {
            int i3 = scheduleImpl + 55;
            moveToNextValue = i3 % 128;
            int i4 = i3 % 2;
            try {
                Object[] objArr = new Object[1];
                a(new int[]{0, 5, 167, 0}, true, new byte[]{1, 1, 1, 0, 1}, objArr);
                String decode = URLDecoder.decode(group, ((String) objArr[0]).intern());
                int i5 = moveToNextValue + 81;
                scheduleImpl = i5 % 128;
                int i6 = i5 % 2;
                return decode;
            } catch (UnsupportedEncodingException unused) {
                MPLog.getAuthRequestContext("MixpanelAPI.InstRfrRcvr", "Could not decode a parameter into UTF-8");
                return null;
            }
        }
        return null;
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr = lookAheadTest;
        if (!(cArr == null)) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            for (int i5 = 0; i5 < length; i5++) {
                cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i2];
        System.arraycopy(cArr, i, cArr3, 0, i2);
        if (bArr != null) {
            int i6 = $10 + 61;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            char[] cArr4 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (true) {
                if (!(verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2)) {
                    break;
                }
                if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                    int i8 = $11 + 57;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                } else {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                }
                c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr4;
        }
        if ((i4 > 0 ? (char) 14 : 'T') != 'T') {
            char[] cArr5 = new char[i2];
            System.arraycopy(cArr3, 0, cArr5, 0, i2);
            int i10 = i2 - i4;
            System.arraycopy(cArr5, 0, cArr3, i10, i4);
            System.arraycopy(cArr5, i4, cArr3, 0, i10);
        }
        if (z) {
            try {
                int i11 = $11 + 51;
                $10 = i11 % 128;
                int i12 = i11 % 2;
                char[] cArr6 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr6;
            } catch (Exception e) {
                throw e;
            }
        }
        if (i3 > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                try {
                    cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        objArr[0] = new String(cArr3);
    }
}

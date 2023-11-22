package com.alibaba.griver.bluetooth.altbeacon.beacon.utils;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import id.dana.DanaApplication;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.util.RaspUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import o.whenAvailable;

/* loaded from: classes6.dex */
public class UrlBeaconUrlCompressor {
    private static final byte EDDYSTONE_URL_BIZ = 12;
    private static final byte EDDYSTONE_URL_BIZ_SLASH = 5;
    private static final byte EDDYSTONE_URL_COM = 7;
    private static final byte EDDYSTONE_URL_COM_SLASH = 0;
    private static final byte EDDYSTONE_URL_EDU = 9;
    private static final byte EDDYSTONE_URL_EDU_SLASH = 2;
    private static final int EDDYSTONE_URL_FQDN_GROUP = 3;
    private static final byte EDDYSTONE_URL_GOV = 13;
    private static final byte EDDYSTONE_URL_GOV_SLASH = 6;
    private static final byte EDDYSTONE_URL_INFO = 11;
    private static final byte EDDYSTONE_URL_INFO_SLASH = 4;
    private static final byte EDDYSTONE_URL_NET = 10;
    private static final byte EDDYSTONE_URL_NET_SLASH = 3;
    private static final byte EDDYSTONE_URL_ORG = 8;
    private static final byte EDDYSTONE_URL_ORG_SLASH = 1;
    private static final int EDDYSTONE_URL_PATH_GROUP = 5;
    private static final int EDDYSTONE_URL_PROTOCOL_GROUP = 1;
    private static final byte EDDYSTONE_URL_PROTOCOL_HTTP = 2;
    private static final byte EDDYSTONE_URL_PROTOCOL_HTTPS = 3;
    private static final byte EDDYSTONE_URL_PROTOCOL_HTTPS_WWW = 1;
    private static final byte EDDYSTONE_URL_PROTOCOL_HTTP_WWW = 0;
    private static final String EDDYSTONE_URL_REGEX = "^((?i)http|https):\\/\\/((?i)www\\.)?((?:[0-9a-zA-Z_-]+\\.?)+)(/?)([./0-9a-zA-Z_-]*)";
    private static final int EDDYSTONE_URL_SLASH_GROUP = 4;
    private static final int EDDYSTONE_URL_WWW_GROUP = 2;
    private static final byte TLD_NOT_ENCODABLE = -1;
    private static final String URL_HOST_WWW = "www.";
    private static final String URL_PROTOCOL_HTTP = "http";
    private static final String URL_PROTOCOL_HTTPS_COLON_SLASH_SLASH = "https://";
    private static final String URL_PROTOCOL_HTTPS_WWW_DOT = "https://www.";
    private static final String URL_PROTOCOL_HTTP_COLON_SLASH_SLASH = "http://";
    private static final String URL_PROTOCOL_HTTP_WWW_DOT = "http://www.";
    private static final String URL_TLD_DOT_BIZ = ".biz";
    private static final String URL_TLD_DOT_BIZ_SLASH = ".biz/";
    private static final String URL_TLD_DOT_COM = ".com";
    private static final String URL_TLD_DOT_COM_SLASH = ".com/";
    private static final String URL_TLD_DOT_EDU = ".edu";
    private static final String URL_TLD_DOT_EDU_SLASH = ".edu/";
    private static final String URL_TLD_DOT_GOV = ".gov";
    private static final String URL_TLD_DOT_GOV_SLASH = ".gov/";
    private static final String URL_TLD_DOT_INFO = ".info";
    private static final String URL_TLD_DOT_INFO_SLASH = ".info/";
    private static final String URL_TLD_DOT_NET = ".net";
    private static final String URL_TLD_DOT_NET_SLASH = ".net/";
    private static final String URL_TLD_DOT_ORG = ".org";
    private static final String URL_TLD_DOT_ORG_SLASH = ".org/";
    private static List<TLDMapEntry> tldMap;

    static {
        ArrayList arrayList = new ArrayList();
        tldMap = arrayList;
        arrayList.add(new TLDMapEntry(URL_TLD_DOT_COM_SLASH, (byte) 0));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_ORG_SLASH, (byte) 1));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_EDU_SLASH, (byte) 2));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_NET_SLASH, (byte) 3));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_INFO_SLASH, (byte) 4));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_BIZ_SLASH, (byte) 5));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_GOV_SLASH, (byte) 6));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_COM, (byte) 7));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_ORG, (byte) 8));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_EDU, (byte) 9));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_NET, (byte) 10));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_INFO, (byte) 11));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_BIZ, (byte) 12));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_GOV, (byte) 13));
    }

    private static byte encodedByteForTopLevelDomain(String str) {
        Iterator<TLDMapEntry> it = tldMap.iterator();
        byte b = -1;
        boolean z = false;
        while (!z && it.hasNext()) {
            TLDMapEntry next = it.next();
            boolean equalsIgnoreCase = next.tld.equalsIgnoreCase(str);
            if (equalsIgnoreCase) {
                b = next.encodedByte;
            }
            z = equalsIgnoreCase;
        }
        return b;
    }

    private static String topLevelDomainForByte(Byte b) {
        Iterator<TLDMapEntry> it = tldMap.iterator();
        String str = null;
        boolean z = false;
        while (!z && it.hasNext()) {
            TLDMapEntry next = it.next();
            boolean z2 = next.encodedByte == b.byteValue();
            if (z2) {
                str = next.tld;
            }
            z = z2;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] compress(java.lang.String r12) throws java.net.MalformedURLException {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.altbeacon.beacon.utils.UrlBeaconUrlCompressor.compress(java.lang.String):byte[]");
    }

    public static String uncompress(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = bArr[0] & 15;
        int i2 = 1;
        if (i == 0) {
            stringBuffer.append(URL_PROTOCOL_HTTP_WWW_DOT);
        } else if (i == 1) {
            stringBuffer.append(URL_PROTOCOL_HTTPS_WWW_DOT);
        } else if (i == 2) {
            stringBuffer.append(URL_PROTOCOL_HTTP_COLON_SLASH_SLASH);
        } else if (i == 3) {
            stringBuffer.append(URL_PROTOCOL_HTTPS_COLON_SLASH_SLASH);
        }
        byte b = -1;
        while (i2 < bArr.length) {
            byte b2 = bArr[i2];
            if (b == 0 && b2 == 0) {
                break;
            }
            String str = topLevelDomainForByte(Byte.valueOf(b2));
            if (str != null) {
                stringBuffer.append(str);
            } else {
                stringBuffer.append((char) b2);
            }
            i2++;
            b = b2;
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class TLDMapEntry {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
        private static int MyBillsEntityDataFactory;
        public final byte encodedByte;
        public final String tld;
        private static char[] getAuthRequestContext = {62247, 47250, 25676, 4151, 56764, 35092};
        private static long PlaceComponentResult = 5949064980287437052L;

        public TLDMapEntry(String str, byte b) {
            this.tld = str;
            this.encodedByte = b;
        }

        public static void $$a(long j, long j2) {
            long j3 = j ^ (j2 << 32);
            Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            StringBuilder sb = new StringBuilder();
            Object[] objArr = new Object[1];
            a((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 6 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) View.MeasureSpec.getMode(0), objArr);
            sb.append((String) objArr[0]);
            sb.append(j3);
            String obj = sb.toString();
            Intrinsics.checkNotNullParameter(obj, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj);
            RaspUtils.DexguardException dexguardException = new RaspUtils.DexguardException();
            Intrinsics.checkNotNullParameter(dexguardException, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(dexguardException);
            RaspUtils.PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.EMULATOR);
            UnsafeDeviceActivity.show(DanaApplication.application, UnsafeDeviceActivity.UnsafeStatus.EMULATOR);
            int i = MyBillsEntityDataFactory + 45;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (!(i % 2 != 0)) {
                int i2 = 37 / 0;
            }
        }

        private static void a(int i, int i2, char c, Object[] objArr) {
            whenAvailable whenavailable = new whenAvailable();
            long[] jArr = new long[i2];
            try {
                whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
                while (true) {
                    if (whenavailable.BuiltInFictitiousFunctionClassFactory >= i2) {
                        break;
                    }
                    int i3 = $11 + 13;
                    $10 = i3 % 128;
                    int i4 = i3 % 2;
                    jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (getAuthRequestContext[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ PlaceComponentResult))) ^ c;
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                }
                char[] cArr = new char[i2];
                whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
                while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                }
                String str = new String(cArr);
                int i5 = $11 + 125;
                $10 = i5 % 128;
                if (i5 % 2 == 0) {
                    objArr[0] = str;
                    return;
                }
                Object obj = null;
                obj.hashCode();
                objArr[0] = str;
            } catch (Exception e) {
                throw e;
            }
        }
    }
}

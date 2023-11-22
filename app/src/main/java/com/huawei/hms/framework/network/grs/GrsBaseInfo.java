package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ExpandableListView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.Locale;
import kotlin.text.Typography;
import o.D;

/* loaded from: classes7.dex */
public class GrsBaseInfo implements Cloneable {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int MyBillsEntityDataFactory = 0;
    private static final String TAG = "GrsBaseInfo";
    private static long getAuthRequestContext;
    private String androidVersion;
    private String appName;
    private String countrySource;
    private String deviceModel;
    private String issueCountry;
    private String regCountry;
    private String romVersion;
    private String serCountry;
    private String uid;
    private String versionName;

    /* loaded from: classes3.dex */
    public @interface CountryCodeSource {
        public static final String APP = "APP";
        public static final String LOCALE_INFO = "LOCALE_INFO";
        public static final String NETWORK_COUNTRY = "NETWORK_COUNTRY";
        public static final String SIM_COUNTRY = "SIM_COUNTRY";
        public static final String UNKNOWN = "UNKNOWN";
        public static final String VENDOR_COUNTRY = "VENDOR_COUNTRY";
    }

    static {
        getAuthRequestContext();
        int i = MyBillsEntityDataFactory + 15;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? (char) 25 : ')') != 25) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public GrsBaseInfo() {
    }

    public GrsBaseInfo(Context context) {
        try {
            this.issueCountry = GrsApp.getInstance().getIssueCountryCode(context);
        } catch (Exception e) {
            throw e;
        }
    }

    static void getAuthRequestContext() {
        getAuthRequestContext = -7665699388676313736L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        if (r4 == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        if (android.text.TextUtils.isEmpty(r8) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        if (android.text.TextUtils.isEmpty(r7.toString()) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
    
        if (r4 == true) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        r7.append(com.huawei.hms.framework.common.ContainerUtils.FIELD_DELIMITER);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        r7.append("android_version");
        r7.append("=");
        r7.append(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.StringBuffer getStringBuffer(java.lang.StringBuffer r7, boolean r8, android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.GrsBaseInfo.getStringBuffer(java.lang.StringBuffer, boolean, android.content.Context):java.lang.StringBuffer");
    }

    private boolean isEqual(String str, String str2) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if (str == null) {
            int i3 = MyBillsEntityDataFactory + 43;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            if (!(str2 != null)) {
                try {
                    int i5 = MyBillsEntityDataFactory + 75;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                    if (!(i5 % 2 != 0)) {
                        Object obj = null;
                        obj.hashCode();
                        return true;
                    }
                    return true;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        if (str != null) {
            int i6 = MyBillsEntityDataFactory + 119;
            KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
            int i7 = i6 % 2;
            if (!(str2 == null)) {
                return str.equals(str2);
            }
        }
        return false;
    }

    public GrsBaseInfo clone() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        GrsBaseInfo grsBaseInfo = (GrsBaseInfo) super.clone();
        int i3 = MyBillsEntityDataFactory + 7;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return grsBaseInfo;
    }

    /* renamed from: clone  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m229clone() {
        GrsBaseInfo clone;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 != 0) {
            clone = clone();
            int i2 = 53 / 0;
        } else {
            clone = clone();
        }
        try {
            int i3 = MyBillsEntityDataFactory + 103;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 == 0 ? 'N' : 'G') != 'G') {
                int i4 = 3 / 0;
                return clone;
            }
            return clone;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
    
        if (r1 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0083, code lost:
    
        if (isEqual(r4.regCountry, r5.regCountry) != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008d, code lost:
    
        if (isEqual(r4.issueCountry, r5.issueCountry) == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0097, code lost:
    
        if (isEqual(r4.androidVersion, r5.androidVersion) == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a1, code lost:
    
        if (isEqual(r4.romVersion, r5.romVersion) == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a3, code lost:
    
        r1 = com.huawei.hms.framework.network.grs.GrsBaseInfo.KClassImpl$Data$declaredNonStaticMembers$2 + 3;
        com.huawei.hms.framework.network.grs.GrsBaseInfo.MyBillsEntityDataFactory = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b5, code lost:
    
        if (isEqual(r4.deviceModel, r5.deviceModel) == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b7, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b9, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ba, code lost:
    
        if (r1 == true) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c7, code lost:
    
        if (isEqual(r4.countrySource, r5.countrySource) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c9, code lost:
    
        r5 = '3';
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00cc, code lost:
    
        r5 = '5';
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ce, code lost:
    
        if (r5 == '3') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d1, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d2, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean compare(java.lang.Object r5) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.GrsBaseInfo.compare(java.lang.Object):boolean");
    }

    public GrsBaseInfo copy() {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setAppName(this.appName);
        grsBaseInfo.setSerCountry(this.serCountry);
        grsBaseInfo.setRegCountry(this.regCountry);
        grsBaseInfo.setIssueCountry(this.issueCountry);
        grsBaseInfo.setCountrySource(this.countrySource);
        grsBaseInfo.setAndroidVersion(this.androidVersion);
        grsBaseInfo.setDeviceModel(this.deviceModel);
        grsBaseInfo.setRomVersion(this.romVersion);
        grsBaseInfo.setUid(this.uid);
        grsBaseInfo.setVersionName(this.versionName);
        int i = MyBillsEntityDataFactory + 55;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return grsBaseInfo;
    }

    public String getAndroidVersion() {
        int i = MyBillsEntityDataFactory + 85;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        char c = i % 2 == 0 ? '_' : 'U';
        String str = this.androidVersion;
        if (c == '_') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return str;
    }

    public String getAppName() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? '*' : 'W') != '*') {
            return this.appName;
        }
        String str = this.appName;
        Object[] objArr = null;
        int length = objArr.length;
        return str;
    }

    public String getCountrySource() {
        int i = MyBillsEntityDataFactory + 117;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        String str = this.countrySource;
        try {
            int i3 = MyBillsEntityDataFactory + 95;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (i3 % 2 != 0) {
                    return str;
                }
                Object obj = null;
                obj.hashCode();
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getDeviceModel() {
        try {
            int i = MyBillsEntityDataFactory + 115;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                String str = this.deviceModel;
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getGrsReqParamJoint(boolean z, boolean z2, String str, Context context) {
        String authRequestContext;
        StringBuffer stringBuffer = new StringBuffer();
        if (("1.0".equals(str) ? 'V' : '\'') != '\'') {
            Logger.v(TAG, "1.0 interface has no query param appname");
        } else {
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append("app_name=");
            } else if (!TextUtils.isEmpty(getAppName())) {
                stringBuffer.append("app_name=");
                str = getAppName();
            }
            stringBuffer.append(str);
        }
        String versionName = getVersionName();
        if ((!TextUtils.isEmpty(versionName) ? 'F' : (char) 27) == 'F') {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            Object[] objArr = new Object[1];
            a((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1, new char[]{43608, 50584, 30797, 3932, 43577, 25976, 14621, 61107, 10350, 59181, 47967, 27871, 44721, 24807, 15747}, objArr);
            stringBuffer.append(((String) objArr[0]).intern());
            stringBuffer.append("=");
            stringBuffer.append(versionName);
        }
        String uid = getUid();
        if (!TextUtils.isEmpty(uid)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                int i = MyBillsEntityDataFactory + 53;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("uid=");
            if (z) {
                authRequestContext = com.huawei.hms.framework.network.grs.h.b.KClassImpl$Data$declaredNonStaticMembers$2(uid);
            } else if (z2) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
                MyBillsEntityDataFactory = i3 % 128;
                if ((i3 % 2 != 0 ? '\t' : Typography.amp) != '\t') {
                    authRequestContext = com.huawei.hms.framework.network.grs.h.b.getAuthRequestContext(uid);
                } else {
                    authRequestContext = com.huawei.hms.framework.network.grs.h.b.getAuthRequestContext(uid);
                    Object obj = null;
                    obj.hashCode();
                }
            } else {
                stringBuffer.append(uid);
                int i4 = MyBillsEntityDataFactory + 33;
                KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                int i5 = i4 % 2;
            }
            stringBuffer.append(authRequestContext);
        }
        String regCountry = getRegCountry();
        if (!TextUtils.isEmpty(regCountry)) {
            if ("UNKNOWN".equals(regCountry) ? false : true) {
                int i6 = MyBillsEntityDataFactory + 11;
                KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                int i7 = i6 % 2;
                if ((!TextUtils.isEmpty(stringBuffer.toString()) ? 'L' : (char) 20) != 20) {
                    int i8 = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
                    MyBillsEntityDataFactory = i8 % 128;
                    int i9 = i8 % 2;
                    stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                    int i10 = MyBillsEntityDataFactory + 103;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i10 % 128;
                    int i11 = i10 % 2;
                }
                stringBuffer.append("reg_country=");
                stringBuffer.append(regCountry);
            }
        }
        String serCountry = getSerCountry();
        if (!TextUtils.isEmpty(serCountry) && !"UNKNOWN".equals(serCountry)) {
            if ((!TextUtils.isEmpty(stringBuffer.toString()) ? (char) 6 : 'K') == 6) {
                int i12 = MyBillsEntityDataFactory + 125;
                KClassImpl$Data$declaredNonStaticMembers$2 = i12 % 128;
                int i13 = i12 % 2;
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("ser_country");
            stringBuffer.append("=");
            stringBuffer.append(serCountry);
        }
        String issueCountry = getIssueCountry();
        if (!TextUtils.isEmpty(issueCountry)) {
            int i14 = MyBillsEntityDataFactory + 87;
            KClassImpl$Data$declaredNonStaticMembers$2 = i14 % 128;
            int i15 = i14 % 2;
            if (!"UNKNOWN".equals(issueCountry)) {
                int i16 = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
                MyBillsEntityDataFactory = i16 % 128;
                int i17 = i16 % 2;
                if (!TextUtils.isEmpty(stringBuffer.toString())) {
                    stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                }
                stringBuffer.append("issue_country");
                stringBuffer.append("=");
                stringBuffer.append(issueCountry);
                int i18 = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
                MyBillsEntityDataFactory = i18 % 128;
                int i19 = i18 % 2;
            }
        }
        return getStringBuffer(stringBuffer, z2, context).toString();
    }

    public String getIssueCountry() {
        int i = MyBillsEntityDataFactory + 1;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        String str = this.issueCountry;
        try {
            int i3 = MyBillsEntityDataFactory + 83;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 24 : '\t') != '\t') {
                    Object obj = null;
                    obj.hashCode();
                    return str;
                }
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getRegCountry() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 == 0)) {
            String str = this.regCountry;
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        }
        return this.regCountry;
    }

    public String getRomVersion() {
        try {
            int i = MyBillsEntityDataFactory + 93;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if ((i % 2 == 0 ? 'X' : '4') != 'X') {
                    return this.romVersion;
                }
                int i2 = 0 / 0;
                return this.romVersion;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getSerCountry() {
        int i = MyBillsEntityDataFactory + 37;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
            try {
                return this.serCountry;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            String str = this.serCountry;
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getUid() {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
            try {
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                String str = this.uid;
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getVersionName() {
        String str;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 != 0) {
            str = this.versionName;
            int i2 = 70 / 0;
        } else {
            str = this.versionName;
        }
        try {
            int i3 = MyBillsEntityDataFactory + 65;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setAndroidVersion(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 41;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? Typography.quote : '[') == '\"') {
            this.androidVersion = str;
            int i2 = 34 / 0;
            return;
        }
        try {
            this.androidVersion = str;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setAppName(String str) {
        try {
            int i = MyBillsEntityDataFactory + 91;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            this.appName = str;
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setCountrySource(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        this.countrySource = str;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
    }

    public void setDeviceModel(String str) {
        try {
            int i = MyBillsEntityDataFactory + 41;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            this.deviceModel = str;
            int i3 = MyBillsEntityDataFactory + 5;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Deprecated
    public void setIssueCountry(String str) {
        String upperCase;
        int i = MyBillsEntityDataFactory + 93;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Object[] objArr = null;
        if (str != null) {
            try {
                int i3 = MyBillsEntityDataFactory + 21;
                try {
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    if ((i3 % 2 == 0 ? '\r' : '(') != '\r') {
                        upperCase = str.toUpperCase(Locale.ENGLISH);
                    } else {
                        upperCase = str.toUpperCase(Locale.ENGLISH);
                        objArr.hashCode();
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            upperCase = "";
        }
        this.issueCountry = upperCase;
        int i4 = MyBillsEntityDataFactory + 81;
        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
        if (i4 % 2 == 0) {
            int length = objArr.length;
        }
    }

    public void setRegCountry(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        this.regCountry = (str != null ? '1' : 'T') != 'T' ? str.toUpperCase(Locale.ENGLISH) : "";
        try {
            int i3 = MyBillsEntityDataFactory + 123;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setRomVersion(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 == 0) {
            this.romVersion = str;
            return;
        }
        try {
            this.romVersion = str;
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public void setSerCountry(String str) {
        String upperCase;
        try {
            int i = MyBillsEntityDataFactory + 91;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            if ((str != null ? '4' : (char) 0) != '4') {
                upperCase = "";
            } else {
                int i3 = MyBillsEntityDataFactory + 117;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                boolean z = i3 % 2 != 0;
                upperCase = str.toUpperCase(Locale.ENGLISH);
                if (!z) {
                    Object obj = null;
                    obj.hashCode();
                }
            }
            this.serCountry = upperCase;
        } catch (Exception e) {
            throw e;
        }
    }

    @Deprecated
    public void setUid(String str) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
            try {
                MyBillsEntityDataFactory = i % 128;
                char c = i % 2 != 0 ? '\b' : 'V';
                this.uid = str;
                if (c != '\b') {
                    return;
                }
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void setVersionName(String str) {
        int i = MyBillsEntityDataFactory + 9;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            this.versionName = str;
            Object obj = null;
            obj.hashCode();
        } else {
            try {
                this.versionName = str;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i2 = MyBillsEntityDataFactory + 45;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public int uniqueCode() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(this.appName);
            try {
                sb.append("#");
                sb.append(this.serCountry);
                sb.append("#");
                sb.append(this.regCountry);
                sb.append("#");
                sb.append(this.issueCountry);
                int hashCode = sb.toString().hashCode();
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                return hashCode;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getGrsParasKey(boolean z, boolean z2, Context context) {
        com.huawei.hms.framework.network.grs.local.model.a aVar;
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        com.huawei.hms.framework.network.grs.f.b BuiltInFictitiousFunctionClassFactory = com.huawei.hms.framework.network.grs.f.b.BuiltInFictitiousFunctionClassFactory(context.getPackageName(), this);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            aVar = BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        } else {
            aVar = null;
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
        }
        if (!(aVar == null)) {
            int i3 = MyBillsEntityDataFactory + 61;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            str = aVar.MyBillsEntityDataFactory;
        } else {
            str = "";
        }
        String grsReqParamJoint = getGrsReqParamJoint(z, z2, str, context);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            if ((!TextUtils.isEmpty(stringBuffer.toString()) ? 'P' : 'I') != 'I') {
                try {
                    int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
                    MyBillsEntityDataFactory = i5 % 128;
                    int i6 = i5 % 2;
                    try {
                        stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            stringBuffer.append(grsReqParamJoint);
        }
        return stringBuffer.toString();
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(getAuthRequestContext ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (true) {
            try {
                if (d.MyBillsEntityDataFactory >= KClassImpl$Data$declaredNonStaticMembers$22.length) {
                    break;
                }
                int i2 = $11 + 115;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (getAuthRequestContext ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
                int i4 = $11 + 115;
                $10 = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        String str = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
        int i6 = $11 + 31;
        $10 = i6 % 128;
        if ((i6 % 2 != 0 ? ',' : (char) 15) != ',') {
            objArr[0] = str;
            return;
        }
        Object[] objArr2 = null;
        int length = objArr2.length;
        objArr[0] = str;
    }
}

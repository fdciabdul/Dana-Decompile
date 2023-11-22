package com.alipay.iap.android.lbs;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LocationErrorSuccess' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public abstract class LBSLocationErrorCode {
    public static final LBSLocationErrorCode LocationErrorCancelled;
    public static final LBSLocationErrorCode LocationErrorExpired;
    public static final LBSLocationErrorCode LocationErrorNoAuthorization;
    public static final LBSLocationErrorCode LocationErrorNullLocation;
    public static final LBSLocationErrorCode LocationErrorParamInvalid;
    public static final LBSLocationErrorCode LocationErrorPositionDisabled;
    public static final LBSLocationErrorCode LocationErrorSuccess;
    public static final LBSLocationErrorCode LocationErrorSystem;
    public static final LBSLocationErrorCode LocationErrorTimeout;
    private static final /* synthetic */ LBSLocationErrorCode[] b;

    /* renamed from: a  reason: collision with root package name */
    private int f6992a;

    static {
        int i = 0;
        LBSLocationErrorCode lBSLocationErrorCode = new LBSLocationErrorCode("LocationErrorSuccess", i, i) { // from class: com.alipay.iap.android.lbs.LBSLocationErrorCode.1
            @Override // com.alipay.iap.android.lbs.LBSLocationErrorCode
            public final String getErrorString() {
                return "LBS Location Error: success";
            }
        };
        LocationErrorSuccess = lBSLocationErrorCode;
        LBSLocationErrorCode lBSLocationErrorCode2 = new LBSLocationErrorCode("LocationErrorNoAuthorization", 1, 1000) { // from class: com.alipay.iap.android.lbs.LBSLocationErrorCode.2
            @Override // com.alipay.iap.android.lbs.LBSLocationErrorCode
            public final String getErrorString() {
                return "LBS Location Error: current application has no authorization to access GPS or Network Location Provider";
            }
        };
        LocationErrorNoAuthorization = lBSLocationErrorCode2;
        LBSLocationErrorCode lBSLocationErrorCode3 = new LBSLocationErrorCode("LocationErrorPositionDisabled", 2, 1001) { // from class: com.alipay.iap.android.lbs.LBSLocationErrorCode.3
            @Override // com.alipay.iap.android.lbs.LBSLocationErrorCode
            public final String getErrorString() {
                return "LBS Location Error: GPS or Network Location Provider is disabled in system";
            }
        };
        LocationErrorPositionDisabled = lBSLocationErrorCode3;
        LBSLocationErrorCode lBSLocationErrorCode4 = new LBSLocationErrorCode("LocationErrorTimeout", 3, 1002) { // from class: com.alipay.iap.android.lbs.LBSLocationErrorCode.4
            @Override // com.alipay.iap.android.lbs.LBSLocationErrorCode
            public final String getErrorString() {
                return "LBS Location Error: timeout during request for location";
            }
        };
        LocationErrorTimeout = lBSLocationErrorCode4;
        LBSLocationErrorCode lBSLocationErrorCode5 = new LBSLocationErrorCode("LocationErrorParamInvalid", 4, 1003) { // from class: com.alipay.iap.android.lbs.LBSLocationErrorCode.5
            @Override // com.alipay.iap.android.lbs.LBSLocationErrorCode
            public final String getErrorString() {
                return "LBS Location Error: some input parameters are invalid, e.g. Context";
            }
        };
        LocationErrorParamInvalid = lBSLocationErrorCode5;
        LBSLocationErrorCode lBSLocationErrorCode6 = new LBSLocationErrorCode("LocationErrorSystem", 5, 1004) { // from class: com.alipay.iap.android.lbs.LBSLocationErrorCode.6
            @Override // com.alipay.iap.android.lbs.LBSLocationErrorCode
            public final String getErrorString() {
                return "LBS Location Error: some native system apis return error";
            }
        };
        LocationErrorSystem = lBSLocationErrorCode6;
        LBSLocationErrorCode lBSLocationErrorCode7 = new LBSLocationErrorCode("LocationErrorCancelled", 6, 1005) { // from class: com.alipay.iap.android.lbs.LBSLocationErrorCode.7
            @Override // com.alipay.iap.android.lbs.LBSLocationErrorCode
            public final String getErrorString() {
                return "LBS Location Error: operation is cancelled outside";
            }
        };
        LocationErrorCancelled = lBSLocationErrorCode7;
        LBSLocationErrorCode lBSLocationErrorCode8 = new LBSLocationErrorCode("LocationErrorNullLocation", 7, 1006) { // from class: com.alipay.iap.android.lbs.LBSLocationErrorCode.8
            @Override // com.alipay.iap.android.lbs.LBSLocationErrorCode
            public final String getErrorString() {
                return "LBS Location Error: Location Provider cannot get fixed because of some unknown reasons";
            }
        };
        LocationErrorNullLocation = lBSLocationErrorCode8;
        LBSLocationErrorCode lBSLocationErrorCode9 = new LBSLocationErrorCode("LocationErrorExpired", 8, 1007) { // from class: com.alipay.iap.android.lbs.LBSLocationErrorCode.9
            @Override // com.alipay.iap.android.lbs.LBSLocationErrorCode
            public final String getErrorString() {
                return "LBS Location Error: location is expired";
            }
        };
        LocationErrorExpired = lBSLocationErrorCode9;
        b = new LBSLocationErrorCode[]{lBSLocationErrorCode, lBSLocationErrorCode2, lBSLocationErrorCode3, lBSLocationErrorCode4, lBSLocationErrorCode5, lBSLocationErrorCode6, lBSLocationErrorCode7, lBSLocationErrorCode8, lBSLocationErrorCode9};
    }

    private LBSLocationErrorCode(String str, int i, int i2) {
        this.f6992a = i2;
    }

    public static LBSLocationErrorCode valueOf(String str) {
        return (LBSLocationErrorCode) Enum.valueOf(LBSLocationErrorCode.class, str);
    }

    public static LBSLocationErrorCode[] values() {
        return (LBSLocationErrorCode[]) b.clone();
    }

    public int getErrorCode() {
        return this.f6992a;
    }

    public abstract String getErrorString();
}

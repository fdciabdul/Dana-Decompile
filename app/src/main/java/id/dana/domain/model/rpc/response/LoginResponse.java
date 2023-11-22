package id.dana.domain.model.rpc.response;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.model.rpc.UserInfo;
import id.dana.utils.rpc.response.BaseRpcResponse;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BË\u0001\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010(\u001a\u00020\f\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\bl\u0010mJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0005J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0005J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0005J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0005J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0005J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0005J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u000eJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u000eJ\u0010\u0010\u001e\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJÔ\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010(\u001a\u00020\f2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b2\u0010\u001fJ\u001a\u00105\u001a\u00020\u00152\b\u00104\u001a\u0004\u0018\u000103HÖ\u0003¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b7\u0010\u001fJ\u0010\u00108\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b8\u0010\u0005J \u0010=\u001a\u00020<2\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b=\u0010>R$\u0010\"\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010?\u001a\u0004\b@\u0010\u0005\"\u0004\bA\u0010BR$\u0010*\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010C\u001a\u0004\bD\u0010\u000b\"\u0004\bE\u0010FR\"\u0010(\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010G\u001a\u0004\bH\u0010\u001f\"\u0004\bI\u0010JR$\u0010#\u001a\u0004\u0018\u00010\u00158\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010K\u001a\u0004\b#\u0010\u0017\"\u0004\bL\u0010MR$\u0010-\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010?\u001a\u0004\bN\u0010\u0005\"\u0004\bO\u0010BR$\u0010.\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010?\u001a\u0004\bP\u0010\u0005\"\u0004\bQ\u0010BR$\u0010+\u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010R\u001a\u0004\bS\u0010\u000e\"\u0004\bT\u0010UR$\u0010'\u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010R\u001a\u0004\bV\u0010\u000e\"\u0004\bW\u0010UR$\u0010/\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010?\u001a\u0004\bX\u0010\u0005\"\u0004\bY\u0010BR$\u0010&\u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010R\u001a\u0004\bZ\u0010\u000e\"\u0004\b[\u0010UR$\u0010,\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010?\u001a\u0004\b\\\u0010\u0005\"\u0004\b]\u0010BR$\u0010$\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010?\u001a\u0004\b^\u0010\u0005\"\u0004\b_\u0010BR$\u0010!\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010?\u001a\u0004\b`\u0010\u0005\"\u0004\ba\u0010BR$\u0010 \u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010?\u001a\u0004\bb\u0010\u0005\"\u0004\bc\u0010BR$\u0010%\u001a\u0004\u0018\u00010\u00198\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010d\u001a\u0004\be\u0010\u001b\"\u0004\bf\u0010gR*\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010h\u001a\u0004\bi\u0010\b\"\u0004\bj\u0010k"}, d2 = {"Lid/dana/domain/model/rpc/response/LoginResponse;", "Lid/dana/utils/rpc/response/BaseRpcResponse;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component10", "()Ljava/util/List;", "Lid/dana/domain/model/rpc/response/EvUrlStatus;", "component11", "()Lid/dana/domain/model/rpc/response/EvUrlStatus;", "", "component12", "()Ljava/lang/Integer;", "component13", "component14", "component15", "component16", "component2", "component3", "", "component4", "()Ljava/lang/Boolean;", "component5", "Lid/dana/domain/model/rpc/UserInfo;", "component6", "()Lid/dana/domain/model/rpc/UserInfo;", "component7", "component8", "component9", "()I", "userId", "sessionId", "clientKey", "isUserInfoCompleted", BioUtilityBridge.SECURITY_ID, "userInfo", "maxFailedCount", "lockedExpireSeconds", "failedCount", "verificationMethods", "evUrlStatus", "leftTimes", "pin", "key", WalletConstant.KYC_LEVEL, "loginTokenId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lid/dana/domain/model/rpc/UserInfo;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/util/List;Lid/dana/domain/model/rpc/response/EvUrlStatus;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/model/rpc/response/LoginResponse;", "describeContents", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getClientKey", "setClientKey", "(Ljava/lang/String;)V", "Lid/dana/domain/model/rpc/response/EvUrlStatus;", "getEvUrlStatus", "setEvUrlStatus", "(Lid/dana/domain/model/rpc/response/EvUrlStatus;)V", "I", "getFailedCount", "setFailedCount", "(I)V", "Ljava/lang/Boolean;", "setUserInfoCompleted", "(Ljava/lang/Boolean;)V", "getKey", "setKey", "getKycLevel", "setKycLevel", "Ljava/lang/Integer;", "getLeftTimes", "setLeftTimes", "(Ljava/lang/Integer;)V", "getLockedExpireSeconds", "setLockedExpireSeconds", "getLoginTokenId", "setLoginTokenId", "getMaxFailedCount", "setMaxFailedCount", "getPin", "setPin", "getSecurityId", "setSecurityId", "getSessionId", "setSessionId", "getUserId", "setUserId", "Lid/dana/domain/model/rpc/UserInfo;", "getUserInfo", "setUserInfo", "(Lid/dana/domain/model/rpc/UserInfo;)V", "Ljava/util/List;", "getVerificationMethods", "setVerificationMethods", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lid/dana/domain/model/rpc/UserInfo;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/util/List;Lid/dana/domain/model/rpc/response/EvUrlStatus;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LoginResponse extends BaseRpcResponse implements Parcelable {
    public static final Parcelable.Creator<LoginResponse> CREATOR = new Creator();
    private String clientKey;
    private EvUrlStatus evUrlStatus;
    private int failedCount;
    private Boolean isUserInfoCompleted;
    private String key;
    private String kycLevel;
    private Integer leftTimes;
    private Integer lockedExpireSeconds;
    private String loginTokenId;
    private Integer maxFailedCount;
    private String pin;
    private String securityId;
    private String sessionId;
    private String userId;
    private UserInfo userInfo;
    private List<String> verificationMethods;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<LoginResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LoginResponse createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new LoginResponse(readString, readString2, readString3, valueOf, parcel.readString(), parcel.readInt() == 0 ? null : UserInfo.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt(), parcel.createStringArrayList(), parcel.readInt() == 0 ? null : EvUrlStatus.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LoginResponse[] newArray(int i) {
            return new LoginResponse[i];
        }
    }

    public LoginResponse() {
        this(null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 65535, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final List<String> component10() {
        return this.verificationMethods;
    }

    /* renamed from: component11  reason: from getter */
    public final EvUrlStatus getEvUrlStatus() {
        return this.evUrlStatus;
    }

    /* renamed from: component12  reason: from getter */
    public final Integer getLeftTimes() {
        return this.leftTimes;
    }

    /* renamed from: component13  reason: from getter */
    public final String getPin() {
        return this.pin;
    }

    /* renamed from: component14  reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component15  reason: from getter */
    public final String getKycLevel() {
        return this.kycLevel;
    }

    /* renamed from: component16  reason: from getter */
    public final String getLoginTokenId() {
        return this.loginTokenId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getClientKey() {
        return this.clientKey;
    }

    /* renamed from: component4  reason: from getter */
    public final Boolean getIsUserInfoCompleted() {
        return this.isUserInfoCompleted;
    }

    /* renamed from: component5  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component6  reason: from getter */
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    /* renamed from: component7  reason: from getter */
    public final Integer getMaxFailedCount() {
        return this.maxFailedCount;
    }

    /* renamed from: component8  reason: from getter */
    public final Integer getLockedExpireSeconds() {
        return this.lockedExpireSeconds;
    }

    /* renamed from: component9  reason: from getter */
    public final int getFailedCount() {
        return this.failedCount;
    }

    public final LoginResponse copy(String userId, String sessionId, String clientKey, Boolean isUserInfoCompleted, String securityId, UserInfo userInfo, Integer maxFailedCount, Integer lockedExpireSeconds, int failedCount, List<String> verificationMethods, EvUrlStatus evUrlStatus, Integer leftTimes, String pin, String key, String kycLevel, String loginTokenId) {
        return new LoginResponse(userId, sessionId, clientKey, isUserInfoCompleted, securityId, userInfo, maxFailedCount, lockedExpireSeconds, failedCount, verificationMethods, evUrlStatus, leftTimes, pin, key, kycLevel, loginTokenId);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LoginResponse) {
            LoginResponse loginResponse = (LoginResponse) other;
            return Intrinsics.areEqual(this.userId, loginResponse.userId) && Intrinsics.areEqual(this.sessionId, loginResponse.sessionId) && Intrinsics.areEqual(this.clientKey, loginResponse.clientKey) && Intrinsics.areEqual(this.isUserInfoCompleted, loginResponse.isUserInfoCompleted) && Intrinsics.areEqual(this.securityId, loginResponse.securityId) && Intrinsics.areEqual(this.userInfo, loginResponse.userInfo) && Intrinsics.areEqual(this.maxFailedCount, loginResponse.maxFailedCount) && Intrinsics.areEqual(this.lockedExpireSeconds, loginResponse.lockedExpireSeconds) && this.failedCount == loginResponse.failedCount && Intrinsics.areEqual(this.verificationMethods, loginResponse.verificationMethods) && Intrinsics.areEqual(this.evUrlStatus, loginResponse.evUrlStatus) && Intrinsics.areEqual(this.leftTimes, loginResponse.leftTimes) && Intrinsics.areEqual(this.pin, loginResponse.pin) && Intrinsics.areEqual(this.key, loginResponse.key) && Intrinsics.areEqual(this.kycLevel, loginResponse.kycLevel) && Intrinsics.areEqual(this.loginTokenId, loginResponse.loginTokenId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.userId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.sessionId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.clientKey;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        Boolean bool = this.isUserInfoCompleted;
        int hashCode4 = bool == null ? 0 : bool.hashCode();
        String str4 = this.securityId;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        UserInfo userInfo = this.userInfo;
        int hashCode6 = userInfo == null ? 0 : userInfo.hashCode();
        Integer num = this.maxFailedCount;
        int hashCode7 = num == null ? 0 : num.hashCode();
        Integer num2 = this.lockedExpireSeconds;
        int hashCode8 = num2 == null ? 0 : num2.hashCode();
        int i = this.failedCount;
        List<String> list = this.verificationMethods;
        int hashCode9 = list == null ? 0 : list.hashCode();
        EvUrlStatus evUrlStatus = this.evUrlStatus;
        int hashCode10 = evUrlStatus == null ? 0 : evUrlStatus.hashCode();
        Integer num3 = this.leftTimes;
        int hashCode11 = num3 == null ? 0 : num3.hashCode();
        String str5 = this.pin;
        int hashCode12 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.key;
        int hashCode13 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.kycLevel;
        int hashCode14 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.loginTokenId;
        return (((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + i) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + (str8 != null ? str8.hashCode() : 0);
    }

    @Override // id.dana.utils.rpc.response.BaseRpcResponse
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoginResponse(userId=");
        sb.append(this.userId);
        sb.append(", sessionId=");
        sb.append(this.sessionId);
        sb.append(", clientKey=");
        sb.append(this.clientKey);
        sb.append(", isUserInfoCompleted=");
        sb.append(this.isUserInfoCompleted);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", userInfo=");
        sb.append(this.userInfo);
        sb.append(", maxFailedCount=");
        sb.append(this.maxFailedCount);
        sb.append(", lockedExpireSeconds=");
        sb.append(this.lockedExpireSeconds);
        sb.append(", failedCount=");
        sb.append(this.failedCount);
        sb.append(", verificationMethods=");
        sb.append(this.verificationMethods);
        sb.append(", evUrlStatus=");
        sb.append(this.evUrlStatus);
        sb.append(", leftTimes=");
        sb.append(this.leftTimes);
        sb.append(", pin=");
        sb.append(this.pin);
        sb.append(", key=");
        sb.append(this.key);
        sb.append(", kycLevel=");
        sb.append(this.kycLevel);
        sb.append(", loginTokenId=");
        sb.append(this.loginTokenId);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.userId);
        parcel.writeString(this.sessionId);
        parcel.writeString(this.clientKey);
        Boolean bool = this.isUserInfoCompleted;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.securityId);
        UserInfo userInfo = this.userInfo;
        if (userInfo == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            userInfo.writeToParcel(parcel, flags);
        }
        Integer num = this.maxFailedCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.lockedExpireSeconds;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeInt(this.failedCount);
        parcel.writeStringList(this.verificationMethods);
        EvUrlStatus evUrlStatus = this.evUrlStatus;
        if (evUrlStatus == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            evUrlStatus.writeToParcel(parcel, flags);
        }
        Integer num3 = this.leftTimes;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        parcel.writeString(this.pin);
        parcel.writeString(this.key);
        parcel.writeString(this.kycLevel);
        parcel.writeString(this.loginTokenId);
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "setUserId")
    public final void setUserId(String str) {
        this.userId = str;
    }

    @JvmName(name = "getSessionId")
    public final String getSessionId() {
        return this.sessionId;
    }

    @JvmName(name = "setSessionId")
    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    @JvmName(name = "getClientKey")
    public final String getClientKey() {
        return this.clientKey;
    }

    @JvmName(name = "setClientKey")
    public final void setClientKey(String str) {
        this.clientKey = str;
    }

    public /* synthetic */ LoginResponse(String str, String str2, String str3, Boolean bool, String str4, UserInfo userInfo, Integer num, Integer num2, int i, List list, EvUrlStatus evUrlStatus, Integer num3, String str5, String str6, String str7, String str8, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? Boolean.FALSE : bool, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : userInfo, (i2 & 64) != 0 ? null : num, (i2 & 128) != 0 ? null : num2, (i2 & 256) != 0 ? 0 : i, (i2 & 512) != 0 ? null : list, (i2 & 1024) != 0 ? null : evUrlStatus, (i2 & 2048) != 0 ? null : num3, (i2 & 4096) != 0 ? null : str5, (i2 & 8192) != 0 ? null : str6, (i2 & 16384) != 0 ? null : str7, (i2 & 32768) != 0 ? null : str8);
    }

    @JvmName(name = "isUserInfoCompleted")
    public final Boolean isUserInfoCompleted() {
        return this.isUserInfoCompleted;
    }

    @JvmName(name = "setUserInfoCompleted")
    public final void setUserInfoCompleted(Boolean bool) {
        this.isUserInfoCompleted = bool;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        this.securityId = str;
    }

    @JvmName(name = "getUserInfo")
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    @JvmName(name = "setUserInfo")
    public final void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @JvmName(name = "getMaxFailedCount")
    public final Integer getMaxFailedCount() {
        return this.maxFailedCount;
    }

    @JvmName(name = "setMaxFailedCount")
    public final void setMaxFailedCount(Integer num) {
        this.maxFailedCount = num;
    }

    @JvmName(name = "getLockedExpireSeconds")
    public final Integer getLockedExpireSeconds() {
        return this.lockedExpireSeconds;
    }

    @JvmName(name = "setLockedExpireSeconds")
    public final void setLockedExpireSeconds(Integer num) {
        this.lockedExpireSeconds = num;
    }

    @JvmName(name = "getFailedCount")
    public final int getFailedCount() {
        return this.failedCount;
    }

    @JvmName(name = "setFailedCount")
    public final void setFailedCount(int i) {
        this.failedCount = i;
    }

    @JvmName(name = "getVerificationMethods")
    public final List<String> getVerificationMethods() {
        return this.verificationMethods;
    }

    @JvmName(name = "setVerificationMethods")
    public final void setVerificationMethods(List<String> list) {
        this.verificationMethods = list;
    }

    @JvmName(name = "getEvUrlStatus")
    public final EvUrlStatus getEvUrlStatus() {
        return this.evUrlStatus;
    }

    @JvmName(name = "setEvUrlStatus")
    public final void setEvUrlStatus(EvUrlStatus evUrlStatus) {
        this.evUrlStatus = evUrlStatus;
    }

    @JvmName(name = "getLeftTimes")
    public final Integer getLeftTimes() {
        return this.leftTimes;
    }

    @JvmName(name = "setLeftTimes")
    public final void setLeftTimes(Integer num) {
        this.leftTimes = num;
    }

    @JvmName(name = "getPin")
    public final String getPin() {
        return this.pin;
    }

    @JvmName(name = "setPin")
    public final void setPin(String str) {
        this.pin = str;
    }

    @JvmName(name = "getKey")
    public final String getKey() {
        return this.key;
    }

    @JvmName(name = "setKey")
    public final void setKey(String str) {
        this.key = str;
    }

    @JvmName(name = "getKycLevel")
    public final String getKycLevel() {
        return this.kycLevel;
    }

    @JvmName(name = "setKycLevel")
    public final void setKycLevel(String str) {
        this.kycLevel = str;
    }

    @JvmName(name = "getLoginTokenId")
    public final String getLoginTokenId() {
        return this.loginTokenId;
    }

    @JvmName(name = "setLoginTokenId")
    public final void setLoginTokenId(String str) {
        this.loginTokenId = str;
    }

    public LoginResponse(String str, String str2, String str3, Boolean bool, String str4, UserInfo userInfo, Integer num, Integer num2, int i, List<String> list, EvUrlStatus evUrlStatus, Integer num3, String str5, String str6, String str7, String str8) {
        this.userId = str;
        this.sessionId = str2;
        this.clientKey = str3;
        this.isUserInfoCompleted = bool;
        this.securityId = str4;
        this.userInfo = userInfo;
        this.maxFailedCount = num;
        this.lockedExpireSeconds = num2;
        this.failedCount = i;
        this.verificationMethods = list;
        this.evUrlStatus = evUrlStatus;
        this.leftTimes = num3;
        this.pin = str5;
        this.key = str6;
        this.kycLevel = str7;
        this.loginTokenId = str8;
    }
}

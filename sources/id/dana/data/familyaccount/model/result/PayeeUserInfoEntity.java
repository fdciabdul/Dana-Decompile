package id.dana.data.familyaccount.model.result;

import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006"}, d2 = {"Lid/dana/data/familyaccount/model/result/PayeeUserInfoEntity;", "Lid/dana/data/familyaccount/model/result/TransferUserInfoEntity;", "", "avatar", "Ljava/lang/String;", "getAvatar", "()Ljava/lang/String;", "", "certified", "Ljava/lang/Boolean;", "getCertified", "()Ljava/lang/Boolean;", "instId", "getInstId", "instName", "getInstName", WalletConstant.KYC_LEVEL, "getKycLevel", "maskedAccountNo", "getMaskedAccountNo", "maskedNickName", "getMaskedNickName", "nickName", "getNickName", "phoneNumber", "getPhoneNumber", "userId", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayeeUserInfoEntity extends TransferUserInfoEntity {
    private final String avatar;
    private final Boolean certified;
    private final String instId;
    private final String instName;
    private final String kycLevel;
    private final String maskedAccountNo;
    private final String maskedNickName;
    private final String nickName;
    private final String phoneNumber;
    private final String userId;

    public /* synthetic */ PayeeUserInfoEntity(String str, String str2, String str3, Boolean bool, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, bool, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? "" : str8, (i & 512) != 0 ? "" : str9);
    }

    @Override // id.dana.data.familyaccount.model.result.TransferUserInfoEntity
    @JvmName(name = "getKycLevel")
    public final String getKycLevel() {
        return this.kycLevel;
    }

    @Override // id.dana.data.familyaccount.model.result.TransferUserInfoEntity
    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override // id.dana.data.familyaccount.model.result.TransferUserInfoEntity
    @JvmName(name = "getNickName")
    public final String getNickName() {
        return this.nickName;
    }

    @Override // id.dana.data.familyaccount.model.result.TransferUserInfoEntity
    @JvmName(name = "getCertified")
    public final Boolean getCertified() {
        return this.certified;
    }

    @Override // id.dana.data.familyaccount.model.result.TransferUserInfoEntity
    @JvmName(name = "getAvatar")
    public final String getAvatar() {
        return this.avatar;
    }

    @Override // id.dana.data.familyaccount.model.result.TransferUserInfoEntity
    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getInstName")
    public final String getInstName() {
        return this.instName;
    }

    @JvmName(name = "getMaskedNickName")
    public final String getMaskedNickName() {
        return this.maskedNickName;
    }

    @JvmName(name = "getMaskedAccountNo")
    public final String getMaskedAccountNo() {
        return this.maskedAccountNo;
    }

    public PayeeUserInfoEntity(String str, String str2, String str3, Boolean bool, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.kycLevel = str;
        this.phoneNumber = str2;
        this.nickName = str3;
        this.certified = bool;
        this.avatar = str4;
        this.userId = str5;
        this.instId = str6;
        this.instName = str7;
        this.maskedNickName = str8;
        this.maskedAccountNo = str9;
    }
}

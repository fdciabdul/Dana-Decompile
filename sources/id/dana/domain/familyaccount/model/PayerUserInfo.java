package id.dana.domain.familyaccount.model;

import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006"}, d2 = {"Lid/dana/domain/familyaccount/model/PayerUserInfo;", "Lid/dana/domain/familyaccount/model/TransferUserInfo;", "", "avatar", "Ljava/lang/String;", "getAvatar", "()Ljava/lang/String;", "", "certified", "Ljava/lang/Boolean;", "getCertified", "()Ljava/lang/Boolean;", WalletConstant.KYC_LEVEL, "getKycLevel", "nickName", "getNickName", "phoneNumber", "getPhoneNumber", "userId", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayerUserInfo extends TransferUserInfo {
    private final String avatar;
    private final Boolean certified;
    private final String kycLevel;
    private final String nickName;
    private final String phoneNumber;
    private final String userId;

    public /* synthetic */ PayerUserInfo(String str, String str2, String str3, Boolean bool, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, bool, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5);
    }

    @Override // id.dana.domain.familyaccount.model.TransferUserInfo
    @JvmName(name = "getKycLevel")
    public final String getKycLevel() {
        return this.kycLevel;
    }

    @Override // id.dana.domain.familyaccount.model.TransferUserInfo
    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override // id.dana.domain.familyaccount.model.TransferUserInfo
    @JvmName(name = "getNickName")
    public final String getNickName() {
        return this.nickName;
    }

    @Override // id.dana.domain.familyaccount.model.TransferUserInfo
    @JvmName(name = "getCertified")
    public final Boolean getCertified() {
        return this.certified;
    }

    @Override // id.dana.domain.familyaccount.model.TransferUserInfo
    @JvmName(name = "getAvatar")
    public final String getAvatar() {
        return this.avatar;
    }

    @Override // id.dana.domain.familyaccount.model.TransferUserInfo
    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    public PayerUserInfo(String str, String str2, String str3, Boolean bool, String str4, String str5) {
        this.kycLevel = str;
        this.phoneNumber = str2;
        this.nickName = str3;
        this.certified = bool;
        this.avatar = str4;
        this.userId = str5;
    }
}

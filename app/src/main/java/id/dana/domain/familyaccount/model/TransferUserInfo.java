package id.dana.domain.familyaccount.model;

import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004"}, d2 = {"Lid/dana/domain/familyaccount/model/TransferUserInfo;", "", "", "getAvatar", "()Ljava/lang/String;", "avatar", "", "getCertified", "()Ljava/lang/Boolean;", "certified", "getKycLevel", WalletConstant.KYC_LEVEL, "getNickName", "nickName", "getPhoneNumber", "phoneNumber", "getUserId", "userId", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class TransferUserInfo {
    @JvmName(name = "getAvatar")
    public abstract String getAvatar();

    @JvmName(name = "getCertified")
    public abstract Boolean getCertified();

    @JvmName(name = "getKycLevel")
    public abstract String getKycLevel();

    @JvmName(name = "getNickName")
    public abstract String getNickName();

    @JvmName(name = "getPhoneNumber")
    public abstract String getPhoneNumber();

    @JvmName(name = "getUserId")
    public abstract String getUserId();
}

package id.dana.network.response.login;

import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.wallet_v3.constant.WalletConstant;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0004R\u0018\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u0004R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0004R\u0018\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0004"}, d2 = {"Lid/dana/network/response/login/RpcUserInfo;", "Ljava/io/Serializable;", "", AccountEntityRepository.UpdateType.AVATAR, "Ljava/lang/String;", "birthday", "", "certified", "Z", "certifiedLevel", "", "Lid/dana/network/response/login/RpcClassification;", "classifications", "Ljava/util/Map;", "getClassifications", "()Ljava/util/Map;", "setClassifications", "(Ljava/util/Map;)V", "", "emails", "Ljava/util/List;", "firstName", "gender", "job", WalletConstant.KYC_LEVEL, "language", "lastName", "Lid/dana/network/response/login/RpcLoginInfo;", "loginIdInfos", "middleName", "mobileNos", "nationality", "nickname", "Ljava/util/Date;", "registeredTime", "Ljava/util/Date;", "userId", "userStatus", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RpcUserInfo implements Serializable {
    public String avatarUrl;
    public String birthday;
    public boolean certified;
    public String certifiedLevel;
    private Map<String, RpcClassification> classifications;
    public List<String> emails;
    public String firstName;
    public String gender;
    public String job;
    public String kycLevel;
    public String language;
    public String lastName;
    public List<RpcLoginInfo> loginIdInfos;
    public String middleName;
    public List<String> mobileNos;
    public String nationality;
    public String nickname;
    public Date registeredTime;
    public String userId;
    public String userStatus;

    @JvmName(name = "getClassifications")
    public final Map<String, RpcClassification> getClassifications() {
        return this.classifications;
    }

    @JvmName(name = "setClassifications")
    public final void setClassifications(Map<String, RpcClassification> map) {
        this.classifications = map;
    }
}

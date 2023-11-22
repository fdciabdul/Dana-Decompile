package id.dana.data.familyaccount.model.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\b\u00100\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b2\u00103R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010%8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u00178\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010\u001bR\u001c\u0010,\u001a\u0004\u0018\u00010\u00178\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010\u001bR\u001c\u0010.\u001a\u0004\u0018\u00010\u00178\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u001bR\u001c\u00100\u001a\u0004\u0018\u00010\u00178\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u0019\u001a\u0004\b1\u0010\u001b"}, d2 = {"Lid/dana/data/familyaccount/model/result/SummaryResultEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "balanceFamily", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getBalanceFamily", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "chargeAmount", "getChargeAmount", "", "completedTime", "Ljava/lang/Long;", "getCompletedTime", "()Ljava/lang/Long;", "createdTime", "getCreatedTime", "", "enableToClaim", "Ljava/lang/Boolean;", "getEnableToClaim", "()Ljava/lang/Boolean;", "fundAmount", "getFundAmount", "", "fundType", "Ljava/lang/String;", "getFundType", "()Ljava/lang/String;", "paidTime", "getPaidTime", "paidTotalAmount", "getPaidTotalAmount", "Lid/dana/data/familyaccount/model/result/PayeeUserInfoEntity;", "payeeUserInfo", "Lid/dana/data/familyaccount/model/result/PayeeUserInfoEntity;", "getPayeeUserInfo", "()Lid/dana/data/familyaccount/model/result/PayeeUserInfoEntity;", "Lid/dana/data/familyaccount/model/result/PayerUserInfoEntity;", "payerUserInfo", "Lid/dana/data/familyaccount/model/result/PayerUserInfoEntity;", "getPayerUserInfo", "()Lid/dana/data/familyaccount/model/result/PayerUserInfoEntity;", "remarks", "getRemarks", "shareLink", "getShareLink", "status", "getStatus", "token", "getToken", "<init>", "(Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Lid/dana/data/familyaccount/model/result/PayerUserInfoEntity;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/familyaccount/model/result/PayeeUserInfoEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SummaryResultEntity extends BaseRpcResult {
    private final MoneyViewEntity balanceFamily;
    private final MoneyViewEntity chargeAmount;
    private final Long completedTime;
    private final Long createdTime;
    private final Boolean enableToClaim;
    private final MoneyViewEntity fundAmount;
    private final String fundType;
    private final Long paidTime;
    private final MoneyViewEntity paidTotalAmount;
    private final PayeeUserInfoEntity payeeUserInfo;
    private final PayerUserInfoEntity payerUserInfo;
    private final String remarks;
    private final String shareLink;
    private final String status;
    private final String token;

    @JvmName(name = "getFundAmount")
    public final MoneyViewEntity getFundAmount() {
        return this.fundAmount;
    }

    @JvmName(name = "getCompletedTime")
    public final Long getCompletedTime() {
        return this.completedTime;
    }

    @JvmName(name = "getEnableToClaim")
    public final Boolean getEnableToClaim() {
        return this.enableToClaim;
    }

    @JvmName(name = "getPaidTime")
    public final Long getPaidTime() {
        return this.paidTime;
    }

    @JvmName(name = "getPayerUserInfo")
    public final PayerUserInfoEntity getPayerUserInfo() {
        return this.payerUserInfo;
    }

    @JvmName(name = "getToken")
    public final String getToken() {
        return this.token;
    }

    @JvmName(name = "getFundType")
    public final String getFundType() {
        return this.fundType;
    }

    @JvmName(name = "getBalanceFamily")
    public final MoneyViewEntity getBalanceFamily() {
        return this.balanceFamily;
    }

    @JvmName(name = "getCreatedTime")
    public final Long getCreatedTime() {
        return this.createdTime;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getShareLink")
    public final String getShareLink() {
        return this.shareLink;
    }

    @JvmName(name = "getPayeeUserInfo")
    public final PayeeUserInfoEntity getPayeeUserInfo() {
        return this.payeeUserInfo;
    }

    @JvmName(name = "getChargeAmount")
    public final MoneyViewEntity getChargeAmount() {
        return this.chargeAmount;
    }

    @JvmName(name = "getRemarks")
    public final String getRemarks() {
        return this.remarks;
    }

    @JvmName(name = "getPaidTotalAmount")
    public final MoneyViewEntity getPaidTotalAmount() {
        return this.paidTotalAmount;
    }

    public SummaryResultEntity(MoneyViewEntity moneyViewEntity, Long l, Boolean bool, Long l2, PayerUserInfoEntity payerUserInfoEntity, String str, String str2, MoneyViewEntity moneyViewEntity2, Long l3, String str3, String str4, PayeeUserInfoEntity payeeUserInfoEntity, MoneyViewEntity moneyViewEntity3, String str5, MoneyViewEntity moneyViewEntity4) {
        this.fundAmount = moneyViewEntity;
        this.completedTime = l;
        this.enableToClaim = bool;
        this.paidTime = l2;
        this.payerUserInfo = payerUserInfoEntity;
        this.token = str;
        this.fundType = str2;
        this.balanceFamily = moneyViewEntity2;
        this.createdTime = l3;
        this.status = str3;
        this.shareLink = str4;
        this.payeeUserInfo = payeeUserInfoEntity;
        this.chargeAmount = moneyViewEntity3;
        this.remarks = str5;
        this.paidTotalAmount = moneyViewEntity4;
    }
}

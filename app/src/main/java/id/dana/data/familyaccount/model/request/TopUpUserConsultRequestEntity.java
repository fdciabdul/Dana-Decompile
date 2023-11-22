package id.dana.data.familyaccount.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0080\u0001\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010\u0004R\u0017\u0010\u0013\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b,\u0010\u0007R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b.\u0010\u0011R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u00101\u001a\u0004\b2\u0010\n"}, d2 = {"Lid/dana/data/familyaccount/model/request/TopUpUserConsultRequestEntity;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Boolean;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component3", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component4", "component5", "component6", "component7", "", "component8", "()Ljava/util/List;", "component9", "accountType", "needPaymentMethod", "topUpAmount", "clientId", "redirectUrl", "topUpAccount", "expressPayAgreementToken", "payMethodFilter", CashierKeyParams.CASHIER_ORDER_ID, "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lid/dana/data/familyaccount/model/request/TopUpUserConsultRequestEntity;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAccountType", "getCashierOrderId", "getClientId", "getExpressPayAgreementToken", "Ljava/lang/Boolean;", "getNeedPaymentMethod", "Ljava/util/List;", "getPayMethodFilter", "getRedirectUrl", "getTopUpAccount", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getTopUpAmount", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TopUpUserConsultRequestEntity extends BaseRpcRequest {
    private final String accountType;
    private final String cashierOrderId;
    private final String clientId;
    private final String expressPayAgreementToken;
    private final Boolean needPaymentMethod;
    private final List<String> payMethodFilter;
    private final String redirectUrl;
    private final String topUpAccount;
    private final MoneyViewEntity topUpAmount;

    public TopUpUserConsultRequestEntity() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAccountType() {
        return this.accountType;
    }

    /* renamed from: component2  reason: from getter */
    public final Boolean getNeedPaymentMethod() {
        return this.needPaymentMethod;
    }

    /* renamed from: component3  reason: from getter */
    public final MoneyViewEntity getTopUpAmount() {
        return this.topUpAmount;
    }

    /* renamed from: component4  reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    /* renamed from: component6  reason: from getter */
    public final String getTopUpAccount() {
        return this.topUpAccount;
    }

    /* renamed from: component7  reason: from getter */
    public final String getExpressPayAgreementToken() {
        return this.expressPayAgreementToken;
    }

    public final List<String> component8() {
        return this.payMethodFilter;
    }

    /* renamed from: component9  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    public final TopUpUserConsultRequestEntity copy(String accountType, Boolean needPaymentMethod, MoneyViewEntity topUpAmount, String clientId, String redirectUrl, String topUpAccount, String expressPayAgreementToken, List<String> payMethodFilter, String cashierOrderId) {
        Intrinsics.checkNotNullParameter(accountType, "");
        return new TopUpUserConsultRequestEntity(accountType, needPaymentMethod, topUpAmount, clientId, redirectUrl, topUpAccount, expressPayAgreementToken, payMethodFilter, cashierOrderId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TopUpUserConsultRequestEntity) {
            TopUpUserConsultRequestEntity topUpUserConsultRequestEntity = (TopUpUserConsultRequestEntity) other;
            return Intrinsics.areEqual(this.accountType, topUpUserConsultRequestEntity.accountType) && Intrinsics.areEqual(this.needPaymentMethod, topUpUserConsultRequestEntity.needPaymentMethod) && Intrinsics.areEqual(this.topUpAmount, topUpUserConsultRequestEntity.topUpAmount) && Intrinsics.areEqual(this.clientId, topUpUserConsultRequestEntity.clientId) && Intrinsics.areEqual(this.redirectUrl, topUpUserConsultRequestEntity.redirectUrl) && Intrinsics.areEqual(this.topUpAccount, topUpUserConsultRequestEntity.topUpAccount) && Intrinsics.areEqual(this.expressPayAgreementToken, topUpUserConsultRequestEntity.expressPayAgreementToken) && Intrinsics.areEqual(this.payMethodFilter, topUpUserConsultRequestEntity.payMethodFilter) && Intrinsics.areEqual(this.cashierOrderId, topUpUserConsultRequestEntity.cashierOrderId);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.accountType.hashCode();
        Boolean bool = this.needPaymentMethod;
        int hashCode2 = bool == null ? 0 : bool.hashCode();
        MoneyViewEntity moneyViewEntity = this.topUpAmount;
        int hashCode3 = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
        String str = this.clientId;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.redirectUrl;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.topUpAccount;
        int hashCode6 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.expressPayAgreementToken;
        int hashCode7 = str4 == null ? 0 : str4.hashCode();
        List<String> list = this.payMethodFilter;
        int hashCode8 = list == null ? 0 : list.hashCode();
        String str5 = this.cashierOrderId;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpUserConsultRequestEntity(accountType=");
        sb.append(this.accountType);
        sb.append(", needPaymentMethod=");
        sb.append(this.needPaymentMethod);
        sb.append(", topUpAmount=");
        sb.append(this.topUpAmount);
        sb.append(", clientId=");
        sb.append(this.clientId);
        sb.append(", redirectUrl=");
        sb.append(this.redirectUrl);
        sb.append(", topUpAccount=");
        sb.append(this.topUpAccount);
        sb.append(", expressPayAgreementToken=");
        sb.append(this.expressPayAgreementToken);
        sb.append(", payMethodFilter=");
        sb.append(this.payMethodFilter);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ TopUpUserConsultRequestEntity(String str, Boolean bool, MoneyViewEntity moneyViewEntity, String str2, String str3, String str4, String str5, List list, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "SHARED_ACCOUNT" : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : moneyViewEntity, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : list, (i & 256) == 0 ? str6 : null);
    }

    @JvmName(name = "getAccountType")
    public final String getAccountType() {
        return this.accountType;
    }

    @JvmName(name = "getNeedPaymentMethod")
    public final Boolean getNeedPaymentMethod() {
        return this.needPaymentMethod;
    }

    @JvmName(name = "getTopUpAmount")
    public final MoneyViewEntity getTopUpAmount() {
        return this.topUpAmount;
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "getTopUpAccount")
    public final String getTopUpAccount() {
        return this.topUpAccount;
    }

    @JvmName(name = "getExpressPayAgreementToken")
    public final String getExpressPayAgreementToken() {
        return this.expressPayAgreementToken;
    }

    @JvmName(name = "getPayMethodFilter")
    public final List<String> getPayMethodFilter() {
        return this.payMethodFilter;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    public TopUpUserConsultRequestEntity(String str, Boolean bool, MoneyViewEntity moneyViewEntity, String str2, String str3, String str4, String str5, List<String> list, String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        this.accountType = str;
        this.needPaymentMethod = bool;
        this.topUpAmount = moneyViewEntity;
        this.clientId = str2;
        this.redirectUrl = str3;
        this.topUpAccount = str4;
        this.expressPayAgreementToken = str5;
        this.payMethodFilter = list;
        this.cashierOrderId = str6;
    }
}

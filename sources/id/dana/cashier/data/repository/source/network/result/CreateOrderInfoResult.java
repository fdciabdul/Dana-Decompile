package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b%\u0010&J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004Jd\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b!\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b$\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/CreateOrderInfoResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "config", "memo", "acquirementId", "checkoutUrl", "merchantTransId", "networkScenarioType", "transactionScenario", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/result/CreateOrderInfoResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAcquirementId", "getCheckoutUrl", "getConfig", "getMemo", "getMerchantTransId", "getNetworkScenarioType", "getTransactionScenario", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CreateOrderInfoResult extends BaseRpcResultAphome {
    private final String acquirementId;
    private final String checkoutUrl;
    @SerializedName("config")
    private final String config;
    private final String memo;
    private final String merchantTransId;
    private final String networkScenarioType;
    private final String transactionScenario;

    public static /* synthetic */ CreateOrderInfoResult copy$default(CreateOrderInfoResult createOrderInfoResult, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createOrderInfoResult.config;
        }
        if ((i & 2) != 0) {
            str2 = createOrderInfoResult.memo;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = createOrderInfoResult.acquirementId;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = createOrderInfoResult.checkoutUrl;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = createOrderInfoResult.merchantTransId;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = createOrderInfoResult.networkScenarioType;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = createOrderInfoResult.transactionScenario;
        }
        return createOrderInfoResult.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1  reason: from getter */
    public final String getConfig() {
        return this.config;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMemo() {
        return this.memo;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAcquirementId() {
        return this.acquirementId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    /* renamed from: component5  reason: from getter */
    public final String getMerchantTransId() {
        return this.merchantTransId;
    }

    /* renamed from: component6  reason: from getter */
    public final String getNetworkScenarioType() {
        return this.networkScenarioType;
    }

    /* renamed from: component7  reason: from getter */
    public final String getTransactionScenario() {
        return this.transactionScenario;
    }

    public final CreateOrderInfoResult copy(String config, String memo, String acquirementId, String checkoutUrl, String merchantTransId, String networkScenarioType, String transactionScenario) {
        return new CreateOrderInfoResult(config, memo, acquirementId, checkoutUrl, merchantTransId, networkScenarioType, transactionScenario);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CreateOrderInfoResult) {
            CreateOrderInfoResult createOrderInfoResult = (CreateOrderInfoResult) other;
            return Intrinsics.areEqual(this.config, createOrderInfoResult.config) && Intrinsics.areEqual(this.memo, createOrderInfoResult.memo) && Intrinsics.areEqual(this.acquirementId, createOrderInfoResult.acquirementId) && Intrinsics.areEqual(this.checkoutUrl, createOrderInfoResult.checkoutUrl) && Intrinsics.areEqual(this.merchantTransId, createOrderInfoResult.merchantTransId) && Intrinsics.areEqual(this.networkScenarioType, createOrderInfoResult.networkScenarioType) && Intrinsics.areEqual(this.transactionScenario, createOrderInfoResult.transactionScenario);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.config;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.memo;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.acquirementId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.checkoutUrl;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.merchantTransId;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.networkScenarioType;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.transactionScenario;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateOrderInfoResult(config=");
        sb.append(this.config);
        sb.append(", memo=");
        sb.append(this.memo);
        sb.append(", acquirementId=");
        sb.append(this.acquirementId);
        sb.append(", checkoutUrl=");
        sb.append(this.checkoutUrl);
        sb.append(", merchantTransId=");
        sb.append(this.merchantTransId);
        sb.append(", networkScenarioType=");
        sb.append(this.networkScenarioType);
        sb.append(", transactionScenario=");
        sb.append(this.transactionScenario);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getConfig")
    public final String getConfig() {
        return this.config;
    }

    @JvmName(name = "getMemo")
    public final String getMemo() {
        return this.memo;
    }

    @JvmName(name = "getAcquirementId")
    public final String getAcquirementId() {
        return this.acquirementId;
    }

    @JvmName(name = "getCheckoutUrl")
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    @JvmName(name = "getMerchantTransId")
    public final String getMerchantTransId() {
        return this.merchantTransId;
    }

    @JvmName(name = "getNetworkScenarioType")
    public final String getNetworkScenarioType() {
        return this.networkScenarioType;
    }

    @JvmName(name = "getTransactionScenario")
    public final String getTransactionScenario() {
        return this.transactionScenario;
    }

    public CreateOrderInfoResult(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.config = str;
        this.memo = str2;
        this.acquirementId = str3;
        this.checkoutUrl = str4;
        this.merchantTransId = str5;
        this.networkScenarioType = str6;
        this.transactionScenario = str7;
    }
}

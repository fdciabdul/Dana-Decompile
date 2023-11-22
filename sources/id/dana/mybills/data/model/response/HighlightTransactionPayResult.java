package id.dana.mybills.data.model.response;

import com.google.gson.annotations.SerializedName;
import id.dana.danah5.transactionstatus.TransactionStatusBridge;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B/\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006"}, d2 = {"Lid/dana/mybills/data/model/response/HighlightTransactionPayResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "checkoutUrl", "Ljava/lang/String;", "getCheckoutUrl", "()Ljava/lang/String;", "location", "getLocation", "subscriptionId", "getSubscriptionId", TransactionStatusBridge.Companion.TransactionStatusParamKey.TRANSACTION_ID, "getTransactionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HighlightTransactionPayResult extends BaseRpcResultAphome {
    private final String checkoutUrl;
    private final String location;
    private final String subscriptionId;
    @SerializedName(BranchLinkConstant.PushVerifyParams.TRANSACTION_ID)
    private final String transactionId;

    @JvmName(name = "getSubscriptionId")
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @JvmName(name = "getTransactionId")
    public final String getTransactionId() {
        return this.transactionId;
    }

    @JvmName(name = "getCheckoutUrl")
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    @JvmName(name = "getLocation")
    public final String getLocation() {
        return this.location;
    }

    public HighlightTransactionPayResult(String str, String str2, String str3, String str4) {
        this.subscriptionId = str;
        this.transactionId = str2;
        this.checkoutUrl = str3;
        this.location = str4;
    }
}

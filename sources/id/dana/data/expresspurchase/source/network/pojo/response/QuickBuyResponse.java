package id.dana.data.expresspurchase.source.network.pojo.response;

import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/QuickBuyResponse;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "acquirementId", "Ljava/lang/String;", "getAcquirementId", "()Ljava/lang/String;", "billId", "getBillId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QuickBuyResponse extends BaseRpcResultAphome {
    private final String acquirementId;
    @SerializedName("billId")
    private final String billId;

    @JvmName(name = "getBillId")
    public final String getBillId() {
        return this.billId;
    }

    @JvmName(name = "getAcquirementId")
    public final String getAcquirementId() {
        return this.acquirementId;
    }

    public QuickBuyResponse(String str, String str2) {
        this.billId = str;
        this.acquirementId = str2;
    }
}

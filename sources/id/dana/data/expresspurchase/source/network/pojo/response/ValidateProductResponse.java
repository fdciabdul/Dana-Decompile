package id.dana.data.expresspurchase.source.network.pojo.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/ValidateProductResponse;", "Lid/dana/data/expresspurchase/source/network/pojo/response/ValidateProductQuickResponse;", "", "aggregatorGoodsId", "Ljava/lang/String;", "getAggregatorGoodsId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ValidateProductResponse extends ValidateProductQuickResponse {
    @SerializedName("aggregatorGoodsId")
    private final String aggregatorGoodsId;

    @JvmName(name = "getAggregatorGoodsId")
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    public ValidateProductResponse(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.aggregatorGoodsId = str;
    }
}

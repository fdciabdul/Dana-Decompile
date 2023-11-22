package id.dana.data.expresspurchase.source.network.pojo.request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/request/ValidateProductRequest;", "Lid/dana/data/expresspurchase/source/network/pojo/request/ValidateProductQuickRequest;", "", "aggregatorId", "Ljava/lang/String;", "getAggregatorId", "()Ljava/lang/String;", "bizOrderId", "getBizOrderId", "finType", "getFinType", "merchantTransId", "getMerchantTransId", "goodsId", "aggregatorGoodsId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ValidateProductRequest extends ValidateProductQuickRequest {
    @SerializedName("aggregatorId")
    private final String aggregatorId;
    private final String bizOrderId;
    private final String finType;
    private final String merchantTransId;

    public /* synthetic */ ValidateProductRequest(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, str5, str6);
    }

    @JvmName(name = "getAggregatorId")
    public final String getAggregatorId() {
        return this.aggregatorId;
    }

    @JvmName(name = "getFinType")
    public final String getFinType() {
        return this.finType;
    }

    @JvmName(name = "getBizOrderId")
    public final String getBizOrderId() {
        return this.bizOrderId;
    }

    @JvmName(name = "getMerchantTransId")
    public final String getMerchantTransId() {
        return this.merchantTransId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValidateProductRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        super(str, str3);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.aggregatorId = str2;
        this.finType = str4;
        this.bizOrderId = str5;
        this.merchantTransId = str6;
    }
}

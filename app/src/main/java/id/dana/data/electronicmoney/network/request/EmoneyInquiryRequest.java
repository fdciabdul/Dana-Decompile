package id.dana.data.electronicmoney.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/electronicmoney/network/request/EmoneyInquiryRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "cardProvider", "Ljava/lang/String;", "getCardProvider", "()Ljava/lang/String;", "", "data", "Ljava/util/Map;", "getData", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class EmoneyInquiryRequest extends BaseRpcRequest {
    private final String cardProvider;
    private final Map<String, String> data;

    @JvmName(name = "getCardProvider")
    public final String getCardProvider() {
        return this.cardProvider;
    }

    @JvmName(name = "getData")
    public final Map<String, String> getData() {
        return this.data;
    }

    public EmoneyInquiryRequest(String str, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.cardProvider = str;
        this.data = map;
    }
}

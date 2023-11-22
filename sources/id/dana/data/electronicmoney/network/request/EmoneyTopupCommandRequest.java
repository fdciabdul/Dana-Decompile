package id.dana.data.electronicmoney.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/electronicmoney/network/request/EmoneyTopupCommandRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "cardProvider", "Ljava/lang/String;", "getCardProvider", "()Ljava/lang/String;", "cardType", "getCardType", "", "data", "Ljava/util/Map;", "getData", "()Ljava/util/Map;", "", "reversal", "Ljava/lang/Boolean;", "getReversal", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class EmoneyTopupCommandRequest extends BaseRpcRequest {
    private final String cardProvider;
    private final String cardType;
    private final Map<String, String> data;
    private final Boolean reversal;

    @JvmName(name = "getCardType")
    public final String getCardType() {
        return this.cardType;
    }

    @JvmName(name = "getCardProvider")
    public final String getCardProvider() {
        return this.cardProvider;
    }

    public /* synthetic */ EmoneyTopupCommandRequest(String str, String str2, Boolean bool, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? Boolean.FALSE : bool, map);
    }

    @JvmName(name = "getReversal")
    public final Boolean getReversal() {
        return this.reversal;
    }

    @JvmName(name = "getData")
    public final Map<String, String> getData() {
        return this.data;
    }

    public EmoneyTopupCommandRequest(String str, String str2, Boolean bool, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.cardType = str;
        this.cardProvider = str2;
        this.reversal = bool;
        this.data = map;
    }
}

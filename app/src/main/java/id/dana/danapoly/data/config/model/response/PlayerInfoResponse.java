package id.dana.danapoly.data.config.model.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/danapoly/data/config/model/response/PlayerInfoResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "danaPoints", "Ljava/lang/Integer;", "getDanaPoints", "()Ljava/lang/Integer;", "position", "getPosition", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayerInfoResponse extends BaseRpcResult {
    private final Integer danaPoints;
    private final Integer position;

    @JvmName(name = "getDanaPoints")
    public final Integer getDanaPoints() {
        return this.danaPoints;
    }

    @JvmName(name = "getPosition")
    public final Integer getPosition() {
        return this.position;
    }

    public PlayerInfoResponse(Integer num, Integer num2) {
        this.danaPoints = num;
        this.position = num2;
    }
}

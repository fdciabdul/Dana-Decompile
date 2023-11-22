package id.dana.data.electronicmoney.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/data/electronicmoney/network/response/EmoneyCardInfoResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/data/electronicmoney/network/response/EmoneyDataEntity;", "component1", "()Lid/dana/data/electronicmoney/network/response/EmoneyDataEntity;", "data", "copy", "(Lid/dana/data/electronicmoney/network/response/EmoneyDataEntity;)Lid/dana/data/electronicmoney/network/response/EmoneyCardInfoResponse;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/data/electronicmoney/network/response/EmoneyDataEntity;", "getData", "<init>", "(Lid/dana/data/electronicmoney/network/response/EmoneyDataEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class EmoneyCardInfoResponse extends BaseRpcResult {
    private final EmoneyDataEntity data;

    public static /* synthetic */ EmoneyCardInfoResponse copy$default(EmoneyCardInfoResponse emoneyCardInfoResponse, EmoneyDataEntity emoneyDataEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            emoneyDataEntity = emoneyCardInfoResponse.data;
        }
        return emoneyCardInfoResponse.copy(emoneyDataEntity);
    }

    /* renamed from: component1  reason: from getter */
    public final EmoneyDataEntity getData() {
        return this.data;
    }

    public final EmoneyCardInfoResponse copy(EmoneyDataEntity data) {
        return new EmoneyCardInfoResponse(data);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof EmoneyCardInfoResponse) && Intrinsics.areEqual(this.data, ((EmoneyCardInfoResponse) other).data);
    }

    public final int hashCode() {
        EmoneyDataEntity emoneyDataEntity = this.data;
        if (emoneyDataEntity == null) {
            return 0;
        }
        return emoneyDataEntity.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmoneyCardInfoResponse(data=");
        sb.append(this.data);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getData")
    public final EmoneyDataEntity getData() {
        return this.data;
    }

    public EmoneyCardInfoResponse(EmoneyDataEntity emoneyDataEntity) {
        this.data = emoneyDataEntity;
    }
}

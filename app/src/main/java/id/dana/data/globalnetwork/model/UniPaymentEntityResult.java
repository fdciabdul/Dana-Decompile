package id.dana.data.globalnetwork.model;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004R\"\u0010\u0005\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/data/globalnetwork/model/UniPaymentEntityResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "bizModelsJsonStr", "copy", "(Ljava/lang/String;)Lid/dana/data/globalnetwork/model/UniPaymentEntityResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizModelsJsonStr", "setBizModelsJsonStr", "(Ljava/lang/String;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UniPaymentEntityResult extends BaseRpcResult {
    private String bizModelsJsonStr;

    public static /* synthetic */ UniPaymentEntityResult copy$default(UniPaymentEntityResult uniPaymentEntityResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uniPaymentEntityResult.bizModelsJsonStr;
        }
        return uniPaymentEntityResult.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBizModelsJsonStr() {
        return this.bizModelsJsonStr;
    }

    public final UniPaymentEntityResult copy(String bizModelsJsonStr) {
        Intrinsics.checkNotNullParameter(bizModelsJsonStr, "");
        return new UniPaymentEntityResult(bizModelsJsonStr);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UniPaymentEntityResult) && Intrinsics.areEqual(this.bizModelsJsonStr, ((UniPaymentEntityResult) other).bizModelsJsonStr);
    }

    public final int hashCode() {
        return this.bizModelsJsonStr.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UniPaymentEntityResult(bizModelsJsonStr=");
        sb.append(this.bizModelsJsonStr);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getBizModelsJsonStr")
    public final String getBizModelsJsonStr() {
        return this.bizModelsJsonStr;
    }

    @JvmName(name = "setBizModelsJsonStr")
    public final void setBizModelsJsonStr(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.bizModelsJsonStr = str;
    }

    public UniPaymentEntityResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.bizModelsJsonStr = str;
    }
}

package id.dana.cardbinding.data.model;

import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/data/model/BindingCardAddResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/String;", "component2", "bizType", "checkoutUrl", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/cardbinding/data/model/BindingCardAddResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizType", "getCheckoutUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BindingCardAddResult extends BaseRpcResultAphome {
    private final String bizType;
    private final String checkoutUrl;

    public static /* synthetic */ BindingCardAddResult copy$default(BindingCardAddResult bindingCardAddResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bindingCardAddResult.bizType;
        }
        if ((i & 2) != 0) {
            str2 = bindingCardAddResult.checkoutUrl;
        }
        return bindingCardAddResult.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    public final BindingCardAddResult copy(String bizType, String checkoutUrl) {
        return new BindingCardAddResult(bizType, checkoutUrl);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BindingCardAddResult) {
            BindingCardAddResult bindingCardAddResult = (BindingCardAddResult) other;
            return Intrinsics.areEqual(this.bizType, bindingCardAddResult.bizType) && Intrinsics.areEqual(this.checkoutUrl, bindingCardAddResult.checkoutUrl);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.bizType;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.checkoutUrl;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BindingCardAddResult(bizType=");
        sb.append(this.bizType);
        sb.append(", checkoutUrl=");
        sb.append(this.checkoutUrl);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getCheckoutUrl")
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    public BindingCardAddResult(String str, String str2) {
        this.bizType = str;
        this.checkoutUrl = str2;
    }
}

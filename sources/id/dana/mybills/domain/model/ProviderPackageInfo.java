package id.dana.mybills.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0014\u0010\bR\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b"}, d2 = {"Lid/dana/mybills/domain/model/ProviderPackageInfo;", "", "", "Lid/dana/mybills/domain/model/ProductGoodsInfo;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "goods", "type", "copy", "(Ljava/util/List;Ljava/lang/String;)Lid/dana/mybills/domain/model/ProviderPackageInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/List;", "getGoods", "Ljava/lang/String;", "getType", "<init>", "(Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ProviderPackageInfo {
    private final List<ProductGoodsInfo> goods;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProviderPackageInfo copy$default(ProviderPackageInfo providerPackageInfo, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = providerPackageInfo.goods;
        }
        if ((i & 2) != 0) {
            str = providerPackageInfo.type;
        }
        return providerPackageInfo.copy(list, str);
    }

    public final List<ProductGoodsInfo> component1() {
        return this.goods;
    }

    /* renamed from: component2  reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final ProviderPackageInfo copy(List<ProductGoodsInfo> goods, String type) {
        return new ProviderPackageInfo(goods, type);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ProviderPackageInfo) {
            ProviderPackageInfo providerPackageInfo = (ProviderPackageInfo) other;
            return Intrinsics.areEqual(this.goods, providerPackageInfo.goods) && Intrinsics.areEqual(this.type, providerPackageInfo.type);
        }
        return false;
    }

    public final int hashCode() {
        List<ProductGoodsInfo> list = this.goods;
        int hashCode = list == null ? 0 : list.hashCode();
        String str = this.type;
        return (hashCode * 31) + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProviderPackageInfo(goods=");
        sb.append(this.goods);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(')');
        return sb.toString();
    }

    public ProviderPackageInfo(List<ProductGoodsInfo> list, String str) {
        this.goods = list;
        this.type = str;
    }

    @JvmName(name = "getGoods")
    public final List<ProductGoodsInfo> getGoods() {
        return this.goods;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }
}

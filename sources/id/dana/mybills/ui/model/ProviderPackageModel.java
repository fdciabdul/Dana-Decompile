package id.dana.mybills.ui.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0014\u0010\bR\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b"}, d2 = {"Lid/dana/mybills/ui/model/ProviderPackageModel;", "", "", "Lid/dana/mybills/ui/model/ProductGoodsModel;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "goods", "type", "copy", "(Ljava/util/List;Ljava/lang/String;)Lid/dana/mybills/ui/model/ProviderPackageModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/List;", "getGoods", "Ljava/lang/String;", "getType", "<init>", "(Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ProviderPackageModel {
    private final List<ProductGoodsModel> goods;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProviderPackageModel copy$default(ProviderPackageModel providerPackageModel, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = providerPackageModel.goods;
        }
        if ((i & 2) != 0) {
            str = providerPackageModel.type;
        }
        return providerPackageModel.copy(list, str);
    }

    public final List<ProductGoodsModel> component1() {
        return this.goods;
    }

    /* renamed from: component2  reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final ProviderPackageModel copy(List<ProductGoodsModel> goods, String type) {
        return new ProviderPackageModel(goods, type);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ProviderPackageModel) {
            ProviderPackageModel providerPackageModel = (ProviderPackageModel) other;
            return Intrinsics.areEqual(this.goods, providerPackageModel.goods) && Intrinsics.areEqual(this.type, providerPackageModel.type);
        }
        return false;
    }

    public final int hashCode() {
        List<ProductGoodsModel> list = this.goods;
        int hashCode = list == null ? 0 : list.hashCode();
        String str = this.type;
        return (hashCode * 31) + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProviderPackageModel(goods=");
        sb.append(this.goods);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(')');
        return sb.toString();
    }

    public ProviderPackageModel(List<ProductGoodsModel> list, String str) {
        this.goods = list;
        this.type = str;
    }

    @JvmName(name = "getGoods")
    public final List<ProductGoodsModel> getGoods() {
        return this.goods;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }
}

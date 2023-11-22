package id.dana.mybills.data.model.response;

import id.dana.network.base.BaseRpcResultAphome;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u000b"}, d2 = {"Lid/dana/mybills/data/model/response/GeneralProductResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/String;", "", "Lid/dana/mybills/data/model/response/ProductGoodsResult;", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/Boolean;", "aboutUrl", "goods", "hasNext", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)Lid/dana/mybills/data/model/response/GeneralProductResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAboutUrl", "Ljava/util/List;", "getGoods", "Ljava/lang/Boolean;", "getHasNext", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GeneralProductResult extends BaseRpcResultAphome {
    private final String aboutUrl;
    private final List<ProductGoodsResult> goods;
    private final Boolean hasNext;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GeneralProductResult copy$default(GeneralProductResult generalProductResult, String str, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = generalProductResult.aboutUrl;
        }
        if ((i & 2) != 0) {
            list = generalProductResult.goods;
        }
        if ((i & 4) != 0) {
            bool = generalProductResult.hasNext;
        }
        return generalProductResult.copy(str, list, bool);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAboutUrl() {
        return this.aboutUrl;
    }

    public final List<ProductGoodsResult> component2() {
        return this.goods;
    }

    /* renamed from: component3  reason: from getter */
    public final Boolean getHasNext() {
        return this.hasNext;
    }

    public final GeneralProductResult copy(String aboutUrl, List<ProductGoodsResult> goods, Boolean hasNext) {
        return new GeneralProductResult(aboutUrl, goods, hasNext);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GeneralProductResult) {
            GeneralProductResult generalProductResult = (GeneralProductResult) other;
            return Intrinsics.areEqual(this.aboutUrl, generalProductResult.aboutUrl) && Intrinsics.areEqual(this.goods, generalProductResult.goods) && Intrinsics.areEqual(this.hasNext, generalProductResult.hasNext);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.aboutUrl;
        int hashCode = str == null ? 0 : str.hashCode();
        List<ProductGoodsResult> list = this.goods;
        int hashCode2 = list == null ? 0 : list.hashCode();
        Boolean bool = this.hasNext;
        return (((hashCode * 31) + hashCode2) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeneralProductResult(aboutUrl=");
        sb.append(this.aboutUrl);
        sb.append(", goods=");
        sb.append(this.goods);
        sb.append(", hasNext=");
        sb.append(this.hasNext);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getAboutUrl")
    public final String getAboutUrl() {
        return this.aboutUrl;
    }

    @JvmName(name = "getGoods")
    public final List<ProductGoodsResult> getGoods() {
        return this.goods;
    }

    @JvmName(name = "getHasNext")
    public final Boolean getHasNext() {
        return this.hasNext;
    }

    public GeneralProductResult(String str, List<ProductGoodsResult> list, Boolean bool) {
        this.aboutUrl = str;
        this.goods = list;
        this.hasNext = bool;
    }
}

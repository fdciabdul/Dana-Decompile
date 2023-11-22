package id.dana.mybills.domain.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u000b"}, d2 = {"Lid/dana/mybills/domain/model/GeneralProductModel;", "", "", "component1", "()Ljava/lang/String;", "", "Lid/dana/mybills/domain/model/ProductGoodsInfo;", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/Boolean;", "aboutUrl", "goods", "hasNext", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)Lid/dana/mybills/domain/model/GeneralProductModel;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAboutUrl", "Ljava/util/List;", "getGoods", "Ljava/lang/Boolean;", "getHasNext", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GeneralProductModel {
    private final String aboutUrl;
    private final List<ProductGoodsInfo> goods;
    private final Boolean hasNext;

    public GeneralProductModel() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GeneralProductModel copy$default(GeneralProductModel generalProductModel, String str, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = generalProductModel.aboutUrl;
        }
        if ((i & 2) != 0) {
            list = generalProductModel.goods;
        }
        if ((i & 4) != 0) {
            bool = generalProductModel.hasNext;
        }
        return generalProductModel.copy(str, list, bool);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAboutUrl() {
        return this.aboutUrl;
    }

    public final List<ProductGoodsInfo> component2() {
        return this.goods;
    }

    /* renamed from: component3  reason: from getter */
    public final Boolean getHasNext() {
        return this.hasNext;
    }

    public final GeneralProductModel copy(String aboutUrl, List<ProductGoodsInfo> goods, Boolean hasNext) {
        return new GeneralProductModel(aboutUrl, goods, hasNext);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GeneralProductModel) {
            GeneralProductModel generalProductModel = (GeneralProductModel) other;
            return Intrinsics.areEqual(this.aboutUrl, generalProductModel.aboutUrl) && Intrinsics.areEqual(this.goods, generalProductModel.goods) && Intrinsics.areEqual(this.hasNext, generalProductModel.hasNext);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.aboutUrl;
        int hashCode = str == null ? 0 : str.hashCode();
        List<ProductGoodsInfo> list = this.goods;
        int hashCode2 = list == null ? 0 : list.hashCode();
        Boolean bool = this.hasNext;
        return (((hashCode * 31) + hashCode2) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeneralProductModel(aboutUrl=");
        sb.append(this.aboutUrl);
        sb.append(", goods=");
        sb.append(this.goods);
        sb.append(", hasNext=");
        sb.append(this.hasNext);
        sb.append(')');
        return sb.toString();
    }

    public GeneralProductModel(String str, List<ProductGoodsInfo> list, Boolean bool) {
        this.aboutUrl = str;
        this.goods = list;
        this.hasNext = bool;
    }

    @JvmName(name = "getAboutUrl")
    public final String getAboutUrl() {
        return this.aboutUrl;
    }

    public /* synthetic */ GeneralProductModel(String str, ArrayList arrayList, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? new ArrayList() : arrayList, (i & 4) != 0 ? Boolean.FALSE : bool);
    }

    @JvmName(name = "getGoods")
    public final List<ProductGoodsInfo> getGoods() {
        return this.goods;
    }

    @JvmName(name = "getHasNext")
    public final Boolean getHasNext() {
        return this.hasNext;
    }
}

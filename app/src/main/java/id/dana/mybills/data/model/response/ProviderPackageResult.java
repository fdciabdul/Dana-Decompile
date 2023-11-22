package id.dana.mybills.data.model.response;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eR\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/mybills/data/model/response/ProviderPackageResult;", "", "", "Lid/dana/mybills/data/model/response/ProductGoodsResult;", "goods", "Ljava/util/List;", "getGoods", "()Ljava/util/List;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "<init>", "(Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProviderPackageResult {
    private final List<ProductGoodsResult> goods;
    private final String type;

    public ProviderPackageResult(List<ProductGoodsResult> list, String str) {
        this.goods = list;
        this.type = str;
    }

    @JvmName(name = "getGoods")
    public final List<ProductGoodsResult> getGoods() {
        return this.goods;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }
}

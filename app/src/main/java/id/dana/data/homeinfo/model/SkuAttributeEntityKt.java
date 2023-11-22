package id.dana.data.homeinfo.model;

import id.dana.domain.homeinfo.SkuAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/homeinfo/model/SkuAttributeEntity;", "Lid/dana/domain/homeinfo/SkuAttribute;", "toSkuAttribute", "(Lid/dana/data/homeinfo/model/SkuAttributeEntity;)Lid/dana/domain/homeinfo/SkuAttribute;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SkuAttributeEntityKt {
    public static final SkuAttribute toSkuAttribute(SkuAttributeEntity skuAttributeEntity) {
        Intrinsics.checkNotNullParameter(skuAttributeEntity, "");
        return new SkuAttribute(skuAttributeEntity.getServiceKey(), skuAttributeEntity.getPrepaidKey(), skuAttributeEntity.getPostpaidKey(), skuAttributeEntity.getBackgroundColor(), skuAttributeEntity.getTitle(), skuAttributeEntity.getIcon(), skuAttributeEntity.getButtonDescription(), skuAttributeEntity.getServiceName(), null, null, skuAttributeEntity.getLink(), null, 2816, null);
    }
}

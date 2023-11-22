package id.dana.model;

import id.dana.domain.homeinfo.SkuAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/homeinfo/SkuAttribute;", "Lid/dana/model/SkuAttributeModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/homeinfo/SkuAttribute;)Lid/dana/model/SkuAttributeModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SkuAttributeModelKt {
    public static final SkuAttributeModel KClassImpl$Data$declaredNonStaticMembers$2(SkuAttribute skuAttribute) {
        Intrinsics.checkNotNullParameter(skuAttribute, "");
        return new SkuAttributeModel(skuAttribute.getServiceKey(), skuAttribute.getPrepaidKey(), skuAttribute.getPostpaidKey(), skuAttribute.getBackgroundColor(), skuAttribute.getTitle(), skuAttribute.getIcon(), skuAttribute.getButtonDescription(), skuAttribute.getServiceName());
    }
}

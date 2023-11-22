package id.dana.promocenter.mapper;

import id.dana.domain.promocenter.model.Promo;
import id.dana.promocenter.model.PromoModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/promocenter/mapper/PromoAdsModelMapper;", "", "", "Lid/dana/domain/promocenter/model/Promo;", "p0", "Lid/dana/promocenter/model/PromoModel;", "getAuthRequestContext", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoAdsModelMapper {
    @Inject
    public PromoAdsModelMapper() {
    }

    public static List<PromoModel> getAuthRequestContext(List<? extends Promo> p0) {
        ArrayList arrayList = null;
        if (p0 != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Promo promo : p0) {
                PromoModel KClassImpl$Data$declaredNonStaticMembers$2 = promo != null ? PromoAdsModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(promo) : null;
                if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    arrayList2.add(KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
            arrayList = arrayList2;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }
}

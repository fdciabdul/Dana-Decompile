package id.dana.promocenter.mapper;

import id.dana.domain.promocenter.model.Promo;
import id.dana.domain.promocenter.model.PromoResult;
import id.dana.promocenter.model.PromoResultModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/domain/promocenter/model/PromoResult;", "p0", "Lid/dana/promocenter/model/PromoResultModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/promocenter/model/PromoResult;Lid/dana/domain/promocenter/model/PromoResult;)Lid/dana/promocenter/model/PromoResultModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoModelExtensionKt {
    public static final PromoResultModel BuiltInFictitiousFunctionClassFactory(PromoResult promoResult, PromoResult promoResult2) {
        ArrayList arrayList;
        List<Promo> promoList;
        Intrinsics.checkNotNullParameter(promoResult, "");
        PromoResultModel promoResultModel = new PromoResultModel();
        promoResultModel.PlaceComponentResult = promoResult2 != null ? promoResult2.isHasMore() : true;
        if (promoResult2 == null || (promoList = promoResult2.getPromoList()) == null) {
            arrayList = null;
        } else {
            List<Promo> list = promoList;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(PromoAdsModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2((Promo) it.next()));
            }
            arrayList = arrayList2;
        }
        promoResultModel.KClassImpl$Data$declaredNonStaticMembers$2 = arrayList;
        return promoResultModel;
    }
}

package id.dana.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.nearbyme.model.MerchantConsult;
import id.dana.domain.nearbyme.model.Tag;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.nearbyme.model.ShopModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/nearbyme/mapper/MerchantConsultReviewMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/nearbyme/model/MerchantConsult;", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "Lid/dana/nearbyme/mapper/MerchantReviewTagMapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/mapper/MerchantReviewTagMapper;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/mapper/ShopMapper;", "PlaceComponentResult", "Lid/dana/nearbyme/mapper/ShopMapper;", "p0", "p1", "<init>", "(Lid/dana/nearbyme/mapper/ShopMapper;Lid/dana/nearbyme/mapper/MerchantReviewTagMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantConsultReviewMapper extends BaseMapper<MerchantConsult, MerchantConsultReviewModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final MerchantReviewTagMapper MyBillsEntityDataFactory;
    private final ShopMapper PlaceComponentResult;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ MerchantConsultReviewModel map(MerchantConsult merchantConsult) {
        MerchantConsult merchantConsult2 = merchantConsult;
        Intrinsics.checkNotNullParameter(merchantConsult2, "");
        ShopModel apply = this.PlaceComponentResult.apply(merchantConsult2.getReviewableShop());
        Intrinsics.checkNotNullExpressionValue(apply, "");
        ShopModel shopModel = apply;
        List<Tag> positiveTags = merchantConsult2.getPositiveTags();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(positiveTags, 10));
        Iterator<T> it = positiveTags.iterator();
        while (it.hasNext()) {
            arrayList.add(this.MyBillsEntityDataFactory.apply((Tag) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        List<Tag> negativeSentiments = merchantConsult2.getNegativeSentiments();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(negativeSentiments, 10));
        Iterator<T> it2 = negativeSentiments.iterator();
        while (it2.hasNext()) {
            arrayList3.add(this.MyBillsEntityDataFactory.apply((Tag) it2.next()));
        }
        ArrayList arrayList4 = arrayList3;
        String merchantId = merchantConsult2.getReviewableShop().getMerchantId();
        return new MerchantConsultReviewModel(shopModel, arrayList2, arrayList4, "", merchantId == null ? "" : merchantId, 0);
    }

    @Inject
    public MerchantConsultReviewMapper(ShopMapper shopMapper, MerchantReviewTagMapper merchantReviewTagMapper) {
        Intrinsics.checkNotNullParameter(shopMapper, "");
        Intrinsics.checkNotNullParameter(merchantReviewTagMapper, "");
        this.PlaceComponentResult = shopMapper;
        this.MyBillsEntityDataFactory = merchantReviewTagMapper;
    }
}

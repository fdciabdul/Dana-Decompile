package id.dana.mapper;

import id.dana.domain.promotion.model.Banner;
import id.dana.domain.promotion.model.BannerCollection;
import id.dana.model.CdpContentModel;
import id.dana.model.PromotionModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/promotion/model/BannerCollection;", "Lid/dana/model/PromotionModel;", "getAuthRequestContext", "(Lid/dana/domain/promotion/model/BannerCollection;)Lid/dana/model/PromotionModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BannerModelMapperKt {
    public static final PromotionModel getAuthRequestContext(BannerCollection bannerCollection) {
        Intrinsics.checkNotNullParameter(bannerCollection, "");
        PromotionModel promotionModel = new PromotionModel();
        promotionModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = bannerCollection.getSpaceCode();
        promotionModel.GetContactSyncConfig = bannerCollection.getSpaceName();
        promotionModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = bannerCollection.getSpaceType();
        List<Banner> contents = bannerCollection.getContents();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(contents, 10));
        for (Banner banner : contents) {
            Intrinsics.checkNotNullParameter(banner, "");
            CdpContentModel cdpContentModel = new CdpContentModel();
            cdpContentModel.initRecordTimeStamp = banner.getBizType();
            cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = banner.getContentId();
            cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = banner.getContentName();
            cdpContentModel.GetContactSyncConfig = banner.getContentValue();
            cdpContentModel.DatabaseTableConfigUtil = banner.getContentType();
            cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = banner.getEffectiveDate();
            cdpContentModel.PrepareContext = banner.getExpireDate();
            cdpContentModel.newProxyInstance = banner.getExtendInfo();
            cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda4 = banner.getRedirectUrl();
            arrayList.add(cdpContentModel);
        }
        promotionModel.KClassImpl$Data$declaredNonStaticMembers$2 = arrayList;
        return promotionModel;
    }
}

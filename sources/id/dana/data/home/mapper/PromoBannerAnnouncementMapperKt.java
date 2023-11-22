package id.dana.data.home.mapper;

import id.dana.data.home.repository.source.presistence.entity.PromoBannerAnnouncementDaoEntity;
import id.dana.domain.home.model.PromoBannerAnnouncementModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0004"}, d2 = {"", "Lid/dana/domain/home/model/PromoBannerAnnouncementModel;", "Lid/dana/data/home/repository/source/presistence/entity/PromoBannerAnnouncementDaoEntity;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;", "getAuthRequestContext"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromoBannerAnnouncementMapperKt {
    public static final List<PromoBannerAnnouncementModel> getAuthRequestContext(List<PromoBannerAnnouncementDaoEntity> list) {
        String str = "";
        Intrinsics.checkNotNullParameter(list, "");
        List<PromoBannerAnnouncementDaoEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            PromoBannerAnnouncementDaoEntity promoBannerAnnouncementDaoEntity = (PromoBannerAnnouncementDaoEntity) it.next();
            Intrinsics.checkNotNullParameter(promoBannerAnnouncementDaoEntity, str);
            arrayList.add(new PromoBannerAnnouncementModel(promoBannerAnnouncementDaoEntity.initRecordTimeStamp, promoBannerAnnouncementDaoEntity.KClassImpl$Data$declaredNonStaticMembers$2, promoBannerAnnouncementDaoEntity.MyBillsEntityDataFactory, promoBannerAnnouncementDaoEntity.getAuthRequestContext, promoBannerAnnouncementDaoEntity.lookAheadTest, promoBannerAnnouncementDaoEntity.getErrorConfigVersion, promoBannerAnnouncementDaoEntity.NetworkUserEntityData$$ExternalSyntheticLambda2, promoBannerAnnouncementDaoEntity.GetContactSyncConfig, promoBannerAnnouncementDaoEntity.BuiltInFictitiousFunctionClassFactory, promoBannerAnnouncementDaoEntity.PlaceComponentResult, promoBannerAnnouncementDaoEntity.NetworkUserEntityData$$ExternalSyntheticLambda0, promoBannerAnnouncementDaoEntity.moveToNextValue, promoBannerAnnouncementDaoEntity.NetworkUserEntityData$$ExternalSyntheticLambda1, promoBannerAnnouncementDaoEntity.scheduleImpl));
            it = it;
            str = str;
        }
        return arrayList;
    }

    public static final List<PromoBannerAnnouncementDaoEntity> MyBillsEntityDataFactory(List<PromoBannerAnnouncementModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<PromoBannerAnnouncementModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (PromoBannerAnnouncementModel promoBannerAnnouncementModel : list2) {
            Intrinsics.checkNotNullParameter(promoBannerAnnouncementModel, "");
            arrayList.add(new PromoBannerAnnouncementDaoEntity(promoBannerAnnouncementModel.getSubscriptionId(), promoBannerAnnouncementModel.getContentName(), promoBannerAnnouncementModel.getContentType(), promoBannerAnnouncementModel.getContentValue(), promoBannerAnnouncementModel.getRedirectUrl(), promoBannerAnnouncementModel.getSubMerchantId(), promoBannerAnnouncementModel.getTitle(), promoBannerAnnouncementModel.getSubtitle(), promoBannerAnnouncementModel.getGoodsName(), promoBannerAnnouncementModel.getGoodsType(), promoBannerAnnouncementModel.getSubscriptionDueDate(), promoBannerAnnouncementModel.getPaymentStatus(), promoBannerAnnouncementModel.getTotalAmount(), promoBannerAnnouncementModel.getIconUrl()));
        }
        return arrayList;
    }
}

package id.dana.data.home.mapper;

import id.dana.data.home.repository.source.presistence.entity.PromoBannerContentDaoEntity;
import id.dana.domain.home.model.PromoBannerContentModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0004"}, d2 = {"", "Lid/dana/domain/home/model/PromoBannerContentModel;", "Lid/dana/data/home/repository/source/presistence/entity/PromoBannerContentDaoEntity;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromoBannerContentMapperKt {
    public static final List<PromoBannerContentModel> BuiltInFictitiousFunctionClassFactory(List<PromoBannerContentDaoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<PromoBannerContentDaoEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (PromoBannerContentDaoEntity promoBannerContentDaoEntity : list2) {
            Intrinsics.checkNotNullParameter(promoBannerContentDaoEntity, "");
            arrayList.add(new PromoBannerContentModel(promoBannerContentDaoEntity.BuiltInFictitiousFunctionClassFactory, promoBannerContentDaoEntity.getAuthRequestContext, promoBannerContentDaoEntity.MyBillsEntityDataFactory, promoBannerContentDaoEntity.KClassImpl$Data$declaredNonStaticMembers$2, promoBannerContentDaoEntity.PlaceComponentResult, promoBannerContentDaoEntity.moveToNextValue, promoBannerContentDaoEntity.getErrorConfigVersion, promoBannerContentDaoEntity.scheduleImpl, promoBannerContentDaoEntity.lookAheadTest, promoBannerContentDaoEntity.NetworkUserEntityData$$ExternalSyntheticLambda1, promoBannerContentDaoEntity.DatabaseTableConfigUtil, promoBannerContentDaoEntity.GetContactSyncConfig, promoBannerContentDaoEntity.NetworkUserEntityData$$ExternalSyntheticLambda2, promoBannerContentDaoEntity.PrepareContext, promoBannerContentDaoEntity.newProxyInstance, promoBannerContentDaoEntity.isLayoutRequested, promoBannerContentDaoEntity.NetworkUserEntityData$$ExternalSyntheticLambda8, promoBannerContentDaoEntity.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        return arrayList;
    }

    public static final List<PromoBannerContentDaoEntity> KClassImpl$Data$declaredNonStaticMembers$2(List<PromoBannerContentModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<PromoBannerContentModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i = 0;
        for (Object obj : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            PromoBannerContentModel promoBannerContentModel = (PromoBannerContentModel) obj;
            Intrinsics.checkNotNullParameter(promoBannerContentModel, "");
            arrayList.add(new PromoBannerContentDaoEntity(promoBannerContentModel.getBizType(), promoBannerContentModel.getContentId(), promoBannerContentModel.getContentName(), promoBannerContentModel.getContentType(), promoBannerContentModel.getContentValue(), promoBannerContentModel.getEffectiveDate(), promoBannerContentModel.getEnvType(), promoBannerContentModel.getExpireDate(), promoBannerContentModel.getGmtCreate(), promoBannerContentModel.getGmtModified(), promoBannerContentModel.getLanguage(), promoBannerContentModel.getPriority(), promoBannerContentModel.getRedirectUrl(), promoBannerContentModel.getSelectRule(), promoBannerContentModel.getSpaceCode(), promoBannerContentModel.getStatus(), promoBannerContentModel.getTenantId(), promoBannerContentModel.getExtendInfo(), i2));
            i = i2;
        }
        return arrayList;
    }
}

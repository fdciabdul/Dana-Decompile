package id.dana.data.home.mapper;

import id.dana.data.home.repository.source.presistence.entity.MoreForYouDaoEntity;
import id.dana.domain.home.model.MoreForYouData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0004"}, d2 = {"", "Lid/dana/domain/home/model/MoreForYouData;", "Lid/dana/data/home/repository/source/presistence/entity/MoreForYouDaoEntity;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;", "PlaceComponentResult"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MoreForYouMapperKt {
    public static final List<MoreForYouData> PlaceComponentResult(List<MoreForYouDaoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<MoreForYouDaoEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (MoreForYouDaoEntity moreForYouDaoEntity : list2) {
            Intrinsics.checkNotNullParameter(moreForYouDaoEntity, "");
            arrayList.add(new MoreForYouData(moreForYouDaoEntity.BuiltInFictitiousFunctionClassFactory, moreForYouDaoEntity.GetContactSyncConfig, moreForYouDaoEntity.DatabaseTableConfigUtil, moreForYouDaoEntity.NetworkUserEntityData$$ExternalSyntheticLambda0, moreForYouDaoEntity.NetworkUserEntityData$$ExternalSyntheticLambda8, moreForYouDaoEntity.PrepareContext, moreForYouDaoEntity.NetworkUserEntityData$$ExternalSyntheticLambda1, moreForYouDaoEntity.KClassImpl$Data$declaredNonStaticMembers$2, moreForYouDaoEntity.MyBillsEntityDataFactory, moreForYouDaoEntity.getAuthRequestContext, moreForYouDaoEntity.NetworkUserEntityData$$ExternalSyntheticLambda2, moreForYouDaoEntity.initRecordTimeStamp, moreForYouDaoEntity.getErrorConfigVersion, moreForYouDaoEntity.PlaceComponentResult, moreForYouDaoEntity.moveToNextValue, moreForYouDaoEntity.scheduleImpl));
        }
        return arrayList;
    }

    public static final List<MoreForYouDaoEntity> MyBillsEntityDataFactory(List<MoreForYouData> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<MoreForYouData> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i = 0;
        for (Object obj : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MoreForYouData moreForYouData = (MoreForYouData) obj;
            Intrinsics.checkNotNullParameter(moreForYouData, "");
            String clientId = moreForYouData.getClientId();
            String scopes = moreForYouData.getScopes();
            String redirectType = moreForYouData.getRedirectType();
            String icon = moreForYouData.getIcon();
            String title = moreForYouData.getTitle();
            String subtitle = moreForYouData.getSubtitle();
            String redirectUrl = moreForYouData.getRedirectUrl();
            String contentId = moreForYouData.getContentId();
            arrayList.add(new MoreForYouDaoEntity(contentId == null ? "" : contentId, clientId, scopes, redirectType, icon, title, subtitle, redirectUrl, moreForYouData.getContentName(), moreForYouData.getContentType(), moreForYouData.getSpaceCode(), moreForYouData.getPriority(), moreForYouData.getCreatedDate(), moreForYouData.getBizScenario(), moreForYouData.getLocalIconId(), moreForYouData.getExpireDate(), i2));
            i = i2;
        }
        return arrayList;
    }
}

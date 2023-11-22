package id.dana.feeds.data.mapper;

import id.dana.data.social.model.FeedsContactEntity;
import id.dana.feeds.data.synccontact.source.network.response.FeedsUserContact;
import id.dana.feeds.domain.synccontact.model.FeedsContact;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0000*\b\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0004"}, d2 = {"", "Lid/dana/data/social/model/FeedsContactEntity;", "Lid/dana/feeds/domain/synccontact/model/FeedsContact;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/feeds/data/synccontact/source/network/response/FeedsUserContact;", "PlaceComponentResult"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialContactEntityMapperKt {
    public static final List<FeedsUserContact> PlaceComponentResult(List<FeedsContact> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<FeedsContact> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (FeedsContact feedsContact : list2) {
            arrayList.add(new FeedsUserContact(feedsContact.getPhoneNumber(), feedsContact.getDisplayName()));
        }
        return arrayList;
    }

    public static final List<FeedsContact> KClassImpl$Data$declaredNonStaticMembers$2(List<FeedsContactEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<FeedsContactEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (FeedsContactEntity feedsContactEntity : list2) {
            Intrinsics.checkNotNullParameter(feedsContactEntity, "");
            arrayList.add(new FeedsContact(feedsContactEntity.getContactId(), feedsContactEntity.getDisplayName(), feedsContactEntity.getPhoneNumber(), feedsContactEntity.getContactRawId(), feedsContactEntity.getLastUpdatedTime(), feedsContactEntity.isEmpty()));
        }
        return arrayList;
    }
}

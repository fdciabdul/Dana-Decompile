package id.dana.feeds.data.mapper;

import id.dana.data.account.AccountEntity;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.data.share.source.local.model.CreateFeedActivityEntity;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.GroupedActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lid/dana/feeds/data/share/source/local/model/CreateFeedActivityEntity;", "Lid/dana/data/account/AccountEntity;", "p0", "Lid/dana/feeds/domain/timeline/model/GroupedActivity;", "MyBillsEntityDataFactory", "(Ljava/util/List;Lid/dana/data/account/AccountEntity;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreateFeedActivityEntityMapperKt {
    public static final List<GroupedActivity> MyBillsEntityDataFactory(List<CreateFeedActivityEntity> list, AccountEntity accountEntity) {
        ActivityResponse activityResponse;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(accountEntity, "");
        List<CreateFeedActivityEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (CreateFeedActivityEntity createFeedActivityEntity : list2) {
            FeedActivityState feedActivityState = createFeedActivityEntity.PlaceComponentResult;
            String caption = createFeedActivityEntity.KClassImpl$Data$declaredNonStaticMembers$2.getCaption();
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            boolean z = false;
            List list3 = null;
            ActivityResponse activityResponse2 = new ActivityResponse(str, str2, createFeedActivityEntity.BuiltInFictitiousFunctionClassFactory, str3, str4, z, System.currentTimeMillis(), createFeedActivityEntity.KClassImpl$Data$declaredNonStaticMembers$2.getExtendInfo(), list3, list3, createFeedActivityEntity.KClassImpl$Data$declaredNonStaticMembers$2.getContentType(), null, false, 0, caption, feedActivityState, false, null, null, null, createFeedActivityEntity.KClassImpl$Data$declaredNonStaticMembers$2.getWidget(), 998203, null);
            if (activityResponse2.getExtendInfo() == null) {
                activityResponse = activityResponse2;
                activityResponse.setExtendInfo(new HashMap<>());
            } else {
                activityResponse = activityResponse2;
            }
            HashMap<String, String> extendInfo = activityResponse.getExtendInfo();
            if (extendInfo != null) {
                ExtendInfoUtilKt.setShareFeedRequestId(extendInfo, createFeedActivityEntity.KClassImpl$Data$declaredNonStaticMembers$2.getShareFeedRequestId());
            }
            HashMap<String, String> extendInfo2 = activityResponse.getExtendInfo();
            if (extendInfo2 != null) {
                String userId = accountEntity.getUserId();
                if (userId == null) {
                    userId = "";
                }
                String avatarUrl = accountEntity.getAvatarUrl();
                if (avatarUrl == null) {
                    avatarUrl = "";
                }
                String username = accountEntity.getUsername();
                if (username == null) {
                    username = "";
                }
                String nickname = accountEntity.getNickname();
                if (nickname == null) {
                    nickname = "";
                }
                ExtendInfoUtilKt.setUserInfo(extendInfo2, userId, avatarUrl, username, nickname);
            }
            List listOf = CollectionsKt.listOf(activityResponse);
            arrayList.add(new GroupedActivity(createFeedActivityEntity.KClassImpl$Data$declaredNonStaticMembers$2.getShareFeedRequestId(), createFeedActivityEntity.KClassImpl$Data$declaredNonStaticMembers$2.getShareFeedRequestId(), 1, 1, listOf, false, 32, null));
        }
        return arrayList;
    }
}

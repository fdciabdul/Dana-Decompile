package id.dana.danapoly.data.rewards.mapper;

import id.dana.danapoly.data.mapper.PaginatorResponseMapperKt;
import id.dana.danapoly.data.play.model.mapper.RollDiceMapperKt;
import id.dana.danapoly.data.play.model.response.LocalizationResponse;
import id.dana.danapoly.data.rewards.model.response.GetRewardsResponse;
import id.dana.danapoly.data.rewards.model.response.PaginatorResponse;
import id.dana.danapoly.data.rewards.model.response.RewardItemResponse;
import id.dana.danapoly.data.rewards.model.response.RewardResponse;
import id.dana.danapoly.domain.play.model.Localization;
import id.dana.danapoly.domain.rewards.model.GetRewardResult;
import id.dana.danapoly.domain.rewards.model.PaginatorInfo;
import id.dana.danapoly.domain.rewards.model.RewardItem;
import id.dana.danapoly.domain.rewards.model.RewardList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/data/rewards/model/response/GetRewardsResponse;", "Lid/dana/danapoly/domain/rewards/model/GetRewardResult;", "PlaceComponentResult", "(Lid/dana/danapoly/data/rewards/model/response/GetRewardsResponse;)Lid/dana/danapoly/domain/rewards/model/GetRewardResult;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetRewardsResponseMapperKt {
    /* JADX WARN: Type inference failed for: r4v8, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public static final GetRewardResult PlaceComponentResult(GetRewardsResponse getRewardsResponse) {
        ArrayList emptyList;
        ArrayList emptyList2;
        Localization localization;
        Localization localization2;
        Localization localization3;
        Localization localization4;
        Intrinsics.checkNotNullParameter(getRewardsResponse, "");
        List<RewardResponse> rewards = getRewardsResponse.getRewards();
        if (rewards == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            List<RewardResponse> list = rewards;
            int i = 10;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (RewardResponse rewardResponse : list) {
                String type = rewardResponse.getType();
                if (type == null) {
                    type = "";
                }
                List<RewardItemResponse> items = rewardResponse.getItems();
                if (items == null) {
                    emptyList2 = CollectionsKt.emptyList();
                } else {
                    List<RewardItemResponse> list2 = items;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, i));
                    for (RewardItemResponse rewardItemResponse : list2) {
                        String id2 = rewardItemResponse.getId();
                        String str = id2 == null ? "" : id2;
                        String type2 = rewardItemResponse.getType();
                        String str2 = type2 == null ? "" : type2;
                        String imageUrl = rewardItemResponse.getImageUrl();
                        String str3 = imageUrl == null ? "" : imageUrl;
                        String status = rewardItemResponse.getStatus();
                        String str4 = status == null ? "" : status;
                        Long expiryTime = rewardItemResponse.getExpiryTime();
                        long longValue = expiryTime != null ? expiryTime.longValue() : 0L;
                        LocalizationResponse title = rewardItemResponse.getTitle();
                        int i2 = 3;
                        ?? r4 = 0;
                        if (title == null || (localization = RollDiceMapperKt.toLocalization(title)) == null) {
                            localization = new Localization(r4, r4, i2, r4);
                        }
                        Localization localization5 = localization;
                        LocalizationResponse subtitle = rewardItemResponse.getSubtitle();
                        if (subtitle == null || (localization2 = RollDiceMapperKt.toLocalization(subtitle)) == null) {
                            localization2 = new Localization(r4, r4, i2, r4);
                        }
                        Localization localization6 = localization2;
                        LocalizationResponse actionButton = rewardItemResponse.getActionButton();
                        if (actionButton == null || (localization3 = RollDiceMapperKt.toLocalization(actionButton)) == null) {
                            localization3 = new Localization(r4, r4, i2, r4);
                        }
                        Localization localization7 = localization3;
                        String redirectLink = rewardItemResponse.getRedirectLink();
                        String str5 = redirectLink == null ? "" : redirectLink;
                        LocalizationResponse name = rewardItemResponse.getName();
                        if (name == null || (localization4 = RollDiceMapperKt.toLocalization(name)) == null) {
                            localization4 = new Localization(r4, r4, i2, r4);
                        }
                        arrayList2.add(new RewardItem(str, str2, str3, str4, longValue, localization5, localization6, localization7, str5, localization4));
                    }
                    emptyList2 = arrayList2;
                }
                PaginatorResponse itemsPaginator = rewardResponse.getItemsPaginator();
                arrayList.add(new RewardList(type, emptyList2, itemsPaginator != null ? PaginatorResponseMapperKt.MyBillsEntityDataFactory(itemsPaginator) : new PaginatorInfo(0, 0, false, 7, null)));
                i = 10;
            }
            emptyList = arrayList;
        }
        PaginatorResponse rewardsPaginator = getRewardsResponse.getRewardsPaginator();
        return new GetRewardResult(emptyList, rewardsPaginator != null ? PaginatorResponseMapperKt.MyBillsEntityDataFactory(rewardsPaginator) : new PaginatorInfo(0, 0, false, 7, null));
    }
}

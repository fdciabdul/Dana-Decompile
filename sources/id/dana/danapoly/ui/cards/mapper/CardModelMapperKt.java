package id.dana.danapoly.ui.cards.mapper;

import id.dana.danapoly.domain.rewards.model.RewardItem;
import id.dana.danapoly.domain.rewards.model.RewardList;
import id.dana.danapoly.ui.enums.RewardType;
import id.dana.danapoly.ui.model.CardItemModel;
import id.dana.danapoly.ui.model.CardListWrapperModel;
import id.dana.danapoly.ui.model.mapper.RollDiceModelMapperKt;
import id.dana.danapoly.ui.model.play.LocalizationModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b0\u0006*\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/danapoly/domain/rewards/model/RewardItem;", "Lid/dana/danapoly/ui/enums/RewardType;", "p0", "Lid/dana/danapoly/ui/model/CardItemModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/danapoly/domain/rewards/model/RewardItem;Lid/dana/danapoly/ui/enums/RewardType;)Lid/dana/danapoly/ui/model/CardItemModel;", "", "Lid/dana/danapoly/domain/rewards/model/RewardList;", "Lkotlin/Pair;", "Lid/dana/danapoly/ui/model/CardListWrapperModel;", "PlaceComponentResult", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardModelMapperKt {
    public static final List<Pair<RewardType, CardListWrapperModel>> PlaceComponentResult(List<RewardList> list) {
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList arrayList = new ArrayList();
        for (RewardList rewardList : list) {
            RewardType valueOf = RewardType.valueOf(rewardList.getType());
            boolean hasMore = rewardList.getItemsPaginator().getHasMore();
            List<RewardItem> items = rewardList.getItems();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                arrayList2.add(KClassImpl$Data$declaredNonStaticMembers$2((RewardItem) it.next(), valueOf));
            }
            arrayList.add(TuplesKt.to(valueOf, new CardListWrapperModel(valueOf, hasMore, arrayList2)));
        }
        return arrayList;
    }

    public static final CardItemModel KClassImpl$Data$declaredNonStaticMembers$2(RewardItem rewardItem, RewardType rewardType) {
        Intrinsics.checkNotNullParameter(rewardItem, "");
        Intrinsics.checkNotNullParameter(rewardType, "");
        String id2 = rewardItem.getId();
        LocalizationModel localizationModel = RollDiceModelMapperKt.toLocalizationModel(rewardItem.getTitle());
        LocalizationModel localizationModel2 = RollDiceModelMapperKt.toLocalizationModel(rewardItem.getSubtitle());
        LocalizationModel localizationModel3 = RollDiceModelMapperKt.toLocalizationModel(rewardItem.getActionButton());
        return new CardItemModel(id2, localizationModel, localizationModel2, rewardItem.getRedirectLink(), rewardType, rewardItem.getStatus(), rewardItem.getExpiryTime(), 0, localizationModel3, rewardItem.getRedirectLink(), rewardItem.getImageUrl(), RollDiceModelMapperKt.toLocalizationModel(rewardItem.getName()), 128, null);
    }
}

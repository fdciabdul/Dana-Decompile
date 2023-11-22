package id.dana.danapoly.data.play.model.mapper;

import id.dana.danapoly.data.play.model.response.LocalizationResponse;
import id.dana.danapoly.data.play.model.response.PlayResponse;
import id.dana.danapoly.data.play.model.response.PositionResponse;
import id.dana.danapoly.data.play.model.response.RollDiceResponse;
import id.dana.danapoly.domain.play.model.Localization;
import id.dana.danapoly.domain.play.model.Play;
import id.dana.danapoly.domain.play.model.Position;
import id.dana.danapoly.domain.play.model.RollDice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b*\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\r\u001a\u00020\f*\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u0011\u001a\u00020\u0010*\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/danapoly/data/play/model/response/LocalizationResponse;", "Lid/dana/danapoly/domain/play/model/Localization;", "toLocalization", "(Lid/dana/danapoly/data/play/model/response/LocalizationResponse;)Lid/dana/danapoly/domain/play/model/Localization;", "Lid/dana/danapoly/data/play/model/response/PlayResponse;", "Lid/dana/danapoly/domain/play/model/Play;", "toPlay", "(Lid/dana/danapoly/data/play/model/response/PlayResponse;)Lid/dana/danapoly/domain/play/model/Play;", "", "toPlays", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/danapoly/data/play/model/response/PositionResponse;", "Lid/dana/danapoly/domain/play/model/Position;", "toPosition", "(Lid/dana/danapoly/data/play/model/response/PositionResponse;)Lid/dana/danapoly/domain/play/model/Position;", "Lid/dana/danapoly/data/play/model/response/RollDiceResponse;", "Lid/dana/danapoly/domain/play/model/RollDice;", "toRollDice", "(Lid/dana/danapoly/data/play/model/response/RollDiceResponse;)Lid/dana/danapoly/domain/play/model/RollDice;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RollDiceMapperKt {
    public static final RollDice toRollDice(RollDiceResponse rollDiceResponse) {
        Intrinsics.checkNotNullParameter(rollDiceResponse, "");
        List<PlayResponse> results = rollDiceResponse.getResults();
        List<Play> plays = results != null ? toPlays(results) : null;
        if (plays == null) {
            plays = CollectionsKt.emptyList();
        }
        List<Play> list = plays;
        Boolean usingFreeAttempt = rollDiceResponse.getUsingFreeAttempt();
        boolean booleanValue = usingFreeAttempt != null ? usingFreeAttempt.booleanValue() : false;
        String currencyType = rollDiceResponse.getCurrencyType();
        String str = currencyType == null ? "" : currencyType;
        Integer userCurrentFund = rollDiceResponse.getUserCurrentFund();
        return new RollDice(list, booleanValue, str, userCurrentFund != null ? userCurrentFund.intValue() : 0, rollDiceResponse.getUserCurrentLap());
    }

    public static final List<Play> toPlays(List<PlayResponse> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<PlayResponse> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlay((PlayResponse) it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public static final Play toPlay(PlayResponse playResponse) {
        Localization localization;
        Localization localization2;
        Localization localization3;
        Position position;
        Intrinsics.checkNotNullParameter(playResponse, "");
        String randomResult = playResponse.getRandomResult();
        String str = randomResult == null ? "" : randomResult;
        String rewardType = playResponse.getRewardType();
        String str2 = rewardType == null ? "" : rewardType;
        LocalizationResponse title = playResponse.getTitle();
        int i = 3;
        ?? r6 = 0;
        if (title == null || (localization = toLocalization(title)) == null) {
            localization = new Localization(r6, r6, i, r6);
        }
        LocalizationResponse subtitle = playResponse.getSubtitle();
        if (subtitle == null || (localization2 = toLocalization(subtitle)) == null) {
            localization2 = new Localization(r6, r6, i, r6);
        }
        String imageUrl = playResponse.getImageUrl();
        if (imageUrl == null) {
            imageUrl = "";
        }
        String redirectLink = playResponse.getRedirectLink();
        if (redirectLink == null) {
            redirectLink = "";
        }
        PositionResponse position2 = playResponse.getPosition();
        Position position3 = (position2 == null || (position = toPosition(position2)) == null) ? new Position(null, 0, 0, false, 15, null) : position;
        LocalizationResponse actionButton = playResponse.getActionButton();
        if (actionButton == null || (localization3 = toLocalization(actionButton)) == null) {
            localization3 = new Localization(r6, r6, i, r6);
        }
        Localization localization4 = localization3;
        Boolean hasPrize = playResponse.getHasPrize();
        return new Play(str, str2, localization, localization2, imageUrl, redirectLink, position3, localization4, hasPrize != null ? hasPrize.booleanValue() : false);
    }

    public static final Localization toLocalization(LocalizationResponse localizationResponse) {
        Intrinsics.checkNotNullParameter(localizationResponse, "");
        String id2 = localizationResponse.getId();
        if (id2 == null) {
            id2 = "";
        }
        String en = localizationResponse.getEn();
        return new Localization(id2, en != null ? en : "");
    }

    public static final Position toPosition(PositionResponse positionResponse) {
        Intrinsics.checkNotNullParameter(positionResponse, "");
        String movingType = positionResponse.getMovingType();
        String str = movingType != null ? movingType : "";
        Integer current = positionResponse.getCurrent();
        int intValue = current != null ? current.intValue() : 0;
        Integer next = positionResponse.getNext();
        int intValue2 = next != null ? next.intValue() : 0;
        Boolean overlapCount = positionResponse.getOverlapCount();
        return new Position(str, intValue, intValue2, overlapCount != null ? overlapCount.booleanValue() : false);
    }
}

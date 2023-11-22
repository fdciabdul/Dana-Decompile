package id.dana.danapoly.ui.model.mapper;

import id.dana.danapoly.domain.play.model.Localization;
import id.dana.danapoly.domain.play.model.Play;
import id.dana.danapoly.domain.play.model.Position;
import id.dana.danapoly.domain.play.model.RollDice;
import id.dana.danapoly.ui.model.play.LocalizationModel;
import id.dana.danapoly.ui.model.play.PlayModel;
import id.dana.danapoly.ui.model.play.PositionModel;
import id.dana.danapoly.ui.model.play.RollDiceModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b*\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\r\u001a\u00020\f*\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u0011\u001a\u00020\u0010*\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/danapoly/domain/play/model/Localization;", "Lid/dana/danapoly/ui/model/play/LocalizationModel;", "toLocalizationModel", "(Lid/dana/danapoly/domain/play/model/Localization;)Lid/dana/danapoly/ui/model/play/LocalizationModel;", "Lid/dana/danapoly/domain/play/model/Play;", "Lid/dana/danapoly/ui/model/play/PlayModel;", "toPlayModel", "(Lid/dana/danapoly/domain/play/model/Play;)Lid/dana/danapoly/ui/model/play/PlayModel;", "", "toPlaysModel", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/danapoly/domain/play/model/Position;", "Lid/dana/danapoly/ui/model/play/PositionModel;", "toPositionModel", "(Lid/dana/danapoly/domain/play/model/Position;)Lid/dana/danapoly/ui/model/play/PositionModel;", "Lid/dana/danapoly/domain/play/model/RollDice;", "Lid/dana/danapoly/ui/model/play/RollDiceModel;", "toRollDiceModel", "(Lid/dana/danapoly/domain/play/model/RollDice;)Lid/dana/danapoly/ui/model/play/RollDiceModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RollDiceModelMapperKt {
    public static final RollDiceModel toRollDiceModel(RollDice rollDice) {
        Intrinsics.checkNotNullParameter(rollDice, "");
        return new RollDiceModel(toPlaysModel(rollDice.getResults()), rollDice.getUsingFreeAttempt());
    }

    public static final List<PlayModel> toPlaysModel(List<Play> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<Play> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlayModel((Play) it.next()));
        }
        return arrayList;
    }

    public static final PlayModel toPlayModel(Play play) {
        Intrinsics.checkNotNullParameter(play, "");
        return new PlayModel(play.getRandomResult(), play.getRewardType(), toLocalizationModel(play.getTitle()), toLocalizationModel(play.getSubtitle()), play.getImageUrl(), play.getRedirectLink(), toPositionModel(play.getPosition()), play.getHasPrize(), toLocalizationModel(play.getActionButton()));
    }

    public static final LocalizationModel toLocalizationModel(Localization localization) {
        Intrinsics.checkNotNullParameter(localization, "");
        return new LocalizationModel(localization.getId(), localization.getEn());
    }

    public static final PositionModel toPositionModel(Position position) {
        Intrinsics.checkNotNullParameter(position, "");
        return new PositionModel(position.getMovingType(), position.getCurrent(), position.getNext(), position.getOverlapCount());
    }
}

package id.dana.danapoly.data.config.model.mapper;

import id.dana.danapoly.data.config.model.response.BoardResponse;
import id.dana.danapoly.data.config.model.response.PlayBoardResponse;
import id.dana.danapoly.domain.config.model.Board;
import id.dana.danapoly.domain.config.model.PlayBoard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\n\u001a\u00020\t*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "Lid/dana/danapoly/data/config/model/response/BoardResponse;", "Lid/dana/danapoly/domain/config/model/Board;", "toBoards", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/danapoly/data/config/model/response/PlayBoardResponse;", "", "eventId", "lastActiveEventId", "Lid/dana/danapoly/domain/config/model/PlayBoard;", "toPlayBoard", "(Lid/dana/danapoly/data/config/model/response/PlayBoardResponse;Ljava/lang/String;Ljava/lang/String;)Lid/dana/danapoly/domain/config/model/PlayBoard;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayBoardMapperKt {
    public static final PlayBoard toPlayBoard(PlayBoardResponse playBoardResponse, String str, String str2) {
        Intrinsics.checkNotNullParameter(playBoardResponse, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        List<BoardResponse> boards = playBoardResponse.getBoards();
        List<Board> boards2 = boards != null ? toBoards(boards) : null;
        if (boards2 == null) {
            boards2 = CollectionsKt.emptyList();
        }
        return new PlayBoard(true, str, str2, boards2);
    }

    public static final List<Board> toBoards(List<BoardResponse> list) {
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList arrayList = new ArrayList();
        for (BoardResponse boardResponse : list) {
            List<Integer> positions = boardResponse.getPositions();
            if (positions != null) {
                Iterator<T> it = positions.iterator();
                while (it.hasNext()) {
                    int intValue = ((Number) it.next()).intValue();
                    String cardType = boardResponse.getCardType();
                    if (cardType == null) {
                        cardType = "";
                    }
                    String iconUrl = boardResponse.getIconUrl();
                    if (iconUrl == null) {
                        iconUrl = "";
                    }
                    arrayList.add(new Board(intValue, cardType, iconUrl));
                }
            }
        }
        return arrayList;
    }
}

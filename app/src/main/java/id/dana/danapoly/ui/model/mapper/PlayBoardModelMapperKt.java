package id.dana.danapoly.ui.model.mapper;

import id.dana.danapoly.domain.config.model.Board;
import id.dana.danapoly.domain.config.model.PlayBoard;
import id.dana.danapoly.ui.model.BoardModel;
import id.dana.danapoly.ui.model.PlayBoardModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/danapoly/domain/config/model/Board;", "Lid/dana/danapoly/ui/model/BoardModel;", "toBoardModel", "(Lid/dana/danapoly/domain/config/model/Board;)Lid/dana/danapoly/ui/model/BoardModel;", "", "toBoardsModel", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/danapoly/domain/config/model/PlayBoard;", "Lid/dana/danapoly/ui/model/PlayBoardModel;", "toPlayBoardModel", "(Lid/dana/danapoly/domain/config/model/PlayBoard;)Lid/dana/danapoly/ui/model/PlayBoardModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayBoardModelMapperKt {
    public static final PlayBoardModel toPlayBoardModel(PlayBoard playBoard) {
        Intrinsics.checkNotNullParameter(playBoard, "");
        return new PlayBoardModel(toBoardsModel(playBoard.getBoards()));
    }

    public static final List<BoardModel> toBoardsModel(List<Board> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<Board> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toBoardModel((Board) it.next()));
        }
        return arrayList;
    }

    public static final BoardModel toBoardModel(Board board) {
        Intrinsics.checkNotNullParameter(board, "");
        return new BoardModel(board.getPosition(), board.getIconUrl(), board.getCardType());
    }
}

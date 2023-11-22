package id.dana.pocket.mapper;

import id.dana.domain.pocket.model.PocketQueryList;
import id.dana.pocket.model.PocketQueryListModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"T", "R", "Lid/dana/domain/pocket/model/PocketQueryList;", "Lkotlin/Function1;", "p0", "Lid/dana/pocket/model/PocketQueryListModel;", "PlaceComponentResult", "(Lid/dana/domain/pocket/model/PocketQueryList;Lkotlin/jvm/functions/Function1;)Lid/dana/pocket/model/PocketQueryListModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PocketMapperKt {
    public static final <T, R> PocketQueryListModel<R> PlaceComponentResult(PocketQueryList<T> pocketQueryList, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(pocketQueryList, "");
        Intrinsics.checkNotNullParameter(function1, "");
        boolean hasMore = pocketQueryList.getHasMore();
        List<T> pockets = pocketQueryList.getPockets();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pockets, 10));
        Iterator<T> it = pockets.iterator();
        while (it.hasNext()) {
            arrayList.add(function1.invoke((T) it.next()));
        }
        return new PocketQueryListModel<>(hasMore, arrayList, pocketQueryList.getTotalCount());
    }
}

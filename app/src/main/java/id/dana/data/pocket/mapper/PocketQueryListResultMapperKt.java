package id.dana.data.pocket.mapper;

import id.dana.data.pocket.model.KtpAssetResult;
import id.dana.data.pocket.model.PocketQueryListResult;
import id.dana.data.wallet_v3.repository.source.network.result.KtpResult;
import id.dana.domain.pocket.model.PocketQueryList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a=\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\t2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0006\u0010\n"}, d2 = {"R", "Lid/dana/data/pocket/model/KtpAssetResult;", "Lkotlin/Function1;", "Lid/dana/data/wallet_v3/repository/source/network/result/KtpResult;", "mapper", "Lid/dana/domain/pocket/model/PocketQueryList;", "toPocketQueryList", "(Lid/dana/data/pocket/model/KtpAssetResult;Lkotlin/jvm/functions/Function1;)Lid/dana/domain/pocket/model/PocketQueryList;", "T", "Lid/dana/data/pocket/model/PocketQueryListResult;", "(Lid/dana/data/pocket/model/PocketQueryListResult;Lkotlin/jvm/functions/Function1;)Lid/dana/domain/pocket/model/PocketQueryList;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PocketQueryListResultMapperKt {
    public static final <T, R> PocketQueryList<R> toPocketQueryList(PocketQueryListResult<T> pocketQueryListResult, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(pocketQueryListResult, "");
        Intrinsics.checkNotNullParameter(function1, "");
        boolean hasMore = pocketQueryListResult.getHasMore();
        List<T> pockets = pocketQueryListResult.getPockets();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pockets, 10));
        Iterator<T> it = pockets.iterator();
        while (it.hasNext()) {
            arrayList.add(function1.invoke((T) it.next()));
        }
        return new PocketQueryList<>(hasMore, arrayList, pocketQueryListResult.getTotalCount());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R> PocketQueryList<R> toPocketQueryList(KtpAssetResult ktpAssetResult, Function1<? super KtpResult, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(ktpAssetResult, "");
        Intrinsics.checkNotNullParameter(function1, "");
        boolean hasMore = ktpAssetResult.getHasMore();
        List<KtpResult> pockets = ktpAssetResult.getPockets();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pockets, 10));
        Iterator<T> it = pockets.iterator();
        while (it.hasNext()) {
            arrayList.add(function1.invoke(it.next()));
        }
        return new PocketQueryList<>(hasMore, arrayList, ktpAssetResult.getTotalCount());
    }
}

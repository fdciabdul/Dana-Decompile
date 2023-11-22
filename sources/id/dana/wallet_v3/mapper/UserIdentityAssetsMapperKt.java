package id.dana.wallet_v3.mapper;

import id.dana.domain.pocket.model.PocketQueryList;
import id.dana.domain.wallet_v3.model.KtpInfo;
import id.dana.pocket.model.PocketQueryListModel;
import id.dana.wallet_v3.model.IdentityCardModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a=\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/wallet_v3/model/KtpInfo;", "Lid/dana/wallet_v3/model/IdentityCardModel;", "toIdentityCardModel", "(Lid/dana/domain/wallet_v3/model/KtpInfo;)Lid/dana/wallet_v3/model/IdentityCardModel;", "T", "R", "Lid/dana/domain/pocket/model/PocketQueryList;", "Lkotlin/Function1;", "mapper", "Lid/dana/pocket/model/PocketQueryListModel;", "toPocketQueryListModel", "(Lid/dana/domain/pocket/model/PocketQueryList;Lkotlin/jvm/functions/Function1;)Lid/dana/pocket/model/PocketQueryListModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserIdentityAssetsMapperKt {
    public static final <T, R> PocketQueryListModel<R> toPocketQueryListModel(PocketQueryList<T> pocketQueryList, Function1<? super T, ? extends R> function1) {
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

    public static final IdentityCardModel toIdentityCardModel(KtpInfo ktpInfo) {
        Intrinsics.checkNotNullParameter(ktpInfo, "");
        return new IdentityCardModel.KtpCard(ktpInfo.getPocketId(), ktpInfo.getPocketStatus(), ktpInfo.getPocketType(), 0, null, null, null, null, ktpInfo.getCertNo(), ktpInfo.getCertName(), ktpInfo.getDateOfBirth(), null, null, null, null, null, null, null, null, null, null, null, 4192504, null);
    }
}

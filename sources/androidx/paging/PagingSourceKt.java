package androidx.paging;

import androidx.paging.PagedList;
import androidx.paging.PagingSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Key", "Landroidx/paging/PagedList$Config;", "p0", "Landroidx/paging/PagingSource$LoadParams;", "MyBillsEntityDataFactory", "(Landroidx/paging/PagedList$Config;Ljava/lang/Object;)Landroidx/paging/PagingSource$LoadParams;"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PagingSourceKt {
    public static final <Key> PagingSource.LoadParams<Key> MyBillsEntityDataFactory(PagedList.Config config, Key key) {
        Intrinsics.checkNotNullParameter(config, "");
        return new PagingSource.LoadParams.Refresh(key, config.getAuthRequestContext, config.MyBillsEntityDataFactory);
    }
}

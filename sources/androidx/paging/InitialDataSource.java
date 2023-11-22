package androidx.paging;

import androidx.paging.PageKeyedDataSource;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\f\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ1\u0010\f\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000eH\u0016¢\u0006\u0004\b\f\u0010\u000f"}, d2 = {"Landroidx/paging/InitialDataSource;", "", DiskFormatter.KB, "V", "Landroidx/paging/PageKeyedDataSource;", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "p0", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/PageKeyedDataSource$LoadParams;Landroidx/paging/PageKeyedDataSource$LoadCallback;)V", "PlaceComponentResult", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "(Landroidx/paging/PageKeyedDataSource$LoadInitialParams;Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;)V", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class InitialDataSource<K, V> extends PageKeyedDataSource<K, V> {
    @Override // androidx.paging.PageKeyedDataSource
    public final void PlaceComponentResult(PageKeyedDataSource.LoadInitialParams<K> p0, PageKeyedDataSource.LoadInitialCallback<K, V> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        p1.PlaceComponentResult(CollectionsKt.emptyList(), 0, 0, null, null);
    }

    @Override // androidx.paging.PageKeyedDataSource
    public final void PlaceComponentResult(PageKeyedDataSource.LoadParams<K> p0, PageKeyedDataSource.LoadCallback<K, V> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        p1.getAuthRequestContext(CollectionsKt.emptyList(), null);
    }

    @Override // androidx.paging.PageKeyedDataSource
    public final void KClassImpl$Data$declaredNonStaticMembers$2(PageKeyedDataSource.LoadParams<K> p0, PageKeyedDataSource.LoadCallback<K, V> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        p1.getAuthRequestContext(CollectionsKt.emptyList(), null);
    }
}

package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u0001*\b\b\u0002\u0010\u0004*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0005B;\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u001e\u0010\u000f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00180\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u0010\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000eH\u0016¢\u0006\u0004\b\t\u0010\u0011J1\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0013H\u0016¢\u0006\u0004\b\t\u0010\u0014J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00158WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0016R,\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00180\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Landroidx/paging/WrapperPageKeyedDataSource;", "", DiskFormatter.KB, "A", DiskFormatter.B, "Landroidx/paging/PageKeyedDataSource;", "Landroidx/paging/DataSource$InvalidatedCallback;", "p0", "", "PlaceComponentResult", "(Landroidx/paging/DataSource$InvalidatedCallback;)V", "MyBillsEntityDataFactory", "()V", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/PageKeyedDataSource$LoadParams;Landroidx/paging/PageKeyedDataSource$LoadCallback;)V", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "(Landroidx/paging/PageKeyedDataSource$LoadInitialParams;Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;)V", "", "()Z", "Landroidx/arch/core/util/Function;", "", "Landroidx/arch/core/util/Function;", "getAuthRequestContext", "Landroidx/paging/PageKeyedDataSource;", "<init>", "(Landroidx/paging/PageKeyedDataSource;Landroidx/arch/core/util/Function;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class WrapperPageKeyedDataSource<K, A, B> extends PageKeyedDataSource<K, B> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function<List<A>, List<B>> PlaceComponentResult;
    private final PageKeyedDataSource<K, A> getAuthRequestContext;

    public WrapperPageKeyedDataSource(PageKeyedDataSource<K, A> pageKeyedDataSource, Function<List<A>, List<B>> function) {
        Intrinsics.checkNotNullParameter(pageKeyedDataSource, "");
        Intrinsics.checkNotNullParameter(function, "");
        this.getAuthRequestContext = pageKeyedDataSource;
        this.PlaceComponentResult = function;
    }

    @Override // androidx.paging.DataSource
    @JvmName(name = "PlaceComponentResult")
    public final boolean PlaceComponentResult() {
        return this.getAuthRequestContext.PlaceComponentResult();
    }

    @Override // androidx.paging.DataSource
    public final void PlaceComponentResult(DataSource.InvalidatedCallback p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.PlaceComponentResult(p0);
    }

    @Override // androidx.paging.DataSource
    public final void MyBillsEntityDataFactory(DataSource.InvalidatedCallback p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.MyBillsEntityDataFactory(p0);
    }

    @Override // androidx.paging.DataSource
    public final void MyBillsEntityDataFactory() {
        this.getAuthRequestContext.MyBillsEntityDataFactory();
    }

    @Override // androidx.paging.PageKeyedDataSource
    public final void PlaceComponentResult(PageKeyedDataSource.LoadInitialParams<K> p0, final PageKeyedDataSource.LoadInitialCallback<K, B> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getAuthRequestContext.PlaceComponentResult(p0, new PageKeyedDataSource.LoadInitialCallback<K, A>(this) { // from class: androidx.paging.WrapperPageKeyedDataSource$loadInitial$1
            final /* synthetic */ WrapperPageKeyedDataSource<K, A, B> MyBillsEntityDataFactory;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.MyBillsEntityDataFactory = this;
            }

            @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
            public final void PlaceComponentResult(List<? extends A> p02, int p12, int p2, K p3, K p4) {
                Function function;
                Intrinsics.checkNotNullParameter(p02, "");
                DataSource.Companion companion = DataSource.INSTANCE;
                function = ((WrapperPageKeyedDataSource) this.MyBillsEntityDataFactory).PlaceComponentResult;
                p1.PlaceComponentResult(DataSource.Companion.PlaceComponentResult(function, p02), p12, p2, p3, p4);
            }

            @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
            public final void MyBillsEntityDataFactory(List<? extends A> p02, K p12, K p2) {
                Function function;
                Intrinsics.checkNotNullParameter(p02, "");
                DataSource.Companion companion = DataSource.INSTANCE;
                function = ((WrapperPageKeyedDataSource) this.MyBillsEntityDataFactory).PlaceComponentResult;
                p1.MyBillsEntityDataFactory(DataSource.Companion.PlaceComponentResult(function, p02), p12, p2);
            }
        });
    }

    @Override // androidx.paging.PageKeyedDataSource
    public final void PlaceComponentResult(PageKeyedDataSource.LoadParams<K> p0, final PageKeyedDataSource.LoadCallback<K, B> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getAuthRequestContext.PlaceComponentResult(p0, new PageKeyedDataSource.LoadCallback<K, A>() { // from class: androidx.paging.WrapperPageKeyedDataSource$loadBefore$1
            @Override // androidx.paging.PageKeyedDataSource.LoadCallback
            public final void getAuthRequestContext(List<? extends A> p02, K p12) {
                Function function;
                Intrinsics.checkNotNullParameter(p02, "");
                PageKeyedDataSource.LoadCallback<K, B> loadCallback = p1;
                DataSource.Companion companion = DataSource.INSTANCE;
                function = ((WrapperPageKeyedDataSource) this).PlaceComponentResult;
                loadCallback.getAuthRequestContext(DataSource.Companion.PlaceComponentResult(function, p02), p12);
            }
        });
    }

    @Override // androidx.paging.PageKeyedDataSource
    public final void KClassImpl$Data$declaredNonStaticMembers$2(PageKeyedDataSource.LoadParams<K> p0, final PageKeyedDataSource.LoadCallback<K, B> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(p0, new PageKeyedDataSource.LoadCallback<K, A>() { // from class: androidx.paging.WrapperPageKeyedDataSource$loadAfter$1
            @Override // androidx.paging.PageKeyedDataSource.LoadCallback
            public final void getAuthRequestContext(List<? extends A> p02, K p12) {
                Function function;
                Intrinsics.checkNotNullParameter(p02, "");
                PageKeyedDataSource.LoadCallback<K, B> loadCallback = p1;
                DataSource.Companion companion = DataSource.INSTANCE;
                function = ((WrapperPageKeyedDataSource) this).PlaceComponentResult;
                loadCallback.getAuthRequestContext(DataSource.Companion.PlaceComponentResult(function, p02), p12);
            }
        });
    }
}

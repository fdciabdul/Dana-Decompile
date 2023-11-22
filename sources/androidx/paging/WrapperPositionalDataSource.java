package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0004B5\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u001e\u0010\u000e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00180\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\b\n\u0010\u000fJ%\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00102\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u0016\u001a\u00020\u00148WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0015R)\u0010\b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00180\u0017X\u0007¢\u0006\u0006\n\u0004\b\n\u0010\u0019R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001a"}, d2 = {"Landroidx/paging/WrapperPositionalDataSource;", "", "A", DiskFormatter.B, "Landroidx/paging/PositionalDataSource;", "Landroidx/paging/DataSource$InvalidatedCallback;", "p0", "", "PlaceComponentResult", "(Landroidx/paging/DataSource$InvalidatedCallback;)V", "MyBillsEntityDataFactory", "()V", "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "p1", "(Landroidx/paging/PositionalDataSource$LoadInitialParams;Landroidx/paging/PositionalDataSource$LoadInitialCallback;)V", "Landroidx/paging/PositionalDataSource$LoadRangeParams;", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "getAuthRequestContext", "(Landroidx/paging/PositionalDataSource$LoadRangeParams;Landroidx/paging/PositionalDataSource$LoadRangeCallback;)V", "", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/arch/core/util/Function;", "", "Landroidx/arch/core/util/Function;", "Landroidx/paging/PositionalDataSource;", "<init>", "(Landroidx/paging/PositionalDataSource;Landroidx/arch/core/util/Function;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class WrapperPositionalDataSource<A, B> extends PositionalDataSource<B> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final Function<List<A>, List<B>> PlaceComponentResult;
    private final PositionalDataSource<A> getAuthRequestContext;

    public WrapperPositionalDataSource(PositionalDataSource<A> positionalDataSource, Function<List<A>, List<B>> function) {
        Intrinsics.checkNotNullParameter(positionalDataSource, "");
        Intrinsics.checkNotNullParameter(function, "");
        this.getAuthRequestContext = positionalDataSource;
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

    @Override // androidx.paging.PositionalDataSource
    public final void MyBillsEntityDataFactory(PositionalDataSource.LoadInitialParams p0, final PositionalDataSource.LoadInitialCallback<B> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getAuthRequestContext.MyBillsEntityDataFactory(p0, new PositionalDataSource.LoadInitialCallback<A>() { // from class: androidx.paging.WrapperPositionalDataSource$loadInitial$1
            @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
            public final void PlaceComponentResult(List<? extends A> p02, int p12) {
                Intrinsics.checkNotNullParameter(p02, "");
                PositionalDataSource.LoadInitialCallback<B> loadInitialCallback = p1;
                DataSource.Companion companion = DataSource.INSTANCE;
                loadInitialCallback.PlaceComponentResult(DataSource.Companion.PlaceComponentResult(this.PlaceComponentResult, p02), p12);
            }
        });
    }

    @Override // androidx.paging.PositionalDataSource
    public final void getAuthRequestContext(PositionalDataSource.LoadRangeParams p0, final PositionalDataSource.LoadRangeCallback<B> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getAuthRequestContext.getAuthRequestContext(p0, new PositionalDataSource.LoadRangeCallback<A>() { // from class: androidx.paging.WrapperPositionalDataSource$loadRange$1
        });
    }
}

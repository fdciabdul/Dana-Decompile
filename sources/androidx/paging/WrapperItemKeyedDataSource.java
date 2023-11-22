package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.ItemKeyedDataSource;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import java.util.IdentityHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u0001*\b\b\u0002\u0010\u0004*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0005B;\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u001e\u0010\u0011\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u001d0\u001c¢\u0006\u0004\b!\u0010\"J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u0010H\u0016¢\u0006\u0004\b\t\u0010\u0012J+\u0010\u0013\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J+\u0010\r\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u0015H\u0016¢\u0006\u0004\b\r\u0010\u0016J\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00178WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0018R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001aR,\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u001d0\u001c8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001eR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Landroidx/paging/WrapperItemKeyedDataSource;", "", DiskFormatter.KB, "A", DiskFormatter.B, "Landroidx/paging/ItemKeyedDataSource;", "Landroidx/paging/DataSource$InvalidatedCallback;", "p0", "", "PlaceComponentResult", "(Landroidx/paging/DataSource$InvalidatedCallback;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Object;)Ljava/lang/Object;", "MyBillsEntityDataFactory", "()V", "Landroidx/paging/ItemKeyedDataSource$LoadParams;", "Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "p1", "(Landroidx/paging/ItemKeyedDataSource$LoadParams;Landroidx/paging/ItemKeyedDataSource$LoadCallback;)V", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;", "Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;", "(Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;)V", "", "()Z", "Ljava/util/IdentityHashMap;", "Ljava/util/IdentityHashMap;", "getAuthRequestContext", "Landroidx/arch/core/util/Function;", "", "Landroidx/arch/core/util/Function;", "moveToNextValue", "Landroidx/paging/ItemKeyedDataSource;", "<init>", "(Landroidx/paging/ItemKeyedDataSource;Landroidx/arch/core/util/Function;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class WrapperItemKeyedDataSource<K, A, B> extends ItemKeyedDataSource<K, B> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final IdentityHashMap<B, K> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function<List<A>, List<B>> PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final ItemKeyedDataSource<K, A> KClassImpl$Data$declaredNonStaticMembers$2;

    public WrapperItemKeyedDataSource(ItemKeyedDataSource<K, A> itemKeyedDataSource, Function<List<A>, List<B>> function) {
        Intrinsics.checkNotNullParameter(itemKeyedDataSource, "");
        Intrinsics.checkNotNullParameter(function, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = itemKeyedDataSource;
        this.PlaceComponentResult = function;
        this.getAuthRequestContext = new IdentityHashMap<>();
    }

    @Override // androidx.paging.DataSource
    public final void PlaceComponentResult(DataSource.InvalidatedCallback p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(p0);
    }

    @Override // androidx.paging.DataSource
    public final void MyBillsEntityDataFactory(DataSource.InvalidatedCallback p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(p0);
    }

    @Override // androidx.paging.DataSource
    public final void MyBillsEntityDataFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
    }

    @Override // androidx.paging.DataSource
    @JvmName(name = "PlaceComponentResult")
    public final boolean PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public final void MyBillsEntityDataFactory(ItemKeyedDataSource.LoadInitialParams<K> p0, final ItemKeyedDataSource.LoadInitialCallback<B> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(p0, new ItemKeyedDataSource.LoadInitialCallback<A>() { // from class: androidx.paging.WrapperItemKeyedDataSource$loadInitial$1
        });
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public final void PlaceComponentResult(ItemKeyedDataSource.LoadParams<K> p0, final ItemKeyedDataSource.LoadCallback<B> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(p0, new ItemKeyedDataSource.LoadCallback<A>() { // from class: androidx.paging.WrapperItemKeyedDataSource$loadAfter$1
        });
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public final void BuiltInFictitiousFunctionClassFactory(ItemKeyedDataSource.LoadParams<K> p0, final ItemKeyedDataSource.LoadCallback<B> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(p0, new ItemKeyedDataSource.LoadCallback<A>() { // from class: androidx.paging.WrapperItemKeyedDataSource$loadBefore$1
        });
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public final K KClassImpl$Data$declaredNonStaticMembers$2(B p0) {
        K k;
        Intrinsics.checkNotNullParameter(p0, "");
        synchronized (this.getAuthRequestContext) {
            k = this.getAuthRequestContext.get(p0);
            Intrinsics.checkNotNull(k);
            Intrinsics.checkNotNullExpressionValue(k, "");
        }
        return k;
    }
}

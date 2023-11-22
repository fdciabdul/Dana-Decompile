package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

@Deprecated(message = "ItemKeyedDataSource is deprecated and has been replaced by PagingSource", replaceWith = @ReplaceWith(expression = "PagingSource<Key, Value>", imports = {"androidx.paging.PagingSource"}))
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0004\u0018\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H\u0010¢\u0006\u0004\b\b\u0010\u0007J'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\b\u001a\u00020\u00102\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH&¢\u0006\u0004\b\b\u0010\u0011J+\u0010\u0012\u001a\u00020\u00102\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH&¢\u0006\u0004\b\u0012\u0010\u0011J+\u0010\u000b\u001a\u00020\u00102\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H&¢\u0006\u0004\b\u000b\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/ItemKeyedDataSource;", "", "Key", "Value", "Landroidx/paging/DataSource;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Object;)Ljava/lang/Object;", "PlaceComponentResult", "Landroidx/paging/DataSource$Params;", "Landroidx/paging/DataSource$BaseResult;", "MyBillsEntityDataFactory", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/ItemKeyedDataSource$LoadParams;", "Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "p1", "", "(Landroidx/paging/ItemKeyedDataSource$LoadParams;Landroidx/paging/ItemKeyedDataSource$LoadCallback;)V", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;", "Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;", "(Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;)V", "<init>", "()V", "LoadCallback", "LoadInitialCallback", "LoadInitialParams", "LoadParams"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ItemKeyedDataSource<Key, Value> extends DataSource<Key, Value> {

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "Value", "", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class LoadCallback<Value> {
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;", "Value", "Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class LoadInitialCallback<Value> extends LoadCallback<Value> {
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[LoadType.values().length];
            iArr[LoadType.REFRESH.ordinal()] = 1;
            iArr[LoadType.PREPEND.ordinal()] = 2;
            iArr[LoadType.APPEND.ordinal()] = 3;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    public abstract void BuiltInFictitiousFunctionClassFactory(LoadParams<Key> p0, LoadCallback<Value> p1);

    public abstract Key KClassImpl$Data$declaredNonStaticMembers$2(Value p0);

    public abstract void MyBillsEntityDataFactory(LoadInitialParams<Key> p0, LoadInitialCallback<Value> p1);

    public abstract void PlaceComponentResult(LoadParams<Key> p0, LoadCallback<Value> p1);

    @Override // androidx.paging.DataSource
    public final /* synthetic */ DataSource MyBillsEntityDataFactory(Function function) {
        Intrinsics.checkNotNullParameter(function, "");
        return new WrapperItemKeyedDataSource(this, function);
    }

    public ItemKeyedDataSource() {
        super(DataSource.KeyType.ITEM_KEYED);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001B!\u0012\b\u0010\f\u001a\u0004\u0018\u00018\u0002\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u00038\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00018\u00028\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\t8\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;", "", "Key", "", "MyBillsEntityDataFactory", "Z", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "Ljava/lang/Object;", "", "PlaceComponentResult", "I", "p0", "p1", "p2", "<init>", "(Ljava/lang/Object;IZ)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static class LoadInitialParams<Key> {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final boolean BuiltInFictitiousFunctionClassFactory;
        public final int PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final Key MyBillsEntityDataFactory;

        public LoadInitialParams(Key key, int i, boolean z) {
            this.MyBillsEntityDataFactory = key;
            this.PlaceComponentResult = i;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00028\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00028\u00028\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u00068\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadParams;", "", "Key", "getAuthRequestContext", "Ljava/lang/Object;", "PlaceComponentResult", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Ljava/lang/Object;I)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static class LoadParams<Key> {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final int MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final Key PlaceComponentResult;

        public LoadParams(Key key, int i) {
            Intrinsics.checkNotNullParameter(key, "");
            this.PlaceComponentResult = key;
            this.MyBillsEntityDataFactory = i;
        }
    }

    @Override // androidx.paging.DataSource
    public final Key PlaceComponentResult(Value p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    @Override // androidx.paging.DataSource
    public final Object MyBillsEntityDataFactory(DataSource.Params<Key> params, Continuation<? super DataSource.BaseResult<Value>> continuation) {
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[params.getAuthRequestContext.ordinal()];
        if (i == 1) {
            LoadInitialParams<Key> loadInitialParams = new LoadInitialParams<>(params.BuiltInFictitiousFunctionClassFactory, params.MyBillsEntityDataFactory, params.getKClassImpl$Data$declaredNonStaticMembers$2());
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            MyBillsEntityDataFactory(loadInitialParams, new LoadInitialCallback<Value>() { // from class: androidx.paging.ItemKeyedDataSource$loadInitial$2$1
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        } else if (i == 2) {
            Key key = params.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNull(key);
            LoadParams<Key> loadParams = new LoadParams<>(key, params.PlaceComponentResult);
            CancellableContinuationImpl cancellableContinuationImpl3 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl3.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl4 = cancellableContinuationImpl3;
            BuiltInFictitiousFunctionClassFactory(loadParams, new LoadCallback<Value>() { // from class: androidx.paging.ItemKeyedDataSource$asCallback$1
            });
            Object result2 = cancellableContinuationImpl3.getResult();
            if (result2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result2;
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            Key key2 = params.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNull(key2);
            LoadParams<Key> loadParams2 = new LoadParams<>(key2, params.PlaceComponentResult);
            CancellableContinuationImpl cancellableContinuationImpl5 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl5.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl6 = cancellableContinuationImpl5;
            PlaceComponentResult(loadParams2, new LoadCallback<Value>() { // from class: androidx.paging.ItemKeyedDataSource$asCallback$1
            });
            Object result3 = cancellableContinuationImpl5.getResult();
            if (result3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result3;
        }
    }
}

package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import java.util.IdentityHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u0001*\b\b\u0002\u0010\u0004*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0005B;\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u001e\u0010\u001c\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00170\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0002H\u0010¢\u0006\u0004\b\t\u0010\u000bJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0090@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0010J\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\nR\u0014\u0010\f\u001a\u00020\u00118WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0012R\"\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00138\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R,\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00170\u00168\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0018R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/WrapperDataSource;", "", "Key", "ValueFrom", "ValueTo", "Landroidx/paging/DataSource;", "Landroidx/paging/DataSource$InvalidatedCallback;", "p0", "", "PlaceComponentResult", "(Landroidx/paging/DataSource$InvalidatedCallback;)V", "(Ljava/lang/Object;)Ljava/lang/Object;", "MyBillsEntityDataFactory", "()V", "Landroidx/paging/DataSource$Params;", "Landroidx/paging/DataSource$BaseResult;", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "()Z", "Ljava/util/IdentityHashMap;", "getAuthRequestContext", "Ljava/util/IdentityHashMap;", "Landroidx/arch/core/util/Function;", "", "Landroidx/arch/core/util/Function;", "lookAheadTest", "Landroidx/paging/DataSource;", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "<init>", "(Landroidx/paging/DataSource;Landroidx/arch/core/util/Function;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public class WrapperDataSource<Key, ValueFrom, ValueTo> extends DataSource<Key, ValueTo> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function<List<ValueFrom>, List<ValueTo>> PlaceComponentResult;
    private final IdentityHashMap<ValueTo, Key> getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final DataSource<Key, ValueFrom> KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[DataSource.KeyType.values().length];
            iArr[DataSource.KeyType.ITEM_KEYED.ordinal()] = 1;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    @Override // androidx.paging.DataSource
    public final Object MyBillsEntityDataFactory(DataSource.Params<Key> params, Continuation<? super DataSource.BaseResult<ValueTo>> continuation) {
        return KClassImpl$Data$declaredNonStaticMembers$2(this, params, continuation);
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

    @Override // androidx.paging.DataSource
    public final Key PlaceComponentResult(ValueTo p0) {
        Key key;
        Intrinsics.checkNotNullParameter(p0, "");
        IdentityHashMap<ValueTo, Key> identityHashMap = this.getAuthRequestContext;
        if (identityHashMap != null) {
            synchronized (identityHashMap) {
                key = this.getAuthRequestContext.get(p0);
                Intrinsics.checkNotNull(key);
                Intrinsics.checkNotNullExpressionValue(key, "");
            }
            return key;
        }
        throw new IllegalStateException("Cannot get key by item in non-item keyed DataSource");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object KClassImpl$Data$declaredNonStaticMembers$2(androidx.paging.WrapperDataSource r8, androidx.paging.DataSource.Params r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof androidx.paging.WrapperDataSource$load$1
            if (r0 == 0) goto L14
            r0 = r10
            androidx.paging.WrapperDataSource$load$1 r0 = (androidx.paging.WrapperDataSource$load$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 + r2
            r0.label = r10
            goto L19
        L14:
            androidx.paging.WrapperDataSource$load$1 r0 = new androidx.paging.WrapperDataSource$load$1
            r0.<init>(r8, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r8 = r0.L$0
            androidx.paging.WrapperDataSource r8 = (androidx.paging.WrapperDataSource) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L46
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r10)
            androidx.paging.DataSource<Key, ValueFrom> r10 = r8.KClassImpl$Data$declaredNonStaticMembers$2
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r10 = r10.MyBillsEntityDataFactory(r9, r0)
            if (r10 != r1) goto L46
            return r1
        L46:
            androidx.paging.DataSource$BaseResult r10 = (androidx.paging.DataSource.BaseResult) r10
            androidx.paging.DataSource$BaseResult$Companion r9 = androidx.paging.DataSource.BaseResult.INSTANCE
            androidx.arch.core.util.Function<java.util.List<ValueFrom>, java.util.List<ValueTo>> r9 = r8.PlaceComponentResult
            androidx.paging.DataSource$BaseResult r9 = androidx.paging.DataSource.BaseResult.Companion.KClassImpl$Data$declaredNonStaticMembers$2(r10, r9)
            java.util.List<Value> r10 = r10.BuiltInFictitiousFunctionClassFactory
            java.util.List<Value> r0 = r9.BuiltInFictitiousFunctionClassFactory
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.util.IdentityHashMap<ValueTo, Key> r1 = r8.getAuthRequestContext
            if (r1 == 0) goto L8f
            monitor-enter(r1)
            r2 = 0
            int r4 = r0.size()     // Catch: java.lang.Throwable -> L8c
            int r4 = r4 - r3
            if (r4 < 0) goto L88
        L6b:
            int r3 = r2 + 1
            java.util.IdentityHashMap<ValueTo, Key> r5 = r8.getAuthRequestContext     // Catch: java.lang.Throwable -> L8c
            java.util.Map r5 = (java.util.Map) r5     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r6 = r0.get(r2)     // Catch: java.lang.Throwable -> L8c
            androidx.paging.DataSource<Key, ValueFrom> r7 = r8.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L8c
            androidx.paging.ItemKeyedDataSource r7 = (androidx.paging.ItemKeyedDataSource) r7     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r2 = r10.get(r2)     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r2 = r7.KClassImpl$Data$declaredNonStaticMembers$2(r2)     // Catch: java.lang.Throwable -> L8c
            r5.put(r6, r2)     // Catch: java.lang.Throwable -> L8c
            if (r3 > r4) goto L88
            r2 = r3
            goto L6b
        L88:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L8c
            monitor-exit(r1)
            goto L8f
        L8c:
            r8 = move-exception
            monitor-exit(r1)
            throw r8
        L8f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.WrapperDataSource.KClassImpl$Data$declaredNonStaticMembers$2(androidx.paging.WrapperDataSource, androidx.paging.DataSource$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrapperDataSource(DataSource<Key, ValueFrom> dataSource, Function<List<ValueFrom>, List<ValueTo>> function) {
        super(dataSource.BuiltInFictitiousFunctionClassFactory);
        Intrinsics.checkNotNullParameter(dataSource, "");
        Intrinsics.checkNotNullParameter(function, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = dataSource;
        this.PlaceComponentResult = function;
        this.getAuthRequestContext = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[dataSource.BuiltInFictitiousFunctionClassFactory.ordinal()] == 1 ? new IdentityHashMap<>() : null;
    }
}

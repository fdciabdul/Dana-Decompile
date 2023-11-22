package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PagingSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/paging/PagingSource$LoadResult$Page;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.LegacyPagingSource$load$2", f = "LegacyPagingSource.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class LegacyPagingSource$load$2<Key, Value> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PagingSource.LoadResult.Page<Key, Value>>, Object> {
    final /* synthetic */ DataSource.Params<Key> $dataSourceParams;
    final /* synthetic */ PagingSource.LoadParams<Key> $params;
    int label;
    final /* synthetic */ LegacyPagingSource<Key, Value> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegacyPagingSource$load$2(LegacyPagingSource<Key, Value> legacyPagingSource, DataSource.Params<Key> params, PagingSource.LoadParams<Key> loadParams, Continuation<? super LegacyPagingSource$load$2> continuation) {
        super(2, continuation);
        this.this$0 = legacyPagingSource;
        this.$dataSourceParams = params;
        this.$params = loadParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LegacyPagingSource$load$2(this.this$0, this.$dataSourceParams, this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object obj) {
        return invoke(coroutineScope, (Continuation) ((Continuation) obj));
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PagingSource.LoadResult.Page<Key, Value>> continuation) {
        return ((LegacyPagingSource$load$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.PlaceComponentResult.MyBillsEntityDataFactory(this.$dataSourceParams, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        PagingSource.LoadParams<Key> loadParams = this.$params;
        DataSource.BaseResult baseResult = (DataSource.BaseResult) obj;
        return new PagingSource.LoadResult.Page(baseResult.BuiltInFictitiousFunctionClassFactory, (baseResult.BuiltInFictitiousFunctionClassFactory.isEmpty() && (loadParams instanceof PagingSource.LoadParams.Prepend)) ? null : baseResult.KClassImpl$Data$declaredNonStaticMembers$2, (baseResult.BuiltInFictitiousFunctionClassFactory.isEmpty() && (loadParams instanceof PagingSource.LoadParams.Append)) ? null : baseResult.getAuthRequestContext, baseResult.PlaceComponentResult, baseResult.MyBillsEntityDataFactory);
    }
}

package androidx.paging;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@"}, d2 = {"", DiskFormatter.KB, "V", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.ContiguousPagedList$deferBoundaryCallbacks$1", f = "ContiguousPagedList.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ContiguousPagedList$deferBoundaryCallbacks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $deferBegin;
    final /* synthetic */ boolean $deferEmpty;
    final /* synthetic */ boolean $deferEnd;
    int label;
    final /* synthetic */ ContiguousPagedList<K, V> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContiguousPagedList$deferBoundaryCallbacks$1(boolean z, ContiguousPagedList<K, V> contiguousPagedList, boolean z2, boolean z3, Continuation<? super ContiguousPagedList$deferBoundaryCallbacks$1> continuation) {
        super(2, continuation);
        this.$deferEmpty = z;
        this.this$0 = contiguousPagedList;
        this.$deferBegin = z2;
        this.$deferEnd = z3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ContiguousPagedList$deferBoundaryCallbacks$1(this.$deferEmpty, this.this$0, this.$deferBegin, this.$deferEnd, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContiguousPagedList$deferBoundaryCallbacks$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$deferEmpty) {
                Object obj2 = this.this$0.BuiltInFictitiousFunctionClassFactory;
            }
            if (this.$deferBegin) {
                ((ContiguousPagedList) this.this$0).getAuthRequestContext = true;
            }
            if (this.$deferEnd) {
                ((ContiguousPagedList) this.this$0).MyBillsEntityDataFactory = true;
            }
            this.this$0.BuiltInFictitiousFunctionClassFactory(false);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

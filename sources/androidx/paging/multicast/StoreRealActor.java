package androidx.paging.multicast;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 \u0010*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0010J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/multicast/StoreRealActor;", "T", "", "p0", "", "getAuthRequestContext", "()Ljava/lang/Object;", "Lkotlinx/coroutines/CompletableDeferred;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/CompletableDeferred;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "PlaceComponentResult", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlinx/coroutines/channels/Channel;", "MyBillsEntityDataFactory", "Lkotlinx/coroutines/channels/Channel;", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class StoreRealActor<T> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    static final Object KClassImpl$Data$declaredNonStaticMembers$2 = new Object();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final CompletableDeferred<Unit> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final Channel<Object> BuiltInFictitiousFunctionClassFactory;
    private final AtomicBoolean PlaceComponentResult;

    public abstract Object getAuthRequestContext();

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"T", "", "msg", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "androidx.paging.multicast.StoreRealActor$1", f = "StoreRealActor.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.multicast.StoreRealActor$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ StoreRealActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StoreRealActor<T> storeRealActor, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = storeRealActor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object obj2 = this.L$0;
                Companion companion = StoreRealActor.INSTANCE;
                if (obj2 == Companion.PlaceComponentResult()) {
                    StoreRealActor.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0);
                } else {
                    StoreRealActor<T> storeRealActor = this.this$0;
                    this.label = 1;
                    if (storeRealActor.getAuthRequestContext() == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "androidx.paging.multicast.StoreRealActor$2", f = "StoreRealActor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.multicast.StoreRealActor$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super Object>, Throwable, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ StoreRealActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(StoreRealActor<T> storeRealActor, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.this$0 = storeRealActor;
        }

        @Override // kotlin.jvm.functions.Function3
        public final /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Object> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<Object>) flowCollector, th, continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<Object> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return new AnonymousClass2(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StoreRealActor.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/paging/multicast/StoreRealActor$Companion;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/Object;", "PlaceComponentResult", "()Ljava/lang/Object;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "PlaceComponentResult")
        public static Object PlaceComponentResult() {
            return StoreRealActor.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(StoreRealActor storeRealActor) {
        if (storeRealActor.PlaceComponentResult.compareAndSet(false, true)) {
            SendChannel.DefaultImpls.close$default(storeRealActor.BuiltInFictitiousFunctionClassFactory, null, 1, null);
            storeRealActor.getAuthRequestContext.complete(Unit.INSTANCE);
        }
    }
}

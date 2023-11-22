package id.dana.cardbinding.domain.interactor;

import id.dana.cardbinding.domain.CardBindingRepository;
import id.dana.cardbinding.domain.model.BankCardInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/cardbinding/domain/model/BankCardInfo;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.cardbinding.domain.interactor.GetCardInfoFromImage$buildUseCase$1", f = "GetCardInfoFromImage.kt", i = {0}, l = {32, 34}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes4.dex */
final class GetCardInfoFromImage$buildUseCase$1 extends SuspendLambda implements Function2<FlowCollector<? super BankCardInfo>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GetCardInfoFromImage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetCardInfoFromImage$buildUseCase$1(GetCardInfoFromImage getCardInfoFromImage, Continuation<? super GetCardInfoFromImage$buildUseCase$1> continuation) {
        super(2, continuation);
        this.this$0 = getCardInfoFromImage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GetCardInfoFromImage$buildUseCase$1 getCardInfoFromImage$buildUseCase$1 = new GetCardInfoFromImage$buildUseCase$1(this.this$0, continuation);
        getCardInfoFromImage$buildUseCase$1.L$0 = obj;
        return getCardInfoFromImage$buildUseCase$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super BankCardInfo> flowCollector, Continuation<? super Unit> continuation) {
        return ((GetCardInfoFromImage$buildUseCase$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        CardBindingRepository cardBindingRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            this.L$0 = flowCollector;
            this.label = 1;
            if (DelayKt.delay(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        cardBindingRepository = this.this$0.PlaceComponentResult;
        this.L$0 = null;
        this.label = 2;
        if (cardBindingRepository.KClassImpl$Data$declaredNonStaticMembers$2().collect(new AnonymousClass1(this.this$0, flowCollector), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.cardbinding.domain.interactor.GetCardInfoFromImage$buildUseCase$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<BankCardInfo> $BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ GetCardInfoFromImage KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(GetCardInfoFromImage getCardInfoFromImage, FlowCollector<? super BankCardInfo> flowCollector) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = getCardInfoFromImage;
            this.$BuiltInFictitiousFunctionClassFactory = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
        /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.util.List<java.lang.String> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof id.dana.cardbinding.domain.interactor.GetCardInfoFromImage$buildUseCase$1$1$emit$1
                if (r0 == 0) goto L14
                r0 = r8
                id.dana.cardbinding.domain.interactor.GetCardInfoFromImage$buildUseCase$1$1$emit$1 r0 = (id.dana.cardbinding.domain.interactor.GetCardInfoFromImage$buildUseCase$1$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r8 = r0.label
                int r8 = r8 + r2
                r0.label = r8
                goto L19
            L14:
                id.dana.cardbinding.domain.interactor.GetCardInfoFromImage$buildUseCase$1$1$emit$1 r0 = new id.dana.cardbinding.domain.interactor.GetCardInfoFromImage$buildUseCase$1$1$emit$1
                r0.<init>(r6, r8)
            L19:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L33
                if (r2 != r4) goto L2b
                kotlin.ResultKt.throwOnFailure(r8)
                goto L4d
            L2b:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L33:
                kotlin.ResultKt.throwOnFailure(r8)
                id.dana.cardbinding.domain.model.BankCardInfo r8 = id.dana.cardbinding.domain.interactor.GetCardInfoFromImage.getAuthRequestContext(r7)
                if (r8 == 0) goto L5c
                id.dana.cardbinding.domain.model.BankCardInfo r7 = id.dana.cardbinding.domain.interactor.GetCardInfoFromImage.getAuthRequestContext(r7)
                if (r7 == 0) goto L50
                kotlinx.coroutines.flow.FlowCollector<id.dana.cardbinding.domain.model.BankCardInfo> r8 = r6.$BuiltInFictitiousFunctionClassFactory
                r0.label = r4
                java.lang.Object r7 = r8.emit(r7, r0)
                if (r7 != r1) goto L4d
                return r1
            L4d:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                goto L51
            L50:
                r7 = r3
            L51:
                if (r7 == 0) goto L56
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            L56:
                id.dana.cardbinding.domain.exception.OCRUnsupportedCardException r7 = new id.dana.cardbinding.domain.exception.OCRUnsupportedCardException
                r7.<init>(r3, r4, r3)
                throw r7
            L5c:
                java.lang.String r7 = r7.toString()
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.Appendable r8 = (java.lang.Appendable) r8
                r0 = 0
                int r1 = r7.length()
            L6e:
                if (r0 >= r1) goto L80
                char r2 = r7.charAt(r0)
                boolean r5 = java.lang.Character.isLetterOrDigit(r2)
                if (r5 == 0) goto L7d
                r8.append(r2)
            L7d:
                int r0 = r0 + 1
                goto L6e
            L80:
                java.lang.StringBuilder r8 = (java.lang.StringBuilder) r8
                java.lang.String r7 = r8.toString()
                java.lang.String r8 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
                int r7 = r7.length()
                r8 = 10
                if (r7 < r8) goto L99
                id.dana.cardbinding.domain.exception.OCRUnsupportedCardException r7 = new id.dana.cardbinding.domain.exception.OCRUnsupportedCardException
                r7.<init>(r3, r4, r3)
                throw r7
            L99:
                java.lang.Throwable r7 = new java.lang.Throwable
                java.lang.String r8 = "Text not found"
                r7.<init>(r8)
                goto La2
            La1:
                throw r7
            La2:
                goto La1
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.domain.interactor.GetCardInfoFromImage$buildUseCase$1.AnonymousClass1.emit(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}

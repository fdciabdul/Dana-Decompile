package id.dana.cardbinding.data.repository;

import id.dana.cardbinding.data.model.BindingCardAddResult;
import id.dana.cardbinding.data.model.SupportedCardsConfigEntity;
import id.dana.cardbinding.data.repository.source.CardBindingEntityData;
import id.dana.cardbinding.data.repository.source.CardBindingEntityDataFactory;
import id.dana.cardbinding.domain.CardBindingRepository;
import id.dana.cardbinding.domain.model.BindingCardAddInfo;
import id.dana.cardbinding.domain.model.SupportedCardsConfig;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0005R\u0013\u0010\u0004\u001a\u00020\rX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0013\u0010\u0007\u001a\u00020\rX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0013\u0010\f\u001a\u00020\rX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e"}, d2 = {"Lid/dana/cardbinding/data/repository/CardBindingEntityRepository;", "Lid/dana/cardbinding/domain/CardBindingRepository;", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/cardbinding/domain/model/BindingCardAddInfo;", "getAuthRequestContext", "()Lkotlinx/coroutines/flow/Flow;", "", "BuiltInFictitiousFunctionClassFactory", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cardbinding/domain/model/SupportedCardsConfig;", "MyBillsEntityDataFactory", "Lid/dana/cardbinding/data/repository/source/CardBindingEntityData;", "Lkotlin/Lazy;", "Lid/dana/cardbinding/data/repository/source/CardBindingEntityDataFactory;", "Lid/dana/cardbinding/data/repository/source/CardBindingEntityDataFactory;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/cardbinding/data/repository/source/CardBindingEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CardBindingEntityRepository implements CardBindingRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CardBindingEntityDataFactory PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;
    private final Lazy getAuthRequestContext;

    @Inject
    public CardBindingEntityRepository(CardBindingEntityDataFactory cardBindingEntityDataFactory) {
        Intrinsics.checkNotNullParameter(cardBindingEntityDataFactory, "");
        this.PlaceComponentResult = cardBindingEntityDataFactory;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<CardBindingEntityData>() { // from class: id.dana.cardbinding.data.repository.CardBindingEntityRepository$cardBindingEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CardBindingEntityData invoke() {
                CardBindingEntityDataFactory cardBindingEntityDataFactory2;
                cardBindingEntityDataFactory2 = CardBindingEntityRepository.this.PlaceComponentResult;
                return cardBindingEntityDataFactory2.createData2("local");
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<CardBindingEntityData>() { // from class: id.dana.cardbinding.data.repository.CardBindingEntityRepository$networkCardBindingEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CardBindingEntityData invoke() {
                CardBindingEntityDataFactory cardBindingEntityDataFactory2;
                cardBindingEntityDataFactory2 = CardBindingEntityRepository.this.PlaceComponentResult;
                return cardBindingEntityDataFactory2.createData2("network");
            }
        });
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<CardBindingEntityData>() { // from class: id.dana.cardbinding.data.repository.CardBindingEntityRepository$splitCardBindingEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CardBindingEntityData invoke() {
                CardBindingEntityDataFactory cardBindingEntityDataFactory2;
                cardBindingEntityDataFactory2 = CardBindingEntityRepository.this.PlaceComponentResult;
                return cardBindingEntityDataFactory2.createData2("split");
            }
        });
    }

    @Override // id.dana.cardbinding.domain.CardBindingRepository
    public final Flow<BindingCardAddInfo> getAuthRequestContext() {
        final Flow<BindingCardAddResult> KClassImpl$Data$declaredNonStaticMembers$2 = ((CardBindingEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
        return new Flow<BindingCardAddInfo>() { // from class: id.dana.cardbinding.data.repository.CardBindingEntityRepository$bindingCardAdd$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super BindingCardAddInfo> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.cardbinding.data.repository.CardBindingEntityRepository$bindingCardAdd$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.cardbinding.data.repository.CardBindingEntityRepository$bindingCardAdd$$inlined$map$1$2", f = "CardBindingEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.cardbinding.data.repository.CardBindingEntityRepository$bindingCardAdd$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$PlaceComponentResult = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.cardbinding.data.repository.CardBindingEntityRepository$bindingCardAdd$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.cardbinding.data.repository.CardBindingEntityRepository$bindingCardAdd$$inlined$map$1$2$1 r0 = (id.dana.cardbinding.data.repository.CardBindingEntityRepository$bindingCardAdd$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.cardbinding.data.repository.CardBindingEntityRepository$bindingCardAdd$$inlined$map$1$2$1 r0 = new id.dana.cardbinding.data.repository.CardBindingEntityRepository$bindingCardAdd$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$PlaceComponentResult
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.cardbinding.data.model.BindingCardAddResult r5 = (id.dana.cardbinding.data.model.BindingCardAddResult) r5
                        id.dana.cardbinding.domain.model.BindingCardAddInfo r5 = id.dana.cardbinding.data.model.BindingCardAddResultKt.PlaceComponentResult(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.data.repository.CardBindingEntityRepository$bindingCardAdd$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.cardbinding.domain.CardBindingRepository
    public final Flow<Boolean> BuiltInFictitiousFunctionClassFactory() {
        return ((CardBindingEntityData) this.MyBillsEntityDataFactory.getValue()).getAuthRequestContext();
    }

    @Override // id.dana.cardbinding.domain.CardBindingRepository
    public final Flow<List<String>> KClassImpl$Data$declaredNonStaticMembers$2() {
        return ((CardBindingEntityData) this.getAuthRequestContext.getValue()).PlaceComponentResult();
    }

    @Override // id.dana.cardbinding.domain.CardBindingRepository
    public final Flow<SupportedCardsConfig> MyBillsEntityDataFactory() {
        final Flow<SupportedCardsConfigEntity> BuiltInFictitiousFunctionClassFactory = ((CardBindingEntityData) this.MyBillsEntityDataFactory.getValue()).BuiltInFictitiousFunctionClassFactory();
        return new Flow<SupportedCardsConfig>() { // from class: id.dana.cardbinding.data.repository.CardBindingEntityRepository$getSupportedCardsConfig$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super SupportedCardsConfig> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.cardbinding.data.repository.CardBindingEntityRepository$getSupportedCardsConfig$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $getAuthRequestContext;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.cardbinding.data.repository.CardBindingEntityRepository$getSupportedCardsConfig$$inlined$map$1$2", f = "CardBindingEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.cardbinding.data.repository.CardBindingEntityRepository$getSupportedCardsConfig$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$getAuthRequestContext = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.cardbinding.data.repository.CardBindingEntityRepository$getSupportedCardsConfig$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.cardbinding.data.repository.CardBindingEntityRepository$getSupportedCardsConfig$$inlined$map$1$2$1 r0 = (id.dana.cardbinding.data.repository.CardBindingEntityRepository$getSupportedCardsConfig$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.cardbinding.data.repository.CardBindingEntityRepository$getSupportedCardsConfig$$inlined$map$1$2$1 r0 = new id.dana.cardbinding.data.repository.CardBindingEntityRepository$getSupportedCardsConfig$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$getAuthRequestContext
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.cardbinding.data.model.SupportedCardsConfigEntity r5 = (id.dana.cardbinding.data.model.SupportedCardsConfigEntity) r5
                        id.dana.cardbinding.domain.model.SupportedCardsConfig r5 = id.dana.cardbinding.data.model.SupportedCardsConfigEntityKt.KClassImpl$Data$declaredNonStaticMembers$2(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.data.repository.CardBindingEntityRepository$getSupportedCardsConfig$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }
}

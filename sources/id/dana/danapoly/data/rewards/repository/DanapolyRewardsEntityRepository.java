package id.dana.danapoly.data.rewards.repository;

import id.dana.danapoly.data.rewards.mapper.GetRewardsRequestMapperKt;
import id.dana.danapoly.data.rewards.model.request.GetRewardsRequest;
import id.dana.danapoly.data.rewards.model.response.GetRewardsResponse;
import id.dana.danapoly.data.rewards.repository.source.DanapolyRewardsData;
import id.dana.danapoly.data.rewards.repository.source.DanapolyRewardsDataFactory;
import id.dana.danapoly.di.DanapolyScope;
import id.dana.danapoly.domain.rewards.DanapolyRewardsRepository;
import id.dana.danapoly.domain.rewards.model.CardsSourcePage;
import id.dana.danapoly.domain.rewards.model.GetRewardResult;
import id.dana.danapoly.domain.rewards.model.GetRewardsParams;
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

@DanapolyScope
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0013\u0010\r\u001a\u00020\u000bX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010\f"}, d2 = {"Lid/dana/danapoly/data/rewards/repository/DanapolyRewardsEntityRepository;", "Lid/dana/danapoly/domain/rewards/DanapolyRewardsRepository;", "Lid/dana/danapoly/domain/rewards/model/GetRewardsParams;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/danapoly/domain/rewards/model/GetRewardResult;", "MyBillsEntityDataFactory", "(Lid/dana/danapoly/domain/rewards/model/GetRewardsParams;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/danapoly/data/rewards/repository/source/DanapolyRewardsDataFactory;", "Lid/dana/danapoly/data/rewards/repository/source/DanapolyRewardsDataFactory;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/danapoly/data/rewards/repository/source/DanapolyRewardsData;", "Lkotlin/Lazy;", "getAuthRequestContext", "<init>", "(Lid/dana/danapoly/data/rewards/repository/source/DanapolyRewardsDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyRewardsEntityRepository implements DanapolyRewardsRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final DanapolyRewardsDataFactory BuiltInFictitiousFunctionClassFactory;

    @Inject
    public DanapolyRewardsEntityRepository(DanapolyRewardsDataFactory danapolyRewardsDataFactory) {
        Intrinsics.checkNotNullParameter(danapolyRewardsDataFactory, "");
        this.BuiltInFictitiousFunctionClassFactory = danapolyRewardsDataFactory;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<DanapolyRewardsData>() { // from class: id.dana.danapoly.data.rewards.repository.DanapolyRewardsEntityRepository$networkRewardsData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanapolyRewardsData invoke() {
                DanapolyRewardsDataFactory danapolyRewardsDataFactory2;
                danapolyRewardsDataFactory2 = DanapolyRewardsEntityRepository.this.BuiltInFictitiousFunctionClassFactory;
                return danapolyRewardsDataFactory2.getAuthRequestContext;
            }
        });
    }

    @Override // id.dana.danapoly.domain.rewards.DanapolyRewardsRepository
    public final Flow<GetRewardResult> MyBillsEntityDataFactory(GetRewardsParams p0) {
        GetRewardsRequest PlaceComponentResult;
        Intrinsics.checkNotNullParameter(p0, "");
        DanapolyRewardsData danapolyRewardsData = (DanapolyRewardsData) this.getAuthRequestContext.getValue();
        if (p0.getCardsSourcePage() == CardsSourcePage.LIST) {
            PlaceComponentResult = GetRewardsRequestMapperKt.BuiltInFictitiousFunctionClassFactory(p0);
        } else {
            PlaceComponentResult = GetRewardsRequestMapperKt.PlaceComponentResult(p0);
        }
        final Flow<GetRewardsResponse> BuiltInFictitiousFunctionClassFactory = danapolyRewardsData.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult);
        return new Flow<GetRewardResult>() { // from class: id.dana.danapoly.data.rewards.repository.DanapolyRewardsEntityRepository$getRewards$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super GetRewardResult> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.danapoly.data.rewards.repository.DanapolyRewardsEntityRepository$getRewards$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $BuiltInFictitiousFunctionClassFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.danapoly.data.rewards.repository.DanapolyRewardsEntityRepository$getRewards$$inlined$map$1$2", f = "DanapolyRewardsEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.danapoly.data.rewards.repository.DanapolyRewardsEntityRepository$getRewards$$inlined$map$1$2$1  reason: invalid class name */
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
                    this.$BuiltInFictitiousFunctionClassFactory = flowCollector;
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
                        boolean r0 = r6 instanceof id.dana.danapoly.data.rewards.repository.DanapolyRewardsEntityRepository$getRewards$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.danapoly.data.rewards.repository.DanapolyRewardsEntityRepository$getRewards$$inlined$map$1$2$1 r0 = (id.dana.danapoly.data.rewards.repository.DanapolyRewardsEntityRepository$getRewards$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.danapoly.data.rewards.repository.DanapolyRewardsEntityRepository$getRewards$$inlined$map$1$2$1 r0 = new id.dana.danapoly.data.rewards.repository.DanapolyRewardsEntityRepository$getRewards$$inlined$map$1$2$1
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
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$BuiltInFictitiousFunctionClassFactory
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.danapoly.data.rewards.model.response.GetRewardsResponse r5 = (id.dana.danapoly.data.rewards.model.response.GetRewardsResponse) r5
                        id.dana.danapoly.domain.rewards.model.GetRewardResult r5 = id.dana.danapoly.data.rewards.mapper.GetRewardsResponseMapperKt.PlaceComponentResult(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.data.rewards.repository.DanapolyRewardsEntityRepository$getRewards$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }
}

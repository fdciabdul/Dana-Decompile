package id.dana.danapoly.data.config.repository;

import com.alibaba.griver.image.framework.utils.FileUtils;
import id.dana.danapoly.data.config.model.response.GetConfigurationResponse;
import id.dana.danapoly.data.config.model.response.PlayerInfoResponse;
import id.dana.danapoly.domain.config.model.PlayerInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@¨\u0006\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getPlayerInfo$$inlined$flatMapLatest$1", f = "DanapolyConfigEntityRepository.kt", i = {}, l = {FileUtils.JPEG_MARKER_EOI}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class DanapolyConfigEntityRepository$getPlayerInfo$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super PlayerInfo>, GetConfigurationResponse, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ DanapolyConfigEntityRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanapolyConfigEntityRepository$getPlayerInfo$$inlined$flatMapLatest$1(Continuation continuation, DanapolyConfigEntityRepository danapolyConfigEntityRepository) {
        super(3, continuation);
        this.this$0 = danapolyConfigEntityRepository;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super PlayerInfo> flowCollector, GetConfigurationResponse getConfigurationResponse, Continuation<? super Unit> continuation) {
        DanapolyConfigEntityRepository$getPlayerInfo$$inlined$flatMapLatest$1 danapolyConfigEntityRepository$getPlayerInfo$$inlined$flatMapLatest$1 = new DanapolyConfigEntityRepository$getPlayerInfo$$inlined$flatMapLatest$1(continuation, this.this$0);
        danapolyConfigEntityRepository$getPlayerInfo$$inlined$flatMapLatest$1.L$0 = flowCollector;
        danapolyConfigEntityRepository$getPlayerInfo$$inlined$flatMapLatest$1.L$1 = getConfigurationResponse;
        return danapolyConfigEntityRepository$getPlayerInfo$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            final GetConfigurationResponse getConfigurationResponse = (GetConfigurationResponse) this.L$1;
            String blockingFirst = this.this$0.KClassImpl$Data$declaredNonStaticMembers$2.createAccountData().getAvatarUrl().blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
            final String str = blockingFirst;
            DanapolyConfigEntityRepository danapolyConfigEntityRepository = this.this$0;
            Flow<PlayerInfoResponse> BuiltInFictitiousFunctionClassFactory = DanapolyConfigEntityRepository.MyBillsEntityDataFactory(danapolyConfigEntityRepository).BuiltInFictitiousFunctionClassFactory(getConfigurationResponse.getEventId());
            Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
            final Flow PlaceComponentResult = danapolyConfigEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
            Flow<PlayerInfo> flow = new Flow<PlayerInfo>() { // from class: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getPlayerInfo$lambda-5$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public final Object collect(FlowCollector<? super PlayerInfo> flowCollector2, Continuation continuation) {
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector2, getConfigurationResponse, str), continuation);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }

                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
                /* renamed from: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getPlayerInfo$lambda-5$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $KClassImpl$Data$declaredNonStaticMembers$2;
                    final /* synthetic */ String $MyBillsEntityDataFactory;
                    final /* synthetic */ GetConfigurationResponse $getAuthRequestContext;

                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    @DebugMetadata(c = "id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getPlayerInfo$lambda-5$$inlined$map$1$2", f = "DanapolyConfigEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                    /* renamed from: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getPlayerInfo$lambda-5$$inlined$map$1$2$1  reason: invalid class name */
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

                    public AnonymousClass2(FlowCollector flowCollector, GetConfigurationResponse getConfigurationResponse, String str) {
                        this.$KClassImpl$Data$declaredNonStaticMembers$2 = flowCollector;
                        this.$getAuthRequestContext = getConfigurationResponse;
                        this.$MyBillsEntityDataFactory = str;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getPlayerInfo$lambda5$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L14
                            r0 = r7
                            id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getPlayerInfo$lambda-5$$inlined$map$1$2$1 r0 = (id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getPlayerInfo$lambda5$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r1 = r1 & r2
                            if (r1 == 0) goto L14
                            int r7 = r0.label
                            int r7 = r7 + r2
                            r0.label = r7
                            goto L19
                        L14:
                            id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getPlayerInfo$lambda-5$$inlined$map$1$2$1 r0 = new id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getPlayerInfo$lambda-5$$inlined$map$1$2$1
                            r0.<init>(r7)
                        L19:
                            java.lang.Object r7 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L32
                            if (r2 != r3) goto L2a
                            kotlin.ResultKt.throwOnFailure(r7)
                            goto L51
                        L2a:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L32:
                            kotlin.ResultKt.throwOnFailure(r7)
                            kotlinx.coroutines.flow.FlowCollector r7 = r5.$KClassImpl$Data$declaredNonStaticMembers$2
                            r2 = r0
                            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                            id.dana.danapoly.data.config.model.response.PlayerInfoResponse r6 = (id.dana.danapoly.data.config.model.response.PlayerInfoResponse) r6
                            id.dana.danapoly.data.config.model.response.GetConfigurationResponse r2 = r5.$getAuthRequestContext
                            int r2 = r2.getCurrencyValue()
                            java.lang.String r4 = r5.$MyBillsEntityDataFactory
                            id.dana.danapoly.domain.config.model.PlayerInfo r6 = id.dana.danapoly.data.config.model.mapper.PlayerInfoMapperKt.toPlayerInfo(r6, r2, r4)
                            r0.label = r3
                            java.lang.Object r6 = r7.emit(r6, r0)
                            if (r6 != r1) goto L51
                            return r1
                        L51:
                            kotlin.Unit r6 = kotlin.Unit.INSTANCE
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getPlayerInfo$lambda5$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            };
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, flow, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

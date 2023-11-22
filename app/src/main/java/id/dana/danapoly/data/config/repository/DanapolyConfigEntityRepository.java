package id.dana.danapoly.data.config.repository;

import id.dana.danapoly.data.config.model.response.GetConfigurationResponse;
import id.dana.danapoly.data.config.repository.source.DanapolyConfigData;
import id.dana.danapoly.data.config.repository.source.DanapolyConfigDataFactory;
import id.dana.danapoly.di.DanapolyScope;
import id.dana.danapoly.domain.config.DanapolyConfigRepository;
import id.dana.danapoly.domain.config.model.DanapolyEvent;
import id.dana.danapoly.domain.config.model.PlayBoard;
import id.dana.danapoly.domain.config.model.PlayerInfo;
import id.dana.danapoly.ui.model.BackgroundColorType;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@DanapolyScope
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u001b¢\u0006\u0004\b \u0010!J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010\u0010\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u0014\u0010\u000e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001cR\u0013\u0010\f\u001a\u00020\u001dX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u001eR\u0013\u0010\n\u001a\u00020\u001dX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u001e"}, d2 = {"Lid/dana/danapoly/data/config/repository/DanapolyConfigEntityRepository;", "Lid/dana/danapoly/domain/config/DanapolyConfigRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/danapoly/data/config/model/response/GetConfigurationResponse;", "getErrorConfigVersion", "()Lkotlinx/coroutines/flow/Flow;", "", "MyBillsEntityDataFactory", "Lid/dana/danapoly/domain/config/model/DanapolyEvent;", "PlaceComponentResult", "Lid/dana/danapoly/ui/model/BackgroundColorType;", "getAuthRequestContext", "Lid/dana/danapoly/domain/config/model/PlayBoard;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danapoly/domain/config/model/PlayerInfo;", "BuiltInFictitiousFunctionClassFactory", "", "scheduleImpl", "p0", "(Lid/dana/danapoly/ui/model/BackgroundColorType;)Lkotlinx/coroutines/flow/Flow;", "", "moveToNextValue", "()V", "Lid/dana/danapoly/data/config/model/response/GetConfigurationResponse;", "Lid/dana/danapoly/data/config/repository/source/DanapolyConfigDataFactory;", "Lid/dana/danapoly/data/config/repository/source/DanapolyConfigDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/danapoly/data/config/repository/source/DanapolyConfigData;", "Lkotlin/Lazy;", "p1", "<init>", "(Lid/dana/danapoly/data/config/repository/source/DanapolyConfigDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyConfigEntityRepository implements DanapolyConfigRepository, HoldLoginV1Repository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    GetConfigurationResponse MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final DanapolyConfigDataFactory BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final HoldLoginV1EntityRepository KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy getAuthRequestContext;

    @Inject
    public DanapolyConfigEntityRepository(DanapolyConfigDataFactory danapolyConfigDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(danapolyConfigDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = danapolyConfigDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = holdLoginV1EntityRepository;
        this.PlaceComponentResult = LazyKt.lazy(new Function0<DanapolyConfigData>() { // from class: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$networkDanapolyConfigData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanapolyConfigData invoke() {
                DanapolyConfigDataFactory danapolyConfigDataFactory2;
                danapolyConfigDataFactory2 = DanapolyConfigEntityRepository.this.BuiltInFictitiousFunctionClassFactory;
                return danapolyConfigDataFactory2.createData2("network");
            }
        });
        this.getAuthRequestContext = LazyKt.lazy(new Function0<DanapolyConfigData>() { // from class: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$localDanapolyConfigData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanapolyConfigData invoke() {
                DanapolyConfigDataFactory danapolyConfigDataFactory2;
                danapolyConfigDataFactory2 = DanapolyConfigEntityRepository.this.BuiltInFictitiousFunctionClassFactory;
                return danapolyConfigDataFactory2.createData2("local");
            }
        });
    }

    private Flow<GetConfigurationResponse> getErrorConfigVersion() {
        Flow<GetConfigurationResponse> flowOf;
        GetConfigurationResponse getConfigurationResponse = this.MyBillsEntityDataFactory;
        if (getConfigurationResponse == null || (flowOf = FlowKt.flowOf(getConfigurationResponse)) == null) {
            Flow<GetConfigurationResponse> PlaceComponentResult = ((DanapolyConfigData) this.PlaceComponentResult.getValue()).PlaceComponentResult();
            Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
            final Flow PlaceComponentResult2 = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(PlaceComponentResult);
            return new Flow<GetConfigurationResponse>() { // from class: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getConfig$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public final Object collect(FlowCollector<? super GetConfigurationResponse> flowCollector, Continuation continuation) {
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }

                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
                /* renamed from: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getConfig$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $PlaceComponentResult;
                    final /* synthetic */ DanapolyConfigEntityRepository BuiltInFictitiousFunctionClassFactory;

                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    @DebugMetadata(c = "id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getConfig$$inlined$map$1$2", f = "DanapolyConfigEntityRepository.kt", i = {}, l = {225}, m = "emit", n = {}, s = {})
                    /* renamed from: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getConfig$$inlined$map$1$2$1  reason: invalid class name */
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

                    public AnonymousClass2(FlowCollector flowCollector, DanapolyConfigEntityRepository danapolyConfigEntityRepository) {
                        this.$PlaceComponentResult = flowCollector;
                        this.BuiltInFictitiousFunctionClassFactory = danapolyConfigEntityRepository;
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
                            boolean r0 = r6 instanceof id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getConfig$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L14
                            r0 = r6
                            id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getConfig$$inlined$map$1$2$1 r0 = (id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getConfig$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r1 = r1 & r2
                            if (r1 == 0) goto L14
                            int r6 = r0.label
                            int r6 = r6 + r2
                            r0.label = r6
                            goto L19
                        L14:
                            id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getConfig$$inlined$map$1$2$1 r0 = new id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getConfig$$inlined$map$1$2$1
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
                            id.dana.danapoly.data.config.model.response.GetConfigurationResponse r5 = (id.dana.danapoly.data.config.model.response.GetConfigurationResponse) r5
                            id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository r2 = r4.BuiltInFictitiousFunctionClassFactory
                            r2.MyBillsEntityDataFactory = r5
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L49
                            return r1
                        L49:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getConfig$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            };
        }
        return flowOf;
    }

    @Override // id.dana.danapoly.domain.config.DanapolyConfigRepository
    public final Flow<PlayBoard> KClassImpl$Data$declaredNonStaticMembers$2() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        return FlowKt.transformLatest(getErrorConfigVersion(), new DanapolyConfigEntityRepository$getPlayBoard$$inlined$flatMapLatest$1(null, objectRef, this));
    }

    @Override // id.dana.danapoly.domain.config.DanapolyConfigRepository
    public final Flow<PlayerInfo> BuiltInFictitiousFunctionClassFactory() {
        return FlowKt.transformLatest(getErrorConfigVersion(), new DanapolyConfigEntityRepository$getPlayerInfo$$inlined$flatMapLatest$1(null, this));
    }

    @Override // id.dana.danapoly.domain.config.DanapolyConfigRepository
    public final Flow<String> MyBillsEntityDataFactory() {
        final Flow<GetConfigurationResponse> errorConfigVersion = getErrorConfigVersion();
        return new Flow<String>() { // from class: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventId$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super String> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventId$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventId$$inlined$map$1$2", f = "DanapolyConfigEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventId$$inlined$map$1$2$1  reason: invalid class name */
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
                        boolean r0 = r6 instanceof id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventId$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventId$$inlined$map$1$2$1 r0 = (id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventId$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventId$$inlined$map$1$2$1 r0 = new id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventId$$inlined$map$1$2$1
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
                        id.dana.danapoly.data.config.model.response.GetConfigurationResponse r5 = (id.dana.danapoly.data.config.model.response.GetConfigurationResponse) r5
                        java.lang.String r5 = r5.getEventId()
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventId$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.danapoly.domain.config.DanapolyConfigRepository
    public final Flow<DanapolyEvent> PlaceComponentResult() {
        final Flow<GetConfigurationResponse> errorConfigVersion = getErrorConfigVersion();
        return new Flow<DanapolyEvent>() { // from class: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventIdWithExpiryDate$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super DanapolyEvent> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventIdWithExpiryDate$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $BuiltInFictitiousFunctionClassFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventIdWithExpiryDate$$inlined$map$1$2", f = "DanapolyConfigEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventIdWithExpiryDate$$inlined$map$1$2$1  reason: invalid class name */
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
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventIdWithExpiryDate$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r7
                        id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventIdWithExpiryDate$$inlined$map$1$2$1 r0 = (id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventIdWithExpiryDate$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r7 = r0.label
                        int r7 = r7 + r2
                        r0.label = r7
                        goto L19
                    L14:
                        id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventIdWithExpiryDate$$inlined$map$1$2$1 r0 = new id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventIdWithExpiryDate$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L19:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L52
                    L2a:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L32:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$BuiltInFictitiousFunctionClassFactory
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.danapoly.data.config.model.response.GetConfigurationResponse r6 = (id.dana.danapoly.data.config.model.response.GetConfigurationResponse) r6
                        id.dana.danapoly.domain.config.model.DanapolyEvent r2 = new id.dana.danapoly.domain.config.model.DanapolyEvent
                        java.lang.String r4 = r6.getEventId()
                        java.lang.Long r6 = r6.getExpiryDate()
                        r2.<init>(r4, r6)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r2, r0)
                        if (r6 != r1) goto L52
                        return r1
                    L52:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.data.config.repository.DanapolyConfigEntityRepository$getEventIdWithExpiryDate$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    public static final /* synthetic */ DanapolyConfigData MyBillsEntityDataFactory(DanapolyConfigEntityRepository danapolyConfigEntityRepository) {
        return (DanapolyConfigData) danapolyConfigEntityRepository.PlaceComponentResult.getValue();
    }

    @Override // id.dana.danapoly.domain.config.DanapolyConfigRepository
    public final Flow<BackgroundColorType> getAuthRequestContext() {
        return ((DanapolyConfigData) this.getAuthRequestContext.getValue()).getAuthRequestContext();
    }

    @Override // id.dana.danapoly.domain.config.DanapolyConfigRepository
    public final Flow<Boolean> scheduleImpl() {
        DanapolyConfigData danapolyConfigData = (DanapolyConfigData) this.getAuthRequestContext.getValue();
        String blockingFirst = this.KClassImpl$Data$declaredNonStaticMembers$2.createAccountData().getUserId().blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return danapolyConfigData.MyBillsEntityDataFactory(blockingFirst);
    }

    @Override // id.dana.danapoly.domain.config.DanapolyConfigRepository
    public final Flow<Boolean> getAuthRequestContext(BackgroundColorType p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return ((DanapolyConfigData) this.getAuthRequestContext.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    @Override // id.dana.danapoly.domain.config.DanapolyConfigRepository
    public final void moveToNextValue() {
        DanapolyConfigData danapolyConfigData = (DanapolyConfigData) this.getAuthRequestContext.getValue();
        String blockingFirst = this.KClassImpl$Data$declaredNonStaticMembers$2.createAccountData().getUserId().blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        danapolyConfigData.KClassImpl$Data$declaredNonStaticMembers$2(blockingFirst);
    }
}

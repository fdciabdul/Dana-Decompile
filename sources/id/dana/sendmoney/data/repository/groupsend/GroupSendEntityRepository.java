package id.dana.sendmoney.data.repository.groupsend;

import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.sendmoney.data.api.groupsend.detail.model.request.BizGroupDetailEntityRequest;
import id.dana.sendmoney.data.api.groupsend.detail.model.response.BizGroupDetailEntityResult;
import id.dana.sendmoney.data.api.groupsend.init.mapper.BizGroupInitEntityMapperKt;
import id.dana.sendmoney.data.api.groupsend.init.model.response.BizGroupTransferInitResult;
import id.dana.sendmoney.data.api.groupsend.modify.mapper.BizGroupModifyEntityMapperKt;
import id.dana.sendmoney.data.api.groupsend.modify.model.response.BizGroupModifyEntityResult;
import id.dana.sendmoney.data.api.groupsend.query.model.request.BizGroupQueryEntityRequest;
import id.dana.sendmoney.data.api.groupsend.query.model.response.BizGroupQueryEntityResult;
import id.dana.sendmoney.data.api.groupsend.submit.mapper.BizGroupTransferEntityMapperKt;
import id.dana.sendmoney.data.api.groupsend.submit.model.response.BizGroupTransferSubmitResult;
import id.dana.sendmoney.data.config.groupsend.model.GroupSendScenarioConfigEntity;
import id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityData;
import id.dana.sendmoney.data.repository.groupsend.source.GroupSendEntityDataFactory;
import id.dana.sendmoney.di.scope.GroupSendScope;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import id.dana.sendmoney.domain.groupsend.interactor.ConfirmSendMoneyGroup;
import id.dana.sendmoney.domain.groupsend.interactor.InitSendMoneyGroup;
import id.dana.sendmoney.domain.groupsend.model.config.GroupSendScenarioConfig;
import id.dana.sendmoney.domain.groupsend.model.detail.BizGroupDetailResult;
import id.dana.sendmoney.domain.groupsend.model.init.SendMoneyGroupInit;
import id.dana.sendmoney.domain.groupsend.model.modify.BizGroupModifyRequest;
import id.dana.sendmoney.domain.groupsend.model.modify.BizGroupModifyResult;
import id.dana.sendmoney.domain.groupsend.model.query.BizGroupQueryResult;
import id.dana.sendmoney.domain.groupsend.model.submit.SendMoneyGroupConfirm;
import java.util.List;
import java.util.UUID;
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

@GroupSendScope
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020 \u0012\u0006\u0010\u000f\u001a\u00020\"¢\u0006\u0004\b&\u0010'J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000bJ%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\u0006\u0010\u0004\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0015J\u001b\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\u000bJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00190\u00052\u0006\u0010\u0004\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0007\u0010\u001aJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00052\u0006\u0010\u0004\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\n\u0010\u001dJ\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00052\u0006\u0010\u0004\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u001fR\u0014\u0010\n\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010!R\u0014\u0010\r\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010#R\u0013\u0010\u0007\u001a\u00020$X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010%R\u0013\u0010\u0011\u001a\u00020$X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010%R\u0013\u0010\u0013\u001a\u00020$X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\r\u0010%"}, d2 = {"Lid/dana/sendmoney/data/repository/groupsend/GroupSendEntityRepository;", "Lid/dana/sendmoney/domain/groupsend/GroupSendRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lid/dana/sendmoney/domain/groupsend/interactor/ConfirmSendMoneyGroup$Param;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/groupsend/model/submit/SendMoneyGroupConfirm;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/domain/groupsend/interactor/ConfirmSendMoneyGroup$Param;)Lkotlinx/coroutines/flow/Flow;", "", "MyBillsEntityDataFactory", "()Lkotlinx/coroutines/flow/Flow;", "", "PlaceComponentResult", "", "p1", "Lid/dana/sendmoney/domain/groupsend/model/detail/BizGroupDetailResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "getAuthRequestContext", "Lid/dana/sendmoney/domain/groupsend/model/query/BizGroupQueryResult;", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "", "Lid/dana/sendmoney/domain/groupsend/model/config/GroupSendScenarioConfig;", "Lid/dana/sendmoney/domain/groupsend/interactor/InitSendMoneyGroup$Param;", "Lid/dana/sendmoney/domain/groupsend/model/init/SendMoneyGroupInit;", "(Lid/dana/sendmoney/domain/groupsend/interactor/InitSendMoneyGroup$Param;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyRequest;", "Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyResult;", "(Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyRequest;)Lkotlinx/coroutines/flow/Flow;", "", "(I)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityDataFactory;", "Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityData;", "Lkotlin/Lazy;", "<init>", "(Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendEntityRepository implements GroupSendRepository, HoldLoginV1Repository {
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GroupSendEntityDataFactory MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository PlaceComponentResult;

    @Inject
    public GroupSendEntityRepository(GroupSendEntityDataFactory groupSendEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(groupSendEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.MyBillsEntityDataFactory = groupSendEntityDataFactory;
        this.PlaceComponentResult = holdLoginV1EntityRepository;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<GroupSendEntityData>() { // from class: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$splitGroupSendEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GroupSendEntityData invoke() {
                GroupSendEntityDataFactory groupSendEntityDataFactory2;
                groupSendEntityDataFactory2 = GroupSendEntityRepository.this.MyBillsEntityDataFactory;
                return groupSendEntityDataFactory2.createData2("split");
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<GroupSendEntityData>() { // from class: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$localGroupSendEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GroupSendEntityData invoke() {
                GroupSendEntityDataFactory groupSendEntityDataFactory2;
                groupSendEntityDataFactory2 = GroupSendEntityRepository.this.MyBillsEntityDataFactory;
                return groupSendEntityDataFactory2.createData2("local");
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<GroupSendEntityData>() { // from class: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$networkGroupSendEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GroupSendEntityData invoke() {
                GroupSendEntityDataFactory groupSendEntityDataFactory2;
                groupSendEntityDataFactory2 = GroupSendEntityRepository.this.MyBillsEntityDataFactory;
                return groupSendEntityDataFactory2.createData2("network");
            }
        });
    }

    @Override // id.dana.sendmoney.domain.groupsend.GroupSendRepository
    public final Flow<SendMoneyGroupConfirm> BuiltInFictitiousFunctionClassFactory(ConfirmSendMoneyGroup.Param p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String obj = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        Intrinsics.checkNotNullParameter(obj, "");
        p0.moveToNextValue = obj;
        final Flow<BizGroupTransferSubmitResult> BuiltInFictitiousFunctionClassFactory = ((GroupSendEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).BuiltInFictitiousFunctionClassFactory(BizGroupTransferEntityMapperKt.toBizGroupTransferSubmitRequest(p0));
        Flow<SendMoneyGroupConfirm> flow = new Flow<SendMoneyGroupConfirm>() { // from class: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$confirmSendMoneyGroup$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super SendMoneyGroupConfirm> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$confirmSendMoneyGroup$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$confirmSendMoneyGroup$$inlined$map$1$2", f = "GroupSendEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$confirmSendMoneyGroup$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$confirmSendMoneyGroup$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$confirmSendMoneyGroup$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$confirmSendMoneyGroup$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$confirmSendMoneyGroup$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$confirmSendMoneyGroup$$inlined$map$1$2$1
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
                        id.dana.sendmoney.data.api.groupsend.submit.model.response.BizGroupTransferSubmitResult r5 = (id.dana.sendmoney.data.api.groupsend.submit.model.response.BizGroupTransferSubmitResult) r5
                        id.dana.sendmoney.domain.groupsend.model.submit.SendMoneyGroupConfirm r5 = id.dana.sendmoney.data.api.groupsend.submit.mapper.BizGroupTransferEntityMapperKt.toSendMoneyGroupConfirm(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$confirmSendMoneyGroup$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
        Intrinsics.checkNotNullParameter(flow, "");
        return this.PlaceComponentResult.PlaceComponentResult(flow);
    }

    @Override // id.dana.sendmoney.domain.groupsend.GroupSendRepository
    public final Flow<Integer> MyBillsEntityDataFactory() {
        return ((GroupSendEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.sendmoney.domain.groupsend.GroupSendRepository
    public final Flow<Boolean> PlaceComponentResult() {
        return ((GroupSendEntityData) this.getAuthRequestContext.getValue()).getAuthRequestContext();
    }

    @Override // id.dana.sendmoney.domain.groupsend.GroupSendRepository
    public final Flow<BizGroupDetailResult> KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        final Flow<BizGroupDetailEntityResult> authRequestContext = ((GroupSendEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).getAuthRequestContext(new BizGroupDetailEntityRequest(p0, p1));
        Flow<BizGroupDetailResult> flow = new Flow<BizGroupDetailResult>() { // from class: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendDetail$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super BizGroupDetailResult> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendDetail$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $BuiltInFictitiousFunctionClassFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendDetail$$inlined$map$1$2", f = "GroupSendEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendDetail$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendDetail$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendDetail$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendDetail$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendDetail$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendDetail$$inlined$map$1$2$1
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
                        id.dana.sendmoney.data.api.groupsend.detail.model.response.BizGroupDetailEntityResult r5 = (id.dana.sendmoney.data.api.groupsend.detail.model.response.BizGroupDetailEntityResult) r5
                        id.dana.sendmoney.domain.groupsend.model.detail.BizGroupDetailResult r5 = id.dana.sendmoney.data.api.groupsend.detail.mapper.GroupDetailEntityMapperKt.toBizGroupDetailResult(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendDetail$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
        Intrinsics.checkNotNullParameter(flow, "");
        return this.PlaceComponentResult.PlaceComponentResult(flow);
    }

    @Override // id.dana.sendmoney.domain.groupsend.GroupSendRepository
    public final Flow<Integer> getAuthRequestContext() {
        return ((GroupSendEntityData) this.getAuthRequestContext.getValue()).PlaceComponentResult();
    }

    @Override // id.dana.sendmoney.domain.groupsend.GroupSendRepository
    public final Flow<Integer> KClassImpl$Data$declaredNonStaticMembers$2() {
        return ((GroupSendEntityData) this.getAuthRequestContext.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.sendmoney.domain.groupsend.GroupSendRepository
    public final Flow<BizGroupQueryResult> getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final Flow<BizGroupQueryEntityResult> BuiltInFictitiousFunctionClassFactory = ((GroupSendEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).BuiltInFictitiousFunctionClassFactory(new BizGroupQueryEntityRequest(p0));
        Flow<BizGroupQueryResult> flow = new Flow<BizGroupQueryResult>() { // from class: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendQuery$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super BizGroupQueryResult> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendQuery$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $getAuthRequestContext;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendQuery$$inlined$map$1$2", f = "GroupSendEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendQuery$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendQuery$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendQuery$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendQuery$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendQuery$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendQuery$$inlined$map$1$2$1
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
                        id.dana.sendmoney.data.api.groupsend.query.model.response.BizGroupQueryEntityResult r5 = (id.dana.sendmoney.data.api.groupsend.query.model.response.BizGroupQueryEntityResult) r5
                        id.dana.sendmoney.domain.groupsend.model.query.BizGroupQueryResult r5 = id.dana.sendmoney.data.api.groupsend.query.mapper.GroupSendQueryEntityMapperKt.toBizGroupQueryResult(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendQuery$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
        Intrinsics.checkNotNullParameter(flow, "");
        return this.PlaceComponentResult.PlaceComponentResult(flow);
    }

    @Override // id.dana.sendmoney.domain.groupsend.GroupSendRepository
    public final Flow<List<GroupSendScenarioConfig>> BuiltInFictitiousFunctionClassFactory() {
        final Flow<List<GroupSendScenarioConfigEntity>> MyBillsEntityDataFactory = ((GroupSendEntityData) this.getAuthRequestContext.getValue()).MyBillsEntityDataFactory();
        return (Flow) new Flow<List<? extends GroupSendScenarioConfig>>() { // from class: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendScenarios$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super List<? extends GroupSendScenarioConfig>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendScenarios$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $KClassImpl$Data$declaredNonStaticMembers$2;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendScenarios$$inlined$map$1$2", f = "GroupSendEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendScenarios$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
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
                    this.$KClassImpl$Data$declaredNonStaticMembers$2 = flowCollector;
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendScenarios$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendScenarios$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendScenarios$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendScenarios$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendScenarios$$inlined$map$1$2$1
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
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$KClassImpl$Data$declaredNonStaticMembers$2
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.util.List r5 = (java.util.List) r5
                        java.util.List r5 = id.dana.sendmoney.data.config.groupsend.mapper.GroupSendScenarioEntityMapperKt.toGroupSendScenarioConfigList(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$getGroupSendScenarios$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.sendmoney.domain.groupsend.GroupSendRepository
    public final Flow<SendMoneyGroupInit> BuiltInFictitiousFunctionClassFactory(InitSendMoneyGroup.Param p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final Flow<BizGroupTransferInitResult> authRequestContext = ((GroupSendEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).getAuthRequestContext(BizGroupInitEntityMapperKt.toBizGroupTransferInitRequest(p0));
        Flow<SendMoneyGroupInit> flow = new Flow<SendMoneyGroupInit>() { // from class: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$initSendMoneyGroup$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super SendMoneyGroupInit> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$initSendMoneyGroup$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $BuiltInFictitiousFunctionClassFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$initSendMoneyGroup$$inlined$map$1$2", f = "GroupSendEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$initSendMoneyGroup$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$initSendMoneyGroup$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$initSendMoneyGroup$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$initSendMoneyGroup$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$initSendMoneyGroup$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$initSendMoneyGroup$$inlined$map$1$2$1
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
                        id.dana.sendmoney.data.api.groupsend.init.model.response.BizGroupTransferInitResult r5 = (id.dana.sendmoney.data.api.groupsend.init.model.response.BizGroupTransferInitResult) r5
                        id.dana.sendmoney.domain.groupsend.model.init.SendMoneyGroupInit r5 = id.dana.sendmoney.data.api.groupsend.init.mapper.BizGroupInitEntityMapperKt.toSendMoneyGroupInit(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$initSendMoneyGroup$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
        Intrinsics.checkNotNullParameter(flow, "");
        return this.PlaceComponentResult.PlaceComponentResult(flow);
    }

    @Override // id.dana.sendmoney.domain.groupsend.GroupSendRepository
    public final Flow<BizGroupModifyResult> MyBillsEntityDataFactory(BizGroupModifyRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Flow<BizGroupModifyEntityResult> PlaceComponentResult = ((GroupSendEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).PlaceComponentResult(BizGroupModifyEntityMapperKt.toBizGroupModifyEntityRequest(p0));
        Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
        final Flow PlaceComponentResult2 = this.PlaceComponentResult.PlaceComponentResult(PlaceComponentResult);
        return new Flow<BizGroupModifyResult>() { // from class: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$modifyGroup$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super BizGroupModifyResult> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$modifyGroup$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$modifyGroup$$inlined$map$1$2", f = "GroupSendEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$modifyGroup$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$modifyGroup$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$modifyGroup$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$modifyGroup$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$modifyGroup$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$modifyGroup$$inlined$map$1$2$1
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
                        id.dana.sendmoney.data.api.groupsend.modify.model.response.BizGroupModifyEntityResult r5 = (id.dana.sendmoney.data.api.groupsend.modify.model.response.BizGroupModifyEntityResult) r5
                        id.dana.sendmoney.domain.groupsend.model.modify.BizGroupModifyResult r5 = id.dana.sendmoney.data.api.groupsend.modify.mapper.BizGroupModifyEntityMapperKt.toBizGroupModifyResult(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.groupsend.GroupSendEntityRepository$modifyGroup$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.sendmoney.domain.groupsend.GroupSendRepository
    public final Flow<Unit> getAuthRequestContext(int p0) {
        return ((GroupSendEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).MyBillsEntityDataFactory(p0);
    }
}

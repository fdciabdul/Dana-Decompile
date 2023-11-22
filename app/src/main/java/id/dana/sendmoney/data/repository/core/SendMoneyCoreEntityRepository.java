package id.dana.sendmoney.data.repository.core;

import id.dana.sendmoney.data.api.core.mapper.TransferInitEntityMapperKt;
import id.dana.sendmoney.data.api.core.model.response.TransferInitResultEntity;
import id.dana.sendmoney.data.config.core.model.SendMoneyApiMigrationConfigEntity;
import id.dana.sendmoney.data.repository.core.source.SendMoneyCoreEntityData;
import id.dana.sendmoney.data.repository.core.source.split.SplitSendMoneyCoreEntityData;
import id.dana.sendmoney.domain.core.SendMoneyCoreRepository;
import id.dana.sendmoney.domain.core.model.config.SendMoneyApiMigrationConfig;
import id.dana.sendmoney.domain.core.model.init.TransferInitRequest;
import id.dana.sendmoney.domain.core.model.init.TransferInitResult;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/sendmoney/data/repository/core/SendMoneyCoreEntityRepository;", "Lid/dana/sendmoney/domain/core/SendMoneyCoreRepository;", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/core/model/config/SendMoneyApiMigrationConfig;", "PlaceComponentResult", "()Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/core/model/init/TransferInitRequest;", "p0", "Lid/dana/sendmoney/domain/core/model/init/TransferInitResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/domain/core/model/init/TransferInitRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/repository/core/source/SendMoneyCoreEntityData;", "Lid/dana/sendmoney/data/repository/core/source/SendMoneyCoreEntityData;", "Lid/dana/sendmoney/data/repository/core/source/split/SplitSendMoneyCoreEntityData;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/data/repository/core/source/split/SplitSendMoneyCoreEntityData;", "getAuthRequestContext", "p1", "<init>", "(Lid/dana/sendmoney/data/repository/core/source/split/SplitSendMoneyCoreEntityData;Lid/dana/sendmoney/data/repository/core/source/SendMoneyCoreEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SendMoneyCoreEntityRepository implements SendMoneyCoreRepository {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SplitSendMoneyCoreEntityData getAuthRequestContext;
    private final SendMoneyCoreEntityData PlaceComponentResult;

    @Inject
    public SendMoneyCoreEntityRepository(SplitSendMoneyCoreEntityData splitSendMoneyCoreEntityData, SendMoneyCoreEntityData sendMoneyCoreEntityData) {
        Intrinsics.checkNotNullParameter(splitSendMoneyCoreEntityData, "");
        Intrinsics.checkNotNullParameter(sendMoneyCoreEntityData, "");
        this.getAuthRequestContext = splitSendMoneyCoreEntityData;
        this.PlaceComponentResult = sendMoneyCoreEntityData;
    }

    @Override // id.dana.sendmoney.domain.core.SendMoneyCoreRepository
    public final Flow<SendMoneyApiMigrationConfig> PlaceComponentResult() {
        final Flow<SendMoneyApiMigrationConfigEntity> PlaceComponentResult = this.getAuthRequestContext.PlaceComponentResult();
        return new Flow<SendMoneyApiMigrationConfig>() { // from class: id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getSendMoneyApiMigrationConfig$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super SendMoneyApiMigrationConfig> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getSendMoneyApiMigrationConfig$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $KClassImpl$Data$declaredNonStaticMembers$2;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getSendMoneyApiMigrationConfig$$inlined$map$1$2", f = "SendMoneyCoreEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getSendMoneyApiMigrationConfig$$inlined$map$1$2$1  reason: invalid class name */
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getSendMoneyApiMigrationConfig$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getSendMoneyApiMigrationConfig$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getSendMoneyApiMigrationConfig$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getSendMoneyApiMigrationConfig$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getSendMoneyApiMigrationConfig$$inlined$map$1$2$1
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
                        id.dana.sendmoney.data.config.core.model.SendMoneyApiMigrationConfigEntity r5 = (id.dana.sendmoney.data.config.core.model.SendMoneyApiMigrationConfigEntity) r5
                        id.dana.sendmoney.domain.core.model.config.SendMoneyApiMigrationConfig r5 = id.dana.sendmoney.data.config.core.mapper.SendMoneyApiMigrationEntityMapperKt.toSendMoneyApiMigrationConfig(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getSendMoneyApiMigrationConfig$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.sendmoney.domain.core.SendMoneyCoreRepository
    public final Flow<TransferInitResult> BuiltInFictitiousFunctionClassFactory(TransferInitRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final Flow<TransferInitResultEntity> BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(TransferInitEntityMapperKt.toTransferInitRequestEntity(p0));
        return new Flow<TransferInitResult>() { // from class: id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getTransferBalanceInit$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super TransferInitResult> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getTransferBalanceInit$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getTransferBalanceInit$$inlined$map$1$2", f = "SendMoneyCoreEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getTransferBalanceInit$$inlined$map$1$2$1  reason: invalid class name */
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getTransferBalanceInit$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getTransferBalanceInit$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getTransferBalanceInit$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getTransferBalanceInit$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getTransferBalanceInit$$inlined$map$1$2$1
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
                        id.dana.sendmoney.data.api.core.model.response.TransferInitResultEntity r5 = (id.dana.sendmoney.data.api.core.model.response.TransferInitResultEntity) r5
                        id.dana.sendmoney.domain.core.model.init.TransferInitResult r5 = id.dana.sendmoney.data.api.core.mapper.TransferInitEntityMapperKt.toTransferInitResult(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository$getTransferBalanceInit$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }
}

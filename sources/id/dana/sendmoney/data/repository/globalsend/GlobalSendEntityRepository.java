package id.dana.sendmoney.data.repository.globalsend;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.card.repository.CardCredentialEntityRepository;
import id.dana.data.encryptcardno.CardCredInfo;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.domain.card.repository.CardCredentialRepository;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import id.dana.sendmoney.data.api.globalsend.beneficiary.mapper.QueryBeneficiaryEntityMapperKt;
import id.dana.sendmoney.data.api.globalsend.beneficiary.response.QueryBeneficiaryResultEntity;
import id.dana.sendmoney.data.api.globalsend.country.model.CountryEntity;
import id.dana.sendmoney.data.api.globalsend.delete.DeleteBeneficiaryRequestEntity;
import id.dana.sendmoney.data.api.globalsend.init.mapper.GlobalTransferInitMapperKt;
import id.dana.sendmoney.data.api.globalsend.init.model.response.GlobalTransferInitResultEntity;
import id.dana.sendmoney.data.api.globalsend.province.model.ProvinceEntity;
import id.dana.sendmoney.data.api.globalsend.transferSubmit.mapper.TransferSubmitEntityMapperKt;
import id.dana.sendmoney.data.api.globalsend.transferSubmit.response.TransferSubmitResultEntity;
import id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData;
import id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityDataFactory;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import id.dana.sendmoney.domain.globalsend.model.beneficiary.request.QueryBeneficiaryRequest;
import id.dana.sendmoney.domain.globalsend.model.beneficiary.response.QueryBeneficiaryResult;
import id.dana.sendmoney.domain.globalsend.model.country.Country;
import id.dana.sendmoney.domain.globalsend.model.init.GlobalTransferInitRequest;
import id.dana.sendmoney.domain.globalsend.model.init.GlobalTransferInitResult;
import id.dana.sendmoney.domain.globalsend.model.province.Province;
import id.dana.sendmoney.domain.globalsend.model.sender.SenderDetail;
import id.dana.sendmoney.domain.globalsend.model.transfersubmit.request.TransferSubmitRequest;
import id.dana.sendmoney.domain.globalsend.model.transfersubmit.response.TransferSubmitResult;
import id.dana.sendmoney.domain.globalsend.model.validate.TransferValidateRequest;
import id.dana.sendmoney.domain.globalsend.model.validate.TransferValidateResult;
import io.reactivex.Observable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u00018B!\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020,\u0012\u0006\u00104\u001a\u00020.\u0012\u0006\u00105\u001a\u00020*¢\u0006\u0004\b6\u00107J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nH\u0096\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006H\u0016¢\u0006\u0004\b\b\u0010\u0015J#\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00120\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\tJ\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0015J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00062\u0006\u0010\u0005\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001b\u0010\u001eJ\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020 0\u00062\u0006\u0010\u0005\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\b\u0010!J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\"0\u00062\u0006\u0010\u0005\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u0014\u0010#J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\"0\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\tJ\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020%0\u00062\u0006\u0010\u0005\u001a\u00020$H\u0016¢\u0006\u0004\b\u0018\u0010&J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020(0\u00062\u0006\u0010\u0005\u001a\u00020'H\u0016¢\u0006\u0004\b\u0014\u0010)R\u0014\u0010\b\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010+R\u0014\u0010\u0014\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010-R\u0014\u0010\u0018\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010/R\u0013\u0010\u001a\u001a\u000200X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0018\u00101R\u0013\u0010\u001b\u001a\u000200X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u00101R\u0013\u00103\u001a\u000200X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b2\u00101"}, d2 = {"Lid/dana/sendmoney/data/repository/globalsend/GlobalSendEntityRepository;", "Lid/dana/sendmoney/domain/globalsend/GlobalSendRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lid/dana/domain/card/repository/CardCredentialRepository;", "", "p0", "Lkotlinx/coroutines/flow/Flow;", "", "PlaceComponentResult", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "", "Lio/reactivex/Observable;", "encryptCardCredentials", "(Ljava/util/Map;)Lio/reactivex/Observable;", "encryptCardCredentialsFlow", "(Ljava/util/Map;)Lkotlinx/coroutines/flow/Flow;", "getCardCredentialPublicKey", "()Lio/reactivex/Observable;", "", "Lid/dana/sendmoney/domain/globalsend/model/country/Country;", "getAuthRequestContext", "()Lkotlinx/coroutines/flow/Flow;", "", "Lid/dana/sendmoney/domain/globalsend/model/province/Province;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/domain/globalsend/model/sender/SenderDetail;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitRequest;", "Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitResult;", "(Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/globalsend/model/beneficiary/request/QueryBeneficiaryRequest;", "Lid/dana/sendmoney/domain/globalsend/model/beneficiary/response/QueryBeneficiaryResult;", "(Lid/dana/sendmoney/domain/globalsend/model/beneficiary/request/QueryBeneficiaryRequest;)Lkotlinx/coroutines/flow/Flow;", "", "(Lid/dana/sendmoney/domain/globalsend/model/sender/SenderDetail;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/globalsend/model/transfersubmit/request/TransferSubmitRequest;", "Lid/dana/sendmoney/domain/globalsend/model/transfersubmit/response/TransferSubmitResult;", "(Lid/dana/sendmoney/domain/globalsend/model/transfersubmit/request/TransferSubmitRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateRequest;", "Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateResult;", "(Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/card/repository/CardCredentialEntityRepository;", "Lid/dana/data/card/repository/CardCredentialEntityRepository;", "Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityDataFactory;", "Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityData;", "Lkotlin/Lazy;", "scheduleImpl", "moveToNextValue", "p1", "p2", "<init>", "(Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;Lid/dana/data/card/repository/CardCredentialEntityRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GlobalSendEntityRepository implements GlobalSendRepository, HoldLoginV1Repository, CardCredentialRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CardCredentialEntityRepository PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository KClassImpl$Data$declaredNonStaticMembers$2;
    private final GlobalSendEntityDataFactory getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy moveToNextValue;

    @Override // id.dana.domain.card.repository.CardCredentialRepository
    public final Observable<String> encryptCardCredentials(Map<String, String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.PlaceComponentResult.encryptCardCredentials(p0);
    }

    @Override // id.dana.domain.card.repository.CardCredentialRepository
    public final Flow<String> encryptCardCredentialsFlow(Map<String, String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.PlaceComponentResult.encryptCardCredentialsFlow(p0);
    }

    @Override // id.dana.domain.card.repository.CardCredentialRepository
    public final Observable<String> getCardCredentialPublicKey() {
        return this.PlaceComponentResult.getCardCredentialPublicKey();
    }

    @Inject
    public GlobalSendEntityRepository(GlobalSendEntityDataFactory globalSendEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository, CardCredentialEntityRepository cardCredentialEntityRepository) {
        Intrinsics.checkNotNullParameter(globalSendEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        Intrinsics.checkNotNullParameter(cardCredentialEntityRepository, "");
        this.getAuthRequestContext = globalSendEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = holdLoginV1EntityRepository;
        this.PlaceComponentResult = cardCredentialEntityRepository;
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<GlobalSendEntityData>() { // from class: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$networkGlobalSendEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GlobalSendEntityData invoke() {
                GlobalSendEntityDataFactory globalSendEntityDataFactory2;
                globalSendEntityDataFactory2 = GlobalSendEntityRepository.this.getAuthRequestContext;
                return globalSendEntityDataFactory2.createData2("network");
            }
        });
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<GlobalSendEntityData>() { // from class: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$localGlobalSendEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GlobalSendEntityData invoke() {
                GlobalSendEntityDataFactory globalSendEntityDataFactory2;
                globalSendEntityDataFactory2 = GlobalSendEntityRepository.this.getAuthRequestContext;
                return globalSendEntityDataFactory2.createData2("local");
            }
        });
        this.moveToNextValue = LazyKt.lazy(new Function0<GlobalSendEntityData>() { // from class: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$splitGlobalSendEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GlobalSendEntityData invoke() {
                GlobalSendEntityDataFactory globalSendEntityDataFactory2;
                globalSendEntityDataFactory2 = GlobalSendEntityRepository.this.getAuthRequestContext;
                return globalSendEntityDataFactory2.createData2("split");
            }
        });
    }

    @Override // id.dana.sendmoney.domain.globalsend.GlobalSendRepository
    public final Flow<TransferSubmitResult> KClassImpl$Data$declaredNonStaticMembers$2(TransferSubmitRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(DecodedScanBizInfoKey.COMMENT, p0.getAuthRequestContext);
        final Flow<TransferSubmitResultEntity> MyBillsEntityDataFactory = ((GlobalSendEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).MyBillsEntityDataFactory(TransferSubmitEntityMapperKt.addExtParams(TransferSubmitEntityMapperKt.toTransferSubmitRequestEntity(p0), linkedHashMap));
        Flow<TransferSubmitResult> flow = new Flow<TransferSubmitResult>() { // from class: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$transferSubmit$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super TransferSubmitResult> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$transferSubmit$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $getAuthRequestContext;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$transferSubmit$$inlined$map$1$2", f = "GlobalSendEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$transferSubmit$$inlined$map$1$2$1  reason: invalid class name */
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$transferSubmit$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$transferSubmit$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$transferSubmit$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$transferSubmit$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$transferSubmit$$inlined$map$1$2$1
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
                        id.dana.sendmoney.data.api.globalsend.transferSubmit.response.TransferSubmitResultEntity r5 = (id.dana.sendmoney.data.api.globalsend.transferSubmit.response.TransferSubmitResultEntity) r5
                        id.dana.sendmoney.domain.globalsend.model.transfersubmit.response.TransferSubmitResult r5 = id.dana.sendmoney.data.api.globalsend.transferSubmit.mapper.TransferSubmitEntityMapperKt.toTransferSubmitResult(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$transferSubmit$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
        Intrinsics.checkNotNullParameter(flow, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(flow);
    }

    public static final /* synthetic */ GlobalSendEntityData BuiltInFictitiousFunctionClassFactory(GlobalSendEntityRepository globalSendEntityRepository) {
        return (GlobalSendEntityData) globalSendEntityRepository.BuiltInFictitiousFunctionClassFactory.getValue();
    }

    @Override // id.dana.sendmoney.domain.globalsend.GlobalSendRepository
    public final Flow<Boolean> PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Flow<BaseRpcResult> PlaceComponentResult = ((GlobalSendEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).PlaceComponentResult(new DeleteBeneficiaryRequestEntity(p0, "GLOBAL_TRANSFER"));
        Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
        final Flow PlaceComponentResult2 = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(PlaceComponentResult);
        return new Flow<Boolean>() { // from class: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$deleteBeneficiaryList$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$deleteBeneficiaryList$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $KClassImpl$Data$declaredNonStaticMembers$2;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$deleteBeneficiaryList$$inlined$map$1$2", f = "GlobalSendEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$deleteBeneficiaryList$$inlined$map$1$2$1  reason: invalid class name */
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$deleteBeneficiaryList$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$deleteBeneficiaryList$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$deleteBeneficiaryList$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$deleteBeneficiaryList$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$deleteBeneficiaryList$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4b
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
                        com.alipayplus.mobile.component.domain.model.result.BaseRpcResult r5 = (com.alipayplus.mobile.component.domain.model.result.BaseRpcResult) r5
                        boolean r5 = r5.success
                        java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4b
                        return r1
                    L4b:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$deleteBeneficiaryList$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.sendmoney.domain.globalsend.GlobalSendRepository
    public final Flow<List<Country>> getAuthRequestContext() {
        final Flow<List<CountryEntity>> MyBillsEntityDataFactory = ((GlobalSendEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).MyBillsEntityDataFactory();
        return (Flow) new Flow<List<? extends Country>>() { // from class: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getCountryList$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super List<? extends Country>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getCountryList$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $MyBillsEntityDataFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getCountryList$$inlined$map$1$2", f = "GlobalSendEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getCountryList$$inlined$map$1$2$1  reason: invalid class name */
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
                    this.$MyBillsEntityDataFactory = flowCollector;
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getCountryList$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getCountryList$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getCountryList$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getCountryList$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getCountryList$$inlined$map$1$2$1
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
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$MyBillsEntityDataFactory
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.util.List r5 = (java.util.List) r5
                        java.util.List r5 = id.dana.sendmoney.data.api.globalsend.country.mapper.CountryEntityMapperKt.toCountryList(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getCountryList$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.sendmoney.domain.globalsend.GlobalSendRepository
    public final Flow<Integer> PlaceComponentResult() {
        return ((GlobalSendEntityData) this.moveToNextValue.getValue()).BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.sendmoney.domain.globalsend.GlobalSendRepository
    public final Flow<List<Province>> KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final Flow<List<ProvinceEntity>> BuiltInFictitiousFunctionClassFactory = ((GlobalSendEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).BuiltInFictitiousFunctionClassFactory(p0);
        return (Flow) new Flow<List<? extends Province>>() { // from class: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getProvinceAndCityList$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super List<? extends Province>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getProvinceAndCityList$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $MyBillsEntityDataFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getProvinceAndCityList$$inlined$map$1$2", f = "GlobalSendEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getProvinceAndCityList$$inlined$map$1$2$1  reason: invalid class name */
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
                    this.$MyBillsEntityDataFactory = flowCollector;
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getProvinceAndCityList$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getProvinceAndCityList$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getProvinceAndCityList$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getProvinceAndCityList$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getProvinceAndCityList$$inlined$map$1$2$1
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
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$MyBillsEntityDataFactory
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.util.List r5 = (java.util.List) r5
                        java.util.List r5 = id.dana.sendmoney.data.api.globalsend.province.mapper.ProvinceEntityMapperKt.toProvinceList(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$getProvinceAndCityList$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.sendmoney.domain.globalsend.GlobalSendRepository
    public final Flow<SenderDetail> MyBillsEntityDataFactory() {
        return ((GlobalSendEntityData) this.MyBillsEntityDataFactory.getValue()).getAuthRequestContext();
    }

    @Override // id.dana.sendmoney.domain.globalsend.GlobalSendRepository
    public final Flow<String> BuiltInFictitiousFunctionClassFactory() {
        return ((GlobalSendEntityData) this.MyBillsEntityDataFactory.getValue()).PlaceComponentResult();
    }

    @Override // id.dana.sendmoney.domain.globalsend.GlobalSendRepository
    public final Flow<GlobalTransferInitResult> BuiltInFictitiousFunctionClassFactory(GlobalTransferInitRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final Flow<GlobalTransferInitResultEntity> authRequestContext = ((GlobalSendEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).getAuthRequestContext(GlobalTransferInitMapperKt.toGlobalTransferInitRequestEntity(p0));
        Flow<GlobalTransferInitResult> flow = new Flow<GlobalTransferInitResult>() { // from class: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$initGlobalTransfer$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super GlobalTransferInitResult> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$initGlobalTransfer$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$initGlobalTransfer$$inlined$map$1$2", f = "GlobalSendEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$initGlobalTransfer$$inlined$map$1$2$1  reason: invalid class name */
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$initGlobalTransfer$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$initGlobalTransfer$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$initGlobalTransfer$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$initGlobalTransfer$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$initGlobalTransfer$$inlined$map$1$2$1
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
                        id.dana.sendmoney.data.api.globalsend.init.model.response.GlobalTransferInitResultEntity r5 = (id.dana.sendmoney.data.api.globalsend.init.model.response.GlobalTransferInitResultEntity) r5
                        id.dana.sendmoney.domain.globalsend.model.init.GlobalTransferInitResult r5 = id.dana.sendmoney.data.api.globalsend.init.mapper.GlobalTransferInitMapperKt.toGlobalTransferInitResult(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$initGlobalTransfer$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
        Intrinsics.checkNotNullParameter(flow, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(flow);
    }

    @Override // id.dana.sendmoney.domain.globalsend.GlobalSendRepository
    public final Flow<QueryBeneficiaryResult> PlaceComponentResult(QueryBeneficiaryRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final Flow<QueryBeneficiaryResultEntity> MyBillsEntityDataFactory = ((GlobalSendEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).MyBillsEntityDataFactory(QueryBeneficiaryEntityMapperKt.toQueryBeneficiaryRequestEntity(p0));
        Flow<QueryBeneficiaryResult> flow = new Flow<QueryBeneficiaryResult>() { // from class: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$queryBeneficiaryList$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super QueryBeneficiaryResult> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$queryBeneficiaryList$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $getAuthRequestContext;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$queryBeneficiaryList$$inlined$map$1$2", f = "GlobalSendEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$queryBeneficiaryList$$inlined$map$1$2$1  reason: invalid class name */
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$queryBeneficiaryList$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$queryBeneficiaryList$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$queryBeneficiaryList$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$queryBeneficiaryList$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$queryBeneficiaryList$$inlined$map$1$2$1
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
                        id.dana.sendmoney.data.api.globalsend.beneficiary.response.QueryBeneficiaryResultEntity r5 = (id.dana.sendmoney.data.api.globalsend.beneficiary.response.QueryBeneficiaryResultEntity) r5
                        id.dana.sendmoney.domain.globalsend.model.beneficiary.response.QueryBeneficiaryResult r5 = id.dana.sendmoney.data.api.globalsend.beneficiary.mapper.QueryBeneficiaryEntityMapperKt.toQueryBeneficiaryResult(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$queryBeneficiaryList$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
        Intrinsics.checkNotNullParameter(flow, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(flow);
    }

    @Override // id.dana.sendmoney.domain.globalsend.GlobalSendRepository
    public final Flow<Unit> getAuthRequestContext(SenderDetail p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return ((GlobalSendEntityData) this.MyBillsEntityDataFactory.getValue()).getAuthRequestContext(p0);
    }

    @Override // id.dana.sendmoney.domain.globalsend.GlobalSendRepository
    public final Flow<Unit> BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return ((GlobalSendEntityData) this.MyBillsEntityDataFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    @Override // id.dana.sendmoney.domain.globalsend.GlobalSendRepository
    public final Flow<TransferValidateResult> getAuthRequestContext(TransferValidateRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p0.PlaceComponentResult;
        if (str == null) {
            str = "";
        }
        Flow flatMapConcat = FlowKt.flatMapConcat(encryptCardCredentialsFlow(MapsKt.mapOf(new Pair(CardCredInfo.CARD_NO, str))), new GlobalSendEntityRepository$validate$1(this, p0, null));
        Intrinsics.checkNotNullParameter(flatMapConcat, "");
        final Flow PlaceComponentResult = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(flatMapConcat);
        return new Flow<TransferValidateResult>() { // from class: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$validate$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super TransferValidateResult> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$validate$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $getAuthRequestContext;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$validate$$inlined$map$1$2", f = "GlobalSendEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$validate$$inlined$map$1$2$1  reason: invalid class name */
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$validate$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$validate$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$validate$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$validate$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$validate$$inlined$map$1$2$1
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
                        id.dana.sendmoney.data.api.globalsend.validate.model.response.TransferValidateEntityResult r5 = (id.dana.sendmoney.data.api.globalsend.validate.model.response.TransferValidateEntityResult) r5
                        id.dana.sendmoney.domain.globalsend.model.validate.TransferValidateResult r5 = id.dana.sendmoney.data.api.globalsend.validate.mapper.TransferValidateEntityMapperKt.toTransferValidateResult(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$validate$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }
}

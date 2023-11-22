package id.dana.sendmoney.data.repository.globalsend.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.network.base.SecureBaseNetworkFlow;
import id.dana.network.rpc.RpcConnector;
import id.dana.sendmoney.data.api.globalsend.beneficiary.request.QueryBeneficiaryRequestEntity;
import id.dana.sendmoney.data.api.globalsend.beneficiary.response.QueryBeneficiaryResultEntity;
import id.dana.sendmoney.data.api.globalsend.country.model.CountryEntity;
import id.dana.sendmoney.data.api.globalsend.delete.DeleteBeneficiaryRequestEntity;
import id.dana.sendmoney.data.api.globalsend.init.model.request.GlobalTransferInitRequestEntity;
import id.dana.sendmoney.data.api.globalsend.init.model.response.GlobalTransferInitResultEntity;
import id.dana.sendmoney.data.api.globalsend.province.model.ProvinceEntity;
import id.dana.sendmoney.data.api.globalsend.transferSubmit.request.TransferSubmitRequestEntity;
import id.dana.sendmoney.data.api.globalsend.transferSubmit.response.TransferSubmitResultEntity;
import id.dana.sendmoney.data.api.globalsend.validate.model.request.TransferValidateEntityRequest;
import id.dana.sendmoney.data.api.globalsend.validate.model.response.TransferValidateEntityResult;
import id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData;
import id.dana.sendmoney.domain.globalsend.model.sender.SenderDetail;
import id.dana.utils.foundation.facede.ApSecurity;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B1\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020+\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00100\u001a\u00020)\u0012\u0006\u00101\u001a\u00020'¢\u0006\u0004\b2\u00103J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\rJ#\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n0\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0012\u0010\u0015J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\rJ\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006H\u0016¢\u0006\u0004\b\b\u0010\rJ\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\u0006\u0010\u0005\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0017\u0010\u001aJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\u0005\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\f\u0010\u001dJ\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00062\u0006\u0010\u0005\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u001fJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0016¢\u0006\u0004\b \u0010\u0015J\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\"0\u00062\u0006\u0010\u0005\u001a\u00020!H\u0016¢\u0006\u0004\b\f\u0010#J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020%0\u00062\u0006\u0010\u0005\u001a\u00020$H\u0016¢\u0006\u0004\b\b\u0010&R\u0014\u0010\f\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010(R\u0014\u0010 \u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010*"}, d2 = {"Lid/dana/sendmoney/data/repository/globalsend/source/network/NetworkGlobalSendEntityData;", "Lid/dana/network/base/SecureBaseNetworkFlow;", "Lid/dana/sendmoney/data/repository/globalsend/source/network/GlobalSendFacade;", "Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityData;", "Lid/dana/sendmoney/data/api/globalsend/delete/DeleteBeneficiaryRequestEntity;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "PlaceComponentResult", "(Lid/dana/sendmoney/data/api/globalsend/delete/DeleteBeneficiaryRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "", "Lid/dana/sendmoney/data/api/globalsend/country/model/CountryEntity;", "MyBillsEntityDataFactory", "()Lkotlinx/coroutines/flow/Flow;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "BuiltInFictitiousFunctionClassFactory", "", "Lid/dana/sendmoney/data/api/globalsend/province/model/ProvinceEntity;", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/globalsend/model/sender/SenderDetail;", "getAuthRequestContext", "Lid/dana/sendmoney/data/api/globalsend/init/model/request/GlobalTransferInitRequestEntity;", "Lid/dana/sendmoney/data/api/globalsend/init/model/response/GlobalTransferInitResultEntity;", "(Lid/dana/sendmoney/data/api/globalsend/init/model/request/GlobalTransferInitRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/api/globalsend/beneficiary/request/QueryBeneficiaryRequestEntity;", "Lid/dana/sendmoney/data/api/globalsend/beneficiary/response/QueryBeneficiaryResultEntity;", "(Lid/dana/sendmoney/data/api/globalsend/beneficiary/request/QueryBeneficiaryRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "", "(Lid/dana/sendmoney/domain/globalsend/model/sender/SenderDetail;)Lkotlinx/coroutines/flow/Flow;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/data/api/globalsend/transferSubmit/request/TransferSubmitRequestEntity;", "Lid/dana/sendmoney/data/api/globalsend/transferSubmit/response/TransferSubmitResultEntity;", "(Lid/dana/sendmoney/data/api/globalsend/transferSubmit/request/TransferSubmitRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/api/globalsend/validate/model/request/TransferValidateEntityRequest;", "Lid/dana/sendmoney/data/api/globalsend/validate/model/response/TransferValidateEntityResult;", "(Lid/dana/sendmoney/data/api/globalsend/validate/model/request/TransferValidateEntityRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "Lid/dana/sendmoney/data/repository/globalsend/source/network/GlobalSendSecureApi;", "Lid/dana/sendmoney/data/repository/globalsend/source/network/GlobalSendSecureApi;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/foundation/facede/ApSecurity;", "p1", "Landroid/content/Context;", "p2", "p3", "p4", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/foundation/facede/ApSecurity;Landroid/content/Context;Lid/dana/sendmoney/data/repository/globalsend/source/network/GlobalSendSecureApi;Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkGlobalSendEntityData extends SecureBaseNetworkFlow<GlobalSendFacade> implements GlobalSendEntityData {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GlobalSendSecureApi KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final DynamicUrlWrapper MyBillsEntityDataFactory;

    @Override // id.dana.network.base.BaseNetworkFlow
    public final Class<GlobalSendFacade> getFacadeClass() {
        return GlobalSendFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkGlobalSendEntityData(RpcConnector rpcConnector, ApSecurity apSecurity, Context context, GlobalSendSecureApi globalSendSecureApi, DynamicUrlWrapper dynamicUrlWrapper) {
        super(apSecurity, context, rpcConnector);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(apSecurity, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(globalSendSecureApi, "");
        Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = globalSendSecureApi;
        this.MyBillsEntityDataFactory = dynamicUrlWrapper;
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<List<CountryEntity>> MyBillsEntityDataFactory() {
        return FlowKt.flow(new NetworkGlobalSendEntityData$getCountryList$1(this, null));
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<List<ProvinceEntity>> BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return FlowKt.flow(new NetworkGlobalSendEntityData$getProvinceAndCityList$1(this, p0, null));
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<SenderDetail> getAuthRequestContext() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<Unit> getAuthRequestContext(SenderDetail p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<Unit> KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<String> PlaceComponentResult() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<QueryBeneficiaryResultEntity> MyBillsEntityDataFactory(final QueryBeneficiaryRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<GlobalSendFacade, QueryBeneficiaryResultEntity>() { // from class: id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$queryBeneficiaryList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final QueryBeneficiaryResultEntity invoke(GlobalSendFacade globalSendFacade) {
                Intrinsics.checkNotNullParameter(globalSendFacade, "");
                return globalSendFacade.queryBeneficiaryList((QueryBeneficiaryRequestEntity) NetworkGlobalSendEntityData.BuiltInFictitiousFunctionClassFactory(NetworkGlobalSendEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<Integer> BuiltInFictitiousFunctionClassFactory() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<TransferValidateEntityResult> PlaceComponentResult(TransferValidateEntityRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final Flow flow = FlowKt.flow(new NetworkGlobalSendEntityData$validate$1(this, p0, null));
        final Flow<TransferValidateEntityResult> flow2 = new Flow<TransferValidateEntityResult>() { // from class: id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super TransferValidateEntityResult> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $MyBillsEntityDataFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$1$2", f = "NetworkGlobalSendEntityData.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$1$2$1  reason: invalid class name */
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

                /* JADX WARN: Multi-variable type inference failed */
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
                        boolean r0 = r6 instanceof id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$1$2$1 r0 = (id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$1$2$1 r0 = new id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$1$2$1
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
                        id.dana.network.base.ResultResponse r5 = (id.dana.network.base.ResultResponse) r5
                        java.lang.Object r5 = r5.getResult()
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
        return new Flow<TransferValidateEntityResult>() { // from class: id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$2
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super TransferValidateEntityResult> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $BuiltInFictitiousFunctionClassFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$2$2", f = "NetworkGlobalSendEntityData.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$2$2$1  reason: invalid class name */
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
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r7
                        id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$2$2$1 r0 = (id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r7 = r0.label
                        int r7 = r7 + r2
                        r0.label = r7
                        goto L19
                    L14:
                        id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$2$2$1 r0 = new id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$2$2$1
                        r0.<init>(r7)
                    L19:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L55
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
                        id.dana.sendmoney.data.api.globalsend.validate.model.response.TransferValidateEntityResult r6 = (id.dana.sendmoney.data.api.globalsend.validate.model.response.TransferValidateEntityResult) r6
                        id.dana.network.base.ExceptionParserAphomeFlow r2 = new id.dana.network.base.ExceptionParserAphomeFlow
                        r2.<init>()
                        java.lang.String r4 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
                        id.dana.network.base.BaseRpcResultAphome r6 = (id.dana.network.base.BaseRpcResultAphome) r6
                        id.dana.network.base.BaseRpcResultAphome r6 = r2.apply(r6)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L55
                        return r1
                    L55:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$validate$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<GlobalTransferInitResultEntity> getAuthRequestContext(final GlobalTransferInitRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<GlobalSendFacade, GlobalTransferInitResultEntity>() { // from class: id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$init$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final GlobalTransferInitResultEntity invoke(GlobalSendFacade globalSendFacade) {
                Intrinsics.checkNotNullParameter(globalSendFacade, "");
                return globalSendFacade.init((GlobalTransferInitRequestEntity) NetworkGlobalSendEntityData.BuiltInFictitiousFunctionClassFactory(NetworkGlobalSendEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<BaseRpcResult> PlaceComponentResult(final DeleteBeneficiaryRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<GlobalSendFacade, BaseRpcResult>() { // from class: id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$deleteBeneficiaryList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BaseRpcResult invoke(GlobalSendFacade globalSendFacade) {
                Intrinsics.checkNotNullParameter(globalSendFacade, "");
                return globalSendFacade.deleteBeneficiaryList((DeleteBeneficiaryRequestEntity) NetworkGlobalSendEntityData.BuiltInFictitiousFunctionClassFactory(NetworkGlobalSendEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<TransferSubmitResultEntity> MyBillsEntityDataFactory(final TransferSubmitRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<GlobalSendFacade, TransferSubmitResultEntity>() { // from class: id.dana.sendmoney.data.repository.globalsend.source.network.NetworkGlobalSendEntityData$transferSubmit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TransferSubmitResultEntity invoke(GlobalSendFacade globalSendFacade) {
                Intrinsics.checkNotNullParameter(globalSendFacade, "");
                return globalSendFacade.transferSubmit((TransferSubmitRequestEntity) NetworkGlobalSendEntityData.BuiltInFictitiousFunctionClassFactory(NetworkGlobalSendEntityData.this, p0));
            }
        });
    }

    public static final /* synthetic */ BaseRpcRequest BuiltInFictitiousFunctionClassFactory(NetworkGlobalSendEntityData networkGlobalSendEntityData, BaseRpcRequest baseRpcRequest) {
        baseRpcRequest.envInfo = networkGlobalSendEntityData.generateMobileEnvInfo();
        return baseRpcRequest;
    }
}

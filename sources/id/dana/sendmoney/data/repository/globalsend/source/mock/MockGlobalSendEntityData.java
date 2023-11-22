package id.dana.sendmoney.data.repository.globalsend.source.mock;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.storage.Serializer;
import id.dana.data.util.RawUtils;
import id.dana.sendmoney.R;
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
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\"\u0012\u0006\u0010&\u001a\u00020$¢\u0006\u0004\b'\u0010(J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000bJ#\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u00042\u0006\u0010\u0003\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\r\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u000bJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u0006\u0010\u0003\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0012\u0010\u0015J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\u0003\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\n\u0010\u0018J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\u0006\u0010\u0003\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u001aJ\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\u0006\u0010\u0003\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u0010J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\u0006\u0010\u0003\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\n\u0010\u001eJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u0003\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\u0006\u0010!R\u0011\u0010\u0012\u001a\u00020\"X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010#R\u0011\u0010\r\u001a\u00020$X\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010%"}, d2 = {"Lid/dana/sendmoney/data/repository/globalsend/source/mock/MockGlobalSendEntityData;", "Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityData;", "Lid/dana/sendmoney/data/api/globalsend/delete/DeleteBeneficiaryRequestEntity;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "PlaceComponentResult", "(Lid/dana/sendmoney/data/api/globalsend/delete/DeleteBeneficiaryRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "", "Lid/dana/sendmoney/data/api/globalsend/country/model/CountryEntity;", "MyBillsEntityDataFactory", "()Lkotlinx/coroutines/flow/Flow;", "", "BuiltInFictitiousFunctionClassFactory", "", "Lid/dana/sendmoney/data/api/globalsend/province/model/ProvinceEntity;", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/globalsend/model/sender/SenderDetail;", "getAuthRequestContext", "Lid/dana/sendmoney/data/api/globalsend/init/model/request/GlobalTransferInitRequestEntity;", "Lid/dana/sendmoney/data/api/globalsend/init/model/response/GlobalTransferInitResultEntity;", "(Lid/dana/sendmoney/data/api/globalsend/init/model/request/GlobalTransferInitRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/api/globalsend/beneficiary/request/QueryBeneficiaryRequestEntity;", "Lid/dana/sendmoney/data/api/globalsend/beneficiary/response/QueryBeneficiaryResultEntity;", "(Lid/dana/sendmoney/data/api/globalsend/beneficiary/request/QueryBeneficiaryRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "", "(Lid/dana/sendmoney/domain/globalsend/model/sender/SenderDetail;)Lkotlinx/coroutines/flow/Flow;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/data/api/globalsend/transferSubmit/request/TransferSubmitRequestEntity;", "Lid/dana/sendmoney/data/api/globalsend/transferSubmit/response/TransferSubmitResultEntity;", "(Lid/dana/sendmoney/data/api/globalsend/transferSubmit/request/TransferSubmitRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/api/globalsend/validate/model/request/TransferValidateEntityRequest;", "Lid/dana/sendmoney/data/api/globalsend/validate/model/response/TransferValidateEntityResult;", "(Lid/dana/sendmoney/data/api/globalsend/validate/model/request/TransferValidateEntityRequest;)Lkotlinx/coroutines/flow/Flow;", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "Lid/dana/data/storage/Serializer;", "p1", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MockGlobalSendEntityData implements GlobalSendEntityData {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Serializer BuiltInFictitiousFunctionClassFactory;
    public final Context getAuthRequestContext;

    @Inject
    public MockGlobalSendEntityData(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.getAuthRequestContext = context;
        this.BuiltInFictitiousFunctionClassFactory = serializer;
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<List<CountryEntity>> MyBillsEntityDataFactory() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<List<ProvinceEntity>> BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
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
    public final Flow<QueryBeneficiaryResultEntity> MyBillsEntityDataFactory(QueryBeneficiaryRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return FlowKt.flowOf(this.BuiltInFictitiousFunctionClassFactory.deserialize(RawUtils.jsonRawToString(this.getAuthRequestContext, R.raw.MyBillsEntityDataFactory_res_0x7f12001d), QueryBeneficiaryResultEntity.class));
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<Integer> BuiltInFictitiousFunctionClassFactory() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<TransferValidateEntityResult> PlaceComponentResult(TransferValidateEntityRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return FlowKt.flowOf(this.BuiltInFictitiousFunctionClassFactory.deserialize(RawUtils.jsonRawToString(this.getAuthRequestContext, R.raw.res_0x7f120029_kclassimpl_data_declarednonstaticmembers_2), TransferValidateEntityResult.class));
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<GlobalTransferInitResultEntity> getAuthRequestContext(GlobalTransferInitRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return FlowKt.flowOf(this.BuiltInFictitiousFunctionClassFactory.deserialize(RawUtils.jsonRawToString(this.getAuthRequestContext, R.raw.BuiltInFictitiousFunctionClassFactory_res_0x7f12001f), GlobalTransferInitResultEntity.class));
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<BaseRpcResult> PlaceComponentResult(DeleteBeneficiaryRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return FlowKt.flowOf(this.BuiltInFictitiousFunctionClassFactory.deserialize(RawUtils.jsonRawToString(this.getAuthRequestContext, R.raw.getAuthRequestContext_res_0x7f12001e), BaseRpcResult.class));
    }

    @Override // id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityData
    public final Flow<TransferSubmitResultEntity> MyBillsEntityDataFactory(TransferSubmitRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return FlowKt.flowOf(this.BuiltInFictitiousFunctionClassFactory.deserialize(RawUtils.jsonRawToString(this.getAuthRequestContext, R.raw.PlaceComponentResult_res_0x7f120028), TransferSubmitResultEntity.class));
    }
}

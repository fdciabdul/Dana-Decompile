package id.dana.sendmoney.domain.globalsend;

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
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u0004H&¢\u0006\u0004\b\u0006\u0010\u000bJ#\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0007J\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H&¢\u0006\u0004\b\u0010\u0010\u000bJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u000bJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\u0003\u001a\u00020\u0012H&¢\u0006\u0004\b\u0011\u0010\u0014J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\u0006\u0010\u0003\u001a\u00020\u0015H&¢\u0006\u0004\b\u0006\u0010\u0017J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\u0006\u0010\u0003\u001a\u00020\u000fH&¢\u0006\u0004\b\n\u0010\u0019J\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0007J\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\u0006\u0010\u0003\u001a\u00020\u001aH&¢\u0006\u0004\b\u000e\u0010\u001cJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00042\u0006\u0010\u0003\u001a\u00020\u001dH&¢\u0006\u0004\b\n\u0010\u001fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/GlobalSendRepository;", "", "", "p0", "Lkotlinx/coroutines/flow/Flow;", "", "PlaceComponentResult", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "", "Lid/dana/sendmoney/domain/globalsend/model/country/Country;", "getAuthRequestContext", "()Lkotlinx/coroutines/flow/Flow;", "", "Lid/dana/sendmoney/domain/globalsend/model/province/Province;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/domain/globalsend/model/sender/SenderDetail;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitRequest;", "Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitResult;", "(Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/globalsend/model/beneficiary/request/QueryBeneficiaryRequest;", "Lid/dana/sendmoney/domain/globalsend/model/beneficiary/response/QueryBeneficiaryResult;", "(Lid/dana/sendmoney/domain/globalsend/model/beneficiary/request/QueryBeneficiaryRequest;)Lkotlinx/coroutines/flow/Flow;", "", "(Lid/dana/sendmoney/domain/globalsend/model/sender/SenderDetail;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/globalsend/model/transfersubmit/request/TransferSubmitRequest;", "Lid/dana/sendmoney/domain/globalsend/model/transfersubmit/response/TransferSubmitResult;", "(Lid/dana/sendmoney/domain/globalsend/model/transfersubmit/request/TransferSubmitRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateRequest;", "Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateResult;", "(Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateRequest;)Lkotlinx/coroutines/flow/Flow;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GlobalSendRepository {
    Flow<String> BuiltInFictitiousFunctionClassFactory();

    Flow<GlobalTransferInitResult> BuiltInFictitiousFunctionClassFactory(GlobalTransferInitRequest p0);

    Flow<Unit> BuiltInFictitiousFunctionClassFactory(String p0);

    Flow<TransferSubmitResult> KClassImpl$Data$declaredNonStaticMembers$2(TransferSubmitRequest p0);

    Flow<List<Province>> KClassImpl$Data$declaredNonStaticMembers$2(String p0);

    Flow<SenderDetail> MyBillsEntityDataFactory();

    Flow<Integer> PlaceComponentResult();

    Flow<QueryBeneficiaryResult> PlaceComponentResult(QueryBeneficiaryRequest p0);

    Flow<Boolean> PlaceComponentResult(String p0);

    Flow<List<Country>> getAuthRequestContext();

    Flow<Unit> getAuthRequestContext(SenderDetail p0);

    Flow<TransferValidateResult> getAuthRequestContext(TransferValidateRequest p0);
}

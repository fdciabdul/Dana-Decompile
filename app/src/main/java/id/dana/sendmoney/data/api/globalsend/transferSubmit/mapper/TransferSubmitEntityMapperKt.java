package id.dana.sendmoney.data.api.globalsend.transferSubmit.mapper;

import id.dana.data.model.CurrencyAmountResult;
import id.dana.domain.user.CurrencyAmount;
import id.dana.sendmoney.data.api.globalsend.transferSubmit.request.BeneficiaryRequest;
import id.dana.sendmoney.data.api.globalsend.transferSubmit.request.TransferSubmitRequestEntity;
import id.dana.sendmoney.data.api.globalsend.transferSubmit.response.TransferSubmitResultEntity;
import id.dana.sendmoney.domain.globalsend.model.transfersubmit.request.TransferSubmitRequest;
import id.dana.sendmoney.domain.globalsend.model.transfersubmit.response.TransferSubmitResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\b\u001a\u00020\u0007*\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\u000b\u001a\u00020\u0000*\u00020\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\u000f\u001a\u00020\u000e*\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/transferSubmit/request/TransferSubmitRequestEntity;", "", "", "params", "addExtParams", "(Lid/dana/sendmoney/data/api/globalsend/transferSubmit/request/TransferSubmitRequestEntity;Ljava/util/Map;)Lid/dana/sendmoney/data/api/globalsend/transferSubmit/request/TransferSubmitRequestEntity;", "Lid/dana/data/model/CurrencyAmountResult;", "Lid/dana/domain/user/CurrencyAmount;", "getAmount", "(Lid/dana/data/model/CurrencyAmountResult;)Lid/dana/domain/user/CurrencyAmount;", "Lid/dana/sendmoney/domain/globalsend/model/transfersubmit/request/TransferSubmitRequest;", "toTransferSubmitRequestEntity", "(Lid/dana/sendmoney/domain/globalsend/model/transfersubmit/request/TransferSubmitRequest;)Lid/dana/sendmoney/data/api/globalsend/transferSubmit/request/TransferSubmitRequestEntity;", "Lid/dana/sendmoney/data/api/globalsend/transferSubmit/response/TransferSubmitResultEntity;", "Lid/dana/sendmoney/domain/globalsend/model/transfersubmit/response/TransferSubmitResult;", "toTransferSubmitResult", "(Lid/dana/sendmoney/data/api/globalsend/transferSubmit/response/TransferSubmitResultEntity;)Lid/dana/sendmoney/domain/globalsend/model/transfersubmit/response/TransferSubmitResult;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferSubmitEntityMapperKt {
    public static final TransferSubmitResult toTransferSubmitResult(TransferSubmitResultEntity transferSubmitResultEntity) {
        Intrinsics.checkNotNullParameter(transferSubmitResultEntity, "");
        return new TransferSubmitResult(transferSubmitResultEntity.getCheckoutUrl(), getAmount(transferSubmitResultEntity.getFundAmount()), transferSubmitResultEntity.getFundOrderId(), transferSubmitResultEntity.getOrderTitle(), transferSubmitResultEntity.getRequestId());
    }

    public static final TransferSubmitRequestEntity addExtParams(TransferSubmitRequestEntity transferSubmitRequestEntity, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(transferSubmitRequestEntity, "");
        Intrinsics.checkNotNullParameter(map, "");
        transferSubmitRequestEntity.extParams = map;
        return transferSubmitRequestEntity;
    }

    private static final CurrencyAmount getAmount(CurrencyAmountResult currencyAmountResult) {
        CurrencyAmount currencyAmount = currencyAmountResult != null ? currencyAmountResult.toCurrencyAmount() : null;
        return currencyAmount == null ? new CurrencyAmount("", "") : currencyAmount;
    }

    public static final TransferSubmitRequestEntity toTransferSubmitRequestEntity(TransferSubmitRequest transferSubmitRequest) {
        Intrinsics.checkNotNullParameter(transferSubmitRequest, "");
        return new TransferSubmitRequestEntity(transferSubmitRequest.KClassImpl$Data$declaredNonStaticMembers$2, transferSubmitRequest.MyBillsEntityDataFactory, transferSubmitRequest.moveToNextValue, transferSubmitRequest.BuiltInFictitiousFunctionClassFactory, new BeneficiaryRequest(transferSubmitRequest.PlaceComponentResult));
    }
}

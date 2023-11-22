package id.dana.sendmoney.data.api.globalsend.validate.mapper;

import id.dana.sendmoney.data.api.globalsend.validate.model.BeneficiaryInfoEntity;
import id.dana.sendmoney.data.api.globalsend.validate.model.request.TransferValidateEntityRequest;
import id.dana.sendmoney.data.api.globalsend.validate.model.response.TransferValidateEntityResult;
import id.dana.sendmoney.domain.globalsend.model.validate.BeneficiaryInfo;
import id.dana.sendmoney.domain.globalsend.model.validate.TransferValidateRequest;
import id.dana.sendmoney.domain.globalsend.model.validate.TransferValidateResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0019\u0010\u0007\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\u000b\u001a\u00020\n*\u00020\t¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;", "createEmptyBeneficiaryInfo", "()Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;", "Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateRequest;", "", "cardCredential", "Lid/dana/sendmoney/data/api/globalsend/validate/model/request/TransferValidateEntityRequest;", "toTransferValidateEntityRequest", "(Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateRequest;Ljava/lang/String;)Lid/dana/sendmoney/data/api/globalsend/validate/model/request/TransferValidateEntityRequest;", "Lid/dana/sendmoney/data/api/globalsend/validate/model/response/TransferValidateEntityResult;", "Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateResult;", "toTransferValidateResult", "(Lid/dana/sendmoney/data/api/globalsend/validate/model/response/TransferValidateEntityResult;)Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateResult;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferValidateEntityMapperKt {
    public static final TransferValidateResult toTransferValidateResult(TransferValidateEntityResult transferValidateEntityResult) {
        BeneficiaryInfo createEmptyBeneficiaryInfo;
        Intrinsics.checkNotNullParameter(transferValidateEntityResult, "");
        BeneficiaryInfoEntity beneficiary = transferValidateEntityResult.getBeneficiary();
        if (beneficiary == null || (createEmptyBeneficiaryInfo = BeneficiaryInfoEntityMapperKt.toBeneficiaryInfo(beneficiary)) == null) {
            createEmptyBeneficiaryInfo = createEmptyBeneficiaryInfo();
        }
        String cardIndexNo = transferValidateEntityResult.getCardIndexNo();
        if (cardIndexNo == null) {
            cardIndexNo = "";
        }
        String maskedCardNo = transferValidateEntityResult.getMaskedCardNo();
        return new TransferValidateResult(createEmptyBeneficiaryInfo, cardIndexNo, maskedCardNo != null ? maskedCardNo : "");
    }

    private static final BeneficiaryInfo createEmptyBeneficiaryInfo() {
        return new BeneficiaryInfo("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 0L, 0L, "", "");
    }

    public static final TransferValidateEntityRequest toTransferValidateEntityRequest(TransferValidateRequest transferValidateRequest, String str) {
        Intrinsics.checkNotNullParameter(transferValidateRequest, "");
        Intrinsics.checkNotNullParameter(str, "");
        return new TransferValidateEntityRequest(BeneficiaryInfoEntityMapperKt.toBeneficiaryInfoEntity(transferValidateRequest.getAuthRequestContext), transferValidateRequest.scheduleImpl, transferValidateRequest.KClassImpl$Data$declaredNonStaticMembers$2, transferValidateRequest.getNetworkUserEntityData$$ExternalSyntheticLambda0(), str, transferValidateRequest.BuiltInFictitiousFunctionClassFactory, transferValidateRequest.MyBillsEntityDataFactory);
    }
}

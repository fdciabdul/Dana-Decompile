package id.dana.sendmoney.data.repository.globalsend.source.network;

import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.sendmoney.data.api.globalsend.beneficiary.request.QueryBeneficiaryRequestEntity;
import id.dana.sendmoney.data.api.globalsend.beneficiary.response.QueryBeneficiaryResultEntity;
import id.dana.sendmoney.data.api.globalsend.delete.DeleteBeneficiaryRequestEntity;
import id.dana.sendmoney.data.api.globalsend.init.model.request.GlobalTransferInitRequestEntity;
import id.dana.sendmoney.data.api.globalsend.init.model.response.GlobalTransferInitResultEntity;
import id.dana.sendmoney.data.api.globalsend.transferSubmit.request.TransferSubmitRequestEntity;
import id.dana.sendmoney.data.api.globalsend.transferSubmit.response.TransferSubmitResultEntity;
import id.dana.sendmoney.data.api.globalsend.validate.model.request.TransferValidateEntityRequest;
import id.dana.sendmoney.data.api.globalsend.validate.model.response.TransferValidateEntityResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/data/repository/globalsend/source/network/GlobalSendFacade;", "", "Lid/dana/sendmoney/data/api/globalsend/delete/DeleteBeneficiaryRequestEntity;", "request", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "deleteBeneficiaryList", "(Lid/dana/sendmoney/data/api/globalsend/delete/DeleteBeneficiaryRequestEntity;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/sendmoney/data/api/globalsend/init/model/request/GlobalTransferInitRequestEntity;", "Lid/dana/sendmoney/data/api/globalsend/init/model/response/GlobalTransferInitResultEntity;", IAPSyncCommand.COMMAND_INIT, "(Lid/dana/sendmoney/data/api/globalsend/init/model/request/GlobalTransferInitRequestEntity;)Lid/dana/sendmoney/data/api/globalsend/init/model/response/GlobalTransferInitResultEntity;", "Lid/dana/sendmoney/data/api/globalsend/beneficiary/request/QueryBeneficiaryRequestEntity;", "Lid/dana/sendmoney/data/api/globalsend/beneficiary/response/QueryBeneficiaryResultEntity;", "queryBeneficiaryList", "(Lid/dana/sendmoney/data/api/globalsend/beneficiary/request/QueryBeneficiaryRequestEntity;)Lid/dana/sendmoney/data/api/globalsend/beneficiary/response/QueryBeneficiaryResultEntity;", "Lid/dana/sendmoney/data/api/globalsend/transferSubmit/request/TransferSubmitRequestEntity;", "Lid/dana/sendmoney/data/api/globalsend/transferSubmit/response/TransferSubmitResultEntity;", "transferSubmit", "(Lid/dana/sendmoney/data/api/globalsend/transferSubmit/request/TransferSubmitRequestEntity;)Lid/dana/sendmoney/data/api/globalsend/transferSubmit/response/TransferSubmitResultEntity;", "Lid/dana/sendmoney/data/api/globalsend/validate/model/request/TransferValidateEntityRequest;", "Lid/dana/sendmoney/data/api/globalsend/validate/model/response/TransferValidateEntityResult;", "transferValidate", "(Lid/dana/sendmoney/data/api/globalsend/validate/model/request/TransferValidateEntityRequest;)Lid/dana/sendmoney/data/api/globalsend/validate/model/response/TransferValidateEntityResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface GlobalSendFacade {
    @OperationType("id.dana.transferprod.beneficiary.delete")
    @SignCheck
    BaseRpcResult deleteBeneficiaryList(DeleteBeneficiaryRequestEntity request);

    @OperationType("id.dana.transferprod.transfer.global.init")
    @SignCheck
    GlobalTransferInitResultEntity init(GlobalTransferInitRequestEntity request);

    @OperationType("id.dana.transferprod.beneficiary.queryBeneficiaryList")
    @SignCheck
    QueryBeneficiaryResultEntity queryBeneficiaryList(QueryBeneficiaryRequestEntity request);

    @OperationType("id.dana.transferprod.transfer.submit")
    @SignCheck
    TransferSubmitResultEntity transferSubmit(TransferSubmitRequestEntity request);

    @OperationType("id.dana.transferprod.transfer.validate")
    @SignCheck
    TransferValidateEntityResult transferValidate(TransferValidateEntityRequest request);
}

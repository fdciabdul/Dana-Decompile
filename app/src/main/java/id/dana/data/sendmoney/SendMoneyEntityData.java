package id.dana.data.sendmoney;

import id.dana.data.sendmoney.model.TransferOTCSubmitRequest;
import id.dana.data.sendmoney.model.TransferSubmitParam;
import id.dana.data.sendmoney.repository.source.network.request.BizTransferOrderCreateRequest;
import id.dana.data.sendmoney.repository.source.network.request.BizTransferPrePayRequest;
import id.dana.data.sendmoney.repository.source.network.request.TransferInitRequest;
import id.dana.data.sendmoney.repository.source.network.request.TransferOTCInitRequest;
import id.dana.data.sendmoney.repository.source.network.request.WithdrawInitRequest;
import id.dana.data.sendmoney.repository.source.network.result.BizGroupModifyEntityResult;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferInitResult;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferOrderCreateResult;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferPrePayResult;
import id.dana.data.sendmoney.repository.source.network.result.SendMoneyInitResult;
import id.dana.data.sendmoney.repository.source.network.result.SendMoneyResult;
import id.dana.data.sendmoney.repository.source.network.result.WithdrawInitResult;
import id.dana.data.sendmoney.repository.source.network.result.WithdrawNameCheckResult;
import id.dana.domain.sendmoney.model.NameCheckParam;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface SendMoneyEntityData {
    Observable<BizTransferInitResult> bizInit(TransferInitRequest transferInitRequest);

    Observable<BizTransferInitResult> bizOTCInit(TransferOTCInitRequest transferOTCInitRequest);

    Observable<SendMoneyResult> confirm(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, String str11);

    Observable<BizGroupModifyEntityResult> deleteGroup(String str);

    Observable<SendMoneyInitResult> init();

    Observable<SendMoneyInitResult> init(String str, String str2, String str3);

    Observable<BizTransferPrePayResult> initPrePay(BizTransferPrePayRequest bizTransferPrePayRequest, String str);

    Observable<WithdrawNameCheckResult> nameCheck(NameCheckParam nameCheckParam, String str, Boolean bool);

    Observable<BizTransferOrderCreateResult> transferCreateOrder(BizTransferOrderCreateRequest bizTransferOrderCreateRequest);

    Observable<SendMoneyResult> transferOTCSubmit(TransferOTCSubmitRequest transferOTCSubmitRequest);

    Observable<SendMoneyResult> transferSubmit(TransferSubmitParam transferSubmitParam);

    Observable<WithdrawInitResult> withdrawInit(WithdrawInitRequest withdrawInitRequest);
}

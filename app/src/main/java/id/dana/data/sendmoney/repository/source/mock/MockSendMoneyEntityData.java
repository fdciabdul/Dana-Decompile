package id.dana.data.sendmoney.repository.source.mock;

import android.content.Context;
import id.dana.data.R;
import id.dana.data.model.cashier.AttributesResult;
import id.dana.data.model.cashier.PayMethodRiskResult;
import id.dana.data.sendmoney.SendMoneyEntityData;
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
import id.dana.data.storage.Serializer;
import id.dana.data.util.RawUtils;
import id.dana.domain.sendmoney.model.NameCheckParam;
import io.reactivex.Observable;
import java.util.Collections;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes8.dex */
public class MockSendMoneyEntityData implements SendMoneyEntityData {
    private final Context context;
    private final Serializer serializer;

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<SendMoneyResult> confirm(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, String str11) {
        return null;
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<SendMoneyInitResult> init() {
        return null;
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<SendMoneyInitResult> init(String str, String str2, String str3) {
        return null;
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<WithdrawNameCheckResult> nameCheck(NameCheckParam nameCheckParam, String str, Boolean bool) {
        return null;
    }

    @Inject
    public MockSendMoneyEntityData(Serializer serializer, Context context) {
        this.serializer = serializer;
        this.context = context;
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<BizTransferPrePayResult> initPrePay(BizTransferPrePayRequest bizTransferPrePayRequest, String str) {
        return Observable.just(new BizTransferPrePayResult());
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<BizTransferInitResult> bizInit(TransferInitRequest transferInitRequest) {
        return Observable.just(createBizTransferInitRpcResultMock());
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<BizTransferInitResult> bizOTCInit(TransferOTCInitRequest transferOTCInitRequest) {
        return Observable.just(createBizTransferInitRpcResultMock());
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<WithdrawInitResult> withdrawInit(WithdrawInitRequest withdrawInitRequest) {
        return Observable.just(createWithdrawInitRpcResultMock());
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<SendMoneyResult> transferSubmit(TransferSubmitParam transferSubmitParam) {
        return Observable.just(getSendMoneyRpcResultMock());
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<SendMoneyResult> transferOTCSubmit(TransferOTCSubmitRequest transferOTCSubmitRequest) {
        return Observable.just(getSendMoneyRpcResultMock());
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<BizTransferOrderCreateResult> transferCreateOrder(BizTransferOrderCreateRequest bizTransferOrderCreateRequest) {
        return Observable.just(createBizTransferOrderResultMock());
    }

    @Override // id.dana.data.sendmoney.SendMoneyEntityData
    public Observable<BizGroupModifyEntityResult> deleteGroup(String str) {
        return Observable.just(new BizGroupModifyEntityResult(""));
    }

    private SendMoneyResult getSendMoneyRpcResultMock() {
        SendMoneyResult sendMoneyResult = new SendMoneyResult();
        sendMoneyResult.fundOrderId = "12345678910";
        sendMoneyResult.fundAmount = "10000";
        sendMoneyResult.cashierOrderId = "10987654321";
        sendMoneyResult.attributes = new AttributesResult();
        sendMoneyResult.pubKey = "1234";
        sendMoneyResult.riskPhoneNumber = "";
        sendMoneyResult.payMethodRiskResult = new PayMethodRiskResult();
        return sendMoneyResult;
    }

    private BizTransferInitResult createBizTransferInitRpcResultMock() {
        return (BizTransferInitResult) this.serializer.deserialize(RawUtils.jsonRawToString(this.context, R.raw.moveToNextValue), BizTransferInitResult.class);
    }

    private WithdrawInitResult createWithdrawInitRpcResultMock() {
        Boolean bool = Boolean.TRUE;
        return new WithdrawInitResult(bool, 5, bool, Collections.emptyList());
    }

    private BizTransferOrderCreateResult createBizTransferOrderResultMock() {
        return new BizTransferOrderCreateResult("groupOrderId", "orderId");
    }
}

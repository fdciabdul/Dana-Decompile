package id.dana.data.electronicmoney;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.electronicmoney.network.request.BrizziManualReversalRequest;
import id.dana.data.electronicmoney.network.request.EmoneyConfirmBalanceRequest;
import id.dana.data.electronicmoney.network.request.EmoneyInquiryRequest;
import id.dana.data.electronicmoney.network.request.EmoneyReversalRequest;
import id.dana.data.electronicmoney.network.request.EmoneyTopupCommandRequest;
import id.dana.data.electronicmoney.network.response.BrizziGetAccessTokenResponse;
import id.dana.data.electronicmoney.network.response.ElectronicMoneyGetBizIdResponse;
import id.dana.data.electronicmoney.network.response.EmoneyCardInfoResponse;
import id.dana.data.electronicmoney.network.response.EmoneyReversalResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u001aH'¢\u0006\u0004\b\u001b\u0010\u001cø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/electronicmoney/ElectronicMoneyFacade;", "", "Lid/dana/data/electronicmoney/network/request/EmoneyConfirmBalanceRequest;", "request", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "confirmUpdateBalanceEmoney", "(Lid/dana/data/electronicmoney/network/request/EmoneyConfirmBalanceRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/data/electronicmoney/network/request/BrizziManualReversalRequest;", "reversalData", "doBrizziManualReversal", "(Lid/dana/data/electronicmoney/network/request/BrizziManualReversalRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "Lid/dana/data/electronicmoney/network/response/BrizziGetAccessTokenResponse;", "getBrizziAccessToken", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/electronicmoney/network/response/BrizziGetAccessTokenResponse;", "Lid/dana/data/electronicmoney/network/response/ElectronicMoneyGetBizIdResponse;", "getElectronicMoneyBizId", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/electronicmoney/network/response/ElectronicMoneyGetBizIdResponse;", "Lid/dana/data/electronicmoney/network/request/EmoneyReversalRequest;", "Lid/dana/data/electronicmoney/network/response/EmoneyReversalResponse;", "getReversalEmoney", "(Lid/dana/data/electronicmoney/network/request/EmoneyReversalRequest;)Lid/dana/data/electronicmoney/network/response/EmoneyReversalResponse;", "Lid/dana/data/electronicmoney/network/request/EmoneyTopupCommandRequest;", "Lid/dana/data/electronicmoney/network/response/EmoneyCardInfoResponse;", "getTopUpCommandEmoney", "(Lid/dana/data/electronicmoney/network/request/EmoneyTopupCommandRequest;)Lid/dana/data/electronicmoney/network/response/EmoneyCardInfoResponse;", "Lid/dana/data/electronicmoney/network/request/EmoneyInquiryRequest;", "inquireBalance", "(Lid/dana/data/electronicmoney/network/request/EmoneyInquiryRequest;)Lid/dana/data/electronicmoney/network/response/EmoneyCardInfoResponse;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ElectronicMoneyFacade {
    @OperationType("alipayplus.mobilewallet.emoney.confirm")
    @SignCheck
    BaseRpcResult confirmUpdateBalanceEmoney(EmoneyConfirmBalanceRequest request);

    @OperationType("alipayplus.mobilewallet.emoney.brizzi.reversal")
    @SignCheck
    BaseRpcResult doBrizziManualReversal(BrizziManualReversalRequest reversalData);

    @OperationType("alipayplus.mobilewallet.emoney.brizzi.getAccessToken")
    @SignCheck
    BrizziGetAccessTokenResponse getBrizziAccessToken(BaseRpcRequest request);

    @OperationType("alipayplus.mobilewallet.product.generate.biz.id")
    @SignCheck
    ElectronicMoneyGetBizIdResponse getElectronicMoneyBizId(BaseRpcRequest request);

    @OperationType("alipayplus.mobilewallet.emoney.reversal")
    @SignCheck
    EmoneyReversalResponse getReversalEmoney(EmoneyReversalRequest request);

    @OperationType("alipayplus.mobilewallet.emoney.getTopUpCommand")
    @SignCheck
    EmoneyCardInfoResponse getTopUpCommandEmoney(EmoneyTopupCommandRequest request);

    @OperationType("alipayplus.mobilewallet.emoney.inquireBalance")
    @SignCheck
    EmoneyCardInfoResponse inquireBalance(EmoneyInquiryRequest request);
}

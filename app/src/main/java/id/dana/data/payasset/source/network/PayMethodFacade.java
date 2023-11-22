package id.dana.data.payasset.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.payasset.source.network.request.ChangePayMethodRequest;
import id.dana.data.payasset.source.network.request.QueryPayMethodRequest;
import id.dana.data.payasset.source.network.result.ChangePayMethodResult;
import id.dana.data.payasset.source.network.result.QueryPayMethodResult;

/* loaded from: classes4.dex */
public interface PayMethodFacade {
    @OperationType("alipayplus.mobilewallet.f2fpay.changePayMethod")
    @SignCheck
    ChangePayMethodResult changePayMethod(ChangePayMethodRequest changePayMethodRequest);

    @OperationType("alipayplus.mobilewallet.user.asset.queryPayMethod")
    @SignCheck
    QueryPayMethodResult queryPayMethod(QueryPayMethodRequest queryPayMethodRequest);
}

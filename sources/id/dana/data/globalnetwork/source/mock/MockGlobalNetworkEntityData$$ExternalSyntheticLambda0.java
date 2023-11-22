package id.dana.data.globalnetwork.source.mock;

import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.base.Result;
import com.alipay.iap.android.wallet.acl.payment.PaymentResult;
import com.google.gson.stream.JsonReader;
import o.getValueOfTouchPositionAbsolute;

/* loaded from: classes4.dex */
public final /* synthetic */ class MockGlobalNetworkEntityData$$ExternalSyntheticLambda0 implements Callback {
    @Override // com.alipay.iap.android.wallet.acl.base.Callback
    public final void result(Result result) {
        MockGlobalNetworkEntityData.lambda$getPayRequest$0((PaymentResult) result);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(JsonReader jsonReader, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute) {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            jsonReader.skipValue();
        }
        jsonReader.endObject();
    }
}

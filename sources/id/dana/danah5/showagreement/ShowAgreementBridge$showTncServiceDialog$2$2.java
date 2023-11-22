package id.dana.danah5.showagreement;

import android.widget.Toast;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.fastjson.JSONObject;
import id.dana.R;
import id.dana.lib.gcontainer.GContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", BridgeDSL.INVOKE, "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShowAgreementBridge$showTncServiceDialog$2$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ ShowAgreementBridge this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShowAgreementBridge$showTncServiceDialog$2$2(ShowAgreementBridge showAgreementBridge) {
        super(1);
        this.this$0 = showAgreementBridge;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke */
    public final void invoke2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        Toast.makeText(GContainer.getApplicationContext(), (int) R.string.home_error, 0).show();
        BridgeCallback agreementCallback = this.this$0.getAgreementCallback();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "error", "001");
        agreementCallback.sendJSONResponse(jSONObject);
    }
}

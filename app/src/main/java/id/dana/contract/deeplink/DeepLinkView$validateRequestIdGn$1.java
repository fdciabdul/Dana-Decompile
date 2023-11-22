package id.dana.contract.deeplink;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.iap.ac.android.biz.IAPConnect;
import com.iap.ac.android.biz.common.model.AcBaseResult;
import com.iap.ac.android.biz.common.model.AcCallback;
import com.iap.ac.android.biz.common.model.gol.SignContractRequest;
import id.dana.oauth.OauthLoginManager;
import id.dana.utils.foundation.logger.log.DanaLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DeepLinkView$validateRequestIdGn$1 extends Lambda implements Function0<Unit> {
    public static final DeepLinkView$validateRequestIdGn$1 INSTANCE = new DeepLinkView$validateRequestIdGn$1();

    DeepLinkView$validateRequestIdGn$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
        SignContractRequest signContractRequest = OauthLoginManager.PlaceComponentResult;
        signContractRequest.authUrl = OauthLoginManager.KClassImpl$Data$declaredNonStaticMembers$2();
        signContractRequest.bizContent = "";
        signContractRequest.needCallback = false;
        IAPConnect.signContract(signContractRequest, new AcCallback() { // from class: id.dana.contract.deeplink.DeepLinkView$validateRequestIdGn$1$$ExternalSyntheticLambda0
            @Override // com.iap.ac.android.biz.common.model.AcCallback
            public final void onResult(AcBaseResult acBaseResult) {
                DeepLinkView$validateRequestIdGn$1.m611invoke$lambda0(acBaseResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m611invoke$lambda0(AcBaseResult acBaseResult) {
        boolean z = false;
        if (acBaseResult != null && !acBaseResult.success) {
            z = true;
        }
        if (z) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("validateRequestIdGn", acBaseResult.errorMessage);
        }
    }
}

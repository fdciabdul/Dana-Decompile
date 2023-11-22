package id.dana.contract.deeplink.path;

import com.alibaba.griver.base.common.env.GriverEnv;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.danah5.DanaH5;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.PerActivity;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.services.interactor.GetServicesByKey;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.miniprogram.ExtensionsKt;
import id.dana.model.ThirdPartyService;
import id.dana.utils.ErrorUtil;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;

@PerActivity
/* loaded from: classes4.dex */
public class FeatureServicesHandler {
    private final ThirdPartyServicesMapper BuiltInFictitiousFunctionClassFactory;
    final FeatureContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    final GetServicesByKey MyBillsEntityDataFactory;
    final DeviceInformationProvider PlaceComponentResult;
    final GetAuthCode getAuthRequestContext;

    @Inject
    public FeatureServicesHandler(FeatureContract.View view, GetServicesByKey getServicesByKey, ThirdPartyServicesMapper thirdPartyServicesMapper, GetAuthCode getAuthCode, DeviceInformationProvider deviceInformationProvider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.MyBillsEntityDataFactory = getServicesByKey;
        this.BuiltInFictitiousFunctionClassFactory = thirdPartyServicesMapper;
        this.getAuthRequestContext = getAuthCode;
        this.PlaceComponentResult = deviceInformationProvider;
    }

    static /* synthetic */ void getAuthRequestContext(final FeatureServicesHandler featureServicesHandler, final ThirdPartyService thirdPartyService) {
        if (!thirdPartyService.getNetworkUserEntityData$$ExternalSyntheticLambda1()) {
            featureServicesHandler.KClassImpl$Data$declaredNonStaticMembers$2.dismissProgress();
        } else if (thirdPartyService.PlaceComponentResult != null) {
            DanaH5.openApp(thirdPartyService);
        } else if ("POST".equals(thirdPartyService.BuiltInFictitiousFunctionClassFactory)) {
            if (thirdPartyService.getSubSequence()) {
                featureServicesHandler.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(thirdPartyService, thirdPartyService.getCallingPid, null, featureServicesHandler.PlaceComponentResult.getDeviceUUID());
                return;
            }
            featureServicesHandler.KClassImpl$Data$declaredNonStaticMembers$2.showProgress();
            featureServicesHandler.getAuthRequestContext.execute(GetAuthCode.Params.forGetAuthCode(thirdPartyService.getCallingPid, thirdPartyService.moveToNextValue, thirdPartyService.VerifyPinStateManager$executeRiskChallenge$2$1, true), new Function1() { // from class: id.dana.contract.deeplink.path.FeatureServicesHandler$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    FeatureServicesHandler featureServicesHandler2 = FeatureServicesHandler.this;
                    ThirdPartyService thirdPartyService2 = thirdPartyService;
                    featureServicesHandler2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(thirdPartyService2, thirdPartyService2.getCallingPid, ((AuthCodeResult) obj).getAuthCode(), featureServicesHandler2.PlaceComponentResult.getDeviceUUID());
                    return null;
                }
            }, new Function1() { // from class: id.dana.contract.deeplink.path.FeatureServicesHandler$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    FeatureServicesHandler featureServicesHandler2 = FeatureServicesHandler.this;
                    ThirdPartyService thirdPartyService2 = thirdPartyService;
                    Throwable th = (Throwable) obj;
                    featureServicesHandler2.KClassImpl$Data$declaredNonStaticMembers$2.dismissProgress();
                    if (th instanceof GetAuthCode.MissingRequiredUserInfoException) {
                        ExtensionsKt.BuiltInFictitiousFunctionClassFactory((GetAuthCode.MissingRequiredUserInfoException) th, thirdPartyService2.NetworkUserEntityData$$ExternalSyntheticLambda8, thirdPartyService2.FragmentBottomSheetPaymentSettingBinding, thirdPartyService2.GetContactSyncConfig, thirdPartyService2.VerifyPinStateManager$executeRiskChallenge$2$1, "", "", false);
                        return null;
                    }
                    featureServicesHandler2.KClassImpl$Data$declaredNonStaticMembers$2.onError(ErrorUtil.PlaceComponentResult(th, GriverEnv.getApplicationContext()));
                    return null;
                }
            });
        } else {
            String str = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (str != null && !str.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
                StringBuilder sb = new StringBuilder();
                sb.append("https://m.dana.id");
                sb.append(str);
                str = sb.toString();
            }
            featureServicesHandler.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(thirdPartyService, str, null, null);
        }
    }
}

package id.dana.riskChallenges.ui.verifypin.shared;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.utils.danah5.DanaH5Facade;

/* loaded from: classes5.dex */
public final class VerifyPinShared_MembersInjector implements MembersInjector<VerifyPinShared> {
    public static void BuiltInFictitiousFunctionClassFactory(VerifyPinShared verifyPinShared, Lazy<DanaH5Facade> lazy) {
        verifyPinShared.danaH5Facade = lazy;
    }

    public static void PlaceComponentResult(VerifyPinShared verifyPinShared, DynamicUrlWrapper dynamicUrlWrapper) {
        verifyPinShared.dynamicUrlWrapper = dynamicUrlWrapper;
    }
}

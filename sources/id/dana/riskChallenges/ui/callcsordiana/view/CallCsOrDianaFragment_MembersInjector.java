package id.dana.riskChallenges.ui.callcsordiana.view;

import dagger.MembersInjector;
import id.dana.utils.danah5.DanaH5Facade;
import id.dana.utils.storage.UTDidInfo;

/* loaded from: classes5.dex */
public final class CallCsOrDianaFragment_MembersInjector implements MembersInjector<CallCsOrDianaFragment> {
    public static void PlaceComponentResult(CallCsOrDianaFragment callCsOrDianaFragment, DanaH5Facade danaH5Facade) {
        callCsOrDianaFragment.danaH5Facade = danaH5Facade;
    }

    public static void BuiltInFictitiousFunctionClassFactory(CallCsOrDianaFragment callCsOrDianaFragment, UTDidInfo uTDidInfo) {
        callCsOrDianaFragment.utDidInfo = uTDidInfo;
    }
}

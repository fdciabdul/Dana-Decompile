package id.dana.data.holdlogin.v2.engine;

import dagger.MembersInjector;
import id.dana.data.deeplink.DeepLinkPayloadManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class HoldLoginV2EngineImpl_MembersInjector implements MembersInjector<HoldLoginV2EngineImpl> {
    public static void MyBillsEntityDataFactory(HoldLoginV2EngineImpl holdLoginV2EngineImpl, DeepLinkPayloadManager deepLinkPayloadManager) {
        Intrinsics.checkNotNullParameter(deepLinkPayloadManager, "");
        holdLoginV2EngineImpl.BuiltInFictitiousFunctionClassFactory = deepLinkPayloadManager;
    }
}

package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney_v2.recipient.SendMoneyEventHandler;

/* loaded from: classes4.dex */
public final class GContainerModule_ProvideSendMoneyEventHandlerFactory implements Factory<SendMoneyEventHandler> {
    private final GContainerModule KClassImpl$Data$declaredNonStaticMembers$2;

    private GContainerModule_ProvideSendMoneyEventHandlerFactory(GContainerModule gContainerModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gContainerModule;
    }

    public static GContainerModule_ProvideSendMoneyEventHandlerFactory KClassImpl$Data$declaredNonStaticMembers$2(GContainerModule gContainerModule) {
        return new GContainerModule_ProvideSendMoneyEventHandlerFactory(gContainerModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyEventHandler) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
    }
}

package id.dana.di.modules;

import android.content.Context;
import com.twilio.verify.TwilioVerify;
import dagger.internal.Factory;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideTwilioVerifyFactory implements Factory<TwilioVerify> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> MyBillsEntityDataFactory;

    private ApplicationModule_ProvideTwilioVerifyFactory(ApplicationModule applicationModule, Provider<Context> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideTwilioVerifyFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<Context> provider) {
        return new ApplicationModule_ProvideTwilioVerifyFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    @Nullable
    public final /* synthetic */ Object get() {
        return this.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig(this.MyBillsEntityDataFactory.get());
    }
}

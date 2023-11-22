package id.dana.di.modules;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import id.dana.BuildConfig;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import id.dana.data.model.DiagnosticLogExtKt;
import id.dana.rum.Rum;
import id.dana.rum.model.RumConfigModel;
import id.dana.utils.VersionUtil;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/di/modules/RumModule;", "", "Landroid/app/Application;", "p0", "Lid/dana/data/config/source/sharedpreference/SharedPrefStartupConfig;", "p1", "Lid/dana/rum/Rum;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/app/Application;Lid/dana/data/config/source/sharedpreference/SharedPrefStartupConfig;)Lid/dana/rum/Rum;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes.dex */
public final class RumModule {
    @Provides
    @Singleton
    public final Rum KClassImpl$Data$declaredNonStaticMembers$2(Application p0, final SharedPrefStartupConfig p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Rum.Companion companion = Rum.getAuthRequestContext;
        String BuiltInFictitiousFunctionClassFactory = VersionUtil.BuiltInFictitiousFunctionClassFactory(p0);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return Rum.Companion.BuiltInFictitiousFunctionClassFactory(BuildConfig.SPLUNK_REALM, "prod", BuildConfig.SPLUNK_TOKEN, "Skywalker Android", BuiltInFictitiousFunctionClassFactory, p0, new Rum.Enabler() { // from class: id.dana.di.modules.RumModule$$ExternalSyntheticLambda0
            @Override // id.dana.rum.Rum.Enabler
            public final RumConfigModel getAuthRequestContext() {
                return RumModule.MyBillsEntityDataFactory(SharedPrefStartupConfig.this);
            }
        }, new Rum.FirebaseLog() { // from class: id.dana.di.modules.RumModule$$ExternalSyntheticLambda1
            @Override // id.dana.rum.Rum.FirebaseLog
            public final void getAuthRequestContext(String str) {
                RumModule.PlaceComponentResult(str);
            }
        }, BuildConfig.APPLICATION_ID);
    }

    public static /* synthetic */ void PlaceComponentResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        Crashlytics.Companion companion = Crashlytics.INSTANCE;
        Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
        Intrinsics.checkNotNullParameter(str, "");
        authRequestContext.getAuthRequestContext.log(str);
    }

    public static /* synthetic */ RumConfigModel MyBillsEntityDataFactory(SharedPrefStartupConfig sharedPrefStartupConfig) {
        Intrinsics.checkNotNullParameter(sharedPrefStartupConfig, "");
        return DiagnosticLogExtKt.toRumConfigModel(sharedPrefStartupConfig.getDiagnosticLog());
    }
}

package id.dana.myprofile.mepagerevamp.securitysettings;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\n"}, d2 = {"Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsModule;", "", "Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsPresenter;", "p0", "Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsPresenter;)Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsContract$Presenter;", "Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsContract$View;", "MyBillsEntityDataFactory", "()Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsContract$View;", "Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsContract$View;", "<init>", "(Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class SecuritySettingsModule {
    private final SecuritySettingsContract.View BuiltInFictitiousFunctionClassFactory;

    public SecuritySettingsModule(SecuritySettingsContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Provides
    @PerActivity
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final SecuritySettingsContract.View getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Provides
    @PerActivity
    public final SecuritySettingsContract.Presenter BuiltInFictitiousFunctionClassFactory(SecuritySettingsPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}

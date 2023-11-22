package id.dana.cardbinding.di.component;

import dagger.Component;
import id.dana.cardbinding.activity.CardBindingActivity;
import id.dana.cardbinding.activity.CardBindingCameraActivity;
import id.dana.cardbinding.di.module.CardBindingAnalyticModule;
import id.dana.cardbinding.di.module.CardBindingViewModelModule;
import id.dana.cardbinding.fragment.CardBindingOtpChallengeFragment;
import id.dana.di.PerActivity;
import id.dana.di.component.ApplicationComponent;
import kotlin.Metadata;

@Component(dependencies = {ApplicationComponent.class}, modules = {CardBindingViewModelModule.class, CardBindingAnalyticModule.class})
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cardbinding/di/component/CardBindingComponent;", "", "Lid/dana/cardbinding/activity/CardBindingActivity;", "p0", "", "getAuthRequestContext", "(Lid/dana/cardbinding/activity/CardBindingActivity;)V", "Lid/dana/cardbinding/activity/CardBindingCameraActivity;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cardbinding/activity/CardBindingCameraActivity;)V", "Lid/dana/cardbinding/fragment/CardBindingOtpChallengeFragment;", "MyBillsEntityDataFactory", "(Lid/dana/cardbinding/fragment/CardBindingOtpChallengeFragment;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes2.dex */
public interface CardBindingComponent {
    void BuiltInFictitiousFunctionClassFactory(CardBindingCameraActivity p0);

    void MyBillsEntityDataFactory(CardBindingOtpChallengeFragment p0);

    void getAuthRequestContext(CardBindingActivity p0);
}

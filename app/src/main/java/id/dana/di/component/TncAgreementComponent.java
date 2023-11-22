package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.tncagreement.TermsAndConditionsActivity;

@Component(dependencies = {ApplicationComponent.class})
@PerActivity
/* loaded from: classes8.dex */
public interface TncAgreementComponent {
    void BuiltInFictitiousFunctionClassFactory(TermsAndConditionsActivity termsAndConditionsActivity);
}

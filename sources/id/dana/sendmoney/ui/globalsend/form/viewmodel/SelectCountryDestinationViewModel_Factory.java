package id.dana.sendmoney.ui.globalsend.form.viewmodel;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.interactor.GetCountryList;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SelectCountryDestinationViewModel_Factory implements Factory<SelectCountryDestinationViewModel> {
    private final Provider<GetCountryList> getAuthRequestContext;

    private SelectCountryDestinationViewModel_Factory(Provider<GetCountryList> provider) {
        this.getAuthRequestContext = provider;
    }

    public static SelectCountryDestinationViewModel_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GetCountryList> provider) {
        return new SelectCountryDestinationViewModel_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SelectCountryDestinationViewModel(this.getAuthRequestContext.get());
    }
}

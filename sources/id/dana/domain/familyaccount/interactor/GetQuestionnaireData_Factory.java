package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQuestionnaireData_Factory implements Factory<GetQuestionnaireData> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public GetQuestionnaireData_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQuestionnaireData get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static GetQuestionnaireData_Factory create(Provider<FamilyAccountRepository> provider) {
        return new GetQuestionnaireData_Factory(provider);
    }

    public static GetQuestionnaireData newInstance(FamilyAccountRepository familyAccountRepository) {
        return new GetQuestionnaireData(familyAccountRepository);
    }
}

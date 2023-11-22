package id.dana.data.usereducation.repository;

import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda1;
import id.dana.data.usereducation.repository.source.UserEducationDataFactory;
import id.dana.domain.usereducation.ShowDialogScenarios;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class UserEducationEntityRepository implements UserEducationRepository {
    private static final String DIALOG_KEY = "%s_%s";
    private final AccountEntityDataFactory accountEntityDataFactory;
    private final UserEducationDataFactory userEducationDataFactory;

    @Inject
    public UserEducationEntityRepository(UserEducationDataFactory userEducationDataFactory, AccountEntityDataFactory accountEntityDataFactory) {
        this.userEducationDataFactory = userEducationDataFactory;
        this.accountEntityDataFactory = accountEntityDataFactory;
    }

    @Override // id.dana.domain.usereducation.repository.UserEducationRepository
    public Observable<Boolean> isNeedToShowToolTip(final String str) {
        return getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.usereducation.repository.UserEducationEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEducationEntityRepository.this.m2134xa5f6f545(str, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$isNeedToShowToolTip$0$id-dana-data-usereducation-repository-UserEducationEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2134xa5f6f545(String str, String str2) throws Exception {
        return createUserEducationData().isNeedToShowToolTip(str, str2);
    }

    @Override // id.dana.domain.usereducation.repository.UserEducationRepository
    public Observable<Boolean> saveShowToolTip(final boolean z, final String str) {
        return getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.usereducation.repository.UserEducationEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEducationEntityRepository.this.m2137x3059b884(z, str, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveShowToolTip$1$id-dana-data-usereducation-repository-UserEducationEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2137x3059b884(boolean z, String str, String str2) throws Exception {
        return createUserEducationData().saveShowToolTip(z, str, str2);
    }

    @Override // id.dana.domain.usereducation.repository.UserEducationRepository
    public Observable<Boolean> isNeedToShowBottomSheetOnBoarding(final String str) {
        return getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.usereducation.repository.UserEducationEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEducationEntityRepository.this.m2132x7caabf73(str, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$isNeedToShowBottomSheetOnBoarding$2$id-dana-data-usereducation-repository-UserEducationEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2132x7caabf73(String str, String str2) throws Exception {
        return createUserEducationData().isNeedToShowBottomSheetOnBoarding(str, str2);
    }

    @Override // id.dana.domain.usereducation.repository.UserEducationRepository
    public Observable<Boolean> saveDisplayedBottomSheetOnBoarding(final String str) {
        return getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.usereducation.repository.UserEducationEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEducationEntityRepository.this.m2135x7587dcc2(str, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveDisplayedBottomSheetOnBoarding$3$id-dana-data-usereducation-repository-UserEducationEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2135x7587dcc2(String str, String str2) throws Exception {
        return createUserEducationData().saveShowBottomSheetOnBoarding(str, str2);
    }

    @Override // id.dana.domain.usereducation.repository.UserEducationRepository
    public Observable<Boolean> isNeedToShowDialog(@ShowDialogScenarios final String str) {
        return getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.usereducation.repository.UserEducationEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEducationEntityRepository.this.m2133xdfbc1138(str, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$isNeedToShowDialog$4$id-dana-data-usereducation-repository-UserEducationEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2133xdfbc1138(String str, String str2) throws Exception {
        return createUserEducationData().isNeedToShowDialog(String.format(DIALOG_KEY, str, str2));
    }

    @Override // id.dana.domain.usereducation.repository.UserEducationRepository
    public Observable<Boolean> saveShowDialog(final boolean z, @ShowDialogScenarios final String str) {
        return getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.usereducation.repository.UserEducationEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserEducationEntityRepository.this.m2136xff47fd3b(z, str, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveShowDialog$5$id-dana-data-usereducation-repository-UserEducationEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2136xff47fd3b(boolean z, String str, String str2) throws Exception {
        return createUserEducationData().saveNeedToShowDialog(z, String.format(DIALOG_KEY, str, str2));
    }

    private Observable<String> getPhoneNumber() {
        return createAccountData().getAccount().map(new NearbyMeEntityRepository$$ExternalSyntheticLambda1());
    }

    private UserEducationEntityData createUserEducationData() {
        return this.userEducationDataFactory.createData2("local");
    }

    private AccountEntityData createAccountData() {
        return this.accountEntityDataFactory.createData2("local");
    }
}

package id.dana.explore.domain.userpersonalization.interactor;

import id.dana.domain.account.AccountRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.explore.domain.userpersonalization.UserPersonalizationRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/explore/domain/userpersonalization/interactor/CreateUserPersonalization;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "", "", "Lid/dana/domain/account/AccountRepository;", "getAuthRequestContext", "Lid/dana/domain/account/AccountRepository;", "Lid/dana/explore/domain/userpersonalization/UserPersonalizationRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/explore/domain/userpersonalization/UserPersonalizationRepository;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(Lid/dana/domain/account/AccountRepository;Lid/dana/explore/domain/userpersonalization/UserPersonalizationRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreateUserPersonalization extends BaseUseCase<Boolean, List<? extends String>> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final UserPersonalizationRepository BuiltInFictitiousFunctionClassFactory;
    private final AccountRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Boolean> buildUseCase(List<? extends String> list) {
        final List<? extends String> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "");
        Observable<String> userId = this.getAuthRequestContext.getUserId();
        Intrinsics.checkNotNullExpressionValue(userId, "");
        final Function1<String, Observable<Boolean>> function1 = new Function1<String, Observable<Boolean>>() { // from class: id.dana.explore.domain.userpersonalization.interactor.CreateUserPersonalization$createUserPreference$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<Boolean> invoke(String str) {
                UserPersonalizationRepository userPersonalizationRepository;
                Intrinsics.checkNotNullParameter(str, "");
                userPersonalizationRepository = CreateUserPersonalization.this.BuiltInFictitiousFunctionClassFactory;
                return userPersonalizationRepository.KClassImpl$Data$declaredNonStaticMembers$2(str, list2);
            }
        };
        Observable flatMap = userId.flatMap(new Function() { // from class: id.dana.explore.domain.userpersonalization.interactor.CreateUserPersonalization$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CreateUserPersonalization.PlaceComponentResult(Function1.this, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Inject
    public CreateUserPersonalization(AccountRepository accountRepository, UserPersonalizationRepository userPersonalizationRepository) {
        Intrinsics.checkNotNullParameter(accountRepository, "");
        Intrinsics.checkNotNullParameter(userPersonalizationRepository, "");
        this.getAuthRequestContext = accountRepository;
        this.BuiltInFictitiousFunctionClassFactory = userPersonalizationRepository;
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(Function1 function1, String str) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(str);
    }
}

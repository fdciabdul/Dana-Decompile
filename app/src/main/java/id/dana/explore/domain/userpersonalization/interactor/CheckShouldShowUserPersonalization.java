package id.dana.explore.domain.userpersonalization.interactor;

import id.dana.domain.account.AccountRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.userpersonalization.UserPersonalizationRepository;
import id.dana.explore.domain.userpersonalization.model.ShouldOpenUserPersonalizationModelWrapper;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/explore/domain/userpersonalization/interactor/CheckShouldShowUserPersonalization;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/explore/domain/userpersonalization/model/ShouldOpenUserPersonalizationModelWrapper;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/domain/account/AccountRepository;", "getAuthRequestContext", "Lid/dana/domain/account/AccountRepository;", "MyBillsEntityDataFactory", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "PlaceComponentResult", "Lid/dana/explore/domain/userpersonalization/UserPersonalizationRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/explore/domain/userpersonalization/UserPersonalizationRepository;", "p0", "p1", "p2", "<init>", "(Lid/dana/explore/domain/userpersonalization/UserPersonalizationRepository;Lid/dana/domain/account/AccountRepository;Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CheckShouldShowUserPersonalization extends BaseUseCase<ShouldOpenUserPersonalizationModelWrapper, NoParams> {
    private final UserPersonalizationRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GlobalSearchRepository PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final AccountRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<ShouldOpenUserPersonalizationModelWrapper> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        Observable onErrorReturnItem = Observable.zip(this.PlaceComponentResult.lookAheadTest(), this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(), new BiFunction() { // from class: id.dana.explore.domain.userpersonalization.interactor.CheckShouldShowUserPersonalization$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return CheckShouldShowUserPersonalization.getAuthRequestContext((Boolean) obj, (Boolean) obj2);
            }
        }).onErrorReturnItem(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        Observable<ShouldOpenUserPersonalizationModelWrapper> flatMap = onErrorReturnItem.flatMap(new Function() { // from class: id.dana.explore.domain.userpersonalization.interactor.CheckShouldShowUserPersonalization$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CheckShouldShowUserPersonalization.BuiltInFictitiousFunctionClassFactory(CheckShouldShowUserPersonalization.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Inject
    public CheckShouldShowUserPersonalization(UserPersonalizationRepository userPersonalizationRepository, AccountRepository accountRepository, GlobalSearchRepository globalSearchRepository) {
        Intrinsics.checkNotNullParameter(userPersonalizationRepository, "");
        Intrinsics.checkNotNullParameter(accountRepository, "");
        Intrinsics.checkNotNullParameter(globalSearchRepository, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = userPersonalizationRepository;
        this.MyBillsEntityDataFactory = accountRepository;
        this.PlaceComponentResult = globalSearchRepository;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(Function1 function1, String str) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(str);
    }

    public static /* synthetic */ Boolean getAuthRequestContext(Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        return Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(final CheckShouldShowUserPersonalization checkShouldShowUserPersonalization, Boolean bool) {
        Observable just;
        Intrinsics.checkNotNullParameter(checkShouldShowUserPersonalization, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (!bool.booleanValue()) {
            just = Observable.just(new ShouldOpenUserPersonalizationModelWrapper(false, true));
        } else {
            Observable<String> userId = checkShouldShowUserPersonalization.MyBillsEntityDataFactory.getUserId();
            final Function1<String, Observable<ShouldOpenUserPersonalizationModelWrapper>> function1 = new Function1<String, Observable<ShouldOpenUserPersonalizationModelWrapper>>() { // from class: id.dana.explore.domain.userpersonalization.interactor.CheckShouldShowUserPersonalization$getUserPreference$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Observable<ShouldOpenUserPersonalizationModelWrapper> invoke(String str) {
                    UserPersonalizationRepository userPersonalizationRepository;
                    UserPersonalizationRepository userPersonalizationRepository2;
                    Intrinsics.checkNotNullParameter(str, "");
                    userPersonalizationRepository = CheckShouldShowUserPersonalization.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    Boolean blockingFirst = userPersonalizationRepository.KClassImpl$Data$declaredNonStaticMembers$2(str).blockingFirst();
                    userPersonalizationRepository2 = CheckShouldShowUserPersonalization.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    Boolean blockingFirst2 = userPersonalizationRepository2.getAuthRequestContext(str).blockingFirst();
                    Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
                    boolean booleanValue = blockingFirst.booleanValue();
                    Intrinsics.checkNotNullExpressionValue(blockingFirst2, "");
                    return Observable.just(new ShouldOpenUserPersonalizationModelWrapper(booleanValue, blockingFirst2.booleanValue()));
                }
            };
            just = userId.flatMap(new Function() { // from class: id.dana.explore.domain.userpersonalization.interactor.CheckShouldShowUserPersonalization$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return CheckShouldShowUserPersonalization.MyBillsEntityDataFactory(Function1.this, (String) obj);
                }
            });
        }
        return just;
    }
}

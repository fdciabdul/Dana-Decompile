package id.dana.contract.userpersonalization;

import id.dana.base.AbstractContractKt;
import id.dana.contract.userpersonalization.UserPersonalizationContract;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.explore.domain.userpersonalization.interactor.CheckShouldShowUserPersonalization;
import id.dana.explore.domain.userpersonalization.interactor.CreateUserPersonalization;
import id.dana.explore.domain.userpersonalization.interactor.GetPersonalizationOptions;
import id.dana.explore.domain.userpersonalization.interactor.SaveUserPersonalizationShown;
import id.dana.explore.domain.userpersonalization.model.ShouldOpenUserPersonalizationModelWrapper;
import id.dana.explore.domain.userpersonalization.model.UserPersonalizationModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004R\u0014\u0010\b\u001a\u00020\f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\n\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0014\u0010\u0012\u001a\u00020\u00168\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017"}, d2 = {"Lid/dana/contract/userpersonalization/UserPersonalizationPresenter;", "Lid/dana/contract/userpersonalization/UserPersonalizationContract$Presenter;", "", "getAuthRequestContext", "()V", "", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)V", "BuiltInFictitiousFunctionClassFactory", "onDestroy", "Lid/dana/explore/domain/userpersonalization/interactor/CheckShouldShowUserPersonalization;", "Lid/dana/explore/domain/userpersonalization/interactor/CheckShouldShowUserPersonalization;", "Lid/dana/explore/domain/userpersonalization/interactor/CreateUserPersonalization;", "Lid/dana/explore/domain/userpersonalization/interactor/CreateUserPersonalization;", "MyBillsEntityDataFactory", "Lid/dana/explore/domain/userpersonalization/interactor/GetPersonalizationOptions;", "PlaceComponentResult", "Lid/dana/explore/domain/userpersonalization/interactor/GetPersonalizationOptions;", "Lid/dana/explore/domain/userpersonalization/interactor/SaveUserPersonalizationShown;", "Lid/dana/explore/domain/userpersonalization/interactor/SaveUserPersonalizationShown;", "Lid/dana/contract/userpersonalization/UserPersonalizationContract$View;", "Lid/dana/contract/userpersonalization/UserPersonalizationContract$View;", "p1", "p2", "p3", "p4", "<init>", "(Lid/dana/contract/userpersonalization/UserPersonalizationContract$View;Lid/dana/explore/domain/userpersonalization/interactor/GetPersonalizationOptions;Lid/dana/explore/domain/userpersonalization/interactor/SaveUserPersonalizationShown;Lid/dana/explore/domain/userpersonalization/interactor/CreateUserPersonalization;Lid/dana/explore/domain/userpersonalization/interactor/CheckShouldShowUserPersonalization;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserPersonalizationPresenter implements UserPersonalizationContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CreateUserPersonalization MyBillsEntityDataFactory;
    private final CheckShouldShowUserPersonalization KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SaveUserPersonalizationShown BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetPersonalizationOptions getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final UserPersonalizationContract.View PlaceComponentResult;

    @Inject
    public UserPersonalizationPresenter(UserPersonalizationContract.View view, GetPersonalizationOptions getPersonalizationOptions, SaveUserPersonalizationShown saveUserPersonalizationShown, CreateUserPersonalization createUserPersonalization, CheckShouldShowUserPersonalization checkShouldShowUserPersonalization) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getPersonalizationOptions, "");
        Intrinsics.checkNotNullParameter(saveUserPersonalizationShown, "");
        Intrinsics.checkNotNullParameter(createUserPersonalization, "");
        Intrinsics.checkNotNullParameter(checkShouldShowUserPersonalization, "");
        this.PlaceComponentResult = view;
        this.getAuthRequestContext = getPersonalizationOptions;
        this.BuiltInFictitiousFunctionClassFactory = saveUserPersonalizationShown;
        this.MyBillsEntityDataFactory = createUserPersonalization;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = checkShouldShowUserPersonalization;
    }

    @Override // id.dana.contract.userpersonalization.UserPersonalizationContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.getAuthRequestContext.execute(NoParams.INSTANCE, new Function1<List<? extends UserPersonalizationModel>, Unit>() { // from class: id.dana.contract.userpersonalization.UserPersonalizationPresenter$getPersonalizationOptions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends UserPersonalizationModel> list) {
                invoke2((List<UserPersonalizationModel>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<UserPersonalizationModel> list) {
                UserPersonalizationContract.View view;
                UserPersonalizationContract.View view2;
                Intrinsics.checkNotNullParameter(list, "");
                if (list.isEmpty()) {
                    view2 = UserPersonalizationPresenter.this.PlaceComponentResult;
                    view2.getAuthRequestContext();
                    return;
                }
                view = UserPersonalizationPresenter.this.PlaceComponentResult;
                view.getAuthRequestContext(list);
                CompletableUseCase.execute$default(UserPersonalizationPresenter.this.BuiltInFictitiousFunctionClassFactory, NoParams.INSTANCE, null, null, 6, null);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.userpersonalization.UserPersonalizationPresenter$getPersonalizationOptions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                UserPersonalizationContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = UserPersonalizationPresenter.this.PlaceComponentResult;
                view.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.contract.userpersonalization.UserPersonalizationContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.execute(p0, new Function1<Boolean, Unit>() { // from class: id.dana.contract.userpersonalization.UserPersonalizationPresenter$createUserPersonalization$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                UserPersonalizationContract.View view;
                UserPersonalizationContract.View view2;
                if (z) {
                    view2 = UserPersonalizationPresenter.this.PlaceComponentResult;
                    view2.BuiltInFictitiousFunctionClassFactory();
                    return;
                }
                view = UserPersonalizationPresenter.this.PlaceComponentResult;
                view.MyBillsEntityDataFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.userpersonalization.UserPersonalizationPresenter$createUserPersonalization$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                UserPersonalizationContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = UserPersonalizationPresenter.this.PlaceComponentResult;
                view.MyBillsEntityDataFactory();
            }
        });
    }

    @Override // id.dana.contract.userpersonalization.UserPersonalizationContract.Presenter
    public final void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function1<ShouldOpenUserPersonalizationModelWrapper, Unit>() { // from class: id.dana.contract.userpersonalization.UserPersonalizationPresenter$checkShowUserPersonalizationFirstTime$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ShouldOpenUserPersonalizationModelWrapper shouldOpenUserPersonalizationModelWrapper) {
                invoke2(shouldOpenUserPersonalizationModelWrapper);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ShouldOpenUserPersonalizationModelWrapper shouldOpenUserPersonalizationModelWrapper) {
                UserPersonalizationContract.View view;
                Intrinsics.checkNotNullParameter(shouldOpenUserPersonalizationModelWrapper, "");
                view = UserPersonalizationPresenter.this.PlaceComponentResult;
                view.MyBillsEntityDataFactory(shouldOpenUserPersonalizationModelWrapper.getIsFirstTime());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.userpersonalization.UserPersonalizationPresenter$checkShowUserPersonalizationFirstTime$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_SUBMITTED_USER_PREFERENCE, th.toString());
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.getAuthRequestContext.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }
}

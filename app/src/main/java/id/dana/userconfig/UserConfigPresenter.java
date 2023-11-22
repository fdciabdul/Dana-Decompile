package id.dana.userconfig;

import dagger.Lazy;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.recentrecipient.interactor.MigrateRecentRecipientConfigToRoom;
import id.dana.domain.user.interactor.GetUserPan;
import id.dana.userconfig.UserConfigContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.observers.DisposableCompletableObserver;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public class UserConfigPresenter implements UserConfigContract.Presenter {
    private final Lazy<GetUserPan> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy<MigrateRecentRecipientConfigToRoom> MyBillsEntityDataFactory;
    final Lazy<UserConfigContract.View> PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit PlaceComponentResult() {
        return null;
    }

    @Inject
    public UserConfigPresenter(Lazy<MigrateRecentRecipientConfigToRoom> lazy, Lazy<GetUserPan> lazy2, Lazy<UserConfigContract.View> lazy3) {
        this.MyBillsEntityDataFactory = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
        this.PlaceComponentResult = lazy3;
    }

    @Override // id.dana.userconfig.UserConfigContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.userconfig.UserConfigPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Boolean bool = (Boolean) obj;
                UserConfigPresenter.this.PlaceComponentResult.get().KClassImpl$Data$declaredNonStaticMembers$2();
                return null;
            }
        }, new Function1() { // from class: id.dana.userconfig.UserConfigPresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                return UserConfigPresenter.PlaceComponentResult();
            }
        });
    }

    @Override // id.dana.userconfig.UserConfigContract.Presenter
    public final void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(new DisposableCompletableObserver() { // from class: id.dana.userconfig.UserConfigPresenter.1
            @Override // io.reactivex.CompletableObserver
            public void onComplete() {
                dispose();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                DanaLog.BuiltInFictitiousFunctionClassFactory("Error get User Pan in Home Fragment", th.getMessage());
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.get().dispose();
    }
}

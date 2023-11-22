package id.dana.challenge.pin;

import dagger.Lazy;
import id.dana.challenge.pin.LogoutContract;
import id.dana.di.PerActivity;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.utils.session.SessionManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f"}, d2 = {"Lid/dana/challenge/pin/LogoutPresenter;", "Lid/dana/challenge/pin/LogoutContract$Presenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "onDestroy", "Lid/dana/domain/auth/face/interactor/ClearFaceAuthSuggestionState;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/auth/face/interactor/ClearFaceAuthSuggestionState;", "PlaceComponentResult", "Ldagger/Lazy;", "Lid/dana/utils/session/SessionManager;", "getAuthRequestContext", "Ldagger/Lazy;", "Lid/dana/challenge/pin/LogoutContract$View;", "Lid/dana/challenge/pin/LogoutContract$View;", "p0", "p1", "p2", "<init>", "(Lid/dana/challenge/pin/LogoutContract$View;Ldagger/Lazy;Lid/dana/domain/auth/face/interactor/ClearFaceAuthSuggestionState;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class LogoutPresenter implements LogoutContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ClearFaceAuthSuggestionState PlaceComponentResult;
    private final LogoutContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<SessionManager> BuiltInFictitiousFunctionClassFactory;

    @Inject
    public LogoutPresenter(LogoutContract.View view, Lazy<SessionManager> lazy, ClearFaceAuthSuggestionState clearFaceAuthSuggestionState) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(clearFaceAuthSuggestionState, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.PlaceComponentResult = clearFaceAuthSuggestionState;
    }

    @Override // id.dana.challenge.pin.LogoutContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        this.BuiltInFictitiousFunctionClassFactory.get().BuiltInFictitiousFunctionClassFactory(new Function0<Unit>() { // from class: id.dana.challenge.pin.LogoutPresenter$logout$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LogoutContract.View view;
                LogoutContract.View view2;
                view = LogoutPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.MyBillsEntityDataFactory();
                view2 = LogoutPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.PlaceComponentResult();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.pin.LogoutPresenter$logout$2
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
                LogoutContract.View view;
                LogoutContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = LogoutPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.MyBillsEntityDataFactory();
                view2 = LogoutPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.PlaceComponentResult();
            }
        });
        BaseUseCase.execute$default(this.PlaceComponentResult, NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.challenge.pin.LogoutPresenter$clearUserEducation$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, null, 4, null);
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.get().BuiltInFictitiousFunctionClassFactory();
        this.PlaceComponentResult.dispose();
    }
}

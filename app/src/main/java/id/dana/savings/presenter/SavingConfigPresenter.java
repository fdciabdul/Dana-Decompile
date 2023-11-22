package id.dana.savings.presenter;

import android.content.Context;
import id.dana.di.PerActivity;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.saving.interactor.GetSavingBalanceVisibility;
import id.dana.domain.saving.interactor.SaveSavingBalanceVisibility;
import id.dana.savings.contract.SavingConfigContract;
import id.dana.savings.parser.SavingErrorParser;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0014\u0010\u000e\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013"}, d2 = {"Lid/dana/savings/presenter/SavingConfigPresenter;", "Lid/dana/savings/contract/SavingConfigContract$Presenter;", "", "getAuthRequestContext", "()V", "onDestroy", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Lid/dana/domain/saving/interactor/GetSavingBalanceVisibility;", "Lid/dana/domain/saving/interactor/GetSavingBalanceVisibility;", "PlaceComponentResult", "", "BuiltInFictitiousFunctionClassFactory", "Z", "Lid/dana/domain/saving/interactor/SaveSavingBalanceVisibility;", "Lid/dana/domain/saving/interactor/SaveSavingBalanceVisibility;", "Lid/dana/savings/contract/SavingConfigContract$View;", "Lid/dana/savings/contract/SavingConfigContract$View;", "p0", "p1", "p2", "p3", "<init>", "(Landroid/content/Context;Lid/dana/savings/contract/SavingConfigContract$View;Lid/dana/domain/saving/interactor/GetSavingBalanceVisibility;Lid/dana/domain/saving/interactor/SaveSavingBalanceVisibility;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class SavingConfigPresenter implements SavingConfigContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetSavingBalanceVisibility PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final SaveSavingBalanceVisibility KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final SavingConfigContract.View BuiltInFictitiousFunctionClassFactory;

    @Inject
    public SavingConfigPresenter(Context context, SavingConfigContract.View view, GetSavingBalanceVisibility getSavingBalanceVisibility, SaveSavingBalanceVisibility saveSavingBalanceVisibility) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getSavingBalanceVisibility, "");
        Intrinsics.checkNotNullParameter(saveSavingBalanceVisibility, "");
        this.MyBillsEntityDataFactory = context;
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.PlaceComponentResult = getSavingBalanceVisibility;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = saveSavingBalanceVisibility;
    }

    public final void getAuthRequestContext() {
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        this.PlaceComponentResult.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.savings.presenter.SavingConfigPresenter$getSavingBalanceVisibility$1
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
                SavingConfigContract.View view;
                SavingConfigContract.View view2;
                view = SavingConfigPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.dismissProgress();
                view2 = SavingConfigPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view2.getAuthRequestContext(z);
                SavingConfigPresenter.this.getAuthRequestContext = z;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingConfigPresenter$getSavingBalanceVisibility$2
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
                SavingConfigContract.View view;
                SavingConfigContract.View view2;
                Context context;
                SavingConfigContract.View view3;
                boolean z;
                Intrinsics.checkNotNullParameter(th, "");
                view = SavingConfigPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.dismissProgress();
                view2 = SavingConfigPresenter.this.BuiltInFictitiousFunctionClassFactory;
                SavingErrorParser savingErrorParser = SavingErrorParser.INSTANCE;
                context = SavingConfigPresenter.this.MyBillsEntityDataFactory;
                view2.onError(SavingErrorParser.PlaceComponentResult(context, th.getLocalizedMessage()));
                view3 = SavingConfigPresenter.this.BuiltInFictitiousFunctionClassFactory;
                z = SavingConfigPresenter.this.getAuthRequestContext;
                view3.getAuthRequestContext(z);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }
}

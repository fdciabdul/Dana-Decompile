package id.dana.savings.presenter;

import android.content.Context;
import id.dana.R;
import id.dana.di.PerActivity;
import id.dana.domain.saving.interactor.InitSavingUpdate;
import id.dana.domain.saving.interactor.UpdateSaving;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.savings.contract.SavingUpdateContract;
import id.dana.savings.ext.SavingErrorHandler;
import id.dana.savings.parser.SavingErrorParser;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0006\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/savings/presenter/SavingUpdatePresenter;", "Lid/dana/savings/contract/SavingUpdateContract$Presenter;", "", "onDestroy", "()V", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "getAuthRequestContext", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "Lid/dana/domain/saving/interactor/InitSavingUpdate;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/saving/interactor/InitSavingUpdate;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/saving/interactor/UpdateSaving;", "Lid/dana/domain/saving/interactor/UpdateSaving;", "Lid/dana/savings/contract/SavingUpdateContract$View;", "PlaceComponentResult", "Lid/dana/savings/contract/SavingUpdateContract$View;", "p0", "p1", "p2", "p3", "p4", "<init>", "(Landroid/content/Context;Lid/dana/savings/contract/SavingUpdateContract$View;Lid/dana/domain/saving/interactor/InitSavingUpdate;Lid/dana/domain/saving/interactor/UpdateSaving;Lid/dana/domain/user/interactor/GetUserInfoWithKyc;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class SavingUpdatePresenter implements SavingUpdateContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final InitSavingUpdate KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final UpdateSaving BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context getAuthRequestContext;
    public final SavingUpdateContract.View PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final GetUserInfoWithKyc MyBillsEntityDataFactory;

    @Inject
    public SavingUpdatePresenter(Context context, SavingUpdateContract.View view, InitSavingUpdate initSavingUpdate, UpdateSaving updateSaving, GetUserInfoWithKyc getUserInfoWithKyc) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(initSavingUpdate, "");
        Intrinsics.checkNotNullParameter(updateSaving, "");
        Intrinsics.checkNotNullParameter(getUserInfoWithKyc, "");
        this.getAuthRequestContext = context;
        this.PlaceComponentResult = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = initSavingUpdate;
        this.BuiltInFictitiousFunctionClassFactory = updateSaving;
        this.MyBillsEntityDataFactory = getUserInfoWithKyc;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SavingUpdatePresenter savingUpdatePresenter, Throwable th) {
        SavingErrorHandler savingErrorHandler = SavingErrorHandler.INSTANCE;
        if (Intrinsics.areEqual(SavingErrorHandler.BuiltInFictitiousFunctionClassFactory(th), "NETWORK_ERROR")) {
            savingUpdatePresenter.PlaceComponentResult.onError(savingUpdatePresenter.getAuthRequestContext.getString(R.string.error_saving_default));
            return;
        }
        SavingUpdateContract.View view = savingUpdatePresenter.PlaceComponentResult;
        SavingErrorParser savingErrorParser = SavingErrorParser.INSTANCE;
        view.onError(SavingErrorParser.PlaceComponentResult(savingUpdatePresenter.getAuthRequestContext, th.getLocalizedMessage()));
    }
}

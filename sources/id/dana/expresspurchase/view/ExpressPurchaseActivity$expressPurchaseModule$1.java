package id.dana.expresspurchase.view;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.os.BundleKt;
import com.zhuinden.simplestack.History;
import id.dana.R;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.model.SnackbarEvent;
import id.dana.animation.tab.HomeTabs;
import id.dana.base.AbstractContractKt;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.component.customsnackbarcomponent.SnackbarPosition;
import id.dana.component.customsnackbarcomponent.SnackbarState;
import id.dana.domain.expresspurchase.interaction.model.DealsShopInfo;
import id.dana.expresspurchase.constant.ExpressPurchaseResult;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import id.dana.expresspurchase.presenter.ExpressPurchaseContract;
import id.dana.expresspurchase.view.ExpressPurchaseLoadingView;
import id.dana.expresspurchase.view.OfferInfoDeals;
import id.dana.expresspurchase.view.OfferProductView;
import id.dana.kyb.model.KybPageInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004JQ\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0003\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u001aJ\u001f\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0015\u0010\u001aJ\u001f\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0003\u0010\u001aJ'\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u001bJ\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J3\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u0003\u0010\u001d"}, d2 = {"Lid/dana/expresspurchase/view/ExpressPurchaseActivity$expressPurchaseModule$1;", "Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$View;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "p0", "", "p1", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;", "p2", "", "p3", "", "", "p4", "p5", "(Ljava/lang/String;Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/expresspurchase/interaction/model/DealsShopInfo;", "MyBillsEntityDataFactory", "(Lid/dana/domain/expresspurchase/interaction/model/DealsShopInfo;)V", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Deals;", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/expresspurchase/model/ExpressPurchaseModel$Deals;)V", "(Ljava/lang/String;Lid/dana/expresspurchase/model/ExpressPurchaseModel$Deals;)V", "(ZLjava/lang/String;Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;)V", "Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/expresspurchase/model/ExpressPurchaseModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ExpressPurchaseActivity$expressPurchaseModule$1 implements ExpressPurchaseContract.View {
    final /* synthetic */ ExpressPurchaseActivity KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ExpressPurchaseModel expressPurchaseModel) {
        ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory(expressPurchaseModel);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExpressPurchaseActivity$expressPurchaseModule$1(ExpressPurchaseActivity expressPurchaseActivity) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = expressPurchaseActivity;
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
    public final void PlaceComponentResult() {
        int height = ((FrameLayout) this.KClassImpl$Data$declaredNonStaticMembers$2._$_findCachedViewById(R.id.WalletSearchPresenter$getPaymentAssetsBasedOnAssetType$1$invoke$$inlined$sortedBy$1)).getHeight();
        ExpressPurchaseNavigationManager navigationManager = this.KClassImpl$Data$declaredNonStaticMembers$2.getNavigationManager();
        if (navigationManager.MyBillsEntityDataFactory == null) {
            navigationManager.MyBillsEntityDataFactory = new ExpressPurchaseLoadingScreen(R.layout.view_express_purchase_loading, BundleKt.PlaceComponentResult(TuplesKt.to(ExpressPurchaseLoadingView.KEY_LOADING_SCREEN_HEIGHT, Integer.valueOf(height))));
        }
        ExpressPurchaseLoadingScreen expressPurchaseLoadingScreen = navigationManager.MyBillsEntityDataFactory;
        if (expressPurchaseLoadingScreen == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            expressPurchaseLoadingScreen = null;
        }
        ExpressPurchaseLoadingScreen expressPurchaseLoadingScreen2 = expressPurchaseLoadingScreen;
        Intrinsics.checkNotNullParameter(expressPurchaseLoadingScreen2, "");
        navigationManager.getAuthRequestContext.goTo(expressPurchaseLoadingScreen2);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Bundle, kotlin.jvm.internal.DefaultConstructorMarker] */
    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
    public final void getAuthRequestContext() {
        ?? r2 = 0;
        EventBus.getDefault().post(new ExpressPurchaseLoadingView.DanaProtectionLoadingEvent(ExpressPurchaseActivity.STOP_LOADING, r2, 2, r2));
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
    public final void BuiltInFictitiousFunctionClassFactory() {
        EventBus.getDefault().post(new OfferProductView.DismissLoadingDialogEvent());
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
    public final void BuiltInFictitiousFunctionClassFactory(final String str, final ExpressPurchaseModel.Gold gold, List<String> list, Map<String, ? extends Object> map, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(gold, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.getNavigationManager().getAuthRequestContext.goBack();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$expressPurchaseModule$1$$ExternalSyntheticLambda0
            public final /* synthetic */ boolean PlaceComponentResult = true;

            @Override // java.lang.Runnable
            public final void run() {
                ExpressPurchaseActivity$expressPurchaseModule$1.KClassImpl$Data$declaredNonStaticMembers$2(ExpressPurchaseActivity$expressPurchaseModule$1.this, this.PlaceComponentResult, str, gold);
            }
        }, 500L);
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2, ExpressPurchaseModel p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        ExpressPurchaseActivity.access$prepareBundle(this.KClassImpl$Data$declaredNonStaticMembers$2, p1, p2, p3);
        if (Intrinsics.areEqual(p0, ExpressPurchaseResult.PREV_SCREEN_CONFIRMATION)) {
            ExpressPurchaseNavigationManager navigationManager = this.KClassImpl$Data$declaredNonStaticMembers$2.getNavigationManager();
            ExpressPurchaseResultScreen expressPurchaseResultScreen = new ExpressPurchaseResultScreen(R.layout.view_express_purchase_bundle_result, this.KClassImpl$Data$declaredNonStaticMembers$2.getIntent().getExtras());
            Intrinsics.checkNotNullParameter(expressPurchaseResultScreen, "");
            navigationManager.getAuthRequestContext.setHistory(History.single(expressPurchaseResultScreen), 0);
            return;
        }
        EventBus.getDefault().post(new ExpressPurchaseLoadingView.DanaProtectionLoadingEvent(ExpressPurchaseActivity.OPEN_RESULT_PAGE, this.KClassImpl$Data$declaredNonStaticMembers$2.getIntent().getExtras()));
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
    public final void getAuthRequestContext(boolean p0, String p1, final ExpressPurchaseModel.Gold p2) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        ExpressPurchaseGoldViewExtender expressPurchaseGoldExtender = this.KClassImpl$Data$declaredNonStaticMembers$2.expressPurchaseGoldExtender();
        final ExpressPurchaseActivity expressPurchaseActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$expressPurchaseModule$1$showChangedPriceDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ExpressPurchaseActivity.this.expressPurchaseGoldExtender().BuiltInFictitiousFunctionClassFactory(p2);
            }
        };
        final ExpressPurchaseActivity expressPurchaseActivity2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        expressPurchaseGoldExtender.PlaceComponentResult(p0, p1, function0, new Function2<Boolean, Boolean, Unit>() { // from class: id.dana.expresspurchase.view.ExpressPurchaseActivity$expressPurchaseModule$1$showChangedPriceDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                invoke(bool.booleanValue(), bool2.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z, boolean z2) {
                ExpressPurchaseActivity.this.getExpressPurchaseAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(z, z2, null);
            }
        });
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
    public final void MyBillsEntityDataFactory(DealsShopInfo p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        EventBus.getDefault().post(new OfferInfoDeals.DealsShopLocationEvent(p0));
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        ExpressPurchaseActivity expressPurchaseActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        EventBus.getDefault().post(new OfferInfoDeals.DealsShopLocationFailedEvent());
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ExpressPurchaseActivity$expressPurchaseModule$1 expressPurchaseActivity$expressPurchaseModule$1, boolean z, String str, ExpressPurchaseModel.Gold gold) {
        Intrinsics.checkNotNullParameter(expressPurchaseActivity$expressPurchaseModule$1, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(gold, "");
        expressPurchaseActivity$expressPurchaseModule$1.getAuthRequestContext(z, str, gold);
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
    public final void PlaceComponentResult(String p0, String p1, ExpressPurchaseModel.Deals p2) {
        int i;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        EventBus.getDefault().post(new OfferProductView.DismissLoadingDialogEvent());
        this.KClassImpl$Data$declaredNonStaticMembers$2.trackExpressPurchaseResult("Failed", (r16 & 2) != 0 ? "" : null, (r16 & 4) != 0 ? "" : p0, p2, (r16 & 16) != 0 ? "" : null, (r16 & 32) != 0 ? "" : ExpressPurchaseActivity.DEALS_EVENT_SOURCE);
        View findViewById = this.KClassImpl$Data$declaredNonStaticMembers$2.findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        CustomSnackbar.Builder builder = new CustomSnackbar.Builder((ViewGroup) findViewById);
        builder.initRecordTimeStamp = this.KClassImpl$Data$declaredNonStaticMembers$2.getResources().getString(R.string.deals_express_snackbar_fail_with_retry);
        CustomSnackbar.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(SnackbarState.FAIL);
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_close_red;
        SnackbarPosition snackbarPosition = SnackbarPosition.TOP;
        Intrinsics.checkNotNullParameter(snackbarPosition, "");
        MyBillsEntityDataFactory.GetContactSyncConfig = snackbarPosition;
        i = this.KClassImpl$Data$declaredNonStaticMembers$2.pageHeight;
        double d = i;
        Double.isNaN(d);
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = (int) (d * 0.1d);
        MyBillsEntityDataFactory.moveToNextValue = 0;
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory().show();
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
    public final void PlaceComponentResult(String p0, ExpressPurchaseModel.Deals p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        EventBus.getDefault().post(new OfferProductView.DismissLoadingDialogEvent());
        this.KClassImpl$Data$declaredNonStaticMembers$2.trackExpressPurchaseResult("Failed", (r16 & 2) != 0 ? "" : null, (r16 & 4) != 0 ? "" : null, p1, (r16 & 16) != 0 ? "" : p0, (r16 & 32) != 0 ? "" : ExpressPurchaseActivity.DEALS_EVENT_SOURCE);
        HomeTabActivity.Companion companion = HomeTabActivity.INSTANCE;
        ExpressPurchaseActivity expressPurchaseActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        HomeTabs homeTabs = HomeTabs.HOME;
        KybPageInfo kybPageInfo = new KybPageInfo(false, false, null, false, 15, null);
        String string = this.KClassImpl$Data$declaredNonStaticMembers$2.getResources().getString(R.string.deals_express_snackbar_fail_without_retry);
        Intrinsics.checkNotNullExpressionValue(string, "");
        HomeTabActivity.Companion.PlaceComponentResult(expressPurchaseActivity, homeTabs, kybPageInfo, new SnackbarEvent(string, SnackbarState.FAIL, null, null, R.drawable.ic_close_red));
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
    public final void MyBillsEntityDataFactory(String p0, ExpressPurchaseModel.Deals p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        EventBus.getDefault().post(new OfferProductView.DismissLoadingDialogEvent());
        this.KClassImpl$Data$declaredNonStaticMembers$2.trackExpressPurchaseResult("Pending", (r16 & 2) != 0 ? "" : null, (r16 & 4) != 0 ? "" : null, p1, (r16 & 16) != 0 ? "" : p0, (r16 & 32) != 0 ? "" : ExpressPurchaseActivity.DEALS_EVENT_SOURCE);
        HomeTabActivity.Companion companion = HomeTabActivity.INSTANCE;
        ExpressPurchaseActivity expressPurchaseActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        HomeTabs homeTabs = HomeTabs.HOME;
        KybPageInfo kybPageInfo = new KybPageInfo(false, false, null, false, 15, null);
        String string = this.KClassImpl$Data$declaredNonStaticMembers$2.getResources().getString(R.string.deals_express_snackbar_pending);
        Intrinsics.checkNotNullExpressionValue(string, "");
        HomeTabActivity.Companion.PlaceComponentResult(expressPurchaseActivity, homeTabs, kybPageInfo, new SnackbarEvent(string, SnackbarState.WARNING, HomeTabs.POCKET, this.KClassImpl$Data$declaredNonStaticMembers$2.getResources().getString(R.string.deals_express_snackbar_ok), R.drawable.ic_warning_24_yellow50));
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.View
    public final void BuiltInFictitiousFunctionClassFactory(String p0, ExpressPurchaseModel.Deals p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        EventBus.getDefault().post(new OfferProductView.DismissLoadingDialogEvent());
        this.KClassImpl$Data$declaredNonStaticMembers$2.trackExpressPurchaseResult("Success", (r16 & 2) != 0 ? "" : null, (r16 & 4) != 0 ? "" : null, p1, (r16 & 16) != 0 ? "" : p0, (r16 & 32) != 0 ? "" : ExpressPurchaseActivity.DEALS_EVENT_SOURCE);
        HomeTabActivity.Companion companion = HomeTabActivity.INSTANCE;
        ExpressPurchaseActivity expressPurchaseActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        HomeTabs homeTabs = HomeTabs.HOME;
        KybPageInfo kybPageInfo = new KybPageInfo(false, false, null, false, 15, null);
        String string = this.KClassImpl$Data$declaredNonStaticMembers$2.getResources().getString(R.string.deals_express_snackbar_success);
        Intrinsics.checkNotNullExpressionValue(string, "");
        HomeTabActivity.Companion.PlaceComponentResult(expressPurchaseActivity, homeTabs, kybPageInfo, new SnackbarEvent(string, SnackbarState.SUCCESS, HomeTabs.POCKET, this.KClassImpl$Data$declaredNonStaticMembers$2.getResources().getString(R.string.deals_express_snackbar_view), R.drawable.ic_success));
        this.KClassImpl$Data$declaredNonStaticMembers$2.finish();
    }
}

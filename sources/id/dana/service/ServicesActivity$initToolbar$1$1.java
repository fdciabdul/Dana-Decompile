package id.dana.service;

import android.os.Handler;
import android.widget.TextView;
import id.dana.R;
import id.dana.richview.ToolbarSearchView;
import id.dana.richview.servicescard.ServiceCategoryView;
import id.dana.service.adapter.ServiceAdapter;
import id.dana.tracker.spm.ServicesTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0003\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\tR\u0014\u0010\n\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0014\u0010\u0005\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011"}, d2 = {"Lid/dana/service/ServicesActivity$initToolbar$1$1;", "Lid/dana/richview/ToolbarSearchView$Listener;", "", "MyBillsEntityDataFactory", "()V", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "", "p0", "(Ljava/lang/CharSequence;)V", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "", "J", "Landroid/os/Handler;", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServicesActivity$initToolbar$1$1 implements ToolbarSearchView.Listener {
    final /* synthetic */ ServicesActivity PlaceComponentResult;
    private final Handler getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Runnable KClassImpl$Data$declaredNonStaticMembers$2 = new Runnable() { // from class: id.dana.service.ServicesActivity$initToolbar$1$1$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            ServicesActivity$initToolbar$1$1.PlaceComponentResult();
        }
    };

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final long BuiltInFictitiousFunctionClassFactory = 500;

    public static /* synthetic */ void PlaceComponentResult() {
    }

    @Override // id.dana.richview.ToolbarSearchView.Listener
    public final void MyBillsEntityDataFactory(CharSequence p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServicesActivity$initToolbar$1$1(ServicesActivity servicesActivity) {
        this.PlaceComponentResult = servicesActivity;
        this.getAuthRequestContext = new Handler(servicesActivity.getMainLooper());
    }

    @Override // id.dana.richview.ToolbarSearchView.Listener
    public final void PlaceComponentResult(final CharSequence p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.removeCallbacks(this.KClassImpl$Data$declaredNonStaticMembers$2);
        Runnable runnable = new Runnable() { // from class: id.dana.service.ServicesActivity$initToolbar$1$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ServicesActivity$initToolbar$1$1.PlaceComponentResult(ServicesActivity$initToolbar$1$1.this, p0);
            }
        };
        this.KClassImpl$Data$declaredNonStaticMembers$2 = runnable;
        this.getAuthRequestContext.postDelayed(runnable, this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // id.dana.richview.ToolbarSearchView.Listener
    public final void MyBillsEntityDataFactory() {
        this.PlaceComponentResult.onBackPressed();
    }

    @Override // id.dana.richview.ToolbarSearchView.Listener
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        ServicesActivity.access$setCategoryViewVisibility(this.PlaceComponentResult, false);
        ServicesTracker.MyBillsEntityDataFactory(this.PlaceComponentResult);
    }

    @Override // id.dana.richview.ToolbarSearchView.Listener
    public final void getAuthRequestContext() {
        ServicesActivity.access$setErrorView(this.PlaceComponentResult, false);
    }

    @Override // id.dana.richview.ToolbarSearchView.Listener
    public final void BuiltInFictitiousFunctionClassFactory() {
        ServicesActivity.access$setCategoryViewVisibility(this.PlaceComponentResult, true);
        ((TextView) this.PlaceComponentResult._$_findCachedViewById(R.id.tv_search_result)).setVisibility(8);
    }

    public static /* synthetic */ void PlaceComponentResult(ServicesActivity$initToolbar$1$1 servicesActivity$initToolbar$1$1, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(servicesActivity$initToolbar$1$1, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        ServiceAdapter access$getServiceAdapter$p = ServicesActivity.access$getServiceAdapter$p(servicesActivity$initToolbar$1$1.PlaceComponentResult);
        ServiceItemDecorator serviceItemDecorator = null;
        if (access$getServiceAdapter$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            access$getServiceAdapter$p = null;
        }
        if (access$getServiceAdapter$p.getPlaceComponentResult() > 0) {
            ServiceAdapter access$getServiceAdapter$p2 = ServicesActivity.access$getServiceAdapter$p(servicesActivity$initToolbar$1$1.PlaceComponentResult);
            if (access$getServiceAdapter$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                access$getServiceAdapter$p2 = null;
            }
            access$getServiceAdapter$p2.getItems().clear();
        }
        String obj = StringsKt.trim((CharSequence) charSequence.toString()).toString();
        if (obj.length() >= 3) {
            ServicesActivity.access$showSearchHeader(servicesActivity$initToolbar$1$1.PlaceComponentResult, true);
            ServiceItemDecorator access$getServiceItemDecorator$p = ServicesActivity.access$getServiceItemDecorator$p(servicesActivity$initToolbar$1$1.PlaceComponentResult);
            if (access$getServiceItemDecorator$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                serviceItemDecorator = access$getServiceItemDecorator$p;
            }
            serviceItemDecorator.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            servicesActivity$initToolbar$1$1.PlaceComponentResult.getPresenter().KClassImpl$Data$declaredNonStaticMembers$2(obj);
            return;
        }
        ServicesActivity.access$showSearchHeader(servicesActivity$initToolbar$1$1.PlaceComponentResult, false);
        ServiceItemDecorator access$getServiceItemDecorator$p2 = ServicesActivity.access$getServiceItemDecorator$p(servicesActivity$initToolbar$1$1.PlaceComponentResult);
        if (access$getServiceItemDecorator$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            serviceItemDecorator = access$getServiceItemDecorator$p2;
        }
        serviceItemDecorator.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        if (!((ServiceCategoryView) servicesActivity$initToolbar$1$1.PlaceComponentResult._$_findCachedViewById(R.id.scv_categories)).isDefaultSelected()) {
            ((ServiceCategoryView) servicesActivity$initToolbar$1$1.PlaceComponentResult._$_findCachedViewById(R.id.scv_categories)).setDefaultSelected(false);
        }
        servicesActivity$initToolbar$1$1.PlaceComponentResult.getPresenter().MyBillsEntityDataFactory();
    }
}

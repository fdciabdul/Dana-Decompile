package id.dana.richview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ResourceManagerInternal;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.contract.maintenance.DaggerMaintenanceBroadcastComponent;
import id.dana.contract.maintenance.MaintenanceBroadcastComponent;
import id.dana.contract.maintenance.MaintenanceBroadcastContract;
import id.dana.contract.maintenance.MaintenanceBroadcastModule;
import id.dana.databinding.ViewMaintenanceBroadcastBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.utils.measureloadscreen.FirstDrawListener;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class MaintenanceBroadcastView extends ViewBindingRichView<ViewMaintenanceBroadcastBinding> implements MaintenanceBroadcastContract.View {
    private MaintenanceBroadcastComponent KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    Lazy<MaintenanceBroadcastContract.Presenter> presenter;

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_maintenance_broadcast;
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }

    public MaintenanceBroadcastView(Context context) {
        super(context);
    }

    public MaintenanceBroadcastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaintenanceBroadcastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MaintenanceBroadcastView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        byte b = 0;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            DaggerMaintenanceBroadcastComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerMaintenanceBroadcastComponent.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (MaintenanceBroadcastModule) Preconditions.getAuthRequestContext(new MaintenanceBroadcastModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, MaintenanceBroadcastModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, ApplicationComponent.class);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new DaggerMaintenanceBroadcastComponent.MaintenanceBroadcastComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, b);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(this.presenter.get());
    }

    @Override // id.dana.base.BaseRichView
    public void init(Context context, AttributeSet attributeSet, boolean z) {
        super.init(context, attributeSet, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public ViewMaintenanceBroadcastBinding initViewBinding(View view) {
        return ViewMaintenanceBroadcastBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
    }

    @Override // id.dana.base.BaseRichView
    public void injected(boolean z) {
        Drawable BuiltInFictitiousFunctionClassFactory;
        if (z) {
            BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), R.drawable.ic_notification);
            getBinding().PlaceComponentResult.setCompoundDrawablesWithIntrinsicBounds(BuiltInFictitiousFunctionClassFactory, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setup$0$id-dana-richview-MaintenanceBroadcastView  reason: not valid java name */
    public /* synthetic */ void m2807lambda$setup$0$iddanarichviewMaintenanceBroadcastView() {
        this.presenter.get().BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        final Runnable runnable = new Runnable() { // from class: id.dana.richview.MaintenanceBroadcastView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MaintenanceBroadcastView.this.m2807lambda$setup$0$iddanarichviewMaintenanceBroadcastView();
            }
        };
        FirstDrawListener.getAuthRequestContext(getBinding().getAuthRequestContext, new FirstDrawListener.OnFirstDrawCallback() { // from class: id.dana.richview.MaintenanceBroadcastView.1
            @Override // id.dana.utils.measureloadscreen.FirstDrawListener.OnFirstDrawCallback
            public final void getAuthRequestContext() {
            }

            @Override // id.dana.utils.measureloadscreen.FirstDrawListener.OnFirstDrawCallback
            public final void BuiltInFictitiousFunctionClassFactory() {
                runnable.run();
            }
        });
    }

    @Override // id.dana.contract.maintenance.MaintenanceBroadcastContract.View
    public void showMaintenanceBroadcast(String str) {
        getBinding().PlaceComponentResult.setVisibility(0);
        getBinding().PlaceComponentResult.setText(str);
        getBinding().PlaceComponentResult.requestFocus();
        getBinding().PlaceComponentResult.setSelected(true);
    }

    @Override // id.dana.contract.maintenance.MaintenanceBroadcastContract.View
    public void hideMaintenanceBroadcast() {
        getBinding().PlaceComponentResult.setVisibility(8);
    }
}

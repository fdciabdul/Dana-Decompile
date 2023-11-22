package id.dana.onboarding.verify.devicelimit;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBinding;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.KeyBaseActivity;
import id.dana.base.KeyBaseFragment;
import id.dana.base.MenuItemButtonListener;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.dialog.DanaLoadingDialogFragment;
import id.dana.danah5.DanaH5;
import id.dana.databinding.FragmentDeviceLimitErrorBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerDeviceLimitErrorComponent;
import id.dana.di.component.DeviceLimitErrorComponent;
import id.dana.di.modules.DeviceLimitErrorModule;
import id.dana.domain.registration.model.HelpButtonOtpLimitDeviceModel;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.OnboardingNavigationManagerWithMenu;
import id.dana.onboarding.verify.devicelimit.DeviceLimitErrorContract;
import id.dana.utils.danah5.DanaH5Listener;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u0001\"B\u0007¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0014\u001a\u00020\u0011X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0087\"¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Lid/dana/onboarding/verify/devicelimit/DeviceLimitErrorFragment;", "Lid/dana/base/KeyBaseFragment;", "Lid/dana/onboarding/OnboardingActivity;", "Lid/dana/onboarding/verify/devicelimit/DeviceLimitErrorKey;", "Lid/dana/databinding/FragmentDeviceLimitErrorBinding;", "Lid/dana/onboarding/verify/devicelimit/DeviceLimitErrorContract$View;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onDestroy", "Lid/dana/domain/registration/model/HelpButtonOtpLimitDeviceModel;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/registration/model/HelpButtonOtpLimitDeviceModel;)V", "Lid/dana/core/ui/dialog/DanaLoadingDialogFragment;", "MyBillsEntityDataFactory", "Lkotlin/Lazy;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/di/component/DeviceLimitErrorComponent;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/di/component/DeviceLimitErrorComponent;", "PlaceComponentResult", "Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "lookAheadTest", "Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "getAuthRequestContext", "Ldagger/Lazy;", "Lid/dana/onboarding/verify/devicelimit/DeviceLimitErrorContract$Presenter;", "presenter", "Ldagger/Lazy;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceLimitErrorFragment extends KeyBaseFragment<OnboardingActivity, DeviceLimitErrorKey, FragmentDeviceLimitErrorBinding> implements DeviceLimitErrorContract.View {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private DeviceLimitErrorComponent PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private OnboardingNavigationManagerWithMenu getAuthRequestContext;
    @Inject
    public Lazy<DeviceLimitErrorContract.Presenter> presenter;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final kotlin.Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<DanaLoadingDialogFragment>() { // from class: id.dana.onboarding.verify.devicelimit.DeviceLimitErrorFragment$danaLoadingDialog$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialogFragment invoke() {
            DanaLoadingDialogFragment.Companion companion = DanaLoadingDialogFragment.INSTANCE;
            return DanaLoadingDialogFragment.Companion.BuiltInFictitiousFunctionClassFactory();
        }
    });

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_device_limit_error;
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentDeviceLimitErrorBinding authRequestContext = FragmentDeviceLimitErrorBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        DanaButtonSecondaryView danaButtonSecondaryView;
        DaggerDeviceLimitErrorComponent.Builder authRequestContext = DaggerDeviceLimitErrorComponent.getAuthRequestContext();
        authRequestContext.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        authRequestContext.MyBillsEntityDataFactory = (DeviceLimitErrorModule) Preconditions.getAuthRequestContext(new DeviceLimitErrorModule(this));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.MyBillsEntityDataFactory, DeviceLimitErrorModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getAuthRequestContext, ApplicationComponent.class);
        DaggerDeviceLimitErrorComponent.DeviceLimitErrorComponentImpl deviceLimitErrorComponentImpl = new DaggerDeviceLimitErrorComponent.DeviceLimitErrorComponentImpl(authRequestContext.MyBillsEntityDataFactory, authRequestContext.getAuthRequestContext, (byte) 0);
        Intrinsics.checkNotNullExpressionValue(deviceLimitErrorComponentImpl, "");
        this.PlaceComponentResult = deviceLimitErrorComponentImpl;
        deviceLimitErrorComponentImpl.getAuthRequestContext(this);
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            OnboardingNavigationManagerWithMenu navigationManager = ((OnboardingActivity) ((KeyBaseActivity) baseActivity)).getNavigationManager();
            this.getAuthRequestContext = navigationManager;
            Lazy<DeviceLimitErrorContract.Presenter> lazy = null;
            if (navigationManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                navigationManager = null;
            }
            BaseActivity baseActivity2 = getBaseActivity();
            if (baseActivity2 != null) {
                ((OnboardingActivity) ((KeyBaseActivity) baseActivity2)).getNavigationManager();
                navigationManager.KClassImpl$Data$declaredNonStaticMembers$2.setMenuLeftButton(R.drawable.btn_arrow_left);
                String string = getString(R.string.btn_back);
                Intrinsics.checkNotNullExpressionValue(string, "");
                Intrinsics.checkNotNullParameter(string, "");
                navigationManager.KClassImpl$Data$declaredNonStaticMembers$2.setMenuLeftContentDescription(string);
                navigationManager.KClassImpl$Data$declaredNonStaticMembers$2.setTitle(getString(R.string.device_limit_error_title_page));
                navigationManager.KClassImpl$Data$declaredNonStaticMembers$2.setToolbarTitleContentDescription(getString(R.string.lbl_title_limit_device));
                FragmentDeviceLimitErrorBinding fragmentDeviceLimitErrorBinding = (FragmentDeviceLimitErrorBinding) getBinding();
                if (fragmentDeviceLimitErrorBinding != null && (danaButtonSecondaryView = fragmentDeviceLimitErrorBinding.BuiltInFictitiousFunctionClassFactory) != null) {
                    danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.verify.devicelimit.DeviceLimitErrorFragment$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            DeviceLimitErrorFragment.PlaceComponentResult(DeviceLimitErrorFragment.this);
                        }
                    });
                }
                Lazy<DeviceLimitErrorContract.Presenter> lazy2 = this.presenter;
                if (lazy2 != null) {
                    lazy = lazy2;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                lazy.get().MyBillsEntityDataFactory();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type T of id.dana.base.KeyBaseFragment");
        }
        throw new NullPointerException("null cannot be cast to non-null type T of id.dana.base.KeyBaseFragment");
    }

    @Override // id.dana.onboarding.verify.devicelimit.DeviceLimitErrorContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final HelpButtonOtpLimitDeviceModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = this.getAuthRequestContext;
        if (onboardingNavigationManagerWithMenu == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onboardingNavigationManagerWithMenu = null;
        }
        if (p0.getEnable()) {
            onboardingNavigationManagerWithMenu.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButton(R.drawable.ic_help_rounded);
            onboardingNavigationManagerWithMenu.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButtonEnabled(true);
            onboardingNavigationManagerWithMenu.getAuthRequestContext = new MenuItemButtonListener() { // from class: id.dana.onboarding.verify.devicelimit.DeviceLimitErrorFragment$$ExternalSyntheticLambda1
                @Override // id.dana.base.MenuItemButtonListener
                public final void PlaceComponentResult() {
                    DeviceLimitErrorFragment.MyBillsEntityDataFactory(DeviceLimitErrorFragment.this, p0);
                }
            };
            String string = getString(R.string.icn_btn_help);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Intrinsics.checkNotNullParameter(string, "");
            onboardingNavigationManagerWithMenu.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButtonContentDescription(string);
            return;
        }
        onboardingNavigationManagerWithMenu.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButton((String) null);
        onboardingNavigationManagerWithMenu.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButtonEnabled(false);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/onboarding/verify/devicelimit/DeviceLimitErrorFragment$Companion;", "", "Lid/dana/onboarding/verify/devicelimit/DeviceLimitErrorFragment;", "MyBillsEntityDataFactory", "()Lid/dana/onboarding/verify/devicelimit/DeviceLimitErrorFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static DeviceLimitErrorFragment MyBillsEntityDataFactory() {
            return new DeviceLimitErrorFragment();
        }
    }

    public static /* synthetic */ void PlaceComponentResult(DeviceLimitErrorFragment deviceLimitErrorFragment) {
        Intrinsics.checkNotNullParameter(deviceLimitErrorFragment, "");
        BaseActivity baseActivity = deviceLimitErrorFragment.getBaseActivity();
        if (baseActivity == null) {
            throw new NullPointerException("null cannot be cast to non-null type T of id.dana.base.KeyBaseFragment");
        }
        ((OnboardingActivity) ((KeyBaseActivity) baseActivity)).getNavigationManager().getAuthRequestContext.goBack();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(final DeviceLimitErrorFragment deviceLimitErrorFragment, HelpButtonOtpLimitDeviceModel helpButtonOtpLimitDeviceModel) {
        Intrinsics.checkNotNullParameter(deviceLimitErrorFragment, "");
        Intrinsics.checkNotNullParameter(helpButtonOtpLimitDeviceModel, "");
        String url = helpButtonOtpLimitDeviceModel.getUrl();
        DanaLoadingDialogFragment danaLoadingDialogFragment = (DanaLoadingDialogFragment) deviceLimitErrorFragment.BuiltInFictitiousFunctionClassFactory.getValue();
        FragmentManager parentFragmentManager = deviceLimitErrorFragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        danaLoadingDialogFragment.show(parentFragmentManager, "FullDanaLoading");
        DanaH5.startContainerFullUrlWithoutTimeout(url, new DanaH5Listener() { // from class: id.dana.onboarding.verify.devicelimit.DeviceLimitErrorFragment$rightButtonClickListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
                DeviceLimitErrorFragment.KClassImpl$Data$declaredNonStaticMembers$2(DeviceLimitErrorFragment.this).dismissAllowingStateLoss();
            }
        });
    }

    public static final /* synthetic */ DanaLoadingDialogFragment KClassImpl$Data$declaredNonStaticMembers$2(DeviceLimitErrorFragment deviceLimitErrorFragment) {
        return (DanaLoadingDialogFragment) deviceLimitErrorFragment.BuiltInFictitiousFunctionClassFactory.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        Lazy<DeviceLimitErrorContract.Presenter> lazy = this.presenter;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        lazy.get().onDestroy();
        super.onDestroy();
    }
}

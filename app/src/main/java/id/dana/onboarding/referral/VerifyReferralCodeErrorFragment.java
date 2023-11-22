package id.dana.onboarding.referral;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.KeyBaseActivity;
import id.dana.base.KeyBaseFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.databinding.ActivityReferralLocationErrorPageBinding;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.OnboardingNavigationManagerWithMenu;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/onboarding/referral/VerifyReferralCodeErrorFragment;", "Lid/dana/base/KeyBaseFragment;", "Lid/dana/onboarding/OnboardingActivity;", "Lid/dana/onboarding/referral/VerifyReferralCodeErrorKey;", "Lid/dana/databinding/ActivityReferralLocationErrorPageBinding;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "PlaceComponentResult", "Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "getAuthRequestContext", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyReferralCodeErrorFragment extends KeyBaseFragment<OnboardingActivity, VerifyReferralCodeErrorKey, ActivityReferralLocationErrorPageBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private OnboardingNavigationManagerWithMenu getAuthRequestContext;

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.MyBillsEntityDataFactory;
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

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.activity_referral_location_error_page;
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ActivityReferralLocationErrorPageBinding PlaceComponentResult = ActivityReferralLocationErrorPageBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/onboarding/referral/VerifyReferralCodeErrorFragment$Companion;", "", "Lid/dana/onboarding/referral/VerifyReferralCodeErrorFragment;", "MyBillsEntityDataFactory", "()Lid/dana/onboarding/referral/VerifyReferralCodeErrorFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static VerifyReferralCodeErrorFragment MyBillsEntityDataFactory() {
            return new VerifyReferralCodeErrorFragment();
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(VerifyReferralCodeErrorFragment verifyReferralCodeErrorFragment) {
        Intrinsics.checkNotNullParameter(verifyReferralCodeErrorFragment, "");
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = verifyReferralCodeErrorFragment.getAuthRequestContext;
        if (onboardingNavigationManagerWithMenu == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onboardingNavigationManagerWithMenu = null;
        }
        onboardingNavigationManagerWithMenu.getAuthRequestContext.goBack();
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        DanaButtonPrimaryView danaButtonPrimaryView;
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            OnboardingNavigationManagerWithMenu navigationManager = ((OnboardingActivity) ((KeyBaseActivity) baseActivity)).getNavigationManager();
            this.getAuthRequestContext = navigationManager;
            if (navigationManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                navigationManager = null;
            }
            BaseActivity baseActivity2 = getBaseActivity();
            if (baseActivity2 != null) {
                ((OnboardingActivity) ((KeyBaseActivity) baseActivity2)).getNavigationManager();
                navigationManager.KClassImpl$Data$declaredNonStaticMembers$2.setMenuLeftButton(R.drawable.btn_arrow_left);
                navigationManager.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButtonEnabled(false);
                navigationManager.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButton(getString(R.string.hide_right_btn));
                ActivityReferralLocationErrorPageBinding activityReferralLocationErrorPageBinding = (ActivityReferralLocationErrorPageBinding) getBinding();
                if (activityReferralLocationErrorPageBinding == null || (danaButtonPrimaryView = activityReferralLocationErrorPageBinding.PlaceComponentResult) == null) {
                    return;
                }
                danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.referral.VerifyReferralCodeErrorFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VerifyReferralCodeErrorFragment.BuiltInFictitiousFunctionClassFactory(VerifyReferralCodeErrorFragment.this);
                    }
                });
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type T of id.dana.base.KeyBaseFragment");
        }
        throw new NullPointerException("null cannot be cast to non-null type T of id.dana.base.KeyBaseFragment");
    }
}

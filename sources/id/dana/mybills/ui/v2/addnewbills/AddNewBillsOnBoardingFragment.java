package id.dana.mybills.ui.v2.addnewbills;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentKt;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.zoloz.rpc.encryption.EncryptionProxyInvocationHandler;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.mybills.R;
import id.dana.mybills.databinding.FragmentAddNewBillsOnBoardingBinding;
import id.dana.mybills.ui.adapter.AddNewBillsOnBoardingAdapter;
import id.dana.mybills.ui.model.MyBillsOnboardingContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000b"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsOnBoardingFragment;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/mybills/databinding/FragmentAddNewBillsOnBoardingBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "onStart", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class AddNewBillsOnBoardingFragment extends BaseViewBindingBottomSheetDialogFragment<FragmentAddNewBillsOnBoardingBinding> {
    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.48f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ FragmentAddNewBillsOnBoardingBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentAddNewBillsOnBoardingBinding MyBillsEntityDataFactory = FragmentAddNewBillsOnBoardingBinding.MyBillsEntityDataFactory(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FragmentAddNewBillsOnBoardingBinding fragmentAddNewBillsOnBoardingBinding = (FragmentAddNewBillsOnBoardingBinding) vb;
            ViewPager2 viewPager2 = fragmentAddNewBillsOnBoardingBinding.getErrorConfigVersion;
            int i = R.drawable.res_0x7f08091d_networkuserentitydata_externalsyntheticlambda1;
            String string = getString(R.string.add_new_bills_first_onboarding_subtitle);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String string2 = getString(R.string.add_new_bills_first_onboarding_description);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            int i2 = R.drawable.res_0x7f080b77_networkuserentitydata_externalsyntheticlambda3;
            String string3 = getString(R.string.add_new_bills_second_onboarding_subtitle);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            String string4 = getString(R.string.add_new_bills_second_onboarding_description);
            Intrinsics.checkNotNullExpressionValue(string4, "");
            int i3 = R.drawable.res_0x7f080bd6_networkuserentitydata_externalsyntheticlambda6;
            String string5 = getString(R.string.add_new_bills_third_onboarding_subtitle);
            Intrinsics.checkNotNullExpressionValue(string5, "");
            String string6 = getString(R.string.add_new_bills_third_onboarding_description);
            Intrinsics.checkNotNullExpressionValue(string6, "");
            List mutableListOf = CollectionsKt.mutableListOf(new MyBillsOnboardingContent(i, string, string2), new MyBillsOnboardingContent(i2, string3, string4), new MyBillsOnboardingContent(i3, string5, string6));
            ViewPager2 viewPager22 = fragmentAddNewBillsOnBoardingBinding.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(viewPager22, "");
            viewPager2.setAdapter(new AddNewBillsOnBoardingAdapter(mutableListOf, new AddNewBillsOnBoardingFragment$setupOnBoarding$1$1(viewPager22)));
            TabLayout tabLayout = fragmentAddNewBillsOnBoardingBinding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(tabLayout, "");
            ViewPager2 viewPager23 = fragmentAddNewBillsOnBoardingBinding.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(viewPager23, "");
            final AddNewBillsOnBoardingFragment$attachViewPager$1 addNewBillsOnBoardingFragment$attachViewPager$1 = new Function2<TabLayout.Tab, Integer, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsOnBoardingFragment$attachViewPager$1
                public final void invoke(TabLayout.Tab tab, int i4) {
                    Intrinsics.checkNotNullParameter(tab, "");
                }

                @Override // kotlin.jvm.functions.Function2
                public final /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
                    invoke(tab, num.intValue());
                    return Unit.INSTANCE;
                }
            };
            Intrinsics.checkNotNullParameter(tabLayout, "");
            Intrinsics.checkNotNullParameter(viewPager23, "");
            Intrinsics.checkNotNullParameter(addNewBillsOnBoardingFragment$attachViewPager$1, "");
            new TabLayoutMediator(tabLayout, viewPager23, new TabLayoutMediator.TabConfigurationStrategy() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsOnBoardingFragment$$ExternalSyntheticLambda0
                @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
                public final void onConfigureTab(TabLayout.Tab tab, int i4) {
                    AddNewBillsOnBoardingFragment.PlaceComponentResult(Function2.this, tab, i4);
                }
            }).attach();
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                ((FragmentAddNewBillsOnBoardingBinding) vb2).BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsOnBoardingFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AddNewBillsOnBoardingFragment.KClassImpl$Data$declaredNonStaticMembers$2(AddNewBillsOnBoardingFragment.this);
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        Dialog dialog = getDialog();
        if (dialog != null) {
            a_(PlaceComponentResult(dialog));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext != null) {
                getAuthRequestContext.post(new BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(getAuthRequestContext, this));
            }
            MyBillsEntityDataFactory(dialog);
        }
    }

    public static /* synthetic */ void PlaceComponentResult(Function2 function2, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(function2, "");
        Intrinsics.checkNotNullParameter(tab, "");
        function2.invoke(tab, Integer.valueOf(i));
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(AddNewBillsOnBoardingFragment addNewBillsOnBoardingFragment) {
        Intrinsics.checkNotNullParameter(addNewBillsOnBoardingFragment, "");
        FragmentKt.KClassImpl$Data$declaredNonStaticMembers$2(addNewBillsOnBoardingFragment, EncryptionProxyInvocationHandler.SUCCESS_RET_CODE, BundleKt.PlaceComponentResult(TuplesKt.to("on_success_onboard", Boolean.TRUE)));
        addNewBillsOnBoardingFragment.dismiss();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((FragmentAddNewBillsOnBoardingBinding) vb).MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}

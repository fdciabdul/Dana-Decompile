package id.dana.usereducation;

import android.view.View;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes9.dex */
public class BottomSheetOnBoardingActivity_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private BottomSheetOnBoardingActivity KClassImpl$Data$declaredNonStaticMembers$2;
    private View MyBillsEntityDataFactory;

    public BottomSheetOnBoardingActivity_ViewBinding(final BottomSheetOnBoardingActivity bottomSheetOnBoardingActivity, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bottomSheetOnBoardingActivity;
        bottomSheetOnBoardingActivity.tvTitleOnBoarding = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title_on_boarding, "field 'tvTitleOnBoarding'", TextView.class);
        bottomSheetOnBoardingActivity.viewPager = (ViewPager) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_pager, "field 'viewPager'", ViewPager.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_next_on_boarding, "field 'btnNext' and method 'onButtonNextClicked'");
        bottomSheetOnBoardingActivity.btnNext = (DanaButtonPrimaryView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.btn_next_on_boarding, "field 'btnNext'", DanaButtonPrimaryView.class);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.usereducation.BottomSheetOnBoardingActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                bottomSheetOnBoardingActivity.onButtonNextClicked();
            }
        });
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_previous_on_boarding, "field 'btnPrevious' and method 'onButtonPreviousClicked'");
        bottomSheetOnBoardingActivity.btnPrevious = (DanaButtonSecondaryView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2, R.id.btn_previous_on_boarding, "field 'btnPrevious'", DanaButtonSecondaryView.class);
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.usereducation.BottomSheetOnBoardingActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                bottomSheetOnBoardingActivity.onButtonPreviousClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        BottomSheetOnBoardingActivity bottomSheetOnBoardingActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (bottomSheetOnBoardingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        bottomSheetOnBoardingActivity.tvTitleOnBoarding = null;
        bottomSheetOnBoardingActivity.viewPager = null;
        bottomSheetOnBoardingActivity.btnNext = null;
        bottomSheetOnBoardingActivity.btnPrevious = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
    }
}

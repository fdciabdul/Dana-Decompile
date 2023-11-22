package id.dana.nearbyme.homeshopping.tutorial;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.fullstory.instrumentation.InstrumentInjector;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.di.component.ApplicationComponent;
import id.dana.extension.ContextExtKt;
import id.dana.nearbyme.di.component.DaggerNearbyTrackerComponent;
import id.dana.nearbyme.di.module.NearbyTrackerModule;
import id.dana.nearbyme.homeshopping.model.HomeShoppingModel;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.util.AndroidComponentUtilsKt;
import id.dana.utils.DanaPhoneNumberUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\u0012X\u0087\"¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/nearbyme/homeshopping/tutorial/HomeShoppingTutorialFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "p0", "", "onActivityCreated", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "p1", "p2", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lid/dana/nearbyme/homeshopping/model/HomeShoppingModel;", "PlaceComponentResult", "Lid/dana/nearbyme/homeshopping/model/HomeShoppingModel;", "getAuthRequestContext", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "nearbyAnalyticTracker", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HomeShoppingTutorialFragment extends Fragment {
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private HomeShoppingModel getAuthRequestContext;
    @Inject
    public NearbyAnalyticTracker nearbyAnalyticTracker;

    private View KClassImpl$Data$declaredNonStaticMembers$2(int i) {
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

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0.inflate(R.layout.fragment_home_shopping_tutorial, p1, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle p0) {
        HomeShoppingModel homeShoppingModel;
        super.onActivityCreated(p0);
        DanaApplication BuiltInFictitiousFunctionClassFactory = AndroidComponentUtilsKt.BuiltInFictitiousFunctionClassFactory(this);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            DaggerNearbyTrackerComponent.Builder BuiltInFictitiousFunctionClassFactory2 = DaggerNearbyTrackerComponent.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory.getApplicationComponent());
            BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = (NearbyTrackerModule) Preconditions.getAuthRequestContext(new NearbyTrackerModule());
            BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext().PlaceComponentResult(this);
        }
        Bundle arguments = getArguments();
        if (arguments != null && (homeShoppingModel = (HomeShoppingModel) arguments.getParcelable("HOME_SHOPPING_TUTORIAL_DATA_KEY")) != null) {
            this.getAuthRequestContext = homeShoppingModel;
            Unit unit = Unit.INSTANCE;
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.SyncContactMixpanelTracker_Factory);
        if (appCompatTextView != null) {
            HomeShoppingModel homeShoppingModel2 = this.getAuthRequestContext;
            if (homeShoppingModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                homeShoppingModel2 = null;
            }
            appCompatTextView.setText(DanaPhoneNumberUtil.KClassImpl$Data$declaredNonStaticMembers$2(homeShoppingModel2.PlaceComponentResult));
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.ChangePayMethodPresenter_Factory);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.homeshopping.tutorial.HomeShoppingTutorialFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeShoppingTutorialFragment.BuiltInFictitiousFunctionClassFactory(HomeShoppingTutorialFragment.this);
                }
            });
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.iv_toggle);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.homeshopping.tutorial.HomeShoppingTutorialFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeShoppingTutorialFragment.getAuthRequestContext(HomeShoppingTutorialFragment.this);
                }
            });
        }
        AppCompatButton appCompatButton = (AppCompatButton) KClassImpl$Data$declaredNonStaticMembers$2(R.id.btn_order);
        if (appCompatButton != null) {
            appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.homeshopping.tutorial.HomeShoppingTutorialFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeShoppingTutorialFragment.PlaceComponentResult(HomeShoppingTutorialFragment.this);
                }
            });
        }
        final View view = getView();
        if (view != null) {
            view.post(new Runnable() { // from class: id.dana.nearbyme.homeshopping.tutorial.HomeShoppingTutorialFragment$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    HomeShoppingTutorialFragment.KClassImpl$Data$declaredNonStaticMembers$2(view);
                }
            });
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(HomeShoppingTutorialFragment homeShoppingTutorialFragment) {
        Intrinsics.checkNotNullParameter(homeShoppingTutorialFragment, "");
        NestedScrollView nestedScrollView = (NestedScrollView) homeShoppingTutorialFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.nsv_tutorial);
        if (nestedScrollView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) homeShoppingTutorialFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.tv_pay_tutorial);
            nestedScrollView.smoothScrollTo(0, appCompatTextView != null ? appCompatTextView.getTop() : 0, 300);
        }
    }

    public static /* synthetic */ void getAuthRequestContext(final HomeShoppingTutorialFragment homeShoppingTutorialFragment) {
        Intrinsics.checkNotNullParameter(homeShoppingTutorialFragment, "");
        ConstraintLayout constraintLayout = (ConstraintLayout) homeShoppingTutorialFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.cl_pay_steps);
        Unit unit = null;
        if (constraintLayout != null) {
            Integer valueOf = Integer.valueOf(constraintLayout.getVisibility());
            if (!(valueOf.intValue() == 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                NestedScrollView nestedScrollView = (NestedScrollView) homeShoppingTutorialFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.nsv_tutorial);
                if (nestedScrollView != null) {
                    nestedScrollView.smoothScrollTo(0, 0, 300);
                }
                AppCompatImageView appCompatImageView = (AppCompatImageView) homeShoppingTutorialFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.iv_toggle);
                if (appCompatImageView != null) {
                    if (appCompatImageView instanceof ImageView) {
                        InstrumentInjector.Resources_setImageResource(appCompatImageView, R.drawable.ic_down_chevron);
                    } else {
                        appCompatImageView.setImageResource(R.drawable.ic_down_chevron);
                    }
                }
                ConstraintLayout constraintLayout2 = (ConstraintLayout) homeShoppingTutorialFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.cl_pay_steps);
                if (constraintLayout2 != null) {
                    constraintLayout2.postDelayed(new Runnable() { // from class: id.dana.nearbyme.homeshopping.tutorial.HomeShoppingTutorialFragment$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            HomeShoppingTutorialFragment.MyBillsEntityDataFactory(HomeShoppingTutorialFragment.this);
                        }
                    }, 300L);
                }
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) homeShoppingTutorialFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.iv_toggle);
            if (appCompatImageView2 != null) {
                if (appCompatImageView2 instanceof ImageView) {
                    InstrumentInjector.Resources_setImageResource(appCompatImageView2, R.drawable.ic_up_chevron);
                } else {
                    appCompatImageView2.setImageResource(R.drawable.ic_up_chevron);
                }
            }
            ConstraintLayout constraintLayout3 = (ConstraintLayout) homeShoppingTutorialFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.cl_pay_steps);
            if (constraintLayout3 != null) {
                constraintLayout3.setVisibility(0);
            }
            ConstraintLayout constraintLayout4 = (ConstraintLayout) homeShoppingTutorialFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.cl_pay_steps);
            if (constraintLayout4 != null) {
                constraintLayout4.post(new Runnable() { // from class: id.dana.nearbyme.homeshopping.tutorial.HomeShoppingTutorialFragment$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeShoppingTutorialFragment.KClassImpl$Data$declaredNonStaticMembers$2(HomeShoppingTutorialFragment.this);
                    }
                });
            }
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(HomeShoppingTutorialFragment homeShoppingTutorialFragment) {
        Intrinsics.checkNotNullParameter(homeShoppingTutorialFragment, "");
        ConstraintLayout constraintLayout = (ConstraintLayout) homeShoppingTutorialFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.cl_pay_steps);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(HomeShoppingTutorialFragment homeShoppingTutorialFragment) {
        Context context;
        Intrinsics.checkNotNullParameter(homeShoppingTutorialFragment, "");
        FragmentActivity activity = homeShoppingTutorialFragment.getActivity();
        if (activity == null || activity.getSupportFragmentManager() == null || (context = homeShoppingTutorialFragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(context);
        builder.DatabaseTableConfigUtil = R.drawable.ic_qris;
        builder.SubSequence = homeShoppingTutorialFragment.getString(R.string.home_shopping_about_qris_title);
        builder.GetContactSyncConfig = homeShoppingTutorialFragment.getString(R.string.home_shopping_about_qris_body);
        builder.moveToNextValue = 0L;
        builder.BuiltInFictitiousFunctionClassFactory(homeShoppingTutorialFragment.getString(R.string.home_shopping_about_qris_button), new Function1<View, Unit>() { // from class: id.dana.nearbyme.homeshopping.tutorial.HomeShoppingTutorialFragment$showAboutDialog$1$1$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        }).BuiltInFictitiousFunctionClassFactory().show();
        Unit unit = Unit.INSTANCE;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        view.getLayoutParams().height = view.getMeasuredHeight();
    }

    public static /* synthetic */ void PlaceComponentResult(HomeShoppingTutorialFragment homeShoppingTutorialFragment) {
        Intrinsics.checkNotNullParameter(homeShoppingTutorialFragment, "");
        NearbyAnalyticTracker nearbyAnalyticTracker = homeShoppingTutorialFragment.nearbyAnalyticTracker;
        HomeShoppingModel homeShoppingModel = null;
        if (nearbyAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            nearbyAnalyticTracker = null;
        }
        HomeShoppingModel homeShoppingModel2 = homeShoppingTutorialFragment.getAuthRequestContext;
        if (homeShoppingModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            homeShoppingModel2 = null;
        }
        String str = homeShoppingModel2.MyBillsEntityDataFactory;
        HomeShoppingModel homeShoppingModel3 = homeShoppingTutorialFragment.getAuthRequestContext;
        if (homeShoppingModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            homeShoppingModel3 = null;
        }
        String str2 = homeShoppingModel3.BuiltInFictitiousFunctionClassFactory;
        HomeShoppingModel homeShoppingModel4 = homeShoppingTutorialFragment.getAuthRequestContext;
        if (homeShoppingModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            homeShoppingModel4 = null;
        }
        nearbyAnalyticTracker.getAuthRequestContext(str, str2, homeShoppingModel4.getErrorConfigVersion);
        Context context = homeShoppingTutorialFragment.getContext();
        if (context != null) {
            HomeShoppingModel homeShoppingModel5 = homeShoppingTutorialFragment.getAuthRequestContext;
            if (homeShoppingModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                homeShoppingModel = homeShoppingModel5;
            }
            ContextExtKt.KClassImpl$Data$declaredNonStaticMembers$2(context, homeShoppingModel.PlaceComponentResult, "");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory.clear();
    }
}

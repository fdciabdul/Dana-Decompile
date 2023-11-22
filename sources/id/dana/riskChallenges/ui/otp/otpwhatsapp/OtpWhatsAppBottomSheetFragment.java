package id.dana.riskChallenges.ui.otp.otpwhatsapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcherKt;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.data.constant.DanaUrl;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentBottomSheetOtpBinding;
import id.dana.riskChallenges.databinding.LayoutOtpVerifyBinding;
import id.dana.riskChallenges.databinding.ViewToolbarBottomSheetBinding;
import id.dana.riskChallenges.ui.otp.viewmodel.OtpChallengeViewModel;
import id.dana.riskChallenges.ui.util.model.TrackerModel;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001b\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0013\u0010\u001a\u001a\u00020\u0018X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0019"}, d2 = {"Lid/dana/riskChallenges/ui/otp/otpwhatsapp/OtpWhatsAppBottomSheetFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/os/Bundle;", "p0", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "p1", "p2", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onDestroyView", "()V", "onStart", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/databinding/FragmentBottomSheetOtpBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/databinding/FragmentBottomSheetOtpBinding;", "Lid/dana/riskChallenges/ui/otp/otpwhatsapp/OtpWhatsappSharedLogicHandler;", "Lkotlin/Lazy;", "BuiltInFictitiousFunctionClassFactory", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OtpWhatsAppBottomSheetFragment extends BottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentBottomSheetOtpBinding KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<OtpWhatsappSharedLogicHandler>() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsAppBottomSheetFragment$otpWhatsAppSharedLogicHandler$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final OtpWhatsappSharedLogicHandler invoke() {
            FragmentBottomSheetOtpBinding fragmentBottomSheetOtpBinding;
            FragmentBottomSheetOtpBinding fragmentBottomSheetOtpBinding2;
            OtpWhatsAppBottomSheetFragment otpWhatsAppBottomSheetFragment = OtpWhatsAppBottomSheetFragment.this;
            OtpWhatsAppBottomSheetFragment otpWhatsAppBottomSheetFragment2 = otpWhatsAppBottomSheetFragment;
            fragmentBottomSheetOtpBinding = otpWhatsAppBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2;
            LayoutOtpVerifyBinding layoutOtpVerifyBinding = fragmentBottomSheetOtpBinding != null ? fragmentBottomSheetOtpBinding.BuiltInFictitiousFunctionClassFactory : null;
            fragmentBottomSheetOtpBinding2 = OtpWhatsAppBottomSheetFragment.this.KClassImpl$Data$declaredNonStaticMembers$2;
            return new OtpWhatsappSharedLogicHandler(otpWhatsAppBottomSheetFragment2, layoutOtpVerifyBinding, fragmentBottomSheetOtpBinding2 != null ? fragmentBottomSheetOtpBinding2.PlaceComponentResult : null);
        }
    });

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        FragmentBottomSheetOtpBinding MyBillsEntityDataFactory = FragmentBottomSheetOtpBinding.MyBillsEntityDataFactory(p0, p1);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory;
        return MyBillsEntityDataFactory.getAuthRequestContext;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle p0) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), R.style.MyBillsEntityDataFactory);
        if (Build.VERSION.SDK_INT >= 30) {
            Window window = bottomSheetDialog.getWindow();
            if (window != null) {
                window.setDecorFitsSystemWindows(true);
            }
        } else {
            Window window2 = bottomSheetDialog.getWindow();
            if (window2 != null) {
                window2.setSoftInputMode(16);
            }
        }
        bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsAppBottomSheetFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                OtpWhatsAppBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(dialogInterface);
            }
        });
        OnBackPressedDispatcherKt.PlaceComponentResult(bottomSheetDialog.getOnBackPressedDispatcher(), new Function1<OnBackPressedCallback, Unit>() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsAppBottomSheetFragment$onCreateDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
                invoke2(onBackPressedCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnBackPressedCallback onBackPressedCallback) {
                Intrinsics.checkNotNullParameter(onBackPressedCallback, "");
                ((OtpChallengeViewModel) OtpWhatsAppBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(OtpWhatsAppBottomSheetFragment.this).scheduleImpl.getValue()).moveToNextValue();
                OtpWhatsAppBottomSheetFragment.this.MyBillsEntityDataFactory();
                OtpWhatsAppBottomSheetFragment.this.dismissNow();
            }
        });
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        UiComponent uiComponent;
        ViewToolbarBottomSheetBinding viewToolbarBottomSheetBinding;
        AppCompatImageView appCompatImageView;
        ViewToolbarBottomSheetBinding viewToolbarBottomSheetBinding2;
        ViewToolbarBottomSheetBinding viewToolbarBottomSheetBinding3;
        AppCompatImageView appCompatImageView2;
        ViewToolbarBottomSheetBinding viewToolbarBottomSheetBinding4;
        AppCompatImageView appCompatImageView3;
        ViewToolbarBottomSheetBinding viewToolbarBottomSheetBinding5;
        AppCompatImageView appCompatImageView4;
        ViewToolbarBottomSheetBinding viewToolbarBottomSheetBinding6;
        ViewToolbarBottomSheetBinding viewToolbarBottomSheetBinding7;
        CoordinatorLayout coordinatorLayout;
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        getLifecycle().BuiltInFictitiousFunctionClassFactory((OtpWhatsappSharedLogicHandler) this.BuiltInFictitiousFunctionClassFactory.getValue());
        Bundle arguments = getArguments();
        AppCompatImageView appCompatImageView5 = null;
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) arguments.getParcelable("KEY_UI_COMPONENT", UiComponent.class);
            } else {
                Parcelable parcelable2 = arguments.getParcelable("KEY_UI_COMPONENT");
                if (!(parcelable2 instanceof UiComponent)) {
                    parcelable2 = null;
                }
                parcelable = (UiComponent) parcelable2;
            }
            uiComponent = (UiComponent) parcelable;
        } else {
            uiComponent = null;
        }
        if (uiComponent != null) {
            FragmentBottomSheetOtpBinding fragmentBottomSheetOtpBinding = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (fragmentBottomSheetOtpBinding != null && (coordinatorLayout = fragmentBottomSheetOtpBinding.PlaceComponentResult) != null) {
                coordinatorLayout.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), uiComponent.MyBillsEntityDataFactory));
            }
            FragmentBottomSheetOtpBinding fragmentBottomSheetOtpBinding2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            TextView textView = (fragmentBottomSheetOtpBinding2 == null || (viewToolbarBottomSheetBinding7 = fragmentBottomSheetOtpBinding2.MyBillsEntityDataFactory) == null) ? null : viewToolbarBottomSheetBinding7.KClassImpl$Data$declaredNonStaticMembers$2;
            if (textView != null) {
                textView.setText(getString(uiComponent.BuiltInFictitiousFunctionClassFactory));
            }
        }
        FragmentBottomSheetOtpBinding fragmentBottomSheetOtpBinding3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        AppCompatImageView appCompatImageView6 = (fragmentBottomSheetOtpBinding3 == null || (viewToolbarBottomSheetBinding6 = fragmentBottomSheetOtpBinding3.MyBillsEntityDataFactory) == null) ? null : viewToolbarBottomSheetBinding6.getAuthRequestContext;
        if (appCompatImageView6 != null) {
            appCompatImageView6.setVisibility(0);
        }
        FragmentBottomSheetOtpBinding fragmentBottomSheetOtpBinding4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (fragmentBottomSheetOtpBinding4 != null && (viewToolbarBottomSheetBinding5 = fragmentBottomSheetOtpBinding4.MyBillsEntityDataFactory) != null && (appCompatImageView4 = viewToolbarBottomSheetBinding5.getAuthRequestContext) != null) {
            int i = R.drawable.getAuthRequestContext;
            if (appCompatImageView4 instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView4, i);
            } else {
                appCompatImageView4.setImageResource(i);
            }
        }
        FragmentBottomSheetOtpBinding fragmentBottomSheetOtpBinding5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (fragmentBottomSheetOtpBinding5 != null && (viewToolbarBottomSheetBinding4 = fragmentBottomSheetOtpBinding5.MyBillsEntityDataFactory) != null && (appCompatImageView3 = viewToolbarBottomSheetBinding4.getAuthRequestContext) != null) {
            appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsAppBottomSheetFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OtpWhatsAppBottomSheetFragment.MyBillsEntityDataFactory(OtpWhatsAppBottomSheetFragment.this);
                }
            });
        }
        FragmentBottomSheetOtpBinding fragmentBottomSheetOtpBinding6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (fragmentBottomSheetOtpBinding6 != null && (viewToolbarBottomSheetBinding3 = fragmentBottomSheetOtpBinding6.MyBillsEntityDataFactory) != null && (appCompatImageView2 = viewToolbarBottomSheetBinding3.BuiltInFictitiousFunctionClassFactory) != null) {
            int i2 = R.drawable.ic_help;
            if (appCompatImageView2 instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView2, i2);
            } else {
                appCompatImageView2.setImageResource(i2);
            }
        }
        FragmentBottomSheetOtpBinding fragmentBottomSheetOtpBinding7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (fragmentBottomSheetOtpBinding7 != null && (viewToolbarBottomSheetBinding2 = fragmentBottomSheetOtpBinding7.MyBillsEntityDataFactory) != null) {
            appCompatImageView5 = viewToolbarBottomSheetBinding2.BuiltInFictitiousFunctionClassFactory;
        }
        if (appCompatImageView5 != null) {
            appCompatImageView5.setVisibility(0);
        }
        FragmentBottomSheetOtpBinding fragmentBottomSheetOtpBinding8 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (fragmentBottomSheetOtpBinding8 == null || (viewToolbarBottomSheetBinding = fragmentBottomSheetOtpBinding8.MyBillsEntityDataFactory) == null || (appCompatImageView = viewToolbarBottomSheetBinding.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsAppBottomSheetFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OtpWhatsAppBottomSheetFragment.getAuthRequestContext(OtpWhatsAppBottomSheetFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory() {
        if (isAdded()) {
            getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0)));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2((OtpWhatsappSharedLogicHandler) this.BuiltInFictitiousFunctionClassFactory.getValue());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        CoordinatorLayout coordinatorLayout;
        super.onStart();
        FragmentBottomSheetOtpBinding fragmentBottomSheetOtpBinding = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (fragmentBottomSheetOtpBinding == null || (coordinatorLayout = fragmentBottomSheetOtpBinding.getAuthRequestContext) == null) {
            return;
        }
        coordinatorLayout.postDelayed(new Runnable() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsAppBottomSheetFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                OtpWhatsAppBottomSheetFragment.PlaceComponentResult(OtpWhatsAppBottomSheetFragment.this);
            }
        }, 700L);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016Js\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/riskChallenges/ui/otp/otpwhatsapp/OtpWhatsAppBottomSheetFragment$Companion;", "", "", "p0", "p1", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "p2", "p3", "p4", "p5", "p6", "", "p7", "p8", "p9", "p10", "Lid/dana/riskChallenges/ui/util/model/TrackerModel;", "p11", "Lid/dana/riskChallenges/ui/otp/otpwhatsapp/OtpWhatsAppBottomSheetFragment;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/model/TrackerModel;)Lid/dana/riskChallenges/ui/otp/otpwhatsapp/OtpWhatsAppBottomSheetFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static OtpWhatsAppBottomSheetFragment BuiltInFictitiousFunctionClassFactory(String p0, String p1, UiComponent p2, String p3, String p4, String p5, String p6, boolean p7, String p8, String p9, String p10, TrackerModel p11) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intrinsics.checkNotNullParameter(p4, "");
            Intrinsics.checkNotNullParameter(p5, "");
            Intrinsics.checkNotNullParameter(p6, "");
            Intrinsics.checkNotNullParameter(p8, "");
            Intrinsics.checkNotNullParameter(p9, "");
            Intrinsics.checkNotNullParameter(p11, "");
            OtpWhatsAppBottomSheetFragment otpWhatsAppBottomSheetFragment = new OtpWhatsAppBottomSheetFragment();
            otpWhatsAppBottomSheetFragment.setArguments(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_PHONE_NUMBER", p0), TuplesKt.to("KEY_UI_COMPONENT", p2), TuplesKt.to("KEY_SECURITY_ID", p1), TuplesKt.to("KEY_USE_CASE_STRATEGY", p3), TuplesKt.to("KEY_OTP_CHANNEL", p4), TuplesKt.to("KEY_SERVICE_CODE", p5), TuplesKt.to("KEY_MERCHANT_ID", p6), TuplesKt.to("KEY_IS_SEND_MONEY", Boolean.valueOf(p7)), TuplesKt.to("KEY_SCENARIO", p8), TuplesKt.to("KEY_FALLBACK_VERIFICATION_METHOD", p9), TuplesKt.to("KEY_RISK_TOKEN", p10), TuplesKt.to("KEY_TRACKER_MODEL", p11)));
            return otpWhatsAppBottomSheetFragment;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DialogInterface dialogInterface) {
        BottomSheetDialog bottomSheetDialog = dialogInterface instanceof BottomSheetDialog ? (BottomSheetDialog) dialogInterface : null;
        if (bottomSheetDialog != null) {
            View findViewById = bottomSheetDialog.findViewById(R.id.GetContactSyncConfig);
            FrameLayout frameLayout = findViewById instanceof FrameLayout ? (FrameLayout) findViewById : null;
            if (frameLayout != null) {
                final BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                Intrinsics.checkNotNullExpressionValue(from, "");
                from.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
                from.setState(3);
                from.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsAppBottomSheetFragment$onCreateDialog$1$1$1$1
                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public final void onSlide(View p0, float p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                    }

                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public final void onStateChanged(View p0, int p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 == 1) {
                            from.setState(3);
                        }
                    }
                });
            }
        }
    }

    public static /* synthetic */ void getAuthRequestContext(OtpWhatsAppBottomSheetFragment otpWhatsAppBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(otpWhatsAppBottomSheetFragment, "");
        ((OtpWhatsappSharedLogicHandler) otpWhatsAppBottomSheetFragment.BuiltInFictitiousFunctionClassFactory.getValue()).PlaceComponentResult(DanaUrl.DANA_OTP_ARTICLE);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(OtpWhatsAppBottomSheetFragment otpWhatsAppBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(otpWhatsAppBottomSheetFragment, "");
        ((OtpChallengeViewModel) ((OtpWhatsappSharedLogicHandler) otpWhatsAppBottomSheetFragment.BuiltInFictitiousFunctionClassFactory.getValue()).scheduleImpl.getValue()).moveToNextValue();
        otpWhatsAppBottomSheetFragment.MyBillsEntityDataFactory();
        otpWhatsAppBottomSheetFragment.dismissNow();
    }

    public static /* synthetic */ void PlaceComponentResult(OtpWhatsAppBottomSheetFragment otpWhatsAppBottomSheetFragment) {
        CoordinatorLayout coordinatorLayout;
        CoordinatorLayout coordinatorLayout2;
        Intrinsics.checkNotNullParameter(otpWhatsAppBottomSheetFragment, "");
        FragmentBottomSheetOtpBinding fragmentBottomSheetOtpBinding = otpWhatsAppBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        Integer num = null;
        ViewGroup.LayoutParams layoutParams = (fragmentBottomSheetOtpBinding == null || (coordinatorLayout2 = fragmentBottomSheetOtpBinding.getAuthRequestContext) == null) ? null : coordinatorLayout2.getLayoutParams();
        if (layoutParams != null) {
            FragmentBottomSheetOtpBinding fragmentBottomSheetOtpBinding2 = otpWhatsAppBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2;
            if (fragmentBottomSheetOtpBinding2 != null && (coordinatorLayout = fragmentBottomSheetOtpBinding2.getAuthRequestContext) != null) {
                num = Integer.valueOf(coordinatorLayout.getHeight() + ViewExtKt.getAuthRequestContext(200.0f));
            }
            layoutParams.height = num.intValue();
        }
    }

    public static final /* synthetic */ OtpWhatsappSharedLogicHandler KClassImpl$Data$declaredNonStaticMembers$2(OtpWhatsAppBottomSheetFragment otpWhatsAppBottomSheetFragment) {
        return (OtpWhatsappSharedLogicHandler) otpWhatsAppBottomSheetFragment.BuiltInFictitiousFunctionClassFactory.getValue();
    }
}

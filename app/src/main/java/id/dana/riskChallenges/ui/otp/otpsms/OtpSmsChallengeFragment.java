package id.dana.riskChallenges.ui.otp.otpsms;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.core.ui.richview.OtpInputView;
import id.dana.data.constant.DanaUrl;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentInputOtpChallengeBinding;
import id.dana.riskChallenges.databinding.LayoutOtpVerifyBinding;
import id.dana.riskChallenges.ui.otp.viewmodel.OtpChallengeViewModel;
import id.dana.riskChallenges.ui.util.model.HistoryFallbackModel;
import id.dana.riskChallenges.ui.util.model.TrackerModel;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J!\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0005R\u0013\u0010\u0011\u001a\u00020\u000eX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/riskChallenges/ui/otp/otpsms/OtpSmsChallengeFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/riskChallenges/databinding/FragmentInputOtpChallengeBinding;", "", "lookAheadTest", "()V", "onDestroyView", "Landroid/view/View;", "p0", "Landroid/os/Bundle;", "p1", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/ui/otp/otpsms/OtpSmsSharedLogicHandler;", "PlaceComponentResult", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OtpSmsChallengeFragment extends BaseViewBindingFragment<FragmentInputOtpChallengeBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<OtpSmsSharedLogicHandler>() { // from class: id.dana.riskChallenges.ui.otp.otpsms.OtpSmsChallengeFragment$otpSmsSharedLogicHandler$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final OtpSmsSharedLogicHandler invoke() {
            OtpSmsChallengeFragment otpSmsChallengeFragment = OtpSmsChallengeFragment.this;
            OtpSmsChallengeFragment otpSmsChallengeFragment2 = otpSmsChallengeFragment;
            VB vb = otpSmsChallengeFragment.PlaceComponentResult;
            if (vb != 0) {
                LayoutOtpVerifyBinding layoutOtpVerifyBinding = ((FragmentInputOtpChallengeBinding) vb).MyBillsEntityDataFactory;
                VB vb2 = OtpSmsChallengeFragment.this.PlaceComponentResult;
                if (vb2 != 0) {
                    return new OtpSmsSharedLogicHandler(otpSmsChallengeFragment2, layoutOtpVerifyBinding, ((FragmentInputOtpChallengeBinding) vb2).getAuthRequestContext);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    });

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentInputOtpChallengeBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FragmentInputOtpChallengeBinding MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        MyBillsEntityDataFactory = FragmentInputOtpChallengeBinding.MyBillsEntityDataFactory(layoutInflater.inflate(R.layout.fragment_input_otp_challenge, viewGroup, false));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v14, types: [android.os.Parcelable] */
    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Object obj;
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        getLifecycle().BuiltInFictitiousFunctionClassFactory((OtpSmsSharedLogicHandler) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                obj = (Parcelable) arguments.getParcelable("KEY_UI_COMPONENT", UiComponent.class);
            } else {
                ?? parcelable = arguments.getParcelable("KEY_UI_COMPONENT");
                obj = parcelable instanceof UiComponent ? parcelable : null;
            }
            r6 = (UiComponent) obj;
        }
        if (r6 != null) {
            Object obj2 = this.PlaceComponentResult;
            if (obj2 != null) {
                ((FragmentInputOtpChallengeBinding) obj2).getAuthRequestContext.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), r6.MyBillsEntityDataFactory));
                Object obj3 = this.PlaceComponentResult;
                if (obj3 != null) {
                    ((FragmentInputOtpChallengeBinding) obj3).PlaceComponentResult.PlaceComponentResult.setText(getString(r6.BuiltInFictitiousFunctionClassFactory));
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        Object obj4 = this.PlaceComponentResult;
        if (obj4 != null) {
            AppCompatImageView appCompatImageView = ((FragmentInputOtpChallengeBinding) obj4).PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
            int i = R.drawable.getAuthRequestContext;
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
            } else {
                appCompatImageView.setImageResource(i);
            }
            Object obj5 = this.PlaceComponentResult;
            if (obj5 != null) {
                AppCompatImageView appCompatImageView2 = ((FragmentInputOtpChallengeBinding) obj5).PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                appCompatImageView2.setVisibility(0);
                Object obj6 = this.PlaceComponentResult;
                if (obj6 != null) {
                    ((FragmentInputOtpChallengeBinding) obj6).PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.otp.otpsms.OtpSmsChallengeFragment$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            OtpSmsChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(OtpSmsChallengeFragment.this);
                        }
                    });
                    Object obj7 = this.PlaceComponentResult;
                    if (obj7 != null) {
                        AppCompatImageView appCompatImageView3 = ((FragmentInputOtpChallengeBinding) obj7).PlaceComponentResult.MyBillsEntityDataFactory;
                        int i2 = R.drawable.ic_help_white;
                        if (appCompatImageView3 instanceof ImageView) {
                            InstrumentInjector.Resources_setImageResource(appCompatImageView3, i2);
                        } else {
                            appCompatImageView3.setImageResource(i2);
                        }
                        Object obj8 = this.PlaceComponentResult;
                        if (obj8 != null) {
                            AppCompatImageView appCompatImageView4 = ((FragmentInputOtpChallengeBinding) obj8).PlaceComponentResult.MyBillsEntityDataFactory;
                            Intrinsics.checkNotNullExpressionValue(appCompatImageView4, "");
                            appCompatImageView4.setVisibility(0);
                            Object obj9 = this.PlaceComponentResult;
                            if (obj9 != null) {
                                ((FragmentInputOtpChallengeBinding) obj9).PlaceComponentResult.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.otp.otpsms.OtpSmsChallengeFragment$$ExternalSyntheticLambda1
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        OtpSmsChallengeFragment.BuiltInFictitiousFunctionClassFactory(OtpSmsChallengeFragment.this);
                                    }
                                });
                                return;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void MyBillsEntityDataFactory() {
        if (FragmentExtKt.PlaceComponentResult(this)) {
            getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0)));
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2((OtpSmsSharedLogicHandler) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017Ju\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/riskChallenges/ui/otp/otpsms/OtpSmsChallengeFragment$Companion;", "", "", "p0", "p1", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "p2", "p3", "p4", "p5", "p6", "", "p7", "p8", "p9", "Lid/dana/riskChallenges/ui/util/model/HistoryFallbackModel;", "p10", "Lid/dana/riskChallenges/ui/util/model/TrackerModel;", "p11", "Lid/dana/riskChallenges/ui/otp/otpsms/OtpSmsChallengeFragment;", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/model/HistoryFallbackModel;Lid/dana/riskChallenges/ui/util/model/TrackerModel;)Lid/dana/riskChallenges/ui/otp/otpsms/OtpSmsChallengeFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static OtpSmsChallengeFragment PlaceComponentResult(String p0, String p1, UiComponent p2, String p3, String p4, String p5, String p6, boolean p7, String p8, String p9, HistoryFallbackModel p10, TrackerModel p11) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intrinsics.checkNotNullParameter(p4, "");
            Intrinsics.checkNotNullParameter(p5, "");
            Intrinsics.checkNotNullParameter(p6, "");
            Intrinsics.checkNotNullParameter(p8, "");
            Intrinsics.checkNotNullParameter(p11, "");
            OtpSmsChallengeFragment otpSmsChallengeFragment = new OtpSmsChallengeFragment();
            otpSmsChallengeFragment.setArguments(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_PHONE_NUMBER", p0), TuplesKt.to("KEY_UI_COMPONENT", p2), TuplesKt.to("KEY_SECURITY_ID", p1), TuplesKt.to("KEY_USE_CASE_STRATEGY", p3), TuplesKt.to("KEY_OTP_CHANNEL", p4), TuplesKt.to("KEY_SERVICE_CODE", p5), TuplesKt.to("KEY_MERCHANT_ID", p6), TuplesKt.to("KEY_IS_SEND_MONEY", Boolean.valueOf(p7)), TuplesKt.to("KEY_SCENARIO", p8), TuplesKt.to("KEY_RISK_TOKEN", p9), TuplesKt.to("KEY_HISTORY_FALLBACK_MODEL", p10), TuplesKt.to("KEY_TRACKER_MODEL", p11)));
            return otpSmsChallengeFragment;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(OtpSmsChallengeFragment otpSmsChallengeFragment) {
        Intrinsics.checkNotNullParameter(otpSmsChallengeFragment, "");
        ((OtpChallengeViewModel) ((OtpSmsSharedLogicHandler) otpSmsChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).scheduleImpl.getValue()).moveToNextValue();
        otpSmsChallengeFragment.MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(OtpSmsChallengeFragment otpSmsChallengeFragment) {
        Intrinsics.checkNotNullParameter(otpSmsChallengeFragment, "");
        ((OtpSmsSharedLogicHandler) otpSmsChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).getAuthRequestContext(DanaUrl.DANA_OTP_ARTICLE);
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        OtpInputView otpInputView;
        ((OtpChallengeViewModel) ((OtpSmsSharedLogicHandler) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).scheduleImpl.getValue()).moveToNextValue();
        final OtpSmsSharedLogicHandler otpSmsSharedLogicHandler = (OtpSmsSharedLogicHandler) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        LayoutOtpVerifyBinding layoutOtpVerifyBinding = otpSmsSharedLogicHandler.KClassImpl$Data$declaredNonStaticMembers$2;
        if (layoutOtpVerifyBinding != null && (otpInputView = layoutOtpVerifyBinding.MyBillsEntityDataFactory) != null) {
            otpInputView.post(new Runnable() { // from class: id.dana.riskChallenges.ui.otp.otpsms.OtpSmsSharedLogicHandler$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    OtpSmsSharedLogicHandler.moveToNextValue(OtpSmsSharedLogicHandler.this);
                }
            });
        }
        MyBillsEntityDataFactory();
    }
}

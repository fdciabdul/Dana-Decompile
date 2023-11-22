package id.dana.riskChallenges.ui.verifypin;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentPinVerifyBinding;
import id.dana.riskChallenges.databinding.LayoutPinVerifyBinding;
import id.dana.riskChallenges.databinding.ViewToolbarBinding;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared;
import id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared$$ExternalSyntheticLambda1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J!\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0005R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0014\u001a\u00020\u0012X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/riskChallenges/databinding/FragmentPinVerifyBinding;", "", "lookAheadTest", "()V", "onDestroyView", "Landroid/view/View;", "p0", "Landroid/os/Bundle;", "p1", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "PlaceComponentResult", "()Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/ui/verifypin/shared/VerifyPinShared;", "Lkotlin/Lazy;", "BuiltInFictitiousFunctionClassFactory", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyPinFragment extends BaseViewBindingFragment<FragmentPinVerifyBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<VerifyPinShared>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinFragment$verifyPinShared$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VerifyPinShared invoke() {
            VerifyPinFragment verifyPinFragment = VerifyPinFragment.this;
            VerifyPinFragment verifyPinFragment2 = verifyPinFragment;
            VB vb = verifyPinFragment.PlaceComponentResult;
            if (vb != 0) {
                LayoutPinVerifyBinding layoutPinVerifyBinding = ((FragmentPinVerifyBinding) vb).MyBillsEntityDataFactory;
                VB vb2 = VerifyPinFragment.this.PlaceComponentResult;
                if (vb2 != 0) {
                    return new VerifyPinShared(verifyPinFragment2, layoutPinVerifyBinding, ((FragmentPinVerifyBinding) vb2).PlaceComponentResult);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    });

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentPinVerifyBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentPinVerifyBinding MyBillsEntityDataFactory = FragmentPinVerifyBinding.MyBillsEntityDataFactory(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @JvmName(name = "PlaceComponentResult")
    private final UiComponent PlaceComponentResult() {
        Object obj;
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                obj = (Parcelable) arguments.getParcelable("KEY_UI_COMPONENT", UiComponent.class);
            } else {
                Object parcelable = arguments.getParcelable("KEY_UI_COMPONENT");
                obj = (Parcelable) ((UiComponent) (parcelable instanceof UiComponent ? parcelable : null));
            }
            return (UiComponent) obj;
        }
        return null;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        getLifecycle().BuiltInFictitiousFunctionClassFactory((VerifyPinShared) this.BuiltInFictitiousFunctionClassFactory.getValue());
        UiComponent PlaceComponentResult = PlaceComponentResult();
        if (PlaceComponentResult != null) {
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                ((FragmentPinVerifyBinding) vb).PlaceComponentResult.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), PlaceComponentResult.MyBillsEntityDataFactory));
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        VB vb2 = this.PlaceComponentResult;
        if (vb2 != 0) {
            ((FragmentPinVerifyBinding) vb2).MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(getString(R.string.verify_pin_txt_input_pin_page));
            VB vb3 = this.PlaceComponentResult;
            if (vb3 != 0) {
                ViewToolbarBinding viewToolbarBinding = ((FragmentPinVerifyBinding) vb3).KClassImpl$Data$declaredNonStaticMembers$2;
                TextView textView = viewToolbarBinding.PlaceComponentResult;
                UiComponent PlaceComponentResult2 = PlaceComponentResult();
                textView.setText(PlaceComponentResult2 != null ? getString(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory) : null);
                AppCompatImageView appCompatImageView = viewToolbarBinding.BuiltInFictitiousFunctionClassFactory;
                int i = R.drawable.getAuthRequestContext;
                if (appCompatImageView instanceof ImageView) {
                    InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
                } else {
                    appCompatImageView.setImageResource(i);
                }
                viewToolbarBinding.BuiltInFictitiousFunctionClassFactory.setContentDescription(getString(R.string.verify_pin_btn_back));
                viewToolbarBinding.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VerifyPinFragment.MyBillsEntityDataFactory(VerifyPinFragment.this);
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        PinEntryEditText pinEntryEditText;
        if (getParentFragmentManager().getBackStackEntryCount() > 0) {
            getParentFragmentManager().popBackStack();
            return;
        }
        VerifyPinShared verifyPinShared = (VerifyPinShared) this.BuiltInFictitiousFunctionClassFactory.getValue();
        LayoutPinVerifyBinding layoutPinVerifyBinding = verifyPinShared.getAuthRequestContext;
        if (layoutPinVerifyBinding != null && (pinEntryEditText = layoutPinVerifyBinding.MyBillsEntityDataFactory) != null) {
            pinEntryEditText.post(new VerifyPinShared$$ExternalSyntheticLambda1(verifyPinShared));
        }
        MyBillsEntityDataFactory();
    }

    private final void MyBillsEntityDataFactory() {
        if (FragmentExtKt.PlaceComponentResult(this)) {
            getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0)));
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2((VerifyPinShared) this.BuiltInFictitiousFunctionClassFactory.getValue());
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ9\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinFragment$Companion;", "", "", "p0", "p1", "p2", "p3", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "p4", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinFragment;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;)Lid/dana/riskChallenges/ui/verifypin/VerifyPinFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static VerifyPinFragment getAuthRequestContext(String p0, String p1, String p2, String p3, UiComponent p4) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            VerifyPinFragment verifyPinFragment = new VerifyPinFragment();
            verifyPinFragment.setArguments(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_UI_COMPONENT", p4), TuplesKt.to("KEY_STRATEGY", p0), TuplesKt.to("KEY_SCENE", p1), TuplesKt.to("KEY_SECURITY_ID", p2), TuplesKt.to("KEY_PHONE_NUMBER", p3)));
            return verifyPinFragment;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(VerifyPinFragment verifyPinFragment) {
        PinEntryEditText pinEntryEditText;
        Intrinsics.checkNotNullParameter(verifyPinFragment, "");
        if (verifyPinFragment.getParentFragmentManager().getBackStackEntryCount() > 0) {
            verifyPinFragment.getParentFragmentManager().popBackStack();
            return;
        }
        VerifyPinShared verifyPinShared = (VerifyPinShared) verifyPinFragment.BuiltInFictitiousFunctionClassFactory.getValue();
        LayoutPinVerifyBinding layoutPinVerifyBinding = verifyPinShared.getAuthRequestContext;
        if (layoutPinVerifyBinding != null && (pinEntryEditText = layoutPinVerifyBinding.MyBillsEntityDataFactory) != null) {
            pinEntryEditText.post(new VerifyPinShared$$ExternalSyntheticLambda1(verifyPinShared));
        }
        verifyPinFragment.MyBillsEntityDataFactory();
    }
}

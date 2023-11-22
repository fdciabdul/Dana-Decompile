package id.dana.riskChallenges.ui.passkey;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.databinding.ViewBaseToolbarBinding;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentPasskeyEnrollmentFaqBinding;
import id.dana.riskChallenges.di.component.RiskChallengesComponentKt;
import id.dana.riskChallenges.ui.passkey.adapter.DropdownFaqAdapter;
import id.dana.riskChallenges.ui.passkey.model.FaqPasskeyModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\fX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/EnrollmentFaqFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/riskChallenges/databinding/FragmentPasskeyEnrollmentFaqBinding;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "Landroid/view/View;", "p0", "Landroid/os/Bundle;", "p1", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lid/dana/riskChallenges/ui/passkey/adapter/DropdownFaqAdapter;", "PlaceComponentResult", "Lkotlin/Lazy;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EnrollmentFaqFragment extends BaseViewBindingFragment<FragmentPasskeyEnrollmentFaqBinding> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<DropdownFaqAdapter>() { // from class: id.dana.riskChallenges.ui.passkey.EnrollmentFaqFragment$faqAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DropdownFaqAdapter invoke() {
            DropdownFaqAdapter dropdownFaqAdapter = new DropdownFaqAdapter();
            BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(dropdownFaqAdapter, EnrollmentFaqFragment.BuiltInFictitiousFunctionClassFactory(EnrollmentFaqFragment.this));
            return dropdownFaqAdapter;
        }
    });

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentPasskeyEnrollmentFaqBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentPasskeyEnrollmentFaqBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentPasskeyEnrollmentFaqBinding.KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        super.KClassImpl$Data$declaredNonStaticMembers$2();
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ViewBaseToolbarBinding viewBaseToolbarBinding = ((FragmentPasskeyEnrollmentFaqBinding) vb).BuiltInFictitiousFunctionClassFactory;
            viewBaseToolbarBinding.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(R.string.passkey_about));
            AppCompatImageView appCompatImageView = viewBaseToolbarBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            int i = R.drawable.getAuthRequestContext;
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
            } else {
                appCompatImageView.setImageResource(i);
            }
            viewBaseToolbarBinding.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.passkey.EnrollmentFaqFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EnrollmentFaqFragment.KClassImpl$Data$declaredNonStaticMembers$2(EnrollmentFaqFragment.this);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "");
        RiskChallengesComponentKt.BuiltInFictitiousFunctionClassFactory(requireActivity);
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentPasskeyEnrollmentFaqBinding) vb).getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.passkey.EnrollmentFaqFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EnrollmentFaqFragment.getAuthRequestContext(EnrollmentFaqFragment.this);
                }
            });
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                RecyclerView recyclerView = ((FragmentPasskeyEnrollmentFaqBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2;
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                recyclerView.setAdapter((DropdownFaqAdapter) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void getAuthRequestContext(EnrollmentFaqFragment enrollmentFaqFragment) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(enrollmentFaqFragment, "");
        FragmentActivity activity = enrollmentFaqFragment.getActivity();
        if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
            return;
        }
        supportFragmentManager.popBackStack();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(EnrollmentFaqFragment enrollmentFaqFragment) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(enrollmentFaqFragment, "");
        FragmentActivity activity = enrollmentFaqFragment.getActivity();
        if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
            return;
        }
        supportFragmentManager.popBackStack();
    }

    public static final /* synthetic */ List BuiltInFictitiousFunctionClassFactory(EnrollmentFaqFragment enrollmentFaqFragment) {
        String string = enrollmentFaqFragment.getString(R.string.passkey_faq_one_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = enrollmentFaqFragment.getString(R.string.passkey_faq_one_desc);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String string3 = enrollmentFaqFragment.getString(R.string.passkey_faq_two_title);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = enrollmentFaqFragment.getString(R.string.passkey_faq_two_desc);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        String string5 = enrollmentFaqFragment.getString(R.string.passkey_faq_three_title);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        String string6 = enrollmentFaqFragment.getString(R.string.passkey_faq_three_desc);
        Intrinsics.checkNotNullExpressionValue(string6, "");
        return CollectionsKt.listOf((Object[]) new FaqPasskeyModel[]{new FaqPasskeyModel(1, string, string2), new FaqPasskeyModel(2, string3, string4), new FaqPasskeyModel(3, string5, string6)});
    }
}

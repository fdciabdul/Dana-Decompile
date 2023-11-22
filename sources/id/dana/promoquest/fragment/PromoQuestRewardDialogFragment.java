package id.dana.promoquest.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/promoquest/fragment/PromoQuestRewardDialogFragment;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onShow", "onStart", "", "lookAheadTest", "Z", "getAuthRequestContext", "Lkotlin/Function0;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/jvm/functions/Function0;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(ZLkotlin/jvm/functions/Function0;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoQuestRewardDialogFragment extends BaseBottomSheetDialogFragment {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final boolean getAuthRequestContext;

    private View BuiltInFictitiousFunctionClassFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.view_coordinator_promo_quest_reward;
    }

    public PromoQuestRewardDialogFragment(boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.getAuthRequestContext = z;
        this.BuiltInFictitiousFunctionClassFactory = function0;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        initMatchParentDialog(getDialog());
        initTransparentDialogDim(getDialog());
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        if (this.getAuthRequestContext) {
            ImageView imageView = (ImageView) BuiltInFictitiousFunctionClassFactory(R.id.iv_prize_icon);
            if (imageView != null) {
                InstrumentInjector.Resources_setImageResource(imageView, R.drawable.prize_claimed_success);
            }
            TextView textView = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.setDrawValueAboveBar);
            if (textView != null) {
                textView.setText(getString(R.string.quest_success_claim_title));
            }
            TextView textView2 = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.SendRiskEventEntityRepository$$ExternalSyntheticLambda1);
            if (textView2 != null) {
                textView2.setText(getString(R.string.quest_success_claim_description));
            }
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) BuiltInFictitiousFunctionClassFactory(R.id.y);
            if (danaButtonPrimaryView != null) {
                danaButtonPrimaryView.setActiveButton(getString(R.string.see_prize), null);
            }
            DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) BuiltInFictitiousFunctionClassFactory(R.id.y);
            if (danaButtonPrimaryView2 != null) {
                danaButtonPrimaryView2.setVisibility(0);
            }
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) BuiltInFictitiousFunctionClassFactory(R.id.getCardNumberOCR);
            if (danaButtonSecondaryView != null) {
                danaButtonSecondaryView.setVisibility(0);
            }
        } else {
            ImageView imageView2 = (ImageView) BuiltInFictitiousFunctionClassFactory(R.id.iv_prize_icon);
            if (imageView2 != null) {
                InstrumentInjector.Resources_setImageResource(imageView2, R.drawable.prize_claimed_failed);
            }
            TextView textView3 = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.setDrawValueAboveBar);
            if (textView3 != null) {
                textView3.setText(getString(R.string.quest_failed_claim_title));
            }
            TextView textView4 = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.SendRiskEventEntityRepository$$ExternalSyntheticLambda1);
            if (textView4 != null) {
                textView4.setText(getString(R.string.quest_failed_claim_description));
            }
            DanaButtonPrimaryView danaButtonPrimaryView3 = (DanaButtonPrimaryView) BuiltInFictitiousFunctionClassFactory(R.id.y);
            if (danaButtonPrimaryView3 != null) {
                danaButtonPrimaryView3.setActiveButton(getString(R.string.btn_ok_promo_quest), null);
            }
            DanaButtonPrimaryView danaButtonPrimaryView4 = (DanaButtonPrimaryView) BuiltInFictitiousFunctionClassFactory(R.id.y);
            if (danaButtonPrimaryView4 != null) {
                danaButtonPrimaryView4.setVisibility(0);
            }
            DanaButtonSecondaryView danaButtonSecondaryView2 = (DanaButtonSecondaryView) BuiltInFictitiousFunctionClassFactory(R.id.getCardNumberOCR);
            if (danaButtonSecondaryView2 != null) {
                danaButtonSecondaryView2.setVisibility(8);
            }
        }
        ((DanaButtonSecondaryView) BuiltInFictitiousFunctionClassFactory(R.id.getCardNumberOCR)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.promoquest.fragment.PromoQuestRewardDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PromoQuestRewardDialogFragment.MyBillsEntityDataFactory(PromoQuestRewardDialogFragment.this);
            }
        });
        ((DanaButtonPrimaryView) BuiltInFictitiousFunctionClassFactory(R.id.y)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.promoquest.fragment.PromoQuestRewardDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PromoQuestRewardDialogFragment.getAuthRequestContext(PromoQuestRewardDialogFragment.this);
            }
        });
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
    }

    public static /* synthetic */ void getAuthRequestContext(PromoQuestRewardDialogFragment promoQuestRewardDialogFragment) {
        Intrinsics.checkNotNullParameter(promoQuestRewardDialogFragment, "");
        promoQuestRewardDialogFragment.BuiltInFictitiousFunctionClassFactory.invoke();
        promoQuestRewardDialogFragment.dismiss();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(PromoQuestRewardDialogFragment promoQuestRewardDialogFragment) {
        Intrinsics.checkNotNullParameter(promoQuestRewardDialogFragment, "");
        promoQuestRewardDialogFragment.dismiss();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        FrameLayout frameLayout = (FrameLayout) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a0114_networkuserentitydata_externalsyntheticlambda7);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}

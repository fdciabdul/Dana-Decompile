package id.dana.sendmoney.external;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.glide.GlideApp;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001&B'\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u001d\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u001d¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0014¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\nJ\u0015\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\b*\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0018\u001a\u00020\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0012\u0010\u0013\u001a\u00020\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\"\u0010\u0017"}, d2 = {"Lid/dana/sendmoney/external/SmartFrictionBottomSheetFragment;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onDismiss", "onShow", "onStart", "Landroidx/fragment/app/FragmentManager;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/fragment/app/FragmentManager;)V", "Landroid/widget/ImageView;", "PlaceComponentResult", "(Landroid/widget/ImageView;I)V", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "MyBillsEntityDataFactory", "", "moveToNextValue", "Z", "getAuthRequestContext", "Lkotlin/Function0;", "getErrorConfigVersion", "Lkotlin/jvm/functions/Function0;", "scheduleImpl", "BuiltInFictitiousFunctionClassFactory", "lookAheadTest", "p1", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SmartFrictionBottomSheetFragment extends BaseBottomSheetDialogFragment {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SmartFrictionBottomSheetFragment() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.external.SmartFrictionBottomSheetFragment.<init>():void");
    }

    private View getAuthRequestContext(int i) {
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
        return 0.48f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.bottom_sheet_smart_friction_coordinator;
    }

    public SmartFrictionBottomSheetFragment(Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
        this.BuiltInFictitiousFunctionClassFactory = function02;
        this.PlaceComponentResult = "";
        this.MyBillsEntityDataFactory = "";
    }

    public /* synthetic */ SmartFrictionBottomSheetFragment(AnonymousClass1 anonymousClass1, AnonymousClass2 anonymousClass2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function0<Unit>() { // from class: id.dana.sendmoney.external.SmartFrictionBottomSheetFragment.1
            /* renamed from: invoke */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : anonymousClass1, (i & 2) != 0 ? new Function0<Unit>() { // from class: id.dana.sendmoney.external.SmartFrictionBottomSheetFragment.2
            /* renamed from: invoke */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : anonymousClass2);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) getAuthRequestContext(R.id.SummaryVoucherView$$ExternalSyntheticLambda2);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.external.SmartFrictionBottomSheetFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SmartFrictionBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(SmartFrictionBottomSheetFragment.this);
                }
            });
        }
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) getAuthRequestContext(R.id.M);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.external.SmartFrictionBottomSheetFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SmartFrictionBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(SmartFrictionBottomSheetFragment.this);
                }
            });
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        initMatchParentDialog(getDialog());
        initTransparentDialogDim(getDialog());
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: id.dana.sendmoney.external.SmartFrictionBottomSheetFragment$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    SmartFrictionBottomSheetFragment.getAuthRequestContext(SmartFrictionBottomSheetFragment.this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onDismiss() {
        super.onDismiss();
        this.getAuthRequestContext = false;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(FragmentManager p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Fragment findFragmentByTag = p0.findFragmentByTag("SmartFrictionBottomSheet");
        if (findFragmentByTag != null) {
            p0.beginTransaction().KClassImpl$Data$declaredNonStaticMembers$2(findFragmentByTag);
        }
        if (this.getAuthRequestContext || p0.isStateSaved()) {
            return;
        }
        super.show(p0, "SmartFrictionBottomSheet");
        this.getAuthRequestContext = true;
    }

    private static void PlaceComponentResult(ImageView imageView, int i) {
        Context context = imageView.getContext();
        if (context != null) {
            GlideApp.getAuthRequestContext(context).PlaceComponentResult(Integer.valueOf(i)).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.ic_unregistered_number).PlaceComponentResult((int) R.drawable.ic_unregistered_number).MyBillsEntityDataFactory(imageView);
        }
    }

    public static /* synthetic */ void getAuthRequestContext(SmartFrictionBottomSheetFragment smartFrictionBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(smartFrictionBottomSheetFragment, "");
        smartFrictionBottomSheetFragment.dismiss();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SmartFrictionBottomSheetFragment smartFrictionBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(smartFrictionBottomSheetFragment, "");
        smartFrictionBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2.invoke();
        smartFrictionBottomSheetFragment.dismiss();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SmartFrictionBottomSheetFragment smartFrictionBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(smartFrictionBottomSheetFragment, "");
        smartFrictionBottomSheetFragment.BuiltInFictitiousFunctionClassFactory.invoke();
        smartFrictionBottomSheetFragment.dismiss();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        FrameLayout frameLayout = (FrameLayout) getAuthRequestContext(R.id.MediaCodec$OutputFrame);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        String str = this.PlaceComponentResult;
        int hashCode = str.hashCode();
        if (hashCode != 442869293) {
            if (hashCode != 944938249) {
                if (hashCode == 1322424106 && str.equals("BLACKLISTED_ACCOUNT")) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) getAuthRequestContext(R.id.getLogSourceName);
                    if (appCompatTextView != null) {
                        appCompatTextView.setText(getString(R.string.account_freeze_title));
                    }
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) getAuthRequestContext(R.id.setupWithViewPager);
                    if (appCompatTextView2 != null) {
                        appCompatTextView2.setText(getString(R.string.blacklist_account_description));
                    }
                    DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) getAuthRequestContext(R.id.SummaryVoucherView$$ExternalSyntheticLambda2);
                    if (danaButtonPrimaryView != null) {
                        danaButtonPrimaryView.setActiveButton(getString(R.string.res_0x7f130923_otpregistrationpresenter_input_2), null);
                    }
                    DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) getAuthRequestContext(R.id.M);
                    if (danaButtonSecondaryView != null) {
                        danaButtonSecondaryView.setVisibility(8);
                    }
                    AppCompatImageView appCompatImageView = (AppCompatImageView) getAuthRequestContext(R.id.GetLeaderboardEntryBanner);
                    if (appCompatImageView != null) {
                        PlaceComponentResult(appCompatImageView, R.drawable.ic_blacklist_account);
                    }
                }
            } else if (str.equals("ACCOUNT_FREEZE")) {
                AppCompatTextView appCompatTextView3 = (AppCompatTextView) getAuthRequestContext(R.id.getLogSourceName);
                if (appCompatTextView3 != null) {
                    appCompatTextView3.setText(getString(R.string.account_freeze_title));
                }
                AppCompatTextView appCompatTextView4 = (AppCompatTextView) getAuthRequestContext(R.id.getLogSourceName);
                if (appCompatTextView4 != null) {
                    appCompatTextView4.setContentDescription(getString(R.string.lbl_warning_receiver_account_freeze));
                }
                AppCompatTextView appCompatTextView5 = (AppCompatTextView) getAuthRequestContext(R.id.setupWithViewPager);
                if (appCompatTextView5 != null) {
                    appCompatTextView5.setText(getString(R.string.account_freeze_description));
                }
                DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) getAuthRequestContext(R.id.SummaryVoucherView$$ExternalSyntheticLambda2);
                if (danaButtonPrimaryView2 != null) {
                    danaButtonPrimaryView2.setActiveButton(getString(R.string.res_0x7f130923_otpregistrationpresenter_input_2), null);
                }
                DanaButtonPrimaryView danaButtonPrimaryView3 = (DanaButtonPrimaryView) getAuthRequestContext(R.id.SummaryVoucherView$$ExternalSyntheticLambda2);
                if (danaButtonPrimaryView3 != null) {
                    danaButtonPrimaryView3.setButtonContentDescription(getString(R.string.res_0x7f13030b_networkuserentitydata_externalsyntheticlambda6));
                }
                DanaButtonSecondaryView danaButtonSecondaryView2 = (DanaButtonSecondaryView) getAuthRequestContext(R.id.M);
                if (danaButtonSecondaryView2 != null) {
                    danaButtonSecondaryView2.setVisibility(8);
                }
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) getAuthRequestContext(R.id.GetLeaderboardEntryBanner);
                if (appCompatImageView2 != null) {
                    PlaceComponentResult(appCompatImageView2, R.drawable.ic_account_freeze);
                }
            }
        } else if (str.equals("UNREGISTERED_NUMBER")) {
            AppCompatTextView appCompatTextView6 = (AppCompatTextView) getAuthRequestContext(R.id.getLogSourceName);
            if (appCompatTextView6 != null) {
                appCompatTextView6.setText(getString(R.string.unregistered_number_title));
            }
            AppCompatTextView appCompatTextView7 = (AppCompatTextView) getAuthRequestContext(R.id.getLogSourceName);
            if (appCompatTextView7 != null) {
                appCompatTextView7.setContentDescription(getString(R.string.lbl_warning_number_not_registered));
            }
            AppCompatTextView appCompatTextView8 = (AppCompatTextView) getAuthRequestContext(R.id.setupWithViewPager);
            if (appCompatTextView8 != null) {
                appCompatTextView8.setText(getString(R.string.unregistered_number_description));
            }
            DanaButtonPrimaryView danaButtonPrimaryView4 = (DanaButtonPrimaryView) getAuthRequestContext(R.id.SummaryVoucherView$$ExternalSyntheticLambda2);
            if (danaButtonPrimaryView4 != null) {
                danaButtonPrimaryView4.setActiveButton(getString(R.string.btn_continue), null);
            }
            DanaButtonPrimaryView danaButtonPrimaryView5 = (DanaButtonPrimaryView) getAuthRequestContext(R.id.SummaryVoucherView$$ExternalSyntheticLambda2);
            if (danaButtonPrimaryView5 != null) {
                danaButtonPrimaryView5.setButtonContentDescription(getString(R.string.btn_continue_content_description));
            }
            DanaButtonSecondaryView danaButtonSecondaryView3 = (DanaButtonSecondaryView) getAuthRequestContext(R.id.M);
            if (danaButtonSecondaryView3 != null) {
                danaButtonSecondaryView3.setActiveButton(getString(R.string.cancel_action), null);
            }
            DanaButtonSecondaryView danaButtonSecondaryView4 = (DanaButtonSecondaryView) getAuthRequestContext(R.id.M);
            if (danaButtonSecondaryView4 != null) {
                danaButtonSecondaryView4.setButtonContentDescription(getString(R.string.btn_recheck));
            }
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) getAuthRequestContext(R.id.GetLeaderboardEntryBanner);
            if (appCompatImageView3 != null) {
                PlaceComponentResult(appCompatImageView3, R.drawable.ic_unregistered_number);
            }
            DanaButtonPrimaryView danaButtonPrimaryView6 = (DanaButtonPrimaryView) getAuthRequestContext(R.id.SummaryVoucherView$$ExternalSyntheticLambda2);
            if (danaButtonPrimaryView6 != null) {
                danaButtonPrimaryView6.setButtonContentDescription(getString(R.string.btn_continue_content_description));
            }
            DanaButtonSecondaryView danaButtonSecondaryView5 = (DanaButtonSecondaryView) getAuthRequestContext(R.id.M);
            if (danaButtonSecondaryView5 != null) {
                danaButtonSecondaryView5.setButtonContentDescription(getString(R.string.btn_recheck));
            }
        }
        super.onShow();
        dismissOnTouchOutsideDialog(false);
        initBottomSheet(getScreenHeight(getDialog()), 3);
    }
}

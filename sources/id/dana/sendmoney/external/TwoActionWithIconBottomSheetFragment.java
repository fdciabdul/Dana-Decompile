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
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 +2\u00020\u0001:\u0001+B'\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0!\u0012\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0!¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0014¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\nJ\u0015\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0010\u001a\u00020\b*\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0013R\"\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@GX\u0086\n¢\u0006\f\n\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0012\u0010\u001c\u001a\u00020\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0017\u001a\u00020\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010\u0010\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@GX\u0087\n¢\u0006\f\n\u0004\b \u0010\u0016\"\u0004\b\u0010\u0010\u0018R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0!8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0!8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\"\u0010 \u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@GX\u0087\n¢\u0006\f\n\u0004\b&\u0010\u0016\"\u0004\b$\u0010\u0018R\"\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014@GX\u0087\n¢\u0006\f\n\u0004\b'\u0010\u0016\"\u0004\b\u001c\u0010\u0018"}, d2 = {"Lid/dana/sendmoney/external/TwoActionWithIconBottomSheetFragment;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onDismiss", "onShow", "onStart", "Landroidx/fragment/app/FragmentManager;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/fragment/app/FragmentManager;)V", "Landroid/widget/ImageView;", "(Landroid/widget/ImageView;I)V", "", "moveToNextValue", "Ljava/lang/String;", "PlaceComponentResult", "(Ljava/lang/String;)V", "getAuthRequestContext", "getErrorConfigVersion", "I", "MyBillsEntityDataFactory", "", "scheduleImpl", "Z", "lookAheadTest", "Lkotlin/Function0;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/jvm/functions/Function0;", "BuiltInFictitiousFunctionClassFactory", "NetworkUserEntityData$$ExternalSyntheticLambda1", "DatabaseTableConfigUtil", "GetContactSyncConfig", "p1", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TwoActionWithIconBottomSheetFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String lookAheadTest;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private String moveToNextValue;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private Function0<Unit> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public int MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TwoActionWithIconBottomSheetFragment() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.external.TwoActionWithIconBottomSheetFragment.<init>():void");
    }

    public final View KClassImpl$Data$declaredNonStaticMembers$2(int i) {
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
        return R.layout.bottom_sheet_two_action_with_icon_coordinator;
    }

    public TwoActionWithIconBottomSheetFragment(Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = function0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = function02;
        this.moveToNextValue = "";
        this.getAuthRequestContext = "";
        this.lookAheadTest = "";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
    }

    public /* synthetic */ TwoActionWithIconBottomSheetFragment(AnonymousClass1 anonymousClass1, AnonymousClass2 anonymousClass2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function0<Unit>() { // from class: id.dana.sendmoney.external.TwoActionWithIconBottomSheetFragment.1
            /* renamed from: invoke */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : anonymousClass1, (i & 2) != 0 ? new Function0<Unit>() { // from class: id.dana.sendmoney.external.TwoActionWithIconBottomSheetFragment.2
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

    @JvmName(name = "MyBillsEntityDataFactory")
    public final void MyBillsEntityDataFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.moveToNextValue = str;
        AppCompatTextView appCompatTextView = (AppCompatTextView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.getLogSourceName);
        if (appCompatTextView != null) {
            appCompatTextView.setText(str);
        }
    }

    @JvmName(name = "PlaceComponentResult")
    public final void PlaceComponentResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getAuthRequestContext = str;
        AppCompatTextView appCompatTextView = (AppCompatTextView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.setupWithViewPager);
        if (appCompatTextView != null) {
            appCompatTextView.setText(str);
        }
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.lookAheadTest = str;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.SummaryVoucherView$$ExternalSyntheticLambda2);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setActiveButton(str, null);
        }
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.M);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setActiveButton(str, null);
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.SummaryVoucherView$$ExternalSyntheticLambda2);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.external.TwoActionWithIconBottomSheetFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TwoActionWithIconBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(TwoActionWithIconBottomSheetFragment.this);
                }
            });
        }
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.M);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.external.TwoActionWithIconBottomSheetFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TwoActionWithIconBottomSheetFragment.MyBillsEntityDataFactory(TwoActionWithIconBottomSheetFragment.this);
                }
            });
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.getLogSourceName);
        if (appCompatTextView != null) {
            appCompatTextView.setText(this.moveToNextValue);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.setupWithViewPager);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(this.getAuthRequestContext);
        }
        DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.SummaryVoucherView$$ExternalSyntheticLambda2);
        if (danaButtonPrimaryView2 != null) {
            danaButtonPrimaryView2.setActiveButton(this.lookAheadTest, null);
        }
        DanaButtonSecondaryView danaButtonSecondaryView2 = (DanaButtonSecondaryView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.M);
        if (danaButtonSecondaryView2 != null) {
            danaButtonSecondaryView2.setActiveButton(this.KClassImpl$Data$declaredNonStaticMembers$2, null);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.GetLeaderboardEntryBanner);
        if (appCompatImageView != null) {
            KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView, this.MyBillsEntityDataFactory);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        initMatchParentDialog(getDialog());
        initTransparentDialogDim(getDialog());
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: id.dana.sendmoney.external.TwoActionWithIconBottomSheetFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    TwoActionWithIconBottomSheetFragment.getAuthRequestContext(TwoActionWithIconBottomSheetFragment.this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onDismiss() {
        super.onDismiss();
        this.PlaceComponentResult = false;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(FragmentManager p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Fragment findFragmentByTag = p0.findFragmentByTag("TwoActionWithIconBottomSheet");
        if (findFragmentByTag != null) {
            p0.beginTransaction().KClassImpl$Data$declaredNonStaticMembers$2(findFragmentByTag);
        }
        if (this.PlaceComponentResult || p0.isStateSaved()) {
            return;
        }
        super.show(p0, "TwoActionWithIconBottomSheet");
        this.PlaceComponentResult = true;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(ImageView imageView, int i) {
        Context context = imageView.getContext();
        if (context != null) {
            GlideApp.getAuthRequestContext(context).PlaceComponentResult(Integer.valueOf(i)).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.ic_unregistered_number).PlaceComponentResult((int) R.drawable.ic_unregistered_number).MyBillsEntityDataFactory(imageView);
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(TwoActionWithIconBottomSheetFragment twoActionWithIconBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(twoActionWithIconBottomSheetFragment, "");
        twoActionWithIconBottomSheetFragment.BuiltInFictitiousFunctionClassFactory.invoke();
        twoActionWithIconBottomSheetFragment.dismiss();
    }

    public static /* synthetic */ void getAuthRequestContext(TwoActionWithIconBottomSheetFragment twoActionWithIconBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(twoActionWithIconBottomSheetFragment, "");
        twoActionWithIconBottomSheetFragment.dismiss();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(TwoActionWithIconBottomSheetFragment twoActionWithIconBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(twoActionWithIconBottomSheetFragment, "");
        twoActionWithIconBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.invoke();
        twoActionWithIconBottomSheetFragment.dismiss();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        FrameLayout frameLayout = (FrameLayout) KClassImpl$Data$declaredNonStaticMembers$2(R.id.MediaCodec$OutputFrame);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}

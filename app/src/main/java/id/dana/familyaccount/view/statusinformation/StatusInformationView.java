package id.dana.familyaccount.view.statusinformation;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewFamilyStatusInformationBinding;
import id.dana.familyaccount.constants.StatusInformationType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010%\u001a\u00020#¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\n\u0010\tJ\u001b\u0010\u000b\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R(\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u00168\u0007@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u000e\u0010\u001d"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/StatusInformationView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewFamilyStatusInformationBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewFamilyStatusInformationBinding;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setGotItButtonListener", "(Lkotlin/jvm/functions/Function0;)V", "setNegativeButtonListener", "setPositiveButtonListener", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "", "statusInformationType", "setStatusInformationType", "(Ljava/lang/String;)V", "setup", "()V", "Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;", "PlaceComponentResult", "Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;", "getBtnStatusInformationGotIt", "()Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;", "btnStatusInformationGotIt", "Lid/dana/familyaccount/view/statusinformation/StatusInformationViewState;", "Lid/dana/familyaccount/view/statusinformation/StatusInformationViewState;", "MyBillsEntityDataFactory", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StatusInformationView extends BaseViewBindingRichView<ViewFamilyStatusInformationBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private StatusInformationViewState MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private DanaButtonPrimaryView btnStatusInformationGotIt;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatusInformationView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatusInformationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatusInformationView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusInformationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ StatusInformationView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @JvmName(name = "getBtnStatusInformationGotIt")
    public final DanaButtonPrimaryView getBtnStatusInformationGotIt() {
        return this.btnStatusInformationGotIt;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewFamilyStatusInformationBinding inflateViewBinding() {
        ViewFamilyStatusInformationBinding PlaceComponentResult = ViewFamilyStatusInformationBinding.PlaceComponentResult(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        this.btnStatusInformationGotIt = getBinding().BuiltInFictitiousFunctionClassFactory;
    }

    public final void setStatusInformationType(@StatusInformationType String statusInformationType) {
        Intrinsics.checkNotNullParameter(statusInformationType, "");
        this.MyBillsEntityDataFactory = new StatusInformationViewState(statusInformationType);
        ViewFamilyStatusInformationBinding binding = getBinding();
        RequestManager KClassImpl$Data$declaredNonStaticMembers$2 = Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
        StatusInformationViewState statusInformationViewState = this.MyBillsEntityDataFactory;
        if (statusInformationViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            statusInformationViewState = null;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(Integer.valueOf(statusInformationViewState.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory)).BuiltInFictitiousFunctionClassFactory((int) R.drawable.ic_illustration_family_account_family).BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory(binding.KClassImpl$Data$declaredNonStaticMembers$2);
        TextView textView = binding.moveToNextValue;
        Resources resources = getResources();
        StatusInformationViewState statusInformationViewState2 = this.MyBillsEntityDataFactory;
        if (statusInformationViewState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            statusInformationViewState2 = null;
        }
        textView.setText(resources.getString(statusInformationViewState2.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2));
        TextView textView2 = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Resources resources2 = getResources();
        StatusInformationViewState statusInformationViewState3 = this.MyBillsEntityDataFactory;
        if (statusInformationViewState3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            statusInformationViewState3 = null;
        }
        textView2.setText(resources2.getString(statusInformationViewState3.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult));
        if (Intrinsics.areEqual(statusInformationType, StatusInformationType.KYC_REVOKED)) {
            KClassImpl$Data$declaredNonStaticMembers$2(true);
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(false);
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().BuiltInFictitiousFunctionClassFactory;
        Resources resources3 = getResources();
        StatusInformationViewState statusInformationViewState4 = this.MyBillsEntityDataFactory;
        if (statusInformationViewState4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            statusInformationViewState4 = null;
        }
        danaButtonPrimaryView.setActiveButton(resources3.getString(statusInformationViewState4.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory), null);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        ViewFamilyStatusInformationBinding binding = getBinding();
        ConstraintLayout constraintLayout = binding.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(p0 ? 0 : 8);
        DanaButtonPrimaryView danaButtonPrimaryView = binding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
        danaButtonPrimaryView.setVisibility(p0 ^ true ? 0 : 8);
    }

    public final void setNegativeButtonListener(final Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.statusinformation.StatusInformationView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StatusInformationView.$r8$lambda$xQcFwd3xwCMtB8DnfAEOdss75Qo(Function0.this, view);
            }
        });
    }

    public final void setPositiveButtonListener(final Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.statusinformation.StatusInformationView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StatusInformationView.$r8$lambda$0YkrookorVDo0JtE6gmQ1jlf1W8(Function0.this, view);
            }
        });
    }

    public final void setGotItButtonListener(final Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.statusinformation.StatusInformationView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StatusInformationView.m2604$r8$lambda$RyccGvcrusAV2n9XZoXdBlwWiI(Function0.this, view);
            }
        });
    }

    public static /* synthetic */ void $r8$lambda$0YkrookorVDo0JtE6gmQ1jlf1W8(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }

    /* renamed from: $r8$lambda$Ry-ccGvcrusAV2n9XZoXdBlwWiI  reason: not valid java name */
    public static /* synthetic */ void m2604$r8$lambda$RyccGvcrusAV2n9XZoXdBlwWiI(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }

    public static /* synthetic */ void $r8$lambda$xQcFwd3xwCMtB8DnfAEOdss75Qo(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }
}

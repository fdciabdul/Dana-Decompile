package id.dana.expresspurchase.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewOfferInfoEmasBinding;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import id.dana.expresspurchase.util.ExpressPurchaseExtKt;
import id.dana.extension.ContextExtKt;
import id.dana.extension.view.InputExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/expresspurchase/view/OfferInfoEmas;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewOfferInfoEmasBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewOfferInfoEmasBinding;", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;", "expressPurchaseModel", "", "setupViews", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OfferInfoEmas extends BaseViewBindingRichView<ViewOfferInfoEmasBinding> {
    public Map<Integer, View> _$_findViewCache;

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
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
    public OfferInfoEmas(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ OfferInfoEmas(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewOfferInfoEmasBinding inflateViewBinding() {
        ViewOfferInfoEmasBinding PlaceComponentResult = ViewOfferInfoEmasBinding.PlaceComponentResult(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    public static /* synthetic */ void $r8$lambda$JWEIX0_tfA975e9T1RwnpjTDw3E(OfferInfoEmas offerInfoEmas, ExpressPurchaseModel.Gold gold, View view) {
        Intrinsics.checkNotNullParameter(offerInfoEmas, "");
        Intrinsics.checkNotNullParameter(gold, "");
        Context context = offerInfoEmas.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context)).getNavigationManager().getAuthRequestContext(gold.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda4, false);
    }

    public final void setupViews(final ExpressPurchaseModel.Gold expressPurchaseModel) {
        Intrinsics.checkNotNullParameter(expressPurchaseModel, "");
        ViewOfferInfoEmasBinding binding = getBinding();
        AppCompatImageView appCompatImageView = binding.getAuthRequestContext;
        Context context = appCompatImageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        ExpressPurchaseExtKt.MyBillsEntityDataFactory(appCompatImageView, context, expressPurchaseModel.moveToNextValue.moveToNextValue, (int) R.drawable.ic_illustration_express_purchase_insurance);
        appCompatImageView.setContentDescription(appCompatImageView.getContext().getString(R.string.sdet_img_ep_emas_landing));
        AppCompatTextView appCompatTextView = binding.DatabaseTableConfigUtil;
        appCompatTextView.setText(expressPurchaseModel.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda8);
        appCompatTextView.setContentDescription(appCompatTextView.getContext().getString(R.string.sdet_lbl_ep_emas_landing));
        binding.initRecordTimeStamp.setText(expressPurchaseModel.moveToNextValue.newProxyInstance);
        ViewOfferInfoEmasBinding binding2 = getBinding();
        binding2.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(getContext().getString(R.string.ep_supported_by));
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(binding2.scheduleImpl, Intrinsics.areEqual(expressPurchaseModel.BuiltInFictitiousFunctionClassFactory, "Treasury") ? R.drawable.logo_treasury : R.drawable.logo_pluang);
        binding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getContext().getString(R.string.ep_supervised_by));
        ViewOfferInfoEmasBinding binding3 = getBinding();
        binding3.moveToNextValue.setText(expressPurchaseModel.moveToNextValue.DatabaseTableConfigUtil);
        binding3.getErrorConfigVersion.setText(expressPurchaseModel.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda2);
        AppCompatTextView appCompatTextView2 = binding3.lookAheadTest;
        appCompatTextView2.setText(appCompatTextView2.getContext().getString(R.string.ep_tnc_gold));
        appCompatTextView2.setClickable(true);
        appCompatTextView2.setFocusable(true);
        appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.expresspurchase.view.OfferInfoEmas$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OfferInfoEmas.$r8$lambda$JWEIX0_tfA975e9T1RwnpjTDw3E(OfferInfoEmas.this, expressPurchaseModel, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
        AppCompatTextView appCompatTextView3 = appCompatTextView2;
        String string = appCompatTextView2.getContext().getString(R.string.tnc);
        Intrinsics.checkNotNullExpressionValue(string, "");
        InputExtKt.PlaceComponentResult(appCompatTextView3, string, false, null, 8);
    }
}

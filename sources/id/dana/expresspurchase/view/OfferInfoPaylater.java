package id.dana.expresspurchase.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import id.dana.expresspurchase.util.ExpressPurchaseExtKt;
import id.dana.extension.ContextExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013B+\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0017J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/expresspurchase/view/OfferInfoPaylater;", "Lid/dana/base/BaseRichView;", "Lid/dana/expresspurchase/view/ExpressPurchaseActivity;", "getActivity", "()Lid/dana/expresspurchase/view/ExpressPurchaseActivity;", "", "getLayout", "()I", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Paylater;", "expressPurchaseModel", "", "setupViews", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel$Paylater;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttribute", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "attrs", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OfferInfoPaylater extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfferInfoPaylater(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfferInfoPaylater(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_offer_info_paylater;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferInfoPaylater(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ OfferInfoPaylater(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferInfoPaylater(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final ExpressPurchaseActivity getActivity() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        return (ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context);
    }

    public final void setupViews(ExpressPurchaseModel.Paylater expressPurchaseModel) {
        Intrinsics.checkNotNullParameter(expressPurchaseModel, "");
        List take = CollectionsKt.take(expressPurchaseModel.PlaceComponentResult, 2);
        ExpressPurchaseModel.Paylater.BenefitContent benefitContent = (ExpressPurchaseModel.Paylater.BenefitContent) CollectionsKt.firstOrNull(take);
        ExpressPurchaseModel.Paylater.BenefitContent benefitContent2 = (ExpressPurchaseModel.Paylater.BenefitContent) CollectionsKt.lastOrNull(take);
        if (benefitContent != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.BaseAsyncRecyclerViewAdapter);
            if (appCompatTextView != null) {
                appCompatTextView.setText(benefitContent.MyBillsEntityDataFactory);
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a13cc_r8_lambda_hch8xfkz4xg6ovng_8yt_xchrik);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText(benefitContent.PlaceComponentResult);
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.FeedNotificationSectionViewHolder);
            if (appCompatImageView != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "");
                ExpressPurchaseExtKt.MyBillsEntityDataFactory(appCompatImageView, context, benefitContent.getAuthRequestContext, (int) R.drawable.ic_no_additional_fee);
            }
        }
        if (benefitContent2 != null) {
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) _$_findCachedViewById(R.id.setVoucherInfo);
            if (appCompatTextView3 != null) {
                appCompatTextView3.setText(benefitContent2.MyBillsEntityDataFactory);
            }
            AppCompatTextView appCompatTextView4 = (AppCompatTextView) _$_findCachedViewById(R.id.tvBenefitRemark2);
            if (appCompatTextView4 != null) {
                appCompatTextView4.setText(benefitContent2.PlaceComponentResult);
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.LoggerImplementation);
            if (appCompatImageView2 != null) {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                ExpressPurchaseExtKt.MyBillsEntityDataFactory(appCompatImageView2, context2, benefitContent2.getAuthRequestContext, (int) R.drawable.ic_use_in_available_merchant);
            }
        }
    }
}

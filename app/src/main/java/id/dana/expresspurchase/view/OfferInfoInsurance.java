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
import id.dana.extension.view.InputExtKt;
import id.dana.richview.CurrencyTextView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010B+\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/expresspurchase/view/OfferInfoInsurance;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent;", "content", "", "setupViews", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttribute", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "attrs", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OfferInfoInsurance extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfferInfoInsurance(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfferInfoInsurance(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_offer_info_insurance;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferInfoInsurance(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ OfferInfoInsurance(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferInfoInsurance(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* renamed from: $r8$lambda$668I_NTTxIlOwJG2vNQ-Bkp77VI */
    public static /* synthetic */ void m2588$r8$lambda$668I_NTTxIlOwJG2vNQBkp77VI(OfferInfoInsurance offerInfoInsurance, ExpressPurchaseModel.OfferContent offerContent, View view) {
        Intrinsics.checkNotNullParameter(offerInfoInsurance, "");
        Intrinsics.checkNotNullParameter(offerContent, "");
        Context context = offerInfoInsurance.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context)).getNavigationManager().getAuthRequestContext(offerContent.NetworkUserEntityData$$ExternalSyntheticLambda4, false);
    }

    public final void setupViews(final ExpressPurchaseModel.OfferContent content) {
        Intrinsics.checkNotNullParameter(content, "");
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.BioUtilityBridge_MembersInjector);
        if (appCompatImageView != null) {
            AppCompatImageView appCompatImageView2 = appCompatImageView;
            Context context = appCompatImageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            ExpressPurchaseExtKt.MyBillsEntityDataFactory(appCompatImageView2, context, content.moveToNextValue, (int) R.drawable.ic_illustration_express_purchase_insurance);
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.text_header_offer);
        if (appCompatTextView != null) {
            appCompatTextView.setText(content.NetworkUserEntityData$$ExternalSyntheticLambda8);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.PerformanceNetworkResourceStatusErrorModel);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(content.isLayoutRequested);
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) _$_findCachedViewById(R.id.product_name);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(content.GetContactSyncConfig);
        }
        AppCompatTextView appCompatTextView4 = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a0fd8_loginauthenticationmapper_factory_instanceholder);
        if (appCompatTextView4 != null) {
            appCompatTextView4.setText(content.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
        CurrencyTextView currencyTextView = (CurrencyTextView) _$_findCachedViewById(R.id.product_price);
        if (currencyTextView != null) {
            currencyTextView.setText(content.DatabaseTableConfigUtil);
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) _$_findCachedViewById(R.id.product_detail_icon);
        if (appCompatImageView3 != null) {
            AppCompatImageView appCompatImageView4 = appCompatImageView3;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "");
            ExpressPurchaseExtKt.MyBillsEntityDataFactory(appCompatImageView4, context2, content.BuiltInFictitiousFunctionClassFactory == null ? "" : content.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, (int) R.drawable.ic_benefit_broken_phone);
        }
        AppCompatTextView appCompatTextView5 = (AppCompatTextView) _$_findCachedViewById(R.id.product_detail_title);
        if (appCompatTextView5 != null) {
            ExpressPurchaseModel.OfferContent.BenefitModel benefitModel = content.BuiltInFictitiousFunctionClassFactory;
            appCompatTextView5.setText(benefitModel != null ? benefitModel.BuiltInFictitiousFunctionClassFactory : null);
        }
        AppCompatTextView appCompatTextView6 = (AppCompatTextView) _$_findCachedViewById(R.id.product_detail_subtitle);
        if (appCompatTextView6 != null) {
            ExpressPurchaseModel.OfferContent.BenefitModel benefitModel2 = content.BuiltInFictitiousFunctionClassFactory;
            appCompatTextView6.setText(benefitModel2 != null ? benefitModel2.MyBillsEntityDataFactory : null);
        }
        AppCompatTextView appCompatTextView7 = (AppCompatTextView) _$_findCachedViewById(R.id.product_detail_tnc);
        if (appCompatTextView7 != null) {
            appCompatTextView7.setText(content.MyBillsEntityDataFactory);
            appCompatTextView7.setClickable(true);
            appCompatTextView7.setFocusable(true);
            appCompatTextView7.setOnClickListener(new View.OnClickListener() { // from class: id.dana.expresspurchase.view.OfferInfoInsurance$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OfferInfoInsurance.m2588$r8$lambda$668I_NTTxIlOwJG2vNQBkp77VI(OfferInfoInsurance.this, content, view);
                }
            });
            AppCompatTextView appCompatTextView8 = appCompatTextView7;
            String string = appCompatTextView7.getContext().getString(R.string.tnc);
            Intrinsics.checkNotNullExpressionValue(string, "");
            InputExtKt.PlaceComponentResult(appCompatTextView8, string, false, null, 8);
        }
    }
}

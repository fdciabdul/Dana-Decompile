package id.dana.drawable.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.nearbyme.model.ShopModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aB+\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\n\u001a\u00020\b2\u0019\u0010\t\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/nearbyrevamp/view/NewMerchantAddressInfoView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lkotlin/Function1;", "Lid/dana/nearbyme/model/ShopModel;", "Lkotlin/ParameterName;", "", "onOtherStoreClickListener", "setOtherLocationsListener", "(Lkotlin/jvm/functions/Function1;)V", "setup", "()V", "shopModel", "showAddress", "(Lid/dana/nearbyme/model/ShopModel;)V", "getAuthRequestContext", "Lid/dana/nearbyme/model/ShopModel;", "PlaceComponentResult", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewMerchantAddressInfoView extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private ShopModel PlaceComponentResult;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewMerchantAddressInfoView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewMerchantAddressInfoView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_new_merchant_address_info;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewMerchantAddressInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ NewMerchantAddressInfoView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewMerchantAddressInfoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void showAddress(ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        this.PlaceComponentResult = shopModel;
        TextView textView = (TextView) _$_findCachedViewById(R.id.getISOCountries);
        if (textView != null) {
            Intrinsics.checkNotNullExpressionValue(textView, "");
            String str = shopModel.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult;
            if (!(str == null || str.length() == 0)) {
                textView.setVisibility(0);
                textView.setText(str);
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.getSupportProgressBackgroundTintMode);
        if (textView2 != null) {
            Intrinsics.checkNotNullExpressionValue(textView2, "");
            textView2.setVisibility(shopModel.PlaceComponentResult() ? 0 : 8);
        }
    }

    public final void setOtherLocationsListener(final Function1<? super ShopModel, Unit> onOtherStoreClickListener) {
        Intrinsics.checkNotNullParameter(onOtherStoreClickListener, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.getSupportProgressBackgroundTintMode);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.view.NewMerchantAddressInfoView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewMerchantAddressInfoView.m2749$r8$lambda$SyWMIOKtlVb1D9iY9FKsi3xaRY(NewMerchantAddressInfoView.this, onOtherStoreClickListener, view);
                }
            });
        }
    }

    /* renamed from: $r8$lambda$SyWMIOKtlVb1D9iY-9FKsi3xaRY  reason: not valid java name */
    public static /* synthetic */ void m2749$r8$lambda$SyWMIOKtlVb1D9iY9FKsi3xaRY(NewMerchantAddressInfoView newMerchantAddressInfoView, Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(newMerchantAddressInfoView, "");
        Intrinsics.checkNotNullParameter(function1, "");
        ShopModel shopModel = newMerchantAddressInfoView.PlaceComponentResult;
        if (shopModel != null) {
            function1.invoke(shopModel);
        }
    }
}

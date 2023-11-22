package id.dana.drawable.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016B+\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/nearbyrevamp/view/NearbyPromoDetailView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/nearbyme/model/PromoInfoModel;", "data", "", "setPromoInfoModel", "(Lid/dana/nearbyme/model/PromoInfoModel;)V", "setup", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbyPromoDetailView extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NearbyPromoDetailView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NearbyPromoDetailView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_new_item_promo_nearby;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyPromoDetailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ NearbyPromoDetailView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyPromoDetailView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setPromoInfoModel(id.dana.nearbyme.model.PromoInfoModel r12) {
        /*
            Method dump skipped, instructions count: 682
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.view.NearbyPromoDetailView.setPromoInfoModel(id.dana.nearbyme.model.PromoInfoModel):void");
    }

    private final String KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        String str = p0;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String replace = new Regex(" ").replace(new Regex("\\]").replace(new Regex("\\[").replace(str, ""), ""), "");
        switch (replace.hashCode()) {
            case -64365875:
                return replace.equals("DIRECT_DEBIT_CREDIT_CARD") ? getContext().getString(R.string.promo_payment_method_direct_debit_credit_card) : "";
            case 0:
                return replace.equals("") ? getContext().getString(R.string.all_payment_method) : "";
            case 341392997:
                return replace.equals("ONLINE_CREDIT") ? getContext().getString(R.string.promo_payment_method_online_credit) : "";
            case 378796732:
                return replace.equals("BALANCE") ? getContext().getString(R.string.promo_payment_method_balance) : "";
            case 1079718284:
                return replace.equals("DIRECT_DEBIT_DEBIT_CARD") ? getContext().getString(R.string.promo_payment_method_direct_debit_debit_card) : "";
            case 1280945827:
                return replace.equals("DEBIT_CARD") ? getContext().getString(R.string.promo_payment_method_debit_card) : "";
            case 1878720662:
                return replace.equals("CREDIT_CARD") ? getContext().getString(R.string.promo_payment_method_credit_card) : "";
            case 1883983033:
                return replace.equals("VIRTUAL_ACCOUNT") ? getContext().getString(R.string.promo_payment_method_virtual_account) : "";
            case 1993722918:
                return replace.equals("COUPON") ? getContext().getString(R.string.promo_payment_method_coupon) : "";
            case 2134027076:
                return replace.equals("NET_BANKING") ? getContext().getString(R.string.promo_payment_method_net_banking) : "";
            default:
                return "";
        }
    }
}

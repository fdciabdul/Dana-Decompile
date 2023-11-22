package id.dana.wallet_v3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewWalletSectionHeaderBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0007¢\u0006\u0004\b!\u0010\"B+\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010 \u001a\u00020\u0007\u0012\u0006\u0010#\u001a\u00020\u0007¢\u0006\u0004\b!\u0010$J)\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/wallet_v3/view/WalletSectionHeaderView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewWalletSectionHeaderBinding;", "", "sectionType", "", "isHasNewAsset", "", "assetCount", "getContentString", "(Ljava/lang/String;ZI)Ljava/lang/String;", "getLayout", "()I", "newAssetNinePlusId", "newAssetPluralId", "assetNinePlusId", "assetPluralId", "getNewAssetOrAssetCountNaming", "(ZIIIII)Ljava/lang/String;", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewWalletSectionHeaderBinding;", "", "setTitleHeaderView", "(Ljava/lang/String;)V", "setTotalAssetHeaderView", "(Ljava/lang/String;ZI)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WalletSectionHeaderView extends ViewBindingRichView<ViewWalletSectionHeaderBinding> {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WalletSectionHeaderView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WalletSectionHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
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
        return R.layout.view_wallet_section_header;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletSectionHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ WalletSectionHeaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletSectionHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewWalletSectionHeaderBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewWalletSectionHeaderBinding PlaceComponentResult = ViewWalletSectionHeaderBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void setTitleHeaderView(String sectionType) {
        String str;
        Intrinsics.checkNotNullParameter(sectionType, "");
        switch (sectionType.hashCode()) {
            case -1150817175:
                if (sectionType.equals("FINANCIAL")) {
                    str = getContext().getString(R.string.financial_header_title);
                    break;
                }
                str = null;
                break;
            case -554006299:
                if (sectionType.equals("VOUCHER_AND_TICKET")) {
                    str = getContext().getString(R.string.voucher_and_ticket_header_title);
                    break;
                }
                str = null;
                break;
            case -68698650:
                if (sectionType.equals("PAYMENT")) {
                    str = getContext().getString(R.string.payment_header_title);
                    break;
                }
                str = null;
                break;
            case 646865086:
                if (sectionType.equals("IDENTITY")) {
                    str = getContext().getString(R.string.identity_header_title);
                    break;
                }
                str = null;
                break;
            case 1076711462:
                if (sectionType.equals("LOYALTY")) {
                    str = getContext().getString(R.string.loyalty_header_title);
                    break;
                }
                str = null;
                break;
            default:
                str = null;
                break;
        }
        if (str != null) {
            getBinding().BuiltInFictitiousFunctionClassFactory.setText(str);
        }
    }

    public final void setTotalAssetHeaderView(String sectionType, boolean isHasNewAsset, int assetCount) {
        Intrinsics.checkNotNullParameter(sectionType, "");
        if (assetCount <= 0) {
            getBinding().getAuthRequestContext.setText("");
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
            return;
        }
        if (isHasNewAsset) {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
        } else {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
        }
        String contentString = getContentString(sectionType, isHasNewAsset, assetCount);
        if (contentString != null) {
            getBinding().getAuthRequestContext.setText(contentString);
        }
    }

    private final String getContentString(String sectionType, boolean isHasNewAsset, int assetCount) {
        String valueOf = assetCount > 9 ? "9+" : String.valueOf(assetCount);
        switch (sectionType.hashCode()) {
            case -1150817175:
                if (sectionType.equals("FINANCIAL")) {
                    return isHasNewAsset ? getContext().getString(R.string.financial_header_new_total_assets, valueOf) : getContext().getString(R.string.financial_header_total_assets, valueOf);
                }
                break;
            case -554006299:
                if (sectionType.equals("VOUCHER_AND_TICKET")) {
                    return getNewAssetOrAssetCountNaming(isHasNewAsset, R.string.voucher_and_ticket_header_new_total_assets_nine_plus, R.plurals.f46782131820564, R.string.voucher_and_ticket_header_total_assets_nine_plus, R.plurals.f46792131820565, assetCount);
                }
                break;
            case -68698650:
                if (sectionType.equals("PAYMENT")) {
                    return getNewAssetOrAssetCountNaming(isHasNewAsset, R.string.payment_header_new_total_assets_nine_plus, R.plurals.f46722131820558, R.string.payment_header_total_assets_nine_plus, R.plurals.f46732131820559, assetCount);
                }
                break;
            case 646865086:
                if (sectionType.equals("IDENTITY")) {
                    return getNewAssetOrAssetCountNaming(isHasNewAsset, R.string.payment_header_new_total_assets_nine_plus, R.plurals.f46722131820558, R.string.payment_header_total_assets_nine_plus, R.plurals.f46732131820559, assetCount);
                }
                break;
            case 1076711462:
                if (sectionType.equals("LOYALTY")) {
                    return isHasNewAsset ? getContext().getString(R.string.loyalty_header_new_total_assets, valueOf) : getContext().getString(R.string.loyalty_header_total_assets, valueOf);
                }
                break;
        }
        return null;
    }

    private final String getNewAssetOrAssetCountNaming(boolean isHasNewAsset, int newAssetNinePlusId, int newAssetPluralId, int assetNinePlusId, int assetPluralId, int assetCount) {
        String quantityString;
        if (isHasNewAsset) {
            if (assetCount > 9) {
                quantityString = getContext().getString(newAssetNinePlusId);
            } else {
                quantityString = getContext().getResources().getQuantityString(newAssetPluralId, assetCount, Integer.valueOf(assetCount));
            }
        } else if (assetCount > 9) {
            quantityString = getContext().getString(assetNinePlusId);
        } else {
            quantityString = getContext().getResources().getQuantityString(assetPluralId, assetCount, Integer.valueOf(assetCount));
        }
        Intrinsics.checkNotNullExpressionValue(quantityString, "");
        return quantityString;
    }
}

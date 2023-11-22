package id.dana.wallet_v3.view.walletcardview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.extension.lang.StringExtKt;
import id.dana.richview.wallet.BaseWalletCustomCardView;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.LoyaltyCardModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\nR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/wallet_v3/view/walletcardview/LoyaltyWalletV3CardView;", "Lid/dana/richview/wallet/BaseWalletCustomCardView;", "", "getCardInstId", "()Ljava/lang/CharSequence;", "", "getLayout", "()I", "", "initView", "()V", "invokeListeners", "", "voucherUrl", "Landroid/widget/ImageView;", "voucherType", "loadLogoBasedOnImageType", "(Ljava/lang/String;Landroid/widget/ImageView;)V", "onAttachedToWindow", "setup", "Lid/dana/wallet_v3/model/LoyaltyCardModel$LoyaltyCard;", "loyaltyAssetModel", "Lid/dana/wallet_v3/model/LoyaltyCardModel$LoyaltyCard;", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "onLoyaltyClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;Lid/dana/wallet_v3/model/LoyaltyCardModel$LoyaltyCard;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LoyaltyWalletV3CardView extends BaseWalletCustomCardView {
    public Map<Integer, View> _$_findViewCache;
    private final LoyaltyCardModel.LoyaltyCard loyaltyAssetModel;
    private final WalletCardAssetClickListener onLoyaltyClickListener;

    @Override // id.dana.richview.wallet.BaseWalletCustomCardView, id.dana.richview.wallet.BaseWalletCardView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.richview.wallet.BaseWalletCustomCardView, id.dana.richview.wallet.BaseWalletCardView
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

    @Override // id.dana.component.BaseRichView
    public final int getLayout() {
        return R.layout.loyalty_wallet_v3_card;
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoyaltyWalletV3CardView(Context context, WalletCardAssetClickListener walletCardAssetClickListener, LoyaltyCardModel.LoyaltyCard loyaltyCard) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(loyaltyCard, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onLoyaltyClickListener = walletCardAssetClickListener;
        this.loyaltyAssetModel = loyaltyCard;
    }

    public /* synthetic */ LoyaltyWalletV3CardView(Context context, WalletCardAssetClickListener walletCardAssetClickListener, LoyaltyCardModel.LoyaltyCard loyaltyCard, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : walletCardAssetClickListener, loyaltyCard);
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final CharSequence getCardInstId() {
        return this.loyaltyAssetModel.getPocketId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        initView();
    }

    private final void initView() {
        ((TextView) _$_findCachedViewById(R.id.tv_pocket_loyalty_points_value)).setText(this.loyaltyAssetModel.getPoint());
        ((TextView) _$_findCachedViewById(R.id.tv_pocket_loyalty_number)).setText(this.loyaltyAssetModel.getCardNumber());
        String PlaceComponentResult = StringExtKt.PlaceComponentResult(this.loyaltyAssetModel.getBackgroundUrl());
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.iv_pocket_loyalty_background);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        loadLogoBasedOnImageType(PlaceComponentResult, appCompatImageView);
        String PlaceComponentResult2 = StringExtKt.PlaceComponentResult(this.loyaltyAssetModel.getLogoUrl());
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.iv_pocket_loyalty);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
        loadLogoBasedOnImageType(PlaceComponentResult2, appCompatImageView2);
        MaterialCardView materialCardView = (MaterialCardView) _$_findCachedViewById(R.id.cv_pocket_loyalty);
        Intrinsics.checkNotNullExpressionValue(materialCardView, "");
        setToGrayScale(materialCardView, this.loyaltyAssetModel.getIsUsed());
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final void invokeListeners() {
        WalletCardAssetClickListener walletCardAssetClickListener = this.onLoyaltyClickListener;
        if (walletCardAssetClickListener != null) {
            walletCardAssetClickListener.onCardClicked(this.loyaltyAssetModel);
        }
    }

    private final void loadLogoBasedOnImageType(String voucherUrl, ImageView voucherType) {
        if (SvgLoader.getAuthRequestContext(voucherUrl)) {
            SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = voucherUrl;
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = true;
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = voucherType;
            new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
            return;
        }
        Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getAuthRequestContext(voucherUrl).MyBillsEntityDataFactory(voucherType);
    }
}

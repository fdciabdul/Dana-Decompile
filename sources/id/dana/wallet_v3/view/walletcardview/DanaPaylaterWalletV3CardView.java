package id.dana.wallet_v3.view.walletcardview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import id.dana.R;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.richview.wallet.BaseWalletDefaultCardView;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.PaymentCardModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/wallet_v3/view/walletcardview/DanaPaylaterWalletV3CardView;", "Lid/dana/richview/wallet/BaseWalletDefaultCardView;", "", "getBackgroundDrawableRes", "()I", "", "getBackgroundUrl", "()Ljava/lang/String;", "getCardContentLayout", "getCardInstId", "Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "getWalletCardListener", "()Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "", "initView", "()V", "onAttachedToWindow", CdpConstants.CONTENT_TEXT_COLOR, "setTextColor", "(I)V", "Lid/dana/wallet_v3/model/PaymentCardModel$PaylaterCard;", "card", "Lid/dana/wallet_v3/model/PaymentCardModel$PaylaterCard;", "getCard", "()Lid/dana/wallet_v3/model/PaymentCardModel$PaylaterCard;", "", "isTextColorUpdated", "Z", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "onPaylaterClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;Lid/dana/wallet_v3/model/PaymentCardModel$PaylaterCard;Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DanaPaylaterWalletV3CardView extends BaseWalletDefaultCardView {
    public Map<Integer, View> _$_findViewCache;
    private final PaymentCardModel.PaylaterCard card;
    private boolean isTextColorUpdated;
    private final WalletCardAssetClickListener onPaylaterClickListener;

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView, id.dana.richview.wallet.BaseWalletCardView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView, id.dana.richview.wallet.BaseWalletCardView
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

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView
    public final int getCardContentLayout() {
        return R.layout.dana_paylater_wallet_v3_card;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaPaylaterWalletV3CardView(Context context, PaymentCardModel.PaylaterCard paylaterCard, WalletCardAssetClickListener walletCardAssetClickListener) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(paylaterCard, "");
        this._$_findViewCache = new LinkedHashMap();
        this.card = paylaterCard;
        this.onPaylaterClickListener = walletCardAssetClickListener;
    }

    public /* synthetic */ DanaPaylaterWalletV3CardView(Context context, PaymentCardModel.PaylaterCard paylaterCard, WalletCardAssetClickListener walletCardAssetClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, paylaterCard, (i & 4) != 0 ? null : walletCardAssetClickListener);
    }

    @JvmName(name = "getCard")
    public final PaymentCardModel.PaylaterCard getCard() {
        return this.card;
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView
    public final BaseWalletDefaultCardView.WalletCardListener getWalletCardListener() {
        return new BaseWalletDefaultCardView.WalletCardListener() { // from class: id.dana.wallet_v3.view.walletcardview.DanaPaylaterWalletV3CardView$getWalletCardListener$1
            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final /* synthetic */ void onCardHold() {
                BaseWalletDefaultCardView.WalletCardListener.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final void onCardClicked() {
                WalletCardAssetClickListener walletCardAssetClickListener;
                walletCardAssetClickListener = DanaPaylaterWalletV3CardView.this.onPaylaterClickListener;
                if (walletCardAssetClickListener != null) {
                    walletCardAssetClickListener.onCardClicked(DanaPaylaterWalletV3CardView.this.getCard());
                }
            }

            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final void onUpdateTextColor(int textColor) {
                boolean z;
                z = DanaPaylaterWalletV3CardView.this.isTextColorUpdated;
                if (z) {
                    return;
                }
                DanaPaylaterWalletV3CardView.this.isTextColorUpdated = true;
                DanaPaylaterWalletV3CardView.this.setTextColor(textColor);
            }
        };
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView
    public final int getBackgroundDrawableRes() {
        return this.card.getPayCardViewItem().BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView
    public final String getBackgroundUrl() {
        return this.card.getCardBackground();
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final String getCardInstId() {
        return this.card.getId();
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        initView();
    }

    private final void initView() {
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43((AppCompatImageView) _$_findCachedViewById(R.id.TextInputLayout$1), this.card.getPayCardViewItem().KClassImpl$Data$declaredNonStaticMembers$2);
        if (!this.isTextColorUpdated) {
            setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), this.card.getPayCardViewItem().scheduleImpl));
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_content);
        if (appCompatTextView != null) {
            MoneyView balance = this.card.getBalance();
            appCompatTextView.setText(balance != null ? balance.getAmount() : null);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_currency);
        if (appCompatTextView2 != null) {
            MoneyView balance2 = this.card.getBalance();
            appCompatTextView2.setText(balance2 != null ? balance2.getCurrency() : null);
        }
    }

    public final void setTextColor(int r2) {
        ((TextView) _$_findCachedViewById(R.id.tv_remaining_limit)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_currency)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_content)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a17ff_r8_lambda_vxzbshfvlfxuzu2egutjia0_mou)).setTextColor(r2);
    }
}

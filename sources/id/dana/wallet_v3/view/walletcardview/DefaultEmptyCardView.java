package id.dana.wallet_v3.view.walletcardview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.richview.EllipseTextView;
import id.dana.richview.wallet.BaseWalletDefaultCardView;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B#\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/wallet_v3/view/walletcardview/DefaultEmptyCardView;", "Lid/dana/richview/wallet/BaseWalletDefaultCardView;", "", "getBackgroundDrawableRes", "()I", "", "getBackgroundUrl", "()Ljava/lang/String;", "getCardContentLayout", "", "getCardInstId", "()Ljava/lang/CharSequence;", "getIconDrawableRes", "Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "getWalletCardListener", "()Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "", "initView", "()V", "onAttachedToWindow", "setupCardContentDescription", "setupContent", "cardType", "Ljava/lang/String;", "getCardType", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;Ljava/lang/String;Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DefaultEmptyCardView extends BaseWalletDefaultCardView {
    private static final String EMPTY_CARD_RATIO = "343:143";
    public Map<Integer, View> _$_findViewCache;
    private final String cardType;
    private final WalletCardAssetClickListener walletCardAssetClickListener;

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
    public final int getBackgroundDrawableRes() {
        return R.drawable.bg_outline_grey_20_rad_9;
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView
    public final String getBackgroundUrl() {
        return "";
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView
    public final int getCardContentLayout() {
        return R.layout.empty_state_wallet_v3_card;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultEmptyCardView(Context context, String str, WalletCardAssetClickListener walletCardAssetClickListener) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        this._$_findViewCache = new LinkedHashMap();
        this.cardType = str;
        this.walletCardAssetClickListener = walletCardAssetClickListener;
    }

    public /* synthetic */ DefaultEmptyCardView(Context context, String str, WalletCardAssetClickListener walletCardAssetClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? null : walletCardAssetClickListener);
    }

    @JvmName(name = "getCardType")
    public final String getCardType() {
        return this.cardType;
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView
    public final BaseWalletDefaultCardView.WalletCardListener getWalletCardListener() {
        return new BaseWalletDefaultCardView.WalletCardListener() { // from class: id.dana.wallet_v3.view.walletcardview.DefaultEmptyCardView$getWalletCardListener$1
            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final /* synthetic */ void onCardHold() {
                BaseWalletDefaultCardView.WalletCardListener.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final /* synthetic */ void onUpdateTextColor(int i) {
                BaseWalletDefaultCardView.WalletCardListener.CC.PlaceComponentResult();
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x004e, code lost:
            
                r1 = r28.this$0.walletCardAssetClickListener;
             */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x0091, code lost:
            
                r1 = r28.this$0.walletCardAssetClickListener;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x00ac, code lost:
            
                r1 = r28.this$0.walletCardAssetClickListener;
             */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x00c7, code lost:
            
                r1 = r28.this$0.walletCardAssetClickListener;
             */
            /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
            
                r1 = r28.this$0.walletCardAssetClickListener;
             */
            /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void onCardClicked() {
                /*
                    Method dump skipped, instructions count: 240
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.walletcardview.DefaultEmptyCardView$getWalletCardListener$1.onCardClicked():void");
            }
        };
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final CharSequence getCardInstId() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        initView();
    }

    private final void initView() {
        setupContent();
        setupCardContentDescription();
        setCustomCardRatio(EMPTY_CARD_RATIO);
    }

    private final void setupCardContentDescription() {
        String str = this.cardType;
        switch (str.hashCode()) {
            case -1150817175:
                if (str.equals("FINANCIAL")) {
                    String string = getContext().getString(R.string.wallet_img_empty_card_financial);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    setCardContentDescription(string);
                    return;
                }
                return;
            case -554006299:
                if (str.equals("VOUCHER_AND_TICKET")) {
                    String string2 = getContext().getString(R.string.wallet_img_empty_card_voucher);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    setCardContentDescription(string2);
                    return;
                }
                return;
            case 646865086:
                if (str.equals("IDENTITY")) {
                    String string3 = getContext().getString(R.string.wallet_img_empty_ktp_card_identity);
                    Intrinsics.checkNotNullExpressionValue(string3, "");
                    setCardContentDescription(string3);
                    return;
                }
                return;
            case 1076711462:
                if (str.equals("LOYALTY")) {
                    String string4 = getContext().getString(R.string.wallet_img_empty_card_loyalty);
                    Intrinsics.checkNotNullExpressionValue(string4, "");
                    setCardContentDescription(string4);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final int getIconDrawableRes() {
        String str = this.cardType;
        switch (str.hashCode()) {
            case -1150817175:
                if (str.equals("FINANCIAL")) {
                    return R.drawable.ic_investment;
                }
                break;
            case -554006299:
                if (str.equals("VOUCHER_AND_TICKET")) {
                    return R.drawable.ic_voucher;
                }
                break;
            case -68698650:
                str.equals("PAYMENT");
                break;
            case 646865086:
                if (str.equals("IDENTITY")) {
                    return R.drawable.ic_identity;
                }
                break;
            case 1076711462:
                if (str.equals("LOYALTY")) {
                    return R.drawable.ic_loyalty;
                }
                break;
        }
        return R.drawable.ic_payment;
    }

    private final void setupContent() {
        String str = this.cardType;
        switch (str.hashCode()) {
            case -1150817175:
                if (str.equals("FINANCIAL")) {
                    ((AppCompatTextView) _$_findCachedViewById(R.id.getLogSourceName)).setText(getContext().getString(R.string.empty_state_investment_title_v3));
                    ((AppCompatTextView) _$_findCachedViewById(R.id.setupWithViewPager)).setText(getContext().getString(R.string.empty_state_investment_desc_v3));
                    break;
                }
                break;
            case -554006299:
                if (str.equals("VOUCHER_AND_TICKET")) {
                    ((AppCompatTextView) _$_findCachedViewById(R.id.getLogSourceName)).setText(getContext().getString(R.string.empty_state_voucher_cards_title_v3));
                    ((AppCompatTextView) _$_findCachedViewById(R.id.setupWithViewPager)).setText(getContext().getString(R.string.empty_state_voucher_cards_desc_v3));
                    ((EllipseTextView) _$_findCachedViewById(R.id.etv_add)).setText(getContext().getString(R.string.empty_state_purchase_button));
                    break;
                }
                break;
            case -68698650:
                if (str.equals("PAYMENT")) {
                    ((AppCompatTextView) _$_findCachedViewById(R.id.getLogSourceName)).setText(getContext().getString(R.string.empty_state_bank_cards_title_v3));
                    ((AppCompatTextView) _$_findCachedViewById(R.id.setupWithViewPager)).setText(getContext().getString(R.string.empty_state_bank_cards_desc_v3));
                    break;
                }
                break;
            case 646865086:
                if (str.equals("IDENTITY")) {
                    ((AppCompatTextView) _$_findCachedViewById(R.id.getLogSourceName)).setText(getContext().getString(R.string.empty_state_identity_cards_title_v3));
                    ((AppCompatTextView) _$_findCachedViewById(R.id.setupWithViewPager)).setText(getContext().getString(R.string.empty_state_identity_cards_desc_v3));
                    break;
                }
                break;
            case 1076711462:
                if (str.equals("LOYALTY")) {
                    ((AppCompatTextView) _$_findCachedViewById(R.id.getLogSourceName)).setText(getContext().getString(R.string.empty_state_loyalty_title_v3));
                    ((AppCompatTextView) _$_findCachedViewById(R.id.setupWithViewPager)).setText(getContext().getString(R.string.empty_state_loyalty_desc_v3));
                    break;
                }
                break;
        }
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43((AppCompatImageView) _$_findCachedViewById(R.id.GetLeaderboardEntryBanner), getIconDrawableRes());
    }
}

package id.dana.wallet_v3.view.walletcardview;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import id.dana.R;
import id.dana.domain.investment.model.MultiCurrencyMoneyView;
import id.dana.richview.wallet.BaseWalletDefaultCardView;
import id.dana.utils.BalanceUtil;
import id.dana.utils.LocaleUtil;
import id.dana.wallet_v3.constant.WalletConstant;
import id.dana.wallet_v3.listener.DanaPlusClickListener;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.InvestmentCardModel;
import id.dana.wallet_v3.util.WalletV3ToastUtilKt;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B9\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b6\u00107J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0012\u0010\u000fJ\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u000fJ\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001c\u0010\u000fJ\u000f\u0010\u001d\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001d\u0010\u000fJ\u000f\u0010\u001e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001e\u0010\u000fR\u0017\u0010 \u001a\u00020\u001f8\u0007¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u0004\u0018\u00010$8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u0004\u0018\u00010\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001f\u00100\u001a\u0006*\u00020+0+8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00102\u001a\u0004\u0018\u0001018\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b2\u00103"}, d2 = {"Lid/dana/wallet_v3/view/walletcardview/DanaPlusWalletV3CardView;", "Lid/dana/richview/wallet/BaseWalletDefaultCardView;", "", "getBackgroundDrawableRes", "()I", "", "getBackgroundUrl", "()Ljava/lang/String;", "getCardContentLayout", "getCardInstId", "Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "getWalletCardListener", "()Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "", "hideBalance", "()V", "initView", "invokeListeners", "onAttachedToWindow", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "setBalanveVisibilityClickListener", CdpConstants.CONTENT_TEXT_COLOR, "setTextColor", "(I)V", "showBalance", "updateBalanceVisibility", "updateShowHideTouchDelegate", "Lid/dana/wallet_v3/model/InvestmentCardModel$DanaPlusCard;", "card", "Lid/dana/wallet_v3/model/InvestmentCardModel$DanaPlusCard;", "getCard", "()Lid/dana/wallet_v3/model/InvestmentCardModel$DanaPlusCard;", "Lid/dana/wallet_v3/listener/DanaPlusClickListener;", "danaPlusClickListener", "Lid/dana/wallet_v3/listener/DanaPlusClickListener;", "isBalanceVisible", "Ljava/lang/Boolean;", "isTextColorUpdated", "Z", "Ljava/util/Locale;", "locale$delegate", "Lkotlin/Lazy;", "getLocale", "()Ljava/util/Locale;", "locale", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;Lid/dana/wallet_v3/model/InvestmentCardModel$DanaPlusCard;Ljava/lang/Boolean;Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;Lid/dana/wallet_v3/listener/DanaPlusClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DanaPlusWalletV3CardView extends BaseWalletDefaultCardView {
    public Map<Integer, View> _$_findViewCache;
    private final InvestmentCardModel.DanaPlusCard card;
    private final DanaPlusClickListener danaPlusClickListener;
    private final Boolean isBalanceVisible;
    private boolean isTextColorUpdated;

    /* renamed from: locale$delegate  reason: from kotlin metadata */
    private final Lazy locale;
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
    public final int getCardContentLayout() {
        return R.layout.dana_plus_wallet_v3_card;
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaPlusWalletV3CardView(Context context, InvestmentCardModel.DanaPlusCard danaPlusCard, Boolean bool, WalletCardAssetClickListener walletCardAssetClickListener, DanaPlusClickListener danaPlusClickListener) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(danaPlusCard, "");
        this._$_findViewCache = new LinkedHashMap();
        this.card = danaPlusCard;
        this.isBalanceVisible = bool;
        this.walletCardAssetClickListener = walletCardAssetClickListener;
        this.danaPlusClickListener = danaPlusClickListener;
        this.locale = LazyKt.lazy(new Function0<Locale>() { // from class: id.dana.wallet_v3.view.walletcardview.DanaPlusWalletV3CardView$locale$2
            @Override // kotlin.jvm.functions.Function0
            public final Locale invoke() {
                return LocaleUtil.getAuthRequestContext();
            }
        });
    }

    public /* synthetic */ DanaPlusWalletV3CardView(Context context, InvestmentCardModel.DanaPlusCard danaPlusCard, Boolean bool, WalletCardAssetClickListener walletCardAssetClickListener, DanaPlusClickListener danaPlusClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, danaPlusCard, bool, (i & 8) != 0 ? null : walletCardAssetClickListener, (i & 16) != 0 ? null : danaPlusClickListener);
    }

    @JvmName(name = "getCard")
    public final InvestmentCardModel.DanaPlusCard getCard() {
        return this.card;
    }

    @JvmName(name = "getLocale")
    private final Locale getLocale() {
        return (Locale) this.locale.getValue();
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView
    public final BaseWalletDefaultCardView.WalletCardListener getWalletCardListener() {
        return new BaseWalletDefaultCardView.WalletCardListener() { // from class: id.dana.wallet_v3.view.walletcardview.DanaPlusWalletV3CardView$getWalletCardListener$1
            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final /* synthetic */ void onCardHold() {
                BaseWalletDefaultCardView.WalletCardListener.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final void onCardClicked() {
                WalletCardAssetClickListener walletCardAssetClickListener;
                walletCardAssetClickListener = DanaPlusWalletV3CardView.this.walletCardAssetClickListener;
                if (walletCardAssetClickListener != null) {
                    walletCardAssetClickListener.onCardClicked(DanaPlusWalletV3CardView.this.getCard());
                }
            }

            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final void onUpdateTextColor(int textColor) {
                boolean z;
                z = DanaPlusWalletV3CardView.this.isTextColorUpdated;
                if (z) {
                    return;
                }
                DanaPlusWalletV3CardView.this.isTextColorUpdated = true;
                DanaPlusWalletV3CardView.this.setTextColor(textColor);
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
        updateShowHideTouchDelegate();
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView, id.dana.richview.wallet.BaseWalletCardView
    public final void invokeListeners() {
        WalletCardAssetClickListener walletCardAssetClickListener = this.walletCardAssetClickListener;
        if (walletCardAssetClickListener != null) {
            walletCardAssetClickListener.onCardClicked(this.card);
        }
    }

    private final void initView() {
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43((AppCompatImageView) _$_findCachedViewById(R.id.TextInputLayout$1), this.card.getPayCardViewItem().KClassImpl$Data$declaredNonStaticMembers$2);
        if (!this.isTextColorUpdated) {
            setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), this.card.getPayCardViewItem().scheduleImpl));
        }
        ((ConstraintLayout) _$_findCachedViewById(R.id.cl_dana_plus)).setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.wallet_v3.view.walletcardview.DanaPlusWalletV3CardView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean m3129initView$lambda0;
                m3129initView$lambda0 = DanaPlusWalletV3CardView.m3129initView$lambda0(DanaPlusWalletV3CardView.this, view, motionEvent);
                return m3129initView$lambda0;
            }
        });
        setBalanveVisibilityClickListener();
        updateBalanceVisibility();
    }

    /* renamed from: initView$lambda-0 */
    public static final boolean m3129initView$lambda0(DanaPlusWalletV3CardView danaPlusWalletV3CardView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(danaPlusWalletV3CardView, "");
        return danaPlusWalletV3CardView.getGestureDetector().onTouchEvent(motionEvent);
    }

    private final void updateShowHideTouchDelegate() {
        ViewParent parent = ((AppCompatImageView) _$_findCachedViewById(R.id.OkHttpExporterBuilder)).getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        final View view = (View) parent;
        view.post(new Runnable() { // from class: id.dana.wallet_v3.view.walletcardview.DanaPlusWalletV3CardView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DanaPlusWalletV3CardView.m3131updateShowHideTouchDelegate$lambda1(DanaPlusWalletV3CardView.this, view);
            }
        });
    }

    /* renamed from: updateShowHideTouchDelegate$lambda-1 */
    public static final void m3131updateShowHideTouchDelegate$lambda1(DanaPlusWalletV3CardView danaPlusWalletV3CardView, View view) {
        Intrinsics.checkNotNullParameter(danaPlusWalletV3CardView, "");
        Intrinsics.checkNotNullParameter(view, "");
        Rect rect = new Rect();
        ((AppCompatImageView) danaPlusWalletV3CardView._$_findCachedViewById(R.id.OkHttpExporterBuilder)).getHitRect(rect);
        rect.top -= 10;
        rect.left -= 10;
        rect.bottom += 10;
        rect.right += 10;
        view.setTouchDelegate(new TouchDelegate(rect, (AppCompatImageView) danaPlusWalletV3CardView._$_findCachedViewById(R.id.OkHttpExporterBuilder)));
    }

    private final void setBalanveVisibilityClickListener() {
        ((AppCompatImageView) _$_findCachedViewById(R.id.OkHttpExporterBuilder)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.walletcardview.DanaPlusWalletV3CardView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanaPlusWalletV3CardView.m3130setBalanveVisibilityClickListener$lambda3(DanaPlusWalletV3CardView.this, view);
            }
        });
    }

    /* renamed from: setBalanveVisibilityClickListener$lambda-3 */
    public static final void m3130setBalanveVisibilityClickListener$lambda3(DanaPlusWalletV3CardView danaPlusWalletV3CardView, View view) {
        Intrinsics.checkNotNullParameter(danaPlusWalletV3CardView, "");
        if (danaPlusWalletV3CardView.isBalanceVisible != null) {
            DanaPlusClickListener danaPlusClickListener = danaPlusWalletV3CardView.danaPlusClickListener;
            if (danaPlusClickListener != null) {
                danaPlusClickListener.onBalanceVisibilityClicked(!r0.booleanValue());
            }
            Context context = danaPlusWalletV3CardView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            WalletV3ToastUtilKt.vibrateWhenShowHideBalance(context);
        }
    }

    private final void updateBalanceVisibility() {
        if (Intrinsics.areEqual(this.isBalanceVisible, Boolean.TRUE)) {
            showBalance();
        } else {
            hideBalance();
        }
    }

    private final void hideBalance() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_content);
        if (appCompatTextView != null) {
            appCompatTextView.setText(WalletConstant.SECURE_TEXT);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.OkHttpExporterBuilder);
        if (appCompatImageView != null) {
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, R.drawable.ic_visibility_show_outlined);
            appCompatImageView.setContentDescription(appCompatImageView.getContext().getString(R.string.wallet_ic_eye_balance));
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.tv_total_gain_content);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(WalletConstant.SECURE_TEXT);
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) _$_findCachedViewById(R.id.tv_gain_content);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(WalletConstant.SECURE_TEXT);
        }
    }

    private final void showBalance() {
        String format;
        Long amount;
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_content);
        if (appCompatTextView != null) {
            Locale locale = getLocale();
            MultiCurrencyMoneyView availableBalance = this.card.getAvailableBalance();
            format = NumberFormat.getNumberInstance(locale).format((availableBalance == null || (amount = availableBalance.getAmount()) == null) ? 0L : amount.longValue());
            appCompatTextView.setText(format);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.OkHttpExporterBuilder);
        if (appCompatImageView != null) {
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, R.drawable.ic_visibility_hide_outlined);
            appCompatImageView.setContentDescription(appCompatImageView.getContext().getString(R.string.wallet_ic_hide_balance));
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.tv_total_gain_content);
        if (appCompatTextView2 != null) {
            MultiCurrencyMoneyView totalGainLossAmount = this.card.getTotalGainLossAmount();
            appCompatTextView2.setText(BalanceUtil.BuiltInFictitiousFunctionClassFactory(String.valueOf(totalGainLossAmount != null ? totalGainLossAmount.getAmount() : null)));
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) _$_findCachedViewById(R.id.tv_gain_content);
        if (appCompatTextView3 != null) {
            MultiCurrencyMoneyView dailyGainLossAmount = this.card.getDailyGainLossAmount();
            appCompatTextView3.setText(BalanceUtil.BuiltInFictitiousFunctionClassFactory(String.valueOf(dailyGainLossAmount != null ? dailyGainLossAmount.getAmount() : null)));
        }
    }

    public final void setTextColor(int r2) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tv_title_balance);
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(r2);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_currency);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setTextColor(r2);
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_content);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setTextColor(r2);
        }
    }
}

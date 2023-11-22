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
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import id.dana.R;
import id.dana.richview.wallet.BaseWalletDefaultCardView;
import id.dana.utils.LocaleUtil;
import id.dana.wallet_v3.constant.WalletConstant;
import id.dana.wallet_v3.listener.DanaEmasClickListener;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.InvestmentCardModel;
import id.dana.wallet_v3.util.WalletV3ToastUtilKt;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u00100\u001a\u00020\u000b\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b>\u0010?J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0019\u0010\u0017J\u0019\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0015H\u0002¢\u0006\u0004\b$\u0010\u0017J\u000f\u0010%\u001a\u00020\u0015H\u0002¢\u0006\u0004\b%\u0010\u0017J\u000f\u0010&\u001a\u00020\u0015H\u0002¢\u0006\u0004\b&\u0010\u0017J\u000f\u0010'\u001a\u00020\u0015H\u0002¢\u0006\u0004\b'\u0010\u0017R\u0017\u0010)\u001a\u00020(8\u0007¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u0010.\u001a\u0004\u0018\u00010-8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b2\u00101R\u001f\u00108\u001a\u0006*\u000203038CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u0010:\u001a\u0004\u0018\u0001098\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b:\u0010;"}, d2 = {"Lid/dana/wallet_v3/view/walletcardview/DanaEmasWalletV3CardView;", "Lid/dana/richview/wallet/BaseWalletDefaultCardView;", "", "getBackgroundDrawableRes", "()I", "", "getBackgroundUrl", "()Ljava/lang/String;", "getCardContentLayout", "getCardInstId", "value", "", "isProfit", "getFormatedPercentageProfit", "(Ljava/lang/String;Z)Ljava/lang/String;", "", "getRoundedToTwoDecimalBehind", "(D)Ljava/lang/String;", "Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "getWalletCardListener", "()Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "", "hideBalance", "()V", "initView", "onAttachedToWindow", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "text", "setProfitCashContentText", "(Ljava/lang/String;)V", CdpConstants.CONTENT_TEXT_COLOR, "setTextColor", "(I)V", "setVisibilityIconContentDescription", "showBalance", "updateBalanceVisibility", "updateShowHideTouchDelegate", "Lid/dana/wallet_v3/model/InvestmentCardModel$EmasCard;", "card", "Lid/dana/wallet_v3/model/InvestmentCardModel$EmasCard;", "getCard", "()Lid/dana/wallet_v3/model/InvestmentCardModel$EmasCard;", "Lid/dana/wallet_v3/listener/DanaEmasClickListener;", "danaEmasClickListener", "Lid/dana/wallet_v3/listener/DanaEmasClickListener;", "isBalanceVisible", "Z", "isTextColorUpdated", "Ljava/util/Locale;", "locale$delegate", "Lkotlin/Lazy;", "getLocale", "()Ljava/util/Locale;", "locale", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "onEmasClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;Lid/dana/wallet_v3/model/InvestmentCardModel$EmasCard;ZLid/dana/wallet_v3/listener/WalletCardAssetClickListener;Lid/dana/wallet_v3/listener/DanaEmasClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DanaEmasWalletV3CardView extends BaseWalletDefaultCardView {
    public Map<Integer, View> _$_findViewCache;
    private final InvestmentCardModel.EmasCard card;
    private final DanaEmasClickListener danaEmasClickListener;
    private final boolean isBalanceVisible;
    private boolean isTextColorUpdated;

    /* renamed from: locale$delegate  reason: from kotlin metadata */
    private final Lazy locale;
    private final WalletCardAssetClickListener onEmasClickListener;

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
        return R.layout.dana_emas_wallet_v3_card;
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaEmasWalletV3CardView(Context context, InvestmentCardModel.EmasCard emasCard, boolean z, WalletCardAssetClickListener walletCardAssetClickListener, DanaEmasClickListener danaEmasClickListener) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(emasCard, "");
        this._$_findViewCache = new LinkedHashMap();
        this.card = emasCard;
        this.isBalanceVisible = z;
        this.onEmasClickListener = walletCardAssetClickListener;
        this.danaEmasClickListener = danaEmasClickListener;
        this.locale = LazyKt.lazy(new Function0<Locale>() { // from class: id.dana.wallet_v3.view.walletcardview.DanaEmasWalletV3CardView$locale$2
            @Override // kotlin.jvm.functions.Function0
            public final Locale invoke() {
                return LocaleUtil.getAuthRequestContext();
            }
        });
    }

    public /* synthetic */ DanaEmasWalletV3CardView(Context context, InvestmentCardModel.EmasCard emasCard, boolean z, WalletCardAssetClickListener walletCardAssetClickListener, DanaEmasClickListener danaEmasClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, emasCard, z, (i & 8) != 0 ? null : walletCardAssetClickListener, (i & 16) != 0 ? null : danaEmasClickListener);
    }

    @JvmName(name = "getCard")
    public final InvestmentCardModel.EmasCard getCard() {
        return this.card;
    }

    @JvmName(name = "getLocale")
    private final Locale getLocale() {
        return (Locale) this.locale.getValue();
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView
    public final BaseWalletDefaultCardView.WalletCardListener getWalletCardListener() {
        return new BaseWalletDefaultCardView.WalletCardListener() { // from class: id.dana.wallet_v3.view.walletcardview.DanaEmasWalletV3CardView$getWalletCardListener$1
            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final /* synthetic */ void onCardHold() {
                BaseWalletDefaultCardView.WalletCardListener.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final void onCardClicked() {
                WalletCardAssetClickListener walletCardAssetClickListener;
                walletCardAssetClickListener = DanaEmasWalletV3CardView.this.onEmasClickListener;
                if (walletCardAssetClickListener != null) {
                    walletCardAssetClickListener.onCardClicked(DanaEmasWalletV3CardView.this.getCard());
                }
            }

            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final void onUpdateTextColor(int textColor) {
                boolean z;
                z = DanaEmasWalletV3CardView.this.isTextColorUpdated;
                if (z) {
                    return;
                }
                DanaEmasWalletV3CardView.this.isTextColorUpdated = true;
                DanaEmasWalletV3CardView.this.setTextColor(textColor);
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

    private final void initView() {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.TextInputLayout$1);
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, this.card.getPayCardViewItem().KClassImpl$Data$declaredNonStaticMembers$2);
        appCompatImageView.setContentDescription(appCompatImageView.getContext().getString(R.string.wallet_img_logo_emas_financial));
        if (!this.isTextColorUpdated) {
            setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), this.card.getPayCardViewItem().scheduleImpl));
        }
        setVisibilityIconContentDescription();
        ((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0436_daggerglobalsearchbottomsheetcomponent_globalsearchbottomsheetcomponentimpl_providefeedsconfigrepositoryprovider)).setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.wallet_v3.view.walletcardview.DanaEmasWalletV3CardView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean m3122initView$lambda1;
                m3122initView$lambda1 = DanaEmasWalletV3CardView.m3122initView$lambda1(DanaEmasWalletV3CardView.this, view, motionEvent);
                return m3122initView$lambda1;
            }
        });
        Group group = (Group) _$_findCachedViewById(R.id.res_0x7f0a07ed_daggerpaymethodcomponent_paymethodcomponentimpl_featureconfigrepositoryprovider);
        if (group != null) {
            group.setVisibility(8);
        }
        ((AppCompatImageView) _$_findCachedViewById(R.id.OkHttpExporterBuilder)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.walletcardview.DanaEmasWalletV3CardView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanaEmasWalletV3CardView.m3123initView$lambda2(DanaEmasWalletV3CardView.this, view);
            }
        });
        updateBalanceVisibility();
    }

    /* renamed from: initView$lambda-1 */
    public static final boolean m3122initView$lambda1(DanaEmasWalletV3CardView danaEmasWalletV3CardView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(danaEmasWalletV3CardView, "");
        return danaEmasWalletV3CardView.getGestureDetector().onTouchEvent(motionEvent);
    }

    /* renamed from: initView$lambda-2 */
    public static final void m3123initView$lambda2(DanaEmasWalletV3CardView danaEmasWalletV3CardView, View view) {
        Intrinsics.checkNotNullParameter(danaEmasWalletV3CardView, "");
        DanaEmasClickListener danaEmasClickListener = danaEmasWalletV3CardView.danaEmasClickListener;
        if (danaEmasClickListener != null) {
            danaEmasClickListener.onBalanceVisibilityClicked(!danaEmasWalletV3CardView.isBalanceVisible);
        }
        Context context = danaEmasWalletV3CardView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        WalletV3ToastUtilKt.vibrateWhenShowHideBalance(context);
        danaEmasWalletV3CardView.setVisibilityIconContentDescription();
    }

    private final void setVisibilityIconContentDescription() {
        String string;
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.OkHttpExporterBuilder);
        if (this.isBalanceVisible) {
            string = getContext().getString(R.string.wallet_ic_cross_eye_emas_financial);
        } else {
            string = getContext().getString(R.string.wallet_ic_eye_emas_financial);
        }
        appCompatImageView.setContentDescription(string);
    }

    private final void updateShowHideTouchDelegate() {
        ViewParent parent = ((AppCompatImageView) _$_findCachedViewById(R.id.OkHttpExporterBuilder)).getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        final View view = (View) parent;
        view.post(new Runnable() { // from class: id.dana.wallet_v3.view.walletcardview.DanaEmasWalletV3CardView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DanaEmasWalletV3CardView.m3124updateShowHideTouchDelegate$lambda3(DanaEmasWalletV3CardView.this, view);
            }
        });
    }

    /* renamed from: updateShowHideTouchDelegate$lambda-3 */
    public static final void m3124updateShowHideTouchDelegate$lambda3(DanaEmasWalletV3CardView danaEmasWalletV3CardView, View view) {
        Intrinsics.checkNotNullParameter(danaEmasWalletV3CardView, "");
        Intrinsics.checkNotNullParameter(view, "");
        Rect rect = new Rect();
        ((AppCompatImageView) danaEmasWalletV3CardView._$_findCachedViewById(R.id.OkHttpExporterBuilder)).getHitRect(rect);
        rect.top -= 10;
        rect.left -= 10;
        rect.bottom += 10;
        rect.right += 10;
        view.setTouchDelegate(new TouchDelegate(rect, (AppCompatImageView) danaEmasWalletV3CardView._$_findCachedViewById(R.id.OkHttpExporterBuilder)));
    }

    private final void updateBalanceVisibility() {
        if (this.isBalanceVisible) {
            showBalance();
        } else {
            hideBalance();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void showBalance() {
        /*
            r9 = this;
            int r0 = id.dana.R.id.tv_balance_content
            android.view.View r0 = r9._$_findCachedViewById(r0)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            r1 = 0
            if (r0 == 0) goto L2d
            java.util.Locale r3 = r9.getLocale()
            id.dana.wallet_v3.model.InvestmentCardModel$EmasCard r4 = r9.card
            id.dana.domain.investment.model.MultiCurrencyMoneyView r4 = r4.getAvailableBalance()
            if (r4 == 0) goto L23
            java.lang.Long r4 = r4.getAmount()
            if (r4 == 0) goto L23
            long r4 = r4.longValue()
            goto L24
        L23:
            r4 = r1
        L24:
            java.lang.String r3 = id.dana.utils.NumberFormatterUtil.KClassImpl$Data$declaredNonStaticMembers$2(r3, r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L2d:
            java.util.Locale r0 = r9.getLocale()
            id.dana.wallet_v3.model.InvestmentCardModel$EmasCard r3 = r9.card
            id.dana.domain.investment.model.MultiCurrencyMoneyView r3 = r3.getTotalGainLossAmount()
            if (r3 == 0) goto L43
            java.lang.Long r3 = r3.getAmount()
            if (r3 == 0) goto L43
            long r1 = r3.longValue()
        L43:
            java.lang.String r0 = id.dana.utils.NumberFormatterUtil.KClassImpl$Data$declaredNonStaticMembers$2(r0, r1)
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r9.setProfitCashContentText(r0)
            int r0 = id.dana.R.id.OkHttpExporterBuilder
            android.view.View r0 = r9._$_findCachedViewById(r0)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            if (r0 == 0) goto L5f
            r1 = 2131233830(0x7f080c26, float:1.8083809E38)
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(r0, r1)
        L5f:
            id.dana.wallet_v3.model.InvestmentCardModel$EmasCard r0 = r9.card
            java.lang.String r0 = r0.getTotalGainLossPercent()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L78
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L73
            r0 = 1
            goto L74
        L73:
            r0 = 0
        L74:
            if (r0 != r2) goto L78
            r0 = 1
            goto L79
        L78:
            r0 = 0
        L79:
            if (r0 == 0) goto La4
            id.dana.wallet_v3.model.InvestmentCardModel$EmasCard r0 = r9.card
            java.lang.String r0 = r0.getTotalGainLossPercent()
            double r3 = java.lang.Double.parseDouble(r0)
            int r0 = id.dana.R.id.res_0x7f0a185e_r8_lambda_kv2_dpqpwd_w5eoph03eiig8sxg
            android.view.View r0 = r9._$_findCachedViewById(r0)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            if (r0 == 0) goto La4
            java.lang.String r5 = r9.getRoundedToTwoDecimalBehind(r3)
            r6 = 0
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 >= 0) goto L9a
            goto L9b
        L9a:
            r1 = 1
        L9b:
            java.lang.String r1 = r9.getFormatedPercentageProfit(r5, r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.walletcardview.DanaEmasWalletV3CardView.showBalance():void");
    }

    private final void hideBalance() {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_content);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(WalletConstant.SECURE_TEXT);
        }
        setProfitCashContentText(WalletConstant.SECURE_TEXT);
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.OkHttpExporterBuilder);
        if (appCompatImageView != null) {
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, R.drawable.ic_visibility_show_outlined);
        }
        String totalGainLossPercent = this.card.getTotalGainLossPercent();
        boolean z = false;
        if (totalGainLossPercent != null) {
            if (totalGainLossPercent.length() > 0) {
                z = true;
            }
        }
        if (!z || (appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a185e_r8_lambda_kv2_dpqpwd_w5eoph03eiig8sxg)) == null) {
            return;
        }
        appCompatTextView.setText(WalletConstant.SECURE_TEXT);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setProfitCashContentText(java.lang.String r9) {
        /*
            r8 = this;
            id.dana.wallet_v3.model.InvestmentCardModel$EmasCard r0 = r8.card
            id.dana.domain.investment.model.MultiCurrencyMoneyView r0 = r0.getTotalGainLossAmount()
            java.lang.String r1 = ""
            r2 = 0
            if (r0 == 0) goto L3d
            int r0 = id.dana.R.id.res_0x7f0a185c_summaryactivity_handleblacklistaccountsmartfriction_1
            android.view.View r0 = r8._$_findCachedViewById(r0)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            if (r0 == 0) goto L1a
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
        L1a:
            int r9 = id.dana.R.id.shouldSendGlobalHeartBeat
            android.view.View r9 = r8._$_findCachedViewById(r9)
            androidx.constraintlayout.widget.Group r9 = (androidx.constraintlayout.widget.Group) r9
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r1)
            android.view.View r9 = (android.view.View) r9
            r9.setVisibility(r2)
            int r9 = id.dana.R.id.AccessibilityNodeProvider
            android.view.View r9 = r8._$_findCachedViewById(r9)
            androidx.constraintlayout.widget.Group r9 = (androidx.constraintlayout.widget.Group) r9
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r1)
            android.view.View r9 = (android.view.View) r9
            r9.setVisibility(r2)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L3e
        L3d:
            r9 = 0
        L3e:
            if (r9 != 0) goto L62
            int r9 = id.dana.R.id.shouldSendGlobalHeartBeat
            android.view.View r9 = r8._$_findCachedViewById(r9)
            androidx.constraintlayout.widget.Group r9 = (androidx.constraintlayout.widget.Group) r9
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r1)
            android.view.View r9 = (android.view.View) r9
            r0 = 8
            r9.setVisibility(r0)
            int r9 = id.dana.R.id.AccessibilityNodeProvider
            android.view.View r9 = r8._$_findCachedViewById(r9)
            androidx.constraintlayout.widget.Group r9 = (androidx.constraintlayout.widget.Group) r9
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r1)
            android.view.View r9 = (android.view.View) r9
            r9.setVisibility(r0)
        L62:
            id.dana.wallet_v3.model.InvestmentCardModel$EmasCard r9 = r8.card
            java.lang.String r9 = r9.getTotalGainLossPercent()
            r0 = 1
            if (r9 == 0) goto L7a
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            int r9 = r9.length()
            if (r9 <= 0) goto L75
            r9 = 1
            goto L76
        L75:
            r9 = 0
        L76:
            if (r9 != r0) goto L7a
            r9 = 1
            goto L7b
        L7a:
            r9 = 0
        L7b:
            if (r9 == 0) goto La5
            id.dana.wallet_v3.model.InvestmentCardModel$EmasCard r9 = r8.card
            java.lang.String r9 = r9.getTotalGainLossPercent()
            double r3 = java.lang.Double.parseDouble(r9)
            int r9 = id.dana.R.id.res_0x7f0a185e_r8_lambda_kv2_dpqpwd_w5eoph03eiig8sxg
            android.view.View r9 = r8._$_findCachedViewById(r9)
            androidx.appcompat.widget.AppCompatTextView r9 = (androidx.appcompat.widget.AppCompatTextView) r9
            if (r9 == 0) goto La5
            java.lang.String r1 = r8.getRoundedToTwoDecimalBehind(r3)
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L9c
            r2 = 1
        L9c:
            java.lang.String r0 = r8.getFormatedPercentageProfit(r1, r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.walletcardview.DanaEmasWalletV3CardView.setProfitCashContentText(java.lang.String):void");
    }

    private final String getRoundedToTwoDecimalBehind(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String format = decimalFormat.format(value);
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    private final String getFormatedPercentageProfit(String value, boolean isProfit) {
        if (isProfit) {
            StringBuilder sb = new StringBuilder();
            sb.append('+');
            sb.append(value);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('-');
        sb2.append(value);
        return sb2.toString();
    }

    public final void setTextColor(int r2) {
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_title_balance)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_currency)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_content)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.AutoMigrationSpec)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_gram)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_weight_content)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_gram)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_title_profit_cash)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_profit_cash_currency)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a185c_summaryactivity_handleblacklistaccountsmartfriction_1)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_title_profit)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a185e_r8_lambda_kv2_dpqpwd_w5eoph03eiig8sxg)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_percentage)).setTextColor(r2);
    }
}

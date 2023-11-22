package id.dana.wallet_v3.view.walletcardview;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import id.dana.R;
import id.dana.richview.wallet.BaseWalletDefaultCardView;
import id.dana.wallet_v3.listener.GoalsClickListener;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.InvestmentCardModel;
import id.dana.wallet_v3.util.WalletV3ToastUtilKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010$\u001a\u00020\u0013\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u000fJ\u000f\u0010\u001a\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001a\u0010\u000fJ\u000f\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u000fR\u0017\u0010\u001d\u001a\u00020\u001c8\u0007¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u0004\u0018\u00010!8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00138\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010%R\u0016\u0010(\u001a\u0004\u0018\u00010'8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lid/dana/wallet_v3/view/walletcardview/DanaGoalsWalletV3CardView;", "Lid/dana/richview/wallet/BaseWalletDefaultCardView;", "", "getBackgroundDrawableRes", "()I", "", "getBackgroundUrl", "()Ljava/lang/String;", "getCardContentLayout", "getCardInstId", "Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "getWalletCardListener", "()Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "", "initView", "()V", "onAttachedToWindow", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", CdpConstants.CONTENT_TEXT_COLOR, "setTextColor", "(I)V", "setVisibilityIconContentDescription", "updateBalanceVisibility", "updateShowHideTouchDelegate", "Lid/dana/wallet_v3/model/InvestmentCardModel$DanaGoalsCard;", "card", "Lid/dana/wallet_v3/model/InvestmentCardModel$DanaGoalsCard;", "getCard", "()Lid/dana/wallet_v3/model/InvestmentCardModel$DanaGoalsCard;", "Lid/dana/wallet_v3/listener/GoalsClickListener;", "danaGoalsClickListener", "Lid/dana/wallet_v3/listener/GoalsClickListener;", "isBalanceVisible", "Z", "isTextColorUpdated", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;Lid/dana/wallet_v3/model/InvestmentCardModel$DanaGoalsCard;ZLid/dana/wallet_v3/listener/WalletCardAssetClickListener;Lid/dana/wallet_v3/listener/GoalsClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DanaGoalsWalletV3CardView extends BaseWalletDefaultCardView {
    public Map<Integer, View> _$_findViewCache;
    private final InvestmentCardModel.DanaGoalsCard card;
    private final GoalsClickListener danaGoalsClickListener;
    private final boolean isBalanceVisible;
    private boolean isTextColorUpdated;
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
        return R.layout.dana_goals_wallet_v3_card;
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaGoalsWalletV3CardView(Context context, InvestmentCardModel.DanaGoalsCard danaGoalsCard, boolean z, WalletCardAssetClickListener walletCardAssetClickListener, GoalsClickListener goalsClickListener) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(danaGoalsCard, "");
        this._$_findViewCache = new LinkedHashMap();
        this.card = danaGoalsCard;
        this.isBalanceVisible = z;
        this.walletCardAssetClickListener = walletCardAssetClickListener;
        this.danaGoalsClickListener = goalsClickListener;
    }

    public /* synthetic */ DanaGoalsWalletV3CardView(Context context, InvestmentCardModel.DanaGoalsCard danaGoalsCard, boolean z, WalletCardAssetClickListener walletCardAssetClickListener, GoalsClickListener goalsClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, danaGoalsCard, z, (i & 8) != 0 ? null : walletCardAssetClickListener, (i & 16) != 0 ? null : goalsClickListener);
    }

    @JvmName(name = "getCard")
    public final InvestmentCardModel.DanaGoalsCard getCard() {
        return this.card;
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView
    public final BaseWalletDefaultCardView.WalletCardListener getWalletCardListener() {
        return new BaseWalletDefaultCardView.WalletCardListener() { // from class: id.dana.wallet_v3.view.walletcardview.DanaGoalsWalletV3CardView$getWalletCardListener$1
            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final /* synthetic */ void onCardHold() {
                BaseWalletDefaultCardView.WalletCardListener.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final void onCardClicked() {
                WalletCardAssetClickListener walletCardAssetClickListener;
                walletCardAssetClickListener = DanaGoalsWalletV3CardView.this.walletCardAssetClickListener;
                if (walletCardAssetClickListener != null) {
                    walletCardAssetClickListener.onCardClicked(DanaGoalsWalletV3CardView.this.getCard());
                }
            }

            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final void onUpdateTextColor(int textColor) {
                boolean z;
                z = DanaGoalsWalletV3CardView.this.isTextColorUpdated;
                if (z) {
                    return;
                }
                DanaGoalsWalletV3CardView.this.isTextColorUpdated = true;
                DanaGoalsWalletV3CardView.this.setTextColor(textColor);
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
        appCompatImageView.setContentDescription(appCompatImageView.getContext().getString(R.string.wallet_img_logo_goals_financial));
        if (!this.isTextColorUpdated) {
            setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), this.card.getPayCardViewItem().scheduleImpl));
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_content);
        if (appCompatTextView != null) {
            appCompatTextView.setText(this.card.getAmount());
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_currency);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(this.card.getCurrency());
        }
        setVisibilityIconContentDescription();
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a042a_imagecaptureviewmodel_gettipuploadphoto_2);
        if (constraintLayout != null) {
            constraintLayout.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.wallet_v3.view.walletcardview.DanaGoalsWalletV3CardView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean m3126initView$lambda1;
                    m3126initView$lambda1 = DanaGoalsWalletV3CardView.m3126initView$lambda1(DanaGoalsWalletV3CardView.this, view, motionEvent);
                    return m3126initView$lambda1;
                }
            });
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.OkHttpExporterBuilder);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.walletcardview.DanaGoalsWalletV3CardView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DanaGoalsWalletV3CardView.m3127initView$lambda2(DanaGoalsWalletV3CardView.this, view);
                }
            });
        }
        updateBalanceVisibility();
    }

    /* renamed from: initView$lambda-1 */
    public static final boolean m3126initView$lambda1(DanaGoalsWalletV3CardView danaGoalsWalletV3CardView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(danaGoalsWalletV3CardView, "");
        return danaGoalsWalletV3CardView.getGestureDetector().onTouchEvent(motionEvent);
    }

    /* renamed from: initView$lambda-2 */
    public static final void m3127initView$lambda2(DanaGoalsWalletV3CardView danaGoalsWalletV3CardView, View view) {
        Intrinsics.checkNotNullParameter(danaGoalsWalletV3CardView, "");
        GoalsClickListener goalsClickListener = danaGoalsWalletV3CardView.danaGoalsClickListener;
        if (goalsClickListener != null) {
            goalsClickListener.onBalanceVisibilityClicked(!danaGoalsWalletV3CardView.isBalanceVisible);
        }
        Context context = danaGoalsWalletV3CardView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        WalletV3ToastUtilKt.vibrateWhenShowHideBalance(context);
        danaGoalsWalletV3CardView.setVisibilityIconContentDescription();
    }

    private final void setVisibilityIconContentDescription() {
        String string;
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.OkHttpExporterBuilder);
        if (this.isBalanceVisible) {
            string = getContext().getString(R.string.wallet_ic_cross_eye_goals_financial);
        } else {
            string = getContext().getString(R.string.wallet_ic_eye_goals_financial);
        }
        appCompatImageView.setContentDescription(string);
    }

    private final void updateShowHideTouchDelegate() {
        ViewParent parent = ((AppCompatImageView) _$_findCachedViewById(R.id.OkHttpExporterBuilder)).getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        final View view = (View) parent;
        view.post(new Runnable() { // from class: id.dana.wallet_v3.view.walletcardview.DanaGoalsWalletV3CardView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                DanaGoalsWalletV3CardView.m3128updateShowHideTouchDelegate$lambda3(DanaGoalsWalletV3CardView.this, view);
            }
        });
    }

    /* renamed from: updateShowHideTouchDelegate$lambda-3 */
    public static final void m3128updateShowHideTouchDelegate$lambda3(DanaGoalsWalletV3CardView danaGoalsWalletV3CardView, View view) {
        Intrinsics.checkNotNullParameter(danaGoalsWalletV3CardView, "");
        Intrinsics.checkNotNullParameter(view, "");
        Rect rect = new Rect();
        ((AppCompatImageView) danaGoalsWalletV3CardView._$_findCachedViewById(R.id.OkHttpExporterBuilder)).getHitRect(rect);
        rect.top -= 10;
        rect.left -= 10;
        rect.bottom += 10;
        rect.right += 10;
        view.setTouchDelegate(new TouchDelegate(rect, (AppCompatImageView) danaGoalsWalletV3CardView._$_findCachedViewById(R.id.OkHttpExporterBuilder)));
    }

    private final void updateBalanceVisibility() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_content);
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(this.isBalanceVisible ? 0 : 8);
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_hidden_pay_content);
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(this.isBalanceVisible ^ true ? 0 : 8);
        if (this.isBalanceVisible) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.OkHttpExporterBuilder);
            if (appCompatImageView != null) {
                __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, R.drawable.ic_visibility_hide_outlined);
                return;
            }
            return;
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.OkHttpExporterBuilder);
        if (appCompatImageView2 != null) {
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView2, R.drawable.ic_visibility_show_outlined);
        }
    }

    public final void setTextColor(int r2) {
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_title_balance)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_currency)).setTextColor(r2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_balance_content)).setTextColor(r2);
        ((TextView) _$_findCachedViewById(R.id.tv_hidden_pay_content)).setTextColor(r2);
    }
}

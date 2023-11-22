package id.dana.wallet_v3.view.walletcardview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import id.dana.R;
import id.dana.data.social.common.PhoneNumberUtilKt;
import id.dana.data.util.NumberUtils;
import id.dana.richview.wallet.BaseWalletDefaultCardView;
import id.dana.wallet_v3.constant.WalletConstant;
import id.dana.wallet_v3.listener.DanaBalanceClickListener;
import id.dana.wallet_v3.model.PaymentCardModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0001,B#\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0012\u0010\u0010J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u001e8\u0007¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u0004\u0018\u00010%8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b&\u0010'"}, d2 = {"Lid/dana/wallet_v3/view/walletcardview/DanaBalanceWalletV3CardView;", "Lid/dana/richview/wallet/BaseWalletDefaultCardView;", "", "getBackgroundDrawableRes", "()I", "", "getBackgroundUrl", "()Ljava/lang/String;", "getCardContentLayout", "getCardInstId", "getSecuredPhoneNumber", "Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "getWalletCardListener", "()Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "", "initView", "()V", "invokeListeners", "onAttachedToWindow", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "phoneNumber", "replaceNumberWithSecureText", "(Ljava/lang/String;)Ljava/lang/String;", CdpConstants.CONTENT_TEXT_COLOR, "setTextColor", "(I)V", "Lid/dana/wallet_v3/model/PaymentCardModel$DanaCard;", "card", "Lid/dana/wallet_v3/model/PaymentCardModel$DanaCard;", "getCard", "()Lid/dana/wallet_v3/model/PaymentCardModel$DanaCard;", "isTextColorUpdated", "Z", "Lid/dana/wallet_v3/listener/DanaBalanceClickListener;", "onDanaBalanceClickListener", "Lid/dana/wallet_v3/listener/DanaBalanceClickListener;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;Lid/dana/wallet_v3/model/PaymentCardModel$DanaCard;Lid/dana/wallet_v3/listener/DanaBalanceClickListener;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DanaBalanceWalletV3CardView extends BaseWalletDefaultCardView {
    private static final int PHONE_NUMBER_SECTION_LENGTH = 4;
    public Map<Integer, View> _$_findViewCache;
    private final PaymentCardModel.DanaCard card;
    private boolean isTextColorUpdated;
    private final DanaBalanceClickListener onDanaBalanceClickListener;

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
        return R.layout.dana_balance_wallet_v3_card;
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaBalanceWalletV3CardView(Context context, PaymentCardModel.DanaCard danaCard, DanaBalanceClickListener danaBalanceClickListener) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(danaCard, "");
        this._$_findViewCache = new LinkedHashMap();
        this.card = danaCard;
        this.onDanaBalanceClickListener = danaBalanceClickListener;
    }

    public /* synthetic */ DanaBalanceWalletV3CardView(Context context, PaymentCardModel.DanaCard danaCard, DanaBalanceClickListener danaBalanceClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, danaCard, (i & 4) != 0 ? null : danaBalanceClickListener);
    }

    @JvmName(name = "getCard")
    public final PaymentCardModel.DanaCard getCard() {
        return this.card;
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView
    public final BaseWalletDefaultCardView.WalletCardListener getWalletCardListener() {
        return new BaseWalletDefaultCardView.WalletCardListener() { // from class: id.dana.wallet_v3.view.walletcardview.DanaBalanceWalletV3CardView$getWalletCardListener$1
            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final /* synthetic */ void onCardClicked() {
                BaseWalletDefaultCardView.WalletCardListener.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final /* synthetic */ void onCardHold() {
                BaseWalletDefaultCardView.WalletCardListener.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final void onUpdateTextColor(int textColor) {
                boolean z;
                z = DanaBalanceWalletV3CardView.this.isTextColorUpdated;
                if (z) {
                    return;
                }
                DanaBalanceWalletV3CardView.this.isTextColorUpdated = true;
                DanaBalanceWalletV3CardView.this.setTextColor(textColor);
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
        String securedPhoneNumber;
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43((AppCompatImageView) _$_findCachedViewById(R.id.TextInputLayout$1), this.card.getPayCardViewItem().KClassImpl$Data$declaredNonStaticMembers$2);
        if (!this.isTextColorUpdated) {
            setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), this.card.getPayCardViewItem().scheduleImpl));
        }
        ((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0428_getexpresspurchaseresponse_priceentity)).setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.wallet_v3.view.walletcardview.DanaBalanceWalletV3CardView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean m3117initView$lambda0;
                m3117initView$lambda0 = DanaBalanceWalletV3CardView.m3117initView$lambda0(DanaBalanceWalletV3CardView.this, view, motionEvent);
                return m3117initView$lambda0;
            }
        });
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tv_mask_number);
        if (appCompatTextView != null) {
            if (!Intrinsics.areEqual(this.card.getKycLevel(), "KYC0")) {
                if (!(this.card.getNickname().length() == 0)) {
                    securedPhoneNumber = this.card.getNickname();
                    appCompatTextView.setText(securedPhoneNumber);
                }
            }
            securedPhoneNumber = getSecuredPhoneNumber();
            appCompatTextView.setText(securedPhoneNumber);
        }
        String string = getContext().getString(R.string.wallet_img_dana_card_payment);
        Intrinsics.checkNotNullExpressionValue(string, "");
        setCardContentDescription(string);
    }

    /* renamed from: initView$lambda-0 */
    public static final boolean m3117initView$lambda0(DanaBalanceWalletV3CardView danaBalanceWalletV3CardView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(danaBalanceWalletV3CardView, "");
        return danaBalanceWalletV3CardView.getGestureDetector().onTouchEvent(motionEvent);
    }

    private final String getSecuredPhoneNumber() {
        if (this.card.getNumber().length() > 4) {
            String replaceIndoPhoneNumberPrefixWithZero = NumberUtils.replaceIndoPhoneNumberPrefixWithZero(this.card.getNumber());
            Intrinsics.checkNotNullExpressionValue(replaceIndoPhoneNumberPrefixWithZero, "");
            return replaceNumberWithSecureText(replaceIndoPhoneNumberPrefixWithZero);
        }
        return "";
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView, id.dana.richview.wallet.BaseWalletCardView
    public final void invokeListeners() {
        DanaBalanceClickListener danaBalanceClickListener = this.onDanaBalanceClickListener;
        if (danaBalanceClickListener != null) {
            danaBalanceClickListener.onTopUpClicked();
        }
    }

    private final String replaceNumberWithSecureText(String phoneNumber) {
        int length = (r4.length() - 1) - 4;
        return StringsKt.replaceRange((CharSequence) PhoneNumberUtilKt.addWhiteSpaceBetweenSection(phoneNumber, 4), length - 4, length, (CharSequence) WalletConstant.SECURE_TEXT).toString();
    }

    public final void setTextColor(int r2) {
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_mask_number)).setTextColor(r2);
    }
}

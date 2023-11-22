package id.dana.wallet_v3.view.walletcardview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.richview.wallet.BaseWalletDefaultCardView;
import id.dana.richview.wallet.GlideCustomKeyByTimestamp;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.PaymentCardModel;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 @2\u00020\u0001:\u0001@B%\u0012\u0006\u0010:\u001a\u000209\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;\u0012\b\b\u0002\u0010=\u001a\u00020\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u001a\u0010\u0012J\u000f\u0010\u001b\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u001b\u0010\u0012J\u0017\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020+8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R$\u00100\u001a\u0004\u0018\u00010/8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b7\u00108"}, d2 = {"Lid/dana/wallet_v3/view/walletcardview/BankWalletV3CardView;", "Lid/dana/richview/wallet/BaseWalletDefaultCardView;", "", "getBackgroundDrawableRes", "()I", "", "getBackgroundUrl", "()Ljava/lang/String;", "cardBin", "getBackgroundUrlByCardBin", "(Ljava/lang/String;)Ljava/lang/String;", "getCardContentLayout", "getCardInstId", "Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "getWalletCardListener", "()Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "", "initView", "()V", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/Bitmap;", "fallback", "loadBinCardBackground", "(Lcom/bumptech/glide/RequestBuilder;)V", "loadDefaultFallbackCardBackground", "()Lcom/bumptech/glide/RequestBuilder;", "onAttachedToWindow", "setCardBackground", CdpConstants.CONTENT_TEXT_COLOR, "setTextColor", "(I)V", "Lid/dana/wallet_v3/model/PaymentCardModel$BankCard;", "card", "Lid/dana/wallet_v3/model/PaymentCardModel$BankCard;", "getCard", "()Lid/dana/wallet_v3/model/PaymentCardModel$BankCard;", "setCard", "(Lid/dana/wallet_v3/model/PaymentCardModel$BankCard;)V", "downloadBgBitmap", "Landroid/graphics/Bitmap;", "", "isTextColorUpdated", "Z", "Lid/dana/richview/wallet/GlideCustomKeyByTimestamp;", "getKey", "()Lid/dana/richview/wallet/GlideCustomKeyByTimestamp;", "key", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "onBankClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "getOnBankClickListener", "()Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "setOnBankClickListener", "(Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;)V", "Lid/dana/wallet_v3/view/walletcardview/BankWalletV3CardView$requestListener$1;", "requestListener", "Lid/dana/wallet_v3/view/walletcardview/BankWalletV3CardView$requestListener$1;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BankWalletV3CardView extends BaseWalletDefaultCardView {
    private static final String CARD_BG_URL = "https://a.m.dana.id/resource/imgs/bank-cards/bg-%s.png";
    private static final String CARD_BIN = "CARD_BIN";
    private static final String CARD_NUMBER_SECURE_FORMAT = "•••• •••• •••• %s";
    private static final String DEBIT_CARD = "DC";
    private static final String EXPIRY_FORMAT = "%s/%s";
    public Map<Integer, View> _$_findViewCache;
    public PaymentCardModel.BankCard card;
    private Bitmap downloadBgBitmap;
    private boolean isTextColorUpdated;
    private WalletCardAssetClickListener onBankClickListener;
    private final BankWalletV3CardView$requestListener$1 requestListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BankWalletV3CardView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BankWalletV3CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

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
        return R.layout.bank_wallet_v3_card;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [id.dana.wallet_v3.view.walletcardview.BankWalletV3CardView$requestListener$1] */
    public BankWalletV3CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.requestListener = new RequestListener<Bitmap>() { // from class: id.dana.wallet_v3.view.walletcardview.BankWalletV3CardView$requestListener$1
            @Override // com.bumptech.glide.request.RequestListener
            public final boolean onLoadFailed(GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public final boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                StringBuilder sb = new StringBuilder();
                sb.append(resource != null ? resource.hashCode() : 0);
                sb.append(InputCardNumberView.DIVIDER);
                sb.append(dataSource != null ? dataSource.name() : null);
                DanaLog.BuiltInFictitiousFunctionClassFactory("BankCard", sb.toString());
                if (resource != null) {
                    BankWalletV3CardView.this.downloadBgBitmap = resource;
                }
                BankWalletV3CardView.this.updateTextColor(resource);
                return false;
            }
        };
    }

    public /* synthetic */ BankWalletV3CardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getCard")
    public final PaymentCardModel.BankCard getCard() {
        PaymentCardModel.BankCard bankCard = this.card;
        if (bankCard != null) {
            return bankCard;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setCard")
    public final void setCard(PaymentCardModel.BankCard bankCard) {
        Intrinsics.checkNotNullParameter(bankCard, "");
        this.card = bankCard;
    }

    @JvmName(name = "getOnBankClickListener")
    public final WalletCardAssetClickListener getOnBankClickListener() {
        return this.onBankClickListener;
    }

    @JvmName(name = "setOnBankClickListener")
    public final void setOnBankClickListener(WalletCardAssetClickListener walletCardAssetClickListener) {
        this.onBankClickListener = walletCardAssetClickListener;
    }

    @JvmName(name = "getKey")
    private final GlideCustomKeyByTimestamp getKey() {
        Long backgroundUrlTimestamp = getCard().getBackgroundUrlTimestamp();
        return new GlideCustomKeyByTimestamp(backgroundUrlTimestamp != null ? backgroundUrlTimestamp.longValue() : System.currentTimeMillis());
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView
    public final BaseWalletDefaultCardView.WalletCardListener getWalletCardListener() {
        return new BaseWalletDefaultCardView.WalletCardListener() { // from class: id.dana.wallet_v3.view.walletcardview.BankWalletV3CardView$getWalletCardListener$1
            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final /* synthetic */ void onCardHold() {
                BaseWalletDefaultCardView.WalletCardListener.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final void onCardClicked() {
                WalletCardAssetClickListener onBankClickListener = BankWalletV3CardView.this.getOnBankClickListener();
                if (onBankClickListener != null) {
                    onBankClickListener.onCardClicked(BankWalletV3CardView.this.getCard());
                }
            }

            @Override // id.dana.richview.wallet.BaseWalletDefaultCardView.WalletCardListener
            public final void onUpdateTextColor(int textColor) {
                boolean z;
                z = BankWalletV3CardView.this.isTextColorUpdated;
                if (z) {
                    return;
                }
                BankWalletV3CardView.this.isTextColorUpdated = true;
                BankWalletV3CardView.this.setTextColor(textColor);
            }
        };
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView
    public final int getBackgroundDrawableRes() {
        return getCard().getPayCardViewItem().BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView
    public final String getBackgroundUrl() {
        return getCard().getCardBackground();
    }

    private final String getBackgroundUrlByCardBin(String cardBin) {
        if ((!StringsKt.isBlank(cardBin)) != false) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("https://a.m.dana.id/resource/imgs/bank-cards/bg-%s.png", Arrays.copyOf(new Object[]{cardBin}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            return format;
        }
        return getCard().getCardBackground();
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView
    public final void setCardBackground() {
        if (this.downloadBgBitmap == null) {
            loadBinCardBackground(loadDefaultFallbackCardBackground());
        } else {
            Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).PlaceComponentResult().PlaceComponentResult(this.downloadBgBitmap).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0c6e_daggerstickysummarycomponent_stickysummarycomponentimpl_postexecutionthreadprovider)));
        }
    }

    private final RequestBuilder<Bitmap> loadDefaultFallbackCardBackground() {
        RequestBuilder<Bitmap> authRequestContext = Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).PlaceComponentResult().PlaceComponentResult(getCard().getCardBackground()).BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.PlaceComponentResult).KClassImpl$Data$declaredNonStaticMembers$2(getKey()).getAuthRequestContext(false).BuiltInFictitiousFunctionClassFactory(R.drawable.bg_bank_card_horizontal_default).getAuthRequestContext(this.requestListener);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    private final void loadBinCardBackground(RequestBuilder<Bitmap> fallback) {
        Map<String, String> extInfo = getCard().getExtInfo();
        String str = extInfo != null ? extInfo.get(CARD_BIN) : null;
        if (str == null) {
            str = "";
        }
        Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).PlaceComponentResult().PlaceComponentResult(getBackgroundUrlByCardBin(str)).BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.PlaceComponentResult).KClassImpl$Data$declaredNonStaticMembers$2(getKey()).getAuthRequestContext(false).BuiltInFictitiousFunctionClassFactory(fallback).getAuthRequestContext(this.requestListener).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0c6e_daggerstickysummarycomponent_stickysummarycomponentimpl_postexecutionthreadprovider)));
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final String getCardInstId() {
        return getCard().getId();
    }

    @Override // id.dana.richview.wallet.BaseWalletDefaultCardView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        initView();
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0180, code lost:
    
        if ((r0.length() == 0) == true) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void initView() {
        /*
            Method dump skipped, instructions count: 479
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.walletcardview.BankWalletV3CardView.initView():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextColor(int textColor) {
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a1650_sendriskevententityrepository_externalsyntheticlambda0)).setTextColor(textColor);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_card_number)).setTextColor(textColor);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_expiry_date_title)).setTextColor(textColor);
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a16f3_tncsummaryactivity_externalsyntheticlambda1)).setTextColor(textColor);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_daily_limit_title)).setTextColor(textColor);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_daily_limit)).setTextColor(textColor);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_daily_limit_content)).setTextColor(textColor);
    }
}

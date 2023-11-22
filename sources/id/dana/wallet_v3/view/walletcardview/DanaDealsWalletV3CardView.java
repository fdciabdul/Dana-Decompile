package id.dana.wallet_v3.view.walletcardview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import id.dana.R;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.core.ui.util.NumberFormatterUtil;
import id.dana.core.ui.util.NumberUtil;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.pocket.model.AssetStatusKt;
import id.dana.domain.wallet_v3.model.AssetType;
import id.dana.extension.lang.StringExtKt;
import id.dana.richview.wallet.BaseWalletCustomCardView;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;
import id.dana.utils.SizeUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 c2\u00020\u0001:\u0001cB?\u0012\u0006\u0010`\u001a\u00020_\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\\\u0012\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\r0T\u0012\b\b\u0002\u0010P\u001a\u00020\r¢\u0006\u0004\ba\u0010bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0017J'\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001f\u0010 J'\u0010!\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010 J'\u0010\"\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\rH\u0002¢\u0006\u0004\b\"\u0010 J\u000f\u0010#\u001a\u00020\u0004H\u0014¢\u0006\u0004\b#\u0010\u0017J\u000f\u0010$\u001a\u00020\u0004H\u0014¢\u0006\u0004\b$\u0010\u0017J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0011H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0011H\u0002¢\u0006\u0004\b)\u0010'J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0011H\u0002¢\u0006\u0004\b+\u0010'J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0011H\u0002¢\u0006\u0004\b-\u0010'J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0011H\u0002¢\u0006\u0004\b.\u0010'J\u0017\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0011H\u0002¢\u0006\u0004\b0\u0010'J\u0017\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0011H\u0002¢\u0006\u0004\b2\u0010'J\u0017\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00042\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b7\u00106J\u0017\u00108\u001a\u00020\u00042\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b8\u00106J\u0017\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0011H\u0002¢\u0006\u0004\b:\u0010'J\u0017\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0002H\u0002¢\u0006\u0004\b<\u0010\u0006J\u000f\u0010=\u001a\u00020\u0004H\u0002¢\u0006\u0004\b=\u0010\u0017J\u0017\u0010>\u001a\u00020\u00042\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b>\u00106J\u0019\u0010@\u001a\u00020\u00042\b\u0010?\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b@\u0010'J\u0017\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0011H\u0002¢\u0006\u0004\bB\u0010'J\u000f\u0010C\u001a\u00020\u0004H\u0016¢\u0006\u0004\bC\u0010\u0017J\u000f\u0010D\u001a\u00020\u0004H\u0002¢\u0006\u0004\bD\u0010\u0017J\u000f\u0010E\u001a\u00020\u0004H\u0002¢\u0006\u0004\bE\u0010\u0017J#\u0010G\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010\u00022\b\u0010?\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0004H\u0002¢\u0006\u0004\bI\u0010\u0017J\u0017\u0010J\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u0002H\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0004H\u0002¢\u0006\u0004\bL\u0010\u0017J\u0017\u0010M\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0011H\u0002¢\u0006\u0004\bM\u0010'J\u000f\u0010N\u001a\u00020\u0004H\u0002¢\u0006\u0004\bN\u0010\u0017J\u0013\u0010O\u001a\u00020\u0011*\u00020\u0011H\u0002¢\u0006\u0004\bO\u0010\u0014R\u0014\u0010P\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010R\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\r0T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010W\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Z\u001a\u0004\u0018\u00010Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010]\u001a\u0004\u0018\u00010\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^"}, d2 = {"Lid/dana/wallet_v3/view/walletcardview/DanaDealsWalletV3CardView;", "Lid/dana/richview/wallet/BaseWalletCustomCardView;", "", "isOnlineMerchant", "", "checkIsOnlineMerchant", "(Z)V", "Lio/reactivex/disposables/Disposable;", "createTimeCounter", "()Lio/reactivex/disposables/Disposable;", "", "getCardInstId", "()Ljava/lang/CharSequence;", "", "getDefaultCategoryIcon", "()I", "getLayout", "", "categoryType", "getOfflineCategoryName", "(Ljava/lang/String;)Ljava/lang/String;", "getOnlineCategoryName", "hideFold", "()V", "hideStatusTag", "initView", "invokeListeners", "url", "Landroidx/appcompat/widget/AppCompatImageView;", "view", SecurityConstants.KEY_PLACE_HOLDER, "loadIcon", "(Ljava/lang/String;Landroidx/appcompat/widget/AppCompatImageView;I)V", "loadPngImage", "loadSvgImage", "onAttachedToWindow", "onDetachedFromWindow", "assetType", "setAmountBasedOnAssetType", "(Ljava/lang/String;)V", "amount", "setAmountSuffix", "backgroundColor", "setBackgroundColor", "iconColor", "setCategoryIconColor", "setCategoryIconSize", "bizType", "setCategoryName", "discountRate", "setDiscountRate", "", "voucherExpirationDate", "setExpirationInDateFormat", "(J)V", "setExpirationInDaysFormat", "setExpirationInTimeFormat", "minTransaction", "setMinimumTrxAmount", "isNew", "setNewRibbon", "setNoExpirationDate", "setNormalStateExpiredDate", "status", "setTagAndSpacing", CdpConstants.CONTENT_TEXT_COLOR, "setTextColor", "setup", "setupData", "setupExpirationDate", "isUsed", "setupExpiredView", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "setupImage", "shouldShowFlag", "(Z)Z", "showExpiredStatusTag", "showFold", "showUsedStatusTag", "formatAmount", "cardIndex", "I", "countdownDisposable", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/subjects/PublishSubject;", "countdownPublishSubject", "Lio/reactivex/subjects/PublishSubject;", "expiryCountdown", "J", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "onVoucherClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$DealsCard;", "voucherAssetModel", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$DealsCard;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$DealsCard;Lio/reactivex/subjects/PublishSubject;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DanaDealsWalletV3CardView extends BaseWalletCustomCardView {
    private static final String AGGREGATOR_VOUCHER_TYPE = "AGGREGATOR_VOUCHER";
    private static final String A_PLUS_VOUCHER_ICON_CATEGORY = "alipay";
    private static final String DANA_DEALS_CATEGORY_ICON_SUFFIX = "category-deals-icon";
    private static final String DANA_VOUCHER_TYPE = "DANA_VOUCHER";
    private static final String DEFAULT_DEALS_AMOUNT = "0";
    private static final String DISCOUNT_RATE_SUFFIX = "%";
    private static final String ONLINE_VOUCHER_CATEGORY = "ONLINE";
    private static final String TAG = "DANA Deals Wallet";
    private static final int USED_DEALS_MARGIN_START = 8;
    public Map<Integer, View> _$_findViewCache;
    private final int cardIndex;
    private Disposable countdownDisposable;
    private final PublishSubject<Integer> countdownPublishSubject;
    private long expiryCountdown;
    private final WalletCardAssetClickListener onVoucherClickListener;
    private final VoucherAndTicketCardModel.DealsCard voucherAssetModel;

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
        return R.layout.dana_deals_wallet_v3_card;
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaDealsWalletV3CardView(Context context, WalletCardAssetClickListener walletCardAssetClickListener, VoucherAndTicketCardModel.DealsCard dealsCard, PublishSubject<Integer> publishSubject, int i) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(publishSubject, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onVoucherClickListener = walletCardAssetClickListener;
        this.voucherAssetModel = dealsCard;
        this.countdownPublishSubject = publishSubject;
        this.cardIndex = i;
        this.countdownDisposable = createTimeCounter();
    }

    public /* synthetic */ DanaDealsWalletV3CardView(Context context, WalletCardAssetClickListener walletCardAssetClickListener, VoucherAndTicketCardModel.DealsCard dealsCard, PublishSubject publishSubject, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : walletCardAssetClickListener, (i2 & 4) != 0 ? null : dealsCard, publishSubject, (i2 & 16) != 0 ? 0 : i);
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final CharSequence getCardInstId() {
        VoucherAndTicketCardModel.DealsCard dealsCard = this.voucherAssetModel;
        String pocketId = dealsCard != null ? dealsCard.getPocketId() : null;
        if (pocketId == null) {
            pocketId = "";
        }
        return pocketId;
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final void invokeListeners() {
        WalletCardAssetClickListener walletCardAssetClickListener;
        VoucherAndTicketCardModel.DealsCard dealsCard = this.voucherAssetModel;
        if (dealsCard == null || (walletCardAssetClickListener = this.onVoucherClickListener) == null) {
            return;
        }
        walletCardAssetClickListener.onCardClicked(dealsCard);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        initView();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable disposable = this.countdownDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    private final Disposable createTimeCounter() {
        Long expirationDate;
        VoucherAndTicketCardModel.DealsCard dealsCard = this.voucherAssetModel;
        if (dealsCard == null || (expirationDate = dealsCard.getExpirationDate()) == null) {
            return null;
        }
        final long longValue = expirationDate.longValue();
        return this.countdownPublishSubject.takeUntil(new Predicate() { // from class: id.dana.wallet_v3.view.walletcardview.DanaDealsWalletV3CardView$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean m3118createTimeCounter$lambda4$lambda1;
                m3118createTimeCounter$lambda4$lambda1 = DanaDealsWalletV3CardView.m3118createTimeCounter$lambda4$lambda1(longValue, (Integer) obj);
                return m3118createTimeCounter$lambda4$lambda1;
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).doOnError(new Consumer() { // from class: id.dana.wallet_v3.view.walletcardview.DanaDealsWalletV3CardView$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DanaDealsWalletV3CardView.m3119createTimeCounter$lambda4$lambda2((Throwable) obj);
            }
        }).subscribe(new Consumer() { // from class: id.dana.wallet_v3.view.walletcardview.DanaDealsWalletV3CardView$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DanaDealsWalletV3CardView.m3120createTimeCounter$lambda4$lambda3(DanaDealsWalletV3CardView.this, (Integer) obj);
            }
        });
    }

    /* renamed from: createTimeCounter$lambda-4$lambda-1 */
    public static final boolean m3118createTimeCounter$lambda4$lambda1(long j, Integer num) {
        Intrinsics.checkNotNullParameter(num, "");
        return ((long) num.intValue()) >= j;
    }

    /* renamed from: createTimeCounter$lambda-4$lambda-2 */
    public static final void m3119createTimeCounter$lambda4$lambda2(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("error on countdownObservable ");
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        sb.append(message);
        DanaLog.BuiltInFictitiousFunctionClassFactory(TAG, sb.toString());
    }

    /* renamed from: createTimeCounter$lambda-4$lambda-3 */
    public static final void m3120createTimeCounter$lambda4$lambda3(DanaDealsWalletV3CardView danaDealsWalletV3CardView, Integer num) {
        Intrinsics.checkNotNullParameter(danaDealsWalletV3CardView, "");
        Long expirationDate = danaDealsWalletV3CardView.voucherAssetModel.getExpirationDate();
        Intrinsics.checkNotNull(expirationDate);
        danaDealsWalletV3CardView.expiryCountdown = expirationDate.longValue() - System.currentTimeMillis();
        danaDealsWalletV3CardView.setupExpirationDate();
    }

    private final void initView() {
        VoucherAndTicketCardModel.DealsCard dealsCard = this.voucherAssetModel;
        String fontColor = dealsCard != null ? dealsCard.getFontColor() : null;
        if (fontColor == null) {
            fontColor = "";
        }
        setTextColor(StringExtKt.PlaceComponentResult(fontColor));
        VoucherAndTicketCardModel.DealsCard dealsCard2 = this.voucherAssetModel;
        String backgroundColor = dealsCard2 != null ? dealsCard2.getBackgroundColor() : null;
        if (backgroundColor == null) {
            backgroundColor = "";
        }
        setBackgroundColor(StringExtKt.PlaceComponentResult(backgroundColor));
        VoucherAndTicketCardModel.DealsCard dealsCard3 = this.voucherAssetModel;
        String categoryIconUrl = dealsCard3 != null ? dealsCard3.getCategoryIconUrl() : null;
        if (categoryIconUrl == null) {
            categoryIconUrl = "";
        }
        setCategoryIconSize(StringExtKt.PlaceComponentResult(categoryIconUrl));
        VoucherAndTicketCardModel.DealsCard dealsCard4 = this.voucherAssetModel;
        String fontColor2 = dealsCard4 != null ? dealsCard4.getFontColor() : null;
        if (fontColor2 == null) {
            fontColor2 = "";
        }
        setCategoryIconColor(StringExtKt.PlaceComponentResult(fontColor2));
        setupData();
        setupImage();
        VoucherAndTicketCardModel.DealsCard dealsCard5 = this.voucherAssetModel;
        String userPocketStatus = dealsCard5 != null ? dealsCard5.getUserPocketStatus() : null;
        setNewRibbon(Intrinsics.areEqual(userPocketStatus != null ? userPocketStatus : "", AssetStatus.USER_POCKET_STATUS_UNREAD));
        VoucherAndTicketCardModel.DealsCard dealsCard6 = this.voucherAssetModel;
        Boolean valueOf = dealsCard6 != null ? Boolean.valueOf(dealsCard6.getIsUsed()) : null;
        VoucherAndTicketCardModel.DealsCard dealsCard7 = this.voucherAssetModel;
        setupExpiredView(valueOf, dealsCard7 != null ? dealsCard7.getPocketStatus() : null);
    }

    private final void setTextColor(final String r2) {
        Function1<AppCompatTextView, Unit> function1 = new Function1<AppCompatTextView, Unit>() { // from class: id.dana.wallet_v3.view.walletcardview.DanaDealsWalletV3CardView$setTextColor$setLabelColor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(AppCompatTextView appCompatTextView) {
                invoke2(appCompatTextView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AppCompatTextView appCompatTextView) {
                Intrinsics.checkNotNullParameter(appCompatTextView, "");
                appCompatTextView.setTextColor(Color.parseColor(r2));
            }
        };
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.CashierShareBottomSheetDialog);
        if (appCompatTextView != null) {
            function1.invoke(appCompatTextView);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a17cd_daggersavingdetailcomponent_savingdetailcomponentimpl_postexecutionthreadprovider);
        if (appCompatTextView2 != null) {
            function1.invoke(appCompatTextView2);
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) _$_findCachedViewById(R.id.tv_minimum_trx);
        if (appCompatTextView3 != null) {
            function1.invoke(appCompatTextView3);
        }
        AppCompatTextView appCompatTextView4 = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a16f0_errorstatecardview_getwalletcardlistener_1);
        if (appCompatTextView4 != null) {
            function1.invoke(appCompatTextView4);
        }
        AppCompatTextView appCompatTextView5 = (AppCompatTextView) _$_findCachedViewById(R.id.tv_expired_date);
        if (appCompatTextView5 != null) {
            function1.invoke(appCompatTextView5);
        }
        AppCompatTextView appCompatTextView6 = (AppCompatTextView) _$_findCachedViewById(R.id.tv_currency);
        if (appCompatTextView6 != null) {
            function1.invoke(appCompatTextView6);
        }
        AppCompatTextView appCompatTextView7 = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a1618_snapshotcontroller_1);
        if (appCompatTextView7 != null) {
            function1.invoke(appCompatTextView7);
        }
        AppCompatTextView appCompatTextView8 = (AppCompatTextView) _$_findCachedViewById(R.id.tv_amount_symbol);
        if (appCompatTextView8 != null) {
            function1.invoke(appCompatTextView8);
        }
        AppCompatTextView appCompatTextView9 = (AppCompatTextView) _$_findCachedViewById(R.id.DoubleExponentialHistogramBuckets);
        if (appCompatTextView9 != null) {
            function1.invoke(appCompatTextView9);
        }
    }

    private final void setupData() {
        Long expirationDate;
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.CashierShareBottomSheetDialog);
        VoucherAndTicketCardModel.DealsCard dealsCard = this.voucherAssetModel;
        String label = dealsCard != null ? dealsCard.getLabel() : null;
        if (label == null) {
            label = "";
        }
        appCompatTextView.setText(label);
        VoucherAndTicketCardModel.DealsCard dealsCard2 = this.voucherAssetModel;
        String bizType = dealsCard2 != null ? dealsCard2.getBizType() : null;
        if (bizType == null) {
            bizType = "";
        }
        setCategoryName(bizType);
        VoucherAndTicketCardModel.DealsCard dealsCard3 = this.voucherAssetModel;
        String minTransaction = dealsCard3 != null ? dealsCard3.getMinTransaction() : null;
        if (minTransaction == null) {
            minTransaction = "";
        }
        setMinimumTrxAmount(minTransaction);
        VoucherAndTicketCardModel.DealsCard dealsCard4 = this.voucherAssetModel;
        String pocketType = dealsCard4 != null ? dealsCard4.getPocketType() : null;
        setAmountBasedOnAssetType(pocketType != null ? pocketType : "");
        VoucherAndTicketCardModel.DealsCard dealsCard5 = this.voucherAssetModel;
        this.expiryCountdown = ((dealsCard5 == null || (expirationDate = dealsCard5.getExpirationDate()) == null) ? 0L : expirationDate.longValue()) - System.currentTimeMillis();
        setupExpirationDate();
    }

    private final void setupImage() {
        VoucherAndTicketCardModel.DealsCard dealsCard = this.voucherAssetModel;
        String iconUrl = dealsCard != null ? dealsCard.getIconUrl() : null;
        if (iconUrl == null) {
            iconUrl = "";
        }
        String PlaceComponentResult = StringExtKt.PlaceComponentResult(iconUrl);
        ShapeableImageView shapeableImageView = (ShapeableImageView) _$_findCachedViewById(R.id.SendMoneyHomePresenter);
        Intrinsics.checkNotNullExpressionValue(shapeableImageView, "");
        loadIcon(PlaceComponentResult, shapeableImageView, R.drawable.ic_dana_deals_asset_icon_default);
        VoucherAndTicketCardModel.DealsCard dealsCard2 = this.voucherAssetModel;
        String categoryIconUrl = dealsCard2 != null ? dealsCard2.getCategoryIconUrl() : null;
        if (categoryIconUrl == null) {
            categoryIconUrl = "";
        }
        String PlaceComponentResult2 = StringExtKt.PlaceComponentResult(categoryIconUrl);
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.iv_logo_voucher_type);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        loadIcon(PlaceComponentResult2, appCompatImageView, getDefaultCategoryIcon());
    }

    private final void setupExpiredView(Boolean isUsed, String status) {
        if (Intrinsics.areEqual(isUsed, Boolean.TRUE)) {
            VoucherAndTicketCardModel.DealsCard dealsCard = this.voucherAssetModel;
            String backgroundColor = dealsCard != null ? dealsCard.getBackgroundColor() : null;
            if (backgroundColor == null) {
                backgroundColor = "";
            }
            showFold(StringExtKt.PlaceComponentResult(backgroundColor));
            setTagAndSpacing(status);
            return;
        }
        hideFold();
        hideStatusTag();
    }

    private final void setTagAndSpacing(String status) {
        if (Intrinsics.areEqual(AssetStatus.REDEEMED.getValue(), status)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.DialogTncInformation_ViewBinding_res_0x7f0a04ac);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) (constraintLayout != null ? constraintLayout.getLayoutParams() : null);
            int authRequestContext = SizeUtil.getAuthRequestContext(8);
            if (layoutParams != null) {
                layoutParams.setMargins(authRequestContext, 0, 0, 0);
            }
            showUsedStatusTag();
            return;
        }
        showExpiredStatusTag();
    }

    private final void setBackgroundColor(String backgroundColor) {
        ((AppCompatImageView) _$_findCachedViewById(R.id.iv_background_left_side)).setColorFilter(Color.parseColor(backgroundColor));
        ((AppCompatImageView) _$_findCachedViewById(R.id.iv_background_right_side)).setColorFilter(Color.parseColor(backgroundColor));
    }

    private final void loadIcon(String url, AppCompatImageView view, int r4) {
        if (SvgLoader.getAuthRequestContext(url)) {
            loadSvgImage(url, view, r4);
        } else {
            loadPngImage(url, view, r4);
        }
    }

    private final void loadSvgImage(String url, AppCompatImageView view, int r4) {
        Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult(url).MyBillsEntityDataFactory(r4).MyBillsEntityDataFactory((ImageView) view);
    }

    private final void loadPngImage(String url, AppCompatImageView view, int r4) {
        Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getAuthRequestContext(url).MyBillsEntityDataFactory(r4).MyBillsEntityDataFactory((ImageView) view);
    }

    private final void setCategoryIconSize(String url) {
        if (StringsKt.contains((CharSequence) url, (CharSequence) DANA_DEALS_CATEGORY_ICON_SUFFIX, true)) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.iv_logo_voucher_type);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            ViewExtKt.getAuthRequestContext(appCompatImageView, Integer.valueOf(getResources().getDimensionPixelSize(R.dimen.f28512131165353)), Integer.valueOf(getResources().getDimensionPixelSize(R.dimen.f28502131165352)));
        }
    }

    private final void showExpiredStatusTag() {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.v_dana_deals_status_tag);
        _$_findCachedViewById.setVisibility(0);
        ((AppCompatImageView) _$_findCachedViewById.findViewById(R.id.iv_status)).setImageDrawable(ContextCompat.PlaceComponentResult(_$_findCachedViewById.getContext(), (int) R.drawable.ic_failed_red50_filled_circle));
        ((AppCompatTextView) _$_findCachedViewById.findViewById(R.id.res_0x7f0a18fe_activityverificationstatemanager_activityverificationstate_canceled)).setText(_$_findCachedViewById.getResources().getString(R.string.dana_deals_ticket_tag_expired));
    }

    private final void showUsedStatusTag() {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.v_dana_deals_status_tag);
        _$_findCachedViewById.setVisibility(0);
        ((AppCompatImageView) _$_findCachedViewById.findViewById(R.id.iv_status)).setImageDrawable(ContextCompat.PlaceComponentResult(_$_findCachedViewById.getContext(), (int) R.drawable.ic_check_24_green50_filled_circle));
        ((AppCompatTextView) _$_findCachedViewById.findViewById(R.id.res_0x7f0a18fe_activityverificationstatemanager_activityverificationstate_canceled)).setText(_$_findCachedViewById.getResources().getString(R.string.dana_deals_ticket_tag_used));
    }

    private final void hideStatusTag() {
        _$_findCachedViewById(R.id.v_dana_deals_status_tag).setVisibility(8);
    }

    private final void showFold(String backgroundColor) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0b2a_getemergencynotifconfig_lambda_179);
        appCompatImageView.setVisibility(0);
        appCompatImageView.setColorFilter(Color.parseColor(backgroundColor));
        ((AppCompatImageView) _$_findCachedViewById(R.id.iv_fold_outline)).setVisibility(0);
        ((AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0c5b_r8_lambda_bz5qhtcn1w1_tjnl791ajh1_rvy)).setVisibility(0);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iv_background_right_side_cutted_outline)).setVisibility(0);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iv_background_right_side_outline)).setVisibility(8);
    }

    private final void hideFold() {
        ((AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0b2a_getemergencynotifconfig_lambda_179)).setVisibility(8);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iv_fold_outline)).setVisibility(8);
        ((AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0c5b_r8_lambda_bz5qhtcn1w1_tjnl791ajh1_rvy)).setVisibility(8);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iv_background_right_side_cutted_outline)).setVisibility(8);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iv_background_right_side_outline)).setVisibility(0);
    }

    private final void setAmountBasedOnAssetType(String assetType) {
        String amount;
        if (Intrinsics.areEqual(assetType, AssetType.DISCOUNT_COUPON.getAsset())) {
            VoucherAndTicketCardModel.DealsCard dealsCard = this.voucherAssetModel;
            amount = dealsCard != null ? dealsCard.getDiscountRate() : null;
            setDiscountRate(amount != null ? amount : "");
            return;
        }
        VoucherAndTicketCardModel.DealsCard dealsCard2 = this.voucherAssetModel;
        amount = dealsCard2 != null ? dealsCard2.getAmount() : null;
        setAmountSuffix(amount != null ? amount : "");
    }

    private final void setAmountSuffix(String amount) {
        NumberUtil numberUtil = NumberUtil.INSTANCE;
        String KClassImpl$Data$declaredNonStaticMembers$2 = NumberUtil.KClassImpl$Data$declaredNonStaticMembers$2(amount);
        String str = KClassImpl$Data$declaredNonStaticMembers$2;
        if ((str.length() > 0) && Integer.parseInt(KClassImpl$Data$declaredNonStaticMembers$2) > 9999) {
            NumberFormatterUtil numberFormatterUtil = NumberFormatterUtil.INSTANCE;
            Pair<String, String> MyBillsEntityDataFactory = NumberFormatterUtil.MyBillsEntityDataFactory(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), KClassImpl$Data$declaredNonStaticMembers$2);
            ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a1618_snapshotcontroller_1)).setText(MyBillsEntityDataFactory.getFirst());
            ((AppCompatTextView) _$_findCachedViewById(R.id.tv_amount_symbol)).setText(MyBillsEntityDataFactory.getSecond());
            return;
        }
        if ((str.length() > 0) && Integer.parseInt(KClassImpl$Data$declaredNonStaticMembers$2) > 0) {
            ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a1618_snapshotcontroller_1)).setText(amount);
        } else {
            ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a1618_snapshotcontroller_1)).setText("0");
        }
    }

    private final void setDiscountRate(String discountRate) {
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_currency)).setVisibility(8);
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a1618_snapshotcontroller_1)).setText(StringsKt.trim((CharSequence) StringsKt.replace$default(discountRate, DISCOUNT_RATE_SUFFIX, "", false, 4, (Object) null)).toString());
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_amount_symbol)).setText(DISCOUNT_RATE_SUFFIX);
    }

    private final void setMinimumTrxAmount(String minTransaction) {
        String string;
        NumberUtil numberUtil = NumberUtil.INSTANCE;
        String obj = StringsKt.trim((CharSequence) StringsKt.replace(NumberUtil.KClassImpl$Data$declaredNonStaticMembers$2(minTransaction), "rp", "", true)).toString();
        String str = obj;
        if (!(str.length() == 0)) {
            if (!(str.length() > 0) || Long.parseLong(obj) != 0) {
                string = formatAmount(obj);
                Intrinsics.checkNotNullExpressionValue(string, "");
                AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tv_minimum_trx);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string2 = getContext().getString(R.string.dana_deals_min_trx);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                String format = String.format(string2, Arrays.copyOf(new Object[]{string}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                appCompatTextView.setText(format);
            }
        }
        string = getContext().getString(R.string.dana_deals_no_min_trx);
        Intrinsics.checkNotNullExpressionValue(string, "");
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.tv_minimum_trx);
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string22 = getContext().getString(R.string.dana_deals_min_trx);
        Intrinsics.checkNotNullExpressionValue(string22, "");
        String format2 = String.format(string22, Arrays.copyOf(new Object[]{string}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "");
        appCompatTextView2.setText(format2);
    }

    private final void setCategoryIconColor(String iconColor) {
        VoucherAndTicketCardModel.DealsCard dealsCard = this.voucherAssetModel;
        String categoryIconUrl = dealsCard != null ? dealsCard.getCategoryIconUrl() : null;
        if (categoryIconUrl == null) {
            categoryIconUrl = "";
        }
        if (StringsKt.contains((CharSequence) StringExtKt.PlaceComponentResult(categoryIconUrl), (CharSequence) A_PLUS_VOUCHER_ICON_CATEGORY, true)) {
            return;
        }
        ((AppCompatImageView) _$_findCachedViewById(R.id.iv_logo_voucher_type)).setColorFilter(Color.parseColor(iconColor));
    }

    private final void setupExpirationDate() {
        Unit unit;
        Long expirationDate;
        VoucherAndTicketCardModel.DealsCard dealsCard = this.voucherAssetModel;
        if (dealsCard == null || (expirationDate = dealsCard.getExpirationDate()) == null) {
            unit = null;
        } else {
            long longValue = expirationDate.longValue();
            if (longValue < 0) {
                setNoExpirationDate();
            } else {
                String pocketStatus = this.voucherAssetModel.getPocketStatus();
                if (Intrinsics.areEqual(pocketStatus, AssetStatus.EXPIRED.name()) ? true : Intrinsics.areEqual(pocketStatus, AssetStatus.REDEEMED.name())) {
                    setExpirationInDateFormat(longValue);
                } else {
                    setNormalStateExpiredDate(longValue);
                }
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            setNoExpirationDate();
        }
    }

    private final void setNormalStateExpiredDate(long voucherExpirationDate) {
        int MyBillsEntityDataFactory = DateTimeUtil.MyBillsEntityDataFactory(new Date(voucherExpirationDate));
        if (MyBillsEntityDataFactory > 168) {
            setExpirationInDateFormat(voucherExpirationDate);
        } else if (MyBillsEntityDataFactory > 24) {
            setExpirationInDaysFormat(voucherExpirationDate);
        } else {
            setExpirationInTimeFormat(this.expiryCountdown);
        }
    }

    private final void setExpirationInDateFormat(long voucherExpirationDate) {
        Locale locale;
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a16f0_errorstatecardview_getwalletcardlistener_1)).setText(getResources().getString(R.string.dana_deals_ticket_expired_title));
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tv_expired_date);
        Date date = new Date(voucherExpirationDate);
        locale = Locale.getDefault();
        appCompatTextView.setText(DateTimeUtil.MyBillsEntityDataFactory(date, "dd MMM yyyy", locale));
    }

    private final void setExpirationInDaysFormat(long voucherExpirationDate) {
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a16f0_errorstatecardview_getwalletcardlistener_1)).setText(getResources().getString(R.string.dana_deals_ticket_almost_expired_title));
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_expired_date)).setText(getContext().getResources().getString(R.string.dana_deals_expired_in_days, String.valueOf(DateTimeUtil.PlaceComponentResult(new Date(voucherExpirationDate)))));
    }

    private final void setExpirationInTimeFormat(long voucherExpirationDate) {
        long j = voucherExpirationDate / 3600000;
        long j2 = voucherExpirationDate % 3600000;
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_expired_date)).setText(getContext().getResources().getString(R.string.dana_deals_expired_in_hours, Long.valueOf(j), Long.valueOf(j2 / 60000), Long.valueOf((j2 % 60000) / 1000)));
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a16f0_errorstatecardview_getwalletcardlistener_1)).setText(getResources().getString(R.string.dana_deals_ticket_almost_expired_title));
    }

    private final void setNoExpirationDate() {
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a16f0_errorstatecardview_getwalletcardlistener_1)).setText(getResources().getString(R.string.dana_deals_ticket_expired_title));
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_expired_date)).setText(getResources().getString(R.string.dana_deals_no_expired_value));
    }

    private final void setCategoryName(String bizType) {
        if (Intrinsics.areEqual(bizType, "DANA_VOUCHER")) {
            VoucherAndTicketCardModel.DealsCard dealsCard = this.voucherAssetModel;
            checkIsOnlineMerchant(dealsCard != null && dealsCard.isOnlineMerchant());
        } else if (Intrinsics.areEqual(bizType, AGGREGATOR_VOUCHER_TYPE)) {
            VoucherAndTicketCardModel.DealsCard dealsCard2 = this.voucherAssetModel;
            checkIsOnlineMerchant(StringsKt.equals(dealsCard2 != null ? dealsCard2.getRedemptionType() : null, ONLINE_VOUCHER_CATEGORY, true));
        } else {
            ((AppCompatTextView) _$_findCachedViewById(R.id.DoubleExponentialHistogramBuckets)).setText(getResources().getString(R.string.deals_injection_category));
        }
    }

    private final void checkIsOnlineMerchant(boolean isOnlineMerchant) {
        String providerCategory;
        String offlineCategoryName;
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.DoubleExponentialHistogramBuckets);
        if (isOnlineMerchant) {
            VoucherAndTicketCardModel.DealsCard dealsCard = this.voucherAssetModel;
            providerCategory = dealsCard != null ? dealsCard.getProviderCategory() : null;
            if (providerCategory == null) {
                providerCategory = "";
            }
            String upperCase = providerCategory.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            offlineCategoryName = getOnlineCategoryName(upperCase);
        } else {
            VoucherAndTicketCardModel.DealsCard dealsCard2 = this.voucherAssetModel;
            providerCategory = dealsCard2 != null ? dealsCard2.getProviderCategory() : null;
            if (providerCategory == null) {
                providerCategory = "";
            }
            String upperCase2 = providerCategory.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "");
            offlineCategoryName = getOfflineCategoryName(upperCase2);
        }
        appCompatTextView.setText(offlineCategoryName);
    }

    private final String getOfflineCategoryName(String categoryType) {
        switch (categoryType.hashCode()) {
            case -1233091606:
                if (categoryType.equals("TRAVEL_&_ENTERTAINMENT")) {
                    String string = getResources().getString(R.string.deals_offline_category_travel_and_entertainment);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    return string;
                }
                break;
            case 68514:
                if (categoryType.equals("F&B")) {
                    String string2 = getResources().getString(R.string.deals_offline_category_fnb);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    return string2;
                }
                break;
            case 352210232:
                if (categoryType.equals("HEALTH_&_BEAUTY")) {
                    String string3 = getResources().getString(R.string.deals_offline_category_health_and_beauty);
                    Intrinsics.checkNotNullExpressionValue(string3, "");
                    return string3;
                }
                break;
            case 2095065135:
                if (categoryType.equals("GAMING")) {
                    String string4 = getResources().getString(R.string.deals_offline_category_gaming);
                    Intrinsics.checkNotNullExpressionValue(string4, "");
                    return string4;
                }
                break;
        }
        String string5 = getResources().getString(R.string.deals_offline_category_shopping_and_other);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        return string5;
    }

    private final String getOnlineCategoryName(String categoryType) {
        if (Intrinsics.areEqual(categoryType, "INVESTMENT")) {
            String string = getResources().getString(R.string.deals_online_category_investment);
            Intrinsics.checkNotNullExpressionValue(string, "");
            return string;
        }
        String string2 = getResources().getString(R.string.deals_online_category_lifestyle_and_other);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        return string2;
    }

    private final int getDefaultCategoryIcon() {
        VoucherAndTicketCardModel.DealsCard dealsCard = this.voucherAssetModel;
        String bizType = dealsCard != null ? dealsCard.getBizType() : null;
        return bizType == null || bizType.length() == 0 ? R.drawable.ic_dana_cropped : R.drawable.ic_dana_deals_category_light;
    }

    private final void setNewRibbon(boolean isNew) {
        VoucherAndTicketCardModel.DealsCard dealsCard = this.voucherAssetModel;
        String pocketStatus = dealsCard != null ? dealsCard.getPocketStatus() : null;
        if (pocketStatus == null) {
            pocketStatus = "";
        }
        if (!AssetStatusKt.isExpiredOrRedeemed(pocketStatus) && shouldShowFlag(isNew)) {
            ((AppCompatImageView) _$_findCachedViewById(R.id.iv_deals_new_ribbon)).setVisibility(0);
        } else {
            ((AppCompatImageView) _$_findCachedViewById(R.id.iv_deals_new_ribbon)).setVisibility(8);
        }
    }

    private final boolean shouldShowFlag(boolean isNew) {
        return isNew && this.cardIndex <= 2;
    }

    private final String formatAmount(String str) {
        return StringsKt.reversed((CharSequence) CollectionsKt.joinToString$default(StringsKt.chunked(StringsKt.reversed((CharSequence) str).toString(), 3), ".", null, null, 0, null, null, 62, null)).toString();
    }
}

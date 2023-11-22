package id.dana.wallet_v3.view.walletcardview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import com.alibaba.griver.core.GriverParams;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.pocket.model.AssetStatusKt;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import id.dana.domain.wallet_v3.model.AssetType;
import id.dana.extension.lang.StringExtKt;
import id.dana.glidetransformations.MaskTransformation;
import id.dana.richview.wallet.BaseWalletCustomCardView;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.ShareableRpcInfoModel;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 F2\u00020\u0001:\u0001FB;\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\u0006\u0010B\u001a\u00020A\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\b0;\u0012\b\b\u0002\u00107\u001a\u00020\b¢\u0006\u0004\bD\u0010EJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0015\u0010\rJ\u000f\u0010\u0016\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0016\u0010\rJ/\u0010\u001e\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010 \u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b(\u0010'J\u0017\u0010)\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b)\u0010'J\u000f\u0010*\u001a\u00020\u000bH\u0002¢\u0006\u0004\b*\u0010\rJ\u0017\u0010,\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000fH\u0002¢\u0006\u0004\b,\u0010\u0012J\u000f\u0010-\u001a\u00020\u000bH\u0016¢\u0006\u0004\b-\u0010\rJ\u000f\u0010.\u001a\u00020\u000bH\u0002¢\u0006\u0004\b.\u0010\rJ\u000f\u0010/\u001a\u00020\u000bH\u0002¢\u0006\u0004\b/\u0010\rJ\u000f\u00100\u001a\u00020\u000bH\u0002¢\u0006\u0004\b0\u0010\rJ\u0017\u00101\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001cH\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u000bH\u0002¢\u0006\u0004\b3\u0010\rJ\u000f\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0004\b4\u0010\rJ\u000f\u00105\u001a\u00020\u000bH\u0002¢\u0006\u0004\b5\u0010\rJ\u000f\u00106\u001a\u00020\u000bH\u0002¢\u0006\u0004\b6\u0010\rR\u0014\u00107\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u00109\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\b0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u0004\u0018\u00010>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010C"}, d2 = {"Lid/dana/wallet_v3/view/walletcardview/VoucherWalletV3CardView;", "Lid/dana/richview/wallet/BaseWalletCustomCardView;", "Lio/reactivex/disposables/Disposable;", "createTimeCounter", "()Lio/reactivex/disposables/Disposable;", "", "getCardInstId", "()Ljava/lang/CharSequence;", "", "getLayout", "()I", "", "initView", "()V", "invokeListeners", "", "backgroundUrl", "loadBackgroundImage", "(Ljava/lang/String;)V", DecodedScanBizInfoKey.LOGO_URL, "loadLogoImage", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/content/Context;", HummerConstants.CONTEXT, GriverParams.ShareParams.IMAGE_URL, "Landroid/widget/ImageView;", "imageView", "", "useCutout", "setImagePng", "(Landroid/content/Context;Ljava/lang/String;Landroid/widget/ImageView;Z)V", "setImageSvg", "isNew", "setNewRibbon", "(Z)V", "", "voucherExpirationDate", "setVoucherDateInDayFormat", "(J)V", "setVoucherDateInMonthFormat", "setVoucherDateInTimeFormat", "setVoucherDateToNoExpiringDate", "iconUrl", "setVoucherLogoBackground", "setup", "setupExpirationDate", "setupImages", "setupStaticDatas", "shouldShowFlag", "(Z)Z", "switchToExpiredState", "switchToNormalState", "switchToRedeemedState", "switchToTransferredState", "cardIndex", "I", "countdownDisposable", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/subjects/PublishSubject;", "countdownPublishSubject", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "onVoucherClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$VoucherCard;", "voucherAssetModel", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$VoucherCard;", "<init>", "(Landroid/content/Context;Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$VoucherCard;Lio/reactivex/subjects/PublishSubject;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VoucherWalletV3CardView extends BaseWalletCustomCardView {
    public static final String TAG = "VoucherSection";
    private static final float VOUCHER_VERTICAL_BIAS = 0.7f;
    public Map<Integer, View> _$_findViewCache;
    private final int cardIndex;
    private Disposable countdownDisposable;
    private final PublishSubject<Integer> countdownPublishSubject;
    private final WalletCardAssetClickListener onVoucherClickListener;
    private final VoucherAndTicketCardModel.VoucherCard voucherAssetModel;

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
        return R.layout.voucher_wallet_v3_card;
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoucherWalletV3CardView(Context context, WalletCardAssetClickListener walletCardAssetClickListener, VoucherAndTicketCardModel.VoucherCard voucherCard, PublishSubject<Integer> publishSubject, int i) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(voucherCard, "");
        Intrinsics.checkNotNullParameter(publishSubject, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onVoucherClickListener = walletCardAssetClickListener;
        this.voucherAssetModel = voucherCard;
        this.countdownPublishSubject = publishSubject;
        this.cardIndex = i;
        this.countdownDisposable = createTimeCounter();
    }

    public /* synthetic */ VoucherWalletV3CardView(Context context, WalletCardAssetClickListener walletCardAssetClickListener, VoucherAndTicketCardModel.VoucherCard voucherCard, PublishSubject publishSubject, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : walletCardAssetClickListener, voucherCard, publishSubject, (i2 & 16) != 0 ? 0 : i);
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final CharSequence getCardInstId() {
        return this.voucherAssetModel.getPocketId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        initView();
    }

    private final Disposable createTimeCounter() {
        Long expirationDate = this.voucherAssetModel.getExpirationDate();
        if (expirationDate != null) {
            final long longValue = expirationDate.longValue();
            return this.countdownPublishSubject.takeUntil(new Predicate() { // from class: id.dana.wallet_v3.view.walletcardview.VoucherWalletV3CardView$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean m3135createTimeCounter$lambda3$lambda0;
                    m3135createTimeCounter$lambda3$lambda0 = VoucherWalletV3CardView.m3135createTimeCounter$lambda3$lambda0(longValue, (Integer) obj);
                    return m3135createTimeCounter$lambda3$lambda0;
                }
            }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).doOnError(new Consumer() { // from class: id.dana.wallet_v3.view.walletcardview.VoucherWalletV3CardView$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VoucherWalletV3CardView.m3136createTimeCounter$lambda3$lambda1((Throwable) obj);
                }
            }).subscribe(new Consumer() { // from class: id.dana.wallet_v3.view.walletcardview.VoucherWalletV3CardView$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VoucherWalletV3CardView.m3137createTimeCounter$lambda3$lambda2(VoucherWalletV3CardView.this, (Integer) obj);
                }
            });
        }
        return null;
    }

    /* renamed from: createTimeCounter$lambda-3$lambda-0 */
    public static final boolean m3135createTimeCounter$lambda3$lambda0(long j, Integer num) {
        Intrinsics.checkNotNullParameter(num, "");
        return ((long) num.intValue()) >= j;
    }

    /* renamed from: createTimeCounter$lambda-3$lambda-1 */
    public static final void m3136createTimeCounter$lambda3$lambda1(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("error on countdownObservable ");
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        sb.append(message);
        DanaLog.BuiltInFictitiousFunctionClassFactory(TAG, sb.toString());
    }

    /* renamed from: createTimeCounter$lambda-3$lambda-2 */
    public static final void m3137createTimeCounter$lambda3$lambda2(VoucherWalletV3CardView voucherWalletV3CardView, Integer num) {
        Intrinsics.checkNotNullParameter(voucherWalletV3CardView, "");
        VoucherAndTicketCardModel.VoucherCard voucherCard = voucherWalletV3CardView.voucherAssetModel;
        Long expirationDate = voucherCard.getExpirationDate();
        Intrinsics.checkNotNull(expirationDate);
        voucherCard.setExpirationDate(Long.valueOf(expirationDate.longValue() - 1000));
        voucherWalletV3CardView.setupStaticDatas();
    }

    private final void initView() {
        setupStaticDatas();
        setupImages();
        MaterialCardView materialCardView = (MaterialCardView) _$_findCachedViewById(R.id.res_0x7f0a0583_trustedlistenablefuturetask_trustedfutureinterruptibleasynctask);
        Intrinsics.checkNotNullExpressionValue(materialCardView, "");
        setToGrayScale(materialCardView, this.voucherAssetModel.getIsUsed());
        setNewRibbon(Intrinsics.areEqual(this.voucherAssetModel.getUserPocketStatus(), AssetStatus.USER_POCKET_STATUS_UNREAD));
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final void invokeListeners() {
        WalletCardAssetClickListener walletCardAssetClickListener = this.onVoucherClickListener;
        if (walletCardAssetClickListener != null) {
            walletCardAssetClickListener.onCardClicked(this.voucherAssetModel);
        }
    }

    private final void setupStaticDatas() {
        String BuiltInFictitiousFunctionClassFactory;
        if (Intrinsics.areEqual(AssetType.VOUCHER.getAsset(), this.voucherAssetModel.getPocketType())) {
            BuiltInFictitiousFunctionClassFactory = this.voucherAssetModel.getSubLabel();
        } else {
            BuiltInFictitiousFunctionClassFactory = StringExtKt.BuiltInFictitiousFunctionClassFactory(this.voucherAssetModel.getAmount());
        }
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_pocket_voucher_title)).setText(this.voucherAssetModel.getLabel());
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_pocket_voucher_value)).setText(BuiltInFictitiousFunctionClassFactory);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_pocket_voucher_amount_transaction)).setText(this.voucherAssetModel.getShortDescription());
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0c36_horizontalquestadapter_dividerviewholder);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(this.voucherAssetModel.getShareable() ? 0 : 8);
        String pocketStatus = this.voucherAssetModel.getPocketStatus();
        if (Intrinsics.areEqual(pocketStatus, AssetStatus.EXPIRED.name())) {
            switchToExpiredState();
        } else if (Intrinsics.areEqual(pocketStatus, AssetStatus.REDEEMED.name())) {
            switchToRedeemedState();
        } else if (Intrinsics.areEqual(pocketStatus, AssetStatus.TRANSFERRED.name())) {
            switchToTransferredState();
        } else {
            switchToNormalState();
        }
    }

    private final void switchToRedeemedState() {
        Locale locale;
        Long expirationDate = this.voucherAssetModel.getExpirationDate();
        if (expirationDate != null) {
            long longValue = expirationDate.longValue();
            ((Group) _$_findCachedViewById(R.id.group_voucher_date)).setVisibility(8);
            ((Group) _$_findCachedViewById(R.id.group_voucher_amount_transaction)).setVisibility(0);
            ((Group) _$_findCachedViewById(R.id.res_0x7f0a0814_inputcardnumberview_iconcarderrorhandlinglistener_1)).setVisibility(8);
            ((Group) _$_findCachedViewById(R.id.group_expired_at)).setVisibility(0);
            AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a183d_credentialproviderbeginsignincontroller_handleresponse_5_externalsyntheticlambda0);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getContext().getString(R.string.pocket_voucher_used);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Date date = new Date(longValue);
            locale = Locale.getDefault();
            String format = String.format(string, Arrays.copyOf(new Object[]{DateTimeUtil.MyBillsEntityDataFactory(date, "dd MMM yyyy", locale)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            appCompatTextView.setText(format);
        }
    }

    private final void switchToTransferredState() {
        String receiverInfo;
        ShareableRpcInfoModel shareableRpcInfo = this.voucherAssetModel.getShareableRpcInfo();
        if (shareableRpcInfo == null || (receiverInfo = shareableRpcInfo.getReceiverInfo()) == null) {
            return;
        }
        if (receiverInfo.length() > 0) {
            ((Group) _$_findCachedViewById(R.id.group_voucher_date)).setVisibility(8);
            ((Group) _$_findCachedViewById(R.id.res_0x7f0a0814_inputcardnumberview_iconcarderrorhandlinglistener_1)).setVisibility(0);
            ((Group) _$_findCachedViewById(R.id.group_expired_at)).setVisibility(8);
            ((Group) _$_findCachedViewById(R.id.group_voucher_amount_transaction)).setVisibility(0);
            ((AppCompatTextView) _$_findCachedViewById(R.id.tv_pocket_sent_to)).setText(getContext().getResources().getString(R.string.pocket_voucher_sent, receiverInfo));
        }
    }

    private final void switchToExpiredState() {
        Locale locale;
        Long expirationDate = this.voucherAssetModel.getExpirationDate();
        if (expirationDate != null) {
            long longValue = expirationDate.longValue();
            ((Group) _$_findCachedViewById(R.id.group_voucher_date)).setVisibility(8);
            ((Group) _$_findCachedViewById(R.id.res_0x7f0a0814_inputcardnumberview_iconcarderrorhandlinglistener_1)).setVisibility(8);
            ((Group) _$_findCachedViewById(R.id.group_expired_at)).setVisibility(0);
            AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a183d_credentialproviderbeginsignincontroller_handleresponse_5_externalsyntheticlambda0);
            Resources resources = getContext().getResources();
            Date date = new Date(longValue);
            locale = Locale.getDefault();
            appCompatTextView.setText(resources.getString(R.string.pocket_voucher_expired_in_date, DateTimeUtil.MyBillsEntityDataFactory(date, "dd MMM yyyy", locale)));
        }
    }

    private final void switchToNormalState() {
        setupExpirationDate();
        ((Group) _$_findCachedViewById(R.id.res_0x7f0a0814_inputcardnumberview_iconcarderrorhandlinglistener_1)).setVisibility(8);
        ((Group) _$_findCachedViewById(R.id.group_expired_at)).setVisibility(8);
        if (this.voucherAssetModel.getShortDescription().length() == 0) {
            ((Group) _$_findCachedViewById(R.id.group_voucher_amount_transaction)).setVisibility(8);
            ViewGroup.LayoutParams layoutParams = ((AppCompatImageView) _$_findCachedViewById(R.id.iv_pocket_voucher_amount_transaction)).getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.flip = 0.7f;
            AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.iv_pocket_voucher_amount_transaction);
            if (appCompatImageView != null) {
                appCompatImageView.setLayoutParams(layoutParams2);
            }
        } else {
            ((Group) _$_findCachedViewById(R.id.group_voucher_amount_transaction)).setVisibility(0);
        }
        ((Group) _$_findCachedViewById(R.id.group_voucher_date)).setVisibility(0);
    }

    private final void setupImages() {
        if (Intrinsics.areEqual(AssetType.VOUCHER.getAsset(), this.voucherAssetModel.getPocketType())) {
            String PlaceComponentResult = StringExtKt.PlaceComponentResult(this.voucherAssetModel.getIconUrl());
            setVoucherLogoBackground(PlaceComponentResult);
            loadLogoImage(PlaceComponentResult);
        } else {
            String PlaceComponentResult2 = StringExtKt.PlaceComponentResult(this.voucherAssetModel.getLogoUrl());
            setVoucherLogoBackground(PlaceComponentResult2);
            loadLogoImage(PlaceComponentResult2);
        }
        loadBackgroundImage(StringExtKt.PlaceComponentResult(this.voucherAssetModel.getBackgroundUrl()));
    }

    private final void setVoucherLogoBackground(String iconUrl) {
        if (iconUrl.length() == 0) {
            ((AppCompatImageView) _$_findCachedViewById(R.id.iv_pocket_voucher_logo)).setBackground(null);
        } else {
            ((AppCompatImageView) _$_findCachedViewById(R.id.iv_pocket_voucher_logo)).setBackground(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.bg_rounded_white_6dp));
        }
    }

    private final void loadLogoImage(String r5) {
        if (SvgLoader.getAuthRequestContext(r5)) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.iv_pocket_voucher_logo);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            setImageSvg(context, r5, appCompatImageView, false);
            return;
        }
        Context context2 = getContext();
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.iv_pocket_voucher_logo);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
        setImagePng(context2, r5, appCompatImageView2, false);
    }

    private final void loadBackgroundImage(String backgroundUrl) {
        if (SvgLoader.getAuthRequestContext(backgroundUrl)) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.iv_pocket_background_with_illustration);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            setImageSvg(context, backgroundUrl, appCompatImageView, true);
            return;
        }
        Context context2 = getContext();
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.iv_pocket_background_with_illustration);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
        setImagePng(context2, backgroundUrl, appCompatImageView2, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x003e, code lost:
    
        if (r3.getIsOn() != false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setupExpirationDate() {
        /*
            r5 = this;
            id.dana.wallet_v3.model.VoucherAndTicketCardModel$VoucherCard r0 = r5.voucherAssetModel
            java.lang.Long r0 = r0.getExpirationDate()
            if (r0 == 0) goto L4e
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L18
            r5.setVoucherDateToNoExpiringDate()
            goto L4b
        L18:
            java.util.Date r2 = new java.util.Date
            r2.<init>(r0)
            int r2 = id.dana.utils.DateTimeUtil.MyBillsEntityDataFactory(r2)
            r3 = 730(0x2da, float:1.023E-42)
            if (r2 <= r3) goto L29
            r5.setVoucherDateInMonthFormat(r0)
            goto L4b
        L29:
            id.dana.wallet_v3.model.VoucherAndTicketCardModel$VoucherCard r3 = r5.voucherAssetModel
            id.dana.wallet_v3.model.PocketAssetTimerConfigModel r3 = r3.getPocketAssetTimerConfigModel()
            if (r3 == 0) goto L40
            id.dana.wallet_v3.model.VoucherAndTicketCardModel$VoucherCard r3 = r5.voucherAssetModel
            id.dana.wallet_v3.model.PocketAssetTimerConfigModel r3 = r3.getPocketAssetTimerConfigModel()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            boolean r3 = r3.getIsOn()
            if (r3 == 0) goto L44
        L40:
            r3 = 24
            if (r2 <= r3) goto L48
        L44:
            r5.setVoucherDateInDayFormat(r0)
            goto L4b
        L48:
            r5.setVoucherDateInTimeFormat(r0)
        L4b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L4f
        L4e:
            r0 = 0
        L4f:
            if (r0 != 0) goto L54
            r5.setVoucherDateToNoExpiringDate()
        L54:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.walletcardview.VoucherWalletV3CardView.setupExpirationDate():void");
    }

    private final void setVoucherDateInMonthFormat(long voucherExpirationDate) {
        Locale locale;
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.MixpanelPushVerifyTracker_Factory);
        Resources resources = getContext().getResources();
        Date date = new Date(voucherExpirationDate);
        locale = Locale.getDefault();
        appCompatTextView.setText(resources.getString(R.string.pocket_voucher_expired_in_months, DateTimeUtil.MyBillsEntityDataFactory(date, "MMM yyyy", locale)));
    }

    private final void setVoucherDateInDayFormat(long voucherExpirationDate) {
        ((AppCompatTextView) _$_findCachedViewById(R.id.MixpanelPushVerifyTracker_Factory)).setText(getContext().getResources().getString(R.string.pocket_voucher_expired_in_days, String.valueOf(Math.abs(DateTimeUtil.MyBillsEntityDataFactory(new Date(), new Date(voucherExpirationDate))))));
    }

    private final void setVoucherDateInTimeFormat(long voucherExpirationDate) {
        Locale locale;
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.MixpanelPushVerifyTracker_Factory);
        Date date = new Date(voucherExpirationDate);
        locale = Locale.getDefault();
        appCompatTextView.setText(DateTimeUtil.MyBillsEntityDataFactory(date, "HH:mm:ss", locale));
    }

    private final void setVoucherDateToNoExpiringDate() {
        ((AppCompatTextView) _$_findCachedViewById(R.id.MixpanelPushVerifyTracker_Factory)).setText(getContext().getString(R.string.pocket_voucher_no_expire_date));
    }

    private final void setNewRibbon(boolean isNew) {
        if (!AssetStatusKt.isExpiredOrRedeemed(this.voucherAssetModel.getPocketStatus()) && shouldShowFlag(isNew)) {
            ((AppCompatImageView) _$_findCachedViewById(R.id.iv_deals_new_ribbon)).setVisibility(0);
        } else {
            ((AppCompatImageView) _$_findCachedViewById(R.id.iv_deals_new_ribbon)).setVisibility(8);
        }
    }

    private final boolean shouldShowFlag(boolean isNew) {
        return isNew && this.cardIndex <= 2;
    }

    public final void setImageSvg(Context r4, String r5, ImageView imageView, boolean useCutout) {
        Intrinsics.checkNotNullParameter(r4, "");
        Intrinsics.checkNotNullParameter(r5, "");
        Intrinsics.checkNotNullParameter(imageView, "");
        SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(r4);
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = r5;
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = new RequestOptions().PlaceComponentResult(r4.getResources().getDimensionPixelSize(R.dimen.f34202131166214), r4.getResources().getDimensionPixelSize(R.dimen.f34192131166209));
        if (useCutout) {
            KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = new MaskTransformation(R.drawable.bg_voucher_v3_cutout);
        }
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = imageView;
        new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
    }

    public final void setImagePng(Context r4, String r5, ImageView imageView, boolean useCutout) {
        Intrinsics.checkNotNullParameter(r5, "");
        Intrinsics.checkNotNullParameter(imageView, "");
        if (r4 != null) {
            RequestBuilder PlaceComponentResult = Glide.KClassImpl$Data$declaredNonStaticMembers$2(r4).getAuthRequestContext(r5).PlaceComponentResult(r4.getResources().getDimensionPixelSize(R.dimen.f34202131166214), r4.getResources().getDimensionPixelSize(R.dimen.f34192131166209));
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            RequestBuilder requestBuilder = PlaceComponentResult;
            if (useCutout) {
                requestBuilder.MyBillsEntityDataFactory((Transformation<Bitmap>) new MaskTransformation(R.drawable.bg_voucher_v3_cutout));
            }
            requestBuilder.MyBillsEntityDataFactory(imageView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable disposable = this.countdownDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}

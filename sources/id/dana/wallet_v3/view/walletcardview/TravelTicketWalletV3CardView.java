package id.dana.wallet_v3.view.walletcardview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import com.alibaba.griver.core.GriverParams;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.extension.lang.StringExtKt;
import id.dana.richview.wallet.BaseWalletCustomCardView;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.TransportTicketType;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0001*B#\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\nJ'\u0010\u0012\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u000f\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\nJ\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\nJ\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\nJ\u001d\u0010\u001a\u001a\u00020\b*\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR0\u0010!\u001a\u001b\u0012\u0004\u0012\u00020\u0019\u0012\u000b\u0012\t\u0018\u00010\u0005¢\u0006\u0002\b \u0012\u0004\u0012\u00020\b0\u001f8\u0007¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b&\u0010'"}, d2 = {"Lid/dana/wallet_v3/view/walletcardview/TravelTicketWalletV3CardView;", "Lid/dana/richview/wallet/BaseWalletCustomCardView;", "", "getCardInstId", "()Ljava/lang/CharSequence;", "", "getLayout", "()I", "", "invokeListeners", "()V", "onAttachedToWindow", "Landroid/content/Context;", HummerConstants.CONTEXT, "", GriverParams.ShareParams.IMAGE_URL, "Landroid/widget/ImageView;", "imageView", "setImagePng", "(Landroid/content/Context;Ljava/lang/String;Landroid/widget/ImageView;)V", "setImageSvg", "setup", "setupStaticData", "setupUIPerSubPocketType", "setupUIPerTransportName", "Landroidx/appcompat/widget/AppCompatImageView;", "loadLogoBasedOnImageType", "(Landroidx/appcompat/widget/AppCompatImageView;Ljava/lang/String;)V", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "onTravelTicketClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "selectIcon", "Lkotlin/jvm/functions/Function2;", "getSelectIcon", "()Lkotlin/jvm/functions/Function2;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$TravelTicketCard;", "travelTicketAssetModel", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$TravelTicketCard;", "<init>", "(Landroid/content/Context;Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$TravelTicketCard;Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TravelTicketWalletV3CardView extends BaseWalletCustomCardView {
    private static final String URL_DOMAIN = "https://";
    public Map<Integer, View> _$_findViewCache;
    private final WalletCardAssetClickListener onTravelTicketClickListener;
    private final Function2<AppCompatImageView, Integer, Unit> selectIcon;
    private final VoucherAndTicketCardModel.TravelTicketCard travelTicketAssetModel;

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
        return R.layout.travel_ticket_wallet_v3_card;
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TravelTicketWalletV3CardView(final Context context, VoucherAndTicketCardModel.TravelTicketCard travelTicketCard, WalletCardAssetClickListener walletCardAssetClickListener) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(travelTicketCard, "");
        this._$_findViewCache = new LinkedHashMap();
        this.travelTicketAssetModel = travelTicketCard;
        this.onTravelTicketClickListener = walletCardAssetClickListener;
        this.selectIcon = new Function2<AppCompatImageView, Integer, Unit>() { // from class: id.dana.wallet_v3.view.walletcardview.TravelTicketWalletV3CardView$selectIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(AppCompatImageView appCompatImageView, Integer num) {
                invoke(appCompatImageView, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AppCompatImageView appCompatImageView, int i) {
                Intrinsics.checkNotNullParameter(appCompatImageView, "");
                appCompatImageView.setImageDrawable(ContextCompat.PlaceComponentResult(context, i));
            }
        };
    }

    public /* synthetic */ TravelTicketWalletV3CardView(Context context, VoucherAndTicketCardModel.TravelTicketCard travelTicketCard, WalletCardAssetClickListener walletCardAssetClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, travelTicketCard, (i & 4) != 0 ? null : walletCardAssetClickListener);
    }

    @JvmName(name = "getSelectIcon")
    public final Function2<AppCompatImageView, Integer, Unit> getSelectIcon() {
        return this.selectIcon;
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final CharSequence getCardInstId() {
        return this.travelTicketAssetModel.getPocketId();
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final void invokeListeners() {
        WalletCardAssetClickListener walletCardAssetClickListener = this.onTravelTicketClickListener;
        if (walletCardAssetClickListener != null) {
            walletCardAssetClickListener.onCardClicked(this.travelTicketAssetModel);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setupStaticData();
    }

    private final void setupStaticData() {
        VoucherAndTicketCardModel.TravelTicketCard travelTicketCard = this.travelTicketAssetModel;
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a190b_scanqrpresenter_onresume_1)).setText(travelTicketCard.getTransportName());
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a181b_lambda_executor_0_com_google_common_util_concurrent_abstractidleservice)).setText(travelTicketCard.getPassengerName());
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_ticket_desc)).setText(getContext().getString(R.string.passenger_type_format, travelTicketCard.getPassengerType()));
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_departure_code)).setText(travelTicketCard.getDepartureCode());
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_departure)).setText(travelTicketCard.getDeparture());
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_arrival_code)).setText(travelTicketCard.getArrivalCode());
        ((AppCompatTextView) _$_findCachedViewById(R.id.getMUTABLE_METHOD_SIGNATURES)).setText(travelTicketCard.getArrival());
        ((AppCompatTextView) _$_findCachedViewById(R.id.isDisableAutoPlayOnUserInteraction)).setText(travelTicketCard.getDepartureTime());
        ((AppCompatTextView) _$_findCachedViewById(R.id.onErrorSwitchPaymentAuth)).setText(travelTicketCard.getDepartureTime());
        ((AppCompatTextView) _$_findCachedViewById(R.id.FirstTimeModule_ProvidePresenterFactory)).setText(travelTicketCard.getArrivalTime());
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_bottom_desc_2)).setText(getContext().getString(R.string.seat, travelTicketCard.getSeatNumber()));
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.setNearExpiredPromoBannerConfig);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        String iconUrl = travelTicketCard.getIconUrl();
        loadLogoBasedOnImageType(appCompatImageView, iconUrl != null ? StringExtKt.PlaceComponentResult(iconUrl) : null);
        MaterialCardView materialCardView = (MaterialCardView) _$_findCachedViewById(R.id.res_0x7f0a0583_trustedlistenablefuturetask_trustedfutureinterruptibleasynctask);
        Intrinsics.checkNotNullExpressionValue(materialCardView, "");
        setToGrayScale(materialCardView, travelTicketCard.getIsUsed());
        setupUIPerTransportName();
        setupUIPerSubPocketType();
    }

    private final void setupUIPerTransportName() {
        String hexCode = this.travelTicketAssetModel.getHexCode();
        if (!(hexCode == null || hexCode.length() == 0)) {
            ((AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0b3b_callcsordianaviewmodel_gethelpbuttonchatbotfeature_1)).setColorFilter(Color.parseColor(this.travelTicketAssetModel.getHexCode()), PorterDuff.Mode.SRC_ATOP);
        } else {
            String backgroundUrl = this.travelTicketAssetModel.getBackgroundUrl();
            if (backgroundUrl == null) {
                backgroundUrl = "";
            }
            if (SvgLoader.getAuthRequestContext(backgroundUrl)) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "");
                String backgroundUrl2 = this.travelTicketAssetModel.getBackgroundUrl();
                if (backgroundUrl2 == null) {
                    backgroundUrl2 = "";
                }
                AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0b3b_callcsordianaviewmodel_gethelpbuttonchatbotfeature_1);
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                setImageSvg(context, backgroundUrl2, appCompatImageView);
            } else {
                Context context2 = getContext();
                String backgroundUrl3 = this.travelTicketAssetModel.getBackgroundUrl();
                if (backgroundUrl3 == null) {
                    backgroundUrl3 = "";
                }
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0b3b_callcsordianaviewmodel_gethelpbuttonchatbotfeature_1);
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                setImagePng(context2, backgroundUrl3, appCompatImageView2);
            }
        }
        if (!URLUtil.isNetworkUrl(this.travelTicketAssetModel.getLogoUrl())) {
            VoucherAndTicketCardModel.TravelTicketCard travelTicketCard = this.travelTicketAssetModel;
            StringBuilder sb = new StringBuilder();
            sb.append(URL_DOMAIN);
            String logoUrl = this.travelTicketAssetModel.getLogoUrl();
            sb.append(logoUrl != null ? StringExtKt.PlaceComponentResult(logoUrl) : null);
            travelTicketCard.setLogoUrl(sb.toString());
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) _$_findCachedViewById(R.id.SendMoneyHomePresenter);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "");
        loadLogoBasedOnImageType(appCompatImageView3, this.travelTicketAssetModel.getLogoUrl());
    }

    private final void setupUIPerSubPocketType() {
        String subPocketType = this.travelTicketAssetModel.getSubPocketType();
        if (Intrinsics.areEqual(subPocketType, TransportTicketType.TRAIN_TICKET.getValue())) {
            ((Group) _$_findCachedViewById(R.id.group_departure_arrival)).setVisibility(0);
            ((AppCompatTextView) _$_findCachedViewById(R.id.tv_bottom_desc_2)).setVisibility(8);
            ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a181b_lambda_executor_0_com_google_common_util_concurrent_abstractidleservice)).setVisibility(8);
            ((AppCompatTextView) _$_findCachedViewById(R.id.tv_ticket_desc)).setText(this.travelTicketAssetModel.getPassengerType());
            ((AppCompatTextView) _$_findCachedViewById(R.id.tv_bottom_desc_1)).setText(getContext().getString(R.string.seat, this.travelTicketAssetModel.getSeatNumber()));
        } else if (Intrinsics.areEqual(subPocketType, TransportTicketType.AIRPLANE_TICKET.getValue())) {
            ((Group) _$_findCachedViewById(R.id.group_departure_arrival)).setVisibility(0);
            ((AppCompatTextView) _$_findCachedViewById(R.id.isDisableAutoPlayOnUserInteraction)).setVisibility(8);
            ((AppCompatTextView) _$_findCachedViewById(R.id.tv_bottom_desc_2)).setVisibility(0);
            ((AppCompatTextView) _$_findCachedViewById(R.id.tv_bottom_desc_1)).setText(getContext().getString(R.string.gate, this.travelTicketAssetModel.getGateNumber()));
        } else if (Intrinsics.areEqual(subPocketType, TransportTicketType.SHUTTLE_TICKET.getValue())) {
            ((Group) _$_findCachedViewById(R.id.group_departure_arrival)).setVisibility(0);
            ((AppCompatTextView) _$_findCachedViewById(R.id.tv_bottom_desc_2)).setVisibility(8);
            ((AppCompatTextView) _$_findCachedViewById(R.id.isDisableAutoPlayOnUserInteraction)).setVisibility(8);
            ((AppCompatTextView) _$_findCachedViewById(R.id.tv_ticket_desc)).setVisibility(4);
            ((AppCompatTextView) _$_findCachedViewById(R.id.tv_ticket_desc)).setText("");
            ((AppCompatTextView) _$_findCachedViewById(R.id.tv_bottom_desc_1)).setText(getContext().getString(R.string.seat, this.travelTicketAssetModel.getSeatNumber()));
        } else if (Intrinsics.areEqual(subPocketType, TransportTicketType.METRO_TICKET.getValue())) {
            ((AppCompatTextView) _$_findCachedViewById(R.id.isDisableAutoPlayOnUserInteraction)).setVisibility(0);
            ((Group) _$_findCachedViewById(R.id.group_departure_arrival)).setVisibility(4);
            ((AppCompatTextView) _$_findCachedViewById(R.id.tv_bottom_desc_2)).setVisibility(8);
            ((AppCompatTextView) _$_findCachedViewById(R.id.tv_bottom_desc_1)).setText(this.travelTicketAssetModel.getBookingCode());
        } else if (Intrinsics.areEqual(subPocketType, TransportTicketType.SHIP_TICKET.getValue())) {
            ((Group) _$_findCachedViewById(R.id.group_departure_arrival)).setVisibility(0);
            ((AppCompatTextView) _$_findCachedViewById(R.id.isDisableAutoPlayOnUserInteraction)).setVisibility(8);
            ((AppCompatTextView) _$_findCachedViewById(R.id.tv_bottom_desc_2)).setVisibility(8);
            ((AppCompatTextView) _$_findCachedViewById(R.id.tv_bottom_desc_1)).setText(getContext().getString(R.string.seat, this.travelTicketAssetModel.getSeatNumber()));
        }
    }

    private final void loadLogoBasedOnImageType(AppCompatImageView appCompatImageView, String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        if (SvgLoader.getAuthRequestContext(str)) {
            Context context = appCompatImageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            setImageSvg(context, str, appCompatImageView);
            return;
        }
        setImagePng(appCompatImageView.getContext(), str, appCompatImageView);
    }

    public final void setImageSvg(Context r2, String r3, ImageView imageView) {
        Intrinsics.checkNotNullParameter(r2, "");
        Intrinsics.checkNotNullParameter(r3, "");
        Intrinsics.checkNotNullParameter(imageView, "");
        SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(r2);
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = r3;
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = true;
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = imageView;
        new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
    }

    public final void setImagePng(Context r2, String r3, ImageView imageView) {
        Intrinsics.checkNotNullParameter(r3, "");
        Intrinsics.checkNotNullParameter(imageView, "");
        if (r2 != null) {
            Glide.KClassImpl$Data$declaredNonStaticMembers$2(r2).getAuthRequestContext(r3).MyBillsEntityDataFactory(imageView);
        }
    }
}

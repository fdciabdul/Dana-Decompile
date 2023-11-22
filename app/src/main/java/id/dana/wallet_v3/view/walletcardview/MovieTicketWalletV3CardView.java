package id.dana.wallet_v3.view.walletcardview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.griver.core.GriverParams;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.load.Transformation;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;
import id.dana.animation.RoundedCornersTransformation;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.extension.lang.StringExtKt;
import id.dana.richview.wallet.BaseWalletCustomCardView;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0012\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0014\u0010\nJ7\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\nJ\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\nR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!"}, d2 = {"Lid/dana/wallet_v3/view/walletcardview/MovieTicketWalletV3CardView;", "Lid/dana/richview/wallet/BaseWalletCustomCardView;", "", "getCardInstId", "()Ljava/lang/CharSequence;", "", "getLayout", "()I", "", "invokeListeners", "()V", "", GriverParams.ShareParams.IMAGE_URL, "Landroid/widget/ImageView;", "imageView", "", "useRoundedCorner", "defaultImage", "loadImageIntoView", "(Ljava/lang/String;Landroid/widget/ImageView;ZI)V", "onAttachedToWindow", "Landroid/content/Context;", HummerConstants.CONTEXT, "setImagePng", "(Landroid/content/Context;Ljava/lang/String;Landroid/widget/ImageView;ZI)V", "setImageSvg", "setup", "setupStaticData", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$MovieTicketCard;", "movieTicketCard", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$MovieTicketCard;", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "onMovieTicketClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "<init>", "(Landroid/content/Context;Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$MovieTicketCard;Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MovieTicketWalletV3CardView extends BaseWalletCustomCardView {
    public Map<Integer, View> _$_findViewCache;
    private final VoucherAndTicketCardModel.MovieTicketCard movieTicketCard;
    private final WalletCardAssetClickListener onMovieTicketClickListener;

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
        return R.layout.view_movie_ticket_wallet_v3;
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieTicketWalletV3CardView(Context context, VoucherAndTicketCardModel.MovieTicketCard movieTicketCard, WalletCardAssetClickListener walletCardAssetClickListener) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(movieTicketCard, "");
        this._$_findViewCache = new LinkedHashMap();
        this.movieTicketCard = movieTicketCard;
        this.onMovieTicketClickListener = walletCardAssetClickListener;
    }

    public /* synthetic */ MovieTicketWalletV3CardView(Context context, VoucherAndTicketCardModel.MovieTicketCard movieTicketCard, WalletCardAssetClickListener walletCardAssetClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, movieTicketCard, (i & 4) != 0 ? null : walletCardAssetClickListener);
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final CharSequence getCardInstId() {
        return this.movieTicketCard.getPocketId();
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final void invokeListeners() {
        WalletCardAssetClickListener walletCardAssetClickListener = this.onMovieTicketClickListener;
        if (walletCardAssetClickListener != null) {
            walletCardAssetClickListener.onCardClicked(this.movieTicketCard);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setupStaticData();
    }

    private final void setupStaticData() {
        VoucherAndTicketCardModel.MovieTicketCard movieTicketCard = this.movieTicketCard;
        String moviePosterUrl = movieTicketCard.getMoviePosterUrl();
        String PlaceComponentResult = moviePosterUrl != null ? StringExtKt.PlaceComponentResult(moviePosterUrl) : null;
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.iv_movie_poster);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        loadImageIntoView(PlaceComponentResult, appCompatImageView, true, R.drawable.bg_rounded_8dp_grey20);
        String logoUrl = movieTicketCard.getLogoUrl();
        String PlaceComponentResult2 = logoUrl != null ? StringExtKt.PlaceComponentResult(logoUrl) : null;
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.iv_cinema_logo);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
        loadImageIntoView(PlaceComponentResult2, appCompatImageView2, false, R.drawable.ic_dana);
        String backgroundUrl = movieTicketCard.getBackgroundUrl();
        String PlaceComponentResult3 = backgroundUrl != null ? StringExtKt.PlaceComponentResult(backgroundUrl) : null;
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) _$_findCachedViewById(R.id.iv_ticket_background);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "");
        loadImageIntoView(PlaceComponentResult3, appCompatImageView3, true, R.drawable.bg_movie_ticket);
        ((AppCompatTextView) _$_findCachedViewById(R.id.FragmentPermissionRequest)).setText(movieTicketCard.getMovieName());
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a17db_daggernewservicecardcomponent_newservicecardcomponentimpl_usereducationrepositoryprovider)).setText(getContext().getString(R.string.movie_ticket_detail, movieTicketCard.getLocationName(), movieTicketCard.getTicketClass()));
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a18dd_daggerinvestmentwalletdetailcomponent_investmentwalletdetailcomponentimpl_generatelinkrepositoryprovider)).setText(movieTicketCard.getShowTime());
        ((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a17dd_imagecaptureactivity_onuploadimage_inlined_proceedbitmap_1)).setText(movieTicketCard.getStudioNumber());
        ((AppCompatTextView) _$_findCachedViewById(R.id.tv_seat_num)).setText(movieTicketCard.getSeatNumber());
        MaterialCardView materialCardView = (MaterialCardView) _$_findCachedViewById(R.id.notifyTakenPictureError_res_0x7f0a057f);
        Intrinsics.checkNotNullExpressionValue(materialCardView, "");
        setToGrayScale(materialCardView, movieTicketCard.getIsUsed());
    }

    private final void loadImageIntoView(String r11, ImageView imageView, boolean useRoundedCorner, int defaultImage) {
        if (r11 != null) {
            if (SvgLoader.getAuthRequestContext(r11)) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "");
                setImageSvg(context, r11, imageView, useRoundedCorner, defaultImage);
                return;
            }
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "");
            setImagePng(context2, r11, imageView, useRoundedCorner, defaultImage);
        }
    }

    private final void setImageSvg(Context r2, String r3, ImageView imageView, boolean useRoundedCorner, int defaultImage) {
        SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(r2);
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = r3;
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = true;
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = defaultImage;
        byte b = 0;
        if (useRoundedCorner) {
            KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = new RoundedCornersTransformation(r2.getResources().getDimensionPixelSize(R.dimen.f28152131165294), 0, RoundedCornersTransformation.CornerType.ALL);
        }
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = imageView;
        new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, b);
    }

    private final void setImagePng(Context r2, String r3, ImageView imageView, boolean useRoundedCorner, int defaultImage) {
        GlideRequest<Drawable> PlaceComponentResult = GlideApp.getAuthRequestContext(r2).PlaceComponentResult(r3).PlaceComponentResult(defaultImage);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        if (useRoundedCorner) {
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new RoundedCornersTransformation(r2.getResources().getDimensionPixelSize(R.dimen.f28152131165294), 0, RoundedCornersTransformation.CornerType.ALL));
        }
        PlaceComponentResult.MyBillsEntityDataFactory(imageView);
    }
}

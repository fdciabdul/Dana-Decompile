package id.dana.wallet_v3.view.walletcardview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.griver.core.GriverParams;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import id.dana.R;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.richview.wallet.BaseWalletCustomCardView;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.IdentityCardModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0014¢\u0006\u0004\b\r\u0010\nJ)\u0010\u0013\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\nR\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/wallet_v3/view/walletcardview/IdentityWalletV3CardView;", "Lid/dana/richview/wallet/BaseWalletCustomCardView;", "", "getCardInstId", "()Ljava/lang/String;", "", "getLayout", "()I", "", "initView", "()V", "invokeListeners", "loadBackgroundImage", "onAttachedToWindow", "Landroid/content/Context;", HummerConstants.CONTEXT, GriverParams.ShareParams.IMAGE_URL, "Landroid/widget/ImageView;", "imageView", "setImagePng", "(Landroid/content/Context;Ljava/lang/String;Landroid/widget/ImageView;)V", "setImageSvg", "setup", "Lid/dana/wallet_v3/model/IdentityCardModel$KtpCard;", "identityModel", "Lid/dana/wallet_v3/model/IdentityCardModel$KtpCard;", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "onIdentityClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "<init>", "(Landroid/content/Context;Lid/dana/wallet_v3/model/IdentityCardModel$KtpCard;Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class IdentityWalletV3CardView extends BaseWalletCustomCardView {
    public Map<Integer, View> _$_findViewCache;
    private final IdentityCardModel.KtpCard identityModel;
    private final WalletCardAssetClickListener onIdentityClickListener;

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
        return R.layout.identity_wallet_v3_card;
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdentityWalletV3CardView(Context context, IdentityCardModel.KtpCard ktpCard, WalletCardAssetClickListener walletCardAssetClickListener) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(ktpCard, "");
        this._$_findViewCache = new LinkedHashMap();
        this.identityModel = ktpCard;
        this.onIdentityClickListener = walletCardAssetClickListener;
    }

    public /* synthetic */ IdentityWalletV3CardView(Context context, IdentityCardModel.KtpCard ktpCard, WalletCardAssetClickListener walletCardAssetClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, ktpCard, (i & 4) != 0 ? null : walletCardAssetClickListener);
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final String getCardInstId() {
        return this.identityModel.getPocketId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        initView();
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public final void invokeListeners() {
        WalletCardAssetClickListener walletCardAssetClickListener = this.onIdentityClickListener;
        if (walletCardAssetClickListener != null) {
            walletCardAssetClickListener.onCardClicked(this.identityModel);
        }
    }

    private final void initView() {
        loadBackgroundImage();
    }

    private final void loadBackgroundImage() {
        if (SvgLoader.getAuthRequestContext(this.identityModel.getBackgroundUrl())) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            String backgroundUrl = this.identityModel.getBackgroundUrl();
            AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.iv_personal_ktp_background);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            setImageSvg(context, backgroundUrl, appCompatImageView);
            return;
        }
        Context context2 = getContext();
        String backgroundUrl2 = this.identityModel.getBackgroundUrl();
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.iv_personal_ktp_background);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
        setImagePng(context2, backgroundUrl2, appCompatImageView2);
    }

    private final void setImageSvg(Context r1, String r2, ImageView imageView) {
        SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(r1);
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = r2;
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.bg_ktp_back_holo;
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = true;
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = imageView;
        new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
    }

    private final void setImagePng(Context r1, String r2, ImageView imageView) {
        if (r1 != null) {
            Glide.KClassImpl$Data$declaredNonStaticMembers$2(r1).getAuthRequestContext(r2).MyBillsEntityDataFactory((int) R.drawable.bg_ktp_back_holo).MyBillsEntityDataFactory(imageView);
        }
    }
}

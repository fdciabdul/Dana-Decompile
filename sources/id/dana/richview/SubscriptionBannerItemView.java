package id.dana.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.glide.GlideApp;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010,\u001a\u00020+\u0012\b\b\u0002\u0010-\u001a\u00020\u0002¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\tJ\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\tJ\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\tJ\u0015\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u001c8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\"\u0010&\u001a\u00020\u001c8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\""}, d2 = {"Lid/dana/richview/SubscriptionBannerItemView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "goodsType", "", "loadImage", "(Ljava/lang/String;)V", "title", "setMerchantTitle", "amount", "setSubscriptionAmount", "status", "setSubscriptionStatus", "color", "setSubscriptionStatusStyle", "(I)V", "setup", "()V", "Landroid/widget/ImageView;", "ivMerchantLogo", "Landroid/widget/ImageView;", "getIvMerchantLogo", "()Landroid/widget/ImageView;", "setIvMerchantLogo", "(Landroid/widget/ImageView;)V", "Landroid/widget/TextView;", "tvMerchantTitle", "Landroid/widget/TextView;", "getTvMerchantTitle", "()Landroid/widget/TextView;", "setTvMerchantTitle", "(Landroid/widget/TextView;)V", "tvSubscriptionAmount", "getTvSubscriptionAmount", "setTvSubscriptionAmount", "tvSubscriptionStatus", "getTvSubscriptionStatus", "setTvSubscriptionStatus", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class SubscriptionBannerItemView extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;
    public ImageView ivMerchantLogo;
    public TextView tvMerchantTitle;
    public TextView tvSubscriptionAmount;
    public TextView tvSubscriptionStatus;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubscriptionBannerItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.item_subscription_banner;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionBannerItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ SubscriptionBannerItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getTvMerchantTitle")
    public final TextView getTvMerchantTitle() {
        TextView textView = this.tvMerchantTitle;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTvMerchantTitle")
    public final void setTvMerchantTitle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "");
        this.tvMerchantTitle = textView;
    }

    @JvmName(name = "getTvSubscriptionStatus")
    public final TextView getTvSubscriptionStatus() {
        TextView textView = this.tvSubscriptionStatus;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTvSubscriptionStatus")
    public final void setTvSubscriptionStatus(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "");
        this.tvSubscriptionStatus = textView;
    }

    @JvmName(name = "getTvSubscriptionAmount")
    public final TextView getTvSubscriptionAmount() {
        TextView textView = this.tvSubscriptionAmount;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTvSubscriptionAmount")
    public final void setTvSubscriptionAmount(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "");
        this.tvSubscriptionAmount = textView;
    }

    @JvmName(name = "getIvMerchantLogo")
    public final ImageView getIvMerchantLogo() {
        ImageView imageView = this.ivMerchantLogo;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setIvMerchantLogo")
    public final void setIvMerchantLogo(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "");
        this.ivMerchantLogo = imageView;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        View findViewById = findViewById(R.id.getUserDataFileForSession);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        setTvMerchantTitle((TextView) findViewById);
        View findViewById2 = findViewById(R.id.ProfileInstallerInitializer);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "");
        setTvSubscriptionStatus((TextView) findViewById2);
        View findViewById3 = findViewById(R.id.f4330tvSubscriptionAmount);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "");
        setTvSubscriptionAmount((TextView) findViewById3);
        View findViewById4 = findViewById(R.id.f3854res_0x7f0a09f8_r8_lambda_npxyyf3zgc_tldyljuapq7cvou4);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "");
        setIvMerchantLogo((ImageView) findViewById4);
    }

    public final void setMerchantTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "");
        getTvMerchantTitle().setText(title);
    }

    public final void setSubscriptionStatus(String status) {
        Intrinsics.checkNotNullParameter(status, "");
        getTvSubscriptionStatus().setText(status);
    }

    public final void setSubscriptionStatusStyle(int color) {
        getTvSubscriptionStatus().setTextColor(color);
    }

    public final void setSubscriptionAmount(String amount) {
        Intrinsics.checkNotNullParameter(amount, "");
        getTvSubscriptionAmount().setText(amount);
    }

    public final void loadImage(String goodsType) {
        Intrinsics.checkNotNullParameter(goodsType, "");
        StringBuilder sb = new StringBuilder();
        sb.append("https://a.m.dana.id/resource/imgs/merchant/subscription-");
        sb.append(goodsType);
        sb.append(".png");
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(sb.toString()).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory(getIvMerchantLogo());
    }
}

package id.dana.drawable.merchantbanner;

import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.onboarding.view.BaseSimpleView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000b"}, d2 = {"Lid/dana/nearbyrevamp/merchantbanner/MerchantBannerItemView;", "Lid/dana/onboarding/view/BaseSimpleView;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()I", "", "getAuthRequestContext", "()Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Ljava/lang/String;", "PlaceComponentResult", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantBannerItemView extends BaseSimpleView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MerchantBannerItemView() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.merchantbanner.MerchantBannerItemView.<init>():void");
    }

    @Override // id.dana.onboarding.view.BaseSimpleView
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return R.layout.item_merchant_banner;
    }

    @Override // id.dana.onboarding.view.SimpleView
    /* renamed from: getAuthRequestContext */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return "";
    }

    public MerchantBannerItemView(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.PlaceComponentResult = str;
    }

    public /* synthetic */ MerchantBannerItemView(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    @Override // id.dana.onboarding.view.SimpleView
    public final void BuiltInFictitiousFunctionClassFactory() {
        String str = this.PlaceComponentResult;
        AppCompatImageView appCompatImageView = (AppCompatImageView) m_().findViewById(R.id.getChildViewHolder);
        if (appCompatImageView != null) {
            Glide.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView.getContext()).PlaceComponentResult().PlaceComponentResult(str).BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory(R.drawable.ic_merchant_banner_placeholder).MyBillsEntityDataFactory(R.color.f23952131099990).MyBillsEntityDataFactory((ImageView) appCompatImageView);
        }
    }
}

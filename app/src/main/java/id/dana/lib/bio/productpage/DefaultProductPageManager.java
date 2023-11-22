package id.dana.lib.bio.productpage;

import android.content.Context;
import com.alipay.mobile.verifyidentity.base.OnClickUrl;
import com.alipay.mobile.verifyidentity.business.activity.SecVIVerify;
import com.alipay.mobile.verifyidentity.business.activity.SecVIVerifyInterface;
import com.alipay.mobile.verifyidentity.framework.engine.VIEngine;
import id.dana.lib.bio.faceauth.exception.DanaBioException;
import id.dana.wallet_v3.identity.presenter.PersonalPresenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JS\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/lib/bio/productpage/DefaultProductPageManager;", "Lid/dana/lib/bio/productpage/ProductPageManager;", "Landroid/content/Context;", "p0", "", "p1", "", "", "p2", "p3", "Lid/dana/lib/bio/productpage/OpenPageCallback;", "p4", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lid/dana/lib/bio/productpage/OpenPageCallback;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultProductPageManager implements ProductPageManager {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ProductPageManager PlaceComponentResult;

    public /* synthetic */ DefaultProductPageManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DefaultProductPageManager() {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/lib/bio/productpage/DefaultProductPageManager$Companion;", "", "Lid/dana/lib/bio/productpage/ProductPageManager;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/lib/bio/productpage/ProductPageManager;", "PlaceComponentResult", "Lid/dana/lib/bio/productpage/ProductPageManager;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static ProductPageManager KClassImpl$Data$declaredNonStaticMembers$2() {
            ProductPageManager productPageManager;
            synchronized (Reflection.getOrCreateKotlinClass(DefaultProductPageManager.class)) {
                if (DefaultProductPageManager.PlaceComponentResult == null) {
                    Companion companion = DefaultProductPageManager.INSTANCE;
                    DefaultProductPageManager.PlaceComponentResult = new DefaultProductPageManager(null);
                }
                productPageManager = DefaultProductPageManager.PlaceComponentResult;
                Intrinsics.checkNotNull(productPageManager);
            }
            return productPageManager;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(OpenPageCallback openPageCallback, String str) {
        Intrinsics.checkNotNullParameter(openPageCallback, "");
        openPageCallback.MyBillsEntityDataFactory(str);
    }

    @Override // id.dana.lib.bio.productpage.ProductPageManager
    public final void MyBillsEntityDataFactory(Context p0, final String p1, Map<String, ? extends Object> p2, Map<String, String> p3, final OpenPageCallback p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p4, "");
        try {
            String str = p1;
            if ((str.length() == 0) || StringsKt.isBlank(str)) {
                throw new DanaBioException.OpenPageException("Open Page but User Id is empty or blank", 300001);
            }
            SecVIVerify.setSecVIVerifyInterface(new SecVIVerifyInterface() { // from class: id.dana.lib.bio.productpage.DefaultProductPageManager$setUserId$1
                @Override // com.alipay.mobile.verifyidentity.business.activity.SecVIVerifyInterface
                public final String tntInstId() {
                    return null;
                }

                @Override // com.alipay.mobile.verifyidentity.business.activity.SecVIVerifyInterface
                /* renamed from: userId  reason: from getter */
                public final String getPlaceComponentResult() {
                    return p1;
                }
            });
            VIEngine.registerOnClickUrl(new OnClickUrl() { // from class: id.dana.lib.bio.productpage.DefaultProductPageManager$$ExternalSyntheticLambda0
                @Override // com.alipay.mobile.verifyidentity.base.OnClickUrl
                public final void onClickHttpUrl(Context context, String str2) {
                    DefaultProductPageManager.PlaceComponentResult(OpenPageCallback.this, str2);
                }
            });
            VIEngine.startProduct(p0, p2, p3, new VIEngine.OnQueryResult() { // from class: id.dana.lib.bio.productpage.DefaultProductPageManager$startProductPage$2
                @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.OnQueryResult
                public final void onSuccess() {
                }

                @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.OnQueryResult
                public final void onFail() {
                    OpenPageCallback.this.MyBillsEntityDataFactory(new DanaBioException.OpenPageException("Open Page and error", 300009));
                }
            });
        } catch (DanaBioException.OpenPageException e) {
            p4.MyBillsEntityDataFactory(e);
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = PersonalPresenter.UNKNOWN_ERROR;
            }
            p4.MyBillsEntityDataFactory(new DanaBioException.OpenPageException(message, 999999));
        }
    }
}

package id.dana.promoquest.handler;

import android.content.Context;
import id.dana.animation.SwipeDelegateListener;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.promoquest.handler.deeplink.PromoQuestDeeplinkActionListener;
import id.dana.promoquest.handler.deeplink.PromoQuestDeeplinkHandler;
import id.dana.promoquest.handler.h5.PromoQuestH5PageHandler;
import id.dana.promoquest.handler.nativepage.PromoQuestNativePageHandler;
import id.dana.utils.UrlUtil;

/* loaded from: classes5.dex */
public class PromoQuestActionFactory {
    private final DynamicUrlWrapper KClassImpl$Data$declaredNonStaticMembers$2;
    private Context MyBillsEntityDataFactory;
    private SwipeDelegateListener PlaceComponentResult = null;
    private PromoQuestDeeplinkActionListener getAuthRequestContext;

    public PromoQuestActionFactory(Context context, PromoQuestDeeplinkActionListener promoQuestDeeplinkActionListener, DynamicUrlWrapper dynamicUrlWrapper) {
        this.MyBillsEntityDataFactory = context;
        this.getAuthRequestContext = promoQuestDeeplinkActionListener;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = dynamicUrlWrapper;
    }

    public final PromoQuestActionHandler MyBillsEntityDataFactory(String str, String str2) {
        char c;
        str.hashCode();
        int hashCode = str.hashCode();
        if (hashCode == -2133131170) {
            if (str.equals(PromoQuestRedirectType.SERVICES)) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != -361445961) {
            if (hashCode == 84303 && str.equals("URL")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals(PromoQuestRedirectType.NATIVE_PAGE)) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0 || c == 1) {
            return new PromoQuestNativePageHandler(this.MyBillsEntityDataFactory, str2, this.PlaceComponentResult);
        }
        if (c == 2) {
            if (UrlUtil.getErrorConfigVersion(str2)) {
                return new PromoQuestDeeplinkHandler(str2, this.getAuthRequestContext);
            }
            return new PromoQuestH5PageHandler(str, str2, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return new PromoQuestH5PageHandler(str, str2, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}

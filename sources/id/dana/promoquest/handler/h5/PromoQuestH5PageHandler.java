package id.dana.promoquest.handler.h5;

import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.promoquest.handler.PromoQuestActionHandler;

/* loaded from: classes5.dex */
public class PromoQuestH5PageHandler implements PromoQuestActionHandler {
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;
    private final DynamicUrlWrapper getAuthRequestContext;

    public PromoQuestH5PageHandler(String str, String str2, DynamicUrlWrapper dynamicUrlWrapper) {
        this.MyBillsEntityDataFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.getAuthRequestContext = dynamicUrlWrapper;
    }

    @Override // id.dana.promoquest.handler.PromoQuestActionHandler
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        char c;
        String obj;
        String str = this.MyBillsEntityDataFactory;
        str.hashCode();
        int hashCode = str.hashCode();
        if (hashCode == -2035039290) {
            if (str.equals("INNER_URL")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != -805752590) {
            if (hashCode == 191796002 && str.equals("VOUCHER_DETAIL")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("TRANSACTION_DETAIL")) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://m.dana.id");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            obj = sb.toString();
        } else if (c == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https://m.dana.id");
            sb2.append(String.format(DanaUrl.TRANSACTION_DETAIL, this.KClassImpl$Data$declaredNonStaticMembers$2));
            obj = sb2.toString();
        } else if (c == 2) {
            obj = String.format(this.getAuthRequestContext.getVoucherDetail(), this.KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            obj = this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        DanaH5.startContainerFullUrl(obj);
    }
}

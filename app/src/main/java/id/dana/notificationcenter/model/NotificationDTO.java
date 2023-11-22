package id.dana.notificationcenter.model;

import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.utils.UrlUtil;

/* loaded from: classes5.dex */
public class NotificationDTO {
    public long BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public String PlaceComponentResult;
    public DynamicUrlWrapper getAuthRequestContext;
    public boolean getErrorConfigVersion;
    public String lookAheadTest;
    public String moveToNextValue;

    public final boolean PlaceComponentResult() {
        return this.getErrorConfigVersion;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String getAuthRequestContext() {
        char c;
        String str = this.lookAheadTest;
        str.hashCode();
        switch (str.hashCode()) {
            case -2035039290:
                if (str.equals("INNER_URL")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -805752590:
                if (str.equals("TRANSACTION_DETAIL")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 66575:
                if (str.equals("CDP")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 191796002:
                if (str.equals("VOUCHER_DETAIL")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://m.dana.id");
            sb.append(this.moveToNextValue);
            return sb.toString();
        } else if (c == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https://m.dana.id");
            sb2.append(String.format(DanaUrl.TRANSACTION_DETAIL, this.moveToNextValue));
            return sb2.toString();
        } else if (c != 2) {
            return c != 3 ? UrlUtil.getAuthRequestContext(this.moveToNextValue) : String.format(this.getAuthRequestContext.getVoucherDetail(), this.moveToNextValue);
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("https://m.dana.id");
            sb3.append(String.format(DanaUrl.CDP_DETAIL, this.moveToNextValue));
            return sb3.toString();
        }
    }
}

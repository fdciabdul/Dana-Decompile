package id.dana.model;

import android.content.Context;
import android.text.TextUtils;
import id.dana.R;

/* loaded from: classes5.dex */
public class KybInfo {
    private String PlaceComponentResult;
    private String getAuthRequestContext;

    public final String KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        if (MyBillsEntityDataFactory()) {
            return context.getResources().getString(R.string.kyb_apply_header);
        }
        if (getAuthRequestContext(str)) {
            return context.getResources().getString(R.string.kyb_re_verify_header);
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            return context.getResources().getString(R.string.kyb_approved_text);
        }
        if (getAuthRequestContext()) {
            return context.getString(R.string.kyb_approved_text);
        }
        return null;
    }

    public final boolean getAuthRequestContext(String str) {
        String str2;
        return "KYC0".equals(str) && "1".equals(this.PlaceComponentResult) && (str2 = this.getAuthRequestContext) != null && "REVOKED".equals(str2);
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return "3".equals(this.PlaceComponentResult) || !PlaceComponentResult();
    }

    public final String BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        if (MyBillsEntityDataFactory()) {
            return context.getResources().getString(R.string.kyb_apply_body);
        }
        return getAuthRequestContext(str) ? context.getResources().getString(R.string.kyb_re_verify_body) : "";
    }

    private boolean MyBillsEntityDataFactory() {
        return "1".equals(this.PlaceComponentResult) && PlaceComponentResult();
    }

    private boolean PlaceComponentResult() {
        return TextUtils.isEmpty(this.getAuthRequestContext);
    }

    public final boolean getAuthRequestContext() {
        return "1".equals(this.PlaceComponentResult) && "REVOKED".equals(this.getAuthRequestContext);
    }
}

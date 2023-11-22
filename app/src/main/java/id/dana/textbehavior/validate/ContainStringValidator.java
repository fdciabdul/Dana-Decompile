package id.dana.textbehavior.validate;

import android.text.TextUtils;

/* loaded from: classes9.dex */
public class ContainStringValidator implements Validator {
    private String getAuthRequestContext;

    @Override // id.dana.textbehavior.validate.Validator
    public final boolean MyBillsEntityDataFactory(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return !str.contains(this.getAuthRequestContext);
    }

    @Override // id.dana.textbehavior.validate.Validator
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        StringBuilder sb = new StringBuilder();
        sb.append("Text cannot contain \"");
        sb.append(this.getAuthRequestContext);
        sb.append("\"");
        return sb.toString();
    }
}

package id.dana.sendmoney;

import android.text.TextUtils;
import id.dana.data.util.NumberUtils;

/* loaded from: classes5.dex */
public class Amount {
    public long getAuthRequestContext;

    public Amount() {
        this.getAuthRequestContext = 999999999L;
    }

    public Amount(byte b) {
        this.getAuthRequestContext = 0L;
    }

    public Amount(String str) {
        long parseLong;
        this.getAuthRequestContext = 999999999L;
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    parseLong = Long.parseLong(NumberUtils.getCleanAll(str));
                    this.getAuthRequestContext = parseLong;
                }
            } catch (NumberFormatException unused) {
                this.getAuthRequestContext = 0L;
                return;
            }
        }
        parseLong = 0;
        this.getAuthRequestContext = parseLong;
    }

    public final boolean getAuthRequestContext() {
        return toString().length() <= 11;
    }

    public String toString() {
        return String.valueOf(this.getAuthRequestContext);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Amount amount) {
        return this.getAuthRequestContext > amount.getAuthRequestContext;
    }
}

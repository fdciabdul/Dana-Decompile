package androidx.browser.customtabs;

import android.os.Bundle;

/* loaded from: classes3.dex */
public final class CustomTabColorSchemeParams {
    public final Integer BuiltInFictitiousFunctionClassFactory;
    public final Integer MyBillsEntityDataFactory;
    public final Integer PlaceComponentResult;
    public final Integer getAuthRequestContext;

    /* loaded from: classes3.dex */
    public static final class Builder {
        public Integer KClassImpl$Data$declaredNonStaticMembers$2;
        public Integer MyBillsEntityDataFactory;
        public Integer PlaceComponentResult;
        public Integer getAuthRequestContext;
    }

    public CustomTabColorSchemeParams(Integer num, Integer num2, Integer num3, Integer num4) {
        this.getAuthRequestContext = num;
        this.BuiltInFictitiousFunctionClassFactory = num2;
        this.MyBillsEntityDataFactory = num3;
        this.PlaceComponentResult = num4;
    }

    public final Bundle PlaceComponentResult() {
        Bundle bundle = new Bundle();
        Integer num = this.getAuthRequestContext;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.BuiltInFictitiousFunctionClassFactory;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.MyBillsEntityDataFactory;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.PlaceComponentResult;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}

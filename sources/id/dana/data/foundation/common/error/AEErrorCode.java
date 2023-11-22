package id.dana.data.foundation.common.error;

import android.text.TextUtils;
import com.iap.ac.android.common.errorcode.IAPAECodeEncoding;

/* loaded from: classes4.dex */
public class AEErrorCode {
    private static String NetworkUserEntityData$$ExternalSyntheticLambda0 = "0";
    public String BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public String PlaceComponentResult;
    public String getAuthRequestContext;
    public String getErrorConfigVersion;

    public static String getAuthRequestContext() {
        return IAPAECodeEncoding.IAP_ERROR_IDENTITY;
    }

    public AEErrorCode() {
        this.getErrorConfigVersion = NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public AEErrorCode(String str, String str2, String str3, String str4, String str5, String str6) {
        this.getErrorConfigVersion = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.MyBillsEntityDataFactory = str3;
        this.getAuthRequestContext = str4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str5;
        this.PlaceComponentResult = str6;
    }

    public String toString() {
        try {
            String str = this.getErrorConfigVersion;
            if (str != null && str.length() == 1) {
                String str2 = this.BuiltInFictitiousFunctionClassFactory;
                if (str2 != null && str2.length() == 1) {
                    String str3 = this.getAuthRequestContext;
                    String str4 = this.getErrorConfigVersion;
                    if (TextUtils.isEmpty(str4)) {
                        throw new IllegalArgumentException();
                    }
                    int i = TextUtils.equals(NetworkUserEntityData$$ExternalSyntheticLambda0, str4) ? 4 : 8;
                    if (str3 != null && str3.length() == i) {
                        String str5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (str5 != null && str5.length() == 3) {
                            String str6 = this.MyBillsEntityDataFactory;
                            if (str6 != null && str6.length() == 1) {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append(TextUtils.equals(NetworkUserEntityData$$ExternalSyntheticLambda0, this.getErrorConfigVersion) ? IAPAECodeEncoding.IAP_ERROR_IDENTITY : this.PlaceComponentResult);
                                stringBuffer.append(this.getErrorConfigVersion);
                                stringBuffer.append(this.BuiltInFictitiousFunctionClassFactory);
                                stringBuffer.append(this.MyBillsEntityDataFactory);
                                stringBuffer.append(this.getAuthRequestContext);
                                stringBuffer.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                                return stringBuffer.toString();
                            }
                            throw new IllegalArgumentException();
                        }
                        throw new IllegalArgumentException();
                    }
                    throw new IllegalArgumentException();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException unused) {
            return "AE15999999999999";
        }
    }
}

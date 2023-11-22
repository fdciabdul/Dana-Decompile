package androidx.constraintlayout.core.motion;

import com.alibaba.wireless.security.SecExceptionCode;

/* loaded from: classes6.dex */
public class CustomVariable {
    public int BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private float MyBillsEntityDataFactory;
    String PlaceComponentResult;
    boolean getAuthRequestContext;
    private String getErrorConfigVersion;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.PlaceComponentResult);
        sb.append(':');
        String obj = sb.toString();
        switch (this.BuiltInFictitiousFunctionClassFactory) {
            case SecExceptionCode.SEC_ERROR_UMID_VALID /* 900 */:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                return sb2.toString();
            case SecExceptionCode.SEC_ERROR_UMID_INVALID_PARAM /* 901 */:
                StringBuilder sb3 = new StringBuilder();
                sb3.append(obj);
                sb3.append(this.MyBillsEntityDataFactory);
                return sb3.toString();
            case SecExceptionCode.SEC_ERROR_UMID_THREADPOOL_FULL /* 902 */:
                StringBuilder sb4 = new StringBuilder();
                sb4.append(obj);
                int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("00000000");
                sb5.append(Integer.toHexString(i));
                String obj2 = sb5.toString();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("#");
                sb6.append(obj2.substring(obj2.length() - 8));
                sb4.append(sb6.toString());
                return sb4.toString();
            case SecExceptionCode.SEC_ERROR_UMID_GET_URL_ERROR /* 903 */:
                StringBuilder sb7 = new StringBuilder();
                sb7.append(obj);
                sb7.append(this.getErrorConfigVersion);
                return sb7.toString();
            case SecExceptionCode.SEC_ERROR_UMID_NETWORK_ERROR /* 904 */:
                StringBuilder sb8 = new StringBuilder();
                sb8.append(obj);
                sb8.append(Boolean.valueOf(this.getAuthRequestContext));
                return sb8.toString();
            case SecExceptionCode.SEC_ERROR_UMID_SERVER_RESP_INVALID /* 905 */:
                StringBuilder sb9 = new StringBuilder();
                sb9.append(obj);
                sb9.append(this.MyBillsEntityDataFactory);
                return sb9.toString();
            default:
                StringBuilder sb10 = new StringBuilder();
                sb10.append(obj);
                sb10.append("????");
                return sb10.toString();
        }
    }

    public final boolean PlaceComponentResult() {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        return (i == 903 || i == 904 || i == 906) ? false : true;
    }

    public final void PlaceComponentResult(float[] fArr) {
        switch (this.BuiltInFictitiousFunctionClassFactory) {
            case SecExceptionCode.SEC_ERROR_UMID_VALID /* 900 */:
                fArr[0] = this.KClassImpl$Data$declaredNonStaticMembers$2;
                return;
            case SecExceptionCode.SEC_ERROR_UMID_INVALID_PARAM /* 901 */:
                fArr[0] = this.MyBillsEntityDataFactory;
                return;
            case SecExceptionCode.SEC_ERROR_UMID_THREADPOOL_FULL /* 902 */:
                int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
                float pow = (float) Math.pow(((i >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((i >> 8) & 255) / 255.0f, 2.2d);
                float pow3 = (float) Math.pow((i & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = pow3;
                fArr[3] = ((i >> 24) & 255) / 255.0f;
                return;
            case SecExceptionCode.SEC_ERROR_UMID_GET_URL_ERROR /* 903 */:
                throw new RuntimeException("Cannot interpolate String");
            case SecExceptionCode.SEC_ERROR_UMID_NETWORK_ERROR /* 904 */:
                fArr[0] = this.getAuthRequestContext ? 1.0f : 0.0f;
                return;
            case SecExceptionCode.SEC_ERROR_UMID_SERVER_RESP_INVALID /* 905 */:
                fArr[0] = this.MyBillsEntityDataFactory;
                return;
            default:
                return;
        }
    }
}

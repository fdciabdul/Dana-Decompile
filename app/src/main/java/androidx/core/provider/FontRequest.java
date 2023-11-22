package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.Preconditions;
import id.dana.R;
import java.util.List;

/* loaded from: classes.dex */
public final class FontRequest {
    final String BuiltInFictitiousFunctionClassFactory;
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    final String MyBillsEntityDataFactory;
    final List<List<byte[]>> PlaceComponentResult;
    final String getAuthRequestContext;
    final String lookAheadTest;

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list) {
        this.getAuthRequestContext = (String) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(str);
        this.BuiltInFictitiousFunctionClassFactory = (String) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(str2);
        this.lookAheadTest = (String) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(str3);
        this.PlaceComponentResult = (List) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(list);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        this.MyBillsEntityDataFactory = PlaceComponentResult(str, str2, str3);
    }

    public FontRequest(String str, String str2, String str3) {
        this.getAuthRequestContext = (String) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(str);
        this.BuiltInFictitiousFunctionClassFactory = (String) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(str2);
        this.lookAheadTest = (String) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(str3);
        this.PlaceComponentResult = null;
        Preconditions.getAuthRequestContext(true);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = R.array.com_google_android_gms_fonts_certs;
        this.MyBillsEntityDataFactory = PlaceComponentResult(str, str2, str3);
    }

    private static String PlaceComponentResult(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append("-");
        sb.append(str2);
        sb.append("-");
        sb.append(str3);
        return sb.toString();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: ");
        sb2.append(this.getAuthRequestContext);
        sb2.append(", mProviderPackage: ");
        sb2.append(this.BuiltInFictitiousFunctionClassFactory);
        sb2.append(", mQuery: ");
        sb2.append(this.lookAheadTest);
        sb2.append(", mCertificates:");
        sb.append(sb2.toString());
        for (int i = 0; i < this.PlaceComponentResult.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.PlaceComponentResult.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("mCertificatesArray: ");
        sb3.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(sb3.toString());
        return sb.toString();
    }
}

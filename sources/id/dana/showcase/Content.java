package id.dana.showcase;

import android.text.Spannable;
import id.dana.R;

/* loaded from: classes3.dex */
public class Content {
    public Spannable BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public int PlaceComponentResult;
    public String getAuthRequestContext;

    public Content() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
        this.getAuthRequestContext = "";
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.PlaceComponentResult = R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2;
        this.MyBillsEntityDataFactory = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
    }

    public Content(String str, String str2) {
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.PlaceComponentResult = R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2;
        this.MyBillsEntityDataFactory = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getAuthRequestContext = str2;
    }

    public Content(String str, String str2, int i) {
        this(str, str2);
        this.PlaceComponentResult = i;
    }

    public Content(String str, Spannable spannable) {
        this.getAuthRequestContext = "";
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.PlaceComponentResult = R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2;
        this.MyBillsEntityDataFactory = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getAuthRequestContext = spannable.toString();
        this.BuiltInFictitiousFunctionClassFactory = spannable;
    }

    public Content(String str, String str2, String str3) {
        this(str, str2);
        this.MyBillsEntityDataFactory = str3;
    }

    public Content(String str, String str2, String str3, String str4) {
        this(str, str2, str3);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
    }
}

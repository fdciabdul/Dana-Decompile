package id.dana.savings.parser;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/savings/parser/SavingErrorParser;", "", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", "p1", "PlaceComponentResult", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingErrorParser {
    public static final SavingErrorParser INSTANCE = new SavingErrorParser();

    private SavingErrorParser() {
    }

    public static String PlaceComponentResult(Context p0, String p1) {
        String string;
        Intrinsics.checkNotNullParameter(p0, "");
        try {
            String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(p1);
            StringBuilder sb = new StringBuilder();
            sb.append("error_saving_");
            sb.append(BuiltInFictitiousFunctionClassFactory);
            String obj = sb.toString();
            String packageName = p0.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "");
            string = p0.getString(p0.getResources().getIdentifier(obj, "string", packageName));
        } catch (Exception unused) {
        }
        return string == null ? "System is Busy" : string;
    }

    public static String BuiltInFictitiousFunctionClassFactory(String p0) {
        if (p0 == null) {
            p0 = "";
        }
        try {
            List split$default = StringsKt.split$default((CharSequence) p0, new String[]{"}:"}, false, 0, 6, (Object) null);
            StringBuilder sb = new StringBuilder();
            sb.append((String) StringsKt.split$default((CharSequence) split$default.get(0), new String[]{"{"}, false, 0, 6, (Object) null).get(1));
            sb.append('}');
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append('{');
            sb2.append(obj);
            String string = new JSONObject(sb2.toString()).getString("errorCode");
            Intrinsics.checkNotNullExpressionValue(string, "");
            return string;
        } catch (Exception unused) {
            return "";
        }
    }
}

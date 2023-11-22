package id.dana.utils;

import android.content.Context;
import android.text.TextUtils;
import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.domain.profilemenu.model.SettingModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0007\u0010\fJ+\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\b"}, d2 = {"Lid/dana/utils/ResourceUtils;", "", "Landroid/content/Context;", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Ljava/lang/String;)I", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/profilemenu/model/SettingModel;", "(Landroid/content/Context;Lid/dana/domain/profilemenu/model/SettingModel;)Ljava/lang/String;", "p2", "PlaceComponentResult", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResourceUtils {
    public static final ResourceUtils INSTANCE = new ResourceUtils();

    private ResourceUtils() {
    }

    @JvmStatic
    public static final String PlaceComponentResult(Context p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p1;
        if (str == null || str.length() == 0) {
            return p1 == null ? "" : p1;
        }
        String lowerCase = new Regex(" ").replace(str, "_").toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        int PlaceComponentResult = PlaceComponentResult(p0, lowerCase);
        if (PlaceComponentResult <= 0) {
            return p2 == null ? "" : p2;
        }
        String string = p0.getString(PlaceComponentResult);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    @JvmStatic
    public static final String BuiltInFictitiousFunctionClassFactory(Context p0, SettingModel p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (Intrinsics.areEqual(MyProfileMenuAction.SETTING_APP_VERSION, p1.getName())) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String title = p1.getTitle();
            Intrinsics.checkNotNullExpressionValue(title, "");
            String lowerCase = new Regex(" ").replace(title, "_").toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "");
            String format = String.format("%s%s", Arrays.copyOf(new Object[]{"setting_", lowerCase}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "");
            return PlaceComponentResult(p0, format, p1.getTitle());
        }
        return PlaceComponentResult(p0, p1.getTitle(), p1.getTitle());
    }

    public static int PlaceComponentResult(Context p0, String p1) {
        if (p0 == null || TextUtils.isEmpty(p1)) {
            return 0;
        }
        return p0.getResources().getIdentifier(p1, "string", p0.getPackageName());
    }

    public static int MyBillsEntityDataFactory(Context p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        StringBuilder sb = new StringBuilder();
        sb.append("icon_");
        String lowerCase = new Regex(" ").replace(p1, "_").toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        sb.append(lowerCase);
        return p0.getResources().getIdentifier(sb.toString(), "drawable", p0.getPackageName());
    }

    public static int BuiltInFictitiousFunctionClassFactory(Context p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p1 != null ? p0.getResources().getIdentifier(p1, "raw", p0.getPackageName()) : id.dana.R.raw.f47082131886125;
    }

    @JvmStatic
    public static final int KClassImpl$Data$declaredNonStaticMembers$2(Context p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String lowerCase = new Regex(" ").replace(p1, "_").toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return p0.getResources().getIdentifier(lowerCase, "drawable", p0.getPackageName());
    }
}

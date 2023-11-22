package id.dana.core.ui.util;

import android.text.TextUtils;
import id.dana.cashier.view.InputCardNumberView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u0005J#\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u0011\u0010\u0013\u001a\u00020\u0002*\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u0011\u0010\u0014\u001a\u00020\u0002*\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u0011\u0010\u0015\u001a\u00020\u0002*\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u0011\u0010\u0016\u001a\u00020\u0002*\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0005J\u0013\u0010\u0017\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u0013\u0010\u0018\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u0011\u0010\u0019\u001a\u00020\u0002*\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0005"}, d2 = {"Lid/dana/core/ui/util/NumberUtil;", "", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Ljava/lang/String;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "p1", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "NetworkUserEntityData$$ExternalSyntheticLambda2", "(Ljava/lang/String;)Z", "initRecordTimeStamp", "newProxyInstance", "lookAheadTest", "scheduleImpl", "MyBillsEntityDataFactory", "moveToNextValue", "getErrorConfigVersion", "DatabaseTableConfigUtil", "GetContactSyncConfig", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda1", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NumberUtil {
    public static final NumberUtil INSTANCE = new NumberUtil();

    private NumberUtil() {
    }

    public static String BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p0, "");
        String replace$default = StringsKt.replace$default(p0, ",", "", false, 4, (Object) null);
        Intrinsics.checkNotNullParameter(replace$default, "");
        return StringsKt.replace$default(replace$default, ".", "", false, 4, (Object) null);
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return StringsKt.replace$default(p0, ".", "", false, 4, (Object) null);
    }

    public static String PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return StringsKt.replace$default(p0, ",", "", false, 4, (Object) null);
    }

    public static String getAuthRequestContext(String p0) {
        if (TextUtils.isEmpty(p0)) {
            return "";
        }
        Intrinsics.checkNotNull(p0);
        return PlaceComponentResult(StringsKt.replace$default(p0, "-", "", false, 4, (Object) null), "62-");
    }

    public static String NetworkUserEntityData$$ExternalSyntheticLambda0(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return TextUtils.isEmpty(p0) ? "" : StringsKt.startsWith$default(p0, "62-", false, 2, (Object) null) ? StringsKt.replace$default(p0, "62-", "+62", false, 4, (Object) null) : p0;
    }

    public static String PlaceComponentResult(String p0, String p1) {
        String str = p0;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intrinsics.checkNotNull(p0);
        String replace = new Regex("(.)(\\++)(.)").replace(new Regex("(^[1-9].+)").replace(new Regex("[^0-9\\+]").replace(str, ""), "$1"), "$1$3");
        String str2 = replace;
        if (new Regex("^628{1,4}.*").matches(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(p1);
            String substring = replace.substring(2);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            sb.append(substring);
            replace = sb.toString();
        } else if (new Regex("^\\+628{1,4}.*").matches(str2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(p1);
            String substring2 = replace.substring(3);
            Intrinsics.checkNotNullExpressionValue(substring2, "");
            sb2.append(substring2);
            replace = sb2.toString();
        } else if (new Regex("^08{1,3}.*").matches(str2)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(p1);
            String substring3 = replace.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring3, "");
            sb3.append(substring3);
            replace = sb3.toString();
        }
        String str3 = replace;
        Intrinsics.checkNotNullParameter(str3, "");
        return StringsKt.replace$default(str3, " ", "", false, 4, (Object) null);
    }

    private static boolean newProxyInstance(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (TextUtils.isEmpty(p0) || !NetworkUserEntityData$$ExternalSyntheticLambda2(p0)) {
            return false;
        }
        return StringsKt.startsWith$default(p0, "+62", false, 2, (Object) null) || StringsKt.startsWith$default(p0, "08", false, 2, (Object) null);
    }

    private static boolean initRecordTimeStamp(String p0) {
        if (TextUtils.isEmpty(p0) || !NetworkUserEntityData$$ExternalSyntheticLambda2(p0)) {
            return false;
        }
        return StringsKt.startsWith$default(p0, "+628", false, 2, (Object) null) || StringsKt.startsWith$default(p0, "08", false, 2, (Object) null) || StringsKt.startsWith$default(p0, "628", false, 2, (Object) null);
    }

    public static boolean scheduleImpl(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return newProxyInstance(p0) && p0.length() >= 8;
    }

    public static boolean lookAheadTest(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return initRecordTimeStamp(p0) && p0.length() >= 8;
    }

    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda2(String p0) {
        if (StringsKt.startsWith$default(p0, "+", false, 2, (Object) null) && p0.length() > 1) {
            p0 = p0.substring(1);
            Intrinsics.checkNotNullExpressionValue(p0, "");
        }
        return TextUtils.isDigitsOnly(p0);
    }

    public static String MyBillsEntityDataFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        if (str.length() > 4) {
            if (StringsKt.startsWith$default(str, "+628", false, 2, (Object) null) || StringsKt.startsWith$default(str, "628", false, 2, (Object) null)) {
                return GetContactSyncConfig(str);
            }
            return isLayoutRequested(str);
        }
        return str;
    }

    public static String moveToNextValue(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("(.{5})(?=.)").replace(str, "$1-");
    }

    public static String getErrorConfigVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("(?<=.{4})-(?=.{4})").replace(str, "");
    }

    public static String DatabaseTableConfigUtil(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        if (StringsKt.startsWith$default(str, "+628", false, 2, (Object) null) || StringsKt.startsWith$default(str, "628", false, 2, (Object) null)) {
            return GetContactSyncConfig(str);
        }
        return isLayoutRequested(str);
    }

    private static String GetContactSyncConfig(String str) {
        int i;
        String substring;
        String substring2;
        String str2 = "";
        int i2 = 0;
        int i3 = 0;
        while (i2 <= 3 && i3 < str.length()) {
            if (i2 != 0) {
                if (i2 == 1) {
                    i = i3 + 3;
                    substring2 = str.substring(i3, RangesKt.coerceAtMost(str.length(), i));
                    Intrinsics.checkNotNullExpressionValue(substring2, "");
                } else if (i2 == 2) {
                    i = i3 + 4;
                    substring2 = str.substring(i3, RangesKt.coerceAtMost(str.length(), i));
                    Intrinsics.checkNotNullExpressionValue(substring2, "");
                } else if (i2 == 3) {
                    substring = str.substring(i3);
                    Intrinsics.checkNotNullExpressionValue(substring, "");
                    i2++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(substring);
                    sb.append(InputCardNumberView.DIVIDER);
                    str2 = sb.toString();
                } else {
                    substring = "";
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(substring);
                    sb2.append(InputCardNumberView.DIVIDER);
                    str2 = sb2.toString();
                }
                substring = substring2;
            } else if (StringsKt.startsWith$default(str, "+628", false, 2, (Object) null)) {
                i = i3 + 3;
                substring = str.substring(i3, RangesKt.coerceAtMost(str.length(), i));
                Intrinsics.checkNotNullExpressionValue(substring, "");
            } else {
                i = i3 + 2;
                substring = str.substring(i3, RangesKt.coerceAtMost(str.length(), i));
                Intrinsics.checkNotNullExpressionValue(substring, "");
            }
            i3 = i;
            i2++;
            StringBuilder sb22 = new StringBuilder();
            sb22.append(str2);
            sb22.append(substring);
            sb22.append(InputCardNumberView.DIVIDER);
            str2 = sb22.toString();
        }
        return StringsKt.replace$default(StringsKt.trim((CharSequence) str2).toString(), " ", "-", false, 4, (Object) null);
    }

    private static String isLayoutRequested(String str) {
        String substring;
        if (TextUtils.isDigitsOnly(str)) {
            int i = 0;
            String str2 = "";
            int i2 = 0;
            while (i <= 2 && i2 < str.length()) {
                int i3 = 8;
                if (i < 2) {
                    i3 = i2 + 4;
                    substring = str.substring(i2, RangesKt.coerceAtMost(str.length(), i3));
                    Intrinsics.checkNotNullExpressionValue(substring, "");
                    i++;
                } else {
                    substring = str.substring(8);
                    Intrinsics.checkNotNullExpressionValue(substring, "");
                    i = 3;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(substring);
                sb.append(InputCardNumberView.DIVIDER);
                str2 = sb.toString();
                i2 = i3;
            }
            return StringsKt.replace$default(StringsKt.trim((CharSequence) str2).toString(), " ", "-", false, 4, (Object) null);
        }
        return str;
    }

    public static String NetworkUserEntityData$$ExternalSyntheticLambda1(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("^(628)").replace(new Regex("[^0-9]").replace(str, ""), "08");
    }
}

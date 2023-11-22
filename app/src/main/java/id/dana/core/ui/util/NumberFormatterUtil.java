package id.dana.core.ui.util;

import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0007\u0010\u0011J+\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\u0012J#\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0014\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0016"}, d2 = {"Lid/dana/core/ui/util/NumberFormatterUtil;", "", "", "p0", "", "p1", "Lkotlin/Pair;", "MyBillsEntityDataFactory", "(ZLjava/lang/String;)Lkotlin/Pair;", "Ljava/util/Locale;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/Locale;D)Ljava/lang/String;", "p2", "PlaceComponentResult", "(Ljava/util/Locale;DLjava/lang/String;)Ljava/lang/String;", "", "(Ljava/util/Locale;I)Ljava/lang/String;", "(Ljava/util/Locale;ILjava/lang/String;)Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/Locale;J)Ljava/lang/String;", "(Ljava/util/Locale;JLjava/lang/String;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NumberFormatterUtil {
    public static final NumberFormatterUtil INSTANCE = new NumberFormatterUtil();

    private NumberFormatterUtil() {
    }

    @JvmStatic
    public static final String MyBillsEntityDataFactory(Locale p0, int p1) {
        return NumberFormat.getNumberInstance(p0).format(p1);
    }

    @JvmStatic
    public static final String MyBillsEntityDataFactory(Locale p0, int p1, String p2) {
        if (p2 == null || StringsKt.equals(p2, GlobalNetworkConstants.IDR_CURRENCY, true)) {
            p2 = "Rp";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(p2);
        sb.append(NumberFormat.getNumberInstance(p0).format(p1));
        return sb.toString();
    }

    @JvmStatic
    public static final String BuiltInFictitiousFunctionClassFactory(Locale p0, long p1) {
        return NumberFormat.getNumberInstance(p0).format(p1);
    }

    @JvmStatic
    public static final String KClassImpl$Data$declaredNonStaticMembers$2(Locale p0, double p1) {
        return NumberFormat.getNumberInstance(p0).format(p1);
    }

    @JvmStatic
    public static final String BuiltInFictitiousFunctionClassFactory(Locale p0, long p1, String p2) {
        if (p2 == null || StringsKt.equals(p2, GlobalNetworkConstants.IDR_CURRENCY, true)) {
            p2 = "Rp";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(p2);
        sb.append(NumberFormat.getNumberInstance(p0).format(p1));
        return sb.toString();
    }

    @JvmStatic
    public static final String PlaceComponentResult(Locale p0, double p1, String p2) {
        if (p2 == null || StringsKt.equals(p2, GlobalNetworkConstants.IDR_CURRENCY, true)) {
            p2 = "Rp";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(p2);
        sb.append(NumberFormat.getNumberInstance(p0).format(p1));
        return sb.toString();
    }

    public static Pair<String, String> MyBillsEntityDataFactory(boolean p0, String p1) {
        List listOf;
        String format;
        Intrinsics.checkNotNullParameter(p1, "");
        if (p0) {
            listOf = CollectionsKt.listOf((Object[]) new String[]{"", "rb", "jt"});
        } else {
            listOf = CollectionsKt.listOf((Object[]) new String[]{"", "k", "mil"});
        }
        double parseDouble = Double.parseDouble(p1);
        int floor = (int) Math.floor(Math.log10(parseDouble));
        int i = floor / 3;
        if (floor >= 3 && i < listOf.size()) {
            DecimalFormat decimalFormat = new DecimalFormat("0.#");
            double d = i;
            Double.isNaN(d);
            format = decimalFormat.format(parseDouble / Math.pow(10.0d, d * 3.0d));
        } else {
            format = new DecimalFormat("#,##0").format(parseDouble);
        }
        return new Pair<>(format, listOf.get(i));
    }
}

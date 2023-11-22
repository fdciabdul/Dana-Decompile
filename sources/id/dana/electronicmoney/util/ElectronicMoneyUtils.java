package id.dana.electronicmoney.util;

import android.os.Build;
import id.dana.cashier.view.InputCardNumberView;
import j$.time.LocalDateTime;
import j$.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\t\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\r"}, d2 = {"Lid/dana/electronicmoney/util/ElectronicMoneyUtils;", "", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/lang/String;", "", "PlaceComponentResult", "([B)Ljava/lang/String;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)[B", "", "[C", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ElectronicMoneyUtils {
    public static final ElectronicMoneyUtils INSTANCE = new ElectronicMoneyUtils();
    private static final char[] MyBillsEntityDataFactory;

    private ElectronicMoneyUtils() {
    }

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "");
        MyBillsEntityDataFactory = charArray;
    }

    public static byte[] BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int length = p0.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(p0.charAt(i), 16) << 4) + Character.digit(p0.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static String PlaceComponentResult(byte[] p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        char[] cArr = new char[p0.length * 2];
        int length = p0.length;
        for (int i = 0; i < length; i++) {
            int i2 = p0[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = MyBillsEntityDataFactory;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static String PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (Build.VERSION.SDK_INT >= 26) {
            String format = LocalDateTime.now().format(DateTimeFormatter.MyBillsEntityDataFactory(p0));
            Intrinsics.checkNotNullExpressionValue(format, "");
            return format;
        }
        String format2 = new SimpleDateFormat(p0, Locale.getDefault()).format(new Date());
        Intrinsics.checkNotNullExpressionValue(format2, "");
        return format2;
    }

    public static String MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        currencyInstance.setMaximumFractionDigits(0);
        String format = currencyInstance.format(Long.parseLong(p0));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    public static String getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        StringBuilder sb = new StringBuilder();
        String substring = p0.substring(0, 4);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        sb.append(substring);
        sb.append(InputCardNumberView.DIVIDER);
        String substring2 = p0.substring(4, 8);
        Intrinsics.checkNotNullExpressionValue(substring2, "");
        sb.append(substring2);
        sb.append(InputCardNumberView.DIVIDER);
        String substring3 = p0.substring(8, 12);
        Intrinsics.checkNotNullExpressionValue(substring3, "");
        sb.append(substring3);
        sb.append(InputCardNumberView.DIVIDER);
        String substring4 = p0.substring(12);
        Intrinsics.checkNotNullExpressionValue(substring4, "");
        sb.append(substring4);
        return sb.toString();
    }
}

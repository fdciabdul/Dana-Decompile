package id.dana.domain.merchant;

import android.os.Process;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import o.whenAvailable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n"}, d2 = {"Lid/dana/domain/merchant/MerchantCategoryType;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "MAPS", "LIST"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MerchantCategoryType {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final /* synthetic */ MerchantCategoryType[] $VALUES;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2;
    public static final MerchantCategoryType LIST;
    public static final MerchantCategoryType MAPS;
    private static long MyBillsEntityDataFactory;
    private static char[] PlaceComponentResult;
    private final String key;

    private static final /* synthetic */ MerchantCategoryType[] $values() {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            MerchantCategoryType[] merchantCategoryTypeArr = {MAPS, LIST};
            int i3 = BuiltInFictitiousFunctionClassFactory + 65;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return merchantCategoryTypeArr;
        } catch (Exception e) {
            throw e;
        }
    }

    static void PlaceComponentResult() {
        PlaceComponentResult = new char[]{4714, 13287, 20863, 30443, 38011, 46591, 56183, 63696, 7792, 16329, 23892, 25284, 32862, 41377, 50990, 58558, 2606, 11149, 18736, 28345, 35859, 44445, 62262, 4251, 13837, 22430, 30176, 39794, 26871, 18810, 11234, 3190, 61158, 53090, 41450, 33357, 25837, 17748, 10185, 6233, 64195, 56124, 48563, 40483, 28851, 20752, 13228, 5164, 63117, 55047, 35243, 27142, 19600, 11523, 3965, 57839};
        MyBillsEntityDataFactory = 730906048276189899L;
    }

    public static MerchantCategoryType valueOf(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 101;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        MerchantCategoryType merchantCategoryType = (MerchantCategoryType) Enum.valueOf(MerchantCategoryType.class, str);
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 75;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return merchantCategoryType;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static MerchantCategoryType[] values() {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 61;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                MerchantCategoryType[] merchantCategoryTypeArr = (MerchantCategoryType[]) $VALUES.clone();
                int i3 = BuiltInFictitiousFunctionClassFactory + 9;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return merchantCategoryTypeArr;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private MerchantCategoryType(String str, int i, String str2) {
        this.key = str2;
    }

    @JvmName(name = "getKey")
    public final String getKey() {
        int i = BuiltInFictitiousFunctionClassFactory + 81;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
            int i2 = 5 / 0;
            return this.key;
        }
        return this.key;
    }

    static {
        PlaceComponentResult();
        Object[] objArr = new Object[1];
        a((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 28 - (Process.myPid() >> 22), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 57672), objArr);
        MAPS = new MerchantCategoryType("MAPS", 0, ((String) objArr[0]).intern());
        Object[] objArr2 = new Object[1];
        a(28 - Gravity.getAbsoluteGravity(0, 0), (ViewConfiguration.getScrollBarSize() >> 8) + 28, (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 39892), objArr2);
        LIST = new MerchantCategoryType("LIST", 1, ((String) objArr2[0]).intern());
        $VALUES = $values();
        int i = BuiltInFictitiousFunctionClassFactory + 91;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? (char) 24 : (char) 5) != 5) {
            int i2 = 69 / 0;
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        int i3;
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if (whenavailable.BuiltInFictitiousFunctionClassFactory >= i2) {
                break;
            }
            try {
                int i4 = $11 + 69;
                try {
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                    jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (PlaceComponentResult[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ MyBillsEntityDataFactory))) ^ c;
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
            throw e;
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
            int i6 = $10 + 105;
            $11 = i6 % 128;
            if ((i6 % 2 == 0 ? 'X' : 'Y') != 'X') {
                cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                i3 = whenavailable.BuiltInFictitiousFunctionClassFactory + 1;
            } else {
                cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                i3 = whenavailable.BuiltInFictitiousFunctionClassFactory + 0;
            }
            whenavailable.BuiltInFictitiousFunctionClassFactory = i3;
        }
        objArr[0] = new String(cArr);
    }
}

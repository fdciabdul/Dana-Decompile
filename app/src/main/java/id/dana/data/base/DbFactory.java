package id.dana.data.base;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewConfiguration;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import com.alibaba.fastjson.parser.JSONLexer;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.base.SqlCipherUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;
import o.A;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/base/DbFactory;", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/data/base/BasePersistenceDao;", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(Landroid/content/Context;)Lid/dana/data/base/BasePersistenceDao;", "", "DB_VERSION", "I", "", "PRODUCTION", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DbFactory {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    public static final int DB_VERSION = 30;
    public static final DbFactory INSTANCE;
    private static final String PRODUCTION = "production";
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 1;

    static {
        try {
            BuiltInFictitiousFunctionClassFactory();
            try {
                INSTANCE = new DbFactory();
                int i = PlaceComponentResult + 117;
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        BuiltInFictitiousFunctionClassFactory = 269894656;
    }

    private DbFactory() {
    }

    @JvmStatic
    public static final BasePersistenceDao create(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        RoomDatabase.Builder KClassImpl$Data$declaredNonStaticMembers$2 = Room.KClassImpl$Data$declaredNonStaticMembers$2(context, BasePersistenceDao.class, "DB-6CC59C4231550-production");
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = false;
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = true;
        RoomDatabase.Builder KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(BasePersistence.MIGRATION_3_4, BasePersistence.MIGRATION_4_5, BasePersistence.MIGRATION_5_6, BasePersistence.MIGRATION_6_7, BasePersistence.MIGRATION_7_8, BasePersistence.MIGRATION_9_10, BasePersistence.MIGRATION_10_11, BasePersistence.MIGRATION_11_12, BasePersistence.MIGRATION_12_13, BasePersistence.MIGRATION_13_14, BasePersistence.MIGRATION_14_15, BasePersistence.MIGRATION_15_16, BasePersistence.MIGRATION_16_17, BasePersistence.MIGRATION_17_18, BasePersistence.MIGRATION_18_19, BasePersistence.MIGRATION_19_20, BasePersistence.MIGRATION_20_21, BasePersistence.MIGRATION_21_22, BasePersistence.MIGRATION_22_23, BasePersistence.MIGRATION_23_24, BasePersistence.MIGRATION_24_25, BasePersistence.MIGRATION_25_26, BasePersistence.MIGRATION_26_27, BasePersistence.MIGRATION_27_28, BasePersistence.MIGRATION_28_29, BasePersistence.MIGRATION_29_30);
        KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory = true;
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = RoomDatabase.JournalMode.AUTOMATIC;
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
        if ((StringsKt.equals("production", "production", true) ? ')' : '(') == ')') {
            Object[] objArr = new Object[1];
            a(new char[]{65516, 65515, 65514, 65515, JSONLexer.EOI, 65511, 65512, 65519, 65510, 65511, 65519, 24, 23, 65510, 28, 23, 27, 65516, 65519, JSONLexer.EOI, 65517, 23, 25, 65515, 65510, 65512, 25, 25, 27, 65512, 23, 65515, JSONLexer.EOI, 24, 27, 65512, 27, 28, 65518, 27}, Color.red(0) + 111, (ViewConfiguration.getPressedStateDuration() >> 16) + 40, true, 19 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr);
            char[] charArray = ((String) objArr[0]).intern().toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "");
            byte[] bytes = SQLiteDatabase.getBytes(charArray);
            if (!(SqlCipherUtils.State.UNENCRYPTED != SqlCipherUtils.getDatabaseState(context, "DB-6CC59C4231550-production"))) {
                int i = getAuthRequestContext + 119;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullExpressionValue(bytes, "");
                SqlCipherUtils.encrypt(context, "DB-6CC59C4231550-production", bytes);
            }
            KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2 = new SupportFactory(bytes);
            int i3 = getAuthRequestContext + 49;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        }
        RoomDatabase BuiltInFictitiousFunctionClassFactory2 = KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
        return (BasePersistenceDao) BuiltInFictitiousFunctionClassFactory2;
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        try {
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i2) {
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                int i4 = a2.MyBillsEntityDataFactory;
                cArr2[i4] = (char) (cArr2[i4] - ((int) (BuiltInFictitiousFunctionClassFactory ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            }
            if (!(i3 <= 0)) {
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr3 = new char[i2];
                System.arraycopy(cArr2, 0, cArr3, 0, i2);
                System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
            }
            if (z) {
                char[] cArr4 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
                int i5 = $10 + 53;
                $11 = i5 % 128;
                while (true) {
                    try {
                        int i6 = i5 % 2;
                        if (a2.MyBillsEntityDataFactory >= i2) {
                            break;
                        }
                        cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                        a2.MyBillsEntityDataFactory++;
                        i5 = $10 + 29;
                        $11 = i5 % 128;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                cArr2 = cArr4;
            }
            objArr[0] = new String(cArr2);
        } catch (Exception e2) {
            throw e2;
        }
    }
}

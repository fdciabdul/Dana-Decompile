package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.tab.HomeTabs;
import id.dana.kyb.model.KybPageInfo;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.B;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0005\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\f\u0010\u000b"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureKyb;", "", "", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/Map;)Ljava/lang/String;", "Landroid/app/Activity;", "p1", "", "MyBillsEntityDataFactory", "(Landroid/app/Activity;Ljava/util/Map;)V", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureKyb {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1531617980;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static short[] PlaceComponentResult = null;
    private static int getAuthRequestContext = 1257195685;
    private static int getErrorConfigVersion;
    private static byte[] MyBillsEntityDataFactory = {-111, -99, 101, 108, -101, -110, -115, -97};
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1995151631;

    @Inject
    public FeatureKyb() {
    }

    public static void MyBillsEntityDataFactory(Activity p0, Map<String, String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        HomeTabActivity.Companion companion = HomeTabActivity.INSTANCE;
        HomeTabActivity.Companion.getAuthRequestContext(p0, HomeTabs.ME, new KybPageInfo(true, false, KClassImpl$Data$declaredNonStaticMembers$2(p1), false, 10, null));
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 55;
        getErrorConfigVersion = i % 128;
        if (!(i % 2 != 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static void PlaceComponentResult(Activity p0, Map<String, String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        HomeTabActivity.Companion companion = HomeTabActivity.INSTANCE;
        HomeTabActivity.Companion.getAuthRequestContext(p0, HomeTabs.ME, new KybPageInfo(true, true, KClassImpl$Data$declaredNonStaticMembers$2(p1), false, 8, null));
        int i = getErrorConfigVersion + 123;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 == 0 ? '-' : (char) 5) != 5) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(Map<String, String> p0) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 45;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        String str = p0.get("source");
        Object[] objArr = new Object[1];
        a((-1006948752) - TextUtils.getTrimmedLength(""), Color.argb(0, 0, 0, 0) - 50, (short) (ViewConfiguration.getTouchSlop() >> 8), TextUtils.getCapsMode("", 0, 0) - 296085968, (byte) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), objArr);
        if ((Intrinsics.areEqual(str, ((String) objArr[0]).intern()) ? (char) 17 : (char) 22) != 22) {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 53;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 3;
            getErrorConfigVersion = i5 % 128;
            int i6 = i5 % 2;
            return "User";
        }
        return "Deeplink";
    }

    private static void a(int i, int i2, short s, int i3, byte b, Object[] objArr) {
        int i4;
        int i5;
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i6 = i2 + ((int) (getAuthRequestContext ^ 3097486228508854431L));
        boolean z = i6 == -1;
        if (z) {
            byte[] bArr = MyBillsEntityDataFactory;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                int i7 = $11 + 53;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                for (int i9 = 0; i9 < length; i9++) {
                    bArr2[i9] = (byte) (bArr[i9] ^ 3097486228508854431L);
                }
                int i10 = $10 + 81;
                $11 = i10 % 128;
                int i11 = i10 % 2;
                bArr = bArr2;
            }
            if (bArr != null) {
                int i12 = $10 + 69;
                $11 = i12 % 128;
                if (i12 % 2 == 0) {
                    i5 = ((byte) (MyBillsEntityDataFactory[i >>> ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] / 3097486228508854431L)) >>> ((int) (getAuthRequestContext | 3097486228508854431L));
                } else {
                    try {
                        i5 = ((byte) (MyBillsEntityDataFactory[i + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (getAuthRequestContext ^ 3097486228508854431L));
                    } catch (Exception e) {
                        throw e;
                    }
                }
                i6 = (byte) i5;
            } else {
                i6 = (short) (((short) (PlaceComponentResult[i + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (getAuthRequestContext ^ 3097486228508854431L)));
            }
        }
        if (i6 > 0) {
            int i13 = ((i + i6) - 2) + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L));
            if (!(!z)) {
                int i14 = $10 + 37;
                $11 = i14 % 128;
                int i15 = i14 % 2;
                i4 = 1;
            } else {
                i4 = 0;
            }
            b2.getAuthRequestContext = i13 + i4;
            b2.MyBillsEntityDataFactory = (char) (i3 + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = MyBillsEntityDataFactory;
            if ((bArr3 != null ? Typography.dollar : 'O') != 'O') {
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                int i16 = 0;
                while (true) {
                    if ((i16 < length2 ? (char) 17 : 'W') == 'W') {
                        break;
                    }
                    bArr4[i16] = (byte) (bArr3[i16] ^ 3097486228508854431L);
                    i16++;
                }
                bArr3 = bArr4;
            }
            boolean z2 = bArr3 != null;
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i6) {
                if (z2) {
                    byte[] bArr5 = MyBillsEntityDataFactory;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = PlaceComponentResult;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                }
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                b2.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        objArr[0] = sb.toString();
    }
}

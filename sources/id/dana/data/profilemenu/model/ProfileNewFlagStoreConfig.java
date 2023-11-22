package id.dana.data.profilemenu.model;

import id.dana.domain.profilemenu.model.UserConfigProfileNewFlag;
import id.dana.domain.userconfig.model.StoreConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/profilemenu/model/ProfileNewFlagStoreConfig;", "Lid/dana/domain/userconfig/model/StoreConfig;", "Lid/dana/domain/profilemenu/model/UserConfigProfileNewFlag;", "content", "Lid/dana/domain/profilemenu/model/UserConfigProfileNewFlag;", "getContent", "()Lid/dana/domain/profilemenu/model/UserConfigProfileNewFlag;", "<init>", "(Lid/dana/domain/profilemenu/model/UserConfigProfileNewFlag;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ProfileNewFlagStoreConfig extends StoreConfig<UserConfigProfileNewFlag> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getAuthRequestContext = 0;
    private static int lookAheadTest = 1;
    private final UserConfigProfileNewFlag content;
    private static char[] MyBillsEntityDataFactory = {39431, 39547, 39546, 39426, 39425, 39427, 39435, 39549, 39429, 39544, 39433, 39539};
    private static boolean BuiltInFictitiousFunctionClassFactory = true;
    private static boolean PlaceComponentResult = true;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 909155304;

    @JvmName(name = "getContent")
    public final UserConfigProfileNewFlag getContent() {
        try {
            int i = lookAheadTest + 17;
            getAuthRequestContext = i % 128;
            if ((i % 2 != 0 ? 'W' : ';') != 'W') {
                return this.content;
            }
            UserConfigProfileNewFlag userConfigProfileNewFlag = this.content;
            Object obj = null;
            obj.hashCode();
            return userConfigProfileNewFlag;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ProfileNewFlagStoreConfig(id.dana.domain.profilemenu.model.UserConfigProfileNewFlag r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = android.view.ViewConfiguration.getTapTimeout()
            int r0 = r0 >> 16
            int r0 = r0 + 127
            r1 = 18
            byte[] r1 = new byte[r1]
            r1 = {x002c: FILL_ARRAY_DATA , data: [-116, -119, -125, -121, -119, -122, -117, -118, -121, -119, -120, -121, -122, -123, -124, -125, -126, -127} // fill-array
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            a(r0, r1, r3, r3, r2)
            r0 = 0
            r0 = r2[r0]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            java.lang.String r1 = "config_me_page_new_flag"
            r4.<init>(r1, r0, r5)
            r4.content = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.profilemenu.model.ProfileNewFlagStoreConfig.<init>(id.dana.domain.profilemenu.model.UserConfigProfileNewFlag):void");
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = MyBillsEntityDataFactory;
        if (cArr2 != null) {
            int i2 = $10 + 105;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                int i5 = $11 + 91;
                $10 = i5 % 128;
                if ((i5 % 2 != 0 ? 'G' : '[') != '[') {
                    cArr3[i4] = (char) (cArr2[i4] ^ 4571606982258105150L);
                    i4 *= 1;
                } else {
                    cArr3[i4] = (char) (cArr2[i4] ^ 4571606982258105150L);
                    i4++;
                }
            }
            cArr2 = cArr3;
        }
        int i6 = (int) (4571606982258105150L ^ KClassImpl$Data$declaredNonStaticMembers$2);
        if (PlaceComponentResult) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                int i7 = $11 + 53;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                try {
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i6);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
            String str = new String(cArr4);
            int i9 = $11 + 29;
            $10 = i9 % 128;
            if (i9 % 2 == 0) {
                objArr[0] = str;
                return;
            }
            Object obj = null;
            obj.hashCode();
            objArr[0] = str;
            return;
        }
        if (!(BuiltInFictitiousFunctionClassFactory)) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
            return;
        }
        try {
            int i10 = $10 + 67;
            $11 = i10 % 128;
            int i11 = i10 % 2;
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr6);
        } catch (Exception e2) {
            throw e2;
        }
    }
}

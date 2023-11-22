package id.dana.data.userconfig.model;

import id.dana.domain.userconfig.model.StoreConfig;
import kotlin.Metadata;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/userconfig/model/SecureRecentRecipientStoreConfig;", "Lid/dana/domain/userconfig/model/StoreConfig;", "", "Lid/dana/data/userconfig/model/UserConfigRecentRecipientEntity;", "content", "<init>", "([Lid/dana/data/userconfig/model/UserConfigRecentRecipientEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SecureRecentRecipientStoreConfig extends StoreConfig<UserConfigRecentRecipientEntity[]> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] MyBillsEntityDataFactory = {39611, 39610, 39614, 39597, 39594, 39599, 39488, 39596, 39612, 39603, 39606, 39600};
    private static boolean getAuthRequestContext = true;
    private static boolean BuiltInFictitiousFunctionClassFactory = true;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 909154849;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SecureRecentRecipientStoreConfig(id.dana.data.userconfig.model.UserConfigRecentRecipientEntity[] r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = android.view.ViewConfiguration.getTouchSlop()
            int r0 = r0 >> 8
            int r0 = 127 - r0
            r1 = 33
            byte[] r1 = new byte[r1]
            r1 = {x002a: FILL_ARRAY_DATA , data: [-118, -116, -117, -124, -119, -125, -120, -118, -125, -122, -124, -121, -124, -118, -126, -119, -126, -122, -121, -126, -122, -123, -119, -126, -120, -121, -126, -122, -123, -124, -125, -126, -127} // fill-array
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            a(r0, r1, r3, r3, r2)
            r0 = 0
            r0 = r2[r0]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            java.lang.String r1 = "config_secure_recent_transaction"
            r4.<init>(r1, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.userconfig.model.SecureRecentRecipientStoreConfig.<init>(id.dana.data.userconfig.model.UserConfigRecentRecipientEntity[]):void");
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = MyBillsEntityDataFactory;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    cArr3[i3] = (char) (cArr2[i3] ^ 4571606982258105150L);
                } catch (Exception e) {
                    throw e;
                }
            }
            cArr2 = cArr3;
        }
        int i4 = (int) (4571606982258105150L ^ KClassImpl$Data$declaredNonStaticMembers$2);
        if ((BuiltInFictitiousFunctionClassFactory ? (char) 27 : 'D') != 'D') {
            int i5 = $10 + 121;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (true) {
                if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? 'A' : 'O') == 'O') {
                    objArr[0] = new String(cArr4);
                    return;
                } else {
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i4);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
            }
        } else if (getAuthRequestContext) {
            try {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr5);
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (true) {
                if (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >= bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    objArr[0] = new String(cArr6);
                    return;
                }
                int i7 = $10 + 75;
                $11 = i7 % 128;
                if ((i7 % 2 == 0 ? (char) 4 : (char) 24) != 4) {
                    cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                    i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                } else {
                    cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult + 1) << bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] >>> i] >>> i4);
                    i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory / 0;
                }
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
            }
        }
    }
}

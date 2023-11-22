package com.alibaba.griver.base.common.network;

import com.alibaba.griver.api.common.network.GriverTransportExtension;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

/* loaded from: classes6.dex */
public class GriverURLTransport implements GriverTransportExtension {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int lookAheadTest = 1;

    /* renamed from: a  reason: collision with root package name */
    private Boolean f6298a = null;
    private static char[] MyBillsEntityDataFactory = {39446, 39449, 39463, 39486, 39477};
    private static boolean getAuthRequestContext = true;
    private static boolean BuiltInFictitiousFunctionClassFactory = true;
    private static int PlaceComponentResult = 909155309;

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a6, code lost:
    
        if (r7 <= 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b6, code lost:
    
        if ((r7 <= 0 ? '.' : 'I') != 'I') goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b8, code lost:
    
        r7 = 60000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01d3, code lost:
    
        if ((r12.length > 0) != false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d9, code lost:
    
        if (r12.length > 0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01db, code lost:
    
        r2.write(r12);
     */
    @Override // com.alibaba.griver.api.common.network.GriverTransportExtension
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.griver.api.common.network.HttpResponse request(com.alibaba.griver.api.common.network.HttpRequest r12) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 633
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.network.GriverURLTransport.request(com.alibaba.griver.api.common.network.HttpRequest):com.alibaba.griver.api.common.network.HttpResponse");
    }

    private static void b(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        int i3;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        try {
            char[] cArr2 = MyBillsEntityDataFactory;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i4 = 0;
                while (i4 < length) {
                    int i5 = $11 + 3;
                    $10 = i5 % 128;
                    if (i5 % 2 != 0) {
                        cArr3[i4] = (char) (cArr2[i4] / 4571606982258105150L);
                        i4 >>>= 0;
                    } else {
                        cArr3[i4] = (char) (cArr2[i4] ^ 4571606982258105150L);
                        i4++;
                    }
                }
                cArr2 = cArr3;
            }
            int i6 = (int) (4571606982258105150L ^ PlaceComponentResult);
            if (!(!BuiltInFictitiousFunctionClassFactory)) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    int i7 = $11 + 21;
                    $10 = i7 % 128;
                    if (i7 % 2 != 0) {
                        cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult / 1) >> bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] >> i] % i6);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory << 1;
                    } else {
                        cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i6);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                    }
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
                }
                objArr[0] = new String(cArr4);
                return;
            }
            if ((getAuthRequestContext ? (char) 7 : '?') != 7) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if (!(bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult)) {
                        objArr[0] = new String(cArr5);
                        return;
                    }
                    int i8 = $10 + 21;
                    $11 = i8 % 128;
                    if (i8 % 2 == 0) {
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 0) >>> bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] % i] + i6);
                        i3 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory / 0;
                    } else {
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                        i3 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                    }
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i3;
                }
            } else {
                int i9 = $10 + 55;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    try {
                        if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? '2' : (char) 20) != '2') {
                            objArr[0] = new String(cArr6);
                            return;
                        }
                        int i11 = $10 + 55;
                        $11 = i11 % 128;
                        if (!(i11 % 2 == 0)) {
                            cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                        } else {
                            cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 0) * bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] >> i] - i6);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory -= 0;
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}

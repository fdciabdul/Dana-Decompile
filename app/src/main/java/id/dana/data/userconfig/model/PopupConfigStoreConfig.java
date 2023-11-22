package id.dana.data.userconfig.model;

import id.dana.domain.userconfig.model.StoreConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/userconfig/model/PopupConfigStoreConfig;", "Lid/dana/domain/userconfig/model/StoreConfig;", "Lid/dana/data/userconfig/model/PopupUserConfig;", "content", "Lid/dana/data/userconfig/model/PopupUserConfig;", "getContent", "()Lid/dana/data/userconfig/model/PopupUserConfig;", "<init>", "(Lid/dana/data/userconfig/model/PopupUserConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PopupConfigStoreConfig extends StoreConfig<PopupUserConfig> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 42065;
    private static char[] MyBillsEntityDataFactory = {37286, 37288, 37281, 37308, 37292, 37290, 37307, 37283, 37306, 37309, 37280, 37302, 37289, 37311, 37294, 37264};
    private static int PlaceComponentResult;
    private final PopupUserConfig content;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PopupConfigStoreConfig(id.dana.data.userconfig.model.PopupUserConfig r12) {
        /*
            r11 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 12
            char[] r1 = new char[r0]
            r1 = {x0058: FILL_ARRAY_DATA , data: [14, 9, 12, 9, 14, 12, 6, 8, 0, 14, 1, 2} // fill-array
            int r2 = android.view.KeyEvent.getModifierMetaStateMask()
            byte r2 = (byte) r2
            int r2 = 97 - r2
            byte r2 = (byte) r2
            r3 = 0
            float r4 = android.util.TypedValue.complexToFloat(r3)
            r5 = 0
            r6 = 25
            r7 = 1
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            int r0 = r0 - r4
            java.lang.Object[] r4 = new java.lang.Object[r7]
            a(r1, r2, r0, r4)
            r0 = r4[r3]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            char[] r1 = new char[r6]
            r1 = {x0068: FILL_ARRAY_DATA , data: [13, 4, 2, 10, 9, 10, 7, 13, 7, 15, 0, 6, 12, 14, 9, 14, 9, 12, 12, 7, 14, 6, 0, 4, 13937} // fill-array
            int r2 = android.view.ViewConfiguration.getJumpTapTimeout()
            int r2 = r2 >> 16
            int r2 = r2 + 116
            byte r2 = (byte) r2
            double r4 = android.telephony.cdma.CdmaCellLocation.convertQuartSecToDecDegrees(r3)
            r8 = 0
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            int r10 = r10 + r6
            java.lang.Object[] r4 = new java.lang.Object[r7]
            a(r1, r2, r10, r4)
            r1 = r4[r3]
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = r1.intern()
            r11.<init>(r0, r1, r12)
            r11.content = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.userconfig.model.PopupConfigStoreConfig.<init>(id.dana.data.userconfig.model.PopupUserConfig):void");
    }

    @JvmName(name = "getContent")
    public final PopupUserConfig getContent() {
        int i = PlaceComponentResult + 25;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? '0' : '_') == '_') {
            try {
                return this.content;
            } catch (Exception e) {
                throw e;
            }
        }
        PopupUserConfig popupUserConfig = this.content;
        Object obj = null;
        obj.hashCode();
        return popupUserConfig;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0081, code lost:
    
        if ((r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) != true) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = r0.MyBillsEntityDataFactory / r2;
        r0.scheduleImpl = r0.MyBillsEntityDataFactory % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = r0.PlaceComponentResult / r2;
        r0.lookAheadTest = r0.PlaceComponentResult % r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009d, code lost:
    
        if (r0.scheduleImpl != r0.lookAheadTest) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
    
        r7 = '\\';
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a2, code lost:
    
        r7 = '[';
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a4, code lost:
    
        if (r7 == '[') goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a6, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = ((r0.BuiltInFictitiousFunctionClassFactory + r2) - 1) % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = ((r0.KClassImpl$Data$declaredNonStaticMembers$2 + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d4, code lost:
    
        if (r0.BuiltInFictitiousFunctionClassFactory != r0.KClassImpl$Data$declaredNonStaticMembers$2) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d6, code lost:
    
        r0.scheduleImpl = ((r0.scheduleImpl + r2) - 1) % r2;
        r0.lookAheadTest = ((r0.lookAheadTest + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0100, code lost:
    
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.lookAheadTest;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.scheduleImpl;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x011c, code lost:
    
        r3[r0.getAuthRequestContext] = (char) (r0.MyBillsEntityDataFactory - r11);
        r3[r0.getAuthRequestContext + 1] = (char) (r0.PlaceComponentResult - r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x012d, code lost:
    
        r0.getAuthRequestContext += 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x014e, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x014f, code lost:
    
        throw r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(char[] r10, byte r11, int r12, java.lang.Object[] r13) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.userconfig.model.PopupConfigStoreConfig.a(char[], byte, int, java.lang.Object[]):void");
    }
}

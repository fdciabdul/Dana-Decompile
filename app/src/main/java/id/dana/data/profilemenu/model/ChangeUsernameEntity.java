package id.dana.data.profilemenu.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004"}, d2 = {"Lid/dana/data/profilemenu/model/ChangeUsernameEntity;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "title", "action", "enable", "copy", "(Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/data/profilemenu/model/ChangeUsernameEntity;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lid/dana/data/profilemenu/model/SettingEntity;", "toSettingEntity", "()Lid/dana/data/profilemenu/model/SettingEntity;", "toString", "Ljava/lang/String;", "getAction", "Z", "getEnable", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ChangeUsernameEntity implements Serializable {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 42065;
    private static char[] MyBillsEntityDataFactory = {37308, 37264, 37311, 37286, 37306, 37305, 37292, 37282, 37288, 37281, 37294, 37307, 37310, 37287, 37309, 37290};
    private static int getAuthRequestContext = 1;
    private final String action;
    private final boolean enable;
    private final String title;

    public ChangeUsernameEntity() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ ChangeUsernameEntity copy$default(ChangeUsernameEntity changeUsernameEntity, String str, String str2, boolean z, int i, Object obj) {
        if (!((i & 1) == 0)) {
            try {
                str = changeUsernameEntity.title;
            } catch (Exception e) {
                throw e;
            }
        }
        if ((i & 2) != 0) {
            str2 = changeUsernameEntity.action;
        }
        if (((i & 4) != 0 ? '\'' : 'X') == '\'') {
            int i2 = getAuthRequestContext + 61;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            if (i2 % 2 != 0) {
                z = changeUsernameEntity.enable;
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                z = changeUsernameEntity.enable;
            }
        }
        ChangeUsernameEntity copy = changeUsernameEntity.copy(str, str2, z);
        int i3 = getAuthRequestContext + 63;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return copy;
    }

    public final String component1() {
        int i = BuiltInFictitiousFunctionClassFactory + 3;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
            return this.title;
        }
        String str = this.title;
        Object obj = null;
        obj.hashCode();
        return str;
    }

    public final String component2() {
        int i = getAuthRequestContext + 113;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        String str = this.action;
        int i3 = BuiltInFictitiousFunctionClassFactory + 51;
        getAuthRequestContext = i3 % 128;
        if ((i3 % 2 == 0 ? '-' : ':') != '-') {
            return str;
        }
        Object obj = null;
        obj.hashCode();
        return str;
    }

    public final boolean component3() {
        int i = BuiltInFictitiousFunctionClassFactory + 27;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        boolean z = this.enable;
        int i3 = getAuthRequestContext + 119;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return z;
    }

    public final ChangeUsernameEntity copy(String title, String action, boolean enable) {
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(action, "");
        ChangeUsernameEntity changeUsernameEntity = new ChangeUsernameEntity(title, action, enable);
        int i = getAuthRequestContext + 51;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (i % 2 != 0) {
            int i2 = 27 / 0;
            return changeUsernameEntity;
        }
        return changeUsernameEntity;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            int i = BuiltInFictitiousFunctionClassFactory + 79;
            getAuthRequestContext = i % 128;
            if (i % 2 == 0) {
                Object obj = null;
                obj.hashCode();
                return true;
            }
            return true;
        } else if (other instanceof ChangeUsernameEntity) {
            ChangeUsernameEntity changeUsernameEntity = (ChangeUsernameEntity) other;
            if ((!Intrinsics.areEqual(this.title, changeUsernameEntity.title) ? 'F' : (char) 11) == 'F') {
                int i2 = getAuthRequestContext + 99;
                BuiltInFictitiousFunctionClassFactory = i2 % 128;
                int i3 = i2 % 2;
                return false;
            } else if (Intrinsics.areEqual(this.action, changeUsernameEntity.action)) {
                return this.enable == changeUsernameEntity.enable;
            } else {
                try {
                    int i4 = getAuthRequestContext + 95;
                    BuiltInFictitiousFunctionClassFactory = i4 % 128;
                    return i4 % 2 != 0;
                } catch (Exception e) {
                    throw e;
                }
            }
        } else {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final int hashCode() {
        int hashCode = this.title.hashCode();
        int hashCode2 = this.action.hashCode();
        int i = this.enable;
        if (!(i == 0)) {
            int i2 = getAuthRequestContext + 97;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            i = 1;
        }
        int i4 = (((hashCode * 31) + hashCode2) * 31) + i;
        int i5 = BuiltInFictitiousFunctionClassFactory + 85;
        getAuthRequestContext = i5 % 128;
        int i6 = i5 % 2;
        return i4;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChangeUsernameEntity(title=");
        sb.append(this.title);
        sb.append(", action=");
        sb.append(this.action);
        sb.append(", enable=");
        sb.append(this.enable);
        sb.append(')');
        String obj = sb.toString();
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 51;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    public ChangeUsernameEntity(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.title = str;
        this.action = str2;
        this.enable = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ChangeUsernameEntity(java.lang.String r5, java.lang.String r6, boolean r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r4 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L10
            int r5 = id.dana.data.profilemenu.model.ChangeUsernameEntity.BuiltInFictitiousFunctionClassFactory
            int r5 = r5 + 15
            int r9 = r5 % 128
            id.dana.data.profilemenu.model.ChangeUsernameEntity.getAuthRequestContext = r9
            int r5 = r5 % 2
            java.lang.String r5 = "Username"
        L10:
            r9 = r8 & 2
            r0 = 0
            r1 = 1
            if (r9 == 0) goto L18
            r9 = 0
            goto L19
        L18:
            r9 = 1
        L19:
            if (r9 == r1) goto L4b
            r6 = 23
            char[] r9 = new char[r6]
            r9 = {x0072: FILL_ARRAY_DATA , data: [3, 12, 13931, 13931, 1, 11, 9, 0, 8, 4, 12, 15, 10, 11, 11, 3, 2, 5, 14, 9, 10, 9, 13948} // fill-array
            r2 = 48
            java.lang.String r3 = ""
            int r2 = android.text.TextUtils.lastIndexOf(r3, r2, r0, r0)
            int r2 = 124 - r2
            byte r2 = (byte) r2
            int r3 = android.view.ViewConfiguration.getLongPressTimeout()
            int r3 = r3 >> 16
            int r3 = r3 + r6
            java.lang.Object[] r6 = new java.lang.Object[r1]
            a(r9, r2, r3, r6)
            r6 = r6[r0]
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r6 = r6.intern()
            int r9 = id.dana.data.profilemenu.model.ChangeUsernameEntity.getAuthRequestContext
            int r9 = r9 + 95
            int r2 = r9 % 128
            id.dana.data.profilemenu.model.ChangeUsernameEntity.BuiltInFictitiousFunctionClassFactory = r2
            int r9 = r9 % 2
        L4b:
            r8 = r8 & 4
            r9 = 22
            if (r8 == 0) goto L54
            r8 = 22
            goto L56
        L54:
            r8 = 71
        L56:
            if (r8 == r9) goto L59
            goto L6d
        L59:
            int r7 = id.dana.data.profilemenu.model.ChangeUsernameEntity.BuiltInFictitiousFunctionClassFactory
            int r7 = r7 + 49
            int r8 = r7 % 128
            id.dana.data.profilemenu.model.ChangeUsernameEntity.getAuthRequestContext = r8
            int r7 = r7 % 2
            if (r7 != 0) goto L67
            r7 = 1
            goto L68
        L67:
            r7 = 0
        L68:
            if (r7 == 0) goto L6c
            r7 = 1
            goto L6d
        L6c:
            r7 = 0
        L6d:
            r4.<init>(r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.profilemenu.model.ChangeUsernameEntity.<init>(java.lang.String, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        try {
            int i = getAuthRequestContext + 123;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (!(i % 2 == 0)) {
                String str = this.title;
                Object obj = null;
                obj.hashCode();
                return str;
            }
            return this.title;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getAction")
    public final String getAction() {
        int i = BuiltInFictitiousFunctionClassFactory + 111;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        String str = this.action;
        int i3 = getAuthRequestContext + 61;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        int i = getAuthRequestContext + 19;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        boolean z = this.enable;
        int i3 = BuiltInFictitiousFunctionClassFactory + 115;
        getAuthRequestContext = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 17 : (char) 28) != 28) {
            Object[] objArr = null;
            int length = objArr.length;
            return z;
        }
        return z;
    }

    public final SettingEntity toSettingEntity() {
        SettingEntity settingEntity = new SettingEntity();
        settingEntity.setTitle(this.title);
        settingEntity.setAction(this.action);
        settingEntity.setEnable(this.enable);
        int i = BuiltInFictitiousFunctionClassFactory + 41;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? 'W' : (char) 21) != 'W') {
            return settingEntity;
        }
        Object obj = null;
        obj.hashCode();
        return settingEntity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008a, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008c, code lost:
    
        r3[r0.getAuthRequestContext] = (char) (r0.MyBillsEntityDataFactory - r11);
        r3[r0.getAuthRequestContext + 1] = (char) (r0.PlaceComponentResult - r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009f, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = r0.MyBillsEntityDataFactory / r2;
        r0.scheduleImpl = r0.MyBillsEntityDataFactory % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = r0.PlaceComponentResult / r2;
        r0.lookAheadTest = r0.PlaceComponentResult % r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b9, code lost:
    
        if (r0.scheduleImpl != r0.lookAheadTest) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bb, code lost:
    
        r7 = 'O';
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00be, code lost:
    
        r7 = 'G';
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c0, code lost:
    
        if (r7 == 'O') goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c6, code lost:
    
        if (r0.BuiltInFictitiousFunctionClassFactory != r0.KClassImpl$Data$declaredNonStaticMembers$2) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ca, code lost:
    
        r7 = id.dana.data.profilemenu.model.ChangeUsernameEntity.$10 + 119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ce, code lost:
    
        id.dana.data.profilemenu.model.ChangeUsernameEntity.$11 = r7 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d0, code lost:
    
        r7 = r7 % 2;
        r0.scheduleImpl = ((r0.scheduleImpl + r2) - 1) % r2;
        r0.lookAheadTest = ((r0.lookAheadTest + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00fc, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00fd, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00fe, code lost:
    
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.lookAheadTest;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.scheduleImpl;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x011a, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x011b, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x011c, code lost:
    
        r7 = id.dana.data.profilemenu.model.ChangeUsernameEntity.$11 + 99;
        id.dana.data.profilemenu.model.ChangeUsernameEntity.$10 = r7 % 128;
        r7 = r7 % 2;
        r0.BuiltInFictitiousFunctionClassFactory = ((r0.BuiltInFictitiousFunctionClassFactory + r2) - 1) % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = ((r0.KClassImpl$Data$declaredNonStaticMembers$2 + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(char[] r10, byte r11, int r12, java.lang.Object[] r13) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.profilemenu.model.ChangeUsernameEntity.a(char[], byte, int, java.lang.Object[]):void");
    }
}

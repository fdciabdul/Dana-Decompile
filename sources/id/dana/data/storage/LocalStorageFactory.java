package id.dana.data.storage;

import android.content.Context;
import id.dana.data.AbstractEntityDataFactory;
import o.whenAvailable;

/* loaded from: classes2.dex */
public class LocalStorageFactory extends AbstractEntityDataFactory<PreferenceFacade> {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final String DEFAULT_PREFERENCE = "6CC59C4231550";
    public static final String KEY_SECURED = "secured";
    private static int MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 1;
    private final Builder builder;
    private static char[] getAuthRequestContext = {24121, 16194, 40179, 31352, 56204, 47362, 5808, 63432, 21885, 13048, 36989, 29060, 53028, 44199, 3555, 60250, 18670, 9752, 34706, 25916, 49833, 41950};
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = -604715713141304797L;

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public /* synthetic */ PreferenceFacade createData2(String str) {
        int i = MyBillsEntityDataFactory + 33;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            try {
                return createData2(str);
            } catch (Exception e) {
                throw e;
            }
        }
        PreferenceFacade createData2 = createData2(str);
        Object obj = null;
        obj.hashCode();
        return createData2;
    }

    public LocalStorageFactory(Builder builder) {
        this.builder = builder;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005e, code lost:
    
        if ((r6.builder.useDrutherPreference) != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
    
        if ((!r0) != true) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
    
        if (r7 == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
    
        r7 = id.dana.data.storage.LocalStorageFactory.MyBillsEntityDataFactory + 69;
        id.dana.data.storage.LocalStorageFactory.PlaceComponentResult = r7 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007e, code lost:
    
        if ((r7 % 2) != 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0080, code lost:
    
        r7 = r6.builder.buildSecurityGuardPreference();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0086, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0087, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0090, code lost:
    
        return r6.builder.buildSecurityGuardPreference();
     */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public id.dana.data.storage.PreferenceFacade createData2(java.lang.String r7) {
        /*
            r6 = this;
            com.iap.ac.config.lite.ConfigCenter r7 = com.iap.ac.config.lite.ConfigCenter.getInstance()
            java.lang.String r0 = ""
            int r1 = android.view.KeyEvent.keyCodeFromString(r0)
            r2 = 0
            int r3 = android.text.TextUtils.getOffsetAfter(r0, r2)
            int r3 = 22 - r3
            r4 = 44291(0xad03, float:6.2065E-41)
            r5 = 48
            int r0 = android.text.TextUtils.lastIndexOf(r0, r5, r2, r2)
            int r4 = r4 - r0
            char r0 = (char) r4
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            a(r1, r3, r0, r5)
            r0 = r5[r2]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            boolean r7 = r7.getBoolConfig(r0, r4)
            id.dana.data.storage.LocalStorageFactory$Builder r0 = r6.builder
            java.lang.String r0 = r0.password
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 57
            if (r0 != 0) goto L3d
            r0 = 51
            goto L3f
        L3d:
            r0 = 57
        L3f:
            r3 = 0
            if (r0 == r1) goto L93
            int r0 = id.dana.data.storage.LocalStorageFactory.PlaceComponentResult
            int r0 = r0 + 89
            int r1 = r0 % 128
            id.dana.data.storage.LocalStorageFactory.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L50
            r0 = 0
            goto L51
        L50:
            r0 = 1
        L51:
            if (r0 == 0) goto L61
            id.dana.data.storage.LocalStorageFactory$Builder r0 = r6.builder
            boolean r0 = id.dana.data.storage.LocalStorageFactory.Builder.access$000(r0)
            if (r0 != 0) goto L5d
            r0 = 0
            goto L5e
        L5d:
            r0 = 1
        L5e:
            if (r0 == 0) goto L72
            goto L93
        L61:
            id.dana.data.storage.LocalStorageFactory$Builder r0 = r6.builder
            boolean r0 = id.dana.data.storage.LocalStorageFactory.Builder.access$000(r0)
            r3.hashCode()     // Catch: java.lang.Throwable -> L91
            if (r0 != 0) goto L6e
            r0 = 1
            goto L6f
        L6e:
            r0 = 0
        L6f:
            if (r0 == r4) goto L72
            goto L93
        L72:
            if (r7 == 0) goto L93
            int r7 = id.dana.data.storage.LocalStorageFactory.MyBillsEntityDataFactory
            int r7 = r7 + 69
            int r0 = r7 % 128
            id.dana.data.storage.LocalStorageFactory.PlaceComponentResult = r0
            int r7 = r7 % 2
            if (r7 != 0) goto L8a
            id.dana.data.storage.LocalStorageFactory$Builder r7 = r6.builder
            id.dana.data.storage.SecurityGuardPreference r7 = r7.buildSecurityGuardPreference()
            int r0 = r3.length     // Catch: java.lang.Throwable -> L88
            return r7
        L88:
            r7 = move-exception
            throw r7
        L8a:
            id.dana.data.storage.LocalStorageFactory$Builder r7 = r6.builder
            id.dana.data.storage.SecurityGuardPreference r7 = r7.buildSecurityGuardPreference()
            return r7
        L91:
            r7 = move-exception
            throw r7
        L93:
            id.dana.data.storage.LocalStorageFactory$Builder r7 = r6.builder
            id.dana.data.storage.Druther r7 = r7.buildDruther()
            int r0 = id.dana.data.storage.LocalStorageFactory.MyBillsEntityDataFactory
            int r0 = r0 + 125
            int r1 = r0 % 128
            id.dana.data.storage.LocalStorageFactory.PlaceComponentResult = r1
            int r0 = r0 % 2
            if (r0 != 0) goto La6
            goto La7
        La6:
            r2 = 1
        La7:
            if (r2 == 0) goto Laa
            return r7
        Laa:
            r3.hashCode()     // Catch: java.lang.Throwable -> Lae
            return r7
        Lae:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.storage.LocalStorageFactory.createData2(java.lang.String):id.dana.data.storage.PreferenceFacade");
    }

    public PreferenceFacade createSecurityGuardData() {
        SecurityGuardPreference buildSecurityGuardPreference;
        try {
            int i = MyBillsEntityDataFactory + 25;
            try {
                PlaceComponentResult = i % 128;
                if ((i % 2 == 0 ? '\r' : '5') != '5') {
                    buildSecurityGuardPreference = this.builder.buildSecurityGuardPreference();
                    Object obj = null;
                    obj.hashCode();
                } else {
                    buildSecurityGuardPreference = this.builder.buildSecurityGuardPreference();
                }
                int i2 = PlaceComponentResult + 25;
                MyBillsEntityDataFactory = i2 % 128;
                if (!(i2 % 2 == 0)) {
                    int i3 = 56 / 0;
                    return buildSecurityGuardPreference;
                }
                return buildSecurityGuardPreference;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        protected Context context;
        protected String preferenceGroup;
        protected SerializerFacade serializerFacade;
        protected String password = "";
        private boolean useDrutherPreference = false;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setPreferenceGroup(String str) {
            this.preferenceGroup = str;
            return this;
        }

        public Builder setSerializerFacade(SerializerFacade serializerFacade) {
            this.serializerFacade = serializerFacade;
            return this;
        }

        public Builder setPassword(String str) {
            this.password = str;
            return this;
        }

        public Builder setUseDrutherPreference(boolean z) {
            this.useDrutherPreference = z;
            return this;
        }

        public Druther buildDruther() {
            return new Druther(implementDefaultValue());
        }

        private Builder implementDefaultValue() {
            if (this.serializerFacade == null) {
                this.serializerFacade = new Serializer();
            }
            if (this.preferenceGroup == null) {
                this.preferenceGroup = "6CC59C4231550";
            }
            return this;
        }

        public SecurityGuardPreference buildSecurityGuardPreference() {
            return new SecurityGuardPreference(implementDefaultValue());
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        int i3 = $10 + 105;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (true) {
            if (whenavailable.BuiltInFictitiousFunctionClassFactory >= i2) {
                break;
            }
            try {
                int i5 = $11 + 15;
                try {
                    $10 = i5 % 128;
                    int i6 = i5 % 2;
                    jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (getAuthRequestContext[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ KClassImpl$Data$declaredNonStaticMembers$2))) ^ c;
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
            int i7 = $10 + 77;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        objArr[0] = new String(cArr);
    }
}

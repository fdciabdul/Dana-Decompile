package id.dana.data.services.repository.source.model;

import id.dana.cashier.view.InputCardNumberView;
import id.dana.domain.userconfig.model.StoreConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.whenAvailable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00172\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0017B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005"}, d2 = {"Lid/dana/data/services/repository/source/model/StoreFavoriteServiceConfig;", "Lid/dana/domain/userconfig/model/StoreConfig;", "", "", "component1", "()Ljava/util/List;", "content", "copy", "(Ljava/util/List;)Lid/dana/data/services/repository/source/model/StoreFavoriteServiceConfig;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getContent", "<init>", "(Ljava/util/List;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class StoreFavoriteServiceConfig extends StoreConfig<List<? extends String>> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static long PlaceComponentResult = 0;
    public static final String SYNC_KEY = "feature_favorite_services";
    private static int getAuthRequestContext;
    private final List<String> content;

    static {
        try {
            KClassImpl$Data$declaredNonStaticMembers$2();
            try {
                INSTANCE = new Companion(null);
                int i = getAuthRequestContext + 33;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{64929, 8967, 16620, 26204, 34598, 42124, 51836, 60187, 2185, 11883, 20419, 27839, 37385, 46031, 53429, 62985, 6088, 13633, 23096, 31626, 39253, 48679, 57226, 64881, 8908};
        PlaceComponentResult = -6336208259455635989L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if (((r4 | 1) != 0 ? '#' : 'X') != '#') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        if ((r4 & 1) != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        r3 = id.dana.data.services.repository.source.model.StoreFavoriteServiceConfig.BuiltInFictitiousFunctionClassFactory + 35;
        id.dana.data.services.repository.source.model.StoreFavoriteServiceConfig.getAuthRequestContext = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if ((r3 % 2) == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r3 = r2.content;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        r4 = 11 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        r3 = r2.content;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        return r2.copy(r3);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ id.dana.data.services.repository.source.model.StoreFavoriteServiceConfig copy$default(id.dana.data.services.repository.source.model.StoreFavoriteServiceConfig r2, java.util.List r3, int r4, java.lang.Object r5) {
        /*
            int r5 = id.dana.data.services.repository.source.model.StoreFavoriteServiceConfig.getAuthRequestContext
            int r5 = r5 + 105
            int r0 = r5 % 128
            id.dana.data.services.repository.source.model.StoreFavoriteServiceConfig.BuiltInFictitiousFunctionClassFactory = r0
            int r5 = r5 % 2
            r0 = 36
            if (r5 != 0) goto L11
            r5 = 69
            goto L13
        L11:
            r5 = 36
        L13:
            r1 = 35
            if (r5 == r0) goto L23
            r4 = r4 | 1
            if (r4 == 0) goto L1e
            r4 = 35
            goto L20
        L1e:
            r4 = 88
        L20:
            if (r4 == r1) goto L27
            goto L3d
        L23:
            r4 = r4 & 1
            if (r4 == 0) goto L3d
        L27:
            int r3 = id.dana.data.services.repository.source.model.StoreFavoriteServiceConfig.BuiltInFictitiousFunctionClassFactory
            int r3 = r3 + r1
            int r4 = r3 % 128
            id.dana.data.services.repository.source.model.StoreFavoriteServiceConfig.getAuthRequestContext = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L3b
            java.util.List<java.lang.String> r3 = r2.content
            r4 = 11
            int r4 = r4 / 0
            goto L3d
        L39:
            r2 = move-exception
            throw r2
        L3b:
            java.util.List<java.lang.String> r3 = r2.content
        L3d:
            id.dana.data.services.repository.source.model.StoreFavoriteServiceConfig r2 = r2.copy(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.source.model.StoreFavoriteServiceConfig.copy$default(id.dana.data.services.repository.source.model.StoreFavoriteServiceConfig, java.util.List, int, java.lang.Object):id.dana.data.services.repository.source.model.StoreFavoriteServiceConfig");
    }

    public final List<String> component1() {
        int i = BuiltInFictitiousFunctionClassFactory + 61;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        List<String> list = this.content;
        try {
            int i3 = getAuthRequestContext + 37;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    public final StoreFavoriteServiceConfig copy(List<String> content) {
        Intrinsics.checkNotNullParameter(content, "");
        StoreFavoriteServiceConfig storeFavoriteServiceConfig = new StoreFavoriteServiceConfig(content);
        try {
            int i = getAuthRequestContext + 3;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                return storeFavoriteServiceConfig;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final boolean equals(Object other) {
        if (this == other) {
            try {
                int i = getAuthRequestContext + 13;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                return true;
            } catch (Exception e) {
                throw e;
            }
        }
        if (other instanceof StoreFavoriteServiceConfig) {
            return !(!Intrinsics.areEqual(this.content, ((StoreFavoriteServiceConfig) other).content));
        }
        int i3 = getAuthRequestContext + 65;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        int i5 = BuiltInFictitiousFunctionClassFactory + 65;
        getAuthRequestContext = i5 % 128;
        if (i5 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int i = getAuthRequestContext + 95;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? Typography.quote : Typography.less) != '<') {
            hashCode = this.content.hashCode();
            obj.hashCode();
        } else {
            hashCode = this.content.hashCode();
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 3;
        getAuthRequestContext = i2 % 128;
        if ((i2 % 2 != 0 ? 'F' : 'O') != 'O') {
            obj.hashCode();
            return hashCode;
        }
        return hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StoreFavoriteServiceConfig(content=");
        sb.append(this.content);
        sb.append(')');
        String obj = sb.toString();
        try {
            int i = getAuthRequestContext + 21;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if ((i % 2 == 0 ? '\'' : 'S') != 'S') {
                int i2 = 59 / 0;
                return obj;
            }
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getContent")
    public final List<String> getContent() {
        try {
            int i = getAuthRequestContext + 109;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            List<String> list = this.content;
            int i3 = getAuthRequestContext + 123;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (i3 % 2 != 0) {
                return list;
            }
            int i4 = 11 / 0;
            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public StoreFavoriteServiceConfig(java.util.List<java.lang.String> r7) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            r1 = 0
            float r2 = android.util.TypedValue.complexToFraction(r1, r0, r0)
            java.lang.String r3 = "config_my_favourite_services"
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            int r2 = android.view.Gravity.getAbsoluteGravity(r1, r1)
            int r2 = r2 + 25
            int r4 = android.view.View.combineMeasuredStates(r1, r1)
            int r4 = 3721 - r4
            char r4 = (char) r4
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            a(r0, r2, r4, r5)
            r0 = r5[r1]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            r6.<init>(r3, r0, r7)
            r6.content = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.source.model.StoreFavoriteServiceConfig.<init>(java.util.List):void");
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        int i3;
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        int i4 = $11 + 119;
        $10 = i4 % 128;
        int i5 = i4 % 2;
        while (true) {
            if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? '=' : '7') != '=') {
                break;
            }
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (KClassImpl$Data$declaredNonStaticMembers$2[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ PlaceComponentResult))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i2];
        try {
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                try {
                    if (!(whenavailable.BuiltInFictitiousFunctionClassFactory >= i2)) {
                        int i6 = $10 + 75;
                        $11 = i6 % 128;
                        if ((i6 % 2 == 0 ? InputCardNumberView.DIVIDER : 'c') != ' ') {
                            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                            i3 = whenavailable.BuiltInFictitiousFunctionClassFactory + 1;
                        } else {
                            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                            i3 = whenavailable.BuiltInFictitiousFunctionClassFactory >> 1;
                        }
                        whenavailable.BuiltInFictitiousFunctionClassFactory = i3;
                    } else {
                        objArr[0] = new String(cArr);
                        return;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}

package id.dana.data.holdlogin.v2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\"\u001a\u0010\u0004\u001a\u00020\u00008\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\" \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u001a\u0010\u000b\u001a\u00020\u00008\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0002\u001a\u0004\b\n\u0010\u0003"}, d2 = {"", "getAuthRequestContext", "J", "()J", "PlaceComponentResult", "", "", "MyBillsEntityDataFactory", "Ljava/util/List;", "()Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConstantsKt {
    private static final long getAuthRequestContext = TimeUnit.SECONDS.toMillis(30);
    private static final long KClassImpl$Data$declaredNonStaticMembers$2 = TimeUnit.SECONDS.toMillis(3);
    private static final List<String> MyBillsEntityDataFactory = CollectionsKt.listOf((Object[]) new String[]{"id.dana.userprod.user.hold.login", "alipayplus.mobilewallet.user.login"});

    @JvmName(name = "getAuthRequestContext")
    public static final long getAuthRequestContext() {
        return getAuthRequestContext;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public static final long BuiltInFictitiousFunctionClassFactory() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public static final List<String> MyBillsEntityDataFactory() {
        return MyBillsEntityDataFactory;
    }
}

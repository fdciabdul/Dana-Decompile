package id.dana.explore.data.globalsearch.source;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Singleton
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/explore/data/globalsearch/source/GlobalSearchPreference;", "", "T", "", "p0", "Ljava/lang/Class;", "p1", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/Object;)Z", "Lid/dana/data/storage/PreferenceFacade;", "getAuthRequestContext", "Lid/dana/data/storage/PreferenceFacade;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GlobalSearchPreference {
    private static final String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final PreferenceFacade KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public GlobalSearchPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        PreferenceFacade createData = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(MyBillsEntityDataFactory).setUseDrutherPreference(true).setSerializerFacade(null)).createData("local");
        Intrinsics.checkNotNullExpressionValue(createData, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = createData;
    }

    public final <T> boolean PlaceComponentResult(String p0, T p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2.saveData(p0, (String) p1);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final <T> T MyBillsEntityDataFactory(String p0, Class<T> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        try {
            return (T) this.KClassImpl$Data$declaredNonStaticMembers$2.getObject(p0, p1);
        } catch (Exception unused) {
            return null;
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        StringBuilder sb = new StringBuilder();
        sb.append(Reflection.getOrCreateKotlinClass(companion.getClass()).getSimpleName());
        sb.append("production");
        MyBillsEntityDataFactory = sb.toString();
    }
}

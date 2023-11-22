package id.dana.data.home.repository.source.local;

import android.content.Context;
import com.google.gson.Gson;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B!\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/home/repository/source/local/DanaProtectionHomeWidgetPreference;", "", "", "getAuthRequestContext", "Ljava/lang/String;", "Lcom/google/gson/Gson;", "PlaceComponentResult", "Lcom/google/gson/Gson;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/storage/PreferenceFacade;", "MyBillsEntityDataFactory", "Lid/dana/data/storage/PreferenceFacade;", "Landroid/content/Context;", "p0", "Lid/dana/data/storage/Serializer;", "p1", "p2", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;Lcom/google/gson/Gson;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaProtectionHomeWidgetPreference {
    public final PreferenceFacade MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private final String getAuthRequestContext;

    @Inject
    public DanaProtectionHomeWidgetPreference(Context context, Serializer serializer, Gson gson) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        Intrinsics.checkNotNullParameter(gson, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.getAuthRequestContext = "DanaProtectionHomeWidgetPreferenceproduction";
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("DanaProtectionHomeWidgetPreferenceproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.MyBillsEntityDataFactory = new SimpleSecureKeyPreference(createData2);
    }
}

package id.dana.data.danaprotection.repository.source.local;

import android.content.Context;
import com.google.gson.Gson;
import id.dana.data.danaprotection.repository.source.network.result.DanaProtectionInfoResult;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.domain.danaprotection.model.DanaProtectionWidgetConfig;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB!\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\bJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0014\u0010\f\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014"}, d2 = {"Lid/dana/data/danaprotection/repository/source/local/DanaProtectionInfoPreference;", "", "Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;", "Lid/dana/data/danaprotection/repository/source/network/result/DanaProtectionInfoResult;", "p0", "", "(Lid/dana/data/danaprotection/repository/source/network/result/DanaProtectionInfoResult;)Z", "", "PlaceComponentResult", "(J)Z", "getAuthRequestContext", "(Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;)Z", "", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/PreferenceFacade;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "p1", "p2", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;Lcom/google/gson/Gson;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaProtectionInfoPreference {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final PreferenceFacade MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final String BuiltInFictitiousFunctionClassFactory;
    final Gson getAuthRequestContext;

    @Inject
    public DanaProtectionInfoPreference(Context context, Serializer serializer, Gson gson) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        Intrinsics.checkNotNullParameter(gson, "");
        this.getAuthRequestContext = gson;
        this.BuiltInFictitiousFunctionClassFactory = "DanaProtectionInfoPreferenceproduction";
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("DanaProtectionInfoPreferenceproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.MyBillsEntityDataFactory = new SimpleSecureKeyPreference(createData2);
    }

    public final boolean getAuthRequestContext(DanaProtectionWidgetConfig p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.saveData("DANA_PROTECTION_WIDGET_CONFIG", this.getAuthRequestContext.toJson(p0, DanaProtectionWidgetConfig.class));
        return true;
    }

    public final DanaProtectionWidgetConfig KClassImpl$Data$declaredNonStaticMembers$2() {
        DanaProtectionWidgetConfig danaProtectionWidgetConfig = (DanaProtectionWidgetConfig) this.getAuthRequestContext.fromJson(this.MyBillsEntityDataFactory.getString("DANA_PROTECTION_WIDGET_CONFIG"), DanaProtectionWidgetConfig.class);
        if (danaProtectionWidgetConfig == null) {
            return new DanaProtectionWidgetConfig(false, false, 0, 7, null);
        }
        Intrinsics.checkNotNullExpressionValue(danaProtectionWidgetConfig, "");
        return danaProtectionWidgetConfig;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(DanaProtectionInfoResult p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.saveData("DANA_PROTECTION_INFO", this.getAuthRequestContext.toJson(p0, DanaProtectionInfoResult.class));
        return true;
    }

    public final boolean PlaceComponentResult(long p0) {
        this.MyBillsEntityDataFactory.saveData("DANA_PROTECTION_INFO_LATEST_FETCH_TIME", Long.valueOf(p0));
        return true;
    }
}

package id.dana.data.installedapp.repository.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.SimpleSecureKeyPreference;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000f"}, d2 = {"Lid/dana/data/installedapp/repository/source/local/InstalledAppPreference;", "", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Z", "getAuthRequestContext", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/PreferenceFacade;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InstalledAppPreference {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final PreferenceFacade MyBillsEntityDataFactory;

    @Inject
    public InstalledAppPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("production");
        this.getAuthRequestContext = sb.toString();
        PreferenceFacade createData = new LocalStorageFactory(new LocalStorageFactory.Builder(this.KClassImpl$Data$declaredNonStaticMembers$2).setPreferenceGroup(this.getAuthRequestContext).setUseDrutherPreference(true)).createData("local");
        Intrinsics.checkNotNullExpressionValue(createData, "");
        this.MyBillsEntityDataFactory = new SimpleSecureKeyPreference(createData);
    }

    public final boolean getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("installed_app_run_v4");
        sb.append(p0);
        preferenceFacade.saveData(sb.toString(), Boolean.TRUE);
        return true;
    }

    public final boolean MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("installed_app_run_v4");
        sb.append(p0);
        Boolean bool = preferenceFacade.getBoolean(sb.toString());
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }
}

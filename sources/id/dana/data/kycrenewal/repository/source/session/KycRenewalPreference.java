package id.dana.data.kycrenewal.repository.source.session;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0019\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\bJ\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\u000bJ\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\f¢\u0006\u0004\b\u0003\u0010\rR\u0014\u0010\u0003\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0014\u0010\n\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013"}, d2 = {"Lid/dana/data/kycrenewal/repository/source/session/KycRenewalPreference;", "", "", "PlaceComponentResult", "()Z", "getAuthRequestContext", "p0", "BuiltInFictitiousFunctionClassFactory", "(Z)Z", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(J)Z", "", "(I)Z", "Landroid/content/Context;", "Landroid/content/Context;", "", "Ljava/lang/String;", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/Serializer;", "p1", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KycRenewalPreference {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final PreferenceFacade getAuthRequestContext;
    private final Context PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final String KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public KycRenewalPreference(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.PlaceComponentResult = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "KycRenewalPreferenceproduction";
        PreferenceFacade createData = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("KycRenewalPreferenceproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData("local");
        Intrinsics.checkNotNullExpressionValue(createData, "");
        this.getAuthRequestContext = createData;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(long p0) {
        this.getAuthRequestContext.saveData("popup_check", Long.valueOf(p0));
        return true;
    }

    public final boolean getAuthRequestContext() {
        Boolean bool = this.getAuthRequestContext.getBoolean("popup_show", false);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    public final boolean getAuthRequestContext(boolean p0) {
        this.getAuthRequestContext.saveData("popup_show", Boolean.valueOf(p0));
        return true;
    }

    public final boolean getAuthRequestContext(long p0) {
        this.getAuthRequestContext.saveData("popup_show_last_time", Long.valueOf(p0));
        return true;
    }

    public final boolean PlaceComponentResult(int p0) {
        this.getAuthRequestContext.saveData("popup_dismiss", Integer.valueOf(p0));
        return true;
    }

    public final boolean PlaceComponentResult() {
        Boolean bool = this.getAuthRequestContext.getBoolean("button_clicked", false);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(boolean p0) {
        this.getAuthRequestContext.saveData("button_clicked", Boolean.valueOf(p0));
        return true;
    }
}

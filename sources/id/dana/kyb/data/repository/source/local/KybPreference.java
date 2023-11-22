package id.dana.kyb.data.repository.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000f\u0012\u0006\u0010\t\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u001d\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0014\u0010\b\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000e"}, d2 = {"Lid/dana/kyb/data/repository/source/local/KybPreference;", "", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Z", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "(Ljava/lang/String;Ljava/lang/String;)Z", "Ljava/lang/String;", "getAuthRequestContext", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/PreferenceFacade;", "Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KybPreference {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final PreferenceFacade KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public KybPreference(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.getAuthRequestContext = "KybPreferenceproduction";
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("KybPreferenceproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = createData2;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PreferenceFacade preferenceFacade = this.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append("kyb_last_transaction_id");
        sb.append(p1);
        preferenceFacade.saveData(sb.toString(), p0);
        return true;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.saveData("kyb_merchant_info", p0);
        return true;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.saveData("kyb_transaction_history", p0);
        return true;
    }

    public final boolean MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.saveData("kyb_banner", p0);
        return true;
    }
}

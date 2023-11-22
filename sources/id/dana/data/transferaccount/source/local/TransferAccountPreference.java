package id.dana.data.transferaccount.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u0003\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/transferaccount/source/local/TransferAccountPreference;", "", "", "PlaceComponentResult", "()Z", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)Z", "MyBillsEntityDataFactory", "Lid/dana/data/storage/PreferenceFacade;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/storage/PreferenceFacade;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "p1", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransferAccountPreference {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final PreferenceFacade PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final String MyBillsEntityDataFactory;

    @Inject
    public TransferAccountPreference(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.MyBillsEntityDataFactory = "TransferAccountPreferenceproduction";
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("TransferAccountPreferenceproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.PlaceComponentResult = new SimpleSecureKeyPreference(createData2);
    }

    public final boolean MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.saveData("transfer_account_token", p0);
        return true;
    }

    public final boolean getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.saveData("transfer_account_status", p0);
        return true;
    }

    public final boolean PlaceComponentResult() {
        this.PlaceComponentResult.clearAllData();
        return true;
    }
}

package id.dana.data.twilio.repository.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011"}, d2 = {"Lid/dana/data/twilio/repository/source/local/TwilioConsultBackendPreferences;", "", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(J)Z", "PlaceComponentResult", "(Z)Z", "", "(Ljava/lang/String;)Z", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/PreferenceFacade;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TwilioConsultBackendPreferences {
    public final PreferenceFacade BuiltInFictitiousFunctionClassFactory;
    private final Context MyBillsEntityDataFactory;

    @Inject
    public TwilioConsultBackendPreferences(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
        PreferenceFacade createData = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("TwilioConsultBackendPreferencesproduction")).createData("local");
        Intrinsics.checkNotNullExpressionValue(createData, "");
        this.BuiltInFictitiousFunctionClassFactory = createData;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(long p0) {
        this.BuiltInFictitiousFunctionClassFactory.saveData("LATEST_DATE_TO_CONSULT_BACKEND", Long.valueOf(p0));
        return true;
    }

    public final boolean PlaceComponentResult(boolean p0) {
        this.BuiltInFictitiousFunctionClassFactory.saveData("IS_REGISTERED_TRUSTED_DEVICE", Boolean.valueOf(p0));
        return true;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        Boolean bool = this.BuiltInFictitiousFunctionClassFactory.getBoolean("IS_REGISTERED_TRUSTED_DEVICE", false);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    public final boolean PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.saveData("LAST_CHALLENGE_SID", p0);
        return true;
    }
}

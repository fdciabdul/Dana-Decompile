package id.dana.data.userpersonalization.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/userpersonalization/source/local/UserPersonalizationPreferences;", "", "Lid/dana/data/storage/PreferenceFacade;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/storage/PreferenceFacade;", "getAuthRequestContext", "Landroid/content/Context;", "p0", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserPersonalizationPreferences {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = "UserPersonalizationPreference production";

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public PreferenceFacade getAuthRequestContext;

    @Inject
    public UserPersonalizationPreferences(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        PreferenceFacade createData = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(KClassImpl$Data$declaredNonStaticMembers$2).setUseDrutherPreference(true).setSerializerFacade(null)).createData("local");
        Intrinsics.checkNotNullExpressionValue(createData, "");
        this.getAuthRequestContext = createData;
    }
}

package id.dana.explore.data.globalsearch.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/explore/data/globalsearch/source/local/PreferenceLocationPermissionSuggestionEntityData;", "", "Lid/dana/data/storage/PreferenceFacade;", "getAuthRequestContext", "Lid/dana/data/storage/PreferenceFacade;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "p0", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreferenceLocationPermissionSuggestionEntityData {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final PreferenceFacade BuiltInFictitiousFunctionClassFactory;

    @Inject
    public PreferenceLocationPermissionSuggestionEntityData(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        PreferenceFacade createData = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("UserEducationPreferenceproduction").setUseDrutherPreference(true)).createData("local");
        Intrinsics.checkNotNullExpressionValue(createData, "");
        this.BuiltInFictitiousFunctionClassFactory = createData;
    }

    public static /* synthetic */ Unit getAuthRequestContext(PreferenceLocationPermissionSuggestionEntityData preferenceLocationPermissionSuggestionEntityData, boolean z) {
        Intrinsics.checkNotNullParameter(preferenceLocationPermissionSuggestionEntityData, "");
        preferenceLocationPermissionSuggestionEntityData.BuiltInFictitiousFunctionClassFactory.saveData("neverSuggestLocationPermissionForGlobalSearch", Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Boolean getAuthRequestContext(PreferenceLocationPermissionSuggestionEntityData preferenceLocationPermissionSuggestionEntityData) {
        Intrinsics.checkNotNullParameter(preferenceLocationPermissionSuggestionEntityData, "");
        return Boolean.valueOf(!preferenceLocationPermissionSuggestionEntityData.BuiltInFictitiousFunctionClassFactory.getBoolean("neverSuggestLocationPermissionForGlobalSearch", false).booleanValue());
    }
}

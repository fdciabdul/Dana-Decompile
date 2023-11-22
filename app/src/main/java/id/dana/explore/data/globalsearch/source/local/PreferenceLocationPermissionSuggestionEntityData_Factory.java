package id.dana.explore.data.globalsearch.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PreferenceLocationPermissionSuggestionEntityData_Factory implements Factory<PreferenceLocationPermissionSuggestionEntityData> {
    private final Provider<Context> getAuthRequestContext;

    private PreferenceLocationPermissionSuggestionEntityData_Factory(Provider<Context> provider) {
        this.getAuthRequestContext = provider;
    }

    public static PreferenceLocationPermissionSuggestionEntityData_Factory PlaceComponentResult(Provider<Context> provider) {
        return new PreferenceLocationPermissionSuggestionEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PreferenceLocationPermissionSuggestionEntityData(this.getAuthRequestContext.get());
    }
}

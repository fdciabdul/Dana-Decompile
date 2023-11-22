package id.dana.scanner.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class ScannerMixpanelTracker_Factory implements Factory<ScannerMixpanelTracker> {
    private final Provider<Context> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ScannerMixpanelTracker(this.getAuthRequestContext.get());
    }
}

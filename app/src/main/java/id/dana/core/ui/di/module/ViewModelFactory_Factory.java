package id.dana.core.ui.di.module;

import androidx.view.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ViewModelFactory_Factory implements Factory<ViewModelFactory> {
    private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ViewModelFactory(this.getAuthRequestContext.get());
    }
}

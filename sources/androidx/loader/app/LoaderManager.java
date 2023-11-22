package androidx.loader.app;

import android.os.Bundle;
import androidx.loader.content.Loader;
import androidx.view.LifecycleOwner;
import androidx.view.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class LoaderManager {

    /* loaded from: classes.dex */
    public interface LoaderCallbacks<D> {
        Loader<D> onCreateLoader(int i, Bundle bundle);

        void onLoadFinished(Loader<D> loader, D d);

        void onLoaderReset(Loader<D> loader);
    }

    @Deprecated
    public abstract void MyBillsEntityDataFactory(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void PlaceComponentResult();

    public abstract <D> Loader<D> getAuthRequestContext(LoaderCallbacks<D> loaderCallbacks);

    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager BuiltInFictitiousFunctionClassFactory(T t) {
        return new LoaderManagerImpl(t, t.getViewModelStore());
    }
}

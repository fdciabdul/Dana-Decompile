package id.dana.di.workerfactory;

import android.text.TextUtils;
import androidx.work.ListenableWorker;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public class CollectionWorkerUtils {
    private CollectionWorkerUtils() {
    }

    public static Provider<ChildWorkerFactory> PlaceComponentResult(Map<Class<? extends ListenableWorker>, Provider<ChildWorkerFactory>> map, String str) {
        for (Map.Entry<Class<? extends ListenableWorker>, Provider<ChildWorkerFactory>> entry : map.entrySet()) {
            if (TextUtils.equals(str, entry.getKey().getName())) {
                return entry.getValue();
            }
        }
        return null;
    }
}

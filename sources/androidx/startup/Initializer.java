package androidx.startup;

import android.content.Context;
import java.util.List;

/* loaded from: classes.dex */
public interface Initializer<T> {
    List<Class<? extends Initializer<?>>> PlaceComponentResult();

    T getAuthRequestContext(Context context);
}

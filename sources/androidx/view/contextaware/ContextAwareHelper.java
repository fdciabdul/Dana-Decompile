package androidx.view.contextaware;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class ContextAwareHelper {
    public volatile Context KClassImpl$Data$declaredNonStaticMembers$2;
    public final Set<OnContextAvailableListener> getAuthRequestContext = new CopyOnWriteArraySet();
}

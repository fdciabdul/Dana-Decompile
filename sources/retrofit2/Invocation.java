package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public final class Invocation {
    final Method KClassImpl$Data$declaredNonStaticMembers$2;
    private final List<?> getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Invocation(Method method, List<?> list) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = method;
        this.getAuthRequestContext = Collections.unmodifiableList(list);
    }

    public final String toString() {
        return String.format("%s.%s() %s", this.KClassImpl$Data$declaredNonStaticMembers$2.getDeclaringClass().getName(), this.KClassImpl$Data$declaredNonStaticMembers$2.getName(), this.getAuthRequestContext);
    }
}

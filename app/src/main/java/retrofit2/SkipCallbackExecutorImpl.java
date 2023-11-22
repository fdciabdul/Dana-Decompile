package retrofit2;

import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import java.lang.annotation.Annotation;

/* loaded from: classes6.dex */
final class SkipCallbackExecutorImpl implements SkipCallbackExecutor {
    private static final SkipCallbackExecutor INSTANCE = new SkipCallbackExecutorImpl();

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return 0;
    }

    SkipCallbackExecutorImpl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Annotation[] ensurePresent(Annotation[] annotationArr) {
        if (Utils.KClassImpl$Data$declaredNonStaticMembers$2(annotationArr, SkipCallbackExecutor.class)) {
            return annotationArr;
        }
        Annotation[] annotationArr2 = new Annotation[annotationArr.length + 1];
        annotationArr2[0] = INSTANCE;
        System.arraycopy(annotationArr, 0, annotationArr2, 1, annotationArr.length);
        return annotationArr2;
    }

    @Override // java.lang.annotation.Annotation
    public final Class<? extends Annotation> annotationType() {
        return SkipCallbackExecutor.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        return obj instanceof SkipCallbackExecutor;
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AUScreenAdaptTool.PREFIX_ID);
        sb.append(SkipCallbackExecutor.class.getName());
        sb.append("()");
        return sb.toString();
    }
}

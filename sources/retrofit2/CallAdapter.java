package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public interface CallAdapter<R, T> {

    /* loaded from: classes2.dex */
    public static abstract class Factory {
        @Nullable
        public abstract CallAdapter<?, ?> KClassImpl$Data$declaredNonStaticMembers$2(Type type, Annotation[] annotationArr);
    }

    T KClassImpl$Data$declaredNonStaticMembers$2(Call<R> call);

    Type getAuthRequestContext();
}

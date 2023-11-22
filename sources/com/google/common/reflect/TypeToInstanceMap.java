package com.google.common.reflect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import javax.annotation.CheckForNull;

@DoNotMock("Use ImmutableTypeToInstanceMap or MutableTypeToInstanceMap")
@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public interface TypeToInstanceMap<B> extends Map<TypeToken<? extends B>, B> {
    @CheckForNull
    <T extends B> T getInstance(TypeToken<T> typeToken);

    @CheckForNull
    <T extends B> T getInstance(Class<T> cls);

    @CheckForNull
    <T extends B> T putInstance(TypeToken<T> typeToken, @ParametricNullness T t);

    @CheckForNull
    <T extends B> T putInstance(Class<T> cls, @ParametricNullness T t);
}

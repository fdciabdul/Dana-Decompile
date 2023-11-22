package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Use Interners.new*Interner")
@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public interface Interner<E> {
    E intern(E e);
}

package com.google.firebase.perf.ktx;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/google/firebase/perf/ktx/FirebasePerfKtxRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "", "Lcom/google/firebase/components/Component;", "getComponents", "()Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class FirebasePerfKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public final List<Component<?>> getComponents() {
        return CollectionsKt.listOf(LibraryVersionComponent.create(PerformanceKt.LIBRARY_NAME, "20.1.1"));
    }
}

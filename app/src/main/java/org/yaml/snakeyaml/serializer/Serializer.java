package org.yaml.snakeyaml.serializer;

import org.yaml.snakeyaml.nodes.NodeId;

/* loaded from: classes9.dex */
public final class Serializer {

    /* renamed from: org.yaml.snakeyaml.serializer.Serializer$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[NodeId.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[NodeId.sequence.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[NodeId.mapping.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[NodeId.scalar.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}

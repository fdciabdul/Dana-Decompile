package com.squareup.wire;

/* loaded from: classes3.dex */
final class Preconditions {
    private Preconditions() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" == null");
        throw new NullPointerException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}

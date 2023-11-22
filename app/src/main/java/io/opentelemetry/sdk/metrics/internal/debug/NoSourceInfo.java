package io.opentelemetry.sdk.metrics.internal.debug;

/* loaded from: classes6.dex */
enum NoSourceInfo implements SourceInfo {
    INSTANCE;

    @Override // io.opentelemetry.sdk.metrics.internal.debug.SourceInfo
    public final String shortDebugString() {
        return "unknown source";
    }

    @Override // io.opentelemetry.sdk.metrics.internal.debug.SourceInfo
    public final String multiLineDebugString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tat unknown source\n\t\t");
        sb.append(DebugConfig.getHowToEnableMessage());
        return sb.toString();
    }
}

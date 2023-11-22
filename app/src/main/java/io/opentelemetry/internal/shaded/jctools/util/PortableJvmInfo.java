package io.opentelemetry.internal.shaded.jctools.util;

/* loaded from: classes9.dex */
public interface PortableJvmInfo {
    public static final int CACHE_LINE_SIZE = Integer.getInteger("jctools.cacheLineSize", 64).intValue();
    public static final int CPUs;
    public static final int RECOMENDED_OFFER_BATCH;
    public static final int RECOMENDED_POLL_BATCH;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPUs = availableProcessors;
        int i = availableProcessors * 4;
        RECOMENDED_OFFER_BATCH = i;
        RECOMENDED_POLL_BATCH = i;
    }
}

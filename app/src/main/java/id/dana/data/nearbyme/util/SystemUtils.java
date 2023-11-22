package id.dana.data.nearbyme.util;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/data/nearbyme/util/SystemUtils;", "", "", "currentTimeMillis", "()J", "", "nextInt", "()I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SystemUtils {
    @Inject
    public SystemUtils() {
    }

    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public final int nextInt() {
        return Random.INSTANCE.nextInt();
    }
}

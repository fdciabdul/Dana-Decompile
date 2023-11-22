package id.dana.data.config.source.split;

import id.dana.domain.version.Version;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/config/source/split/DefaultAppVersionGenerator;", "", "Lid/dana/domain/version/Version;", "generate", "()Lid/dana/domain/version/Version;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultAppVersionGenerator {
    public static final DefaultAppVersionGenerator INSTANCE = new DefaultAppVersionGenerator();

    private DefaultAppVersionGenerator() {
    }

    public final Version generate() {
        return new Version("1", "15", "0", "1", "15", "0");
    }
}

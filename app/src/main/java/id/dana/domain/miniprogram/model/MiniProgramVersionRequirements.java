package id.dana.domain.miniprogram.model;

import id.dana.domain.version.SemanticVersion;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/domain/miniprogram/model/MiniProgramVersionRequirements;", "", "Lid/dana/domain/version/SemanticVersion;", "minAppVersion", "Lid/dana/domain/version/SemanticVersion;", "getMinAppVersion", "()Lid/dana/domain/version/SemanticVersion;", "minOsVersion", "getMinOsVersion", "<init>", "(Lid/dana/domain/version/SemanticVersion;Lid/dana/domain/version/SemanticVersion;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MiniProgramVersionRequirements {
    private final SemanticVersion minAppVersion;
    private final SemanticVersion minOsVersion;

    public MiniProgramVersionRequirements(SemanticVersion semanticVersion, SemanticVersion semanticVersion2) {
        Intrinsics.checkNotNullParameter(semanticVersion, "");
        Intrinsics.checkNotNullParameter(semanticVersion2, "");
        this.minAppVersion = semanticVersion;
        this.minOsVersion = semanticVersion2;
    }

    @JvmName(name = "getMinAppVersion")
    public final SemanticVersion getMinAppVersion() {
        return this.minAppVersion;
    }

    @JvmName(name = "getMinOsVersion")
    public final SemanticVersion getMinOsVersion() {
        return this.minOsVersion;
    }
}

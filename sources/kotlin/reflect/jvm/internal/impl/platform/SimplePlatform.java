package kotlin.reflect.jvm.internal.impl.platform;

/* loaded from: classes.dex */
public abstract class SimplePlatform {
    private final String platformName;
    private final TargetPlatformVersion targetPlatformVersion;

    public String toString() {
        String targetName = getTargetName();
        if (targetName.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.platformName);
            sb.append(" (");
            sb.append(targetName);
            sb.append(')');
            return sb.toString();
        }
        return this.platformName;
    }

    public String getTargetName() {
        return getTargetPlatformVersion().getDescription();
    }

    public TargetPlatformVersion getTargetPlatformVersion() {
        return this.targetPlatformVersion;
    }
}

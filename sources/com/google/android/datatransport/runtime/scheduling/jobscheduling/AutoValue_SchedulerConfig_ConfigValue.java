package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

/* loaded from: classes7.dex */
final class AutoValue_SchedulerConfig_ConfigValue extends SchedulerConfig.ConfigValue {
    private final long delta;
    private final Set<SchedulerConfig.Flag> flags;
    private final long maxAllowedDelay;

    private AutoValue_SchedulerConfig_ConfigValue(long j, long j2, Set<SchedulerConfig.Flag> set) {
        this.delta = j;
        this.maxAllowedDelay = j2;
        this.flags = set;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    final long getDelta() {
        return this.delta;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    final long getMaxAllowedDelay() {
        return this.maxAllowedDelay;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    final Set<SchedulerConfig.Flag> getFlags() {
        return this.flags;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConfigValue{delta=");
        sb.append(this.delta);
        sb.append(", maxAllowedDelay=");
        sb.append(this.maxAllowedDelay);
        sb.append(", flags=");
        sb.append(this.flags);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SchedulerConfig.ConfigValue) {
            SchedulerConfig.ConfigValue configValue = (SchedulerConfig.ConfigValue) obj;
            return this.delta == configValue.getDelta() && this.maxAllowedDelay == configValue.getMaxAllowedDelay() && this.flags.equals(configValue.getFlags());
        }
        return false;
    }

    public final int hashCode() {
        long j = this.delta;
        long j2 = this.maxAllowedDelay;
        return ((((int) (j2 ^ (j2 >>> 32))) ^ ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003)) * 1000003) ^ this.flags.hashCode();
    }

    /* loaded from: classes7.dex */
    static final class Builder extends SchedulerConfig.ConfigValue.Builder {
        private Long delta;
        private Set<SchedulerConfig.Flag> flags;
        private Long maxAllowedDelay;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public final SchedulerConfig.ConfigValue.Builder setDelta(long j) {
            this.delta = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public final SchedulerConfig.ConfigValue.Builder setMaxAllowedDelay(long j) {
            this.maxAllowedDelay = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public final SchedulerConfig.ConfigValue.Builder setFlags(Set<SchedulerConfig.Flag> set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.flags = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public final SchedulerConfig.ConfigValue build() {
            String str;
            if (this.delta == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" delta");
                str = sb.toString();
            } else {
                str = "";
            }
            if (this.maxAllowedDelay == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" maxAllowedDelay");
                str = sb2.toString();
            }
            if (this.flags == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" flags");
                str = sb3.toString();
            }
            if (!str.isEmpty()) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Missing required properties:");
                sb4.append(str);
                throw new IllegalStateException(sb4.toString());
            }
            return new AutoValue_SchedulerConfig_ConfigValue(this.delta.longValue(), this.maxAllowedDelay.longValue(), this.flags);
        }
    }
}

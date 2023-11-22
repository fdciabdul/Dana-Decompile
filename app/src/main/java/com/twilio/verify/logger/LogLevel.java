package com.twilio.verify.logger;

import com.twilio.security.logger.Level;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r"}, d2 = {"Lcom/twilio/verify/logger/LogLevel;", "", "Lcom/twilio/security/logger/Level;", "level", "Lcom/twilio/security/logger/Level;", "getLevel$verify_release", "()Lcom/twilio/security/logger/Level;", "<init>", "(Ljava/lang/String;ILcom/twilio/security/logger/Level;)V", "Error", "Info", "Networking", "Debug", "All"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public enum LogLevel {
    Error(Level.Error),
    Info(Level.Info),
    Networking(Level.Networking),
    Debug(Level.Debug),
    All(Level.All);

    private final Level level;

    LogLevel(Level level) {
        this.level = level;
    }

    @JvmName(name = "getLevel$verify_release")
    /* renamed from: getLevel$verify_release  reason: from getter */
    public final Level getLevel() {
        return this.level;
    }
}

package com.ipification.mobile.sdk.android.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/ipification/mobile/sdk/android/utils/LogUtils;", "", "()V", "Companion", "ipification-auth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class LogUtils {
    public static final Companion getAuthRequestContext = new Companion(null);
    public static final Set<LogLevel> BuiltInFictitiousFunctionClassFactory = new LinkedHashSet();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000e"}, d2 = {"Lcom/ipification/mobile/sdk/android/utils/LogUtils$Companion;", "", "Lcom/ipification/mobile/sdk/android/utils/LogLevel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lcom/ipification/mobile/sdk/android/utils/LogLevel;)V", "", "PlaceComponentResult", "(Lcom/ipification/mobile/sdk/android/utils/LogLevel;)Z", "", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "", "Ljava/util/Set;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static void BuiltInFictitiousFunctionClassFactory(LogLevel p0) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            if (p0 == LogLevel.ALL) {
                Set<LogLevel> set = LogUtils.BuiltInFictitiousFunctionClassFactory;
                set.add(LogLevel.DEBUG);
                set.add(LogLevel.INFO);
                set.add(LogLevel.WARN);
                set.add(LogLevel.VERBOSE);
                set.add(LogLevel.ERROR);
                set.add(LogLevel.WTF);
                return;
            }
            LogUtils.BuiltInFictitiousFunctionClassFactory.add(p0);
        }

        public static String MyBillsEntityDataFactory() {
            String format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(new Date());
            Intrinsics.checkExpressionValueIsNotNull(format, "");
            return format;
        }

        public static boolean PlaceComponentResult(LogLevel p0) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            return LogUtils.BuiltInFictitiousFunctionClassFactory.contains(p0);
        }
    }
}

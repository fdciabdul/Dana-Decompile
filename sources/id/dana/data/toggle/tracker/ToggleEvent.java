package id.dana.data.toggle.tracker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/toggle/tracker/ToggleEvent;", "", "<init>", "()V", "EventName", "Property"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ToggleEvent {
    public static final ToggleEvent INSTANCE = new ToggleEvent();

    private ToggleEvent() {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/data/toggle/tracker/ToggleEvent$EventName;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public @interface EventName {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.BuiltInFictitiousFunctionClassFactory;
        public static final String GET_TOGGLE_CONFIG = "$experiment_started";

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/toggle/tracker/ToggleEvent$EventName$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes8.dex */
        public static final class Companion {
            static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/data/toggle/tracker/ToggleEvent$Property;", "", "Key"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes3.dex */
    public @interface Property {

        @Retention(RetentionPolicy.RUNTIME)
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/data/toggle/tracker/ToggleEvent$Property$Key;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public @interface Key {

            /* renamed from: Companion  reason: from kotlin metadata */
            public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;
            public static final String EXPERIMENT_NAME = "Experiment name";
            public static final String VARIANT_NAME = "Variant name";

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/toggle/tracker/ToggleEvent$Property$Key$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes8.dex */
            public static final class Companion {
                static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

                private Companion() {
                }
            }
        }
    }
}

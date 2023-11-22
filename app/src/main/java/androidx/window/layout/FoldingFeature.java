package androidx.window.layout;

import id.dana.analytics.tracker.TrackerKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0003\n\u000b\fR\u0014\u0010\u0005\u001a\u00020\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/window/layout/FoldingFeature;", "Landroidx/window/layout/DisplayFeature;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "getAuthRequestContext", "Landroidx/window/layout/FoldingFeature$Orientation;", "BuiltInFictitiousFunctionClassFactory", "()Landroidx/window/layout/FoldingFeature$Orientation;", "MyBillsEntityDataFactory", "OcclusionType", "Orientation", TrackerKey.Property.STATE}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface FoldingFeature extends DisplayFeature {
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    Orientation BuiltInFictitiousFunctionClassFactory();

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    boolean KClassImpl$Data$declaredNonStaticMembers$2();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/window/layout/FoldingFeature$OcclusionType;", "", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "p0", "<init>", "(Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class OcclusionType {
        public static final OcclusionType KClassImpl$Data$declaredNonStaticMembers$2 = new OcclusionType("NONE");
        public static final OcclusionType getAuthRequestContext = new OcclusionType("FULL");

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final String PlaceComponentResult;

        private OcclusionType(String str) {
            this.PlaceComponentResult = str;
        }

        /* renamed from: toString  reason: from getter */
        public final String getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/window/layout/FoldingFeature$Orientation;", "", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "p0", "<init>", "(Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Orientation {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final String getAuthRequestContext;
        public static final Orientation getAuthRequestContext = new Orientation("VERTICAL");
        public static final Orientation BuiltInFictitiousFunctionClassFactory = new Orientation("HORIZONTAL");

        private Orientation(String str) {
            this.getAuthRequestContext = str;
        }

        /* renamed from: toString  reason: from getter */
        public final String getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/window/layout/FoldingFeature$State;", "", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "p0", "<init>", "(Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class State {
        private final String getAuthRequestContext;
        public static final State BuiltInFictitiousFunctionClassFactory = new State("FLAT");
        public static final State MyBillsEntityDataFactory = new State("HALF_OPENED");

        private State(String str) {
            this.getAuthRequestContext = str;
        }

        /* renamed from: toString  reason: from getter */
        public final String getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }
    }
}

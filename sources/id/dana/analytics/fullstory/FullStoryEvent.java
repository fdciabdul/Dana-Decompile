package id.dana.analytics.fullstory;

import com.fullstory.FS;
import id.dana.analytics.tracker.EventStrategy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0012\u0010\b\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/analytics/fullstory/FullStoryEvent;", "Lid/dana/analytics/tracker/EventStrategy;", "", "PlaceComponentResult", "()V", "Lid/dana/analytics/fullstory/FullStoryEvent$Builder;", "MyBillsEntityDataFactory", "Lid/dana/analytics/fullstory/FullStoryEvent$Builder;", "KClassImpl$Data$declaredNonStaticMembers$2", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class FullStoryEvent implements EventStrategy {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Builder KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.analytics.tracker.EventStrategy
    public final void PlaceComponentResult() {
        FS.event(Builder.BuiltInFictitiousFunctionClassFactory(), MapsKt.toMap(Builder.PlaceComponentResult()));
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R,\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b0\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/analytics/fullstory/FullStoryEvent$Builder;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "", "Lkotlin/Pair;", "Ljava/util/List;", "PlaceComponentResult", "()Ljava/util/List;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Builder {
        public static final Builder INSTANCE = new Builder();

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private static final List<Pair<String, String>> getAuthRequestContext = new ArrayList();
        private static String KClassImpl$Data$declaredNonStaticMembers$2 = "";

        private Builder() {
        }

        @JvmName(name = "PlaceComponentResult")
        public static List<Pair<String, String>> PlaceComponentResult() {
            return getAuthRequestContext;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        public static String BuiltInFictitiousFunctionClassFactory() {
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }
}

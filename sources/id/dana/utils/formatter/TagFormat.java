package id.dana.utils.formatter;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\tR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/utils/formatter/TagFormat;", "", "", "PlaceComponentResult", "()Ljava/lang/String;", "p0", "p1", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/Object;)Lid/dana/utils/formatter/TagFormat;", "Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/Map;", "getAuthRequestContext", "<init>", "(Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TagFormat {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String getAuthRequestContext = "TagFormat";

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Map<String, Object> getAuthRequestContext;
    private final String PlaceComponentResult;

    public /* synthetic */ TagFormat(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private TagFormat(String str) {
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = new HashMap();
    }

    public final TagFormat MyBillsEntityDataFactory(String p0, Object p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Map<String, Object> map = this.getAuthRequestContext;
        StringBuilder sb = new StringBuilder();
        sb.append("\\{");
        sb.append(p0);
        sb.append("\\}");
        map.put(sb.toString(), p1);
        return this;
    }

    public final String PlaceComponentResult() {
        String str = this.PlaceComponentResult;
        for (Map.Entry<String, Object> entry : this.getAuthRequestContext.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            str = new Regex(key).replace(str, value.toString());
        }
        return str;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0005\u001a\u0006*\u00020\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/utils/formatter/TagFormat$Companion;", "", "", "p0", "Lid/dana/utils/formatter/TagFormat;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lid/dana/utils/formatter/TagFormat;", "getAuthRequestContext", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static TagFormat KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new TagFormat(p0, null);
        }
    }
}

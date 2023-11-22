package id.dana.utils.deeplink;

import android.app.Activity;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/utils/deeplink/BranchDeeplinkUtil;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Ljava/util/Map;", "Landroid/app/Activity;", "", "getAuthRequestContext", "(Landroid/app/Activity;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BranchDeeplinkUtil {
    public static final BranchDeeplinkUtil INSTANCE = new BranchDeeplinkUtil();

    private BranchDeeplinkUtil() {
    }

    @JvmStatic
    public static final boolean getAuthRequestContext(Activity p0) {
        if (p0 != null) {
            boolean z = p0.getIntent().hasExtra("branch_force_new_session") && p0.getIntent().getBooleanExtra("branch_force_new_session", false);
            boolean z2 = p0.getIntent().hasExtra("in_app_deeplink_process") && p0.getIntent().getBooleanExtra("in_app_deeplink_process", false);
            if (z || z2) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Object m3179constructorimpl;
        Intrinsics.checkNotNullParameter(p0, "");
        try {
            Result.Companion companion = Result.INSTANCE;
            Uri parse = Uri.parse(p0);
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            Intrinsics.checkNotNullExpressionValue(queryParameterNames, "");
            Set<String> set = queryParameterNames;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set, 10)), 16));
            for (Object obj : set) {
                linkedHashMap.put(obj, parse.getQueryParameter((String) obj));
            }
            Object obj2 = linkedHashMap.get("params");
            Intrinsics.checkNotNull(obj2);
            List split$default = StringsKt.split$default((CharSequence) StringsKt.removeSurrounding((String) obj2, (CharSequence) "[", (CharSequence) "]"), new String[]{","}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                List split$default2 = StringsKt.split$default((CharSequence) ((String) it.next()), new String[]{"="}, false, 0, 6, (Object) null);
                arrayList.add(TuplesKt.to((String) split$default2.get(0), (String) split$default2.get(1)));
            }
            m3179constructorimpl = Result.m3179constructorimpl(MapsKt.toMap(arrayList));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        Map emptyMap = MapsKt.emptyMap();
        boolean m3185isFailureimpl = Result.m3185isFailureimpl(m3179constructorimpl);
        Map map = m3179constructorimpl;
        if (m3185isFailureimpl) {
            map = emptyMap;
        }
        return (Map) map;
    }
}

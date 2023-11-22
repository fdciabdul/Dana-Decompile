package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import android.view.WindowMetrics;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0082\u0002¢\u0006\u0004\b\t\u0010\nJ,\u0010\u000b\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0082\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fJ(\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\b0\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J(\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00140\b0\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000eH\u0007J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000eH\u0007J\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020 0\u000e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000e¨\u0006#"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter;", "", "Landroidx/window/extensions/embedding/SplitInfo;", "splitInfo", "Landroidx/window/embedding/SplitInfo;", "translate", LogConstants.RESULT_FALSE, "S", "Landroid/util/Pair;", "component1", "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "", "splitInfoList", "", "Landroidx/window/embedding/SplitPairFilter;", "splitPairFilters", "j$/util/function/Predicate", "Landroid/app/Activity;", "translateActivityPairPredicates", "Landroid/content/Intent;", "translateActivityIntentPredicates", "Landroidx/window/embedding/SplitRule;", "splitRule", "Landroid/view/WindowMetrics;", "translateParentMetricsPredicate", "Landroidx/window/embedding/ActivityFilter;", "activityFilters", "translateActivityPredicates", "translateIntentPredicates", "Landroidx/window/embedding/EmbeddingRule;", "rules", "Landroidx/window/extensions/embedding/EmbeddingRule;", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class EmbeddingAdapter {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static SplitInfo KClassImpl$Data$declaredNonStaticMembers$2(androidx.window.extensions.embedding.SplitInfo splitInfo) {
        boolean z;
        androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        Intrinsics.checkNotNullExpressionValue(primaryActivityStack, "");
        boolean z2 = false;
        try {
            z = primaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused) {
            z = false;
        }
        List activities = primaryActivityStack.getActivities();
        Intrinsics.checkNotNullExpressionValue(activities, "");
        ActivityStack activityStack = new ActivityStack(activities, z);
        androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        Intrinsics.checkNotNullExpressionValue(secondaryActivityStack, "");
        try {
            z2 = secondaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused2) {
        }
        List activities2 = secondaryActivityStack.getActivities();
        Intrinsics.checkNotNullExpressionValue(activities2, "");
        return new SplitInfo(activityStack, new ActivityStack(activities2, z2), splitInfo.getSplitRatio());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MyBillsEntityDataFactory(EmbeddingAdapter embeddingAdapter, Set set, Pair pair) {
        Intrinsics.checkNotNullParameter(embeddingAdapter, "");
        Intrinsics.checkNotNullParameter(set, "");
        Intrinsics.checkNotNullExpressionValue(pair, "");
        Intrinsics.checkNotNullParameter(pair, "");
        Activity activity = (Activity) pair.first;
        Intrinsics.checkNotNullParameter(pair, "");
        Activity activity2 = (Activity) pair.second;
        Set set2 = set;
        if ((set2 instanceof Collection) && set2.isEmpty()) {
            return false;
        }
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            if (((SplitPairFilter) it.next()).MyBillsEntityDataFactory(activity, activity2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAuthRequestContext(EmbeddingAdapter embeddingAdapter, Set set, Pair pair) {
        Intrinsics.checkNotNullParameter(embeddingAdapter, "");
        Intrinsics.checkNotNullParameter(set, "");
        Intrinsics.checkNotNullExpressionValue(pair, "");
        Intrinsics.checkNotNullParameter(pair, "");
        Activity activity = (Activity) pair.first;
        Intrinsics.checkNotNullParameter(pair, "");
        Intent intent = (Intent) pair.second;
        Set set2 = set;
        if ((set2 instanceof Collection) && set2.isEmpty()) {
            return false;
        }
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            if (((SplitPairFilter) it.next()).KClassImpl$Data$declaredNonStaticMembers$2(activity, intent)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PlaceComponentResult(SplitRule splitRule, WindowMetrics windowMetrics) {
        Intrinsics.checkNotNullParameter(splitRule, "");
        Intrinsics.checkNotNullExpressionValue(windowMetrics, "");
        return splitRule.BuiltInFictitiousFunctionClassFactory(windowMetrics);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAuthRequestContext(Set set, Activity activity) {
        Intrinsics.checkNotNullParameter(set, "");
        Set<ActivityFilter> set2 = set;
        if ((set2 instanceof Collection) && set2.isEmpty()) {
            return false;
        }
        for (ActivityFilter activityFilter : set2) {
            Intrinsics.checkNotNullExpressionValue(activity, "");
            if (activityFilter.PlaceComponentResult(activity)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(Set set, Intent intent) {
        Intrinsics.checkNotNullParameter(set, "");
        Set<ActivityFilter> set2 = set;
        if ((set2 instanceof Collection) && set2.isEmpty()) {
            return false;
        }
        for (ActivityFilter activityFilter : set2) {
            Intrinsics.checkNotNullExpressionValue(intent, "");
            if (activityFilter.MyBillsEntityDataFactory(intent)) {
                return true;
            }
        }
        return false;
    }
}

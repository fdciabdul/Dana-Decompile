package id.dana.tracker;

import android.content.Context;
import id.dana.tracker.EventTrackerModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/tracker/BaseEventTracker;", "", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/content/Context;", "getAuthRequestContext", "Landroid/content/Context;", "PlaceComponentResult", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseEventTracker {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

    public BaseEventTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.PlaceComponentResult);
        p0.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
    }
}

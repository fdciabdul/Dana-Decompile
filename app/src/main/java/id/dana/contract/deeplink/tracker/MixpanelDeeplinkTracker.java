package id.dana.contract.deeplink.tracker;

import android.content.Context;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.contract.deeplink.DeeplinkLoadTimeTracker;
import id.dana.data.deeplink.DeeplinkException;
import id.dana.domain.deeplink.model.DeepLinkPayload;
import id.dana.tracker.BaseEventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.MixPanelTracker;
import java.net.MalformedURLException;
import java.net.URL;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006JA\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0011J'\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u000f\u0010\u0015J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0017"}, d2 = {"Lid/dana/contract/deeplink/tracker/MixpanelDeeplinkTracker;", "Lid/dana/tracker/BaseEventTracker;", "Lid/dana/contract/deeplink/tracker/DeeplinkTracker;", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)Ljava/lang/String;", "", "p1", "p2", "p3", "p4", "", "p5", "", "MyBillsEntityDataFactory", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/domain/deeplink/model/DeepLinkPayload;", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/deeplink/model/DeepLinkPayload;)V", "Landroid/content/Context;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MixpanelDeeplinkTracker extends BaseEventTracker implements DeeplinkTracker {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public MixpanelDeeplinkTracker(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = context;
    }

    @Override // id.dana.contract.deeplink.tracker.DeeplinkTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        MyBillsEntityDataFactory(true, p0, PlaceComponentResult(p0), p1, p2, null);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.contract.deeplink.tracker.DeeplinkTracker
    public final void MyBillsEntityDataFactory(String p0, String p1, DeepLinkPayload p2) {
        Intrinsics.checkNotNullParameter(p2, "");
        ?? r2 = 0;
        throw new NotImplementedError(r2, 1, r2);
    }

    @Override // id.dana.contract.deeplink.tracker.DeeplinkTracker
    public final void MyBillsEntityDataFactory(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        boolean z = p0 instanceof DeeplinkException;
        MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, z ? ((DeeplinkException) p0).getCode() : "", z ? ((DeeplinkException) p0).getUrl() : "", p0.getMessage(), this.PlaceComponentResult.getString(R.string.deeplink_error_description), "Deep link", "");
    }

    private static String PlaceComponentResult(String p0) {
        String str;
        if (p0.length() > 0) {
            try {
                str = new URL(p0).getPath();
            } catch (MalformedURLException unused) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "");
            return str;
        }
        return "";
    }

    private final void MyBillsEntityDataFactory(final boolean p0, final String p1, final String p2, final String p3, final String p4, Throwable p5) {
        String str;
        long BuiltInFictitiousFunctionClassFactory = DeeplinkLoadTimeTracker.BuiltInFictitiousFunctionClassFactory();
        final long authRequestContext = DeeplinkLoadTimeTracker.getAuthRequestContext();
        final long j = BuiltInFictitiousFunctionClassFactory + authRequestContext;
        DeeplinkLoadTimeTracker.lookAheadTest = j;
        if (p5 == null || (str = p5.getMessage()) == null) {
            str = "null";
        }
        final String str2 = str;
        KClassImpl$Data$declaredNonStaticMembers$2(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.contract.deeplink.tracker.MixpanelDeeplinkTracker$track$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.DEEPLINK_REDIRECTION;
                builder.BuiltInFictitiousFunctionClassFactory("Success", p0);
                builder.MyBillsEntityDataFactory(TrackerKey.DeeplinkProperty.FULL_URL, p1);
                builder.MyBillsEntityDataFactory(TrackerKey.DeeplinkProperty.PATH, p2);
                builder.MyBillsEntityDataFactory(TrackerKey.DeeplinkProperty.REDIRECTION, p3);
                builder.MyBillsEntityDataFactory(TrackerKey.DeeplinkProperty.ADDITIONAL_FLOW, p4);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.DeeplinkProperty.GET_PAYLOAD_DURATION, authRequestContext);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.DeeplinkProperty.TOTAL_DURATION, j);
                builder.MyBillsEntityDataFactory("Error Message", str2);
            }
        });
        DeeplinkLoadTimeTracker.PlaceComponentResult();
    }

    @Override // id.dana.contract.deeplink.tracker.DeeplinkTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String url = p0 instanceof DeeplinkException ? ((DeeplinkException) p0).getUrl() : "";
        DeeplinkLoadTimeTracker deeplinkLoadTimeTracker = DeeplinkLoadTimeTracker.INSTANCE;
        if (DeeplinkLoadTimeTracker.DatabaseTableConfigUtil()) {
            DeeplinkLoadTimeTracker.moveToNextValue();
        }
        if (DeeplinkLoadTimeTracker.getErrorConfigVersion()) {
            DeeplinkLoadTimeTracker.scheduleImpl();
        }
        String str = url;
        if (str == null || str.length() == 0) {
            return;
        }
        MyBillsEntityDataFactory(false, url, PlaceComponentResult(url), "Error", "None", p0);
    }
}

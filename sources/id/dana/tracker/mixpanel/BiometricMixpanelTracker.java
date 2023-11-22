package id.dana.tracker.mixpanel;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.biometric.domain.model.BiometricDataSize;
import id.dana.tracker.EventPropertiesModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\b"}, d2 = {"Lid/dana/tracker/mixpanel/BiometricMixpanelTracker;", "Lid/dana/tracker/mixpanel/BiometricAnalyticTracker;", "Lid/dana/biometric/domain/model/BiometricDataSize;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/biometric/domain/model/BiometricDataSize;)V", "Landroid/content/Context;", "Landroid/content/Context;", "MyBillsEntityDataFactory", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BiometricMixpanelTracker implements BiometricAnalyticTracker {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Context MyBillsEntityDataFactory;

    @Inject
    public BiometricMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
    }

    @Override // id.dana.tracker.mixpanel.BiometricAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final BiometricDataSize p0) {
        String str;
        EventPropertiesModel eventPropertiesModel;
        Intrinsics.checkNotNullParameter(p0, "");
        Function1<EventTrackerModel.Builder, Unit> function1 = new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.tracker.mixpanel.BiometricMixpanelTracker$trackBiometricDataSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PASSIVE_BIOMETRIC;
                builder.MyBillsEntityDataFactory(TrackerKey.PassiveBioProperties.GYROSCOPE, BiometricDataSize.this.KClassImpl$Data$declaredNonStaticMembers$2);
                builder.MyBillsEntityDataFactory(TrackerKey.PassiveBioProperties.ACCELEROMETER, BiometricDataSize.this.BuiltInFictitiousFunctionClassFactory);
                builder.MyBillsEntityDataFactory(TrackerKey.PassiveBioProperties.KEYSTROKE, BiometricDataSize.this.MyBillsEntityDataFactory);
            }
        };
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.MyBillsEntityDataFactory);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        function1.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTrackerModel eventTrackerModel = new EventTrackerModel(PlaceComponentResult, (byte) 0);
        EventTracker.PlaceComponentResult(eventTrackerModel);
        StringBuilder sb = new StringBuilder();
        sb.append("key=");
        str = eventTrackerModel.getAuthRequestContext.MyBillsEntityDataFactory;
        sb.append(str);
        sb.append(" \n properties=");
        eventPropertiesModel = eventTrackerModel.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        sb.append(eventPropertiesModel.MyBillsEntityDataFactory);
        DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.MIXPANEL_PASSIVE_BIOMETRIC, sb.toString());
    }
}

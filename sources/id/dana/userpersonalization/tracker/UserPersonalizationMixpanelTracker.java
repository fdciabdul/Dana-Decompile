package id.dana.userpersonalization.tracker;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.explore.domain.userpersonalization.model.UserPersonalizationModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\n\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011"}, d2 = {"Lid/dana/userpersonalization/tracker/UserPersonalizationMixpanelTracker;", "Lid/dana/userpersonalization/tracker/UserPersonalizationAnalyticTracker;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "MyBillsEntityDataFactory", "(Lkotlin/jvm/functions/Function1;)V", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "", "Lid/dana/explore/domain/userpersonalization/model/UserPersonalizationModel;", "p1", "(Ljava/lang/String;Ljava/util/List;)V", "Landroid/content/Context;", "Landroid/content/Context;", "PlaceComponentResult", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserPersonalizationMixpanelTracker implements UserPersonalizationAnalyticTracker {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

    @Inject
    public UserPersonalizationMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = context;
    }

    @Override // id.dana.userpersonalization.tracker.UserPersonalizationAnalyticTracker
    public final void getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.userpersonalization.tracker.UserPersonalizationMixpanelTracker$trackOpenUserPersonalization$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.USER_PREFERENCE_LIST_OPEN;
                builder.MyBillsEntityDataFactory("Source", p0);
            }
        });
    }

    @Override // id.dana.userpersonalization.tracker.UserPersonalizationAnalyticTracker
    public final void getAuthRequestContext(final String p0, final List<UserPersonalizationModel> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.userpersonalization.tracker.UserPersonalizationMixpanelTracker$trackSubmitUserPersonalization$1
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
                String joinToString$default;
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.USER_PREFERENCE_LIST_SUBMIT;
                builder.MyBillsEntityDataFactory("Source", p0);
                joinToString$default = CollectionsKt.joinToString$default(p1, ",", null, null, 0, null, new Function1<UserPersonalizationModel, CharSequence>() { // from class: id.dana.userpersonalization.tracker.UserPersonalizationMixpanelTracker$getPreferencesName$1
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(UserPersonalizationModel userPersonalizationModel) {
                        Intrinsics.checkNotNullParameter(userPersonalizationModel, "");
                        return userPersonalizationModel.getDisplayName();
                    }
                }, 30, null);
                builder.MyBillsEntityDataFactory(TrackerKey.UserPersonalizationProperties.SELECTED_CATEGORY, joinToString$default);
            }
        });
    }

    private final void MyBillsEntityDataFactory(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.PlaceComponentResult);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        p0.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
    }
}

package id.dana.twilio.tracker;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductManager;
import id.dana.domain.util.StringUtil;
import id.dana.oauth.OauthConstant;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000fJ1\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u0010JC\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J9\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0007\u0010\u0015J1\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0007\u0010\u0016R\u0011\u0010\u0013\u001a\u00020\u0017X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0018"}, d2 = {"Lid/dana/twilio/tracker/TwilioMixpanelTracker;", "Lid/dana/twilio/tracker/TwilioAnalyticTracker;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "MyBillsEntityDataFactory", "(Lkotlin/jvm/functions/Function1;)V", "", "Ljava/util/Date;", "p1", "p2", "p3", "p4", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;)V", "", "p5", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Z)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TwilioMixpanelTracker implements TwilioAnalyticTracker {
    public final Context KClassImpl$Data$declaredNonStaticMembers$2;

    public static final /* synthetic */ String getAuthRequestContext(String str) {
        return str == null ? "" : str;
    }

    @Inject
    public TwilioMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String str, final Date date, final String str2, final String str3, final boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(date, "");
        Intrinsics.checkNotNullParameter(str3, "");
        final String str4 = null;
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.twilio.tracker.TwilioMixpanelTracker$trackTwilioReturnCreateChallenge$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PUSH_VERIFY_RETURN_CREATE_CHALLENGE;
                builder.MyBillsEntityDataFactory("Source", str);
                builder.MyBillsEntityDataFactory("Duration", TwilioMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(date));
                String str5 = str2;
                if (str5 != null) {
                    builder.MyBillsEntityDataFactory(TrackerKey.Property.FACTOR_SID, str5);
                }
                builder.MyBillsEntityDataFactory(TrackerKey.Property.CHALLENGE_SID, str3);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.IS_SUCCESS, z);
                String str6 = str4;
                if (str6 == null) {
                    str6 = " ";
                }
                builder.MyBillsEntityDataFactory("Fail Reason", str6);
                builder.MyBillsEntityDataFactory(TrackerKey.Property.TIME, TwilioMixpanelTracker.getAuthRequestContext());
            }
        });
    }

    @Override // id.dana.twilio.tracker.TwilioAnalyticTracker
    public final void MyBillsEntityDataFactory(final String p0, final String p1, final String p2, final String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.twilio.tracker.TwilioMixpanelTracker$trackTwilioUpdateChallengeSuccess$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PUSH_VERIFY_UPDATE_CHALLENGE;
                builder.MyBillsEntityDataFactory("Source", p0);
                builder.MyBillsEntityDataFactory(TrackerKey.Property.CHALLENGE_SID, p1);
                builder.MyBillsEntityDataFactory(TrackerKey.Property.USER_UPDATE_RESULT, p2);
                builder.MyBillsEntityDataFactory(TrackerKey.Property.TIME, TwilioMixpanelTracker.getAuthRequestContext());
                String str = p3;
                if (str == null) {
                    str = OauthConstant.BindingType.IPG;
                }
                builder.MyBillsEntityDataFactory("Merchant Name", str);
                builder.BuiltInFictitiousFunctionClassFactory("Success", true);
            }
        });
    }

    @Override // id.dana.twilio.tracker.TwilioAnalyticTracker
    public final void MyBillsEntityDataFactory(final String p0, final String p1, final String p2, final String p3, final String p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.twilio.tracker.TwilioMixpanelTracker$trackTwilioUpdateChallengeFailed$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PUSH_VERIFY_UPDATE_CHALLENGE;
                builder.MyBillsEntityDataFactory("Source", p0);
                builder.MyBillsEntityDataFactory(TrackerKey.Property.CHALLENGE_SID, p1);
                builder.MyBillsEntityDataFactory(TrackerKey.Property.USER_UPDATE_RESULT, p2);
                builder.MyBillsEntityDataFactory(TrackerKey.Property.TIME, TwilioMixpanelTracker.getAuthRequestContext());
                String str = p4;
                if (str == null) {
                    str = OauthConstant.BindingType.IPG;
                }
                builder.MyBillsEntityDataFactory("Merchant Name", str);
                builder.BuiltInFictitiousFunctionClassFactory("Success", false);
                builder.MyBillsEntityDataFactory("Fail Reason", p3);
            }
        });
    }

    public final void MyBillsEntityDataFactory(final String p0, final Date p1, final String p2, final String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p3, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.twilio.tracker.TwilioMixpanelTracker$trackTwilioPushChallengeSuccess$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PUSH_VERIFY_COMPLETED;
                builder.MyBillsEntityDataFactory("Source", p0);
                builder.MyBillsEntityDataFactory("Duration", TwilioMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(p1));
                String str = p2;
                if (str != null) {
                    builder.MyBillsEntityDataFactory(TrackerKey.Property.FACTOR_SID, str);
                }
                builder.MyBillsEntityDataFactory(TrackerKey.Property.CHALLENGE_SID, p3);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.IS_SUCCESS, true);
                builder.MyBillsEntityDataFactory(TrackerKey.Property.TIME, TwilioMixpanelTracker.getAuthRequestContext());
            }
        });
    }

    public final void MyBillsEntityDataFactory(final String p0, final Date p1, final String p2, final String p3, final String p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.twilio.tracker.TwilioMixpanelTracker$trackTwilioPushChallengeFailed$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PUSH_VERIFY_COMPLETED;
                builder.MyBillsEntityDataFactory("Source", p0);
                builder.MyBillsEntityDataFactory("Duration", TwilioMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(p1));
                String str = p2;
                if (str != null) {
                    builder.MyBillsEntityDataFactory(TrackerKey.Property.FACTOR_SID, str);
                }
                builder.MyBillsEntityDataFactory(TrackerKey.Property.CHALLENGE_SID, p3);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.IS_SUCCESS, false);
                builder.MyBillsEntityDataFactory("Fail Reason", p4);
                builder.MyBillsEntityDataFactory(TrackerKey.Property.TIME, TwilioMixpanelTracker.getAuthRequestContext());
            }
        });
    }

    private final void MyBillsEntityDataFactory(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        p0.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
    }

    public static final /* synthetic */ String BuiltInFictitiousFunctionClassFactory(String str) {
        return (str == null || !Intrinsics.areEqual(str, TwilioVerifySecurityProductManager.VERIFY_SECURITY_PRODUCT_POST_LOGIN)) ? "Other Device" : "Same Device";
    }

    public static final /* synthetic */ String getAuthRequestContext() {
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, "");
        return StringUtil.getDateTime("HH:mm:ss, d, MMM, yyyy", locale, "Asia/Jakarta");
    }

    public static final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2(Date date) {
        Date time = Calendar.getInstance().getTime();
        Intrinsics.checkNotNullExpressionValue(time, "");
        double abs = (Math.abs(date.getTime() - time.getTime()) / 1000) % 60;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(abs)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }
}

package id.dana.oauth.tracker;

import android.content.Context;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.contract.deeplink.DeeplinkLoadTimeTracker;
import id.dana.domain.oauth.error.QueryAuthInfoException;
import id.dana.extension.lang.StringExtKt;
import id.dana.model.DisplayedErrorModel;
import id.dana.oauth.OauthLoginManager;
import id.dana.oauth.model.OauthInitModel;
import id.dana.tracker.BaseEventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.MixPanelTracker;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u0005X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0013\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017"}, d2 = {"Lid/dana/oauth/tracker/MixpanelOauthGrantTracker;", "Lid/dana/tracker/BaseEventTracker;", "Lid/dana/oauth/tracker/OauthGrantTracker;", "", "p0", "", "p1", "", "p2", "p3", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Throwable;Ljava/lang/String;ZZ)V", "", "PlaceComponentResult", "(Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "Lid/dana/oauth/model/OauthInitModel;", "getAuthRequestContext", "(Lid/dana/oauth/model/OauthInitModel;)V", "Lkotlin/Lazy;", "Landroid/content/Context;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MixpanelOauthGrantTracker extends BaseEventTracker implements OauthGrantTracker {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public MixpanelOauthGrantTracker(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this.getAuthRequestContext = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<String>() { // from class: id.dana.oauth.tracker.MixpanelOauthGrantTracker$bindingPurpose$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("Binding %s-%s", Arrays.copyOf(new Object[]{MixpanelOauthGrantTracker.getAuthRequestContext(MixpanelOauthGrantTracker.this), MixpanelOauthGrantTracker.MyBillsEntityDataFactory()}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "");
                return format;
            }
        });
    }

    @Override // id.dana.oauth.tracker.OauthGrantTracker
    public final void getAuthRequestContext(OauthInitModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final long BuiltInFictitiousFunctionClassFactory = OauthGrantTimer.BuiltInFictitiousFunctionClassFactory();
        String str = p0.getAuthRequestContext;
        final String str2 = str != null ? str : "";
        KClassImpl$Data$declaredNonStaticMembers$2(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.oauth.tracker.MixpanelOauthGrantTracker$trackGnMerchantRequestOpen$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.ACCESS_REQUEST_OPEN;
                builder.MyBillsEntityDataFactory("Source", TrackerDataKey.Source.DEEPLINK_BINDING);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.LOAD_DURATION, BuiltInFictitiousFunctionClassFactory);
                builder.MyBillsEntityDataFactory("Merchant Name", MixpanelOauthGrantTracker.getAuthRequestContext(this));
                builder.MyBillsEntityDataFactory(TrackerKey.BindingProperties.MERCHANT_SITE_NAME, str2);
            }
        });
    }

    @Override // id.dana.oauth.tracker.OauthGrantTracker
    public final void MyBillsEntityDataFactory(final String p0) {
        final boolean z = p0 == null;
        KClassImpl$Data$declaredNonStaticMembers$2(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.oauth.tracker.MixpanelOauthGrantTracker$trackGnMerchantLoadingState$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.LOADING_STATE;
                builder.MyBillsEntityDataFactory("Source", TrackerDataKey.Source.DEEPLINK_BINDING);
                builder.MyBillsEntityDataFactory("Purpose", MixpanelOauthGrantTracker.MyBillsEntityDataFactory(MixpanelOauthGrantTracker.this));
                builder.BuiltInFictitiousFunctionClassFactory("Success", z);
                if (z) {
                    return;
                }
                builder.MyBillsEntityDataFactory("Fail Reason", p0);
            }
        });
    }

    @Override // id.dana.oauth.tracker.OauthGrantTracker
    public final void PlaceComponentResult(final String p0, final boolean p1, final String p2, final List<String> p3) {
        long coerceAtLeast;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p3, "");
        long MyBillsEntityDataFactory = DeeplinkLoadTimeTracker.MyBillsEntityDataFactory();
        long BuiltInFictitiousFunctionClassFactory = OauthGrantTimer.BuiltInFictitiousFunctionClassFactory();
        coerceAtLeast = RangesKt.coerceAtLeast(OauthGrantTimer.getAuthRequestContext - OauthGrantTimer.KClassImpl$Data$declaredNonStaticMembers$2, 0L);
        final long j = coerceAtLeast + BuiltInFictitiousFunctionClassFactory;
        final long j2 = MyBillsEntityDataFactory + j;
        KClassImpl$Data$declaredNonStaticMembers$2(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.oauth.tracker.MixpanelOauthGrantTracker$trackGnMerchantAccountBind$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.ACCOUNT_BIND;
                builder.MyBillsEntityDataFactory("Source", TrackerDataKey.Source.DEEPLINK_BINDING);
                builder.BuiltInFictitiousFunctionClassFactory("Success", p1);
                builder.MyBillsEntityDataFactory("Merchant Name", MixpanelOauthGrantTracker.getAuthRequestContext(this));
                builder.MyBillsEntityDataFactory(TrackerKey.BindingProperties.MERCHANT_SITE_NAME, p0);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.BindingProperties.BIND_DURATION, j);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.BindingProperties.FULL_BIND_DURATION, j2);
                if (p3.isEmpty()) {
                    builder.MyBillsEntityDataFactory("Risk Type", "null");
                } else {
                    builder.BuiltInFictitiousFunctionClassFactory("Risk Type", StringExtKt.BuiltInFictitiousFunctionClassFactory(p3));
                }
                if (!p1) {
                    builder.MyBillsEntityDataFactory("Fail Reason", p2);
                }
                DeeplinkLoadTimeTracker.lookAheadTest = 0L;
                OauthGrantTimer.PlaceComponentResult();
            }
        });
    }

    public static final /* synthetic */ String MyBillsEntityDataFactory(MixpanelOauthGrantTracker mixpanelOauthGrantTracker) {
        return (String) mixpanelOauthGrantTracker.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ String MyBillsEntityDataFactory() {
        OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
        return OauthLoginManager.MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ String getAuthRequestContext(MixpanelOauthGrantTracker mixpanelOauthGrantTracker) {
        OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
        String scheduleImpl = OauthLoginManager.scheduleImpl();
        if (scheduleImpl.length() == 0) {
            scheduleImpl = mixpanelOauthGrantTracker.getAuthRequestContext.getString(R.string.dana_string);
            Intrinsics.checkNotNullExpressionValue(scheduleImpl, "");
        }
        return scheduleImpl;
    }

    @Override // id.dana.oauth.tracker.OauthGrantTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0, String p1, boolean p2, boolean p3) {
        String string;
        Intrinsics.checkNotNullParameter(p0, "");
        if (p2) {
            string = this.getAuthRequestContext.getString(R.string.account_link_fail);
            Intrinsics.checkNotNullExpressionValue(string, "");
        } else if (p3) {
            string = this.getAuthRequestContext.getString(R.string.error_google_oauth_description);
            Intrinsics.checkNotNullExpressionValue(string, "");
        } else {
            string = this.getAuthRequestContext.getString(R.string.error_oauth_description);
            Intrinsics.checkNotNullExpressionValue(string, "");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Deeplink Binding ");
        if (p1 == null) {
            p1 = "";
        }
        String upperCase = p1.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        sb.append(upperCase);
        String obj = sb.toString();
        boolean z = p0 instanceof QueryAuthInfoException;
        String str = z ? TrackerDataKey.NetworkErrorOperationTypeProperty.QUERY_AUTH_INFO : TrackerDataKey.NetworkErrorOperationTypeProperty.GET_AUTH_CODE;
        DisplayedErrorModel.Companion companion = DisplayedErrorModel.INSTANCE;
        if (z) {
            p0 = ((QueryAuthInfoException) p0).getThrowable();
        }
        MixPanelTracker.getAuthRequestContext(this.getAuthRequestContext, string, obj, DisplayedErrorModel.Companion.BuiltInFictitiousFunctionClassFactory(p0, str));
    }
}

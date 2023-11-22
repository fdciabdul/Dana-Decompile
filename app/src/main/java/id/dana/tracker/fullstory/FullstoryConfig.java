package id.dana.tracker.fullstory;

import com.fullstory.FS;
import com.fullstory.FSOnReadyListener;
import com.fullstory.FSSessionData;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.data.account.repository.source.SecuredAccountPreferences;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.fullstory.interactor.IsEligibleForFullstorySession;
import id.dana.tracker.EventConfig;
import id.dana.tracker.EventConfigProperty;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\n"}, d2 = {"Lid/dana/tracker/fullstory/FullstoryConfig;", "Lid/dana/tracker/EventConfig;", "", "MyBillsEntityDataFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "PlaceComponentResult", "Lid/dana/tracker/EventConfigProperty;", "Lid/dana/tracker/EventConfigProperty;", "p0", "<init>", "(Lid/dana/tracker/EventConfigProperty;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FullstoryConfig implements EventConfig {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final EventConfigProperty KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public FullstoryConfig(EventConfigProperty eventConfigProperty) {
        Intrinsics.checkNotNullParameter(eventConfigProperty, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = eventConfigProperty;
    }

    @Override // id.dana.tracker.EventConfig
    public final void MyBillsEntityDataFactory() {
        String str;
        String str2;
        FS.setReadyListener(new FSOnReadyListener() { // from class: id.dana.tracker.fullstory.FullstoryConfig$$ExternalSyntheticLambda0
            @Override // com.fullstory.FSOnReadyListener
            public final void onReady(FSSessionData fSSessionData) {
                FullstoryConfig.getAuthRequestContext(fSSessionData);
            }
        });
        str = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getErrorConfigVersion;
        if (str != null) {
            str2 = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            if (str2.length() > 0) {
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
    }

    @Override // id.dana.tracker.EventConfig
    public final void PlaceComponentResult() {
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.tracker.EventConfig
    public final void BuiltInFictitiousFunctionClassFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        FullstoryTracker fullstoryTracker = FullstoryTracker.INSTANCE;
        IsEligibleForFullstorySession authRequestContext = FullstoryTracker.getAuthRequestContext();
        if (authRequestContext == null) {
            Crashlytics.Companion companion = Crashlytics.INSTANCE;
            Crashlytics authRequestContext2 = Crashlytics.Companion.getAuthRequestContext();
            Intrinsics.checkNotNullParameter("FullstoryTracker.isEligibleForFullstorySession it not set", "");
            authRequestContext2.getAuthRequestContext.log("FullstoryTracker.isEligibleForFullstorySession it not set");
            Intrinsics.checkNotNullParameter("reason: DanaApplication.initMainComponent is asynchronous", "");
            authRequestContext2.getAuthRequestContext.log("reason: DanaApplication.initMainComponent is asynchronous");
            NullPointerException nullPointerException = new NullPointerException("FullstoryTracker.isEligibleForFullstorySession");
            Intrinsics.checkNotNullParameter(nullPointerException, "");
            authRequestContext2.getAuthRequestContext.recordException(nullPointerException);
            return;
        }
        authRequestContext.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.tracker.fullstory.FullstoryConfig$initiateFullstoryIfEligible$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                EventConfigProperty eventConfigProperty;
                if (z) {
                    FS.restart();
                    eventConfigProperty = FullstoryConfig.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    FullstoryConfig.BuiltInFictitiousFunctionClassFactory(eventConfigProperty);
                    return;
                }
                FS.shutdown();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.tracker.fullstory.FullstoryConfig$initiateFullstoryIfEligible$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                FS.shutdown();
            }
        });
    }

    @Override // id.dana.tracker.EventConfig
    public final void getAuthRequestContext() {
        FS.shutdown();
    }

    public static /* synthetic */ void getAuthRequestContext(FSSessionData fSSessionData) {
        Timber.getAuthRequestContext("FullstoryLog").BuiltInFictitiousFunctionClassFactory(fSSessionData.getCurrentSessionURL(), new Object[0]);
        Crashlytics.Companion companion = Crashlytics.INSTANCE;
        Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
        String currentSessionURL = fSSessionData.getCurrentSessionURL();
        Intrinsics.checkNotNullExpressionValue(currentSessionURL, "");
        Intrinsics.checkNotNullParameter("FSSessionURL", "");
        Intrinsics.checkNotNullParameter(currentSessionURL, "");
        authRequestContext.getAuthRequestContext.setCustomKey("FSSessionURL", currentSessionURL);
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(EventConfigProperty eventConfigProperty) {
        String str;
        String str2;
        String str3;
        Timber.getAuthRequestContext("FullstoryLog").BuiltInFictitiousFunctionClassFactory("is eligible for fullstory session, identifying user now", new Object[0]);
        str = eventConfigProperty.PlaceComponentResult.getErrorConfigVersion;
        str2 = eventConfigProperty.PlaceComponentResult.getErrorConfigVersion;
        str3 = eventConfigProperty.PlaceComponentResult.lookAheadTest;
        FS.identify(str, MapsKt.mutableMapOf(TuplesKt.to(SecuredAccountPreferences.Key.USER_ID, str2), TuplesKt.to("environment", "production"), TuplesKt.to("utdid", str3)));
    }
}

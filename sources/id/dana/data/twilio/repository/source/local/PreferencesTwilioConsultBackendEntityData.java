package id.dana.data.twilio.repository.source.local;

import id.dana.data.twilio.repository.source.TwilioConsultBackendPreferencesEntityData;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/twilio/repository/source/local/PreferencesTwilioConsultBackendEntityData;", "Lid/dana/data/twilio/repository/source/TwilioConsultBackendPreferencesEntityData;", "Lio/reactivex/Observable;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "", "MyBillsEntityDataFactory", "()Z", "p0", "(J)Lio/reactivex/Observable;", "getAuthRequestContext", "(Z)Lio/reactivex/Observable;", "Lid/dana/data/twilio/repository/source/local/TwilioConsultBackendPreferences;", "PlaceComponentResult", "Lid/dana/data/twilio/repository/source/local/TwilioConsultBackendPreferences;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/data/twilio/repository/source/local/TwilioConsultBackendPreferences;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreferencesTwilioConsultBackendEntityData implements TwilioConsultBackendPreferencesEntityData {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final TwilioConsultBackendPreferences BuiltInFictitiousFunctionClassFactory;

    @Inject
    public PreferencesTwilioConsultBackendEntityData(TwilioConsultBackendPreferences twilioConsultBackendPreferences) {
        Intrinsics.checkNotNullParameter(twilioConsultBackendPreferences, "");
        this.BuiltInFictitiousFunctionClassFactory = twilioConsultBackendPreferences;
    }

    @Override // id.dana.data.twilio.repository.source.TwilioConsultBackendPreferencesEntityData
    public final Observable<Boolean> MyBillsEntityDataFactory(long p0) {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.twilio.repository.source.TwilioConsultBackendPreferencesEntityData
    public final Observable<Long> KClassImpl$Data$declaredNonStaticMembers$2() {
        Long l = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.getLong("LATEST_DATE_TO_CONSULT_BACKEND");
        Observable<Long> just = Observable.just(Long.valueOf(l == null ? 0L : l.longValue()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.twilio.repository.source.TwilioConsultBackendPreferencesEntityData
    public final Observable<Boolean> getAuthRequestContext(boolean p0) {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(p0)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.twilio.repository.source.TwilioConsultBackendPreferencesEntityData
    public final boolean MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
    }
}

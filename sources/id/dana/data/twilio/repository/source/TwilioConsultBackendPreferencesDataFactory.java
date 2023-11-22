package id.dana.data.twilio.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.twilio.repository.source.local.PreferencesTwilioConsultBackendEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/twilio/repository/source/TwilioConsultBackendPreferencesDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/twilio/repository/source/TwilioConsultBackendPreferencesEntityData;", "Lid/dana/data/twilio/repository/source/local/PreferencesTwilioConsultBackendEntityData;", "getAuthRequestContext", "Lid/dana/data/twilio/repository/source/local/PreferencesTwilioConsultBackendEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/data/twilio/repository/source/local/PreferencesTwilioConsultBackendEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TwilioConsultBackendPreferencesDataFactory extends AbstractEntityDataFactory<TwilioConsultBackendPreferencesEntityData> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final PreferencesTwilioConsultBackendEntityData KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public TwilioConsultBackendPreferencesDataFactory(PreferencesTwilioConsultBackendEntityData preferencesTwilioConsultBackendEntityData) {
        Intrinsics.checkNotNullParameter(preferencesTwilioConsultBackendEntityData, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = preferencesTwilioConsultBackendEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    public final /* bridge */ /* synthetic */ TwilioConsultBackendPreferencesEntityData createData(String str) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}

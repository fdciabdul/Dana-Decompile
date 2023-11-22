package id.dana.data.ipg.mapper;

import id.dana.data.ipg.repository.source.network.response.IpgRegistrationUrlResult;
import id.dana.domain.ipg.IpgRegistrationUrl;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/ipg/mapper/IpgRegistrationUrlMapper;", "", "Lid/dana/data/ipg/repository/source/network/response/IpgRegistrationUrlResult;", "ipgRegistrationUrlResult", "Lid/dana/domain/ipg/IpgRegistrationUrl;", "transform", "(Lid/dana/data/ipg/repository/source/network/response/IpgRegistrationUrlResult;)Lid/dana/domain/ipg/IpgRegistrationUrl;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IpgRegistrationUrlMapper {
    @Inject
    public IpgRegistrationUrlMapper() {
    }

    public final IpgRegistrationUrl transform(IpgRegistrationUrlResult ipgRegistrationUrlResult) {
        Intrinsics.checkNotNullParameter(ipgRegistrationUrlResult, "");
        return new IpgRegistrationUrl(ipgRegistrationUrlResult.getRedirectUrl(), ipgRegistrationUrlResult.getNeedUserConsent(), ipgRegistrationUrlResult.getUserConsentConfigKey(), ipgRegistrationUrlResult.getUserConsentSyncKey());
    }
}

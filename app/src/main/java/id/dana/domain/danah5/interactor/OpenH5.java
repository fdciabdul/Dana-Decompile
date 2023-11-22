package id.dana.domain.danah5.interactor;

import android.os.Bundle;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.danah5.H5Repository;
import id.dana.domain.danah5.model.H5UserDataEntity;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/danah5/interactor/OpenH5;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/danah5/model/H5UserDataEntity;", "Lid/dana/domain/danah5/interactor/OpenH5$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/danah5/interactor/OpenH5$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/danah5/H5Repository;", "repository", "Lid/dana/domain/danah5/H5Repository;", "<init>", "(Lid/dana/domain/danah5/H5Repository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OpenH5 extends BaseUseCase<H5UserDataEntity, Params> {
    private final H5Repository repository;

    @Inject
    public OpenH5(H5Repository h5Repository) {
        Intrinsics.checkNotNullParameter(h5Repository, "");
        this.repository = h5Repository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<H5UserDataEntity> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        H5Repository h5Repository = this.repository;
        String urlOrAppId = params.getUrlOrAppId();
        Bundle bundle = params.getBundle();
        if (bundle == null) {
            bundle = new Bundle(2);
        }
        return h5Repository.fetchConfigs(urlOrAppId, bundle, params.getFromResetPin());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/domain/danah5/interactor/OpenH5$Params;", "", "Landroid/os/Bundle;", HummerConstants.BUNDLE, "Landroid/os/Bundle;", "getBundle$domain_productionRelease", "()Landroid/os/Bundle;", "", "fromResetPin", "Z", "getFromResetPin$domain_productionRelease", "()Z", "", "urlOrAppId", "Ljava/lang/String;", "getUrlOrAppId$domain_productionRelease", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Landroid/os/Bundle;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final Bundle bundle;
        private final boolean fromResetPin;
        private final String urlOrAppId;

        public Params(String str, Bundle bundle, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            this.urlOrAppId = str;
            this.bundle = bundle;
            this.fromResetPin = z;
        }

        @JvmName(name = "getUrlOrAppId$domain_productionRelease")
        /* renamed from: getUrlOrAppId$domain_productionRelease  reason: from getter */
        public final String getUrlOrAppId() {
            return this.urlOrAppId;
        }

        @JvmName(name = "getBundle$domain_productionRelease")
        /* renamed from: getBundle$domain_productionRelease  reason: from getter */
        public final Bundle getBundle() {
            return this.bundle;
        }

        @JvmName(name = "getFromResetPin$domain_productionRelease")
        /* renamed from: getFromResetPin$domain_productionRelease  reason: from getter */
        public final boolean getFromResetPin() {
            return this.fromResetPin;
        }
    }
}

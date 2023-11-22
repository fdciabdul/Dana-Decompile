package id.dana.domain.login.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.login.LoginRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/login/interactor/SaveIsSessionChecked;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/login/interactor/SaveIsSessionChecked$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/login/interactor/SaveIsSessionChecked$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/login/LoginRepository;", "loginRepository", "Lid/dana/domain/login/LoginRepository;", "<init>", "(Lid/dana/domain/login/LoginRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveIsSessionChecked extends BaseUseCase<Boolean, Params> {
    private final LoginRepository loginRepository;

    @Inject
    public SaveIsSessionChecked(LoginRepository loginRepository) {
        Intrinsics.checkNotNullParameter(loginRepository, "");
        this.loginRepository = loginRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Boolean> saveIsSessionChecked = this.loginRepository.saveIsSessionChecked(Boolean.valueOf(params.isSessionChecked()));
        Intrinsics.checkNotNullExpressionValue(saveIsSessionChecked, "");
        return saveIsSessionChecked;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/domain/login/interactor/SaveIsSessionChecked$Params;", "", "", "component1", "()Z", "isSessionChecked", "copy", "(Z)Lid/dana/domain/login/interactor/SaveIsSessionChecked$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final boolean isSessionChecked;

        public static /* synthetic */ Params copy$default(Params params, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = params.isSessionChecked;
            }
            return params.copy(z);
        }

        /* renamed from: component1  reason: from getter */
        public final boolean getIsSessionChecked() {
            return this.isSessionChecked;
        }

        public final Params copy(boolean isSessionChecked) {
            return new Params(isSessionChecked);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && this.isSessionChecked == ((Params) other).isSessionChecked;
        }

        public final int hashCode() {
            boolean z = this.isSessionChecked;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(isSessionChecked=");
            sb.append(this.isSessionChecked);
            sb.append(')');
            return sb.toString();
        }

        public Params(boolean z) {
            this.isSessionChecked = z;
        }

        @JvmName(name = "isSessionChecked")
        public final boolean isSessionChecked() {
            return this.isSessionChecked;
        }
    }
}

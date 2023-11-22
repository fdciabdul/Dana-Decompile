package id.dana.domain.usereducation.interactor;

import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.usereducation.ShowDialogScenarios;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/usereducation/interactor/SaveShowDialog;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/usereducation/interactor/SaveShowDialog$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/usereducation/interactor/SaveShowDialog$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/usereducation/repository/UserEducationRepository;", "userEducationRepository", "Lid/dana/domain/usereducation/repository/UserEducationRepository;", "<init>", "(Lid/dana/domain/usereducation/repository/UserEducationRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveShowDialog extends BaseUseCase<Boolean, Params> {
    private final UserEducationRepository userEducationRepository;

    @Inject
    public SaveShowDialog(UserEducationRepository userEducationRepository) {
        Intrinsics.checkNotNullParameter(userEducationRepository, "");
        this.userEducationRepository = userEducationRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Boolean> saveShowDialog = this.userEducationRepository.saveShowDialog(params.getShow(), params.getScenario());
        Intrinsics.checkNotNullExpressionValue(saveShowDialog, "");
        return saveShowDialog;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001b\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/usereducation/interactor/SaveShowDialog$Params;", "", "", "scenario", "Ljava/lang/String;", "getScenario", "()Ljava/lang/String;", "", ContainerUIProvider.KEY_SHOW, "Z", "getShow", "()Z", "<init>", "(ZLjava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String scenario;
        private final boolean show;

        public /* synthetic */ Params(boolean z, String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, str);
        }

        private Params(boolean z, @ShowDialogScenarios String str) {
            this.show = z;
            this.scenario = str;
        }

        @JvmName(name = "getShow")
        public final boolean getShow() {
            return this.show;
        }

        @JvmName(name = "getScenario")
        public final String getScenario() {
            return this.scenario;
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/domain/usereducation/interactor/SaveShowDialog$Params$Companion;", "", "", ContainerUIProvider.KEY_SHOW, "", "scenario", "Lid/dana/domain/usereducation/interactor/SaveShowDialog$Params;", "forShowDialog", "(ZLjava/lang/String;)Lid/dana/domain/usereducation/interactor/SaveShowDialog$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Params forShowDialog(boolean show, @ShowDialogScenarios String scenario) {
                Intrinsics.checkNotNullParameter(scenario, "");
                return new Params(show, scenario, null);
            }
        }
    }
}

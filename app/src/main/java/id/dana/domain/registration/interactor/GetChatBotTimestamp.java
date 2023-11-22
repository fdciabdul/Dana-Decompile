package id.dana.domain.registration.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.registration.RegistrationRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/registration/interactor/GetChatBotTimestamp;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/registration/interactor/GetChatBotTimestamp$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/registration/interactor/GetChatBotTimestamp$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/registration/RegistrationRepository;", "registrationRepository", "Lid/dana/domain/registration/RegistrationRepository;", "<init>", "(Lid/dana/domain/registration/RegistrationRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetChatBotTimestamp extends BaseUseCase<Long, Params> {
    private final RegistrationRepository registrationRepository;

    @Inject
    public GetChatBotTimestamp(RegistrationRepository registrationRepository) {
        Intrinsics.checkNotNullParameter(registrationRepository, "");
        this.registrationRepository = registrationRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Long> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Long> chatBotTimestamp = this.registrationRepository.getChatBotTimestamp(params.getChatBotEntry());
        Intrinsics.checkNotNullExpressionValue(chatBotTimestamp, "");
        return chatBotTimestamp;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/registration/interactor/GetChatBotTimestamp$Params;", "", "", "chatBotEntry", "Ljava/lang/String;", "getChatBotEntry", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final String chatBotEntry;

        public Params(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.chatBotEntry = str;
        }

        @JvmName(name = "getChatBotEntry")
        public final String getChatBotEntry() {
            return this.chatBotEntry;
        }
    }
}

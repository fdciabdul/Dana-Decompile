package id.dana.domain.registration.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.registration.RegistrationRepository;
import io.reactivex.Observable;
import java.io.File;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/registration/interactor/CreateProfile;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/registration/interactor/CreateProfile$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/registration/interactor/CreateProfile$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/registration/RegistrationRepository;", "registrationRepository", "Lid/dana/domain/registration/RegistrationRepository;", "<init>", "(Lid/dana/domain/registration/RegistrationRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CreateProfile extends BaseUseCase<Boolean, Params> {
    private final RegistrationRepository registrationRepository;

    @Inject
    public CreateProfile(RegistrationRepository registrationRepository) {
        Intrinsics.checkNotNullParameter(registrationRepository, "");
        this.registrationRepository = registrationRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Boolean> register = this.registrationRepository.register(params.getPhoneNumber(), params.getPin(), params.getNickname(), params.getAvatarFile(), params.getReferralCode());
        Intrinsics.checkNotNullExpressionValue(register, "");
        return register;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JL\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b \u0010\u0004"}, d2 = {"Lid/dana/domain/registration/interactor/CreateProfile$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Ljava/io/File;", "component4", "()Ljava/io/File;", "component5", "phoneNumber", "pin", "nickname", "avatarFile", "referralCode", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)Lid/dana/domain/registration/interactor/CreateProfile$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/io/File;", "getAvatarFile", "Ljava/lang/String;", "getNickname", "getPhoneNumber", "getPin", "getReferralCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final File avatarFile;
        private final String nickname;
        private final String phoneNumber;
        private final String pin;
        private final String referralCode;

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, String str3, File file, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.phoneNumber;
            }
            if ((i & 2) != 0) {
                str2 = params.pin;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = params.nickname;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                file = params.avatarFile;
            }
            File file2 = file;
            if ((i & 16) != 0) {
                str4 = params.referralCode;
            }
            return params.copy(str, str5, str6, file2, str4);
        }

        /* renamed from: component1  reason: from getter */
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        /* renamed from: component2  reason: from getter */
        public final String getPin() {
            return this.pin;
        }

        /* renamed from: component3  reason: from getter */
        public final String getNickname() {
            return this.nickname;
        }

        /* renamed from: component4  reason: from getter */
        public final File getAvatarFile() {
            return this.avatarFile;
        }

        /* renamed from: component5  reason: from getter */
        public final String getReferralCode() {
            return this.referralCode;
        }

        public final Params copy(String phoneNumber, String pin, String nickname, File avatarFile, String referralCode) {
            return new Params(phoneNumber, pin, nickname, avatarFile, referralCode);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.phoneNumber, params.phoneNumber) && Intrinsics.areEqual(this.pin, params.pin) && Intrinsics.areEqual(this.nickname, params.nickname) && Intrinsics.areEqual(this.avatarFile, params.avatarFile) && Intrinsics.areEqual(this.referralCode, params.referralCode);
            }
            return false;
        }

        public final int hashCode() {
            String str = this.phoneNumber;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.pin;
            int hashCode2 = str2 == null ? 0 : str2.hashCode();
            String str3 = this.nickname;
            int hashCode3 = str3 == null ? 0 : str3.hashCode();
            File file = this.avatarFile;
            int hashCode4 = file == null ? 0 : file.hashCode();
            String str4 = this.referralCode;
            return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str4 != null ? str4.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(phoneNumber=");
            sb.append(this.phoneNumber);
            sb.append(", pin=");
            sb.append(this.pin);
            sb.append(", nickname=");
            sb.append(this.nickname);
            sb.append(", avatarFile=");
            sb.append(this.avatarFile);
            sb.append(", referralCode=");
            sb.append(this.referralCode);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, String str3, File file, String str4) {
            this.phoneNumber = str;
            this.pin = str2;
            this.nickname = str3;
            this.avatarFile = file;
            this.referralCode = str4;
        }

        @JvmName(name = "getPhoneNumber")
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        @JvmName(name = "getPin")
        public final String getPin() {
            return this.pin;
        }

        @JvmName(name = "getNickname")
        public final String getNickname() {
            return this.nickname;
        }

        @JvmName(name = "getAvatarFile")
        public final File getAvatarFile() {
            return this.avatarFile;
        }

        @JvmName(name = "getReferralCode")
        public final String getReferralCode() {
            return this.referralCode;
        }
    }
}

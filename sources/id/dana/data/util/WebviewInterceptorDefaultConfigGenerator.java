package id.dana.data.util;

import id.dana.data.webviewinterceptor.model.WebviewInterceptorEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/util/WebviewInterceptorDefaultConfigGenerator;", "", "Lid/dana/data/webviewinterceptor/model/WebviewInterceptorEntity;", "createBcaOneKlikBindFailed", "()Lid/dana/data/webviewinterceptor/model/WebviewInterceptorEntity;", "createBcaOneKlikBindSuccess", "createBcaOpeningBankAccountRegistration", "createBcaOpeningBankAccountRegistrationSuccess", "", "createWebviewInterceptor", "()Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WebviewInterceptorDefaultConfigGenerator {
    public static final WebviewInterceptorDefaultConfigGenerator INSTANCE = new WebviewInterceptorDefaultConfigGenerator();

    private WebviewInterceptorDefaultConfigGenerator() {
    }

    public final List<WebviewInterceptorEntity> createWebviewInterceptor() {
        return CollectionsKt.listOf((Object[]) new WebviewInterceptorEntity[]{createBcaOneKlikBindSuccess(), createBcaOneKlikBindFailed(), createBcaOpeningBankAccountRegistration(), createBcaOpeningBankAccountRegistrationSuccess()});
    }

    private final WebviewInterceptorEntity createBcaOneKlikBindSuccess() {
        return new WebviewInterceptorEntity("BCA_ONE_KLIK_BIND_SUCCESS_URL", "https://registrasi.klikbca.com/en/OneKlik/registrasi/success", "https://play.google.com/store/apps/details?id=com.bca");
    }

    private final WebviewInterceptorEntity createBcaOneKlikBindFailed() {
        return new WebviewInterceptorEntity("BCA_ONE_KLIK_BIND_FAILED_URL", "https://registrasi.klikbca.com/en/OneKlik/registrasi/failed", null, 4, null);
    }

    private final WebviewInterceptorEntity createBcaOpeningBankAccountRegistration() {
        return new WebviewInterceptorEntity("BCA_OPENING_BANK_ACCOUNT_REGISTRATION_URL", "https://webform.bca.co.id/apply-online/bukarekening/form1", null, 4, null);
    }

    private final WebviewInterceptorEntity createBcaOpeningBankAccountRegistrationSuccess() {
        return new WebviewInterceptorEntity("BCA_OPENING_BANK_ACCOUNT_REGISTRATION_SUCCESS_URL", "https://webform.bca.co.id/apply-online/bukarekening/ThankYouPage", null, 4, null);
    }
}

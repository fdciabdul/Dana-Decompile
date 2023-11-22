package id.dana.domain.deeplink.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.splitbill.model.SplitBill;
import id.dana.domain.splitbill.model.SplitBillDeeplink;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GenerateSplitBillQrDeepLink extends UseCase<SplitBillDeeplink, Params> {
    private GenerateLinkRepository generateLinkRepository;

    @Inject
    public GenerateSplitBillQrDeepLink(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GenerateLinkRepository generateLinkRepository) {
        super(threadExecutor, postExecutionThread);
        this.generateLinkRepository = generateLinkRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<SplitBillDeeplink> buildUseCaseObservable(Params params) {
        return this.generateLinkRepository.generateSplitBillQrDeepLink(params.splitBill, params.deepLinkTitle, params.deepLinkDescription);
    }

    /* loaded from: classes4.dex */
    public static final class Params {
        private final String deepLinkDescription;
        private final String deepLinkTitle;
        private final SplitBill splitBill;

        private Params(SplitBill splitBill, String str, String str2) {
            this.splitBill = splitBill;
            this.deepLinkDescription = str;
            this.deepLinkTitle = str2;
        }

        public static Params forParams(SplitBill splitBill, String str, String str2) {
            return new Params(splitBill, str2, str);
        }
    }
}

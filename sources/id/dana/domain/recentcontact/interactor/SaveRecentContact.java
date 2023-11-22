package id.dana.domain.recentcontact.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.recentrecipient.model.RecentContactRecipient;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SaveRecentContact extends UseCase<Boolean, Params> {
    private RecentRecipientRepository recentRecipientRepository;

    @Inject
    public SaveRecentContact(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RecentRecipientRepository recentRecipientRepository) {
        super(threadExecutor, postExecutionThread);
        this.recentRecipientRepository = recentRecipientRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.recentRecipientRepository.saveRecentContact(params.toRecentContactRecipient(), params.isUpdate);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private boolean isFavorite;
        private boolean isUpdate;
        private String payeeAvatar;
        private String payeeLoginId;
        private String payeeNickname;
        private String payeeUserId;
        private int transactionCount;

        private Params(String str, String str2, String str3, String str4, int i, boolean z, boolean z2) {
            this.payeeNickname = str;
            this.payeeLoginId = str2;
            this.payeeUserId = str3;
            this.payeeAvatar = str4;
            this.transactionCount = i;
            this.isFavorite = z;
            this.isUpdate = z2;
        }

        public static Params forSaveRecentContact(String str, String str2, String str3, String str4, int i, boolean z) {
            return new Params(str, str2, str3, str4, i, z, false);
        }

        public static Params forUpdateRecentContact(String str, String str2, String str3, String str4, int i, boolean z) {
            return new Params(str, str2, str3, str4, i, z, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RecentContactRecipient toRecentContactRecipient() {
            return new RecentContactRecipient(this.payeeUserId, this.payeeLoginId, this.payeeNickname, this.payeeAvatar, this.transactionCount, this.isFavorite);
        }
    }
}

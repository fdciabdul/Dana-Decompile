package id.dana.domain.recentbank.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.recentrecipient.model.RecentBankRecipient;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SaveRecentBank extends UseCase<Boolean, Params> {
    private final RecentRecipientRepository recentRecipientRepository;

    @Inject
    public SaveRecentBank(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RecentRecipientRepository recentRecipientRepository) {
        super(threadExecutor, postExecutionThread);
        this.recentRecipientRepository = recentRecipientRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.recentRecipientRepository.saveRecentBank(params.toRecentRecipient(), params.isUpdate);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String alias;
        private String bankLogo;
        private String bankName;
        private String bankNumber;
        private String cardIndexNo;
        private String formattedMaskNumber;
        private String instId;
        private String instLocalName;
        private boolean isFavorite;
        private boolean isUpdate;
        private Long lastUpdated;
        private String payMethod;
        private String payOption;
        private String prefix;
        private String recipientName;
        private String senderName;
        private int transactionCount;

        private Params(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, Long l, boolean z, boolean z2) {
            this.recipientName = str;
            this.bankName = str2;
            this.bankNumber = str3;
            this.bankLogo = str4;
            this.alias = str5;
            this.instId = str6;
            this.instLocalName = str7;
            this.payMethod = str8;
            this.payOption = str9;
            this.senderName = str10;
            this.cardIndexNo = str11;
            this.formattedMaskNumber = str12;
            this.prefix = str13;
            this.transactionCount = i;
            this.lastUpdated = l;
            this.isFavorite = z;
            this.isUpdate = z2;
        }

        public static Params forSaveRecentBank(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, boolean z) {
            return new Params(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, i, null, z, false);
        }

        public static Params forUpdateRecentBank(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, Long l, boolean z) {
            return new Params(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, i, l, z, true);
        }

        public RecentBankRecipient toRecentRecipient() {
            return new RecentBankRecipient(this.recipientName, this.bankNumber, this.bankName, this.bankLogo, this.alias, this.instId, this.instLocalName, this.payMethod, this.payOption, this.senderName, this.cardIndexNo, this.formattedMaskNumber, this.prefix, this.transactionCount, this.lastUpdated, this.isFavorite);
        }
    }
}

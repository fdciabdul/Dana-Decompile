package id.dana.domain.synccontact.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.sendmoney.model.UserContact;
import id.dana.domain.synccontact.SyncContactRepository;
import id.dana.domain.synccontact.model.Contact;
import id.dana.domain.synccontact.model.SyncContactSplitConfigModel;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class SyncContact extends UseCase<Boolean, Params> {
    private final FeatureConfigRepository featureConfigRepository;
    private final SyncContactRepository syncContactRepository;

    @Inject
    public SyncContact(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SyncContactRepository syncContactRepository, FeatureConfigRepository featureConfigRepository) {
        super(threadExecutor, postExecutionThread);
        this.syncContactRepository = syncContactRepository;
        this.featureConfigRepository = featureConfigRepository;
    }

    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(final Params params) {
        return this.featureConfigRepository.getSyncContactWithNameConfig().flatMap(new Function() { // from class: id.dana.domain.synccontact.interactor.SyncContact$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SyncContact.this.m2503x612c6568(params, (SyncContactSplitConfigModel) obj);
            }
        });
    }

    /* renamed from: chooseContactToSend */
    public Observable<Boolean> m2503x612c6568(Params params, SyncContactSplitConfigModel syncContactSplitConfigModel) {
        if (syncContactSplitConfigModel.getSendMoneySync()) {
            params.phoneNumbers = null;
        } else {
            params.phoneNumbersWithName = null;
        }
        return this.syncContactRepository.syncContact(params.phoneNumbers, params.lastContact, params.phoneNumbersWithName);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private Contact lastContact;
        private List<String> phoneNumbers;
        private List<UserContact> phoneNumbersWithName;

        private Params(List<String> list, Contact contact, List<UserContact> list2) {
            this.phoneNumbers = list;
            this.lastContact = contact;
            this.phoneNumbersWithName = list2;
        }

        public static Params forSyncContact(List<String> list, Contact contact, List<UserContact> list2) {
            return new Params(list, contact, list2);
        }
    }
}

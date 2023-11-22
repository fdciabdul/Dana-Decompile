package id.dana.domain.synccontact.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.sendmoney.model.UserContact;
import id.dana.domain.synccontact.SyncContactRepository;
import id.dana.domain.synccontact.model.SyncContactSplitConfigModel;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SyncOneContact extends UseCase<Boolean, Params> {
    private final FeatureConfigRepository featureConfigRepository;
    private final SyncContactRepository syncContactRepository;

    @Inject
    public SyncOneContact(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SyncContactRepository syncContactRepository, FeatureConfigRepository featureConfigRepository) {
        super(threadExecutor, postExecutionThread);
        this.syncContactRepository = syncContactRepository;
        this.featureConfigRepository = featureConfigRepository;
    }

    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(final Params params) {
        return this.featureConfigRepository.getSyncContactWithNameConfig().flatMap(new Function() { // from class: id.dana.domain.synccontact.interactor.SyncOneContact$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SyncOneContact.this.m2504x5e1e0892(params, (SyncContactSplitConfigModel) obj);
            }
        });
    }

    /* renamed from: lambda$buildUseCaseObservable$0$id-dana-domain-synccontact-interactor-SyncOneContact */
    public /* synthetic */ ObservableSource m2504x5e1e0892(Params params, SyncContactSplitConfigModel syncContactSplitConfigModel) throws Exception {
        return chooseContactToSend(params, Boolean.valueOf(syncContactSplitConfigModel.getReferralSync()));
    }

    private Observable<Boolean> chooseContactToSend(Params params, Boolean bool) {
        if (bool.booleanValue()) {
            params.phoneNumber = null;
        } else {
            params.phoneNumberWithName = null;
        }
        return this.syncContactRepository.syncOneContact(params.phoneNumber, params.phoneNumberWithName);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String phoneNumber;
        private UserContact phoneNumberWithName;

        private Params(String str, UserContact userContact) {
            this.phoneNumber = str;
            this.phoneNumberWithName = userContact;
        }

        public static Params forSyncOneContact(String str, UserContact userContact) {
            return new Params(str, userContact);
        }
    }
}

package id.dana.data.deeplink.repository.source.branch;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import id.dana.data.deeplink.DeeplinkException;
import id.dana.data.deeplink.repository.source.DeepLinkEntityData;
import id.dana.data.deeplink.repository.source.branch.mapper.BranchIoDeepLinkEntityMapper;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity;
import id.dana.utils.deeplink.BranchDeeplinkUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerRequestIdentifyUserRequest;
import io.branch.referral.ServerRequestLogout;
import io.branch.referral.util.BRANCH_STANDARD_EVENT;
import io.branch.referral.util.BranchEvent;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* loaded from: classes2.dex */
public class BranchDeepLinkEntityData implements DeepLinkEntityData {
    private static final String EMPTY_OBJ_JSON = "{}";
    private final Branch branch;
    private final BranchIoDeepLinkEntityMapper branchIoDeepLinkEntityMapper;
    private final Context context;

    @Inject
    public BranchDeepLinkEntityData(Context context, Branch branch, BranchIoDeepLinkEntityMapper branchIoDeepLinkEntityMapper) {
        this.context = context;
        this.branch = branch;
        this.branchIoDeepLinkEntityMapper = branchIoDeepLinkEntityMapper;
    }

    @Override // id.dana.data.deeplink.repository.source.DeepLinkEntityData
    public Observable<DeepLinkPayloadEntity> initSession(final Activity activity) {
        if (BranchDeeplinkUtil.getAuthRequestContext(activity)) {
            return Observable.defer(new Callable() { // from class: id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData$$ExternalSyntheticLambda7
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return BranchDeepLinkEntityData.this.m1189xb0b1ff55(activity);
                }
            });
        }
        return Observable.defer(new Callable() { // from class: id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BranchDeepLinkEntityData.this.m1192x5d5b458(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initSession$2$id-dana-data-deeplink-repository-source-branch-BranchDeepLinkEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1189xb0b1ff55(final Activity activity) throws Exception {
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData$$ExternalSyntheticLambda10
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                BranchDeepLinkEntityData.this.m1188xe9a61854(activity, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initSession$1$id-dana-data-deeplink-repository-source-branch-BranchDeepLinkEntityData  reason: not valid java name */
    public /* synthetic */ void m1188xe9a61854(final Activity activity, final ObservableEmitter observableEmitter) throws Exception {
        this.branch.PlaceComponentResult(activity, new Branch.BranchReferralInitListener() { // from class: id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData$$ExternalSyntheticLambda14
            @Override // io.branch.referral.Branch.BranchReferralInitListener
            public final void onInitFinished(JSONObject jSONObject, BranchError branchError) {
                BranchDeepLinkEntityData.this.m1187x229a3153(observableEmitter, activity, jSONObject, branchError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initSession$5$id-dana-data-deeplink-repository-source-branch-BranchDeepLinkEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1192x5d5b458(final Activity activity) throws Exception {
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                BranchDeepLinkEntityData.this.m1191x3ec9cd57(activity, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initSession$4$id-dana-data-deeplink-repository-source-branch-BranchDeepLinkEntityData  reason: not valid java name */
    public /* synthetic */ void m1191x3ec9cd57(final Activity activity, final ObservableEmitter observableEmitter) throws Exception {
        this.branch.PlaceComponentResult(new Branch.BranchReferralInitListener() { // from class: id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData$$ExternalSyntheticLambda6
            @Override // io.branch.referral.Branch.BranchReferralInitListener
            public final void onInitFinished(JSONObject jSONObject, BranchError branchError) {
                BranchDeepLinkEntityData.this.m1190x77bde656(observableEmitter, activity, jSONObject, branchError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleBranchInitCallback  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void m1190x77bde656(JSONObject jSONObject, BranchError branchError, ObservableEmitter<DeepLinkPayloadEntity> observableEmitter, Activity activity) {
        if (branchError == null) {
            if (!EMPTY_OBJ_JSON.equalsIgnoreCase(jSONObject.toString())) {
                if (jSONObject.has("~referring_link")) {
                    observableEmitter.onNext(this.branchIoDeepLinkEntityMapper.apply(jSONObject));
                    observableEmitter.onComplete();
                    return;
                }
                observableEmitter.onError(new DeeplinkException("", "referringParams not has ~referring_link", getUrl(activity)));
                return;
            }
            observableEmitter.onError(new NullPointerException("empty object"));
            return;
        }
        observableEmitter.onError(new DeeplinkException(String.valueOf(branchError.MyBillsEntityDataFactory), branchError.BuiltInFictitiousFunctionClassFactory, getUrl(activity)));
    }

    @Override // id.dana.data.deeplink.repository.source.DeepLinkEntityData
    public Observable<DeepLinkPayloadEntity> getDeepLinkPayload() {
        return Observable.defer(new Callable() { // from class: id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BranchDeepLinkEntityData.this.m1186x85383b3f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getDeepLinkPayload$6$id-dana-data-deeplink-repository-source-branch-BranchDeepLinkEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1186x85383b3f() throws Exception {
        Branch branch = this.branch;
        PrefHelper prefHelper = branch.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Observable just = Observable.just(branch.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params"))));
        final BranchIoDeepLinkEntityMapper branchIoDeepLinkEntityMapper = this.branchIoDeepLinkEntityMapper;
        Objects.requireNonNull(branchIoDeepLinkEntityMapper);
        return just.map(new Function() { // from class: id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BranchIoDeepLinkEntityMapper.this.apply((JSONObject) obj);
            }
        });
    }

    @Override // id.dana.data.deeplink.repository.source.DeepLinkEntityData
    public Observable<Boolean> completeRegistration(final String str, final String str2) {
        return Observable.defer(new Callable() { // from class: id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BranchDeepLinkEntityData.this.m1185xfafff220(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$completeRegistration$7$id-dana-data-deeplink-repository-source-branch-BranchDeepLinkEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1185xfafff220(String str, String str2) throws Exception {
        return Observable.just(Boolean.valueOf(new BranchEvent(BRANCH_STANDARD_EVENT.COMPLETE_REGISTRATION).MyBillsEntityDataFactory("isUsingReferral", Boolean.toString(!TextUtils.isEmpty(str))).MyBillsEntityDataFactory("UserID", str2).MyBillsEntityDataFactory("referralCode", str).BuiltInFictitiousFunctionClassFactory(this.context)));
    }

    @Override // id.dana.data.deeplink.repository.source.DeepLinkEntityData
    public Observable<DeepLinkPayloadEntity> login(final String str) {
        return Observable.defer(new Callable() { // from class: id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData$$ExternalSyntheticLambda12
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BranchDeepLinkEntityData.this.m1193xc874c475(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$login$10$id-dana-data-deeplink-repository-source-branch-BranchDeepLinkEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1193xc874c475(final String str) throws Exception {
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                BranchDeepLinkEntityData.this.m1195xea6282df(str, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$login$9$id-dana-data-deeplink-repository-source-branch-BranchDeepLinkEntityData  reason: not valid java name */
    public /* synthetic */ void m1195xea6282df(String str, final ObservableEmitter observableEmitter) throws Exception {
        Branch branch = this.branch;
        ServerRequestIdentifyUserRequest serverRequestIdentifyUserRequest = new ServerRequestIdentifyUserRequest(branch.PlaceComponentResult, new Branch.BranchReferralInitListener() { // from class: id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData$$ExternalSyntheticLambda1
            @Override // io.branch.referral.Branch.BranchReferralInitListener
            public final void onInitFinished(JSONObject jSONObject, BranchError branchError) {
                BranchDeepLinkEntityData.this.m1194x23569bde(observableEmitter, jSONObject, branchError);
            }
        }, str);
        if (!serverRequestIdentifyUserRequest.MyBillsEntityDataFactory && !serverRequestIdentifyUserRequest.getAuthRequestContext(branch.PlaceComponentResult)) {
            branch.getAuthRequestContext(serverRequestIdentifyUserRequest);
        } else if (serverRequestIdentifyUserRequest.initRecordTimeStamp()) {
            Branch branch2 = Branch.BuiltInFictitiousFunctionClassFactory;
            Branch.BranchReferralInitListener branchReferralInitListener = serverRequestIdentifyUserRequest.scheduleImpl;
            if (branchReferralInitListener != null) {
                PrefHelper prefHelper = branch2.NetworkUserEntityData$$ExternalSyntheticLambda1;
                branchReferralInitListener.onInitFinished(branch2.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_install_params"))), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$login$8$id-dana-data-deeplink-repository-source-branch-BranchDeepLinkEntityData  reason: not valid java name */
    public /* synthetic */ void m1194x23569bde(ObservableEmitter observableEmitter, JSONObject jSONObject, BranchError branchError) {
        if (branchError == null) {
            observableEmitter.onNext(this.branchIoDeepLinkEntityMapper.apply(jSONObject));
            observableEmitter.onComplete();
            return;
        }
        observableEmitter.onError(new Error(createErrorDesc(branchError)));
    }

    @Override // id.dana.data.deeplink.repository.source.DeepLinkEntityData
    public Observable<Boolean> logout() {
        return Observable.defer(new Callable() { // from class: id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BranchDeepLinkEntityData.this.m1198x92da8ddd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$logout$13$id-dana-data-deeplink-repository-source-branch-BranchDeepLinkEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1198x92da8ddd() throws Exception {
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                BranchDeepLinkEntityData.this.m1197xcbcea6dc(observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$logout$12$id-dana-data-deeplink-repository-source-branch-BranchDeepLinkEntityData  reason: not valid java name */
    public /* synthetic */ void m1197xcbcea6dc(final ObservableEmitter observableEmitter) throws Exception {
        Branch branch = this.branch;
        ServerRequestLogout serverRequestLogout = new ServerRequestLogout(branch.PlaceComponentResult, new Branch.LogoutStatusListener() { // from class: id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData$$ExternalSyntheticLambda11
            @Override // io.branch.referral.Branch.LogoutStatusListener
            public final void onLogoutFinished(boolean z, BranchError branchError) {
                BranchDeepLinkEntityData.this.m1196x4c2bfdb(observableEmitter, z, branchError);
            }
        });
        if (serverRequestLogout.MyBillsEntityDataFactory || serverRequestLogout.getAuthRequestContext(branch.PlaceComponentResult)) {
            return;
        }
        branch.getAuthRequestContext(serverRequestLogout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$logout$11$id-dana-data-deeplink-repository-source-branch-BranchDeepLinkEntityData  reason: not valid java name */
    public /* synthetic */ void m1196x4c2bfdb(ObservableEmitter observableEmitter, boolean z, BranchError branchError) {
        if (branchError == null) {
            observableEmitter.onNext(Boolean.valueOf(z));
            observableEmitter.onComplete();
            return;
        }
        observableEmitter.onError(new Error(createErrorDesc(branchError)));
    }

    private String createErrorDesc(BranchError branchError) {
        StringBuilder sb = new StringBuilder();
        sb.append(DanaLogConstants.Prefix.DEEPLINK_PREFIX);
        sb.append(branchError.MyBillsEntityDataFactory);
        sb.append("-");
        sb.append(branchError.BuiltInFictitiousFunctionClassFactory);
        String obj = sb.toString();
        DanaLog.getAuthRequestContext(DanaLogConstants.TAG.DEEPLINK_TAG, obj);
        return obj;
    }

    private String getUrl(Activity activity) {
        return (activity.getIntent() == null || activity.getIntent().getData() == null) ? "" : activity.getIntent().getData().toString();
    }
}

package id.dana.data.account.general.repository.source.preference;

import dagger.Lazy;
import id.dana.data.account.general.repository.GeneralEntityData;
import id.dana.data.storage.GeneralPreferences;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.subjects.BehaviorSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%¢\u0006\u0004\b.\u0010/J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0012J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u000bJ\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u001cJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u001cJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u0007R\u001e\u0010\"\u001a\f\u0012\b\u0012\u0006*\u00020\u00050\u00050!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001e\u0010$\u001a\f\u0012\b\u0012\u0006*\u00020\u00050\u00050!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010)\u001a\f\u0012\b\u0012\u0006*\u00020\u00050\u00050!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010#R\u001e\u0010*\u001a\f\u0012\b\u0012\u0006*\u00020\u00050\u00050!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010#R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-"}, d2 = {"Lid/dana/data/account/general/repository/source/preference/PreferenceGeneralEntityData;", "Lid/dana/data/account/general/repository/GeneralEntityData;", "", "contentId", "Lio/reactivex/Observable;", "", "checkReadInterstitialBanner", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "resetTimeSettings", "checkResetInterstitialBannerReadList", "(J)Lio/reactivex/Observable;", "gapTimeSettings", "checkShouldShowInterstitialBanner", "", "clearAll", "()V", "getBalanceVisibility", "()Lio/reactivex/Observable;", "getEmasBalanceVisibility", "getGoalsBalanceVisibility", "getInvestmentBalanceVisibility", "gapTimeInUnix", "saveInterstitialBannerNextGapTime", "resetTimeInUnix", "saveInterstitialBannerNextResetTime", "newState", "setBalanceVisibility", "(Z)Lio/reactivex/Observable;", "setEmasBalanceVisibility", "setGoalsBalanceVisibility", "setInvestmentBalanceVisibility", "setReadInterstitialBanner", "Lio/reactivex/subjects/BehaviorSubject;", "balanceVisibility", "Lio/reactivex/subjects/BehaviorSubject;", "emasBalanceVisibility", "Ldagger/Lazy;", "Lid/dana/data/storage/GeneralPreferences;", "generalPreferences", "Ldagger/Lazy;", "goalsBalanceVisibility", "investmentBalanceVisibility", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "<init>", "(Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreferenceGeneralEntityData implements GeneralEntityData {
    private final BehaviorSubject<Boolean> balanceVisibility;
    private final BehaviorSubject<Boolean> emasBalanceVisibility;
    private final Lazy<GeneralPreferences> generalPreferences;
    private final BehaviorSubject<Boolean> goalsBalanceVisibility;
    private final BehaviorSubject<Boolean> investmentBalanceVisibility;
    private final ReentrantLock lock;

    @Inject
    public PreferenceGeneralEntityData(Lazy<GeneralPreferences> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.generalPreferences = lazy;
        BehaviorSubject<Boolean> BuiltInFictitiousFunctionClassFactory = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        this.balanceVisibility = BuiltInFictitiousFunctionClassFactory;
        BehaviorSubject<Boolean> BuiltInFictitiousFunctionClassFactory2 = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
        this.goalsBalanceVisibility = BuiltInFictitiousFunctionClassFactory2;
        BehaviorSubject<Boolean> BuiltInFictitiousFunctionClassFactory3 = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory3, "");
        this.investmentBalanceVisibility = BuiltInFictitiousFunctionClassFactory3;
        BehaviorSubject<Boolean> BuiltInFictitiousFunctionClassFactory4 = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory4, "");
        this.emasBalanceVisibility = BuiltInFictitiousFunctionClassFactory4;
        this.lock = new ReentrantLock();
    }

    @Override // id.dana.data.account.general.repository.GeneralEntityData
    public final Observable<String> setReadInterstitialBanner(final String contentId) {
        Intrinsics.checkNotNullParameter(contentId, "");
        Observable<String> defer = Observable.defer(new Callable() { // from class: id.dana.data.account.general.repository.source.preference.PreferenceGeneralEntityData$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m753setReadInterstitialBanner$lambda1;
                m753setReadInterstitialBanner$lambda1 = PreferenceGeneralEntityData.m753setReadInterstitialBanner$lambda1(PreferenceGeneralEntityData.this, contentId);
                return m753setReadInterstitialBanner$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setReadInterstitialBanner$lambda-1  reason: not valid java name */
    public static final ObservableSource m753setReadInterstitialBanner$lambda1(final PreferenceGeneralEntityData preferenceGeneralEntityData, final String str) {
        Intrinsics.checkNotNullParameter(preferenceGeneralEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.account.general.repository.source.preference.PreferenceGeneralEntityData$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String m754setReadInterstitialBanner$lambda1$lambda0;
                m754setReadInterstitialBanner$lambda1$lambda0 = PreferenceGeneralEntityData.m754setReadInterstitialBanner$lambda1$lambda0(PreferenceGeneralEntityData.this, str);
                return m754setReadInterstitialBanner$lambda1$lambda0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setReadInterstitialBanner$lambda-1$lambda-0  reason: not valid java name */
    public static final String m754setReadInterstitialBanner$lambda1$lambda0(PreferenceGeneralEntityData preferenceGeneralEntityData, String str) {
        Intrinsics.checkNotNullParameter(preferenceGeneralEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return preferenceGeneralEntityData.generalPreferences.get().addInterstitialBannerReadList(str);
    }

    @Override // id.dana.data.account.general.repository.GeneralEntityData
    public final Observable<Boolean> checkReadInterstitialBanner(final String contentId) {
        Intrinsics.checkNotNullParameter(contentId, "");
        Observable<Boolean> defer = Observable.defer(new Callable() { // from class: id.dana.data.account.general.repository.source.preference.PreferenceGeneralEntityData$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m743checkReadInterstitialBanner$lambda3;
                m743checkReadInterstitialBanner$lambda3 = PreferenceGeneralEntityData.m743checkReadInterstitialBanner$lambda3(PreferenceGeneralEntityData.this, contentId);
                return m743checkReadInterstitialBanner$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkReadInterstitialBanner$lambda-3  reason: not valid java name */
    public static final ObservableSource m743checkReadInterstitialBanner$lambda3(final PreferenceGeneralEntityData preferenceGeneralEntityData, final String str) {
        Intrinsics.checkNotNullParameter(preferenceGeneralEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.account.general.repository.source.preference.PreferenceGeneralEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m744checkReadInterstitialBanner$lambda3$lambda2;
                m744checkReadInterstitialBanner$lambda3$lambda2 = PreferenceGeneralEntityData.m744checkReadInterstitialBanner$lambda3$lambda2(PreferenceGeneralEntityData.this, str);
                return m744checkReadInterstitialBanner$lambda3$lambda2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkReadInterstitialBanner$lambda-3$lambda-2  reason: not valid java name */
    public static final Boolean m744checkReadInterstitialBanner$lambda3$lambda2(PreferenceGeneralEntityData preferenceGeneralEntityData, String str) {
        Intrinsics.checkNotNullParameter(preferenceGeneralEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return preferenceGeneralEntityData.generalPreferences.get().checkBannerReadList(str);
    }

    @Override // id.dana.data.account.general.repository.GeneralEntityData
    public final Observable<Boolean> checkShouldShowInterstitialBanner(final long gapTimeSettings) {
        Observable<Boolean> defer = Observable.defer(new Callable() { // from class: id.dana.data.account.general.repository.source.preference.PreferenceGeneralEntityData$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m747checkShouldShowInterstitialBanner$lambda5;
                m747checkShouldShowInterstitialBanner$lambda5 = PreferenceGeneralEntityData.m747checkShouldShowInterstitialBanner$lambda5(PreferenceGeneralEntityData.this, gapTimeSettings);
                return m747checkShouldShowInterstitialBanner$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkShouldShowInterstitialBanner$lambda-5  reason: not valid java name */
    public static final ObservableSource m747checkShouldShowInterstitialBanner$lambda5(final PreferenceGeneralEntityData preferenceGeneralEntityData, final long j) {
        Intrinsics.checkNotNullParameter(preferenceGeneralEntityData, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.account.general.repository.source.preference.PreferenceGeneralEntityData$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m748checkShouldShowInterstitialBanner$lambda5$lambda4;
                m748checkShouldShowInterstitialBanner$lambda5$lambda4 = PreferenceGeneralEntityData.m748checkShouldShowInterstitialBanner$lambda5$lambda4(PreferenceGeneralEntityData.this, j);
                return m748checkShouldShowInterstitialBanner$lambda5$lambda4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkShouldShowInterstitialBanner$lambda-5$lambda-4  reason: not valid java name */
    public static final Boolean m748checkShouldShowInterstitialBanner$lambda5$lambda4(PreferenceGeneralEntityData preferenceGeneralEntityData, long j) {
        Intrinsics.checkNotNullParameter(preferenceGeneralEntityData, "");
        return preferenceGeneralEntityData.generalPreferences.get().checkShouldShowInterstitialBanner(Long.valueOf(j));
    }

    @Override // id.dana.data.account.general.repository.GeneralEntityData
    public final Observable<Boolean> saveInterstitialBannerNextGapTime(final long gapTimeInUnix) {
        Observable<Boolean> defer = Observable.defer(new Callable() { // from class: id.dana.data.account.general.repository.source.preference.PreferenceGeneralEntityData$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m749saveInterstitialBannerNextGapTime$lambda7;
                m749saveInterstitialBannerNextGapTime$lambda7 = PreferenceGeneralEntityData.m749saveInterstitialBannerNextGapTime$lambda7(PreferenceGeneralEntityData.this, gapTimeInUnix);
                return m749saveInterstitialBannerNextGapTime$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveInterstitialBannerNextGapTime$lambda-7  reason: not valid java name */
    public static final ObservableSource m749saveInterstitialBannerNextGapTime$lambda7(final PreferenceGeneralEntityData preferenceGeneralEntityData, final long j) {
        Intrinsics.checkNotNullParameter(preferenceGeneralEntityData, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.account.general.repository.source.preference.PreferenceGeneralEntityData$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m750saveInterstitialBannerNextGapTime$lambda7$lambda6;
                m750saveInterstitialBannerNextGapTime$lambda7$lambda6 = PreferenceGeneralEntityData.m750saveInterstitialBannerNextGapTime$lambda7$lambda6(PreferenceGeneralEntityData.this, j);
                return m750saveInterstitialBannerNextGapTime$lambda7$lambda6;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveInterstitialBannerNextGapTime$lambda-7$lambda-6  reason: not valid java name */
    public static final Boolean m750saveInterstitialBannerNextGapTime$lambda7$lambda6(PreferenceGeneralEntityData preferenceGeneralEntityData, long j) {
        Intrinsics.checkNotNullParameter(preferenceGeneralEntityData, "");
        return preferenceGeneralEntityData.generalPreferences.get().saveInterstitialBannerNextGapTime(Long.valueOf(j));
    }

    @Override // id.dana.data.account.general.repository.GeneralEntityData
    public final Observable<Boolean> checkResetInterstitialBannerReadList(final long resetTimeSettings) {
        Observable<Boolean> defer = Observable.defer(new Callable() { // from class: id.dana.data.account.general.repository.source.preference.PreferenceGeneralEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m745checkResetInterstitialBannerReadList$lambda9;
                m745checkResetInterstitialBannerReadList$lambda9 = PreferenceGeneralEntityData.m745checkResetInterstitialBannerReadList$lambda9(PreferenceGeneralEntityData.this, resetTimeSettings);
                return m745checkResetInterstitialBannerReadList$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkResetInterstitialBannerReadList$lambda-9  reason: not valid java name */
    public static final ObservableSource m745checkResetInterstitialBannerReadList$lambda9(final PreferenceGeneralEntityData preferenceGeneralEntityData, final long j) {
        Intrinsics.checkNotNullParameter(preferenceGeneralEntityData, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.account.general.repository.source.preference.PreferenceGeneralEntityData$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m746checkResetInterstitialBannerReadList$lambda9$lambda8;
                m746checkResetInterstitialBannerReadList$lambda9$lambda8 = PreferenceGeneralEntityData.m746checkResetInterstitialBannerReadList$lambda9$lambda8(PreferenceGeneralEntityData.this, j);
                return m746checkResetInterstitialBannerReadList$lambda9$lambda8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkResetInterstitialBannerReadList$lambda-9$lambda-8  reason: not valid java name */
    public static final Boolean m746checkResetInterstitialBannerReadList$lambda9$lambda8(PreferenceGeneralEntityData preferenceGeneralEntityData, long j) {
        Intrinsics.checkNotNullParameter(preferenceGeneralEntityData, "");
        return preferenceGeneralEntityData.generalPreferences.get().checkResetInterstitialBannerReadList(Long.valueOf(j));
    }

    @Override // id.dana.data.account.general.repository.GeneralEntityData
    public final Observable<Boolean> saveInterstitialBannerNextResetTime(final long resetTimeInUnix) {
        Observable<Boolean> defer = Observable.defer(new Callable() { // from class: id.dana.data.account.general.repository.source.preference.PreferenceGeneralEntityData$$ExternalSyntheticLambda10
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m751saveInterstitialBannerNextResetTime$lambda11;
                m751saveInterstitialBannerNextResetTime$lambda11 = PreferenceGeneralEntityData.m751saveInterstitialBannerNextResetTime$lambda11(PreferenceGeneralEntityData.this, resetTimeInUnix);
                return m751saveInterstitialBannerNextResetTime$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveInterstitialBannerNextResetTime$lambda-11  reason: not valid java name */
    public static final ObservableSource m751saveInterstitialBannerNextResetTime$lambda11(final PreferenceGeneralEntityData preferenceGeneralEntityData, final long j) {
        Intrinsics.checkNotNullParameter(preferenceGeneralEntityData, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.account.general.repository.source.preference.PreferenceGeneralEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m752saveInterstitialBannerNextResetTime$lambda11$lambda10;
                m752saveInterstitialBannerNextResetTime$lambda11$lambda10 = PreferenceGeneralEntityData.m752saveInterstitialBannerNextResetTime$lambda11$lambda10(PreferenceGeneralEntityData.this, j);
                return m752saveInterstitialBannerNextResetTime$lambda11$lambda10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveInterstitialBannerNextResetTime$lambda-11$lambda-10  reason: not valid java name */
    public static final Boolean m752saveInterstitialBannerNextResetTime$lambda11$lambda10(PreferenceGeneralEntityData preferenceGeneralEntityData, long j) {
        Intrinsics.checkNotNullParameter(preferenceGeneralEntityData, "");
        return preferenceGeneralEntityData.generalPreferences.get().saveResetInterstitialBannerTime(Long.valueOf(j));
    }

    @Override // id.dana.data.account.general.repository.GeneralEntityData
    public final Observable<Boolean> getBalanceVisibility() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.balanceVisibility.onNext(Boolean.valueOf(this.generalPreferences.get().getBalanceVisibility()));
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return this.balanceVisibility;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // id.dana.data.account.general.repository.GeneralEntityData
    public final Observable<Boolean> getGoalsBalanceVisibility() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.goalsBalanceVisibility.onNext(this.generalPreferences.get().getGoalsBalanceVisibility());
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return this.goalsBalanceVisibility;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // id.dana.data.account.general.repository.GeneralEntityData
    public final Observable<Boolean> setBalanceVisibility(boolean newState) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.generalPreferences.get().setBalanceVisibility(Boolean.valueOf(newState));
            this.balanceVisibility.onNext(Boolean.valueOf(newState));
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return this.balanceVisibility;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // id.dana.data.account.general.repository.GeneralEntityData
    public final Observable<Boolean> getInvestmentBalanceVisibility() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.investmentBalanceVisibility.onNext(this.generalPreferences.get().getInvestmentBalanceVisibility());
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return this.investmentBalanceVisibility;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // id.dana.data.account.general.repository.GeneralEntityData
    public final Observable<Boolean> getEmasBalanceVisibility() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.emasBalanceVisibility.onNext(this.generalPreferences.get().getEmasBalanceVisibility());
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return this.emasBalanceVisibility;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // id.dana.data.account.general.repository.GeneralEntityData
    public final Observable<Boolean> setGoalsBalanceVisibility(boolean newState) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.generalPreferences.get().setGoalsBalanceVisibility(Boolean.valueOf(newState));
            this.goalsBalanceVisibility.onNext(Boolean.valueOf(newState));
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return this.goalsBalanceVisibility;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // id.dana.data.account.general.repository.GeneralEntityData
    public final Observable<Boolean> setInvestmentBalanceVisibility(boolean newState) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.generalPreferences.get().setInvestmentBalanceVisibility(Boolean.valueOf(newState));
            this.investmentBalanceVisibility.onNext(Boolean.valueOf(newState));
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return this.investmentBalanceVisibility;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // id.dana.data.account.general.repository.GeneralEntityData
    public final Observable<Boolean> setEmasBalanceVisibility(boolean newState) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.generalPreferences.get().setEmasBalanceVisibility(Boolean.valueOf(newState));
            this.emasBalanceVisibility.onNext(Boolean.valueOf(newState));
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return this.emasBalanceVisibility;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // id.dana.data.account.general.repository.GeneralEntityData
    public final void clearAll() {
        this.generalPreferences.get().clearAll();
    }
}

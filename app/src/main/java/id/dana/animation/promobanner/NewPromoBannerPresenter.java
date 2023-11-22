package id.dana.animation.promobanner;

import android.content.Context;
import dagger.Lazy;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.promobanner.NewPromoBannerContract;
import id.dana.animation.promobanner.mapper.PromoBannerModelMapperKt;
import id.dana.base.BasePresenter;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.announcement.interactor.GetAnnouncements;
import id.dana.domain.announcement.interactor.GetGnAnnouncementsId;
import id.dana.domain.announcement.interactor.GetTrackedAnnouncementsId;
import id.dana.domain.announcement.interactor.SaveTrackedAnnouncementId;
import id.dana.domain.announcement.model.AnnouncementsInfo;
import id.dana.domain.announcement.model.RecurringAnnouncement;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckAnnouncementFeature;
import id.dana.domain.home.interactor.GetPromoBannerAnnouncementFromPersistence;
import id.dana.domain.home.interactor.GetPromoBannerContentFromPersistence;
import id.dana.domain.home.interactor.SavePromoBannerAnnouncementIntoPersistence;
import id.dana.domain.home.interactor.SavePromoBannerCdpContentIntoPersistence;
import id.dana.domain.promotion.interactor.GetHomePromotionBanner;
import id.dana.domain.promotion.model.BannerCollection;
import id.dana.domain.pushverify.model.PushVerifyAnnouncement;
import id.dana.mapper.BannerModelMapperKt;
import id.dana.model.CdpContentModel;
import id.dana.model.PromotionModel;
import id.dana.pushverify.mapper.PushVerifyModelMapperKt;
import id.dana.pushverify.model.PushVerifyParamsModel;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@PerActivity
/* loaded from: classes5.dex */
public class NewPromoBannerPresenter extends BasePresenter implements NewPromoBannerContract.Presenter {
    public static final String KClassImpl$Data$declaredNonStaticMembers$2 = "NewPromoBannerPresenter";
    private final Lazy<GetPromoBannerContentFromPersistence> FragmentBottomSheetPaymentSettingBinding;
    PushVerifyParamsModel MyBillsEntityDataFactory;
    final Lazy<GetAnnouncements> NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Lazy<SavePromoBannerAnnouncementIntoPersistence> NetworkUserEntityData$$ExternalSyntheticLambda1;
    final Lazy<PushVerifyTracker> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Lazy<SavePromoBannerCdpContentIntoPersistence> NetworkUserEntityData$$ExternalSyntheticLambda3;
    private DefaultObserver<BannerCollection> NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final Lazy<GetHomePromotionBanner> NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final Lazy<CheckAnnouncementFeature> NetworkUserEntityData$$ExternalSyntheticLambda7;
    final Context PlaceComponentResult;
    final Lazy<SaveTrackedAnnouncementId> PrepareContext;
    final Lazy<GetGnAnnouncementsId> getErrorConfigVersion;
    private final Lazy<GetPromoBannerAnnouncementFromPersistence> isLayoutRequested;
    final NewPromoBannerContract.View newProxyInstance;
    final Lazy<GetTrackedAnnouncementsId> scheduleImpl;
    CompositeDisposable moveToNextValue = new CompositeDisposable();
    boolean lookAheadTest = false;
    private final PublishSubject<Boolean> NetworkUserEntityData$$ExternalSyntheticLambda8 = PublishSubject.PlaceComponentResult();
    final PublishSubject<Boolean> DatabaseTableConfigUtil = PublishSubject.PlaceComponentResult();
    boolean initRecordTimeStamp = false;
    boolean GetContactSyncConfig = false;
    boolean BuiltInFictitiousFunctionClassFactory = false;
    boolean getAuthRequestContext = false;

    public static /* synthetic */ Unit NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return null;
    }

    public static /* synthetic */ Unit lookAheadTest() {
        return null;
    }

    public static /* synthetic */ Unit moveToNextValue() {
        return null;
    }

    public static /* synthetic */ Unit scheduleImpl() {
        return null;
    }

    @Inject
    public NewPromoBannerPresenter(NewPromoBannerContract.View view, Lazy<GetHomePromotionBanner> lazy, Lazy<CheckAnnouncementFeature> lazy2, Lazy<GetAnnouncements> lazy3, Lazy<GetGnAnnouncementsId> lazy4, Lazy<GetTrackedAnnouncementsId> lazy5, Lazy<SaveTrackedAnnouncementId> lazy6, Lazy<SavePromoBannerCdpContentIntoPersistence> lazy7, Lazy<SavePromoBannerAnnouncementIntoPersistence> lazy8, Lazy<GetPromoBannerContentFromPersistence> lazy9, Lazy<GetPromoBannerAnnouncementFromPersistence> lazy10, Lazy<PushVerifyTracker> lazy11, Context context) {
        this.newProxyInstance = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = lazy;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = lazy2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy3;
        this.getErrorConfigVersion = lazy4;
        this.scheduleImpl = lazy5;
        this.PrepareContext = lazy6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = lazy7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lazy8;
        this.FragmentBottomSheetPaymentSettingBinding = lazy9;
        this.isLayoutRequested = lazy10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lazy11;
        this.PlaceComponentResult = context;
    }

    @Override // id.dana.home.promobanner.NewPromoBannerContract.Presenter
    public final void MyBillsEntityDataFactory(final boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().execute(null, new Function1() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                final NewPromoBannerPresenter newPromoBannerPresenter = NewPromoBannerPresenter.this;
                final boolean z2 = z;
                if (((Boolean) obj).booleanValue()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("widgetTypes", "SUBSCRIPTION_SUMMARY,SUBSCRIPTION_PAY_STATUS");
                    newPromoBannerPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(new GetAnnouncements.Params("", hashMap), new Function1() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            String widgetType;
                            final NewPromoBannerPresenter newPromoBannerPresenter2 = NewPromoBannerPresenter.this;
                            final boolean z3 = z2;
                            AnnouncementsInfo announcementsInfo = (AnnouncementsInfo) obj2;
                            ArrayList<RecurringAnnouncement> arrayList = new ArrayList(announcementsInfo.getRecurringAnnouncements());
                            Collections.sort(arrayList, new Comparator() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda3
                                @Override // java.util.Comparator
                                public final int compare(Object obj3, Object obj4) {
                                    return NewPromoBannerPresenter.BuiltInFictitiousFunctionClassFactory((RecurringAnnouncement) obj3, (RecurringAnnouncement) obj4);
                                }
                            });
                            final ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = new ArrayList();
                            for (RecurringAnnouncement recurringAnnouncement : arrayList) {
                                if (!NewPromoBannerPresenter.MyBillsEntityDataFactory(recurringAnnouncement.getExpirationDate()) && (widgetType = recurringAnnouncement.getWidgetType()) != null) {
                                    if ("SUBSCRIPTION_SUMMARY".equalsIgnoreCase(widgetType)) {
                                        arrayList2.add(recurringAnnouncement);
                                    } else if ("SUBSCRIPTION_PAY_STATUS".equalsIgnoreCase(widgetType)) {
                                        arrayList3.add(recurringAnnouncement);
                                    }
                                }
                            }
                            arrayList2.addAll(arrayList3);
                            PushVerifyAnnouncement pushVerifyAnnouncement = announcementsInfo.getPushVerifyAnnouncement();
                            if (pushVerifyAnnouncement != null && pushVerifyAnnouncement.isValid()) {
                                newPromoBannerPresenter2.MyBillsEntityDataFactory = PushVerifyModelMapperKt.BuiltInFictitiousFunctionClassFactory(pushVerifyAnnouncement);
                            }
                            newPromoBannerPresenter2.getErrorConfigVersion.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda0
                                /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
                                @Override // kotlin.jvm.functions.Function1
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                                */
                                public final java.lang.Object invoke(java.lang.Object r10) {
                                    /*
                                        r9 = this;
                                        id.dana.home.promobanner.NewPromoBannerPresenter r0 = id.dana.animation.promobanner.NewPromoBannerPresenter.this
                                        java.util.List r1 = r2
                                        boolean r2 = r3
                                        java.util.List r10 = (java.util.List) r10
                                        boolean r3 = r1.isEmpty()
                                        java.lang.String r4 = "SUBSCRIPTION"
                                        if (r3 != 0) goto L67
                                        id.dana.model.CdpContentModel r3 = new id.dana.model.CdpContentModel
                                        r3.<init>()
                                        java.util.ArrayList r5 = new java.util.ArrayList
                                        r5.<init>()
                                        java.util.Iterator r1 = r1.iterator()
                                    L1e:
                                        boolean r6 = r1.hasNext()
                                        if (r6 == 0) goto L54
                                        java.lang.Object r6 = r1.next()
                                        id.dana.domain.announcement.model.RecurringAnnouncement r6 = (id.dana.domain.announcement.model.RecurringAnnouncement) r6
                                        java.lang.String r7 = r6.getId()
                                        boolean r7 = r10.contains(r7)
                                        if (r7 != 0) goto L1e
                                        java.lang.String r7 = r6.getWidgetType()
                                        java.lang.String r8 = "SUBSCRIPTION_SUMMARY"
                                        boolean r7 = r8.equalsIgnoreCase(r7)
                                        if (r7 != 0) goto L4c
                                        java.lang.String r7 = r6.getWidgetType()
                                        java.lang.String r8 = "SUBSCRIPTION_PAY_STATUS"
                                        boolean r7 = r8.equalsIgnoreCase(r7)
                                        if (r7 == 0) goto L1e
                                    L4c:
                                        id.dana.model.CdpContentModel r6 = id.dana.announcement.mapper.AnnouncementModelMapperKt.MyBillsEntityDataFactory(r6)
                                        r5.add(r6)
                                        goto L1e
                                    L54:
                                        boolean r10 = r5.isEmpty()
                                        if (r10 != 0) goto L67
                                        r3.PlaceComponentResult = r5
                                        r3.DatabaseTableConfigUtil = r4
                                        java.util.ArrayList r10 = new java.util.ArrayList
                                        r10.<init>()
                                        r10.add(r3)
                                        goto L68
                                    L67:
                                        r10 = 0
                                    L68:
                                        id.dana.model.PromotionModel r1 = new id.dana.model.PromotionModel
                                        r1.<init>()
                                        r1.KClassImpl$Data$declaredNonStaticMembers$2 = r10
                                        if (r10 != 0) goto L82
                                        java.util.ArrayList r3 = new java.util.ArrayList
                                        r3.<init>()
                                        id.dana.model.CdpContentModel r5 = new id.dana.model.CdpContentModel
                                        r5.<init>()
                                        r5.DatabaseTableConfigUtil = r4
                                        r3.add(r5)
                                        r1.KClassImpl$Data$declaredNonStaticMembers$2 = r3
                                    L82:
                                        if (r10 == 0) goto Lb1
                                        boolean r3 = r10.isEmpty()
                                        if (r3 != 0) goto Lb1
                                        r3 = 0
                                        java.lang.Object r10 = r10.get(r3)
                                        id.dana.model.CdpContentModel r10 = (id.dana.model.CdpContentModel) r10
                                        java.util.List<id.dana.model.CdpContentModel> r10 = r10.PlaceComponentResult
                                        dagger.Lazy<id.dana.domain.home.interactor.SavePromoBannerAnnouncementIntoPersistence> r3 = r0.NetworkUserEntityData$$ExternalSyntheticLambda1
                                        java.lang.Object r3 = r3.get()
                                        id.dana.domain.home.interactor.SavePromoBannerAnnouncementIntoPersistence r3 = (id.dana.domain.home.interactor.SavePromoBannerAnnouncementIntoPersistence) r3
                                        id.dana.domain.home.interactor.SavePromoBannerAnnouncementIntoPersistence$Params r4 = new id.dana.domain.home.interactor.SavePromoBannerAnnouncementIntoPersistence$Params
                                        java.util.List r10 = id.dana.model.CdpContentModel.MyBillsEntityDataFactory(r10)
                                        r4.<init>(r10)
                                        id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda10 r10 = new id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda10
                                        r10.<init>()
                                        id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda12 r5 = new id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda12
                                        r5.<init>()
                                        r3.execute(r4, r10, r5)
                                    Lb1:
                                        boolean r10 = r0.PlaceComponentResult()
                                        if (r10 != 0) goto Lb9
                                        if (r2 == 0) goto Lbe
                                    Lb9:
                                        id.dana.home.promobanner.NewPromoBannerContract$View r10 = r0.newProxyInstance
                                        r10.onGetPromoCenterBannerSuccess(r1)
                                    Lbe:
                                        id.dana.pushverify.model.PushVerifyParamsModel r10 = r0.MyBillsEntityDataFactory
                                        if (r10 == 0) goto Ldd
                                        boolean r10 = r0.lookAheadTest
                                        if (r10 != 0) goto Ldd
                                        r10 = 1
                                        r0.lookAheadTest = r10
                                        dagger.Lazy<id.dana.pushverify.tracker.PushVerifyTracker> r10 = r0.NetworkUserEntityData$$ExternalSyntheticLambda2
                                        java.lang.Object r10 = r10.get()
                                        id.dana.pushverify.tracker.PushVerifyTracker r10 = (id.dana.pushverify.tracker.PushVerifyTracker) r10
                                        java.lang.String r1 = "Auto Redirection"
                                        r10.BuiltInFictitiousFunctionClassFactory(r1)
                                        id.dana.home.promobanner.NewPromoBannerContract$View r10 = r0.newProxyInstance
                                        id.dana.pushverify.model.PushVerifyParamsModel r0 = r0.MyBillsEntityDataFactory
                                        r10.onActiveVerificationAnnounced(r0)
                                    Ldd:
                                        kotlin.Unit r10 = kotlin.Unit.INSTANCE
                                        return r10
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda0.invoke(java.lang.Object):java.lang.Object");
                                }
                            }, new Function1() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    return NewPromoBannerPresenter.MyBillsEntityDataFactory((Throwable) obj3);
                                }
                            });
                            newPromoBannerPresenter2.scheduleImpl.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    NewPromoBannerPresenter newPromoBannerPresenter3 = NewPromoBannerPresenter.this;
                                    List list = (List) obj3;
                                    for (RecurringAnnouncement recurringAnnouncement2 : arrayList2) {
                                        boolean z4 = true;
                                        Iterator it = list.iterator();
                                        byte b = 0;
                                        while (it.hasNext()) {
                                            if (((String) it.next()).equals(recurringAnnouncement2.getId())) {
                                                z4 = false;
                                            }
                                        }
                                        if (z4) {
                                            String id2 = recurringAnnouncement2.getId();
                                            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(newPromoBannerPresenter3.PlaceComponentResult);
                                            builder.MyBillsEntityDataFactory = TrackerKey.Event.ANNOUNCEMENT_WIDGET_SHOW;
                                            builder.PlaceComponentResult();
                                            EventTracker.PlaceComponentResult(new EventTrackerModel(builder, b));
                                            newPromoBannerPresenter3.PrepareContext.get().execute(new SaveTrackedAnnouncementId.Params(id2), new Function1() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda4
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj4) {
                                                    Unit unit;
                                                    Boolean bool = (Boolean) obj4;
                                                    unit = Unit.INSTANCE;
                                                    return unit;
                                                }
                                            }, new Function1() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda5
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj4) {
                                                    return NewPromoBannerPresenter.PlaceComponentResult((Throwable) obj4);
                                                }
                                            });
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, new Function1() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda20
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    return NewPromoBannerPresenter.KClassImpl$Data$declaredNonStaticMembers$2((Throwable) obj3);
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    }, new Function1() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return NewPromoBannerPresenter.getAuthRequestContext((Throwable) obj2);
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NewPromoBannerPresenter.BuiltInFictitiousFunctionClassFactory((Throwable) obj);
            }
        });
    }

    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(Throwable th) {
        DanaLog.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, th.getMessage());
        return Unit.INSTANCE;
    }

    @Override // id.dana.home.promobanner.NewPromoBannerContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.FragmentBottomSheetPaymentSettingBinding.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NewPromoBannerPresenter newPromoBannerPresenter = NewPromoBannerPresenter.this;
                List list = (List) obj;
                newPromoBannerPresenter.newProxyInstance.onSuccessGetPromoBannerWidgetFromPersistence(PromoBannerModelMapperKt.getAuthRequestContext(list));
                newPromoBannerPresenter.initRecordTimeStamp = list.isEmpty();
                newPromoBannerPresenter.BuiltInFictitiousFunctionClassFactory = true;
                if (newPromoBannerPresenter.getAuthRequestContext && newPromoBannerPresenter.BuiltInFictitiousFunctionClassFactory) {
                    newPromoBannerPresenter.DatabaseTableConfigUtil.onNext(Boolean.TRUE);
                }
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NewPromoBannerPresenter newPromoBannerPresenter = NewPromoBannerPresenter.this;
                Throwable th = (Throwable) obj;
                newPromoBannerPresenter.newProxyInstance.onErrorGetPromoBannerWidgetFromPersistence();
                newPromoBannerPresenter.initRecordTimeStamp = true;
                newPromoBannerPresenter.BuiltInFictitiousFunctionClassFactory = true;
                if (newPromoBannerPresenter.getAuthRequestContext && newPromoBannerPresenter.BuiltInFictitiousFunctionClassFactory) {
                    newPromoBannerPresenter.DatabaseTableConfigUtil.onNext(Boolean.TRUE);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.home.promobanner.NewPromoBannerContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.isLayoutRequested.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NewPromoBannerPresenter newPromoBannerPresenter = NewPromoBannerPresenter.this;
                List list = (List) obj;
                ArrayList arrayList = new ArrayList(PromoBannerModelMapperKt.getAuthRequestContext(list));
                CdpContentModel cdpContentModel = new CdpContentModel();
                cdpContentModel.PlaceComponentResult = arrayList;
                cdpContentModel.DatabaseTableConfigUtil = "SUBSCRIPTION";
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(cdpContentModel);
                newPromoBannerPresenter.newProxyInstance.onSuccessGetPromoBannerWidgetFromPersistence(arrayList2);
                newPromoBannerPresenter.GetContactSyncConfig = list.isEmpty();
                newPromoBannerPresenter.getAuthRequestContext = true;
                if (newPromoBannerPresenter.getAuthRequestContext && newPromoBannerPresenter.BuiltInFictitiousFunctionClassFactory) {
                    newPromoBannerPresenter.DatabaseTableConfigUtil.onNext(Boolean.TRUE);
                }
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NewPromoBannerPresenter newPromoBannerPresenter = NewPromoBannerPresenter.this;
                Throwable th = (Throwable) obj;
                newPromoBannerPresenter.GetContactSyncConfig = true;
                newPromoBannerPresenter.getAuthRequestContext = true;
                if (newPromoBannerPresenter.getAuthRequestContext && newPromoBannerPresenter.BuiltInFictitiousFunctionClassFactory) {
                    newPromoBannerPresenter.DatabaseTableConfigUtil.onNext(Boolean.TRUE);
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final boolean PlaceComponentResult() {
        return this.GetContactSyncConfig && this.initRecordTimeStamp;
    }

    public static /* synthetic */ Unit getAuthRequestContext(Throwable th) {
        DanaLog.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, th.getMessage());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        DanaLog.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, th.getMessage());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit PlaceComponentResult(Throwable th) {
        DanaLog.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, th.getMessage());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit MyBillsEntityDataFactory(Throwable th) {
        DanaLog.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, th.getMessage());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ int BuiltInFictitiousFunctionClassFactory(RecurringAnnouncement recurringAnnouncement, RecurringAnnouncement recurringAnnouncement2) {
        Locale locale;
        Date parse;
        Locale locale2;
        Date parse2;
        try {
            String subscriptionDueDate = recurringAnnouncement.getSubscriptionDueDate();
            locale = Locale.getDefault();
            parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).parse(subscriptionDueDate);
            String subscriptionDueDate2 = recurringAnnouncement2.getSubscriptionDueDate();
            locale2 = Locale.getDefault();
            parse2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale2).parse(subscriptionDueDate2);
            return parse.compareTo(parse2);
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, e.getMessage());
            return -1;
        }
    }

    public static boolean MyBillsEntityDataFactory(String str) {
        Locale locale;
        locale = Locale.getDefault();
        return DateTimeUtil.MyBillsEntityDataFactory(str, "yyyy-MM-dd HH:mm:ss", locale);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.moveToNextValue.dispose();
        this.getErrorConfigVersion.get().dispose();
        this.scheduleImpl.get().dispose();
        this.PrepareContext.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda3.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().dispose();
        this.FragmentBottomSheetPaymentSettingBinding.get().dispose();
        this.isLayoutRequested.get().dispose();
    }

    @Override // id.dana.home.promobanner.NewPromoBannerContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        addDisposable(Observable.combineLatest(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.DatabaseTableConfigUtil, new BiFunction() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean valueOf;
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                valueOf = Boolean.valueOf(r0.booleanValue() && r1.booleanValue());
                return valueOf;
            }
        }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new Consumer() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewPromoBannerPresenter newPromoBannerPresenter = NewPromoBannerPresenter.this;
                if (((Boolean) obj).booleanValue()) {
                    newPromoBannerPresenter.PlaceComponentResult(false);
                    newPromoBannerPresenter.MyBillsEntityDataFactory(false);
                }
            }
        }));
    }

    @Override // id.dana.home.promobanner.NewPromoBannerContract.Presenter
    public final void getAuthRequestContext() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.onNext(Boolean.TRUE);
    }

    static /* synthetic */ void getAuthRequestContext(NewPromoBannerPresenter newPromoBannerPresenter, List list) {
        newPromoBannerPresenter.NetworkUserEntityData$$ExternalSyntheticLambda3.get().execute(new SavePromoBannerCdpContentIntoPersistence.Params(CdpContentModel.KClassImpl$Data$declaredNonStaticMembers$2(list)), new Function0() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewPromoBannerPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
        }, new Function1() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                return NewPromoBannerPresenter.scheduleImpl();
            }
        });
    }

    @Override // id.dana.home.promobanner.NewPromoBannerContract.Presenter
    public final void PlaceComponentResult(final boolean z) {
        DefaultObserver<BannerCollection> defaultObserver = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (defaultObserver != null) {
            defaultObserver.dispose();
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = null;
        }
        GetHomePromotionBanner getHomePromotionBanner = this.NetworkUserEntityData$$ExternalSyntheticLambda6.get();
        DefaultObserver<BannerCollection> defaultObserver2 = new DefaultObserver<BannerCollection>() { // from class: id.dana.home.promobanner.NewPromoBannerPresenter.1
            {
                NewPromoBannerPresenter.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                PromotionModel authRequestContext = BannerModelMapperKt.getAuthRequestContext((BannerCollection) obj);
                if (authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 == null || authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
                    return;
                }
                NewPromoBannerPresenter.getAuthRequestContext(NewPromoBannerPresenter.this, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2);
                if (NewPromoBannerPresenter.this.PlaceComponentResult() || z) {
                    NewPromoBannerPresenter.this.newProxyInstance.onGetPromoCenterBannerSuccess(authRequestContext);
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                if (NewPromoBannerPresenter.this.PlaceComponentResult()) {
                    NewPromoBannerPresenter.this.newProxyInstance.onError(th.getMessage());
                }
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PROMO_CENTER_BANNER, sb.toString());
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = defaultObserver2;
        getHomePromotionBanner.execute(defaultObserver2);
    }
}

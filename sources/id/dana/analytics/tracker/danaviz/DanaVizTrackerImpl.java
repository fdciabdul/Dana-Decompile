package id.dana.analytics.tracker.danaviz;

import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.analytics.tracker.danaviz.DanaVizTracker;
import id.dana.tracker.constant.TrackerType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u001d¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J;\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0007\u0010\u000eJ9\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u000f\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0018J\u000f\u0010\u0011\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0011\u0010\u0017J\u000f\u0010\u0005\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0005\u0010\u0017J\u0019\u0010\u0011\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0019J\u000f\u0010\u000f\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u000f\u0010\u0017J\u000f\u0010\u0007\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0007\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u0017J\u001f\u0010\u0007\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u0017J\u000f\u0010\u001c\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001c\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001eR\u0012\u0010\u000f\u001a\u00020\tX\u0080\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010 "}, d2 = {"Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker;", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;)Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "", "p2", "", "Lkotlin/Pair;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)[Lkotlin/Pair;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;I)[Lkotlin/Pair;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)[Lkotlin/Pair;", "", "setSource", "(Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;)V", "PlaceComponentResult", "()V", "(ILjava/lang/String;)V", "(Ljava/lang/Integer;)V", "lookAheadTest", "getErrorConfigVersion", "scheduleImpl", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "I", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;", "<init>", "(Lid/dana/analytics/tracker/AnalyticsTrackerFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaVizTrackerImpl implements DanaVizTracker {
    public DanaVizTracker.Source BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public int getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final AnalyticsTrackerFactory KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[DanaVizTracker.Source.values().length];
            iArr[DanaVizTracker.Source.LOGIN.ordinal()] = 1;
            iArr[DanaVizTracker.Source.SEND_MONEY.ordinal()] = 2;
            iArr[DanaVizTracker.Source.GROUP_SEND.ordinal()] = 3;
            iArr[DanaVizTracker.Source.TRANSFER_ACCOUNT.ordinal()] = 4;
            iArr[DanaVizTracker.Source.CASHIER.ordinal()] = 5;
            iArr[DanaVizTracker.Source.SMART_PAY.ordinal()] = 6;
            iArr[DanaVizTracker.Source.REGISTRATION.ordinal()] = 7;
            iArr[DanaVizTracker.Source.DANA_PROTECTION.ordinal()] = 8;
            iArr[DanaVizTracker.Source.TOP_UP.ordinal()] = 9;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    @Inject
    public DanaVizTrackerImpl(AnalyticsTrackerFactory analyticsTrackerFactory) {
        Intrinsics.checkNotNullParameter(analyticsTrackerFactory, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = analyticsTrackerFactory;
    }

    @Override // id.dana.analytics.tracker.danaviz.DanaVizTracker
    public final void setSource(DanaVizTracker.Source p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory = p0;
    }

    public final void MyBillsEntityDataFactory() {
        DanaVizTracker.Source source = this.BuiltInFictitiousFunctionClassFactory;
        if (source != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_VIZ_OPEN, getAuthRequestContext(TrackerKey.DanaVizPurpose.ENROLL_DANA_VIZ, BuiltInFictitiousFunctionClassFactory(source), this.getAuthRequestContext));
            String KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(source);
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("firebase").PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
    }

    public final void getAuthRequestContext(int p0, String p1) {
        String KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(p1, "");
        DanaVizTracker.Source source = this.BuiltInFictitiousFunctionClassFactory;
        if (source != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_VIZ_COMPLETED, KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.DanaVizPurpose.ENROLL_DANA_VIZ, BuiltInFictitiousFunctionClassFactory(source), Integer.valueOf(p0)));
            int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[source.ordinal()];
            String str = i != 6 ? i != 7 ? i != 8 ? null : TrackerKey.Event.DANA_PROTECTION_FACEAUTH_ENROLLMENT_FAILED : TrackerKey.Event.REGISTRATION_FACEAUTH_ENROLLMENT_FAILED : TrackerKey.Event.SMARTPAY_FACEAUTH_ENROLLMENT_FAILED;
            if (str != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("firebase").KClassImpl$Data$declaredNonStaticMembers$2(str, new Pair[]{TuplesKt.to(TrackerKey.Property.ERROR_CODE_FIREBASE, Integer.valueOf(p0)), TuplesKt.to(TrackerKey.Property.ERROR_MESSAGE_FIREBASE, p1)});
                DanaVizTracker.Source source2 = this.BuiltInFictitiousFunctionClassFactory;
                if (source2 == null || (KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(source2)) == null) {
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("firebase").MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2, new Pair[0], new Pair[0]);
            }
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        String KClassImpl$Data$declaredNonStaticMembers$2;
        DanaVizTracker.Source source = this.BuiltInFictitiousFunctionClassFactory;
        if (source != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_VIZ_COMPLETED, MyBillsEntityDataFactory(TrackerKey.DanaVizPurpose.ENROLL_DANA_VIZ, BuiltInFictitiousFunctionClassFactory(source)));
            int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[source.ordinal()];
            String str = i != 6 ? i != 7 ? i != 8 ? null : TrackerKey.Event.DANA_PROTECTION_FACEAUTH_ENROLLMENT_SUCCESS : TrackerKey.Event.REGISTRATION_FACEAUTH_ENROLLMENT_SUCCESS : TrackerKey.Event.SMARTPAY_FACEAUTH_ENROLLMENT_SUCCESS;
            if (str != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("firebase").KClassImpl$Data$declaredNonStaticMembers$2(str, null);
                DanaVizTracker.Source source2 = this.BuiltInFictitiousFunctionClassFactory;
                if (source2 == null || (KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(source2)) == null) {
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("firebase").MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2, new Pair[0], new Pair[0]);
            }
        }
    }

    public final void PlaceComponentResult() {
        DanaVizTracker.Source source = this.BuiltInFictitiousFunctionClassFactory;
        if (source != null) {
            int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[source.ordinal()];
            String str = i != 6 ? i != 7 ? i != 8 ? null : TrackerKey.Event.DANA_PROTECTION_FACEAUTH_ENROLLMENT_CANCELLED : TrackerKey.Event.REGISTRATION_FACEAUTH_ENROLLMENT_CANCELLED : TrackerKey.Event.SMARTPAY_FACEAUTH_ENROLLMENT_CANCELLED;
            if (str != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("firebase").KClassImpl$Data$declaredNonStaticMembers$2(str, null);
            }
        }
    }

    public final void getAuthRequestContext() {
        if (this.BuiltInFictitiousFunctionClassFactory == DanaVizTracker.Source.SMART_PAY) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_VIZ_OPEN, getAuthRequestContext(TrackerKey.DanaVizPurpose.TOGGLE_OFF_DANA_VIZ, TrackerKey.DanaVizSource.SMARTPAY, this.getAuthRequestContext));
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.BuiltInFictitiousFunctionClassFactory == DanaVizTracker.Source.SMART_PAY) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_VIZ_COMPLETED, MyBillsEntityDataFactory(TrackerKey.DanaVizPurpose.TOGGLE_OFF_DANA_VIZ, TrackerKey.DanaVizSource.SMARTPAY));
        }
    }

    public final void MyBillsEntityDataFactory(Integer p0) {
        if (this.BuiltInFictitiousFunctionClassFactory == DanaVizTracker.Source.SMART_PAY) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_VIZ_COMPLETED, KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.DanaVizPurpose.TOGGLE_OFF_DANA_VIZ, TrackerKey.DanaVizSource.SMARTPAY, p0));
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0, String p1) {
        String str;
        Intrinsics.checkNotNullParameter(p1, "");
        DanaVizTracker.Source source = this.BuiltInFictitiousFunctionClassFactory;
        if (source != null) {
            String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(source);
            int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[source.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_VIZ_COMPLETED, KClassImpl$Data$declaredNonStaticMembers$2("Risk Challenge", BuiltInFictitiousFunctionClassFactory, Integer.valueOf(p0)));
            } else if (i == 4) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_VIZ_COMPLETED, KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.DanaVizPurpose.TRANSFER_ACCOUNT_MATCHING, BuiltInFictitiousFunctionClassFactory, Integer.valueOf(p0)));
            }
            switch (WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[source.ordinal()]) {
                case 1:
                    str = TrackerKey.Event.LOGIN_FACEAUTH_FAILED;
                    break;
                case 2:
                case 3:
                case 5:
                    str = TrackerKey.Event.CASHIER_FACEAUTH_FAILED;
                    break;
                case 4:
                    str = TrackerKey.Event.TRANSFER_ACCOUNT_FACEAUTH_FAILED;
                    break;
                case 6:
                    str = TrackerKey.Event.SMARTPAY_FACEAUTH_FAILED;
                    break;
                case 7:
                    str = TrackerKey.Event.REGISTRATION_FACEAUTH_FAILED;
                    break;
                case 8:
                    str = TrackerKey.Event.DANA_PROTECTION_FACEAUTH_FAILED;
                    break;
                case 9:
                    str = TrackerKey.Event.TOPUP_FACEAUTH_FAILED;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("firebase").KClassImpl$Data$declaredNonStaticMembers$2(str, new Pair[]{TuplesKt.to(TrackerKey.Property.ERROR_CODE_FIREBASE, Integer.valueOf(p0)), TuplesKt.to(TrackerKey.Property.ERROR_MESSAGE_FIREBASE, p1)});
            DanaVizTracker.Source source2 = this.BuiltInFictitiousFunctionClassFactory;
            if (source2 != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("firebase").MyBillsEntityDataFactory(MyBillsEntityDataFactory(source2), new Pair[0], new Pair[0]);
            }
        }
    }

    public final void scheduleImpl() {
        String str;
        DanaVizTracker.Source source = this.BuiltInFictitiousFunctionClassFactory;
        if (source != null) {
            String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(source);
            int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[source.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_VIZ_COMPLETED, MyBillsEntityDataFactory("Risk Challenge", BuiltInFictitiousFunctionClassFactory));
            } else if (i == 4) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_VIZ_COMPLETED, MyBillsEntityDataFactory(TrackerKey.DanaVizPurpose.TRANSFER_ACCOUNT_MATCHING, BuiltInFictitiousFunctionClassFactory));
            }
            switch (WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[source.ordinal()]) {
                case 1:
                    str = TrackerKey.Event.LOGIN_FACEAUTH_SUCCESS;
                    break;
                case 2:
                case 3:
                case 5:
                    str = TrackerKey.Event.CASHIER_FACEAUTH_SUCCESS;
                    break;
                case 4:
                    str = TrackerKey.Event.TRANSFER_ACCOUNT_FACEAUTH_SUCCESS;
                    break;
                case 6:
                    str = TrackerKey.Event.SMARTPAY_FACEAUTH_SUCCESS;
                    break;
                case 7:
                    str = TrackerKey.Event.REGISTRATION_FACEAUTH_SUCCESS;
                    break;
                case 8:
                    str = TrackerKey.Event.DANA_PROTECTION_FACEAUTH_SUCCESS;
                    break;
                case 9:
                    str = TrackerKey.Event.TOPUP_FACEAUTH_SUCCESS;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("firebase").KClassImpl$Data$declaredNonStaticMembers$2(str, null);
            DanaVizTracker.Source source2 = this.BuiltInFictitiousFunctionClassFactory;
            if (source2 != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("firebase").MyBillsEntityDataFactory(MyBillsEntityDataFactory(source2), new Pair[0], new Pair[0]);
            }
        }
    }

    public final void lookAheadTest() {
        String str;
        DanaVizTracker.Source source = this.BuiltInFictitiousFunctionClassFactory;
        if (source != null) {
            switch (WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[source.ordinal()]) {
                case 1:
                    str = TrackerKey.Event.LOGIN_FACEAUTH_CANCELLED;
                    break;
                case 2:
                case 3:
                case 5:
                    str = TrackerKey.Event.CASHIER_FACEAUTH_CANCELLED;
                    break;
                case 4:
                    str = TrackerKey.Event.TRANSFER_ACCOUNT_FACEAUTH_CANCELLED;
                    break;
                case 6:
                    str = TrackerKey.Event.SMARTPAY_FACEAUTH_CANCELLED;
                    break;
                case 7:
                    str = TrackerKey.Event.REGISTRATION_FACEAUTH_CANCELLED;
                    break;
                case 8:
                    str = TrackerKey.Event.DANA_PROTECTION_FACEAUTH_CANCELLED;
                    break;
                case 9:
                    str = TrackerKey.Event.TOPUP_FACEAUTH_CANCELLED;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("firebase").KClassImpl$Data$declaredNonStaticMembers$2(str, null);
        }
    }

    public final void getErrorConfigVersion() {
        DanaVizTracker.Source source = this.BuiltInFictitiousFunctionClassFactory;
        if (source != null) {
            String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(source);
            int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[source.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_VIZ_OPEN, getAuthRequestContext("Risk Challenge", BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext));
            } else if (i == 4) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_VIZ_OPEN, getAuthRequestContext(TrackerKey.DanaVizPurpose.TRANSFER_ACCOUNT_MATCHING, BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext));
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("firebase").PlaceComponentResult(MyBillsEntityDataFactory(source));
        }
    }

    private static Pair<String, Object>[] getAuthRequestContext(String p0, String p1, int p2) {
        return p2 > 0 ? new Pair[]{TuplesKt.to("Purpose", p0), TuplesKt.to("Source", p1), TuplesKt.to(TrackerKey.Property.NUMBER_OF_ATTEMPTS, Integer.valueOf(p2))} : new Pair[]{TuplesKt.to("Purpose", p0), TuplesKt.to("Source", p1)};
    }

    private static Pair<String, Object>[] MyBillsEntityDataFactory(String p0, String p1) {
        return new Pair[]{TuplesKt.to("Purpose", p0), TuplesKt.to("Source", p1), TuplesKt.to("Success", Boolean.TRUE)};
    }

    private static Pair<String, Object>[] KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, Integer p2) {
        Boolean bool = Boolean.FALSE;
        return p2 != null ? new Pair[]{TuplesKt.to("Purpose", p0), TuplesKt.to("Source", p1), TuplesKt.to("Success", bool), TuplesKt.to("Error Code", p2)} : new Pair[]{TuplesKt.to("Purpose", p0), TuplesKt.to("Source", p1), TuplesKt.to("Success", bool)};
    }

    private static String BuiltInFictitiousFunctionClassFactory(DanaVizTracker.Source p0) {
        switch (WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[p0.ordinal()]) {
            case 1:
                return "Login";
            case 2:
                return "Send Money";
            case 3:
                return "Group Send";
            case 4:
                return TrackerKey.DanaVizSource.TRANSFER_ACCOUNT;
            case 5:
                return "Cashier";
            case 6:
                return TrackerKey.DanaVizSource.SMARTPAY;
            case 7:
                return "Registration";
            case 8:
                return "DANA_PROTECTION";
            case 9:
                return TrackerKey.DanaVizSource.TOP_UP;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(DanaVizTracker.Source p0) {
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[p0.ordinal()];
        if (i != 6) {
            if (i != 7) {
                if (i != 8) {
                    return null;
                }
                return TrackerKey.Event.DANA_PROTECTION_FACEAUTH_ENROLLMENT_TIME;
            }
            return TrackerKey.Event.REGISTRATION_FACEAUTH_ENROLLMENT_TIME;
        }
        return TrackerKey.Event.SMARTPAY_FACEAUTH_ENROLLMENT_TIME;
    }

    private static String MyBillsEntityDataFactory(DanaVizTracker.Source p0) {
        switch (WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[p0.ordinal()]) {
            case 1:
                return TrackerKey.Event.LOGIN_FACEAUTH_TIME;
            case 2:
            case 3:
            case 5:
                return TrackerKey.Event.CASHIER_FACEAUTH_TIME;
            case 4:
                return TrackerKey.Event.TRANSFER_ACCOUNT_FACEAUTH_TIME;
            case 6:
                return TrackerKey.Event.SMARTPAY_FACEAUTH_TIME;
            case 7:
                return TrackerKey.Event.REGISTRATION_FACEAUTH_TIME;
            case 8:
                return TrackerKey.Event.DANA_PROTECTION_FACEAUTH_TIME;
            case 9:
                return TrackerKey.Event.TOPUP_FACEAUTH_TIME;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}

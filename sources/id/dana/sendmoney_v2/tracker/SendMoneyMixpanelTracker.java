package id.dana.sendmoney_v2.tracker;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.performancetracker.FirstActionEntryPointClickTracker;
import id.dana.performancetracker.FirstActionTracker;
import id.dana.performancetracker.IdleTimeUtil;
import id.dana.rum.Rum;
import id.dana.sendmoney.confirmation.ConfirmationType;
import id.dana.sendmoney.model.ConfirmationModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.TransactionTracker;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020$¢\u0006\u0004\b(\u0010)J*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0007\u0010\u0012J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u0014\u0010\u001aJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0018J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0018J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u001cJ\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0015J/\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u001dH\u0016¢\u0006\u0004\b\u0007\u0010\u001eJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0018J\u001f\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u0015J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0018J3\u0010\u000b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u001fJ)\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0014\u0010 J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010!J#\u0010\u0017\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0017\u0010\"J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u0017\u0010#R\u0011\u0010\u000b\u001a\u00020$X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010%R\u0013\u0010\u0014\u001a\u00020&X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010'"}, d2 = {"Lid/dana/sendmoney_v2/tracker/SendMoneyMixpanelTracker;", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "getAuthRequestContext", "(Lkotlin/jvm/functions/Function1;)V", "", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Z", "p1", "", "p2", "p3", "p4", "(Ljava/lang/String;ZJZZ)V", "(Ljava/lang/String;Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "()V", "", "(ZLjava/lang/String;I)V", "Lid/dana/sendmoney/model/ConfirmationModel;", "(Lid/dana/sendmoney/model/ConfirmationModel;Z)V", "", "(ZLjava/lang/String;Ljava/util/List;)V", "(Ljava/lang/String;ZLjava/lang/String;Z)V", "(Ljava/lang/String;ZLjava/lang/Boolean;)V", "(ZLjava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "(I)V", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "Lkotlin/Lazy;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyMixpanelTracker implements SendMoneyAnalyticTracker {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Context MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public SendMoneyMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<SendMoneyFeatureTime>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$sendMoneyFeatureTime$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SendMoneyFeatureTime invoke() {
                return SendMoneyFeatureTime.INSTANCE.MyBillsEntityDataFactory();
            }
        });
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory(final String p0, final boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneyOpen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_OPEN;
                IdleTimeUtil idleTimeUtil = IdleTimeUtil.INSTANCE;
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.IDLE_TIME, IdleTimeUtil.PlaceComponentResult());
                builder.MyBillsEntityDataFactory("Source", p0);
                SendMoneyFeatureTime authRequestContext = SendMoneyMixpanelTracker.getAuthRequestContext(this);
                Intrinsics.checkNotNullParameter("OPEN LANDING PAGE", "");
                builder.MyBillsEntityDataFactory("Render Time", String.valueOf(authRequestContext.getAuthRequestContext.get("OPEN LANDING PAGE")));
                if (p1) {
                    builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.HIT_TIME, SendMoneyMixpanelTracker.getAuthRequestContext(this).KClassImpl$Data$declaredNonStaticMembers$2());
                    builder.BuiltInFictitiousFunctionClassFactory("Is Success", SendMoneyMixpanelTracker.getAuthRequestContext(this).getMyBillsEntityDataFactory());
                }
                SendMoneyMixpanelTracker.PlaceComponentResult(builder);
            }
        });
        FirstActionTracker firstActionTracker = FirstActionTracker.INSTANCE;
        FirstActionTracker.PlaceComponentResult("Send Money");
        Rum.Companion companion = Rum.getAuthRequestContext;
        Rum.Companion.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(TrackerKey.Event.FIRST_ACTION, TuplesKt.to("operation", TrackerKey.Event.SEND_MONEY_OPEN)).PlaceComponentResult();
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void getAuthRequestContext(final String p0, final boolean p1, final long p2, final boolean p3, final boolean p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p2 != 0) {
            getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackRequestMoneyGenerateQr$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                    invoke2(builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(EventTrackerModel.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "");
                    builder.MyBillsEntityDataFactory = TrackerKey.Event.REQUEST_MONEY_GENERATE_QR;
                    builder.MyBillsEntityDataFactory(TrackerKey.RequestMoneyProperties.QR_TYPE, p0);
                    builder.BuiltInFictitiousFunctionClassFactory("Is Success", p1);
                    builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.HIT_TIME, p2);
                    builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.IS_QRIS, p3);
                    builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.RequestMoneyProperties.IS_DEEPLINK, p4);
                }
            });
        }
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void MyBillsEntityDataFactory() {
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneyHelpOpen$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_HELP_OPEN;
            }
        });
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, final boolean p1, final Boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        switch (p0.hashCode()) {
            case -1820761141:
                if (p0.equals("external")) {
                    final String str = "CASH";
                    getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneySelectFromType$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                            invoke2(builder);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(EventTrackerModel.Builder builder) {
                            Intrinsics.checkNotNullParameter(builder, "");
                            builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_SELECT;
                            builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_DESTINATION_TYPE, str);
                            builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.LAST_TRANSACTION, p1);
                            Boolean bool = p2;
                            if (bool != null) {
                                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.IS_FAVORITE, bool.booleanValue());
                            }
                        }
                    });
                    return;
                }
                return;
            case -276836809:
                if (p0.equals("phonenumber")) {
                    final String str2 = "DANA Balance";
                    getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneySelectFromType$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                            invoke2(builder);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(EventTrackerModel.Builder builder) {
                            Intrinsics.checkNotNullParameter(builder, "");
                            builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_SELECT;
                            builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_DESTINATION_TYPE, str2);
                            builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.LAST_TRANSACTION, p1);
                            Boolean bool = p2;
                            if (bool != null) {
                                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.IS_FAVORITE, bool.booleanValue());
                            }
                        }
                    });
                    return;
                }
                return;
            case 3016252:
                if (p0.equals("bank")) {
                    final String str3 = "BANK";
                    getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneySelectFromType$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                            invoke2(builder);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(EventTrackerModel.Builder builder) {
                            Intrinsics.checkNotNullParameter(builder, "");
                            builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_SELECT;
                            builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_DESTINATION_TYPE, str3);
                            builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.LAST_TRANSACTION, p1);
                            Boolean bool = p2;
                            if (bool != null) {
                                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.IS_FAVORITE, bool.booleanValue());
                            }
                        }
                    });
                    return;
                }
                return;
            case 3052376:
                if (p0.equals("chat")) {
                    final String str4 = "LINK";
                    getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneySelectFromType$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                            invoke2(builder);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(EventTrackerModel.Builder builder) {
                            Intrinsics.checkNotNullParameter(builder, "");
                            builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_SELECT;
                            builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_DESTINATION_TYPE, str4);
                            builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.LAST_TRANSACTION, p1);
                            Boolean bool = p2;
                            if (bool != null) {
                                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.IS_FAVORITE, bool.booleanValue());
                            }
                        }
                    });
                    return;
                }
                return;
            case 98629247:
                if (p0.equals("group")) {
                    final String str5 = TrackerKey.RecipientDestinationTypeProperty.GROUP;
                    getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneySelectFromType$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                            invoke2(builder);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(EventTrackerModel.Builder builder) {
                            Intrinsics.checkNotNullParameter(builder, "");
                            builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_SELECT;
                            builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_DESTINATION_TYPE, str5);
                            builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.LAST_TRANSACTION, p1);
                            Boolean bool = p2;
                            if (bool != null) {
                                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.IS_FAVORITE, bool.booleanValue());
                            }
                        }
                    });
                    return;
                }
                return;
            case 1107020974:
                if (p0.equals("globalTransfer")) {
                    final String str6 = TrackerKey.RecipientDestinationTypeProperty.OVERSEAS;
                    getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneySelectFromType$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                            invoke2(builder);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(EventTrackerModel.Builder builder) {
                            Intrinsics.checkNotNullParameter(builder, "");
                            builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_SELECT;
                            builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_DESTINATION_TYPE, str6);
                            builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.LAST_TRANSACTION, p1);
                            Boolean bool = p2;
                            if (bool != null) {
                                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.IS_FAVORITE, bool.booleanValue());
                            }
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void PlaceComponentResult(final int p0) {
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSubmitNameCheckCount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.REQUEST_MONEY_QR_BANK_ACCOUNT_NUMBER_INPUT;
                builder.MyBillsEntityDataFactory("Source", TrackerKey.SourceType.QR_CARD);
                builder.PlaceComponentResult(TrackerKey.Property.NUMBER_OF_ATTEMPTS, p0);
            }
        });
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final boolean p0, final String p1, final int p2) {
        Intrinsics.checkNotNullParameter(p1, "");
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneyBankAccountNumberInput$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_BANK_ACCOUNT_NUMBER_INPUT;
                builder.MyBillsEntityDataFactory("Source", TrackerKey.SourceType.QR_CARD);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.IS_SUCCESS, p0);
                builder.MyBillsEntityDataFactory("Fail Reason", p1);
                builder.PlaceComponentResult(TrackerKey.Property.NUMBER_OF_ATTEMPTS, p2);
            }
        });
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void getAuthRequestContext(final boolean p0, final String p1, final List<String> p2) {
        Intrinsics.checkNotNullParameter(p2, "");
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneyCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_CREATE;
                builder.MyBillsEntityDataFactory("Source", p1);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.IS_FAVORITE, p0);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.SEND_MONEY_SMART_FRICTION, p2);
                SendMoneyFeatureTime authRequestContext = SendMoneyMixpanelTracker.getAuthRequestContext(this);
                builder.BuiltInFictitiousFunctionClassFactory("Render Time", authRequestContext.MyBillsEntityDataFactory());
                if (authRequestContext.getMyBillsEntityDataFactory()) {
                    builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.HIT_TIME, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2());
                    builder.BuiltInFictitiousFunctionClassFactory("Is Success", authRequestContext.getMyBillsEntityDataFactory());
                }
                long MyBillsEntityDataFactory = authRequestContext.MyBillsEntityDataFactory();
                Intrinsics.checkNotNullParameter("OPEN SUMMARY PAGE", "");
                authRequestContext.getAuthRequestContext.put("OPEN SUMMARY PAGE", Long.valueOf(MyBillsEntityDataFactory));
                authRequestContext.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void MyBillsEntityDataFactory(final ConfirmationModel p0, final boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneyConfirm$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = "Send Money Confirm";
                builder.MyBillsEntityDataFactory("Source", ConfirmationModel.this.C());
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.SENDER_PAYMENT_METHOD, !p1 ? ConfirmationModel.this.readMicros() : null);
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_DESTINATION_TYPE, SendMoneyMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(ConfirmationModel.this));
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.P2P_RECIPIENT_TYPE, SendMoneyMixpanelTracker.PlaceComponentResult(ConfirmationModel.this));
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_USER_ID, SendMoneyMixpanelTracker.getAuthRequestContext(ConfirmationModel.this));
                builder.PlaceComponentResult(TrackerKey.SendMoneyProperties.SENDER_CONTACT_COUNT, ConfirmationModel.this.B());
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_SOURCE, ConfirmationModel.this.getSupportButtonTintMode());
                builder.PlaceComponentResult(TrackerKey.SendMoneyProperties.SEND_MONEY_AMOUNT, ConfirmationModel.this.moveToNextValue());
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.HAS_COMMENT, ConfirmationModel.this.F());
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.SHARE_TO_FEED, ConfirmationModel.this.AppCompatEmojiTextHelper());
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.SEND_MONEY_CLAIM_LINK_EXPIRY, ConfirmationModel.this.newProxyInstance());
                builder.MyBillsEntityDataFactory("KYC Level", ConfirmationModel.this.FragmentBottomSheetPaymentSettingBinding());
                builder.PlaceComponentResult(TrackerKey.SendMoneyProperties.PAID_AMOUNT, ConfirmationModel.this.moveToNextValue());
                builder.PlaceComponentResult(TrackerKey.SendMoneyProperties.NUMBER_OF_FREE_TRANSFER, ConfirmationModel.this.D());
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.IS_FAVORITE, ConfirmationModel.this.I());
                SendMoneyFeatureTime authRequestContext = SendMoneyMixpanelTracker.getAuthRequestContext(this);
                ConfirmationModel confirmationModel = ConfirmationModel.this;
                long MyBillsEntityDataFactory = authRequestContext.MyBillsEntityDataFactory();
                Intrinsics.checkNotNullParameter("SUBMIT ON SUMMARY PAGE", "");
                authRequestContext.getAuthRequestContext.put("SUBMIT ON SUMMARY PAGE", Long.valueOf(MyBillsEntityDataFactory));
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.HIT_TIME, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2());
                builder.BuiltInFictitiousFunctionClassFactory("Render Time", authRequestContext.MyBillsEntityDataFactory());
                builder.BuiltInFictitiousFunctionClassFactory("Feature Time", CollectionsKt.sumOfLong(authRequestContext.getAuthRequestContext.values()));
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.FEATURE_JOURNEY, authRequestContext.getAuthRequestContext.toString());
                builder.MyBillsEntityDataFactory("Feature Name", SendMoneyFeatureTime.PlaceComponentResult(confirmationModel));
                if (authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.length() > 0) {
                    builder.MyBillsEntityDataFactory(TrackerKey.ScanQRProperties.DECODE_TYPE, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                authRequestContext.getAuthRequestContext();
            }
        });
        TransactionTracker.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, "Send Money");
        TransactionTracker.PlaceComponentResult(this.MyBillsEntityDataFactory, "Send Money");
    }

    private static boolean MyBillsEntityDataFactory(String p0) {
        return Intrinsics.areEqual(p0, ConfirmationType.Destination.CONTACT);
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void PlaceComponentResult(final String p0, final String p1) {
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSmartFrictionOpen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SMART_FRICTION_SEND_MONEY_OPEN;
                builder.MyBillsEntityDataFactory(TrackerKey.SmartFrictionProperties.SCENARIO, p0);
                builder.MyBillsEntityDataFactory(TrackerKey.SmartFrictionProperties.RECIPIENT_DESTINATION, p1);
            }
        });
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final boolean p0, final String p1) {
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSmartFrictionConfirm$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SMART_FRICTION_SEND_MONEY_CONFIRM;
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SmartFrictionProperties.IS_CONTINUE, p0);
                builder.MyBillsEntityDataFactory(TrackerKey.SmartFrictionProperties.SCENARIO, p1);
            }
        });
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneySearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_SEARCH;
                builder.BuiltInFictitiousFunctionClassFactory("Render Time", SendMoneyMixpanelTracker.getAuthRequestContext(SendMoneyMixpanelTracker.this).MyBillsEntityDataFactory());
            }
        });
        SendMoneyFeatureTime sendMoneyFeatureTime = (SendMoneyFeatureTime) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        long MyBillsEntityDataFactory = sendMoneyFeatureTime.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullParameter("OPEN SEARCH PAGE", "");
        sendMoneyFeatureTime.getAuthRequestContext.put("OPEN SEARCH PAGE", Long.valueOf(MyBillsEntityDataFactory));
        sendMoneyFeatureTime.getAuthRequestContext();
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void MyBillsEntityDataFactory(final String p0, final boolean p1, final String p2, final boolean p3) {
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneySearchSelected$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_SEARCH_SELECTED;
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.ADD_NEW_BANK, p3);
                String str = p0;
                if (str != null) {
                    builder.MyBillsEntityDataFactory("Destination", str);
                }
                String str2 = p2;
                if (str2 != null) {
                    builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.FRICTION_TYPE, str2);
                }
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.IS_RECENT, p1);
                SendMoneyFeatureTime authRequestContext = SendMoneyMixpanelTracker.getAuthRequestContext(this);
                if (authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2() > 0) {
                    builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.HIT_TIME, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2());
                    builder.BuiltInFictitiousFunctionClassFactory("Is Success", authRequestContext.getMyBillsEntityDataFactory());
                    long KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
                    Intrinsics.checkNotNullParameter("INIT ON SEARCH SELECTION", "");
                    authRequestContext.getAuthRequestContext.put("INIT ON SEARCH SELECTION", Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2));
                    authRequestContext.getAuthRequestContext();
                }
            }
        });
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void PlaceComponentResult(final String p0) {
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneyContactListPageOpen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_CONTACT_LIST_PAGE;
                builder.MyBillsEntityDataFactory("Destination", "DANA Balance");
                String str = p0;
                if (str != null) {
                    builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.FRICTION_TYPE, str);
                }
                SendMoneyFeatureTime authRequestContext = SendMoneyMixpanelTracker.getAuthRequestContext(this);
                Intrinsics.checkNotNullParameter("OPEN CONTACT LIST PAGE", "");
                Long l = authRequestContext.getAuthRequestContext.get("OPEN CONTACT LIST PAGE");
                if (l != null) {
                    builder.BuiltInFictitiousFunctionClassFactory("Render Time", l.longValue());
                }
                if (authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2() > 0) {
                    builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.HIT_TIME, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2());
                    builder.BuiltInFictitiousFunctionClassFactory("Is Success", authRequestContext.getMyBillsEntityDataFactory());
                    long KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
                    Intrinsics.checkNotNullParameter("INIT ON CONTACT PAGE SELECTION", "");
                    authRequestContext.getAuthRequestContext.put("INIT ON CONTACT PAGE SELECTION", Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2));
                }
                authRequestContext.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory() {
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneyBankListPageOpen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_BANK_LIST_PAGE;
                builder.BuiltInFictitiousFunctionClassFactory("Render Time", SendMoneyMixpanelTracker.getAuthRequestContext(SendMoneyMixpanelTracker.this).MyBillsEntityDataFactory());
            }
        });
        SendMoneyFeatureTime sendMoneyFeatureTime = (SendMoneyFeatureTime) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        long MyBillsEntityDataFactory = sendMoneyFeatureTime.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullParameter("OPEN BANK LIST PAGE", "");
        sendMoneyFeatureTime.getAuthRequestContext.put("OPEN BANK LIST PAGE", Long.valueOf(MyBillsEntityDataFactory));
        sendMoneyFeatureTime.getAuthRequestContext();
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void getAuthRequestContext() {
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneyChatOpen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_CHAT_OPEN;
                SendMoneyFeatureTime authRequestContext = SendMoneyMixpanelTracker.getAuthRequestContext(SendMoneyMixpanelTracker.this);
                Intrinsics.checkNotNullParameter("OPEN LINK LANDING PAGE", "");
                builder.MyBillsEntityDataFactory("Render Time", String.valueOf(authRequestContext.getAuthRequestContext.get("OPEN LINK LANDING PAGE")));
            }
        });
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendAndWithdrawOpen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
            
                if (r6 > 0) goto L10;
             */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(id.dana.tracker.EventTrackerModel.Builder r10) {
                /*
                    r9 = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                    java.lang.String r1 = "Send & Withdraw Open"
                    r10.MyBillsEntityDataFactory = r1
                    java.lang.String r1 = r1
                    java.lang.String r2 = "Source"
                    r10.MyBillsEntityDataFactory(r2, r1)
                    id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker r1 = r2
                    id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime r1 = id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker.getAuthRequestContext(r1)
                    long r2 = r1.MyBillsEntityDataFactory()
                    java.lang.String r4 = "Render Time"
                    r10.BuiltInFictitiousFunctionClassFactory(r4, r2)
                    long r2 = r1.BuiltInFictitiousFunctionClassFactory
                    r4 = 0
                    int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                    if (r6 <= 0) goto L33
                    long r6 = r1.scheduleImpl
                    int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                    if (r8 <= 0) goto L33
                    long r6 = r6 - r2
                    int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                    if (r2 <= 0) goto L33
                    goto L34
                L33:
                    r6 = r4
                L34:
                    java.lang.String r2 = "Hit Time (Biztransfer.init)"
                    r10.BuiltInFictitiousFunctionClassFactory(r2, r6)
                    long r2 = r1.BuiltInFictitiousFunctionClassFactory
                    int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                    if (r6 <= 0) goto L4b
                    long r6 = r1.getErrorConfigVersion
                    int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                    if (r8 <= 0) goto L4b
                    long r6 = r6 - r2
                    int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                    if (r2 <= 0) goto L4b
                    r4 = r6
                L4b:
                    java.lang.String r2 = "Hit Time (Withdraw.init)"
                    r10.BuiltInFictitiousFunctionClassFactory(r2, r4)
                    long r2 = r1.MyBillsEntityDataFactory()
                    java.lang.String r10 = "OPEN WITHDRAW LANDING PAGE"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                    java.util.Map<java.lang.String, java.lang.Long> r0 = r1.getAuthRequestContext
                    java.lang.Long r2 = java.lang.Long.valueOf(r2)
                    r0.put(r10, r2)
                    r1.getAuthRequestContext()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendAndWithdrawOpen$1.invoke2(id.dana.tracker.EventTrackerModel$Builder):void");
            }
        });
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendAndWithdrawSelect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_AND_WITHDRAW_SELECT;
                builder.MyBillsEntityDataFactory("Transaction Type", TrackerKey.TransactionType.WITHDRAW);
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.SEND_AND_WITHDRAW_CHANNEL, p0);
            }
        });
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneyReceiverDataInput$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_RECEIVER_DATA_INPUT;
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.SEND_AND_WITHDRAW_CHANNEL, p0);
                SendMoneyFeatureTime authRequestContext = SendMoneyMixpanelTracker.getAuthRequestContext(this);
                builder.BuiltInFictitiousFunctionClassFactory("Render Time", authRequestContext.MyBillsEntityDataFactory());
                long MyBillsEntityDataFactory = authRequestContext.MyBillsEntityDataFactory();
                Intrinsics.checkNotNullParameter("OPEN WITHDRAW FORM PAGE", "");
                authRequestContext.getAuthRequestContext.put("OPEN WITHDRAW FORM PAGE", Long.valueOf(MyBillsEntityDataFactory));
                authRequestContext.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void PlaceComponentResult() {
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackSendMoneyAddNewBankOpen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_MONEY_ADD_NEW_BANK_OPEN;
                SendMoneyFeatureTime authRequestContext = SendMoneyMixpanelTracker.getAuthRequestContext(SendMoneyMixpanelTracker.this);
                builder.BuiltInFictitiousFunctionClassFactory("Render Time", authRequestContext.MyBillsEntityDataFactory());
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.HIT_TIME, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2());
                builder.BuiltInFictitiousFunctionClassFactory("Is Success", authRequestContext.getMyBillsEntityDataFactory());
                long MyBillsEntityDataFactory = authRequestContext.MyBillsEntityDataFactory();
                Intrinsics.checkNotNullParameter("OPEN ADD NEW BANK PAGE", "");
                authRequestContext.getAuthRequestContext.put("OPEN ADD NEW BANK PAGE", Long.valueOf(MyBillsEntityDataFactory));
                authRequestContext.getAuthRequestContext();
            }
        });
    }

    private final void getAuthRequestContext(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.MyBillsEntityDataFactory);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        p0.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
    }

    public static final /* synthetic */ void PlaceComponentResult(EventTrackerModel.Builder builder) {
        AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
        builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.HOME_ENTRY_POINT_CLICK, FirstActionEntryPointClickTracker.MyBillsEntityDataFactory(AppReadyMixpanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda0()));
        builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.INIT_TIME, FirstActionEntryPointClickTracker.PlaceComponentResult());
        builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.ROAMING_TIME, FirstActionEntryPointClickTracker.PlaceComponentResult(IdleTimeUtil.MyBillsEntityDataFactory()));
        AppReadyMixpanelTracker appReadyMixpanelTracker2 = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
        builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.TOTAL_TIME, FirstActionEntryPointClickTracker.BuiltInFictitiousFunctionClassFactory(AppReadyMixpanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda0()));
    }

    public static final /* synthetic */ String PlaceComponentResult(ConfirmationModel confirmationModel) {
        String PrepareContext = confirmationModel.PrepareContext();
        Intrinsics.checkNotNullExpressionValue(PrepareContext, "");
        return MyBillsEntityDataFactory(PrepareContext) ? confirmationModel.H() ? TrackerKey.DanaBalanceRecipientTypeProperty.DANA : TrackerKey.DanaBalanceRecipientTypeProperty.PHONE : "Other";
    }

    public static final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2(ConfirmationModel confirmationModel) {
        if (StringsKt.equals(confirmationModel.PrepareContext(), ConfirmationType.Destination.CONTACT, true)) {
            return "DANA Balance";
        }
        if (StringsKt.equals(confirmationModel.PrepareContext(), ConfirmationType.Destination.OTC, true)) {
            return "CASH";
        }
        String PrepareContext = confirmationModel.PrepareContext();
        Intrinsics.checkNotNullExpressionValue(PrepareContext, "");
        String replace$default = StringsKt.replace$default(PrepareContext, "destination_", "", false, 4, (Object) null);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String upperCase = replace$default.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        return upperCase;
    }

    public static final /* synthetic */ String getAuthRequestContext(ConfirmationModel confirmationModel) {
        String PrepareContext = confirmationModel.PrepareContext();
        Intrinsics.checkNotNullExpressionValue(PrepareContext, "");
        if (MyBillsEntityDataFactory(PrepareContext)) {
            String NetworkUserEntityData$$ExternalSyntheticLambda5 = confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda5();
            Intrinsics.checkNotNullExpressionValue(NetworkUserEntityData$$ExternalSyntheticLambda5, "");
            return NetworkUserEntityData$$ExternalSyntheticLambda5;
        }
        return "-";
    }

    public static final /* synthetic */ SendMoneyFeatureTime getAuthRequestContext(SendMoneyMixpanelTracker sendMoneyMixpanelTracker) {
        return (SendMoneyFeatureTime) sendMoneyMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    @Override // id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker
    public final void MyBillsEntityDataFactory(final String p0, final boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        final long KClassImpl$Data$declaredNonStaticMembers$2 = ((SendMoneyFeatureTime) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
        final long MyBillsEntityDataFactory = ((SendMoneyFeatureTime) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).MyBillsEntityDataFactory();
        if (KClassImpl$Data$declaredNonStaticMembers$2 == 0 || MyBillsEntityDataFactory == 0) {
            return;
        }
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker$trackRequestMoneyOpen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.REQUEST_MONEY_OPEN;
                builder.BuiltInFictitiousFunctionClassFactory("Render Time", MyBillsEntityDataFactory);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.HIT_TIME, KClassImpl$Data$declaredNonStaticMembers$2);
                builder.BuiltInFictitiousFunctionClassFactory("Is Success", SendMoneyMixpanelTracker.getAuthRequestContext(this).getMyBillsEntityDataFactory());
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.IS_QRIS, p1);
                builder.MyBillsEntityDataFactory("Source", p0);
            }
        });
        ((SendMoneyFeatureTime) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).getAuthRequestContext();
    }
}

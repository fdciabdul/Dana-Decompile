package id.dana.qriscrossborder;

import dagger.Lazy;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.qriscrossborder.interactor.GetQrisCountryCodeByLocation;
import id.dana.domain.qriscrossborder.interactor.GetQrisCrossBorderConfig;
import id.dana.domain.qriscrossborder.interactor.GetQrisCrossBorderContent;
import id.dana.domain.qriscrossborder.interactor.GetQrisCrossBorderCountries;
import id.dana.domain.qriscrossborder.interactor.GetQrisCurrentCountryCode;
import id.dana.domain.qriscrossborder.interactor.GetQrisOriginCountryCode;
import id.dana.domain.qriscrossborder.interactor.SaveQrisCurrentCountryCode;
import id.dana.domain.qriscrossborder.interactor.SaveQrisOriginCountryCode;
import id.dana.domain.qriscrossborder.interactor.SendRiskEventWithParams;
import id.dana.domain.qriscrossborder.model.QrisCrossBorderContent;
import id.dana.model.QrisCrossBorderContentModel;
import id.dana.qriscrossborder.QrisCrossBorderContract;
import id.dana.qriscrossborder.mapper.QrisCrossBorderModelMapperKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 .2\u00020\u0001:\u0001.B\u008f\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020!\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000e\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000e\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0004\b,\u0010-J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u001d\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\rR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0010R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0010R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0018\u0010\u0012\u001a\u0006*\u00020\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#"}, d2 = {"Lid/dana/qriscrossborder/QrisCrossBorderPresenter;", "Lid/dana/qriscrossborder/QrisCrossBorderContract$Presenter;", "", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Z)V", "PlaceComponentResult", "()V", "onDestroy", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "Ldagger/Lazy;", "Lid/dana/domain/qriscrossborder/interactor/GetQrisCountryCodeByLocation;", "Ldagger/Lazy;", "Lid/dana/domain/qriscrossborder/interactor/GetQrisCrossBorderConfig;", "getErrorConfigVersion", "Lid/dana/domain/qriscrossborder/interactor/GetQrisCrossBorderContent;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/qriscrossborder/interactor/GetQrisCrossBorderCountries;", "getAuthRequestContext", "Lid/dana/domain/qriscrossborder/interactor/GetQrisCurrentCountryCode;", "Lid/dana/domain/qriscrossborder/interactor/GetQrisOriginCountryCode;", "lookAheadTest", "Lid/dana/domain/qriscrossborder/interactor/SaveQrisCurrentCountryCode;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/qriscrossborder/interactor/SaveQrisOriginCountryCode;", "scheduleImpl", "Lid/dana/domain/qriscrossborder/interactor/SendRiskEventWithParams;", "moveToNextValue", "Ljava/lang/String;", "Lid/dana/qriscrossborder/QrisCrossBorderContract$View;", "initRecordTimeStamp", "Lid/dana/qriscrossborder/QrisCrossBorderContract$View;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "<init>", "(Lid/dana/qriscrossborder/QrisCrossBorderContract$View;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QrisCrossBorderPresenter implements QrisCrossBorderContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final Lazy<GetQrisCurrentCountryCode> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Lazy<GetQrisCrossBorderContent> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final Lazy<GetQrisCountryCodeByLocation> BuiltInFictitiousFunctionClassFactory;
    private final Lazy<SaveQrisCurrentCountryCode> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Lazy<GetQrisCrossBorderCountries> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final Lazy<SendRiskEventWithParams> moveToNextValue;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<GetQrisCrossBorderConfig> MyBillsEntityDataFactory;
    private final QrisCrossBorderContract.View initRecordTimeStamp;
    private final Lazy<GetQrisOriginCountryCode> lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final String getErrorConfigVersion;
    private final Lazy<SaveQrisOriginCountryCode> scheduleImpl;

    @Inject
    public QrisCrossBorderPresenter(QrisCrossBorderContract.View view, Lazy<GetQrisCrossBorderConfig> lazy, Lazy<GetQrisCrossBorderCountries> lazy2, Lazy<GetQrisCountryCodeByLocation> lazy3, Lazy<GetQrisCurrentCountryCode> lazy4, Lazy<GetQrisOriginCountryCode> lazy5, Lazy<SaveQrisOriginCountryCode> lazy6, Lazy<SaveQrisCurrentCountryCode> lazy7, Lazy<GetQrisCrossBorderContent> lazy8, Lazy<SendRiskEventWithParams> lazy9) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        Intrinsics.checkNotNullParameter(lazy9, "");
        this.initRecordTimeStamp = view;
        this.MyBillsEntityDataFactory = lazy;
        this.getAuthRequestContext = lazy2;
        this.BuiltInFictitiousFunctionClassFactory = lazy3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy4;
        this.lookAheadTest = lazy5;
        this.scheduleImpl = lazy6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy7;
        this.PlaceComponentResult = lazy8;
        this.moveToNextValue = lazy9;
        this.getErrorConfigVersion = "QrisCrossBorderPresenter";
    }

    public final void BuiltInFictitiousFunctionClassFactory(final String p0, final boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.lookAheadTest.get().execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$getOriginCountryCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                boolean z = p1;
                if (!z) {
                    this.BuiltInFictitiousFunctionClassFactory(p0);
                    this.MyBillsEntityDataFactory(p0, false);
                } else if (z) {
                    if (str.length() == 0) {
                        str = p0;
                    }
                    final QrisCrossBorderPresenter qrisCrossBorderPresenter = this;
                    final String str2 = p0;
                    Intrinsics.checkNotNullParameter(str, "");
                    Intrinsics.checkNotNullParameter(str2, "");
                    qrisCrossBorderPresenter.moveToNextValue.get().execute(SendRiskEventWithParams.Params.INSTANCE.forSendRiskEventWithParams(str, str2), new Function1<Boolean, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$sendRiskEvent$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z2) {
                            QrisCrossBorderPresenter.this.BuiltInFictitiousFunctionClassFactory(str2);
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$sendRiskEvent$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            QrisCrossBorderContract.View view;
                            String str3;
                            Intrinsics.checkNotNullParameter(th, "");
                            view = QrisCrossBorderPresenter.this.initRecordTimeStamp;
                            view.onError(th.getMessage());
                            str3 = QrisCrossBorderPresenter.this.getErrorConfigVersion;
                            DanaLog.BuiltInFictitiousFunctionClassFactory(str3, th.getMessage());
                        }
                    });
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$getOriginCountryCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                QrisCrossBorderContract.View view;
                String str;
                Intrinsics.checkNotNullParameter(th, "");
                view = QrisCrossBorderPresenter.this.initRecordTimeStamp;
                view.onError(th.getMessage());
                str = QrisCrossBorderPresenter.this.getErrorConfigVersion;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, th.getMessage());
            }
        });
    }

    public final void MyBillsEntityDataFactory(final String p0, final boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(p0, new Function1<Boolean, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$setCurrentCountryCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (p1) {
                    final QrisCrossBorderPresenter qrisCrossBorderPresenter = this;
                    final String str = p0;
                    Intrinsics.checkNotNullParameter(str, "");
                    qrisCrossBorderPresenter.PlaceComponentResult.get().execute(str, new Function1<QrisCrossBorderContent, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$getQrisCrossBorderContent$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(QrisCrossBorderContent qrisCrossBorderContent) {
                            invoke2(qrisCrossBorderContent);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(QrisCrossBorderContent qrisCrossBorderContent) {
                            QrisCrossBorderContract.View view;
                            Intrinsics.checkNotNullParameter(qrisCrossBorderContent, "");
                            view = QrisCrossBorderPresenter.this.initRecordTimeStamp;
                            QrisCrossBorderContentModel KClassImpl$Data$declaredNonStaticMembers$2 = QrisCrossBorderModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(qrisCrossBorderContent);
                            String str2 = str;
                            Locale locale = Locale.getDefault();
                            Intrinsics.checkNotNullExpressionValue(locale, "");
                            String lowerCase = str2.toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                            view.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, lowerCase);
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$getQrisCrossBorderContent$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            QrisCrossBorderContract.View view;
                            String str2;
                            Intrinsics.checkNotNullParameter(th, "");
                            view = QrisCrossBorderPresenter.this.initRecordTimeStamp;
                            view.onError(th.getMessage());
                            str2 = QrisCrossBorderPresenter.this.getErrorConfigVersion;
                            DanaLog.BuiltInFictitiousFunctionClassFactory(str2, th.getMessage());
                        }
                    });
                    this.BuiltInFictitiousFunctionClassFactory(p0, true);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$setCurrentCountryCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                QrisCrossBorderContract.View view;
                String str;
                Intrinsics.checkNotNullParameter(th, "");
                view = QrisCrossBorderPresenter.this.initRecordTimeStamp;
                view.onError(th.getMessage());
                str = QrisCrossBorderPresenter.this.getErrorConfigVersion;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, th.getMessage());
            }
        });
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.scheduleImpl.get().execute(p0, new Function1<Boolean, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$setOriginCountryCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                QrisCrossBorderContract.View view;
                view = QrisCrossBorderPresenter.this.initRecordTimeStamp;
                view.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$setOriginCountryCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                QrisCrossBorderContract.View view;
                String str;
                Intrinsics.checkNotNullParameter(th, "");
                view = QrisCrossBorderPresenter.this.initRecordTimeStamp;
                view.onError(th.getMessage());
                str = QrisCrossBorderPresenter.this.getErrorConfigVersion;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, th.getMessage());
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.get().dispose();
        this.getAuthRequestContext.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.lookAheadTest.get().dispose();
        this.PlaceComponentResult.get().dispose();
        this.scheduleImpl.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
    }

    @Override // id.dana.qriscrossborder.QrisCrossBorderContract.Presenter
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$checkQrisCrossBorderFeatureSwitch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                QrisCrossBorderContract.View view;
                if (!z) {
                    view = QrisCrossBorderPresenter.this.initRecordTimeStamp;
                    view.KClassImpl$Data$declaredNonStaticMembers$2();
                    return;
                }
                final QrisCrossBorderPresenter qrisCrossBorderPresenter = QrisCrossBorderPresenter.this;
                qrisCrossBorderPresenter.getAuthRequestContext.get().execute(NoParams.INSTANCE, new Function1<List<? extends String>, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$getQrisCrossBorderSupportedCountries$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                        invoke2((List<String>) list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(final List<String> list) {
                        Intrinsics.checkNotNullParameter(list, "");
                        final QrisCrossBorderPresenter qrisCrossBorderPresenter2 = QrisCrossBorderPresenter.this;
                        Intrinsics.checkNotNullParameter(list, "");
                        qrisCrossBorderPresenter2.BuiltInFictitiousFunctionClassFactory.get().execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$getQrisCountryCodeByLocation$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                                invoke2(str);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(final String str) {
                                Intrinsics.checkNotNullParameter(str, "");
                                Iterator<T> it = list.iterator();
                                boolean z2 = false;
                                while (it.hasNext()) {
                                    if (Intrinsics.areEqual((String) it.next(), str)) {
                                        z2 = true;
                                    }
                                }
                                if (!Intrinsics.areEqual(str, "ID") && z2) {
                                    final QrisCrossBorderPresenter qrisCrossBorderPresenter3 = qrisCrossBorderPresenter2;
                                    Intrinsics.checkNotNullParameter(str, "");
                                    qrisCrossBorderPresenter3.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$getCurrentCountryCode$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(String str2) {
                                            invoke2(str2);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(String str2) {
                                            QrisCrossBorderContract.View view2;
                                            Intrinsics.checkNotNullParameter(str2, "");
                                            if (!(str2.length() == 0) && Intrinsics.areEqual(str2, str)) {
                                                view2 = qrisCrossBorderPresenter3.initRecordTimeStamp;
                                                view2.KClassImpl$Data$declaredNonStaticMembers$2();
                                                return;
                                            }
                                            qrisCrossBorderPresenter3.MyBillsEntityDataFactory(str, true);
                                        }
                                    }, new Function1<Throwable, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$getCurrentCountryCode$2
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                            invoke2(th);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(Throwable th) {
                                            QrisCrossBorderContract.View view2;
                                            String str2;
                                            Intrinsics.checkNotNullParameter(th, "");
                                            view2 = QrisCrossBorderPresenter.this.initRecordTimeStamp;
                                            view2.onError(th.getMessage());
                                            str2 = QrisCrossBorderPresenter.this.getErrorConfigVersion;
                                            DanaLog.BuiltInFictitiousFunctionClassFactory(str2, th.getMessage());
                                        }
                                    });
                                    return;
                                }
                                qrisCrossBorderPresenter2.BuiltInFictitiousFunctionClassFactory(str, false);
                            }
                        }, new Function1<Throwable, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$getQrisCountryCodeByLocation$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th) {
                                QrisCrossBorderContract.View view2;
                                String str;
                                Intrinsics.checkNotNullParameter(th, "");
                                view2 = QrisCrossBorderPresenter.this.initRecordTimeStamp;
                                view2.onError(th.getMessage());
                                str = QrisCrossBorderPresenter.this.getErrorConfigVersion;
                                DanaLog.BuiltInFictitiousFunctionClassFactory(str, th.getMessage());
                            }
                        });
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$getQrisCrossBorderSupportedCountries$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        QrisCrossBorderContract.View view2;
                        String str;
                        Intrinsics.checkNotNullParameter(th, "");
                        view2 = QrisCrossBorderPresenter.this.initRecordTimeStamp;
                        view2.onError(th.getMessage());
                        str = QrisCrossBorderPresenter.this.getErrorConfigVersion;
                        DanaLog.BuiltInFictitiousFunctionClassFactory(str, th.getMessage());
                    }
                });
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.qriscrossborder.QrisCrossBorderPresenter$checkQrisCrossBorderFeatureSwitch$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                QrisCrossBorderContract.View view;
                String str;
                Intrinsics.checkNotNullParameter(th, "");
                view = QrisCrossBorderPresenter.this.initRecordTimeStamp;
                view.onError(th.getMessage());
                str = QrisCrossBorderPresenter.this.getErrorConfigVersion;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, th.getMessage());
            }
        });
    }
}

package id.dana.myprofile.settingconfig;

import id.dana.domain.deeplink.model.DeepLink;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.domain.referral.model.MyReferralConsultRpcResponse;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ReferralSettingConfigRunner implements SettingConfigurationRunner {
    private final MyReferralConsultRepository BuiltInFictitiousFunctionClassFactory;
    public MyReferralConsultRpcResponse MyBillsEntityDataFactory;
    final GenerateLinkRepository PlaceComponentResult;
    public String getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ MyReferralConsultRpcResponse KClassImpl$Data$declaredNonStaticMembers$2(MyReferralConsultRpcResponse myReferralConsultRpcResponse) throws Exception {
        return myReferralConsultRpcResponse;
    }

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public String getSettingName() {
        return "setting_referral";
    }

    @Inject
    public ReferralSettingConfigRunner(GenerateLinkRepository generateLinkRepository, MyReferralConsultRepository myReferralConsultRepository) {
        this.PlaceComponentResult = generateLinkRepository;
        this.BuiltInFictitiousFunctionClassFactory = myReferralConsultRepository;
    }

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public Observable<SettingModel> performConfiguration(final SettingModel settingModel) {
        return this.BuiltInFictitiousFunctionClassFactory.getReferralConsult().onErrorResumeNext(new Function() { // from class: id.dana.myprofile.settingconfig.ReferralSettingConfigRunner$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource just;
                Throwable th = (Throwable) obj;
                just = Observable.just(new MyReferralConsultRpcResponse());
                return just;
            }
        }).doOnNext(new Consumer() { // from class: id.dana.myprofile.settingconfig.ReferralSettingConfigRunner$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ReferralSettingConfigRunner.this.MyBillsEntityDataFactory = (MyReferralConsultRpcResponse) obj;
            }
        }).flatMap(new Function() { // from class: id.dana.myprofile.settingconfig.ReferralSettingConfigRunner$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                final ReferralSettingConfigRunner referralSettingConfigRunner = ReferralSettingConfigRunner.this;
                final MyReferralConsultRpcResponse myReferralConsultRpcResponse = (MyReferralConsultRpcResponse) obj;
                return referralSettingConfigRunner.PlaceComponentResult.generateReferralDeepLink(referralSettingConfigRunner.MyBillsEntityDataFactory.getReferralCode()).onErrorResumeNext(Observable.just(new DeepLink(""))).doOnNext(new Consumer() { // from class: id.dana.myprofile.settingconfig.ReferralSettingConfigRunner$$ExternalSyntheticLambda4
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj2) {
                        ReferralSettingConfigRunner.this.getAuthRequestContext = ((DeepLink) obj2).getLink();
                    }
                }).map(new Function() { // from class: id.dana.myprofile.settingconfig.ReferralSettingConfigRunner$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj2) {
                        DeepLink deepLink = (DeepLink) obj2;
                        return ReferralSettingConfigRunner.KClassImpl$Data$declaredNonStaticMembers$2(MyReferralConsultRpcResponse.this);
                    }
                });
            }
        }).map(new Function() { // from class: id.dana.myprofile.settingconfig.ReferralSettingConfigRunner$$ExternalSyntheticLambda5
            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: id.dana.myprofile.settingconfig.ReferralSettingConfigRunner.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.domain.profilemenu.model.SettingModel, id.dana.domain.referral.model.MyReferralConsultRpcResponse):id.dana.domain.profilemenu.model.SettingModel
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
                	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
                	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:63)
                	... 1 more
                */
            @Override // io.reactivex.functions.Function
            public final java.lang.Object apply(java.lang.Object r2) {
                /*
                    r1 = this;
                    id.dana.domain.profilemenu.model.SettingModel r0 = id.dana.domain.profilemenu.model.SettingModel.this
                    id.dana.domain.referral.model.MyReferralConsultRpcResponse r2 = (id.dana.domain.referral.model.MyReferralConsultRpcResponse) r2
                    id.dana.domain.profilemenu.model.SettingModel r2 = id.dana.myprofile.settingconfig.ReferralSettingConfigRunner.KClassImpl$Data$declaredNonStaticMembers$2(r0, r2)
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.settingconfig.ReferralSettingConfigRunner$$ExternalSyntheticLambda5.apply(java.lang.Object):java.lang.Object");
            }
        });
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ id.dana.domain.profilemenu.model.SettingModel KClassImpl$Data$declaredNonStaticMembers$2(id.dana.domain.profilemenu.model.SettingModel r0, id.dana.domain.referral.model.MyReferralConsultRpcResponse r1) throws java.lang.Exception {
        /*
            boolean r1 = r1.isCampaignEnable()
            r0.setNeedToShow(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.settingconfig.ReferralSettingConfigRunner.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.domain.profilemenu.model.SettingModel, id.dana.domain.referral.model.MyReferralConsultRpcResponse):id.dana.domain.profilemenu.model.SettingModel");
    }
}

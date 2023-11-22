package com.twilio.verify.domain.service;

import android.content.Context;
import com.twilio.verify.domain.factor.FactorFacade;
import com.twilio.verify.networking.Authentication;
import com.twilio.verify.networking.NetworkProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/twilio/verify/domain/service/ServiceFacade;", "", "Lcom/twilio/verify/domain/factor/FactorFacade;", "PlaceComponentResult", "Lcom/twilio/verify/domain/factor/FactorFacade;", "Lcom/twilio/verify/domain/service/ServiceProvider;", "getAuthRequestContext", "Lcom/twilio/verify/domain/service/ServiceProvider;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Lcom/twilio/verify/domain/service/ServiceProvider;Lcom/twilio/verify/domain/factor/FactorFacade;)V", "Builder"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class ServiceFacade {
    private final FactorFacade PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ServiceProvider KClassImpl$Data$declaredNonStaticMembers$2;

    public ServiceFacade(ServiceProvider serviceProvider, FactorFacade factorFacade) {
        Intrinsics.checkParameterIsNotNull(serviceProvider, "");
        Intrinsics.checkParameterIsNotNull(factorFacade, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = serviceProvider;
        this.PlaceComponentResult = factorFacade;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0016\u0010\u0003\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010"}, d2 = {"Lcom/twilio/verify/domain/service/ServiceFacade$Builder;", "", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "getAuthRequestContext", "Lcom/twilio/verify/networking/Authentication;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/twilio/verify/networking/Authentication;", "Lcom/twilio/verify/domain/factor/FactorFacade;", "BuiltInFictitiousFunctionClassFactory", "Lcom/twilio/verify/domain/factor/FactorFacade;", "Lcom/twilio/verify/networking/NetworkProvider;", "Lcom/twilio/verify/networking/NetworkProvider;", "PlaceComponentResult", "", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 8, 0})
    /* loaded from: classes.dex */
    public static final class Builder {
        public FactorFacade BuiltInFictitiousFunctionClassFactory;
        public Authentication KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public Context getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public String MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public NetworkProvider PlaceComponentResult;

        public static final /* synthetic */ FactorFacade BuiltInFictitiousFunctionClassFactory(Builder builder) {
            FactorFacade factorFacade = builder.BuiltInFictitiousFunctionClassFactory;
            if (factorFacade == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return factorFacade;
        }

        public static final /* synthetic */ Authentication KClassImpl$Data$declaredNonStaticMembers$2(Builder builder) {
            Authentication authentication = builder.KClassImpl$Data$declaredNonStaticMembers$2;
            if (authentication == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return authentication;
        }

        public static final /* synthetic */ String MyBillsEntityDataFactory(Builder builder) {
            String str = builder.MyBillsEntityDataFactory;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return str;
        }

        public static final /* synthetic */ Context PlaceComponentResult(Builder builder) {
            Context context = builder.getAuthRequestContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return context;
        }

        public static final /* synthetic */ NetworkProvider getAuthRequestContext(Builder builder) {
            NetworkProvider networkProvider = builder.PlaceComponentResult;
            if (networkProvider == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return networkProvider;
        }
    }
}

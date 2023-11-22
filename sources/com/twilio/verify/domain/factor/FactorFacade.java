package com.twilio.verify.domain.factor;

import android.content.Context;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.data.KeyStorage;
import com.twilio.verify.data.StorageException;
import com.twilio.verify.models.Factor;
import com.twilio.verify.networking.Authentication;
import com.twilio.verify.networking.NetworkProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0010\u0012\u0006\u0010\u0007\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J=\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lcom/twilio/verify/domain/factor/FactorFacade;", "", "", "p0", "Lkotlin/Function1;", "Lcom/twilio/verify/models/Factor;", "", "p1", "Lcom/twilio/verify/TwilioVerifyException;", "p2", "MyBillsEntityDataFactory", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/domain/factor/FactorProvider;", "PlaceComponentResult", "Lcom/twilio/verify/domain/factor/FactorProvider;", "BuiltInFictitiousFunctionClassFactory", "Lcom/twilio/verify/domain/factor/PushFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/twilio/verify/domain/factor/PushFactory;", "<init>", "(Lcom/twilio/verify/domain/factor/PushFactory;Lcom/twilio/verify/domain/factor/FactorProvider;)V", "Builder"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class FactorFacade {
    private final PushFactory KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final FactorProvider BuiltInFictitiousFunctionClassFactory;

    public FactorFacade(PushFactory pushFactory, FactorProvider factorProvider) {
        Intrinsics.checkParameterIsNotNull(pushFactory, "");
        Intrinsics.checkParameterIsNotNull(factorProvider, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pushFactory;
        this.BuiltInFictitiousFunctionClassFactory = factorProvider;
    }

    public final void MyBillsEntityDataFactory(String p0, Function1<? super Factor, Unit> p1, Function1<? super TwilioVerifyException, Unit> p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        try {
            Factor PlaceComponentResult = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(p0);
            if (PlaceComponentResult != null) {
                p1.invoke(PlaceComponentResult);
                return;
            }
            StorageException storageException = new StorageException("Factor not found");
            Logger logger = Logger.PlaceComponentResult;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, storageException.toString(), storageException);
            throw new TwilioVerifyException(storageException, TwilioVerifyException.ErrorCode.StorageError);
        } catch (TwilioVerifyException e) {
            p2.invoke(e);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\t\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lcom/twilio/verify/domain/factor/FactorFacade$Builder;", "", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "Lcom/twilio/verify/networking/Authentication;", "getAuthRequestContext", "Lcom/twilio/verify/networking/Authentication;", "Lcom/twilio/verify/data/KeyStorage;", "MyBillsEntityDataFactory", "Lcom/twilio/verify/data/KeyStorage;", "PlaceComponentResult", "Lcom/twilio/verify/networking/NetworkProvider;", "Lcom/twilio/verify/networking/NetworkProvider;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 8, 0})
    /* loaded from: classes.dex */
    public static final class Builder {
        public String BuiltInFictitiousFunctionClassFactory;
        public Context KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public KeyStorage PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public NetworkProvider MyBillsEntityDataFactory;
        public Authentication getAuthRequestContext;

        public static final /* synthetic */ NetworkProvider BuiltInFictitiousFunctionClassFactory(Builder builder) {
            NetworkProvider networkProvider = builder.MyBillsEntityDataFactory;
            if (networkProvider == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return networkProvider;
        }

        public static final /* synthetic */ Context KClassImpl$Data$declaredNonStaticMembers$2(Builder builder) {
            Context context = builder.KClassImpl$Data$declaredNonStaticMembers$2;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return context;
        }

        public static final /* synthetic */ String MyBillsEntityDataFactory(Builder builder) {
            String str = builder.BuiltInFictitiousFunctionClassFactory;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return str;
        }

        public static final /* synthetic */ KeyStorage PlaceComponentResult(Builder builder) {
            KeyStorage keyStorage = builder.PlaceComponentResult;
            if (keyStorage == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return keyStorage;
        }

        public static final /* synthetic */ Authentication getAuthRequestContext(Builder builder) {
            Authentication authentication = builder.getAuthRequestContext;
            if (authentication == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return authentication;
        }
    }
}

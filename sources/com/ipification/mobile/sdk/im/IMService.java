package com.ipification.mobile.sdk.im;

import com.ipification.mobile.sdk.im.di.RepositoryModule;
import com.ipification.mobile.sdk.im.repository.SessionRepository;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/ipification/mobile/sdk/im/IMService;", "", "<init>", "()V", "Factory"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class IMService {
    private static IMTheme KClassImpl$Data$declaredNonStaticMembers$2;
    private static VerifyCompleteListener getAuthRequestContext;

    /* renamed from: Factory  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static IMLocale MyBillsEntityDataFactory = new IMLocale(null, null, null, null, null, null, 0, 127, null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\n\u001a\u00020\u00058\u0001@\u0001X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\f8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0003\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\b\u0010\u0012"}, d2 = {"Lcom/ipification/mobile/sdk/im/IMService$Factory;", "", "Lcom/ipification/mobile/sdk/im/repository/SessionRepository;", "getAuthRequestContext", "()Lcom/ipification/mobile/sdk/im/repository/SessionRepository;", "Lcom/ipification/mobile/sdk/im/IMLocale;", "MyBillsEntityDataFactory", "Lcom/ipification/mobile/sdk/im/IMLocale;", "BuiltInFictitiousFunctionClassFactory", "()Lcom/ipification/mobile/sdk/im/IMLocale;", "PlaceComponentResult", "(Lcom/ipification/mobile/sdk/im/IMLocale;)V", "Lcom/ipification/mobile/sdk/im/VerifyCompleteListener;", "Lcom/ipification/mobile/sdk/im/VerifyCompleteListener;", "Lcom/ipification/mobile/sdk/im/IMTheme;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/ipification/mobile/sdk/im/IMTheme;", "()Lcom/ipification/mobile/sdk/im/IMTheme;", "(Lcom/ipification/mobile/sdk/im/IMTheme;)V", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.ipification.mobile.sdk.im.IMService$Factory  reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        public static IMLocale BuiltInFictitiousFunctionClassFactory() {
            return IMService.MyBillsEntityDataFactory;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        public static void BuiltInFictitiousFunctionClassFactory(IMTheme iMTheme) {
            IMService.KClassImpl$Data$declaredNonStaticMembers$2 = iMTheme;
        }

        @JvmName(name = "PlaceComponentResult")
        public static void PlaceComponentResult(IMLocale iMLocale) {
            Intrinsics.checkParameterIsNotNull(iMLocale, "");
            IMService.MyBillsEntityDataFactory = iMLocale;
        }

        public static SessionRepository getAuthRequestContext() {
            RepositoryModule.Companion companion = RepositoryModule.INSTANCE;
            return RepositoryModule.Companion.getAuthRequestContext().MyBillsEntityDataFactory();
        }
    }
}

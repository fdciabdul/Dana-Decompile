package com.ipification.mobile.sdk.im.di;

import com.ipification.mobile.sdk.im.data.SessionDataSource;
import com.ipification.mobile.sdk.im.repository.SessionRepository;
import com.ipification.mobile.sdk.im.repository.SessionRepositoryImpl;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/ipification/mobile/sdk/im/di/RepositoryModule;", "", "Lcom/ipification/mobile/sdk/im/repository/SessionRepository;", "MyBillsEntityDataFactory", "()Lcom/ipification/mobile/sdk/im/repository/SessionRepository;", "PlaceComponentResult", "Lcom/ipification/mobile/sdk/im/repository/SessionRepository;", "<init>", "()V", "Companion", "Holder"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RepositoryModule {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private SessionRepository MyBillsEntityDataFactory;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/ipification/mobile/sdk/im/di/RepositoryModule$Companion;", "", "Lcom/ipification/mobile/sdk/im/di/RepositoryModule;", "getAuthRequestContext", "()Lcom/ipification/mobile/sdk/im/di/RepositoryModule;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static RepositoryModule getAuthRequestContext() {
            Holder holder = Holder.INSTANCE;
            return Holder.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/ipification/mobile/sdk/im/di/RepositoryModule$Holder;", "", "Lcom/ipification/mobile/sdk/im/di/RepositoryModule;", "BuiltInFictitiousFunctionClassFactory", "Lcom/ipification/mobile/sdk/im/di/RepositoryModule;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lcom/ipification/mobile/sdk/im/di/RepositoryModule;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Holder {
        public static final Holder INSTANCE = new Holder();

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private static final RepositoryModule KClassImpl$Data$declaredNonStaticMembers$2 = new RepositoryModule();

        private Holder() {
        }
    }

    public final SessionRepository MyBillsEntityDataFactory() {
        SessionRepository sessionRepository;
        synchronized (this) {
            sessionRepository = this.MyBillsEntityDataFactory;
            if (sessionRepository == null && sessionRepository == null) {
                sessionRepository = new SessionRepositoryImpl(new SessionDataSource());
                this.MyBillsEntityDataFactory = sessionRepository;
            }
        }
        return sessionRepository;
    }
}

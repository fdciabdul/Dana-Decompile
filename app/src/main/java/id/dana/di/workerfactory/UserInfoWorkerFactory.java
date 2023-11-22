package id.dana.di.workerfactory;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import id.dana.data.user.UserInfoWorker;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000b"}, d2 = {"Lid/dana/di/workerfactory/UserInfoWorkerFactory;", "Lid/dana/di/workerfactory/ChildWorkerFactory;", "Landroid/content/Context;", "p0", "Landroidx/work/WorkerParameters;", "p1", "Landroidx/work/ListenableWorker;", "MyBillsEntityDataFactory", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)Landroidx/work/ListenableWorker;", "Ljavax/inject/Provider;", "Lid/dana/domain/user/repository/UserRepository;", "Ljavax/inject/Provider;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Ljavax/inject/Provider;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserInfoWorkerFactory implements ChildWorkerFactory {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Provider<UserRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public UserInfoWorkerFactory(Provider<UserRepository> provider) {
        Intrinsics.checkNotNullParameter(provider, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    @Override // id.dana.di.workerfactory.ChildWorkerFactory
    public final ListenableWorker MyBillsEntityDataFactory(Context p0, WorkerParameters p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        UserRepository userRepository = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        Intrinsics.checkNotNullExpressionValue(userRepository, "");
        return new UserInfoWorker(p0, p1, userRepository);
    }
}

package id.dana.sendmoney.data.repository.groupsend.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GroupSendPreference_Factory implements Factory<GroupSendPreference> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;

    private GroupSendPreference_Factory(Provider<Context> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GroupSendPreference_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider) {
        return new GroupSendPreference_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GroupSendPreference(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

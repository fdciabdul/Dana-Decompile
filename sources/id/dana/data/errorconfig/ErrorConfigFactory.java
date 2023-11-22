package id.dana.data.errorconfig;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.errorconfig.local.LocalErrorConfigEntityData;
import id.dana.data.errorconfig.network.NetworkErrorConfigEntityData;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class ErrorConfigFactory extends AbstractEntityDataFactory<ErrorConfigEntityData> {
    private final LocalErrorConfigEntityData localErrorConfigEntityData;
    private final NetworkErrorConfigEntityData networkErrorConfigEntityData;

    @Inject
    public ErrorConfigFactory(NetworkErrorConfigEntityData networkErrorConfigEntityData, LocalErrorConfigEntityData localErrorConfigEntityData) {
        this.networkErrorConfigEntityData = networkErrorConfigEntityData;
        this.localErrorConfigEntityData = localErrorConfigEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public ErrorConfigEntityData createData2(String str) {
        str.hashCode();
        if (str.equals("local")) {
            return this.localErrorConfigEntityData;
        }
        if (str.equals("network")) {
            return this.networkErrorConfigEntityData;
        }
        return this.localErrorConfigEntityData;
    }
}

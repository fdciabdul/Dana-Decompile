package id.dana.domain.featureconfig.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/featureconfig/model/AnbuConfig;", "", "", "featureWarmHomeDialog", "Ljava/lang/Boolean;", "getFeatureWarmHomeDialog", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnbuConfig {
    public Boolean featureWarmHomeDialog;

    public /* synthetic */ AnbuConfig() {
    }

    public AnbuConfig(Boolean bool) {
        this.featureWarmHomeDialog = bool;
    }

    @JvmName(name = "getFeatureWarmHomeDialog")
    public final Boolean getFeatureWarmHomeDialog() {
        return this.featureWarmHomeDialog;
    }
}

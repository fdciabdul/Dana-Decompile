package id.dana.domain.home.model;

import id.dana.domain.danaprotection.model.DanaProtectionWidgetConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007"}, d2 = {"Lid/dana/domain/home/model/DanaProtectionHomeWidgetModel;", "", "Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;", "component1", "()Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;", "Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;", "component2", "()Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;", "config", "danaProtectionHomeWidgetInfoModel", "copy", "(Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;)Lid/dana/domain/home/model/DanaProtectionHomeWidgetModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;", "getConfig", "Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;", "getDanaProtectionHomeWidgetInfoModel", "<init>", "(Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DanaProtectionHomeWidgetModel {
    private final DanaProtectionWidgetConfig config;
    private final DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.domain.danaprotection.model.DanaProtectionWidgetConfig, id.dana.domain.home.model.DanaProtectionHomeWidgetInfoModel, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DanaProtectionHomeWidgetModel() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.home.model.DanaProtectionHomeWidgetModel.<init>():void");
    }

    public static /* synthetic */ DanaProtectionHomeWidgetModel copy$default(DanaProtectionHomeWidgetModel danaProtectionHomeWidgetModel, DanaProtectionWidgetConfig danaProtectionWidgetConfig, DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel, int i, Object obj) {
        if ((i & 1) != 0) {
            danaProtectionWidgetConfig = danaProtectionHomeWidgetModel.config;
        }
        if ((i & 2) != 0) {
            danaProtectionHomeWidgetInfoModel = danaProtectionHomeWidgetModel.danaProtectionHomeWidgetInfoModel;
        }
        return danaProtectionHomeWidgetModel.copy(danaProtectionWidgetConfig, danaProtectionHomeWidgetInfoModel);
    }

    /* renamed from: component1  reason: from getter */
    public final DanaProtectionWidgetConfig getConfig() {
        return this.config;
    }

    /* renamed from: component2  reason: from getter */
    public final DanaProtectionHomeWidgetInfoModel getDanaProtectionHomeWidgetInfoModel() {
        return this.danaProtectionHomeWidgetInfoModel;
    }

    public final DanaProtectionHomeWidgetModel copy(DanaProtectionWidgetConfig config, DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel) {
        return new DanaProtectionHomeWidgetModel(config, danaProtectionHomeWidgetInfoModel);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DanaProtectionHomeWidgetModel) {
            DanaProtectionHomeWidgetModel danaProtectionHomeWidgetModel = (DanaProtectionHomeWidgetModel) other;
            return Intrinsics.areEqual(this.config, danaProtectionHomeWidgetModel.config) && Intrinsics.areEqual(this.danaProtectionHomeWidgetInfoModel, danaProtectionHomeWidgetModel.danaProtectionHomeWidgetInfoModel);
        }
        return false;
    }

    public final int hashCode() {
        DanaProtectionWidgetConfig danaProtectionWidgetConfig = this.config;
        int hashCode = danaProtectionWidgetConfig == null ? 0 : danaProtectionWidgetConfig.hashCode();
        DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel = this.danaProtectionHomeWidgetInfoModel;
        return (hashCode * 31) + (danaProtectionHomeWidgetInfoModel != null ? danaProtectionHomeWidgetInfoModel.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DanaProtectionHomeWidgetModel(config=");
        sb.append(this.config);
        sb.append(", danaProtectionHomeWidgetInfoModel=");
        sb.append(this.danaProtectionHomeWidgetInfoModel);
        sb.append(')');
        return sb.toString();
    }

    public DanaProtectionHomeWidgetModel(DanaProtectionWidgetConfig danaProtectionWidgetConfig, DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel) {
        this.config = danaProtectionWidgetConfig;
        this.danaProtectionHomeWidgetInfoModel = danaProtectionHomeWidgetInfoModel;
    }

    public /* synthetic */ DanaProtectionHomeWidgetModel(DanaProtectionWidgetConfig danaProtectionWidgetConfig, DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : danaProtectionWidgetConfig, (i & 2) != 0 ? null : danaProtectionHomeWidgetInfoModel);
    }

    @JvmName(name = "getConfig")
    public final DanaProtectionWidgetConfig getConfig() {
        return this.config;
    }

    @JvmName(name = "getDanaProtectionHomeWidgetInfoModel")
    public final DanaProtectionHomeWidgetInfoModel getDanaProtectionHomeWidgetInfoModel() {
        return this.danaProtectionHomeWidgetInfoModel;
    }
}

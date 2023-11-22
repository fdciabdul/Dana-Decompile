package id.dana.mybills.ui.model.service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u00002\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\"\u0010!J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8G@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR(\u0010\u001b\u001a\u00020\u00068\u0007@\u0007X\u0086\u000e¢\u0006\u0018\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b \u0010!\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/mybills/ui/model/service/CategoryServiceModel;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "chipName", "Ljava/lang/String;", "getChipName", "()Ljava/lang/String;", "setChipName", "(Ljava/lang/String;)V", "id", "getId", "setId", "isSelected", "Z", "()Z", "setSelected", "(Z)V", "name", "getName", "setName", "viewType", "I", "getViewType", "setViewType", "(I)V", "getViewType$annotations", "()V", "<init>", "ViewType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CategoryServiceModel {
    private String chipName;
    private String id;
    private boolean isSelected;
    private String name;
    private int viewType;

    public static /* synthetic */ void getViewType$annotations() {
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "setId")
    public final void setId(String str) {
        this.id = str;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "setName")
    public final void setName(String str) {
        this.name = str;
    }

    @JvmName(name = "setChipName")
    public final void setChipName(String str) {
        this.chipName = str;
    }

    @JvmName(name = "getChipName")
    public final String getChipName() {
        String str = this.chipName;
        return str == null ? this.name : str;
    }

    @JvmName(name = "isSelected")
    /* renamed from: isSelected  reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    @JvmName(name = "setSelected")
    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    @JvmName(name = "getViewType")
    public final int getViewType() {
        return this.viewType;
    }

    @JvmName(name = "setViewType")
    public final void setViewType(int i) {
        this.viewType = i;
    }

    public final boolean equals(Object other) {
        if (other instanceof CategoryServiceModel) {
            if (other == this) {
                return true;
            }
            CategoryServiceModel categoryServiceModel = (CategoryServiceModel) other;
            String str = categoryServiceModel.id;
            if (str == null) {
                int i = categoryServiceModel.viewType;
                return i != 0 && i == this.viewType;
            }
            return Intrinsics.areEqual(str, this.id);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.id;
        return ((str != null ? str.hashCode() : 0) * 31) + this.viewType;
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/mybills/ui/model/service/CategoryServiceModel$ViewType;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ViewType {
        public static final int CATEGORY_VIEW = 1;

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int SHIMMER_VIEW = 2;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/model/service/CategoryServiceModel$ViewType$Companion;", "", "", "CATEGORY_VIEW", "I", "SHIMMER_VIEW", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int CATEGORY_VIEW = 1;
            public static final int SHIMMER_VIEW = 2;

            private Companion() {
            }
        }
    }
}

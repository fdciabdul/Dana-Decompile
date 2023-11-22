package id.dana.domain.autoroute.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b.\u0010/J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004JR\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001d\u0010\bR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010!R$\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\b\"\u0004\b$\u0010%R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\u0004\"\u0004\b(\u0010)R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010&\u001a\u0004\b*\u0010\u0004\"\u0004\b+\u0010)R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010&\u001a\u0004\b,\u0010\u0004\"\u0004\b-\u0010)"}, d2 = {"Lid/dana/domain/autoroute/model/AutoRouteInit;", "", "", "component1", "()Ljava/lang/Boolean;", "component2", "", "component3", "()Ljava/lang/String;", "", "Lid/dana/domain/autoroute/model/AuthenticationTypeOption;", "component4", "()Ljava/util/List;", "component5", "autorouteFeatureEnable", "autorouteConfigEnable", "authenticationType", "authenticationSettingOptions", "autorouteAssetExist", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)Lid/dana/domain/autoroute/model/AutoRouteInit;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isShowAutoRoute", "()Z", "toString", "Ljava/util/List;", "getAuthenticationSettingOptions", "setAuthenticationSettingOptions", "(Ljava/util/List;)V", "Ljava/lang/String;", "getAuthenticationType", "setAuthenticationType", "(Ljava/lang/String;)V", "Ljava/lang/Boolean;", "getAutorouteAssetExist", "setAutorouteAssetExist", "(Ljava/lang/Boolean;)V", "getAutorouteConfigEnable", "setAutorouteConfigEnable", "getAutorouteFeatureEnable", "setAutorouteFeatureEnable", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AutoRouteInit {
    private List<AuthenticationTypeOption> authenticationSettingOptions;
    private String authenticationType;
    private Boolean autorouteAssetExist;
    private Boolean autorouteConfigEnable;
    private Boolean autorouteFeatureEnable;

    public AutoRouteInit() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ AutoRouteInit copy$default(AutoRouteInit autoRouteInit, Boolean bool, Boolean bool2, String str, List list, Boolean bool3, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = autoRouteInit.autorouteFeatureEnable;
        }
        if ((i & 2) != 0) {
            bool2 = autoRouteInit.autorouteConfigEnable;
        }
        Boolean bool4 = bool2;
        if ((i & 4) != 0) {
            str = autoRouteInit.authenticationType;
        }
        String str2 = str;
        List<AuthenticationTypeOption> list2 = list;
        if ((i & 8) != 0) {
            list2 = autoRouteInit.authenticationSettingOptions;
        }
        List list3 = list2;
        if ((i & 16) != 0) {
            bool3 = autoRouteInit.autorouteAssetExist;
        }
        return autoRouteInit.copy(bool, bool4, str2, list3, bool3);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getAutorouteFeatureEnable() {
        return this.autorouteFeatureEnable;
    }

    /* renamed from: component2  reason: from getter */
    public final Boolean getAutorouteConfigEnable() {
        return this.autorouteConfigEnable;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAuthenticationType() {
        return this.authenticationType;
    }

    public final List<AuthenticationTypeOption> component4() {
        return this.authenticationSettingOptions;
    }

    /* renamed from: component5  reason: from getter */
    public final Boolean getAutorouteAssetExist() {
        return this.autorouteAssetExist;
    }

    public final AutoRouteInit copy(Boolean autorouteFeatureEnable, Boolean autorouteConfigEnable, String authenticationType, List<AuthenticationTypeOption> authenticationSettingOptions, Boolean autorouteAssetExist) {
        return new AutoRouteInit(autorouteFeatureEnable, autorouteConfigEnable, authenticationType, authenticationSettingOptions, autorouteAssetExist);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AutoRouteInit) {
            AutoRouteInit autoRouteInit = (AutoRouteInit) other;
            return Intrinsics.areEqual(this.autorouteFeatureEnable, autoRouteInit.autorouteFeatureEnable) && Intrinsics.areEqual(this.autorouteConfigEnable, autoRouteInit.autorouteConfigEnable) && Intrinsics.areEqual(this.authenticationType, autoRouteInit.authenticationType) && Intrinsics.areEqual(this.authenticationSettingOptions, autoRouteInit.authenticationSettingOptions) && Intrinsics.areEqual(this.autorouteAssetExist, autoRouteInit.autorouteAssetExist);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.autorouteFeatureEnable;
        int hashCode = bool == null ? 0 : bool.hashCode();
        Boolean bool2 = this.autorouteConfigEnable;
        int hashCode2 = bool2 == null ? 0 : bool2.hashCode();
        String str = this.authenticationType;
        int hashCode3 = str == null ? 0 : str.hashCode();
        List<AuthenticationTypeOption> list = this.authenticationSettingOptions;
        int hashCode4 = list == null ? 0 : list.hashCode();
        Boolean bool3 = this.autorouteAssetExist;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (bool3 != null ? bool3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AutoRouteInit(autorouteFeatureEnable=");
        sb.append(this.autorouteFeatureEnable);
        sb.append(", autorouteConfigEnable=");
        sb.append(this.autorouteConfigEnable);
        sb.append(", authenticationType=");
        sb.append(this.authenticationType);
        sb.append(", authenticationSettingOptions=");
        sb.append(this.authenticationSettingOptions);
        sb.append(", autorouteAssetExist=");
        sb.append(this.autorouteAssetExist);
        sb.append(')');
        return sb.toString();
    }

    public AutoRouteInit(Boolean bool, Boolean bool2, String str, List<AuthenticationTypeOption> list, Boolean bool3) {
        AuthenticationTypeOption authenticationTypeOption;
        this.autorouteFeatureEnable = bool;
        this.autorouteConfigEnable = bool2;
        this.authenticationType = str;
        this.authenticationSettingOptions = list;
        this.autorouteAssetExist = bool3;
        this.authenticationType = (list == null || (authenticationTypeOption = (AuthenticationTypeOption) CollectionsKt.getOrNull(list, 0)) == null) ? null : authenticationTypeOption.getAuthenticationType();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AutoRouteInit(java.lang.Boolean r5, java.lang.Boolean r6, java.lang.String r7, java.util.List r8, java.lang.Boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            java.lang.Boolean r11 = java.lang.Boolean.FALSE
            r0 = r10 & 1
            if (r0 == 0) goto L8
            r0 = r11
            goto L9
        L8:
            r0 = r5
        L9:
            r5 = r10 & 2
            if (r5 == 0) goto Lf
            r1 = r11
            goto L10
        Lf:
            r1 = r6
        L10:
            r5 = r10 & 4
            r6 = 0
            if (r5 == 0) goto L17
            r2 = r6
            goto L18
        L17:
            r2 = r7
        L18:
            r5 = r10 & 8
            if (r5 == 0) goto L1e
            r3 = r6
            goto L1f
        L1e:
            r3 = r8
        L1f:
            r5 = r10 & 16
            if (r5 != 0) goto L25
            r10 = r9
            goto L26
        L25:
            r10 = r11
        L26:
            r5 = r4
            r6 = r0
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.autoroute.model.AutoRouteInit.<init>(java.lang.Boolean, java.lang.Boolean, java.lang.String, java.util.List, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getAutorouteFeatureEnable")
    public final Boolean getAutorouteFeatureEnable() {
        return this.autorouteFeatureEnable;
    }

    @JvmName(name = "setAutorouteFeatureEnable")
    public final void setAutorouteFeatureEnable(Boolean bool) {
        this.autorouteFeatureEnable = bool;
    }

    @JvmName(name = "getAutorouteConfigEnable")
    public final Boolean getAutorouteConfigEnable() {
        return this.autorouteConfigEnable;
    }

    @JvmName(name = "setAutorouteConfigEnable")
    public final void setAutorouteConfigEnable(Boolean bool) {
        this.autorouteConfigEnable = bool;
    }

    @JvmName(name = "getAuthenticationType")
    public final String getAuthenticationType() {
        return this.authenticationType;
    }

    @JvmName(name = "setAuthenticationType")
    public final void setAuthenticationType(String str) {
        this.authenticationType = str;
    }

    @JvmName(name = "getAuthenticationSettingOptions")
    public final List<AuthenticationTypeOption> getAuthenticationSettingOptions() {
        return this.authenticationSettingOptions;
    }

    @JvmName(name = "setAuthenticationSettingOptions")
    public final void setAuthenticationSettingOptions(List<AuthenticationTypeOption> list) {
        this.authenticationSettingOptions = list;
    }

    @JvmName(name = "getAutorouteAssetExist")
    public final Boolean getAutorouteAssetExist() {
        return this.autorouteAssetExist;
    }

    @JvmName(name = "setAutorouteAssetExist")
    public final void setAutorouteAssetExist(Boolean bool) {
        this.autorouteAssetExist = bool;
    }

    public final boolean isShowAutoRoute() {
        Boolean bool = this.autorouteFeatureEnable;
        Boolean bool2 = Boolean.TRUE;
        return Intrinsics.areEqual(bool, bool2) && Intrinsics.areEqual(this.autorouteConfigEnable, Boolean.FALSE) && Intrinsics.areEqual(this.autorouteAssetExist, bool2);
    }
}

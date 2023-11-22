package androidx.work;

import android.os.Build;

/* loaded from: classes2.dex */
public final class Constraints {
    public static final Constraints PlaceComponentResult = new Constraints(new Builder());
    public boolean BuiltInFictitiousFunctionClassFactory;
    public ContentUriTriggers KClassImpl$Data$declaredNonStaticMembers$2;
    public NetworkType MyBillsEntityDataFactory;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    public boolean getAuthRequestContext;
    public boolean getErrorConfigVersion;
    public long moveToNextValue;
    public long scheduleImpl;

    /* loaded from: classes2.dex */
    public static final class Builder {
        public boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
        public boolean BuiltInFictitiousFunctionClassFactory = false;
        public NetworkType PlaceComponentResult = NetworkType.NOT_REQUIRED;
        public boolean MyBillsEntityDataFactory = false;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        long getErrorConfigVersion = -1;
        long moveToNextValue = -1;
        ContentUriTriggers getAuthRequestContext = new ContentUriTriggers();
    }

    public Constraints() {
        this.MyBillsEntityDataFactory = NetworkType.NOT_REQUIRED;
        this.scheduleImpl = -1L;
        this.moveToNextValue = -1L;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ContentUriTriggers();
    }

    public Constraints(Builder builder) {
        this.MyBillsEntityDataFactory = NetworkType.NOT_REQUIRED;
        this.scheduleImpl = -1L;
        this.moveToNextValue = -1L;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ContentUriTriggers();
        this.getAuthRequestContext = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        this.getErrorConfigVersion = Build.VERSION.SDK_INT >= 23 && builder.BuiltInFictitiousFunctionClassFactory;
        this.MyBillsEntityDataFactory = builder.PlaceComponentResult;
        this.BuiltInFictitiousFunctionClassFactory = builder.MyBillsEntityDataFactory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = builder.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (Build.VERSION.SDK_INT >= 24) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.getAuthRequestContext;
            this.scheduleImpl = builder.getErrorConfigVersion;
            this.moveToNextValue = builder.moveToNextValue;
        }
    }

    public Constraints(Constraints constraints) {
        this.MyBillsEntityDataFactory = NetworkType.NOT_REQUIRED;
        this.scheduleImpl = -1L;
        this.moveToNextValue = -1L;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ContentUriTriggers();
        this.getAuthRequestContext = constraints.getAuthRequestContext;
        this.getErrorConfigVersion = constraints.getErrorConfigVersion;
        this.MyBillsEntityDataFactory = constraints.MyBillsEntityDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = constraints.BuiltInFictitiousFunctionClassFactory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraints.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraints.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }

    public final boolean getAuthRequestContext() {
        return this.getErrorConfigVersion;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean PlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.size() > 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.getAuthRequestContext == constraints.getAuthRequestContext && this.getErrorConfigVersion == constraints.getErrorConfigVersion && this.BuiltInFictitiousFunctionClassFactory == constraints.BuiltInFictitiousFunctionClassFactory && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == constraints.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.scheduleImpl == constraints.scheduleImpl && this.moveToNextValue == constraints.moveToNextValue && this.MyBillsEntityDataFactory == constraints.MyBillsEntityDataFactory) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.equals(constraints.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.MyBillsEntityDataFactory.hashCode();
        boolean z = this.getAuthRequestContext;
        boolean z2 = this.getErrorConfigVersion;
        boolean z3 = this.BuiltInFictitiousFunctionClassFactory;
        boolean z4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        long j = this.scheduleImpl;
        long j2 = this.moveToNextValue;
        return (((((((((((((hashCode * 31) + (z ? 1 : 0)) * 31) + (z2 ? 1 : 0)) * 31) + (z3 ? 1 : 0)) * 31) + (z4 ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
    }
}

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes3.dex */
class EngineKey implements Key {
    private final Object KClassImpl$Data$declaredNonStaticMembers$2;
    private final Key NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final int PlaceComponentResult;
    private int getAuthRequestContext;
    private final Map<Class<?>, Transformation<?>> getErrorConfigVersion;
    private final Class<?> lookAheadTest;
    private final Class<?> moveToNextValue;
    private final Options scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineKey(Object obj, Key key, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Preconditions.PlaceComponentResult(obj);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (Key) Preconditions.BuiltInFictitiousFunctionClassFactory(key, "Signature must not be null");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i;
        this.PlaceComponentResult = i2;
        this.getErrorConfigVersion = (Map) Preconditions.PlaceComponentResult(map);
        this.moveToNextValue = (Class) Preconditions.BuiltInFictitiousFunctionClassFactory(cls, "Resource class must not be null");
        this.lookAheadTest = (Class) Preconditions.BuiltInFictitiousFunctionClassFactory(cls2, "Transcode class must not be null");
        this.scheduleImpl = (Options) Preconditions.PlaceComponentResult(options);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof EngineKey) {
            EngineKey engineKey = (EngineKey) obj;
            return this.KClassImpl$Data$declaredNonStaticMembers$2.equals(engineKey.KClassImpl$Data$declaredNonStaticMembers$2) && this.NetworkUserEntityData$$ExternalSyntheticLambda0.equals(engineKey.NetworkUserEntityData$$ExternalSyntheticLambda0) && this.PlaceComponentResult == engineKey.PlaceComponentResult && this.NetworkUserEntityData$$ExternalSyntheticLambda2 == engineKey.NetworkUserEntityData$$ExternalSyntheticLambda2 && this.getErrorConfigVersion.equals(engineKey.getErrorConfigVersion) && this.moveToNextValue.equals(engineKey.moveToNextValue) && this.lookAheadTest.equals(engineKey.lookAheadTest) && this.scheduleImpl.equals(engineKey.scheduleImpl);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.getAuthRequestContext == 0) {
            int hashCode = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
            this.getAuthRequestContext = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda2) * 31) + this.PlaceComponentResult;
            this.getAuthRequestContext = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.getErrorConfigVersion.hashCode();
            this.getAuthRequestContext = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.moveToNextValue.hashCode();
            this.getAuthRequestContext = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.lookAheadTest.hashCode();
            this.getAuthRequestContext = hashCode5;
            this.getAuthRequestContext = (hashCode5 * 31) + this.scheduleImpl.hashCode();
        }
        return this.getAuthRequestContext;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EngineKey{model=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", width=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", height=");
        sb.append(this.PlaceComponentResult);
        sb.append(", resourceClass=");
        sb.append(this.moveToNextValue);
        sb.append(", transcodeClass=");
        sb.append(this.lookAheadTest);
        sb.append(", signature=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", hashCode=");
        sb.append(this.getAuthRequestContext);
        sb.append(", transformations=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", options=");
        sb.append(this.scheduleImpl);
        sb.append('}');
        return sb.toString();
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}

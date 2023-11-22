package at.wirecube.additiveanimations.additive_animator;

import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.graphics.Path;
import android.util.Property;
import at.wirecube.additiveanimations.additive_animator.animation_set.AnimationState;
import at.wirecube.additiveanimations.helper.evaluators.PathEvaluator;

/* loaded from: classes3.dex */
public class AdditiveAnimation<T> {
    float BuiltInFictitiousFunctionClassFactory;
    T DatabaseTableConfigUtil;
    float GetContactSyncConfig;
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    TimeInterpolator MyBillsEntityDataFactory;
    Property<T, Float> NetworkUserEntityData$$ExternalSyntheticLambda0;
    String NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    AnimationState<T> PlaceComponentResult;
    AccumulatedAnimationValue getAuthRequestContext;
    PathEvaluator getErrorConfigVersion;
    float initRecordTimeStamp;
    TypeEvaluator<Float> lookAheadTest;
    PathEvaluator.PathMode moveToNextValue;
    Path scheduleImpl;

    public AdditiveAnimation(T t, Property<T, Float> property, float f, float f2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.DatabaseTableConfigUtil = t;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = property;
        this.GetContactSyncConfig = f2;
        this.initRecordTimeStamp = f;
        String name = property.getName();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = name;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = (name.hashCode() * 262143) + this.DatabaseTableConfigUtil.hashCode();
    }

    public AdditiveAnimation(T t, String str, float f, float f2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.DatabaseTableConfigUtil = t;
        this.initRecordTimeStamp = f;
        this.GetContactSyncConfig = f2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = (str.hashCode() * 262143) + this.DatabaseTableConfigUtil.hashCode();
    }

    public AdditiveAnimation(T t, String str, float f, Path path, PathEvaluator.PathMode pathMode, PathEvaluator pathEvaluator) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.DatabaseTableConfigUtil = t;
        this.initRecordTimeStamp = f;
        this.scheduleImpl = path;
        this.getErrorConfigVersion = pathEvaluator;
        this.moveToNextValue = pathMode;
        this.GetContactSyncConfig = PlaceComponentResult(1.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = (str.hashCode() * 262143) + this.DatabaseTableConfigUtil.hashCode();
    }

    public AdditiveAnimation(T t, Property<T, Float> property, float f, Path path, PathEvaluator.PathMode pathMode, PathEvaluator pathEvaluator) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.DatabaseTableConfigUtil = t;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = property;
        this.initRecordTimeStamp = f;
        this.scheduleImpl = path;
        this.getErrorConfigVersion = pathEvaluator;
        this.moveToNextValue = pathMode;
        this.GetContactSyncConfig = PlaceComponentResult(1.0f);
        String name = property.getName();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = name;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = (name.hashCode() * 262143) + this.DatabaseTableConfigUtil.hashCode();
    }

    public final boolean PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final float PlaceComponentResult(float f) {
        TimeInterpolator timeInterpolator = this.MyBillsEntityDataFactory;
        if (timeInterpolator != null) {
            f = timeInterpolator.getInterpolation(f);
        }
        Path path = this.scheduleImpl;
        if (path != null) {
            return this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(f, this.moveToNextValue, path);
        }
        TypeEvaluator<Float> typeEvaluator = this.lookAheadTest;
        if (typeEvaluator != null) {
            return typeEvaluator.evaluate(f, Float.valueOf(this.initRecordTimeStamp), Float.valueOf(this.GetContactSyncConfig)).floatValue();
        }
        float f2 = this.initRecordTimeStamp;
        return f2 + ((this.GetContactSyncConfig - f2) * f);
    }

    public int hashCode() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdditiveAnimation) {
            AdditiveAnimation additiveAnimation = (AdditiveAnimation) obj;
            return additiveAnimation.NetworkUserEntityData$$ExternalSyntheticLambda1.hashCode() == this.NetworkUserEntityData$$ExternalSyntheticLambda1.hashCode() && additiveAnimation.DatabaseTableConfigUtil == this.DatabaseTableConfigUtil;
        }
        return false;
    }
}

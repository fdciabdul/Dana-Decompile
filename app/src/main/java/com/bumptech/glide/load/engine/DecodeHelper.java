package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class DecodeHelper<Transcode> {
    int BuiltInFictitiousFunctionClassFactory;
    int GetContactSyncConfig;
    GlideContext KClassImpl$Data$declaredNonStaticMembers$2;
    DiskCacheStrategy MyBillsEntityDataFactory;
    Object NetworkUserEntityData$$ExternalSyntheticLambda0;
    Key NetworkUserEntityData$$ExternalSyntheticLambda1;
    Map<Class<?>, Transformation<?>> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    DecodeJob.DiskCacheProvider PlaceComponentResult;
    private boolean PrepareContext;
    boolean getAuthRequestContext;
    Class<?> getErrorConfigVersion;
    Class<Transcode> initRecordTimeStamp;
    Options lookAheadTest;
    boolean moveToNextValue;
    Priority scheduleImpl;
    private final List<ModelLoader.LoadData<?>> newProxyInstance = new ArrayList();
    private final List<Key> DatabaseTableConfigUtil = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        this.getErrorConfigVersion = null;
        this.initRecordTimeStamp = null;
        this.lookAheadTest = null;
        this.scheduleImpl = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        this.MyBillsEntityDataFactory = null;
        this.newProxyInstance.clear();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
        this.DatabaseTableConfigUtil.clear();
        this.PrepareContext = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <Z> Transformation<Z> getAuthRequestContext(Class<Z> cls) {
        Transformation<Z> transformation = (Transformation<Z>) this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(cls);
        if (transformation == null) {
            Iterator<Map.Entry<Class<?>, Transformation<?>>> it = this.NetworkUserEntityData$$ExternalSyntheticLambda2.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, Transformation<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    transformation = (Transformation<Z>) next.getValue();
                    break;
                }
            }
        }
        if (transformation == null) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.isEmpty() && this.moveToNextValue) {
                StringBuilder sb = new StringBuilder();
                sb.append("Missing transformation for ");
                sb.append(cls);
                sb.append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
                throw new IllegalArgumentException(sb.toString());
            }
            return UnitTransformation.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return transformation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean MyBillsEntityDataFactory(Resource<?> resource) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(resource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult(Key key) {
        List<ModelLoader.LoadData<?>> PlaceComponentResult = PlaceComponentResult();
        int size = PlaceComponentResult.size();
        for (int i = 0; i < size; i++) {
            if (PlaceComponentResult.get(i).getAuthRequestContext.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<ModelLoader.LoadData<?>> PlaceComponentResult() {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
            this.newProxyInstance.clear();
            List KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            int size = KClassImpl$Data$declaredNonStaticMembers$2.size();
            for (int i = 0; i < size; i++) {
                ModelLoader.LoadData<?> KClassImpl$Data$declaredNonStaticMembers$22 = ((ModelLoader) KClassImpl$Data$declaredNonStaticMembers$2.get(i)).KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.GetContactSyncConfig, this.BuiltInFictitiousFunctionClassFactory, this.lookAheadTest);
                if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                    this.newProxyInstance.add(KClassImpl$Data$declaredNonStaticMembers$22);
                }
            }
        }
        return this.newProxyInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Key> KClassImpl$Data$declaredNonStaticMembers$2() {
        if (!this.PrepareContext) {
            this.PrepareContext = true;
            this.DatabaseTableConfigUtil.clear();
            List<ModelLoader.LoadData<?>> PlaceComponentResult = PlaceComponentResult();
            int size = PlaceComponentResult.size();
            for (int i = 0; i < size; i++) {
                ModelLoader.LoadData<?> loadData = PlaceComponentResult.get(i);
                if (!this.DatabaseTableConfigUtil.contains(loadData.getAuthRequestContext)) {
                    this.DatabaseTableConfigUtil.add(loadData.getAuthRequestContext);
                }
                for (int i2 = 0; i2 < loadData.PlaceComponentResult.size(); i2++) {
                    if (!this.DatabaseTableConfigUtil.contains(loadData.PlaceComponentResult.get(i2))) {
                        this.DatabaseTableConfigUtil.add(loadData.PlaceComponentResult.get(i2));
                    }
                }
            }
        }
        return this.DatabaseTableConfigUtil;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Class<?> cls) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(cls, this.getErrorConfigVersion, this.initRecordTimeStamp) != null;
    }
}

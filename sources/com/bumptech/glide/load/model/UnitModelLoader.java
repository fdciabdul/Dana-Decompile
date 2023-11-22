package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

/* loaded from: classes3.dex */
public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {
    private static final UnitModelLoader<?> getAuthRequestContext = new UnitModelLoader<>();

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final boolean BuiltInFictitiousFunctionClassFactory(Model model) {
        return true;
    }

    public static <T> UnitModelLoader<T> getAuthRequestContext() {
        return (UnitModelLoader<T>) getAuthRequestContext;
    }

    @Deprecated
    public UnitModelLoader() {
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData<Model> KClassImpl$Data$declaredNonStaticMembers$2(Model model, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new UnitFetcher(model));
    }

    /* loaded from: classes3.dex */
    static class UnitFetcher<Model> implements DataFetcher<Model> {
        private final Model MyBillsEntityDataFactory;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        }

        UnitFetcher(Model model) {
            this.MyBillsEntityDataFactory = model;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory(Priority priority, DataFetcher.DataCallback<? super Model> dataCallback) {
            dataCallback.getAuthRequestContext((Model) this.MyBillsEntityDataFactory);
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final Class<Model> getAuthRequestContext() {
            return (Class<Model>) this.MyBillsEntityDataFactory.getClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final DataSource MyBillsEntityDataFactory() {
            return DataSource.LOCAL;
        }
    }

    /* loaded from: classes3.dex */
    public static class Factory<Model> implements ModelLoaderFactory<Model, Model> {
        private static final Factory<?> PlaceComponentResult = new Factory<>();

        public static <T> Factory<T> KClassImpl$Data$declaredNonStaticMembers$2() {
            return (Factory<T>) PlaceComponentResult;
        }

        @Deprecated
        public Factory() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Model, Model> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.getAuthRequestContext();
        }
    }
}

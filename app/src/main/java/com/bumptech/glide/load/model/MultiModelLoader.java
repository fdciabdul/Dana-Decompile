package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {
    private final Pools.Pool<List<Throwable>> KClassImpl$Data$declaredNonStaticMembers$2;
    private final List<ModelLoader<Model, Data>> getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiModelLoader(List<ModelLoader<Model, Data>> list, Pools.Pool<List<Throwable>> pool) {
        this.getAuthRequestContext = list;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pool;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData<Data> KClassImpl$Data$declaredNonStaticMembers$2(Model model, int i, int i2, Options options) {
        ModelLoader.LoadData<Data> KClassImpl$Data$declaredNonStaticMembers$2;
        int size = this.getAuthRequestContext.size();
        ArrayList arrayList = new ArrayList(size);
        Key key = null;
        for (int i3 = 0; i3 < size; i3++) {
            ModelLoader<Model, Data> modelLoader = this.getAuthRequestContext.get(i3);
            if (modelLoader.BuiltInFictitiousFunctionClassFactory(model) && (KClassImpl$Data$declaredNonStaticMembers$2 = modelLoader.KClassImpl$Data$declaredNonStaticMembers$2(model, i, i2, options)) != null) {
                key = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.LoadData<>(key, new MultiFetcher(arrayList, this.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final boolean BuiltInFictitiousFunctionClassFactory(Model model) {
        Iterator<ModelLoader<Model, Data>> it = this.getAuthRequestContext.iterator();
        while (it.hasNext()) {
            if (it.next().BuiltInFictitiousFunctionClassFactory(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiModelLoader{modelLoaders=");
        sb.append(Arrays.toString(this.getAuthRequestContext.toArray()));
        sb.append('}');
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {
        private List<Throwable> BuiltInFictitiousFunctionClassFactory;
        private DataFetcher.DataCallback<? super Data> KClassImpl$Data$declaredNonStaticMembers$2;
        private int MyBillsEntityDataFactory;
        private final List<DataFetcher<Data>> PlaceComponentResult;
        private boolean getAuthRequestContext;
        private final Pools.Pool<List<Throwable>> lookAheadTest;
        private Priority moveToNextValue;

        MultiFetcher(List<DataFetcher<Data>> list, Pools.Pool<List<Throwable>> pool) {
            this.lookAheadTest = pool;
            Preconditions.getAuthRequestContext(list);
            this.PlaceComponentResult = list;
            this.MyBillsEntityDataFactory = 0;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory(Priority priority, DataFetcher.DataCallback<? super Data> dataCallback) {
            this.moveToNextValue = priority;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = dataCallback;
            this.BuiltInFictitiousFunctionClassFactory = this.lookAheadTest.BuiltInFictitiousFunctionClassFactory();
            this.PlaceComponentResult.get(this.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory(priority, this);
            if (this.getAuthRequestContext) {
                BuiltInFictitiousFunctionClassFactory();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            List<Throwable> list = this.BuiltInFictitiousFunctionClassFactory;
            if (list != null) {
                this.lookAheadTest.MyBillsEntityDataFactory(list);
            }
            this.BuiltInFictitiousFunctionClassFactory = null;
            Iterator<DataFetcher<Data>> it = this.PlaceComponentResult.iterator();
            while (it.hasNext()) {
                it.next().KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory() {
            this.getAuthRequestContext = true;
            Iterator<DataFetcher<Data>> it = this.PlaceComponentResult.iterator();
            while (it.hasNext()) {
                it.next().BuiltInFictitiousFunctionClassFactory();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final Class<Data> getAuthRequestContext() {
            return this.PlaceComponentResult.get(0).getAuthRequestContext();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final DataSource MyBillsEntityDataFactory() {
            return this.PlaceComponentResult.get(0).MyBillsEntityDataFactory();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public final void getAuthRequestContext(Data data) {
            if (data != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(data);
            } else {
                PlaceComponentResult();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public final void BuiltInFictitiousFunctionClassFactory(Exception exc) {
            ((List) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory)).add(exc);
            PlaceComponentResult();
        }

        private void PlaceComponentResult() {
            if (this.getAuthRequestContext) {
                return;
            }
            if (this.MyBillsEntityDataFactory < this.PlaceComponentResult.size() - 1) {
                this.MyBillsEntityDataFactory++;
                BuiltInFictitiousFunctionClassFactory(this.moveToNextValue, this.KClassImpl$Data$declaredNonStaticMembers$2);
                return;
            }
            Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(new GlideException("Fetch failed", new ArrayList(this.BuiltInFictitiousFunctionClassFactory)));
        }
    }
}

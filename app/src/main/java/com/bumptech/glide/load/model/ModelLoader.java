package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public interface ModelLoader<Model, Data> {
    boolean BuiltInFictitiousFunctionClassFactory(Model model);

    LoadData<Data> KClassImpl$Data$declaredNonStaticMembers$2(Model model, int i, int i2, Options options);

    /* loaded from: classes3.dex */
    public static class LoadData<Data> {
        public final DataFetcher<Data> BuiltInFictitiousFunctionClassFactory;
        public final List<Key> PlaceComponentResult;
        public final Key getAuthRequestContext;

        public LoadData(Key key, DataFetcher<Data> dataFetcher) {
            this(key, Collections.emptyList(), dataFetcher);
        }

        private LoadData(Key key, List<Key> list, DataFetcher<Data> dataFetcher) {
            this.getAuthRequestContext = (Key) Preconditions.PlaceComponentResult(key);
            this.PlaceComponentResult = (List) Preconditions.PlaceComponentResult(list);
            this.BuiltInFictitiousFunctionClassFactory = (DataFetcher) Preconditions.PlaceComponentResult(dataFetcher);
        }
    }
}

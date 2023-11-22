package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* loaded from: classes.dex */
public abstract class DiskCacheStrategy {
    public static final DiskCacheStrategy KClassImpl$Data$declaredNonStaticMembers$2 = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.1
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean MyBillsEntityDataFactory() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean getAuthRequestContext() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean BuiltInFictitiousFunctionClassFactory(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean BuiltInFictitiousFunctionClassFactory(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };
    public static final DiskCacheStrategy MyBillsEntityDataFactory = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.2
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean BuiltInFictitiousFunctionClassFactory(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean BuiltInFictitiousFunctionClassFactory(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean MyBillsEntityDataFactory() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean getAuthRequestContext() {
            return false;
        }
    };
    public static final DiskCacheStrategy BuiltInFictitiousFunctionClassFactory = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.3
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean BuiltInFictitiousFunctionClassFactory(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean MyBillsEntityDataFactory() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean getAuthRequestContext() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean BuiltInFictitiousFunctionClassFactory(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };
    public static final DiskCacheStrategy PlaceComponentResult = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.4
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean BuiltInFictitiousFunctionClassFactory(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean MyBillsEntityDataFactory() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean getAuthRequestContext() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean BuiltInFictitiousFunctionClassFactory(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };
    public static final DiskCacheStrategy getAuthRequestContext = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.5
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean MyBillsEntityDataFactory() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean getAuthRequestContext() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean BuiltInFictitiousFunctionClassFactory(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean BuiltInFictitiousFunctionClassFactory(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    };

    public abstract boolean BuiltInFictitiousFunctionClassFactory(DataSource dataSource);

    public abstract boolean BuiltInFictitiousFunctionClassFactory(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);

    public abstract boolean MyBillsEntityDataFactory();

    public abstract boolean getAuthRequestContext();
}

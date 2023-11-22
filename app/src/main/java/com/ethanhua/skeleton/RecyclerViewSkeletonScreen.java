package com.ethanhua.skeleton;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class RecyclerViewSkeletonScreen implements SkeletonScreen {
    private final boolean BuiltInFictitiousFunctionClassFactory;
    private final SkeletonAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView MyBillsEntityDataFactory;
    public final RecyclerView.Adapter getAuthRequestContext;

    public /* synthetic */ RecyclerViewSkeletonScreen(Builder builder, byte b) {
        this(builder);
    }

    private RecyclerViewSkeletonScreen(Builder builder) {
        this.MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory;
        this.getAuthRequestContext = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        SkeletonAdapter skeletonAdapter = new SkeletonAdapter();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = skeletonAdapter;
        skeletonAdapter.MyBillsEntityDataFactory = builder.getAuthRequestContext;
        skeletonAdapter.BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory;
        skeletonAdapter.getAuthRequestContext = builder.PlaceComponentResult;
        skeletonAdapter.PlaceComponentResult = builder.getErrorConfigVersion;
        skeletonAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = builder.lookAheadTest;
        skeletonAdapter.moveToNextValue = builder.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.BuiltInFictitiousFunctionClassFactory = builder.scheduleImpl;
    }

    @Override // com.ethanhua.skeleton.SkeletonScreen
    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory.setAdapter(this.KClassImpl$Data$declaredNonStaticMembers$2);
        if (this.MyBillsEntityDataFactory.isComputingLayout() || !this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        this.MyBillsEntityDataFactory.setLayoutFrozen(true);
    }

    @Override // com.ethanhua.skeleton.SkeletonScreen
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.setAdapter(this.getAuthRequestContext);
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public RecyclerView.Adapter KClassImpl$Data$declaredNonStaticMembers$2;
        public final RecyclerView MyBillsEntityDataFactory;
        public int getErrorConfigVersion;
        public boolean PlaceComponentResult = true;
        public int getAuthRequestContext = 10;
        public int BuiltInFictitiousFunctionClassFactory = R.layout.layout_default_item_skeleton;
        public int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1000;
        public int lookAheadTest = 20;
        private boolean scheduleImpl = true;

        public Builder(RecyclerView recyclerView) {
            this.MyBillsEntityDataFactory = recyclerView;
            this.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(recyclerView.getContext(), R.color.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }
}

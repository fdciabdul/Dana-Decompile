package com.otaliastudios.cameraview.size;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public class SizeSelectors {

    /* loaded from: classes8.dex */
    public interface Filter {
        boolean MyBillsEntityDataFactory(Size size);
    }

    public static SizeSelector PlaceComponentResult(final int i) {
        return new FilterSelector(new Filter() { // from class: com.otaliastudios.cameraview.size.SizeSelectors.1
            @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
            public final boolean MyBillsEntityDataFactory(Size size) {
                return size.BuiltInFictitiousFunctionClassFactory <= i;
            }
        }, (byte) 0);
    }

    public static SizeSelector NetworkUserEntityData$$ExternalSyntheticLambda0(final int i) {
        return new FilterSelector(new Filter() { // from class: com.otaliastudios.cameraview.size.SizeSelectors.2
            @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
            public final boolean MyBillsEntityDataFactory(Size size) {
                return size.BuiltInFictitiousFunctionClassFactory >= i;
            }
        }, (byte) 0);
    }

    public static SizeSelector BuiltInFictitiousFunctionClassFactory(final int i) {
        return new FilterSelector(new Filter() { // from class: com.otaliastudios.cameraview.size.SizeSelectors.3
            @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
            public final boolean MyBillsEntityDataFactory(Size size) {
                return size.getAuthRequestContext <= i;
            }
        }, (byte) 0);
    }

    public static SizeSelector getAuthRequestContext(final int i) {
        return new FilterSelector(new Filter() { // from class: com.otaliastudios.cameraview.size.SizeSelectors.4
            @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
            public final boolean MyBillsEntityDataFactory(Size size) {
                return size.getAuthRequestContext >= i;
            }
        }, (byte) 0);
    }

    public static SizeSelector PlaceComponentResult() {
        return new SizeSelector() { // from class: com.otaliastudios.cameraview.size.SizeSelectors.6
            @Override // com.otaliastudios.cameraview.size.SizeSelector
            public final List<Size> PlaceComponentResult(List<Size> list) {
                Collections.sort(list);
                Collections.reverse(list);
                return list;
            }
        };
    }

    public static SizeSelector MyBillsEntityDataFactory() {
        return new SizeSelector() { // from class: com.otaliastudios.cameraview.size.SizeSelectors.7
            @Override // com.otaliastudios.cameraview.size.SizeSelector
            public final List<Size> PlaceComponentResult(List<Size> list) {
                Collections.sort(list);
                return list;
            }
        };
    }

    public static SizeSelector MyBillsEntityDataFactory(final int i) {
        return new FilterSelector(new Filter() { // from class: com.otaliastudios.cameraview.size.SizeSelectors.8
            @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
            public final boolean MyBillsEntityDataFactory(Size size) {
                return size.getAuthRequestContext * size.BuiltInFictitiousFunctionClassFactory <= i;
            }
        }, (byte) 0);
    }

    public static SizeSelector KClassImpl$Data$declaredNonStaticMembers$2(final int i) {
        return new FilterSelector(new Filter() { // from class: com.otaliastudios.cameraview.size.SizeSelectors.9
            @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
            public final boolean MyBillsEntityDataFactory(Size size) {
                return size.getAuthRequestContext * size.BuiltInFictitiousFunctionClassFactory >= i;
            }
        }, (byte) 0);
    }

    public static SizeSelector MyBillsEntityDataFactory(SizeSelector... sizeSelectorArr) {
        return new AndSelector(sizeSelectorArr, (byte) 0);
    }

    public static SizeSelector PlaceComponentResult(SizeSelector... sizeSelectorArr) {
        return new OrSelector(sizeSelectorArr, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class FilterSelector implements SizeSelector {
        private Filter getAuthRequestContext;

        /* synthetic */ FilterSelector(Filter filter, byte b) {
            this(filter);
        }

        private FilterSelector(Filter filter) {
            this.getAuthRequestContext = filter;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelector
        public final List<Size> PlaceComponentResult(List<Size> list) {
            ArrayList arrayList = new ArrayList();
            for (Size size : list) {
                if (this.getAuthRequestContext.MyBillsEntityDataFactory(size)) {
                    arrayList.add(size);
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes8.dex */
    static class AndSelector implements SizeSelector {
        private SizeSelector[] KClassImpl$Data$declaredNonStaticMembers$2;

        /* synthetic */ AndSelector(SizeSelector[] sizeSelectorArr, byte b) {
            this(sizeSelectorArr);
        }

        private AndSelector(SizeSelector... sizeSelectorArr) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = sizeSelectorArr;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelector
        public final List<Size> PlaceComponentResult(List<Size> list) {
            for (SizeSelector sizeSelector : this.KClassImpl$Data$declaredNonStaticMembers$2) {
                list = sizeSelector.PlaceComponentResult(list);
            }
            return list;
        }
    }

    /* loaded from: classes8.dex */
    static class OrSelector implements SizeSelector {
        private SizeSelector[] PlaceComponentResult;

        /* synthetic */ OrSelector(SizeSelector[] sizeSelectorArr, byte b) {
            this(sizeSelectorArr);
        }

        private OrSelector(SizeSelector... sizeSelectorArr) {
            this.PlaceComponentResult = sizeSelectorArr;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelector
        public final List<Size> PlaceComponentResult(List<Size> list) {
            List<Size> list2 = null;
            for (SizeSelector sizeSelector : this.PlaceComponentResult) {
                list2 = sizeSelector.PlaceComponentResult(list);
                if (!list2.isEmpty()) {
                    break;
                }
            }
            return list2 == null ? new ArrayList() : list2;
        }
    }

    public static SizeSelector getAuthRequestContext(AspectRatio aspectRatio) {
        final float f = aspectRatio.getAuthRequestContext / aspectRatio.MyBillsEntityDataFactory;
        return new FilterSelector(new Filter() { // from class: com.otaliastudios.cameraview.size.SizeSelectors.5
            final /* synthetic */ float BuiltInFictitiousFunctionClassFactory = 0.0f;

            @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
            public final boolean MyBillsEntityDataFactory(Size size) {
                AspectRatio BuiltInFictitiousFunctionClassFactory = AspectRatio.BuiltInFictitiousFunctionClassFactory(size.BuiltInFictitiousFunctionClassFactory, size.getAuthRequestContext);
                float f2 = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext / BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
                float f3 = f;
                float f4 = this.BuiltInFictitiousFunctionClassFactory;
                return f2 >= f3 - f4 && f2 <= f3 + f4;
            }
        }, (byte) 0);
    }
}

package Catalano.Imaging.Filters;

import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class BlobsFiltering implements IApplyInPlace {
    private Filter PlaceComponentResult = Filter.Area;
    private Logic getAuthRequestContext = Logic.Or;
    private int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private int BuiltInFictitiousFunctionClassFactory = 0;
    private int MyBillsEntityDataFactory = 0;

    /* loaded from: classes6.dex */
    public enum Filter {
        Area,
        Size
    }

    /* loaded from: classes6.dex */
    public enum Logic {
        Or,
        And
    }

    /* renamed from: Catalano.Imaging.Filters.BlobsFiltering$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[Filter.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[Filter.Area.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[Filter.Size.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}

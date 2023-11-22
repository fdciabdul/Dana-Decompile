package id.dana.sendmoney.ui.globalsend.form.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ViewGlobalSendDynamicFormBinding;
import id.dana.sendmoney.ui.globalsend.form.adapter.GlobalSendDynamicFormAdapter;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormOptionModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CityFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CityModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CountryFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.DefaultFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.EnabledTransferToDebitModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010:\u001a\u00020\u0015\u0012\b\b\u0002\u0010;\u001a\u00020\u0015¢\u0006\u0004\b<\u0010=J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001f\u001a\u00020\u00052\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00050\u001d¢\u0006\u0004\b\u001f\u0010 J'\u0010&\u001a\u00020\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'R*\u0010/\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00158\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R*\u00103\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00158\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\u0016\u0010)\u001a\u0002048\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00105\u001a\u0002078\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b8\u00109"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/view/GlobalSendDynamicFormView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/sendmoney/databinding/ViewGlobalSendDynamicFormBinding;", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryFormModel;", "countryFormModel", "", "changeExchangeRate", "(Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryFormModel;)V", "inflateViewBinding", "()Lid/dana/sendmoney/databinding/ViewGlobalSendDynamicFormBinding;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CityModel;", "cityList", "setCityViewTypeOptionsList", "(Ljava/util/List;)V", "", "viewType", "", "isError", "", "errorMessageString", "setErrorForTransferToDebit", "(IZLjava/lang/String;)V", "Lkotlin/Function1;", "onTransferDestinationItemSelected", "setOnTransferDestinationItemSelected", "(Lkotlin/jvm/functions/Function1;)V", "", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "formList", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "setupForm", "(Ljava/util/List;Landroidx/fragment/app/FragmentManager;)V", "value", "PlaceComponentResult", "I", "getHeaderIcon", "()I", "setHeaderIcon", "(I)V", "headerIcon", "MyBillsEntityDataFactory", "getHeaderTitle", "setHeaderTitle", "headerTitle", "Lid/dana/sendmoney/ui/globalsend/form/adapter/GlobalSendDynamicFormAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/ui/globalsend/form/adapter/GlobalSendDynamicFormAdapter;", "Landroid/content/res/TypedArray;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/res/TypedArray;", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSendDynamicFormView extends BaseViewBindingRichView<ViewGlobalSendDynamicFormBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private TypedArray KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private GlobalSendDynamicFormAdapter PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int headerTitle;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int headerIcon;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlobalSendDynamicFormView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlobalSendDynamicFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlobalSendDynamicFormView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ GlobalSendDynamicFormView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSendDynamicFormView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this.headerIcon = R.drawable.ic_default_person_form;
        this.headerTitle = R.string.header_section_personal_information;
    }

    @JvmName(name = "getHeaderIcon")
    public final int getHeaderIcon() {
        return this.headerIcon;
    }

    @JvmName(name = "setHeaderIcon")
    public final void setHeaderIcon(int i) {
        this.headerIcon = i;
        InstrumentInjector.Resources_setImageResource(getBinding().BuiltInFictitiousFunctionClassFactory, this.headerIcon);
    }

    @JvmName(name = "getHeaderTitle")
    public final int getHeaderTitle() {
        return this.headerTitle;
    }

    @JvmName(name = "setHeaderTitle")
    public final void setHeaderTitle(int i) {
        this.headerTitle = i;
        getBinding().getAuthRequestContext.setText(this.headerTitle);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewGlobalSendDynamicFormBinding inflateViewBinding() {
        ViewGlobalSendDynamicFormBinding PlaceComponentResult = ViewGlobalSendDynamicFormBinding.PlaceComponentResult(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    public final void changeExchangeRate(CountryFormModel countryFormModel) {
        Intrinsics.checkNotNullParameter(countryFormModel, "");
        GlobalSendDynamicFormAdapter globalSendDynamicFormAdapter = this.PlaceComponentResult;
        if (globalSendDynamicFormAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalSendDynamicFormAdapter = null;
        }
        Intrinsics.checkNotNullParameter(countryFormModel, "");
        globalSendDynamicFormAdapter.KClassImpl$Data$declaredNonStaticMembers$2.remove(0);
        globalSendDynamicFormAdapter.KClassImpl$Data$declaredNonStaticMembers$2.add(0, countryFormModel);
        globalSendDynamicFormAdapter.notifyItemChanged(0);
    }

    public static /* synthetic */ void setupForm$default(GlobalSendDynamicFormView globalSendDynamicFormView, List list, FragmentManager fragmentManager, int i, Object obj) {
        if ((i & 2) != 0) {
            fragmentManager = null;
        }
        globalSendDynamicFormView.setupForm(list, fragmentManager);
    }

    public final void setOnTransferDestinationItemSelected(Function1<? super Integer, Unit> onTransferDestinationItemSelected) {
        Intrinsics.checkNotNullParameter(onTransferDestinationItemSelected, "");
        GlobalSendDynamicFormAdapter globalSendDynamicFormAdapter = this.PlaceComponentResult;
        if (globalSendDynamicFormAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalSendDynamicFormAdapter = null;
        }
        Intrinsics.checkNotNullParameter(onTransferDestinationItemSelected, "");
        globalSendDynamicFormAdapter.PlaceComponentResult = onTransferDestinationItemSelected;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void parseAttrs(Context r4, AttributeSet attrs) {
        if (attrs != null) {
            int[] iArr = R.styleable.w;
            Intrinsics.checkNotNullExpressionValue(iArr, "");
            if (r4 != null) {
                TypedArray obtainStyledAttributes = r4.obtainStyledAttributes(attrs, iArr, 0, 0);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes;
            }
            TypedArray typedArray = null;
            try {
                TypedArray typedArray2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (typedArray2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray2 = null;
                }
                setHeaderIcon(typedArray2.getResourceId(R.styleable.z, R.drawable.ic_default_person_form));
                TypedArray typedArray3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (typedArray3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray3 = null;
                }
                setHeaderTitle(typedArray3.getResourceId(R.styleable.RequestMoneyQrContract$View, R.string.header_section_personal_information));
            } finally {
                TypedArray typedArray4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (typedArray4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    typedArray = typedArray4;
                }
                typedArray.recycle();
            }
        }
    }

    public static /* synthetic */ void setErrorForTransferToDebit$default(GlobalSendDynamicFormView globalSendDynamicFormView, int i, boolean z, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        globalSendDynamicFormView.setErrorForTransferToDebit(i, z, str);
    }

    public final void setErrorForTransferToDebit(int viewType, boolean isError, String errorMessageString) {
        Intrinsics.checkNotNullParameter(errorMessageString, "");
        GlobalSendDynamicFormAdapter globalSendDynamicFormAdapter = this.PlaceComponentResult;
        Object obj = null;
        if (globalSendDynamicFormAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalSendDynamicFormAdapter = null;
        }
        Intrinsics.checkNotNullParameter(errorMessageString, "");
        Iterator<T> it = globalSendDynamicFormAdapter.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((GlobalSendFormModel) next).PlaceComponentResult == viewType) {
                obj = next;
                break;
            }
        }
        GlobalSendFormModel globalSendFormModel = (GlobalSendFormModel) obj;
        if (globalSendFormModel != null) {
            int indexOf = globalSendDynamicFormAdapter.KClassImpl$Data$declaredNonStaticMembers$2.indexOf(globalSendFormModel);
            DefaultFormModel defaultFormModel = ((EnabledTransferToDebitModel) globalSendFormModel).KClassImpl$Data$declaredNonStaticMembers$2;
            defaultFormModel.getErrorConfigVersion = isError;
            Intrinsics.checkNotNullParameter(errorMessageString, "");
            defaultFormModel.MyBillsEntityDataFactory = errorMessageString;
            globalSendDynamicFormAdapter.notifyItemChanged(indexOf);
        }
    }

    public final void setCityViewTypeOptionsList(List<CityModel> cityList) {
        Intrinsics.checkNotNullParameter(cityList, "");
        GlobalSendDynamicFormAdapter globalSendDynamicFormAdapter = this.PlaceComponentResult;
        Object obj = null;
        if (globalSendDynamicFormAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalSendDynamicFormAdapter = null;
        }
        Intrinsics.checkNotNullParameter(cityList, "");
        Iterator<T> it = globalSendDynamicFormAdapter.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((GlobalSendFormModel) next).PlaceComponentResult == 17) {
                obj = next;
                break;
            }
        }
        GlobalSendFormModel globalSendFormModel = (GlobalSendFormModel) obj;
        if (globalSendFormModel != null) {
            int indexOf = globalSendDynamicFormAdapter.KClassImpl$Data$declaredNonStaticMembers$2.indexOf(globalSendFormModel);
            CityFormModel cityFormModel = (CityFormModel) globalSendFormModel;
            List<CityModel> list = cityList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(new GlobalSendFormOptionModel(((CityModel) it2.next()).MyBillsEntityDataFactory, null, false, 6, null));
            }
            ArrayList arrayList2 = arrayList;
            Intrinsics.checkNotNullParameter(arrayList2, "");
            cityFormModel.getAuthRequestContext = arrayList2;
            globalSendDynamicFormAdapter.notifyItemChanged(indexOf);
        }
    }

    public final void setupForm(List<GlobalSendFormModel> formList, FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(formList, "");
        this.PlaceComponentResult = new GlobalSendDynamicFormAdapter(formList, fragmentManager);
        RecyclerView recyclerView = getBinding().PlaceComponentResult;
        RecyclerView recyclerView2 = getBinding().PlaceComponentResult;
        if (recyclerView2.getItemDecorationCount() > 0) {
            for (int itemDecorationCount = recyclerView2.getItemDecorationCount() - 1; itemDecorationCount >= 0; itemDecorationCount--) {
                recyclerView2.removeItemDecorationAt(itemDecorationCount);
            }
        }
        GlobalSendDynamicFormAdapter globalSendDynamicFormAdapter = this.PlaceComponentResult;
        if (globalSendDynamicFormAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalSendDynamicFormAdapter = null;
        }
        recyclerView.setAdapter(globalSendDynamicFormAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: id.dana.sendmoney.ui.globalsend.form.view.GlobalSendDynamicFormView$getItemDecorator$1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public final void getItemOffsets(Rect p0, View p1, RecyclerView p2, RecyclerView.State p3) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                Intrinsics.checkNotNullParameter(p3, "");
                int authRequestContext = ViewExtKt.getAuthRequestContext(16.0f);
                if (p2.getChildAdapterPosition(p1) == 0) {
                    p0.top = authRequestContext;
                }
                p0.left = authRequestContext;
                p0.right = authRequestContext;
                p0.bottom = authRequestContext;
            }
        });
    }
}

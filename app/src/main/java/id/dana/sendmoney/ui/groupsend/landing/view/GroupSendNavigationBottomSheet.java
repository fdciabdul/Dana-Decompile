package id.dana.sendmoney.ui.groupsend.landing.view;

import android.app.Dialog;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.core.ui.glide.GlideApp;
import id.dana.sendmoney.R;
import id.dana.sendmoney.constants.GroupSendRecipientType;
import id.dana.sendmoney.databinding.BottomSheetGroupSendNavigationBinding;
import id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity;
import id.dana.sendmoney.ui.groupsend.landing.model.GroupSendScenarioConfigModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B$\u0012\u001b\b\u0002\u0010\r\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u000e¢\u0006\u0002\b!\u0012\u0004\u0012\u00020\u00120 ¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0004\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0004\u0010\u001cR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u001fR)\u0010\u0015\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u000e¢\u0006\u0002\b!\u0012\u0004\u0012\u00020\u00120 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\""}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/view/GroupSendNavigationBottomSheet;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/sendmoney/databinding/BottomSheetGroupSendNavigationBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Z", "Landroid/widget/ImageView;", "p0", "", "p1", "", "p2", "", "getAuthRequestContext", "(Landroid/widget/ImageView;Ljava/lang/String;I)V", "MyBillsEntityDataFactory", "()V", "onStart", "(Landroid/widget/ImageView;)V", "Landroidx/fragment/app/FragmentManager;", "PlaceComponentResult", "(Landroidx/fragment/app/FragmentManager;)V", "(Ljava/lang/String;)V", "", "Lid/dana/sendmoney/ui/groupsend/landing/model/GroupSendScenarioConfigModel;", "Ljava/util/List;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "Lkotlin/jvm/functions/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendNavigationBottomSheet extends BaseViewBindingBottomSheetDialogFragment<BottomSheetGroupSendNavigationBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function1<? super String, Unit> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<GroupSendScenarioConfigModel> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GroupSendNavigationBottomSheet() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.groupsend.landing.view.GroupSendNavigationBottomSheet.<init>():void");
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.48f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BottomSheetGroupSendNavigationBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BottomSheetGroupSendNavigationBinding BuiltInFictitiousFunctionClassFactory = BottomSheetGroupSendNavigationBinding.BuiltInFictitiousFunctionClassFactory(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public /* synthetic */ GroupSendNavigationBottomSheet(AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.view.GroupSendNavigationBottomSheet.1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        } : anonymousClass1);
    }

    public GroupSendNavigationBottomSheet(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.MyBillsEntityDataFactory = function1;
        super.getAuthRequestContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        Dialog dialog = getDialog();
        if (dialog != null) {
            a_(PlaceComponentResult(dialog));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            if (this.BuiltInFictitiousFunctionClassFactory != null) {
                List<GroupSendScenarioConfigModel> list = null;
                if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                    List<GroupSendScenarioConfigModel> list2 = this.BuiltInFictitiousFunctionClassFactory;
                    if (list2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        list = list2;
                    }
                    final GroupSendScenarioConfigModel groupSendScenarioConfigModel = list.get(0);
                    if (!Intrinsics.areEqual(groupSendScenarioConfigModel.PlaceComponentResult, GroupSendRecipientType.BANK)) {
                        if (Intrinsics.areEqual(groupSendScenarioConfigModel.PlaceComponentResult, GroupSendRecipientType.CONTACT)) {
                            if (groupSendScenarioConfigModel.getGetAuthRequestContext()) {
                                VB vb = this.MyBillsEntityDataFactory;
                                if (vb != 0) {
                                    ((BottomSheetGroupSendNavigationBinding) vb).PlaceComponentResult.setEnabled(false);
                                    VB vb2 = this.MyBillsEntityDataFactory;
                                    if (vb2 != 0) {
                                        AppCompatImageView appCompatImageView = ((BottomSheetGroupSendNavigationBinding) vb2).lookAheadTest;
                                        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                                        getAuthRequestContext(appCompatImageView);
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            } else {
                                VB vb3 = this.MyBillsEntityDataFactory;
                                if (vb3 != 0) {
                                    ((BottomSheetGroupSendNavigationBinding) vb3).PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.landing.view.GroupSendNavigationBottomSheet$$ExternalSyntheticLambda1
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            GroupSendNavigationBottomSheet.getAuthRequestContext(GroupSendNavigationBottomSheet.this, groupSendScenarioConfigModel);
                                        }
                                    });
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            }
                            VB vb4 = this.MyBillsEntityDataFactory;
                            if (vb4 != 0) {
                                AppCompatImageView appCompatImageView2 = ((BottomSheetGroupSendNavigationBinding) vb4).lookAheadTest;
                                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                                getAuthRequestContext(appCompatImageView2, groupSendScenarioConfigModel.BuiltInFictitiousFunctionClassFactory, R.drawable.ic_user_default_placeholder);
                                VB vb5 = this.MyBillsEntityDataFactory;
                                if (vb5 != 0) {
                                    ((BottomSheetGroupSendNavigationBinding) vb5).DatabaseTableConfigUtil.setText(groupSendScenarioConfigModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
                                    VB vb6 = this.MyBillsEntityDataFactory;
                                    if (vb6 != 0) {
                                        ((BottomSheetGroupSendNavigationBinding) vb6).GetContactSyncConfig.setText(groupSendScenarioConfigModel.moveToNextValue);
                                        VB vb7 = this.MyBillsEntityDataFactory;
                                        if (vb7 != 0) {
                                            ((BottomSheetGroupSendNavigationBinding) vb7).MyBillsEntityDataFactory.setVisibility(8);
                                        } else {
                                            throw new IllegalArgumentException("Required value was null.".toString());
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        }
                    } else {
                        if (groupSendScenarioConfigModel.getGetAuthRequestContext()) {
                            VB vb8 = this.MyBillsEntityDataFactory;
                            if (vb8 != 0) {
                                ((BottomSheetGroupSendNavigationBinding) vb8).MyBillsEntityDataFactory.setEnabled(false);
                                VB vb9 = this.MyBillsEntityDataFactory;
                                if (vb9 != 0) {
                                    AppCompatImageView appCompatImageView3 = ((BottomSheetGroupSendNavigationBinding) vb9).NetworkUserEntityData$$ExternalSyntheticLambda0;
                                    Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "");
                                    getAuthRequestContext(appCompatImageView3);
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        } else {
                            VB vb10 = this.MyBillsEntityDataFactory;
                            if (vb10 != 0) {
                                ((BottomSheetGroupSendNavigationBinding) vb10).MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.landing.view.GroupSendNavigationBottomSheet$$ExternalSyntheticLambda3
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        GroupSendNavigationBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2(GroupSendNavigationBottomSheet.this, groupSendScenarioConfigModel);
                                    }
                                });
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        }
                        VB vb11 = this.MyBillsEntityDataFactory;
                        if (vb11 != 0) {
                            AppCompatImageView appCompatImageView4 = ((BottomSheetGroupSendNavigationBinding) vb11).NetworkUserEntityData$$ExternalSyntheticLambda0;
                            Intrinsics.checkNotNullExpressionValue(appCompatImageView4, "");
                            getAuthRequestContext(appCompatImageView4, groupSendScenarioConfigModel.BuiltInFictitiousFunctionClassFactory, R.drawable.ic_user_default_placeholder);
                            VB vb12 = this.MyBillsEntityDataFactory;
                            if (vb12 != 0) {
                                ((BottomSheetGroupSendNavigationBinding) vb12).moveToNextValue.setText(groupSendScenarioConfigModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
                                VB vb13 = this.MyBillsEntityDataFactory;
                                if (vb13 != 0) {
                                    ((BottomSheetGroupSendNavigationBinding) vb13).scheduleImpl.setText(groupSendScenarioConfigModel.moveToNextValue);
                                    VB vb14 = this.MyBillsEntityDataFactory;
                                    if (vb14 != 0) {
                                        ((BottomSheetGroupSendNavigationBinding) vb14).PlaceComponentResult.setVisibility(8);
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                } else {
                    List<GroupSendScenarioConfigModel> list3 = this.BuiltInFictitiousFunctionClassFactory;
                    if (list3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        list = list3;
                    }
                    for (final GroupSendScenarioConfigModel groupSendScenarioConfigModel2 : list) {
                        String str = groupSendScenarioConfigModel2.PlaceComponentResult;
                        if (!Intrinsics.areEqual(str, GroupSendRecipientType.BANK)) {
                            if (Intrinsics.areEqual(str, GroupSendRecipientType.CONTACT)) {
                                if (!groupSendScenarioConfigModel2.getGetAuthRequestContext()) {
                                    VB vb15 = this.MyBillsEntityDataFactory;
                                    if (vb15 != 0) {
                                        ((BottomSheetGroupSendNavigationBinding) vb15).PlaceComponentResult.setEnabled(false);
                                        VB vb16 = this.MyBillsEntityDataFactory;
                                        if (vb16 != 0) {
                                            AppCompatImageView appCompatImageView5 = ((BottomSheetGroupSendNavigationBinding) vb16).lookAheadTest;
                                            Intrinsics.checkNotNullExpressionValue(appCompatImageView5, "");
                                            getAuthRequestContext(appCompatImageView5);
                                        } else {
                                            throw new IllegalArgumentException("Required value was null.".toString());
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                } else {
                                    VB vb17 = this.MyBillsEntityDataFactory;
                                    if (vb17 != 0) {
                                        ((BottomSheetGroupSendNavigationBinding) vb17).PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.landing.view.GroupSendNavigationBottomSheet$$ExternalSyntheticLambda4
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view) {
                                                GroupSendNavigationBottomSheet.BuiltInFictitiousFunctionClassFactory(GroupSendNavigationBottomSheet.this, groupSendScenarioConfigModel2);
                                            }
                                        });
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                }
                                VB vb18 = this.MyBillsEntityDataFactory;
                                if (vb18 != 0) {
                                    AppCompatImageView appCompatImageView6 = ((BottomSheetGroupSendNavigationBinding) vb18).lookAheadTest;
                                    Intrinsics.checkNotNullExpressionValue(appCompatImageView6, "");
                                    getAuthRequestContext(appCompatImageView6, groupSendScenarioConfigModel2.BuiltInFictitiousFunctionClassFactory, R.drawable.ic_user_default_placeholder);
                                    VB vb19 = this.MyBillsEntityDataFactory;
                                    if (vb19 != 0) {
                                        ((BottomSheetGroupSendNavigationBinding) vb19).DatabaseTableConfigUtil.setText(groupSendScenarioConfigModel2.NetworkUserEntityData$$ExternalSyntheticLambda0);
                                        VB vb20 = this.MyBillsEntityDataFactory;
                                        if (vb20 != 0) {
                                            ((BottomSheetGroupSendNavigationBinding) vb20).GetContactSyncConfig.setText(groupSendScenarioConfigModel2.moveToNextValue);
                                        } else {
                                            throw new IllegalArgumentException("Required value was null.".toString());
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            } else {
                                continue;
                            }
                        } else {
                            if (!groupSendScenarioConfigModel2.getGetAuthRequestContext()) {
                                VB vb21 = this.MyBillsEntityDataFactory;
                                if (vb21 != 0) {
                                    ((BottomSheetGroupSendNavigationBinding) vb21).MyBillsEntityDataFactory.setEnabled(false);
                                    VB vb22 = this.MyBillsEntityDataFactory;
                                    if (vb22 != 0) {
                                        AppCompatImageView appCompatImageView7 = ((BottomSheetGroupSendNavigationBinding) vb22).NetworkUserEntityData$$ExternalSyntheticLambda0;
                                        Intrinsics.checkNotNullExpressionValue(appCompatImageView7, "");
                                        getAuthRequestContext(appCompatImageView7);
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            } else {
                                VB vb23 = this.MyBillsEntityDataFactory;
                                if (vb23 != 0) {
                                    ((BottomSheetGroupSendNavigationBinding) vb23).MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.landing.view.GroupSendNavigationBottomSheet$$ExternalSyntheticLambda2
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            GroupSendNavigationBottomSheet.PlaceComponentResult(GroupSendNavigationBottomSheet.this, groupSendScenarioConfigModel2);
                                        }
                                    });
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            }
                            VB vb24 = this.MyBillsEntityDataFactory;
                            if (vb24 != 0) {
                                AppCompatImageView appCompatImageView8 = ((BottomSheetGroupSendNavigationBinding) vb24).NetworkUserEntityData$$ExternalSyntheticLambda0;
                                Intrinsics.checkNotNullExpressionValue(appCompatImageView8, "");
                                getAuthRequestContext(appCompatImageView8, groupSendScenarioConfigModel2.BuiltInFictitiousFunctionClassFactory, R.drawable.ic_user_default_placeholder);
                                VB vb25 = this.MyBillsEntityDataFactory;
                                if (vb25 != 0) {
                                    ((BottomSheetGroupSendNavigationBinding) vb25).moveToNextValue.setText(groupSendScenarioConfigModel2.NetworkUserEntityData$$ExternalSyntheticLambda0);
                                    VB vb26 = this.MyBillsEntityDataFactory;
                                    if (vb26 != 0) {
                                        ((BottomSheetGroupSendNavigationBinding) vb26).scheduleImpl.setText(groupSendScenarioConfigModel2.moveToNextValue);
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        }
                    }
                }
            }
            VB vb27 = this.MyBillsEntityDataFactory;
            if (vb27 != 0) {
                ((BottomSheetGroupSendNavigationBinding) vb27).BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.landing.view.GroupSendNavigationBottomSheet$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GroupSendNavigationBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2(GroupSendNavigationBottomSheet.this);
                    }
                });
                View view = getView();
                if (view != null) {
                    view.post(new BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(view, this));
                }
                MyBillsEntityDataFactory(dialog);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        List<GroupSendScenarioConfigModel> list = this.BuiltInFictitiousFunctionClassFactory;
        List<GroupSendScenarioConfigModel> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            list = null;
        }
        if (list.size() < 2) {
            List<GroupSendScenarioConfigModel> list3 = this.BuiltInFictitiousFunctionClassFactory;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                list2 = list3;
            }
            if ((!list2.isEmpty()) != false) {
                return true;
            }
        }
        return false;
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0) {
        FragmentActivity activity = getActivity();
        GroupSendLandingActivity groupSendLandingActivity = activity instanceof GroupSendLandingActivity ? (GroupSendLandingActivity) activity : null;
        if (groupSendLandingActivity != null) {
            groupSendLandingActivity.getGroupSendTrackerHelper().MyBillsEntityDataFactory(p0);
        }
    }

    public final void PlaceComponentResult(FragmentManager p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.show(p0, "GroupSendNavigationDialogFragment");
    }

    private static void getAuthRequestContext(ImageView p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        p0.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        p0.setImageAlpha(200);
    }

    private static void getAuthRequestContext(ImageView p0, String p1, int p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        GlideApp.getAuthRequestContext(p0.getContext()).PlaceComponentResult(p1).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion(p2).PlaceComponentResult(p2).MyBillsEntityDataFactory(p0);
    }

    public static /* synthetic */ void PlaceComponentResult(GroupSendNavigationBottomSheet groupSendNavigationBottomSheet, GroupSendScenarioConfigModel groupSendScenarioConfigModel) {
        Intrinsics.checkNotNullParameter(groupSendNavigationBottomSheet, "");
        Intrinsics.checkNotNullParameter(groupSendScenarioConfigModel, "");
        Function1<? super String, Unit> function1 = groupSendNavigationBottomSheet.MyBillsEntityDataFactory;
        String str = groupSendScenarioConfigModel.PlaceComponentResult;
        function1.invoke(str != null ? str : "");
        groupSendNavigationBottomSheet.BuiltInFictitiousFunctionClassFactory("Bank");
        groupSendNavigationBottomSheet.dismiss();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GroupSendNavigationBottomSheet groupSendNavigationBottomSheet) {
        Intrinsics.checkNotNullParameter(groupSendNavigationBottomSheet, "");
        groupSendNavigationBottomSheet.dismiss();
    }

    public static /* synthetic */ void getAuthRequestContext(GroupSendNavigationBottomSheet groupSendNavigationBottomSheet, GroupSendScenarioConfigModel groupSendScenarioConfigModel) {
        Intrinsics.checkNotNullParameter(groupSendNavigationBottomSheet, "");
        Intrinsics.checkNotNullParameter(groupSendScenarioConfigModel, "");
        Function1<? super String, Unit> function1 = groupSendNavigationBottomSheet.MyBillsEntityDataFactory;
        String str = groupSendScenarioConfigModel.PlaceComponentResult;
        function1.invoke(str != null ? str : "");
        groupSendNavigationBottomSheet.BuiltInFictitiousFunctionClassFactory("Peer");
        groupSendNavigationBottomSheet.dismiss();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GroupSendNavigationBottomSheet groupSendNavigationBottomSheet, GroupSendScenarioConfigModel groupSendScenarioConfigModel) {
        Intrinsics.checkNotNullParameter(groupSendNavigationBottomSheet, "");
        Intrinsics.checkNotNullParameter(groupSendScenarioConfigModel, "");
        Function1<? super String, Unit> function1 = groupSendNavigationBottomSheet.MyBillsEntityDataFactory;
        String str = groupSendScenarioConfigModel.PlaceComponentResult;
        function1.invoke(str != null ? str : "");
        groupSendNavigationBottomSheet.BuiltInFictitiousFunctionClassFactory("Bank");
        groupSendNavigationBottomSheet.dismiss();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GroupSendNavigationBottomSheet groupSendNavigationBottomSheet, GroupSendScenarioConfigModel groupSendScenarioConfigModel) {
        Intrinsics.checkNotNullParameter(groupSendNavigationBottomSheet, "");
        Intrinsics.checkNotNullParameter(groupSendScenarioConfigModel, "");
        Function1<? super String, Unit> function1 = groupSendNavigationBottomSheet.MyBillsEntityDataFactory;
        String str = groupSendScenarioConfigModel.PlaceComponentResult;
        function1.invoke(str != null ? str : "");
        groupSendNavigationBottomSheet.BuiltInFictitiousFunctionClassFactory("Peer");
        groupSendNavigationBottomSheet.dismiss();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BottomSheetGroupSendNavigationBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}

package id.dana.myprofile.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.component.cellcomponent.DanaCellLeftView;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView;
import id.dana.myprofile.viewholder.ProfileMenuFaceAuthViewHolder;
import id.dana.richview.BlueSwitchView;
import id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005R\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000b@GX\u0086\n¢\u0006\f\n\u0004\b\f\u0010\r\"\u0004\b\f\u0010\u000eR\u0012\u0010\u0012\u001a\u00020\u000fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/myprofile/viewholder/ProfileMenuFaceAuthViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "", "dispose", "()V", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "MyBillsEntityDataFactory", "Lid/dana/myprofile/viewholder/ProfileMenuFaceAuthViewHolder$EnrolmentState;", "getAuthRequestContext", "Lid/dana/myprofile/viewholder/ProfileMenuFaceAuthViewHolder$EnrolmentState;", "(Lid/dana/myprofile/viewholder/ProfileMenuFaceAuthViewHolder$EnrolmentState;)V", "", "BuiltInFictitiousFunctionClassFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/myprofile/viewholder/ProfileMenuFaceAuthViewHolder$CheckedListener;", "Lid/dana/myprofile/viewholder/ProfileMenuFaceAuthViewHolder$CheckedListener;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lid/dana/richview/profile/switchfaceauth/SwitchFaceAuthenticationView;", "PlaceComponentResult", "Lid/dana/richview/profile/switchfaceauth/SwitchFaceAuthenticationView;", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "CheckedListener", "EnrolmentState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileMenuFaceAuthViewHolder extends BaseRecyclerViewHolder<SettingModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public CheckedListener MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private SkeletonScreen BuiltInFictitiousFunctionClassFactory;
    private SwitchFaceAuthenticationView PlaceComponentResult;
    private EnrolmentState getAuthRequestContext;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/myprofile/viewholder/ProfileMenuFaceAuthViewHolder$CheckedListener;", "", "", "p0", "", "MyBillsEntityDataFactory", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface CheckedListener {
        void MyBillsEntityDataFactory();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007"}, d2 = {"Lid/dana/myprofile/viewholder/ProfileMenuFaceAuthViewHolder$EnrolmentState;", "", "<init>", "(Ljava/lang/String;I)V", NewSwitchFaceAuthenticationView.FETCHING, NewSwitchFaceAuthenticationView.ERROR_FETCH, NewSwitchFaceAuthenticationView.ENROLLED, NewSwitchFaceAuthenticationView.NOT_ENROLLED}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum EnrolmentState {
        FETCHING,
        ERROR_FETCH,
        ENROLLED,
        NOT_ENROLLED
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[EnrolmentState.values().length];
            iArr[EnrolmentState.ERROR_FETCH.ordinal()] = 1;
            iArr[EnrolmentState.ENROLLED.ordinal()] = 2;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        SwitchFaceAuthenticationView switchFaceAuthenticationView = null;
        if (settingModel2 != null) {
            View view = this.itemView;
            DanaCellLeftView danaCellLeftView = (DanaCellLeftView) view.findViewById(R.id.setDrawValueAboveBar);
            if (danaCellLeftView != null) {
                danaCellLeftView.setCellLabelIcon(settingModel2.getTitle(), R.drawable.ic_info_blue);
            }
            BlueSwitchView blueSwitchView = (BlueSwitchView) view.findViewById(R.id.sv_enable_face_auth);
            if (blueSwitchView != null) {
                blueSwitchView.setChecked(settingModel2.isShareFeed());
            }
            if (this.getAuthRequestContext != EnrolmentState.FETCHING) {
                SkeletonScreen skeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
                if (skeletonScreen != null) {
                    skeletonScreen.PlaceComponentResult();
                }
                this.BuiltInFictitiousFunctionClassFactory = null;
            }
        }
        SwitchFaceAuthenticationView switchFaceAuthenticationView2 = (SwitchFaceAuthenticationView) this.itemView.findViewById(R.id.view_authentication_switch);
        Intrinsics.checkNotNullExpressionValue(switchFaceAuthenticationView2, "");
        this.PlaceComponentResult = switchFaceAuthenticationView2;
        if (switchFaceAuthenticationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            switchFaceAuthenticationView = switchFaceAuthenticationView2;
        }
        switchFaceAuthenticationView.setAuthListener(new SwitchFaceAuthenticationView.AuthFaceListener() { // from class: id.dana.myprofile.viewholder.ProfileMenuFaceAuthViewHolder$bindData$2
            @Override // id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView.AuthFaceListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                ProfileMenuFaceAuthViewHolder.CheckedListener checkedListener;
                checkedListener = ProfileMenuFaceAuthViewHolder.this.MyBillsEntityDataFactory;
                if (checkedListener != null) {
                    checkedListener.MyBillsEntityDataFactory();
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMenuFaceAuthViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_authentication_switchfaceauth, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        MyBillsEntityDataFactory();
        this.getAuthRequestContext = EnrolmentState.FETCHING;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener p0) {
        super.setOnItemClickListener(p0);
        ((BlueSwitchView) this.itemView.findViewById(R.id.sv_enable_face_auth)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.ProfileMenuFaceAuthViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileMenuFaceAuthViewHolder.BuiltInFictitiousFunctionClassFactory(BaseRecyclerViewHolder.OnItemClickListener.this, this);
            }
        });
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void dispose() {
        super.dispose();
        SwitchFaceAuthenticationView switchFaceAuthenticationView = this.PlaceComponentResult;
        if (switchFaceAuthenticationView != null) {
            if (switchFaceAuthenticationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                switchFaceAuthenticationView = null;
            }
            switchFaceAuthenticationView.disposePresenter();
        }
    }

    @JvmName(name = "getAuthRequestContext")
    public final void getAuthRequestContext(EnrolmentState enrolmentState) {
        Intrinsics.checkNotNullParameter(enrolmentState, "");
        this.getAuthRequestContext = enrolmentState;
        SkeletonScreen skeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[enrolmentState.ordinal()];
        if (i == 1) {
            View view = this.itemView;
            ((LinearLayout) view.findViewById(R.id.btn_activate)).setVisibility(8);
            ((BlueSwitchView) view.findViewById(R.id.sv_enable_face_auth)).setVisibility(8);
        } else if (i == 2) {
            View view2 = this.itemView;
            ((LinearLayout) view2.findViewById(R.id.btn_activate)).setVisibility(8);
            ((BlueSwitchView) view2.findViewById(R.id.sv_enable_face_auth)).setVisibility(0);
        } else {
            View view3 = this.itemView;
            ((LinearLayout) view3.findViewById(R.id.btn_activate)).setVisibility(0);
            ((BlueSwitchView) view3.findViewById(R.id.sv_enable_face_auth)).setVisibility(8);
            if (enrolmentState == EnrolmentState.FETCHING) {
                MyBillsEntityDataFactory();
            }
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, ProfileMenuFaceAuthViewHolder profileMenuFaceAuthViewHolder) {
        Intrinsics.checkNotNullParameter(profileMenuFaceAuthViewHolder, "");
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(profileMenuFaceAuthViewHolder.getAdapterPosition());
        }
    }

    private final void MyBillsEntityDataFactory() {
        SkeletonScreen skeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((LinearLayout) this.itemView.findViewById(R.id.btn_activate));
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_subtitle_me_page_skeleton;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        this.BuiltInFictitiousFunctionClassFactory = viewSkeletonScreen;
    }
}

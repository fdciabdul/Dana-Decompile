package id.dana.promoquest.views;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.LogoProgressView;

/* loaded from: classes9.dex */
public class QuestView_ViewBinding implements Unbinder {
    private QuestView BuiltInFictitiousFunctionClassFactory;

    public QuestView_ViewBinding(QuestView questView, View view) {
        this.BuiltInFictitiousFunctionClassFactory = questView;
        questView.btnQuestAction = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_quest_action, "field 'btnQuestAction'", Button.class);
        questView.viewTrackLine = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.view_track_line, "field 'viewTrackLine'");
        questView.viewQuestSeparator = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.view_quest_separator, "field 'viewQuestSeparator'");
        questView.ivQuestIconState = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_quest_status, "field 'ivQuestIconState'", ImageView.class);
        questView.lpvLoading = (LogoProgressView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.lpv_quest_loading, "field 'lpvLoading'", LogoProgressView.class);
        questView.questDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_quest_description, "field 'questDescription'", TextView.class);
        questView.questTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_quest_title, "field 'questTitle'", TextView.class);
        questView.vgQuestViewRoot = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.vg_quest_view_root, "field 'vgQuestViewRoot'", ConstraintLayout.class);
        questView.viewAction = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.vg_quest_action, "field 'viewAction'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        QuestView questView = this.BuiltInFictitiousFunctionClassFactory;
        if (questView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        questView.btnQuestAction = null;
        questView.viewTrackLine = null;
        questView.viewQuestSeparator = null;
        questView.ivQuestIconState = null;
        questView.lpvLoading = null;
        questView.questDescription = null;
        questView.questTitle = null;
        questView.vgQuestViewRoot = null;
        questView.viewAction = null;
    }
}

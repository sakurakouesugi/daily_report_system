package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import actions.views.FavoriteView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.MessageConst;
import services.FavoriteService;

/**
 * いいね処理に関するFavoriteクラス
 * @author
 *
 */

public class FavoriteAction extends ActionBase {
    private FavoriteService service;

    /**
     * いいね！する
     * @throws ServletException
     * @throws IOException
     */

    public void favorite() throws ServletException, IOException {

        EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);
        int rep_id = Integer.parseInt((getRequestParam(AttributeConst.REP_ID)));
        FavoriteView fv = new FavoriteView(
                ev,
                rep_id);
        //いいねテーブルへの追加
        List<String> addedToFavorite = service.create(fv);
        if (addedToFavorite != null) {
            favdel();
        }

        //セッションにフラッシュメッセージを設定
        putSessionScope(AttributeConst.FLUSH, MessageConst.I_ADDEDFAVORITE.getMessage());

        forward(ForwardConst.FW_REP_SHOW);
    }

    /**
     * いいね！を解除
     * @throws ServletException
     * @throws IOException
     */
    public void favdel() throws ServletException, IOException {
        //TODO 解除　見直し
        service.favdel(toNumber(getRequestParam(AttributeConst.EMP_ID)));
        redirect(ForwardConst.ACT_EMP, ForwardConst.CMD_SHOW);
    }

    @Override
    public void process() throws ServletException, IOException {

        service = new FavoriteService();

        //メソッドを実行
        invoke();

        service.close();
    }
}

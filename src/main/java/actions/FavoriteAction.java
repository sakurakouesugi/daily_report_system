package actions;
import java.io.IOException;

import javax.servlet.ServletException;

import actions.views.ReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.MessageConst;
import services.FavoriteService;
/**
 * いいね処理に関するFavoriteクラス
 * @author
 *
 */

public class FavoriteAction extends ActionBase{
    private FavoriteService service;
    /**
     * いいね！する
     * @throws ServletException
     * @throws IOException
     */

    public void fav()throws ServletException,IOException{



        String employee = getRequestParam(AttributeConst.LOGIN_EMP);
        String rep_id = getRequestParam(AttributeConst. FAV_REPID);
        Boolean addedToFavorite = service.favoriteStamp(employee, rep_id);

        if (addedToFavorite)
            //セッションにログイン完了のフラッシュメッセージを設定
            putSessionScope(AttributeConst.FLUSH, MessageConst. I_ADDEDFAVORITE.getMessage());

       }
    public void show() throws ServletException, IOException {
        //idを条件に日報データを取得する
        ReportView rv = service.findOne(toNumber(getRequestParam(AttributeConst.REP_ID)));
   if (rv==null) {
       //該当の日報データが存在しない場合はエラー画面を表示
       forward(ForwardConst.FW_ERR_UNKNOWN);

   }else {
       putRequestScope(AttributeConst.REPORT,rv);//取得した日報データ
       //詳細画面を表示
       forward(ForwardConst.FW_REP_SHOW);}}




    /**
     * いいね！を解除
     * @throws ServletException
     * @throws IOException
     */
 public void favdel()throws ServletException,IOException{
     //TODO 解除　見直し
        // service.favdel(toNumber(getRequestParam(AttributeConst.EMP_ID)))
 }
    @Override
    public void process() throws ServletException, IOException {

        service= new FavoriteService();

        //メソッドを実行
        invoke();

        service.close();
    }
}

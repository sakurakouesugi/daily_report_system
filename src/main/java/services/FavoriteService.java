package services;

import java.util.List;

import javax.persistence.NoResultException;

import actions.views.FavoriteConverter;
import actions.views.FavoriteView;
import actions.views.ReportConverter;
import actions.views.ReportView;
import constants.JpaConst;
import models.Favorite;
import models.Report;




public class FavoriteService extends ServiceBase {




           //TODO　見直し  いいね！登録処理

public List<String>create(FavoriteView fv) {

   createInternal(fv);
    return null ;
    }




   /**
    * @param employee 社員ID
    * @param rep_id 日報ID
    * @return 取得データのインスタンス 取得できない場合null
    */
   public FavoriteView findIt(String employee, String rep_id) {
       Favorite  f = null;
       try {


           //社員IDと日報IDをもとに検索
          f=em.createNamedQuery(JpaConst.Q_FAV_GET_BY_EMPLOYEE_AND_REP_ID, Favorite.class)
                   .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, employee)
                   .setParameter(JpaConst.JPQL_PARM_REP_ID, rep_id)
                   .getSingleResult();


       } catch (NoResultException ex) {
       }

       return FavoriteConverter.toView(f);

   }

    /**
     * 社員番号と日報IDを条件に検索し、データが取得できるかどうかで認証結果を返却する
     * @param employee 社員ID
     * @param rep_id 日報のID
     *
     * @return 認証結果を返却す(成功:true 失敗:false)
     */
    public Boolean favoriteStamp(String employee, String rep_id) {

        boolean addedToFavorite = false;
        if (employee != null && !employee.equals("") && rep_id != null && !rep_id.equals("")) {
            FavoriteView fv = findIt(employee,rep_id);

            if (fv != null && fv.getRep_id() != null) {

                //データが取得できた場合、認証成功
                addedToFavorite = true;
            }
        }

        //認証結果を返却する
        return addedToFavorite;
    }
    public ReportView findOne(int id) {
        return ReportConverter.toView(findOneInternal(id));

    }

    private Report findOneInternal(int id) {
        return em.find(Report.class, id);
    }
    /**
     * FAVテーブルへの登録
     * @param rv
     */
    private void createInternal(FavoriteView fv) {

        em.getTransaction().begin();
        em.persist(FavoriteConverter.toModel(fv));
        em.getTransaction().commit();
    }
/**
 * いいね！の解除
 */
    //TODO 解除見直し
    public void favdel(Integer employee) {


    }
}
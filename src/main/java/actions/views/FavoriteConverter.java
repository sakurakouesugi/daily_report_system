package actions.views;

import models.Favorite;

public class FavoriteConverter {
    /**
     * FavoriteのインスタンスからDTOモデルのインスタンスを作成する
     * @param fv Favoriteのインスタンス
     * @return
     * @return
     */

    public static Favorite toModel(FavoriteView fv) {

        return new Favorite(
                EmployeeConverter.toModel(fv.getEmployee()),
                fv.getRep_id());
    }

    public static FavoriteView toView(Favorite f) {
        if (f == null) {
            return null;
        }
        return new FavoriteView(
                EmployeeConverter.toView(f.getEmployee()),
                f.getRep_id());
    }

}

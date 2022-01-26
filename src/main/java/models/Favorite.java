package models;



import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




/**
 * いいねデータのDTOモデル
 *
 */
@Table(name = JpaConst.TABLE_FAV)

    @NamedQueries({
        @NamedQuery(
                name=JpaConst.Q_EMP_GET_ALL,
                query= JpaConst.Q_EMP_GET_ALL_DEF)

})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Favorite {


    /**
     * 従業員ID
     */
    @ManyToOne
    @JoinColumn(name = JpaConst.REP_COL_EMP, nullable = false)
    private Employee employee;
    /**
     * 日報ID
     */

    @ManyToOne
    @JoinColumn(name = JpaConst.FAV_COL_REPID, nullable = false)

    private  Integer rep_id;


}

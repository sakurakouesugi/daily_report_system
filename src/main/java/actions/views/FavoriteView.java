package actions.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FavoriteView {

    /**
     * 従業員id
     */
    private  EmployeeView employee;

    /**
     * 日報ID
     */
    private Integer rep_id;


}

package actions.views;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 従業員情報についての画面の入力値・出力地を扱うviewモデル
 * @author cocb1
 *
 */
@Getter //全てのクラスフィールドについてgetterを自動生成する(lombok)
@Setter //全てのクラスフィールドについてSetterを自動生成尻(lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(lombok)
@AllArgsConstructor //全てのクラスフィールドを引数に持つ引数ありコンストラクタを自動生成する(Lombok)
public class EmployeeView {

    /**
     * id
     */
    private Integer id;

    /**
     * 社員番号
     */

    private String code;

    /**
     * 氏名
     */

    private String name;

    /**
     * パスワード
     */

    private String password;

    /**
     * 管理者権限があるかどうか
     *
     */

    private Integer adminFlag;

    /**
     * 登録日時
     *
     */
    private LocalDateTime createdAt;

    /**
     * 更新日時
     */
     private LocalDateTime updatedAt;

     /**
      * 削除された従業員かどうか（現役：0，削除済み：1）
      *
      */
     private Integer deleteFlag;
}

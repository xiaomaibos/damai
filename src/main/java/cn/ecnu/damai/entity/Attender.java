package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Kyrie Lee
 * @date 2021/5/12 22:41
 */
@Data
@Entity
@Table(name = "attender")
public class Attender {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    private String name;
    @Column(name = "identity_type")
    private String identityType;
    @Column(name = "identity_num")
    private String identityNum;
    @Column(name = "user_id")
    private Integer userId;

    @Transient
    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}

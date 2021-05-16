package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:48
 */
@Data
@Entity
@Table(name = "show")
public class Show {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer showId;
    private String name;
    private Date time;
    @Column(name = "program_id")
    private Integer programId;

    @Transient
    @ManyToOne(targetEntity = Program.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id",referencedColumnName = "id")
    private Program program;
    @Transient
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private Set<Order> orders;
    @Transient
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private Set<Level> levels;
}

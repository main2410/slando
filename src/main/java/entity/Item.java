package entity;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Generated

@Entity
@Table(name = "slando_item")
public class Item {
    @Id
    private final String id = UUID.randomUUID().toString();
    private String cat;
    private String name;
    private String about;
    private String pic;
    private String owner;
    private String phone;
    private String email;
    private String city;
    private Integer price;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "is_vip")
    private Boolean isVip;
}

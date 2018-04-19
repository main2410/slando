package entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
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
@Table(name = "slando_user")
public class User {
    @Id
    private final String id = UUID.randomUUID().toString();
    private String login;
    private String pass;
    private String phone;
    private String email;
    private String city;
    @Column(name = "create_date")
    private Timestamp createDate;

}
package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {
    // DB가 자동으로 id값 생성하는것 = IDENTITY
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 시스템 ID

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
